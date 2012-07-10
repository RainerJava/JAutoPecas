package jautopecas.entidades.produto;

import jautopecas.entidades.substituicaoTributaria.Cst;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_CLASSIFICACAO_FISCAL")
public class ClassificacaoFiscal implements Serializable {

    @Id
    @Column(name = "CLASSIFICACAO_FISCAL")
    private String classificacaoFiscal;
    private String descricao;
    @Column(name = "PERCENT_IMPOSTO_IMPORTACAO")
    private BigDecimal percentImpostoImportacao;
    @Column(name = "PERCENT_IPI")
    private BigDecimal percentIpi;
    @Column(name = "PERCENT_IPI_PIS")
    private BigDecimal percentIpiPis;
    @Column(name = "PERCENT_PIS")
    private BigDecimal percentPis;
    @Column(name = "PERCENT_COFINS")
    private BigDecimal percentCofins;
    @OneToOne
    @JoinColumn(name = "CST_IPI")
    private Cst cstIpi;
    @OneToOne
    @JoinColumn(name = "CST_PIS")
    private Cst cstPis;
    @OneToOne
    @JoinColumn(name = "CST_COFINS")
    private Cst cstCofins;

    public String getClassificacaoFiscal() {
        return classificacaoFiscal;
    }

    public void setClassificacaoFiscal(String classificacaoFiscal) {
        this.classificacaoFiscal = classificacaoFiscal;
    }

    public Cst getCstCofins() {
        return cstCofins;
    }

    public void setCstCofins(Cst cstCofins) {
        this.cstCofins = cstCofins;
    }

    public Cst getCstIpi() {
        return cstIpi;
    }

    public void setCstIpi(Cst cstIpi) {
        this.cstIpi = cstIpi;
    }

    public Cst getCstPis() {
        return cstPis;
    }

    public void setCstPis(Cst cstPis) {
        this.cstPis = cstPis;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPercentCofins() {
        return percentCofins;
    }

    public void setPercentCofins(BigDecimal percentCofins) {
        this.percentCofins = percentCofins;
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

    public BigDecimal getPercentIpiPis() {
        return percentIpiPis;
    }

    public void setPercentIpiPis(BigDecimal percentIpiPis) {
        this.percentIpiPis = percentIpiPis;
    }

    public BigDecimal getPercentPis() {
        return percentPis;
    }

    public void setPercentPis(BigDecimal percentPis) {
        this.percentPis = percentPis;
    }
}
