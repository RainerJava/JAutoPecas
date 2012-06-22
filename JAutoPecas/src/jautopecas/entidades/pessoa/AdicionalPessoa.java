package jautopecas.entidades.pessoa;

import java.io.Serializable;
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
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
    @Column(name = "INSCRICAO_ESTADUAL")
    private String inscricaoEstadual;
    private String rg;
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
}
