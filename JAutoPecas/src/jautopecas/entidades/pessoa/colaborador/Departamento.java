package jautopecas.entidades.pessoa.colaborador;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_DEPARTAMENTO")
public class Departamento implements Serializable {

    @Id
    @Column(name = "ID_DEPARTAMENTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepartamento;
    private String nome;
    /*
     * Getter's and Setter's
     */

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
