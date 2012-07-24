package jautopecas.entidades.pessoa;

import jautopecas.dao.pessoa.ModeloPessoaDao;
import jautopecas.dao.pessoa.PessoaDao;
import jautopecas.dao.pessoa.TipoPessoaDao;
import jautopecas.dao.pessoa.endereco.*;
import jautopecas.dao.pessoa.telefone.TipoTelefoneDao;
import jautopecas.entidades.pessoa.endereco.Endereco;
import jautopecas.entidades.pessoa.endereco.EnderecoPessoa;
import jautopecas.entidades.pessoa.telefone.Telefone;
import jautopecas.entidades.pessoa.telefone.TelefonePessoa;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author JFFiorotto
 */
public class ImportacaoPessoa {

    public void leCsvCadastroFabricante() {
        StringBuilder sbErros = new StringBuilder();
//SELECT IIDFO AS ID_FABRICANTE,CNOME AS RAZAO_SOCIAL,CFANTASIA AS NOME_FANTASIA,CCGC AS CNPJ,CIEST AS INSC_ESTADUAL,
//'' AS TIPO_LOGRADOURO,CEND AS LOGRADOURO,CCOMPL AS COMPLEMENTO,'BRASIL' AS PAIS,CUF AS UF,CCIDADE AS CIDADE,CBAIRRO AS BAIRRO,CCEP AS CEP,CNUM AS NUMERO,
//CDDDTEL AS DDD_TELEFONE,CTEL AS TELEFONE
//FROM CDFORNECEDOR WHERE CTPC = 'F'
        try {
            BufferedReader in = new BufferedReader(new FileReader("C:/Fabricantes.csv"));
            String linha;
            while ((linha = in.readLine()) != null) {
                String conteudo[] = linha.split(";");
                if (conteudo[0].equals("ID_FABRICANTE")) {
                    continue;
                }
                Pessoa pessoa = new Pessoa();
                AdicionalPessoa adicionalPessoa = new AdicionalPessoa();
                pessoa.setAdicionalPessoa(adicionalPessoa);

                pessoa.setIdPessoa(Integer.valueOf(conteudo[0]));
                pessoa.setNome(conteudo[1]);
                pessoa.setApelido(conteudo[2]);
                pessoa.setDocumento(conteudo[3]);
                adicionalPessoa.setPessoa(pessoa);
                adicionalPessoa.setInscricaoEstadual(conteudo[4]);
                pessoa.setModeloPessoa(new ModeloPessoaDao().load("FA"));
                pessoa.setFisicaJuridica(Pessoa.TIPO_PESSOA_JURIDICA);
                pessoa.setTipoPessoa(new TipoPessoaDao().load("FA"));
                /*
                 * Endereço
                 */
                List<EnderecoPessoa> listaEnderecoPessoa = new ArrayList<>();
                EnderecoPessoa enderecoPessoa = new EnderecoPessoa();
                Endereco endereco = new Endereco();
                try {
                    endereco.setTipoLogradouro(new TipoLogradouroDao().loadByColun("nome", conteudo[5]));
                } catch (NoResultException ex) {
                    sbErros.append("Tipo de logradouro não encontrado para o fornecedor ").append(pessoa.getNome());
                }

                endereco.setLogradouro(conteudo[6]);
                //endereco.setComplemento(conteudo[7]);
                //endereco.setPais(conteudo[8]);
                try {
                    endereco.setUf(new EstadoDao().load(conteudo[9]));
                } catch (NoResultException ex) {
                    sbErros.append("Estado não encontrado para o fornecedor ").append(pessoa.getNome());
                }
                try {
                    endereco.setCidade(new CidadeDao().getCidadePorNome(conteudo[10],endereco.getUf().getUf()));
                } catch (Exception ex) {
                    if(ex instanceof NoResultException){
                        sbErros.append("Cidade não encontrado para o fornecedor ").append(pessoa.getNome());
                    }
                }
                try {
                    endereco.setBairro(new BairroDao().loadByColun("nome", conteudo[11]));
                } catch (NoResultException ex) {
                    sbErros.append("Bairro não encontrado para o fornecedor ").append(pessoa.getNome());
                }

                endereco.setCep(conteudo[12]);
                endereco.setNumero(conteudo[13]);
                endereco.setTipoEndereco(new TipoEnderecoDao().loadByColun("nome", "COMERCIAL"));
                enderecoPessoa.setEndereco(endereco);
                enderecoPessoa.setPessoa(pessoa);
                if (endereco.getUf() != null && endereco.getCidade() != null && endereco.getBairro() != null) {
                    listaEnderecoPessoa.add(enderecoPessoa);
                }
                pessoa.setEnderecoPessoa(listaEnderecoPessoa);
                /*
                 * Telefone
                 */
                List<TelefonePessoa> listaTelefonePessoa = new ArrayList<>();
                TelefonePessoa telefonePessoa = new TelefonePessoa();
                Telefone telefone = new Telefone();
                String dddTelefone = conteudo[14];
                String numTelefone = conteudo[15];
                if (!dddTelefone.equals("0") && !numTelefone.equals("0")) {
                    String telefoneFormatado = "(" + dddTelefone + ")" + numTelefone.substring(0, 4) + "-" + numTelefone.substring(4);
                    telefone.setTelefone(telefoneFormatado);
                    telefone.setTipoTelefone(new TipoTelefoneDao().loadByColun("nome", "COMERCIAL"));
                    telefonePessoa.setTelefone(telefone);
                    telefonePessoa.setPessoa(pessoa);
                    listaTelefonePessoa.add(telefonePessoa);
                }

                pessoa.setTelefonePessoa(listaTelefonePessoa);

                new PessoaDao().salvar(pessoa);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
