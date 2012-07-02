package jautopecas.entidades.produto;

import jautopecas.components.anotacao.AnotacaoNomeColuna;
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
@Table(name = "CAD_TIPO_PRODUTO")
public class TipoProduto implements Serializable {

    @Id
    @Column(name = "TIPO_PRODUTO")
    @AnotacaoNomeColuna(nome = "Tipo Produto")
    private String tipoProduto;
    @AnotacaoNomeColuna(nome = "Nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoProduto other = (TipoProduto) obj;
        if (!Objects.equals(this.tipoProduto, other.tipoProduto)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.tipoProduto);
        hash = 61 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public String toString() {
        return tipoProduto + "-" + nome;
    }
}
