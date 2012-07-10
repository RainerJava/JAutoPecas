package jautopecas.entidades.pessoa.endereco;

import jautopecas.dao.pessoa.endereco.BairroDao;
import jautopecas.dao.pessoa.endereco.CidadeDao;
import jautopecas.dao.pessoa.endereco.EstadoDao;
import jautopecas.dao.pessoa.endereco.TipoLogradouroDao;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class CepService {
    
    public static Endereco getEndereco(String cep) throws Exception {
        Endereco endereco = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(Webservicecep.class);
            
            Unmarshaller u = jc.createUnmarshaller();
            URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
            Webservicecep wCep = (Webservicecep) u.unmarshal(url);
            
            if (wCep != null) {
                if (wCep.getResultado().equals("0")) {
                    throw new Exception(wCep.getResultado_txt());
                } else {
                    endereco = cepToEndereco(wCep);
                }
            } else {
                throw new Exception("Erro ao Buscar Endereço pelo CEP");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
        return endereco;
    }
    
    private static Endereco cepToEndereco(Webservicecep webServiceCep) {
        Endereco endereco = new Endereco();
        Bairro bairro;
        BairroDao bairroDao = new BairroDao();
        
        Cidade cidade;
        CidadeDao cidadeDao = new CidadeDao();
        
        Estado estado;
        EstadoDao estadoDao = new EstadoDao();
        
        TipoLogradouro tipoLogradouro;
        TipoLogradouroDao tipoLogradouroDao = new TipoLogradouroDao();
        
        bairro = bairroDao.getBairroPorNome(webServiceCep.getBairro());
        if (bairro == null) {
            bairro = new Bairro();
            bairro.setNome(webServiceCep.getBairro());
            bairroDao.salvar(bairro);
        }
        estado = estadoDao.getEstadoPorSigla(webServiceCep.getUf());
        if (estado == null) {
            estado = new Estado();
            estado.setUf(webServiceCep.getUf());
            estado.setNome(webServiceCep.getUf());
            estadoDao.salvar(estado);
        }
        
        cidade = cidadeDao.getCidadePorNome(webServiceCep.getCidade());
        if (cidade == null) {
            cidade = new Cidade();
            cidade.setNome(webServiceCep.getCidade());
            cidade.setUf(estado);
            cidadeDao.salvar(cidade);
        }
        
        tipoLogradouro = tipoLogradouroDao.getTipoLogradouroPorNome(webServiceCep.getTipo_logradouro());
        if (tipoLogradouro == null) {
            tipoLogradouro = new TipoLogradouro();
            tipoLogradouro.setNome(webServiceCep.getTipo_logradouro());
            tipoLogradouroDao.salvar(tipoLogradouro);
        }
        
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setUf(estado);
        endereco.setLogradouro(webServiceCep.getLogradouro());
        endereco.setTipoLogradouro(tipoLogradouro);
        
        return endereco;
    }
}
