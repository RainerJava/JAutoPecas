package jautopecas.crud.pessoa.colaborador;

import jautopecas.entidades.pessoa.colaborador.FuncaoSalarioColaborador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author JFFiorotto
 */
public class ColaboradorFuncaoSalarioTableModel extends AbstractTableModel {

    private String[] colunas = {"Data Inicial", "Data Final", "Função", "Salario"};
    private List<FuncaoSalarioColaborador> dados = new ArrayList<>();

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

        FuncaoSalarioColaborador dado = dados.get(rowIndex);
        if (columnIndex == 0) {
            return dado.getDataInicio();
        } else if (columnIndex == 1) {
            return dado.getDataFim();
        } else if (columnIndex == 2) {
            return dado.getFuncao().getNome();
        } else {
            return dado.getSalario();
        }
    }

    @Override
    public String getColumnName(int col) {
        return colunas[col];
    }

    public List<FuncaoSalarioColaborador> getFuncaoSalarioColaborador() {
        return dados;
    }

    public void setFuncaoSalarioColaborador(List<FuncaoSalarioColaborador> dados) {
        this.dados = dados;
    }

    public void mostraResultado(List<FuncaoSalarioColaborador> l) {
        dados = new ArrayList<>();
        if (l != null) {
            getFuncaoSalarioColaborador().addAll(l);
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
        FuncaoSalarioColaborador vo = dados.get(row);
        fireTableCellUpdated(row, col);
    }

    public FuncaoSalarioColaborador buscaFuncaoSalarioColaborador(int row) {
        FuncaoSalarioColaborador p = dados.get(row);
        return p;
    }
}
