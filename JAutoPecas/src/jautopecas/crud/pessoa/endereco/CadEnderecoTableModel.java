/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.crud.pessoa.endereco;

import jautopecas.entidades.pessoa.endereco.Endereco;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JFFiorotto
 */
public class CadEnderecoTableModel extends AbstractTableModel {

    private String[] colunas = {"Tipo Endereco", "Logradouro"};
    private List<Endereco> dados = new ArrayList<Endereco>();

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

        Endereco dado = dados.get(rowIndex);
        if (columnIndex == 0) {
            return dado.getTipoLogradouro();
        } else {
            return dado.getLogradouro();
        }
    }

    @Override
    public String getColumnName(int col) {
        return colunas[col];
    }

    public List<Endereco> getProdutos() {
        return dados;
    }

    public void setProdutos(List<Endereco> dados) {
        this.dados = dados;
    }

    public void mostraResultado(List<Endereco> l) {
        dados = new ArrayList<Endereco>();
        getProdutos().addAll(l);
        fireTableDataChanged();
    }

    public void removeResultado() {
        dados = new ArrayList<Endereco>();
        fireTableDataChanged();
    }

    @Override
    public Class<?> getColumnClass(int col) {
        return super.getColumnClass(col);
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Endereco vo = dados.get(row);
        fireTableCellUpdated(row, col);
    }

    public Endereco buscaProduto(int row) {
        Endereco p = dados.get(row);
        return p;
    }
}
