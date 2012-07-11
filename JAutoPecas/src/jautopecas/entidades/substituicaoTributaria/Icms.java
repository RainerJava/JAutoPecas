package jautopecas.entidades.substituicaoTributaria;

import jautopecas.entidades.pessoa.endereco.Estado;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_ICMS")
public class Icms implements Serializable {

    @Id
    @Column(name = "ID_ICMS")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIcms;
    private String nome;
    @OneToOne
    @JoinColumn(name = "UF")
    private Estado uf;
    @OneToOne
    @JoinColumn(name = "UF_EMISSOR")
    private Estado ufEmissor;
    @Column(name = "TAXA_VIGENTE")
    private Integer taxaVigente;
    private Boolean desconto;
    @Column(name = "PERCENT_ICMS_1")
    private BigDecimal percentIcms1;
    @Column(name = "PERCENT_ICMS_2")
    private BigDecimal percentIcms2;
    @Column(name = "PERCENT_ICMS_3")
    private BigDecimal percentIcms3;
    @Column(name = "PERCENT_ICMS_4")
    private BigDecimal percentIcms4;
    @Column(name = "PERCENT_ICMS_5")
    private BigDecimal percentIcms5;
    @Column(name = "PERCENT_ICMS_6")
    private BigDecimal percentIcms6;

    public Boolean getDesconto() {
        return desconto;
    }

    public void setDesconto(Boolean desconto) {
        this.desconto = desconto;
    }

    public Integer getIdIcms() {
        return idIcms;
    }

    public void setIdIcms(Integer idIcms) {
        this.idIcms = idIcms;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPercentIcms1() {
        return percentIcms1;
    }

    public void setPercentIcms1(BigDecimal percentIcms1) {
        this.percentIcms1 = percentIcms1;
    }

    public BigDecimal getPercentIcms2() {
        return percentIcms2;
    }

    public void setPercentIcms2(BigDecimal percentIcms2) {
        this.percentIcms2 = percentIcms2;
    }

    public BigDecimal getPercentIcms3() {
        return percentIcms3;
    }

    public void setPercentIcms3(BigDecimal percentIcms3) {
        this.percentIcms3 = percentIcms3;
    }

    public BigDecimal getPercentIcms4() {
        return percentIcms4;
    }

    public void setPercentIcms4(BigDecimal percentIcms4) {
        this.percentIcms4 = percentIcms4;
    }

    public BigDecimal getPercentIcms5() {
        return percentIcms5;
    }

    public void setPercentIcms5(BigDecimal percentIcms5) {
        this.percentIcms5 = percentIcms5;
    }

    public BigDecimal getPercentIcms6() {
        return percentIcms6;
    }

    public void setPercentIcms6(BigDecimal percentIcms6) {
        this.percentIcms6 = percentIcms6;
    }

    public Integer getTaxaVigente() {
        return taxaVigente;
    }

    public void setTaxaVigente(Integer taxaVigente) {
        this.taxaVigente = taxaVigente;
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
}
