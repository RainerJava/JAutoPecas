package jautopecas.entidades.pessoa.colaborador;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_FUNCAO")
public class Funcao implements Serializable {

    @Id
    @Column(name = "ID_FUNCAO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFuncao;
    private String nome;
    @OneToOne
    @JoinColumn(name = "ID_DEPARTAMENTO")
    private Departamento departamento;
    /*
     * Getter's and Setter's
     */

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Integer getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(Integer idFuncao) {
        this.idFuncao = idFuncao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
