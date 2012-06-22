package jautopecas.crud.pessoa.telefone;

import jautopecas.entidades.pessoa.telefone.TelefonePessoa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JFFiorotto
 */
public class FormularioTelefoneTableModel extends AbstractTableModel {

    private String[] colunas = {"Tipo Telefone", "Telefone"};
    private List<TelefonePessoa> dados = new ArrayList<>();

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

        TelefonePessoa dado = dados.get(rowIndex);
        if (columnIndex == 0) {
            return dado.getTelefone().getTipoTelefone().getNome();
        } else {
            return dado.getTelefone().getTelefone();
        }
    }

    @Override
    public String getColumnName(int col) {
        return colunas[col];
    }

    public List<TelefonePessoa> getTelefones() {
        return dados;
    }

    public void setTelefone(List<TelefonePessoa> dados) {
        this.dados = dados;
    }

    public void mostraResultado(List<TelefonePessoa> l) {
        dados = new ArrayList<>();
        if (l != null) {
            getTelefones().addAll(l);
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
        TelefonePessoa vo = dados.get(row);
        fireTableCellUpdated(row, col);
    }

    public TelefonePessoa buscaTelefone(int row) {
        TelefonePessoa p = dados.get(row);
        return p;
    }
}
