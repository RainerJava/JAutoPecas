package jautopecas.entidades.produto;

import jautopecas.dao.produto.ProdutoFornecedorCustoDao;
import jautopecas.entidades.pessoa.Pessoa;
import jautopecas.entidades.substituicaoTributaria.Cst;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
    @Column(name = "CODIGO_BARRA_FABRICANTE")
    private String codigoBarraFabricante;
    @Column(name = "CODIGO_BARRA_EMPRESA")
    private String codigoBarraEmpresa;
    @Column(name = "QTD_EMBALAGEM_COMPRA")
    private BigDecimal qtdEmbalagemCompra;
    @Column(name = "QTD_EMBALAGEM_VENDA")
    private BigDecimal qtdEmbalagemVenda;
    @Column(name = "FATOR_EMBALAGEM_COMPRA")
    private BigDecimal fatorEmbalagemCompra;
    @Column(name = "FATOR_EMBALAGEM_VENDA")
    private BigDecimal fatorEmbalagemVenda;
    @Column(name = "PESO_LIQUIDO")
    private BigDecimal pesoLiguido;
    @Column(name = "PESO_BRUTO")
    private BigDecimal pesoBruto;
    @OneToOne
    @JoinColumn(name = "ID_UNIDADE_COMPRA")
    private Unidade unidadeCompra;
    @OneToOne
    @JoinColumn(name = "ID_UNIDADE_VENDA")
    private Unidade unidadeVenda;
    @OneToOne
    @JoinColumn(name = "ID_FABRICANTE")
    private Pessoa fabricante;
    @OneToOne
    @JoinColumn(name = "CLASSIFICACAO_FISCAL")
    private ClassificacaoFiscal classificacaoFiscal;
    private String aplicacao;
    private String status;
    @OneToOne
    @JoinColumn(name = "ID_MARCA")
    private Marca marca;
    @OneToOne
    @JoinColumn(name = "ID_GRUPO")
    private Grupo grupo;
    @OneToOne
    @JoinColumn(name = "ID_SUBGRUPO")
    private Subgrupo subGrupo;
    @OneToOne
    @JoinColumn(name = "ID_FAMILIA")
    private Familia familia;
    @Column(name = "DATA_CADASTRO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    private String medida;
    @OneToOne
    @JoinColumn(name = "TIPO_PRODUTO")
    private TipoProduto tipoProduto;
    @Column(name = "CLASSIFICACAO_ABC")
    private String classificacaoAbc;
    @OneToOne
    @JoinColumn(name = "CST_ICMS")
    private Cst cstIcms;
    @OneToMany(mappedBy = "produto", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoFornecedor> produtoFornecedor;
    @Transient
    private ProdutoFornecedorCusto custoFornecedor;

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

    public ClassificacaoFiscal getClassificacaoFiscal() {
        return classificacaoFiscal;
    }

    public void setClassificacaoFiscal(ClassificacaoFiscal classificacaoFiscal) {
        this.classificacaoFiscal = classificacaoFiscal;
    }

    public String getCodigoBarraEmpresa() {
        return codigoBarraEmpresa;
    }

    public void setCodigoBarraEmpresa(String codigoBarraEmpresa) {
        this.codigoBarraEmpresa = codigoBarraEmpresa;
    }

    public String getCodigoBarraFabricante() {
        return codigoBarraFabricante;
    }

    public void setCodigoBarraFabricante(String codigoBarraFabricante) {
        this.codigoBarraFabricante = codigoBarraFabricante;
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

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public BigDecimal getFatorEmbalagemCompra() {
        return fatorEmbalagemCompra;
    }

    public void setFatorEmbalagemCompra(BigDecimal fatorEmbalagemCompra) {
        this.fatorEmbalagemCompra = fatorEmbalagemCompra;
    }

    public BigDecimal getFatorEmbalagemVenda() {
        return fatorEmbalagemVenda;
    }

    public void setFatorEmbalagemVenda(BigDecimal fatorEmbalagemVenda) {
        this.fatorEmbalagemVenda = fatorEmbalagemVenda;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
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

    public Subgrupo getSubGrupo() {
        return subGrupo;
    }

    public void setSubGrupo(Subgrupo subGrupo) {
        this.subGrupo = subGrupo;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Unidade getUnidadeCompra() {
        return unidadeCompra;
    }

    public void setUnidadeCompra(Unidade unidadeCompra) {
        this.unidadeCompra = unidadeCompra;
    }

    public Unidade getUnidadeVenda() {
        return unidadeVenda;
    }

    public void setUnidadeVenda(Unidade unidadeVenda) {
        this.unidadeVenda = unidadeVenda;
    }

    public List<ProdutoFornecedor> getProdutoFornecedor() {
        return produtoFornecedor;
    }

    public void setProdutoFornecedor(List<ProdutoFornecedor> produtoFornecedor) {
        this.produtoFornecedor = produtoFornecedor;
    }

    public Cst getCstIcms() {
        return cstIcms;
    }

    public void setCstIcms(Cst cstIcms) {
        this.cstIcms = cstIcms;
    }

    public ProdutoFornecedorCusto getCustoFornecedor() {
        return custoFornecedor;
    }

    public void setCustoFornecedor(ProdutoFornecedorCusto custoFornecedor) {
        this.custoFornecedor = custoFornecedor;
    }
}
