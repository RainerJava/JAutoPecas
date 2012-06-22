package jautopecas.entidades.pessoa.telefone;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "CAD_TIPO_TELEFONE")
public class TipoTelefone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_TIPO_TELEFONE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoTelefone;
    private String nome;

    /*
     * Getter's and Setter's
     */
    public Integer getIdTipoTelefone() {
        return idTipoTelefone;
    }

    public void setIdTipoTelefone(Integer idTipoTelefone) {
        this.idTipoTelefone = idTipoTelefone;
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
        final TipoTelefone other = (TipoTelefone) obj;
        if (!Objects.equals(this.idTipoTelefone, other.idTipoTelefone)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idTipoTelefone);
        hash = 53 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public String toString() {
        return idTipoTelefone + " - " + nome;
    }
}
