package jautopecas.entidades.pessoa.endereco;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "CAD_PAIS")
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_PAIS")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPais;
    private String nome;

    /*
     * Getter's and Setter's
     */
    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
