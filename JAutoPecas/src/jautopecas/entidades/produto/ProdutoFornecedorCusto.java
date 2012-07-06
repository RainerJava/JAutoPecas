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
@Table(name = "CAD_PRODUTO_FORNECEDOR_CUSTO")
public class ProdutoFornecedorCusto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO_FORNECEDOR_CUSTO")
    private Integer idProdutoFornecedorCusto;
    @OneToOne
    @JoinColumn(name = "ID_PRODUTO_FORNECEDOR")
    private ProdutoFornecedor produtoFornecedor;
    @OneToOne
    @JoinColumn(name = "ID_EMPRESA")
    private Pessoa empresa;
    @Column(name = "CUSTO_UNITARIO")
    private BigDecimal custoUnitario;
    @Column(name = "PORCENT_IPI")
    private BigDecimal porcentIpi;
    @Column(name = "PORCENT_ICMS")
    private BigDecimal porcentIcms;
    private String cst;
    @Column(name = "PORCENT_IMPOSTO_IMPORTACAO")
    private BigDecimal porcentImpostoImportacao;
    @Column(name = "CUSTO_REPOSICAO")
    private BigDecimal custoReposicao;

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public Pessoa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Pessoa empresa) {
        this.empresa = empresa;
    }

    public BigDecimal getCustoReposicao() {
        return custoReposicao;
    }

    public void setCustoReposicao(BigDecimal custoReposicao) {
        this.custoReposicao = custoReposicao;
    }

    public BigDecimal getCustoUnitario() {
        return custoUnitario;
    }

    public void setCustoUnitario(BigDecimal custoUnitario) {
        this.custoUnitario = custoUnitario;
    }

    public Integer getIdProdutoFornecedorCusto() {
        return idProdutoFornecedorCusto;
    }

    public void setIdProdutoFornecedorCusto(Integer idProdutoFornecedorCusto) {
        this.idProdutoFornecedorCusto = idProdutoFornecedorCusto;
    }

    public BigDecimal getPorcentIcms() {
        return porcentIcms;
    }

    public void setPorcentIcms(BigDecimal porcentIcms) {
        this.porcentIcms = porcentIcms;
    }

    public BigDecimal getPorcentImpostoImportacao() {
        return porcentImpostoImportacao;
    }

    public void setPorcentImpostoImportacao(BigDecimal porcentImpostoImportacao) {
        this.porcentImpostoImportacao = porcentImpostoImportacao;
    }

    public BigDecimal getPorcentIpi() {
        return porcentIpi;
    }

    public void setPorcentIpi(BigDecimal porcentIpi) {
        this.porcentIpi = porcentIpi;
    }

    public ProdutoFornecedor getProdutoFornecedor() {
        return produtoFornecedor;
    }

    public void setProdutoFornecedor(ProdutoFornecedor produtoFornecedor) {
        this.produtoFornecedor = produtoFornecedor;
    }
}
