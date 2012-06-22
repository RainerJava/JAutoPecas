package jautopecas.entidades.pessoa.endereco;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "CAD_ENDERECO")
public class Endereco implements Serializable {

    public Endereco() {
        super();
    }
    @Id
    @Column(name = "ID_ENDERECO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEndereco;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_TIPO_LOGRADOURO", referencedColumnName = "ID_TIPO_LOGRADOURO")
    private TipoLogradouro tipoLogradouro;
    private String logradouro;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "UF", referencedColumnName = "UF")
    private Estado uf;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_CIDADE", referencedColumnName = "ID_CIDADE")
    private Cidade cidade;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_BAIRRO", referencedColumnName = "ID_BAIRRO")
    private Bairro bairro;
    private String cep;
    private String numero;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_TIPO_ENDERECO", referencedColumnName = "ID_TIPO_ENDERECO")
    private TipoEndereco tipoEndereco;
    /*
     * Getter's and Setter's
     */

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public Estado getUf() {
        return uf;
    }

    public void setUf(Estado uf) {
        this.uf = uf;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }
}
