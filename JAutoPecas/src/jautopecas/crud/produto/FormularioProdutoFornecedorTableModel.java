package jautopecas.crud.produto;

import jautopecas.entidades.produto.ProdutoFornecedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JFFiorotto
 */
public class FormularioProdutoFornecedorTableModel extends AbstractTableModel {

    private String[] colunas = {"Numero Fornecedor", "Fornecedor"};
    private List<ProdutoFornecedor> dados = new ArrayList<>();

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

        ProdutoFornecedor dado = dados.get(rowIndex);
        if (columnIndex == 0) {
            return dado.getNumeroFornecedor();
        } else {
            return dado.getFornecedor().getNome();
        }
    }

    @Override
    public String getColumnName(int col) {
        return colunas[col];
    }

    public List<ProdutoFornecedor> getProdutoFornecedores() {
        return dados;
    }

    public void setProdutoFornecedores(List<ProdutoFornecedor> dados) {
        this.dados = dados;
    }

    public void mostraResultado(List<ProdutoFornecedor> l) {
        dados = new ArrayList<>();
        if (l != null) {
            getProdutoFornecedores().addAll(l);
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
        ProdutoFornecedor vo = dados.get(row);
        fireTableCellUpdated(row, col);
    }

    public ProdutoFornecedor buscaProduto(int row) {
        ProdutoFornecedor p = dados.get(row);
        return p;
    }
}
