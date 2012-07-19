package jautopecas.entidades.produto;

import jautopecas.dao.substituicaoTributaria.CstDao;
import jautopecas.entidades.pessoa.Pessoa;
import jautopecas.entidades.substituicaoTributaria.Cst;
import jautopecas.entidades.substituicaoTributaria.SubstituicaoTributariaEntrada;
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
    @Column(name = "PERCENT_IPI")
    private BigDecimal percentIpi;
    @Column(name = "PERCENT_ICMS")
    private BigDecimal percentIcms;
    @OneToOne
    @JoinColumn(name = "CST_ICMS")
    private Cst cstIcms;
    @Column(name = "PERCENT_IMPOSTO_IMPORTACAO")
    private BigDecimal percentImpostoImportacao;
    @Column(name = "CUSTO_REPOSICAO")
    private BigDecimal custoReposicao;
    @Column(name = "CUSTO_BRUTO")
    private BigDecimal custoBruto;
    @Column(name = "CUSTO_NET")
    private BigDecimal custoNet;
    @Column(name = "CUSTO_NET_ST")
    private BigDecimal custocustoNetSt;

    public Cst getCstIcms() {
        return cstIcms;
    }

    public void setCstIcms(Cst cstIcms) {
        this.cstIcms = cstIcms;
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

    public BigDecimal getCustoBruto() {
        return custoBruto;
    }

    public void setCustoBruto(BigDecimal custoBruto) {
        this.custoBruto = custoBruto;
    }

    public BigDecimal getCustoNet() {
        return custoNet;
    }

    public void setCustoNet(BigDecimal custoNet) {
        this.custoNet = custoNet;
    }

    public BigDecimal getCustocustoNetSt() {
        return custocustoNetSt;
    }

    public void setCustocustoNetSt(BigDecimal custocustoNetSt) {
        this.custocustoNetSt = custocustoNetSt;
    }

    public BigDecimal getPercentIcms() {
        return percentIcms;
    }

    public void setPercentIcms(BigDecimal percentIcms) {
        this.percentIcms = percentIcms;
    }

    public BigDecimal getPercentImpostoImportacao() {
        return percentImpostoImportacao;
    }

    public void setPercentImpostoImportacao(BigDecimal percentImpostoImportacao) {
        this.percentImpostoImportacao = percentImpostoImportacao;
    }

    public BigDecimal getPercentIpi() {
        return percentIpi;
    }

    public void setPercentIpi(BigDecimal percentIpi) {
        this.percentIpi = percentIpi;
    }

    public ProdutoFornecedor getProdutoFornecedor() {
        return produtoFornecedor;
    }

    public void setProdutoFornecedor(ProdutoFornecedor produtoFornecedor) {
        this.produtoFornecedor = produtoFornecedor;
    }

    public void calculaCustoNet() throws Exception {
        try {
            BigDecimal custoUnitario = getCustoUnitario();
            BigDecimal fatorEmbalagemCompra = getProdutoFornecedor().getProduto().getFatorEmbalagemCompra();
            custoUnitario = custoUnitario.divide(fatorEmbalagemCompra);
            BigDecimal percentIpi = getPercentIpi().divide(new BigDecimal(100));
            BigDecimal percentPis = new BigDecimal(9.25);
            BigDecimal percentPisCofins = BigDecimal.ZERO;
            BigDecimal valorIcmsTributado = BigDecimal.ZERO;
            BigDecimal valorPis = BigDecimal.ZERO;
            BigDecimal DIpiPis = BigDecimal.ZERO;
            BigDecimal custoUnitarioCalculado = custoUnitario;
            BigDecimal custoNetCalculado = BigDecimal.ZERO;
            BigDecimal percentIcms = getPercentIcms().divide(new BigDecimal(100));
            /*
             * Descontos sobre Descontos
             */
            /**
             * **Implementar Desconto Sobre Desconto***
             */
            BigDecimal valorIcms = custoUnitarioCalculado.multiply(percentIcms);
            BigDecimal valorIpi = custoUnitarioCalculado.multiply(percentIpi);
            // BigDecimal Pdesc = 1 - (this.getDouble(Fields.FAR_FDESC) / 100);
            // custoUnitarioCalculado = getJFLClient().round(custoUnitarioCalculado * Pdesc, 2);
            BigDecimal baseSt = BigDecimal.ZERO;
            //custoUnitario = getJFLClient().round(custoUnitario * Pdesc, 2);
            if (percentPis != null && percentPis.doubleValue() > 0) {
                percentPisCofins = getProdutoFornecedor().getProduto().getClassificacaoFiscal().getPercentPis().add(
                        getProdutoFornecedor().getProduto().getClassificacaoFiscal().getPercentCofins());
            }
            valorPis = (custoUnitarioCalculado.multiply(percentPisCofins)).divide(new BigDecimal(100));
            baseSt = custoUnitarioCalculado;
            custoUnitarioCalculado = custoUnitarioCalculado.subtract(valorPis).subtract(DIpiPis).subtract((valorIcms.divide(custoUnitario)).multiply(custoUnitarioCalculado));
            custoNetCalculado = custoUnitarioCalculado;
            try {
                SubstituicaoTributariaEntrada substTribEntrada = new SubstituicaoTributariaEntrada();
                substTribEntrada.calculaSubstituicaoTributaria(this, baseSt, valorIpi, getPercentIcms());
                valorIcmsTributado = substTribEntrada.getIcmsSubstituicao();
            } catch (Exception ex) {
                if (ex instanceof NoResultException) {
                    valorIcmsTributado = BigDecimal.ZERO;
                } else {
                    throw new Exception(ex);
                }
            }

            BigDecimal custoUnitarioCalculadoBruto = custoUnitario.add(valorIpi).add(valorIcmsTributado);
            BigDecimal custoNetSt = custoNetCalculado;
            if (valorIcmsTributado.doubleValue() > 0) {
                setCstIcms(new CstDao().load(getCstIcms().getCst().substring(0, 1) + "10"));
                custoNetSt = custoUnitarioCalculado.add(valorIcms).add(valorIcmsTributado);
            }
            setCustoNet(custoNetCalculado);
            setCustoBruto(custoUnitarioCalculadoBruto);
            setCustocustoNetSt(custoNetSt);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Erro ao calcular custo Net");
        }
    }
}
