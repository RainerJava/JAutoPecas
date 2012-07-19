package jautopecas.entidades.produto;

import jautopecas.entidades.pessoa.Pessoa;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_ESTOQUE")
public class Estoque implements Serializable {

    @Id
    @Column(name = "ID_ESTOQUE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstoque;
    @OneToOne
    @JoinColumn(name = "ID_EMPRESA")
    private Pessoa empresa;
    @OneToOne
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;
    @Column(name = "ESTOQUE_ATUAL")
    private BigDecimal estoqueAtual;

    public Pessoa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Pessoa empresa) {
        this.empresa = empresa;
    }

    public Integer getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Integer idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(BigDecimal estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }
}
