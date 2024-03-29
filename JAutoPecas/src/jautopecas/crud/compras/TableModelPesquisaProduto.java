package jautopecas.crud.compras;

import jautopecas.entidades.produto.Estoque;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JFFiorotto
 */
public class TableModelPesquisaProduto extends AbstractTableModel {

    private String[] colunas = {"ID", "Estoque", "Preco", "Numero Fabricante", "Descrição", "Fabricante", "Aplicação"};
    private List<Estoque> dados = new ArrayList<>();

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
        Estoque dado = dados.get(rowIndex);
        if (columnIndex == 0) {
            return dado.getProduto().getIdProduto();
        } else if (columnIndex == 1) {
            return dado.getEstoqueAtual();
        } else if (columnIndex == 2) {
            return dado.getProduto().getCustoFornecedor().getCustoUnitario();
        } else if (columnIndex == 3) {
            return dado.getProduto().getNumeroFabricante();
        } else if (columnIndex == 4) {
            return dado.getProduto().getDescricao();
        } else if (columnIndex == 5) {
            return dado.getProduto().getFabricante().getNome();
        } else if (columnIndex == 6) {
            return dado.getProduto().getAplicacao();
        } else {
            return null;
        }
    }

    @Override
    public String getColumnName(int col) {
        return colunas[col];
    }

    public List<Estoque> getProduto() {
        return dados;
    }

    public void setProduto(List<Estoque> dados) {
        this.dados = dados;
    }

    public void mostraResultado(List<Estoque> l) {
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
        Estoque vo = dados.get(row);
        fireTableCellUpdated(row, col);
    }

    public Estoque buscaProduto(int row) {
        Estoque p = dados.get(row);
        return p;
    }
}
