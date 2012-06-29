package jautopecas.entidades.produto;

import jautopecas.entidades.pessoa.Pessoa;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_PRODUTO")
public class Produto implements Serializable {

    @Id
    @Column(name = "ID_PRODUTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduto;
    @Column(name = "NUMERO_FABRICANTE")
    private String numeroFabricante;
    private String descricao;
    @Column(name = "CODIGO_BARRA")
    private String codigoBarra;
    @Column(name = "QTD_EMBALAGEM_COMPRA")
    private BigDecimal qtdEmbalagemCompra;
    @Column(name = "QTD_EMBALAGEM_VENDA")
    private BigDecimal qtdEmbalagemVenda;
    @Column(name = "FATOR_EMBALAGEM_COMPRA")
    private BigDecimal fator;
    @Column(name = "PESO_LIQUIDO")
    private BigDecimal pesoLiguido;
    @Column(name = "PESO_BRUTO")
    private BigDecimal pesoBruto;
//    @OneToOne
//    @JoinColumn(name = "ID_UNIDADE")
//    private Unidade unidade;
    @OneToOne
    @JoinColumn(name = "ID_FABRICANTE")
    private Pessoa fabricante;
    @Column(name = "CLASSIFICACAO_FISCAL")
    private String classificacaoFiscal;
    private String aplicacao;
    private String status;
    //    @OneToOne
//    @JoinColumn(name = "ID_MARCA")
//    private Marca marca;
    @Column(name = "DATA_CADASTRO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    private String medida;
    @Column(name = "TIPO_PRODUTO")
    private String tipoProduto; //<R>-Revenda / <C>-Consumo / <A>-Ativo / <B>-Brinde
    @Column(name = "CLASSIFICACAO_ABC")
    private String classificacaoAbc;

    
    public String getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(String aplicacao) {
        this.aplicacao = aplicacao;
    }

    public String getClassificacaoAbc() {
        return classificacaoAbc;
    }

    public void setClassificacaoAbc(String classificacaoAbc) {
        this.classificacaoAbc = classificacaoAbc;
    }

    public String getClassificacaoFiscal() {
        return classificacaoFiscal;
    }

    public void setClassificacaoFiscal(String classificacaoFiscal) {
        this.classificacaoFiscal = classificacaoFiscal;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pessoa getFabricante() {
        return fabricante;
    }

    public void setFabricante(Pessoa fabricante) {
        this.fabricante = fabricante;
    }

    public BigDecimal getFator() {
        return fator;
    }

    public void setFator(BigDecimal fator) {
        this.fator = fator;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getNumeroFabricante() {
        return numeroFabricante;
    }

    public void setNumeroFabricante(String numeroFabricante) {
        this.numeroFabricante = numeroFabricante;
    }

    public BigDecimal getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(BigDecimal pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    public BigDecimal getPesoLiguido() {
        return pesoLiguido;
    }

    public void setPesoLiguido(BigDecimal pesoLiguido) {
        this.pesoLiguido = pesoLiguido;
    }

    public BigDecimal getQtdEmbalagemCompra() {
        return qtdEmbalagemCompra;
    }

    public void setQtdEmbalagemCompra(BigDecimal qtdEmbalagemCompra) {
        this.qtdEmbalagemCompra = qtdEmbalagemCompra;
    }

    public BigDecimal getQtdEmbalagemVenda() {
        return qtdEmbalagemVenda;
    }

    public void setQtdEmbalagemVenda(BigDecimal qtdEmbalagemVenda) {
        this.qtdEmbalagemVenda = qtdEmbalagemVenda;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
}
