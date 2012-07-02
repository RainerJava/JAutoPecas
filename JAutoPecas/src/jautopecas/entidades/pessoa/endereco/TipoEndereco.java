package jautopecas.entidades.pessoa.endereco;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "CAD_TIPO_ENDERECO")
public class TipoEndereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_TIPO_ENDERECO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoEndereco;
    private String nome;

    /*
     * Getter's and Setter's
     */
    public Integer getIdTipoEndereco() {
        return idTipoEndereco;
    }

    public void setIdTipoEndereco(Integer idTipoEndereco) {
        this.idTipoEndereco = idTipoEndereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoEndereco other = (TipoEndereco) obj;
        if (!Objects.equals(this.idTipoEndereco, other.idTipoEndereco)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.idTipoEndereco);
        hash = 53 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public String toString() {
        return idTipoEndereco + "-" + nome;
    }
}
