package jautopecas.entidades.pessoa.endereco;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "CAD_BAIRRO")
public class Bairro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_BAIRRO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBairro;
    private String nome;

    /*
     * Getter's and Setter's
     */
    public Integer getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(Integer idBairro) {
        this.idBairro = idBairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
