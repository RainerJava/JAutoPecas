package jautopecas.entidades.produto;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @Column(name = "CST_IPI")
    private String cstIpi;
    @Column(name = "CST_PIS")
    private String cstPis;
    @Column(name = "CST_COFINS")
    private String cstCofins;

    public String getClassificacaoFiscal() {
        return classificacaoFiscal;
    }

    public void setClassificacaoFiscal(String classificacaoFiscal) {
        this.classificacaoFiscal = classificacaoFiscal;
    }

    public String getCstCofins() {
        return cstCofins;
    }

    public void setCstCofins(String cstCofins) {
        this.cstCofins = cstCofins;
    }

    public String getCstIpi() {
        return cstIpi;
    }

    public void setCstIpi(String cstIpi) {
        this.cstIpi = cstIpi;
    }

    public String getCstPis() {
        return cstPis;
    }

    public void setCstPis(String cstPis) {
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
