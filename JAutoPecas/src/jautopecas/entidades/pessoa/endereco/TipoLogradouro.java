package jautopecas.entidades.pessoa.endereco;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "CAD_TIPO_LOGRADOURO")
public class TipoLogradouro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_TIPO_LOGRADOURO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoLogradouro;
    @Column(name = "NOME")
    private String nome;

    /*
     * Getter's and Setter's
     */
    public Integer getIdTipoLogradouro() {
        return idTipoLogradouro;
    }

    public void setIdTipoLogradouro(Integer idTipoLogradouro) {
        this.idTipoLogradouro = idTipoLogradouro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
