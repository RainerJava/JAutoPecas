package jautopecas.crud.pessoa.login;

import jautopecas.entidades.pessoa.login.LoginPessoa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JFFiorotto
 */
public class FormularioLoginTableModel extends AbstractTableModel {

    private String[] colunas = {"Login", "Status"};
    private List<LoginPessoa> dados = new ArrayList<>();

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

        LoginPessoa dado = dados.get(rowIndex);
        if (columnIndex == 0) {
            return dado.getLogin();
        } else {
            return dado.getStatus();
        }
    }

    @Override
    public String getColumnName(int col) {
        return colunas[col];
    }

    public List<LoginPessoa> getLogins() {
        return dados;
    }

    public void setProdutos(List<LoginPessoa> dados) {
        this.dados = dados;
    }

    public void mostraResultado(List<LoginPessoa> l) {
        dados = new ArrayList<>();
        if (l != null) {
            getLogins().addAll(l);
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
        LoginPessoa vo = dados.get(row);
        fireTableCellUpdated(row, col);
    }

    public LoginPessoa buscaProduto(int row) {
        LoginPessoa p = dados.get(row);
        return p;
    }
}
