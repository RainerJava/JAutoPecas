package jautopecas.crud.compras;

import jautopecas.entidades.compras.PedidoCompraItem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JFFiorotto
 */
public class TableModelItensPedidoCompra extends AbstractTableModel {

    private String[] colunas = {"ID", "Numero Fabricante", "Qtd", "Preço", "Desconto", "% IPI", "% ICMS"};
    private List<PedidoCompraItem> dados = new ArrayList<>();

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PedidoCompraItem dado = dados.get(rowIndex);
        if (columnIndex == 0) {
            return dado.getProduto().getIdProduto();
        } else if (columnIndex == 1) {
            return dado.getProduto().getNumeroFabricante();
        } else if (columnIndex == 2) {
            return dado.getQuantidadePedida();
        } else if (columnIndex == 3) {
            return dado.getValorUnitarioLiquido();
        } else if (columnIndex == 4) {
            return dado.getValorDesconto();
        } else if (columnIndex == 5) {
            return dado.getValorIpi();
        } else if (columnIndex == 6) {
            return dado.getValorIcms();
        } else {
            return null;
        }
    }

    @Override
    public String getColumnName(int col) {
        return colunas[col];
    }

    public List<PedidoCompraItem> getProduto() {
        return dados;
    }

    public void setProduto(List<PedidoCompraItem> dados) {
        this.dados = dados;
    }

    public void mostraResultado(List<PedidoCompraItem> l) {
        dados = new ArrayList<>();
        if (l != null) {
            getProduto().addAll(l);
        }

        fireTableDataChanged();
    }

    public void removeResultado() {
        dados = new ArrayList<>();
        fireTableDataChanged();
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return super.getColumnClass(col);
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        PedidoCompraItem vo = dados.get(row);
        fireTableCellUpdated(row, col);
    }

    public PedidoCompraItem buscaProduto(int row) {
        PedidoCompraItem p = dados.get(row);
        return p;
    }
}
