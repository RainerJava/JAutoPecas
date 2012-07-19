package jautopecas.entidades.produto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author JFFiorotto
 */
public class ProdutoVo implements Serializable {

    private Produto produto;
    private BigDecimal estoque;
    private BigDecimal preco;

    public BigDecimal getEstoque() {
        return estoque;
    }

    public void setEstoque(BigDecimal estoque) {
        this.estoque = estoque;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
