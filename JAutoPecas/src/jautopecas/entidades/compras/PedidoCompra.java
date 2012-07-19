package jautopecas.entidades.compras;

import jautopecas.entidades.pessoa.Pessoa;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "MOV_PEDIDO_COMPRA")
public class PedidoCompra implements Serializable {

    @Id
    @Column(name = "ID_PEDIDO_COMPRA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedidoCompra;
    @OneToOne
    @JoinColumn(name = "ID_EMPRESA")
    private Pessoa empresa;
    @OneToOne
    @JoinColumn(name = "ID_FORNECEDOR")
    private Pessoa fornecedor;
    @Column(name = "NUMERO_PEDIDO")
    private String numeroPedido;
    private Boolean temporario;
    @Column(name = "DATA_EMISSAO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEmissao;
    @Column(name = "DATA_PREVISAO_ENTREGA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPrevisaoEntrega;
    @Column(name = "TOTAL_PEDIDO")
    private BigDecimal totalPedido;
    @Column(name = "TOTAL_PRODUTO")
    private BigDecimal totalProduto;
    @Column(name = "TOTAL_IPI")
    private BigDecimal totalIpi;
    @Column(name = "TOTAL_ICMS")
    private BigDecimal totalIcms;
    @Column(name = "TOTAL_BASE_ICMS_ST")
    private BigDecimal totalBaseIcmsSt;
    @Column(name = "TOTAL_ICMS_ST")
    private BigDecimal totalIcmsSt;
    @Column(name = "TOTAL_DESCONTO")
    private BigDecimal totalDesconto;
    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoCompraItem> itens;

    public void criaNumeroPedido() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int mesAtual = c.get(Calendar.MONTH) + 1;
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
        StringBuilder numeroPedido = new StringBuilder();
        if (temporario) {
            numeroPedido.append("TMP_");
        }
        numeroPedido.append(letras[mesAtual]);
        numeroPedido.append(c.get(Calendar.YEAR));
        this.setNumeroPedido(numeroPedido.toString());
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataPrevisaoEntrega() {
        return dataPrevisaoEntrega;
    }

    public void setDataPrevisaoEntrega(Date dataPrevisaoEntrega) {
        this.dataPrevisaoEntrega = dataPrevisaoEntrega;
    }

    public Pessoa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Pessoa empresa) {
        this.empresa = empresa;
    }

    public Pessoa getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Pessoa fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Integer getIdPedidoCompra() {
        return idPedidoCompra;
    }

    public void setIdPedidoCompra(Integer idPedidoCompra) {
        this.idPedidoCompra = idPedidoCompra;
    }

    public List<PedidoCompraItem> getItens() {
        return itens;
    }

    public void setItens(List<PedidoCompraItem> itens) {
        this.itens = itens;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Boolean getTemporario() {
        return temporario;
    }

    public void setTemporario(Boolean temporario) {
        this.temporario = temporario;
    }

    public BigDecimal getTotalBaseIcmsSt() {
        return totalBaseIcmsSt;
    }

    public void setTotalBaseIcmsSt(BigDecimal totalBaseIcmsSt) {
        this.totalBaseIcmsSt = totalBaseIcmsSt;
    }

    public BigDecimal getTotalDesconto() {
        return totalDesconto;
    }

    public void setTotalDesconto(BigDecimal totalDesconto) {
        this.totalDesconto = totalDesconto;
    }

    public BigDecimal getTotalIcms() {
        return totalIcms;
    }

    public void setTotalIcms(BigDecimal totalIcms) {
        this.totalIcms = totalIcms;
    }

    public BigDecimal getTotalIcmsSt() {
        return totalIcmsSt;
    }

    public void setTotalIcmsSt(BigDecimal totalIcmsSt) {
        this.totalIcmsSt = totalIcmsSt;
    }

    public BigDecimal getTotalIpi() {
        return totalIpi;
    }

    public void setTotalIpi(BigDecimal totalIpi) {
        this.totalIpi = totalIpi;
    }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
    }

    public BigDecimal getTotalProduto() {
        return totalProduto;
    }

    public void setTotalProduto(BigDecimal totalProduto) {
        this.totalProduto = totalProduto;
    }
}
