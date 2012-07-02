package jautopecas.entidades.pessoa.endereco;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "CAD_TIPO_ENDERECO")
public class TipoEndereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "TIPO_ENDERECO")
    private String tipoEndereco;
    private String descricao;

    /*
     * Getter's and Setter's
     */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
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
        if (!Objects.equals(this.tipoEndereco, other.tipoEndereco)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.tipoEndereco);
        hash = 89 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public String toString() {
        return tipoEndereco + "-" + descricao;
    }
}
