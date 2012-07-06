package jautopecas.entidades.substituicaoTributaria;

import jautopecas.dao.substituicaoTributaria.SubstituicaoTributariaEntradaDao;
import jautopecas.entidades.pessoa.endereco.Estado;
import jautopecas.entidades.produto.ClassificacaoFiscal;
import jautopecas.entidades.produto.ProdutoFornecedorCusto;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_SUBSTITUICAO_TRIBUTARIA_ENTRADA")
public class SubstituicaoTributariaEntrada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SUBSTITUICAO_TRIBUTARIA_ENTRADA")
    private Integer idSubstituicaoTributariaEntrada;
    @OneToOne
    @JoinColumn(name = "UF")
    private Estado uf;
    @Column(name = "TIPO_PESSOA")
    private String tipoPessoa;
    @Column(name = "PERCENT_ICMS")
    private BigDecimal percentIcms;
    private BigDecimal margem;
    private String descricao;
    @Column(name = "PERCENT_ICMS_INTERNO")
    private BigDecimal percentIcmsInterno;
    @Column(name = "CST_ICMS")
    private String cstIcms;
    @OneToOne
    @JoinColumn(name = "CLASSIFICACAO_FISCAL")
    private ClassificacaoFiscal classificacaoFiscal;
    @OneToOne
    @JoinColumn(name = "UF_EMISSOR")
    private Estado ufEmissor;
    @Transient
    private BigDecimal baseSubstituicao;
    @Transient
    private BigDecimal icmsSubstituicao;

    public void calculaSubstituicaoTributaria(ProdutoFornecedorCusto produtoFornecedorCusto, double custoUnitario, double valorIpi,
            double percentIcms) throws Exception {
        try {
            double xBase = 0;
            double xIpi = 0;
            double wBaseT = 0;
            double wIcmT = 0;
            double xIcm = 0;
            double xIcmT = 0;
            double xIcmBasePropria = 0;
            Estado cUF = produtoFornecedorCusto.getEmpresa().getEnderecoPessoa().get(0).getEndereco().getUf();
            Estado cUFE = produtoFornecedorCusto.getProdutoFornecedor().getFornecedor().getEnderecoPessoa().get(0).getEndereco().getUf();
            String xClass = produtoFornecedorCusto.getProdutoFornecedor().getProduto().getClassificacaoFiscal().getClassificacaoFiscal();
            String xCst = produtoFornecedorCusto.getProdutoFornecedor().getProduto().getCst().substring(0, 3);
            xIpi = valorIpi;
            xBase = custoUnitario;
            double xBaseCalculo = xBase;
            if (produtoFornecedorCusto.getProdutoFornecedor().getFornecedor().getTipoPessoa().getTipoPessoa().equals("C")
                    || produtoFornecedorCusto.getProdutoFornecedor().getFornecedor().getTipoPessoa().getTipoPessoa().equals("N")) {
                xBaseCalculo = xBase + xIpi;
            }
            xIcm = ((xBaseCalculo * percentIcms) / 100);
            SubstituicaoTributariaEntrada substTribEntrada = new SubstituicaoTributariaEntradaDao().getSubstituicaoTributariaEntrada(xClass, cUFE.getUf(), produtoFornecedorCusto.getProdutoFornecedor().getFornecedor().getTipoPessoa().getTipoPessoa(), cUF.getUf(), xCst);
            double xPicm = substTribEntrada.getPercentIcms().doubleValue();
            xIcm = xBaseCalculo * xPicm / 100;
            double wMargem = substTribEntrada.getMargem().doubleValue() / 100;
            double wBaseCalculoStt = ((custoUnitario + xIpi) * (1 + wMargem));
            double xCalculoIcmstt = ((wBaseCalculoStt * substTribEntrada.getPercentIcmsInterno().doubleValue()) / 100);
            xIcmT = xIcmT + xCalculoIcmstt;
            xIcmBasePropria = xIcmBasePropria + xIcm;
            wBaseT = wBaseT + wBaseCalculoStt;
            wIcmT = xIcmT - xIcmBasePropria;
            setBaseSubstituicao(new BigDecimal(wBaseT));
            setIcmsSubstituicao(new BigDecimal(wIcmT));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Erro ao calcular substituição tributaria");
        }
    }

    public ClassificacaoFiscal getClassificacaoFiscal() {
        return classificacaoFiscal;
    }

    public void setClassificacaoFiscal(ClassificacaoFiscal classificacaoFiscal) {
        this.classificacaoFiscal = classificacaoFiscal;
    }

    public String getCstIcms() {
        return cstIcms;
    }

    public void setCstIcms(String cstIcms) {
        this.cstIcms = cstIcms;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdSubstituicaoTributariaEntrada() {
        return idSubstituicaoTributariaEntrada;
    }

    public void setIdSubstituicaoTributariaEntrada(Integer idSubstituicaoTributariaEntrada) {
        this.idSubstituicaoTributariaEntrada = idSubstituicaoTributariaEntrada;
    }

    public BigDecimal getMargem() {
        return margem;
    }

    public void setMargem(BigDecimal margem) {
        this.margem = margem;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public BigDecimal getPercentIcms() {
        return percentIcms;
    }

    public void setPercentIcms(BigDecimal percentIcms) {
        this.percentIcms = percentIcms;
    }

    public BigDecimal getPercentIcmsInterno() {
        return percentIcmsInterno;
    }

    public void setPercentIcmsInterno(BigDecimal percentIcmsInterno) {
        this.percentIcmsInterno = percentIcmsInterno;
    }

    public Estado getUf() {
        return uf;
    }

    public void setUf(Estado uf) {
        this.uf = uf;
    }

    public Estado getUfEmissor() {
        return ufEmissor;
    }

    public void setUfEmissor(Estado ufEmissor) {
        this.ufEmissor = ufEmissor;
    }

    public BigDecimal getBaseSubstituicao() {
        return baseSubstituicao;
    }

    public void setBaseSubstituicao(BigDecimal baseSubstituicao) {
        this.baseSubstituicao = baseSubstituicao;
    }

    public BigDecimal getIcmsSubstituicao() {
        return icmsSubstituicao;
    }

    public void setIcmsSubstituicao(BigDecimal icmsSubstituicao) {
        this.icmsSubstituicao = icmsSubstituicao;
    }
}
