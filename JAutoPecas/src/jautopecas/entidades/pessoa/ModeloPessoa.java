package jautopecas.entidades.pessoa;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_MODELO_PESSOA")
public class ModeloPessoa implements Serializable {

    @Id
    @Column(name = "ID_MODELO_PESSOA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idModeloPessoa;
    private String sigla;
    private String descricao;
    /*
     * Getter's and Setter's
     */

    public Integer getIdModeloPessoa() {
        return idModeloPessoa;
    }

    public void setIdModeloPessoa(Integer idModeloPessoa) {
        this.idModeloPessoa = idModeloPessoa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
