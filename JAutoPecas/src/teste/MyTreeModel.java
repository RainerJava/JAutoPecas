package teste;

import jautopecas.entidades.pessoa.login.LoginPermissaoPessoa;
import javax.swing.tree.DefaultMutableTreeNode;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;

public class MyTreeModel extends AbstractTreeTableModel {

    private String[] titles = {"ID Item", "Nome", "Visualizar", "Incluir", "Alterar", "Excluir"};

    public MyTreeModel(DefaultMutableTreeNode root) {
        super(root);
    }

    /**
     * Table Columns
     */
    @Override
    public boolean isCellEditable(Object arg0, int arg1) {
        return true;
    }

    @Override
    public String getColumnName(int column) {
        if (column < titles.length) {
            return (String) titles[column];
        } else {
            return "";
        }
    }

    @Override
    public int getColumnCount() {
        return titles.length;
    }

    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Boolean.class;
            case 3:
                return Boolean.class;
            case 4:
                return Boolean.class;
            case 5:
                return Boolean.class;
        }
        return String.class;
    }

    @Override
    public Object getValueAt(Object arg0, int arg1) {
        if (arg0 instanceof TableRowData) {
            LoginPermissaoPessoa data = (LoginPermissaoPessoa) arg0;
            if (data != null) {
                switch (arg1) {
                    case 0:
                        return data.getItemMenu().getIdItemMenu();
                    case 1:
                        return data.getItemMenu().getNome();
                    case 2:
                        return data.getVisualizar();
                    case 3:
                        return data.getIncluir();
                    case 4:
                        return data.getAlterar();
                    case 5:
                        return data.getExcluir();
                }
            }
        }

        if (arg0 instanceof DefaultMutableTreeNode) {
            DefaultMutableTreeNode dataNode = (DefaultMutableTreeNode) arg0;
            LoginPermissaoPessoa data = (LoginPermissaoPessoa) dataNode.getUserObject();
            if (data != null) {
                switch (arg1) {
                    case 0:
                        return data.getItemMenu().getIdItemMenu();
                    case 1:
                        return data.getItemMenu().getNome();
                    case 2:
                        return data.getVisualizar();
                    case 3:
                        return data.getIncluir();
                    case 4:
                        return data.getAlterar();
                    case 5:
                        return data.getExcluir();
                }
            }
        }
        return null;
    }

    @Override
    public Object getChild(Object arg0, int arg1) {

        if (arg0 instanceof DefaultMutableTreeNode) {
            DefaultMutableTreeNode nodes = (DefaultMutableTreeNode) arg0;
            return nodes.getChildAt(arg1);
        }
        return null;
    }

    @Override
    public int getChildCount(Object arg0) {

        if (arg0 instanceof DefaultMutableTreeNode) {
            DefaultMutableTreeNode nodes = (DefaultMutableTreeNode) arg0;
            return nodes.getChildCount();
        }
        return 0;
    }

    @Override
    public int getIndexOfChild(Object arg0, Object arg1) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isLeaf(Object node) {
        return getChildCount(node) == 0;
    }
}
