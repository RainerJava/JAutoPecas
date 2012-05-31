package jautopecas.entidades.pessoa.endereco;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "CAD_CIDADE")
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_CIDADE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCidade;
    private String nome;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "UF", referencedColumnName = "UF")
    private Estado uf;
    private String ibge;

    /*
     * Getter's and Setter's
     */
    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getUf() {
        return uf;
    }

    public void setUf(Estado uf) {
        this.uf = uf;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }
}
