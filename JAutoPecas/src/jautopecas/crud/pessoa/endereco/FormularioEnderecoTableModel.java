package jautopecas.crud.pessoa.endereco;

import jautopecas.entidades.pessoa.endereco.EnderecoPessoa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JFFiorotto
 */
public class FormularioEnderecoTableModel extends AbstractTableModel {

    private String[] colunas = {"Tipo Endereco", "Logradouro"};
    private List<EnderecoPessoa> dados = new ArrayList<>();

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

        EnderecoPessoa dado = dados.get(rowIndex);
        if (columnIndex == 0) {
            return dado.getEndereco().getTipoLogradouro().getNome();
        } else {
            return dado.getEndereco().getLogradouro();
        }
    }

    @Override
    public String getColumnName(int col) {
        return colunas[col];
    }

    public List<EnderecoPessoa> getProdutos() {
        return dados;
    }

    public void setProdutos(List<EnderecoPessoa> dados) {
        this.dados = dados;
    }

    public void mostraResultado(List<EnderecoPessoa> l) {
        dados = new ArrayList<>();
        if (l != null) {
            getProdutos().addAll(l);
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
        EnderecoPessoa vo = dados.get(row);
        fireTableCellUpdated(row, col);
    }

    public EnderecoPessoa buscaProduto(int row) {
        EnderecoPessoa p = dados.get(row);
        return p;
    }
}
