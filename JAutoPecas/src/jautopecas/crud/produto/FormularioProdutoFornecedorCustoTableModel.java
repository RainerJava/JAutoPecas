package jautopecas.crud.produto;

import jautopecas.entidades.produto.ProdutoFornecedorCusto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JFFiorotto
 */
public class FormularioProdutoFornecedorCustoTableModel extends AbstractTableModel {

    private String[] colunas = {"Empresa", "Custo Unitario"};
    private List<ProdutoFornecedorCusto> dados = new ArrayList<>();

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

        ProdutoFornecedorCusto dado = dados.get(rowIndex);
        if (columnIndex == 0) {
            return dado.getEmpresa().getNome();
        } else {
            return dado.getCustoUnitario();
        }
    }

    @Override
    public String getColumnName(int col) {
        return colunas[col];
    }

    public List<ProdutoFornecedorCusto> getProdutoFornecedoresCusto() {
        return dados;
    }

    public void setProdutoFornecedoresCusto(List<ProdutoFornecedorCusto> dados) {
        this.dados = dados;
    }

    public void mostraResultado(List<ProdutoFornecedorCusto> l) {
        dados = new ArrayList<>();
        if (l != null) {
            getProdutoFornecedoresCusto().addAll(l);
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
        ProdutoFornecedorCusto vo = dados.get(row);
        fireTableCellUpdated(row, col);
    }

    public ProdutoFornecedorCusto buscaProduto(int row) {
        ProdutoFornecedorCusto p = dados.get(row);
        return p;
    }
}
