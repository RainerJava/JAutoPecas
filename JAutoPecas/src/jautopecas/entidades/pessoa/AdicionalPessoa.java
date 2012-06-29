package jautopecas.entidades.pessoa;

import jautopecas.entidades.pessoa.endereco.Cidade;
import jautopecas.entidades.pessoa.endereco.Pais;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_ADICIONAL_PESSOA")
public class AdicionalPessoa implements Serializable {

    @Id
    @Column(name = "ID_ADICIONAL_PESSOA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdicionalPessoa;
    @OneToOne
    @JoinColumn(name = "ID_PESSOA")
    private Pessoa pessoa;
    @Column(name = "INSCRICAO_ESTADUAL")
    private String inscricaoEstadual;
    private String rg;
    private String sexo;
    @Column(name = "RACA_COR")
    private String racaCor;
    @Column(name = "DATA_NASCIMENTO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    @OneToOne
    @JoinColumn(name = "ID_CIDADE_NATURALIDADE")
    private Cidade naturalidade;
    @Column(name = "NOME_PAI")
    private String nomePai;
    @Column(name = "NOME_MAE")
    private String nomeMae;
    @Column(name = "TIPO_LINHA_FORNECIMENTO")
    private String tipoLinhaFornecimento;
    /*
     * Getter's and Setter's
     */

    public Integer getIdAdicionalPessoa() {
        return idAdicionalPessoa;
    }

    public void setIdAdicionalPessoa(Integer idAdicionalPessoa) {
        this.idAdicionalPessoa = idAdicionalPessoa;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Cidade getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(Cidade naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getRacaCor() {
        return racaCor;
    }

    public void setRacaCor(String racaCor) {
        this.racaCor = racaCor;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoLinhaFornecimento() {
        return tipoLinhaFornecimento;
    }

    public void setTipoLinhaFornecimento(String tipoLinhaFornecimento) {
        this.tipoLinhaFornecimento = tipoLinhaFornecimento;
    }
}
