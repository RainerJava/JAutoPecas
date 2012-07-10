package jautopecas.entidades.substituicaoTributaria;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_CST")
public class Cst implements Serializable {

    @Id
    @Column(name = "CST")
    private String cst;
    private String nome;
    @Column(name = "TIPO_CST")
    private String tipoCst;

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoCst() {
        return tipoCst;
    }

    public void setTipoCst(String tipoCst) {
        this.tipoCst = tipoCst;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cst other = (Cst) obj;
        if (!Objects.equals(this.cst, other.cst)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.tipoCst, other.tipoCst)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.cst);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.tipoCst);
        return hash;
    }

    @Override
    public String toString() {
        return cst + "-" + nome;
    }
}
