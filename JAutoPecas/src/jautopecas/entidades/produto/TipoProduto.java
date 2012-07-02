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
    @AnotacaoNomeColuna(nome = "Descrição")
    private String descricao;

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.tipoProduto);
        hash = 59 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public String toString() {
        return tipoProduto + "-" + descricao;
    }
}
