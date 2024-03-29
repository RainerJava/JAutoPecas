package jautopecas.entidades.produto;

import jautopecas.entidades.pessoa.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_PRODUTO_FORNECEDOR")
public class ProdutoFornecedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO_FORNECEDOR")
    private Integer idProdutoFornecedor;
    @OneToOne
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;
    @OneToOne
    @JoinColumn(name = "ID_FORNECEDOR")
    private Pessoa fornecedor;
    @Column(name = "NUMERO_FORNECEDOR")
    private String numeroFornecedor;
    @OneToMany(mappedBy = "produtoFornecedor", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoFornecedorCusto> produtoFornecedorCusto;

    public List<ProdutoFornecedorCusto> getProdutoFornecedorCusto() {
        return produtoFornecedorCusto;
    }

    public void setProdutoFornecedorCusto(List<ProdutoFornecedorCusto> produtoFornecedorCusto) {
        this.produtoFornecedorCusto = produtoFornecedorCusto;
    }

    public Pessoa getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Pessoa fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Integer getIdProdutoFornecedor() {
        return idProdutoFornecedor;
    }

    public void setIdProdutoFornecedor(Integer idProdutoFornecedor) {
        this.idProdutoFornecedor = idProdutoFornecedor;
    }

    public String getNumeroFornecedor() {
        return numeroFornecedor;
    }

    public void setNumeroFornecedor(String numeroFornecedor) {
        this.numeroFornecedor = numeroFornecedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
