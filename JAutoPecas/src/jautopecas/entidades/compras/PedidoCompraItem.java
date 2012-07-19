package jautopecas.entidades.compras;

import jautopecas.entidades.produto.*;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "MOV_PEDIDO_COMPRA_ITEM")
public class PedidoCompraItem implements Serializable {

    @Id
    @Column(name = "ID_PEDIDO_COMPRA_ITEM")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedidoCompraItem;
    @OneToOne
    @JoinColumn(name = "ID_PEDIDO_COMPRA")
    private PedidoCompra pedido;
    @OneToOne
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;
    @Column(name = "QTD_PEDIDA")
    private BigDecimal quantidadePedida;
    @Column(name = "QTD_ENTREGUE")
    private BigDecimal quantidadeEntregue;
    @Column(name = "VALOR_UNITARIO_LIQUIDO")
    private BigDecimal valorUnitarioLiquido;
    @Column(name = "VALOR_UNITARIO_BRUTO")
    private BigDecimal valorUnitarioBruto;
    @Column(name = "TOTAL_UNITARIO_LIQUIDO")
    private BigDecimal totalUnitarioLiquido;
    @Column(name = "TOTAL_UNITARIO_BRUTO")
    private BigDecimal totalUnitarioBruto;
    @Column(name = "VALOR_IPI")
    private BigDecimal valorIpi;
    @Column(name = "VALOR_ICMS")
    private BigDecimal valorIcms;
    @Column(name = "VALOR_BASE_ICMS_ST")
    private BigDecimal valorBaseIcmsSt;
    @Column(name = "VALOR_ICMS_ST")
    private BigDecimal valorIcmsSt;
    @Column(name = "VALOR_DESCONTO")
    private BigDecimal valorDesconto;
    @Column(name = "PERCENT_ICMS")
    private BigDecimal percentIcms;
    @Column(name = "PERCENT_IPI")
    private BigDecimal percentIpi;

    public Integer getIdPedidoCompraItem() {
        return idPedidoCompraItem;
    }

    public void setIdPedidoCompraItem(Integer idPedidoCompraItem) {
        this.idPedidoCompraItem = idPedidoCompraItem;
    }

    public PedidoCompra getPedido() {
        return pedido;
    }

    public void setPedido(PedidoCompra pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQuantidadeEntregue() {
        return quantidadeEntregue;
    }

    public void setQuantidadeEntregue(BigDecimal quantidadeEntregue) {
        this.quantidadeEntregue = quantidadeEntregue;
    }

    public BigDecimal getQuantidadePedida() {
        return quantidadePedida;
    }

    public void setQuantidadePedida(BigDecimal quantidadePedida) {
        this.quantidadePedida = quantidadePedida;
    }

    public BigDecimal getTotalUnitarioBruto() {
        return totalUnitarioBruto;
    }

    public void setTotalUnitarioBruto(BigDecimal totalUnitarioBruto) {
        this.totalUnitarioBruto = totalUnitarioBruto;
    }

    public BigDecimal getTotalUnitarioLiquido() {
        return totalUnitarioLiquido;
    }

    public void setTotalUnitarioLiquido(BigDecimal totalUnitarioLiquido) {
        this.totalUnitarioLiquido = totalUnitarioLiquido;
    }

    public BigDecimal getValorBaseIcmsSt() {
        return valorBaseIcmsSt;
    }

    public void setValorBaseIcmsSt(BigDecimal valorBaseIcmsSt) {
        this.valorBaseIcmsSt = valorBaseIcmsSt;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public BigDecimal getValorIcms() {
        return valorIcms;
    }

    public void setValorIcms(BigDecimal valorIcms) {
        this.valorIcms = valorIcms;
    }

    public BigDecimal getValorIcmsSt() {
        return valorIcmsSt;
    }

    public void setValorIcmsSt(BigDecimal valorIcmsSt) {
        this.valorIcmsSt = valorIcmsSt;
    }

    public BigDecimal getValorIpi() {
        return valorIpi;
    }

    public void setValorIpi(BigDecimal valorIpi) {
        this.valorIpi = valorIpi;
    }

    public BigDecimal getValorUnitarioBruto() {
        return valorUnitarioBruto;
    }

    public void setValorUnitarioBruto(BigDecimal valorUnitarioBruto) {
        this.valorUnitarioBruto = valorUnitarioBruto;
    }

    public BigDecimal getValorUnitarioLiquido() {
        return valorUnitarioLiquido;
    }

    public void setValorUnitarioLiquido(BigDecimal valorUnitarioLiquido) {
        this.valorUnitarioLiquido = valorUnitarioLiquido;
    }

    public BigDecimal getPercentIcms() {
        return percentIcms;
    }

    public void setPercentIcms(BigDecimal percentIcms) {
        this.percentIcms = percentIcms;
    }

    public BigDecimal getPercentIpi() {
        return percentIpi;
    }

    public void setPercentIpi(BigDecimal percentIpi) {
        this.percentIpi = percentIpi;
    }
}
