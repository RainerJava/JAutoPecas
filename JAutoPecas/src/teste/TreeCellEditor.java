package teste;

import jautopecas.entidades.menu.ItemMenu;
import jautopecas.entidades.pessoa.login.LoginPermissaoPessoa;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import org.jdesktop.swingx.JXTreeTable;

/**
 * @author JFFiorotto
 *
 */
public class TreeCellEditor implements TableCellEditor {

    JCheckBox component = new JCheckBox();
    JXTreeTable tree;
    JTable table;
    Object value;
    boolean isSelected;
    int rowIndex;
    int vColIndex;

    public TreeCellEditor(JXTreeTable tree) {
        this.tree = tree;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int rowIndex, int vColIndex) {
        ((JCheckBox) component).setSelected((Boolean) value);
        System.out.println("getTableCellEditorComponent");
        this.table = table;
        this.value = value;
        this.isSelected = isSelected;
        this.rowIndex = rowIndex;
        this.vColIndex = vColIndex;

        component.setHorizontalAlignment(SwingConstants.CENTER);
        component.setBackground(Color.white);
        component.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                stopCellEditing();
            }
        });

        return component;
    }

    @Override
    public Object getCellEditorValue() {
        return ((JCheckBox) component).isSelected();
    }

    @Override
    public void cancelCellEditing() {
        System.out.println("cancelCellEditing");
    }

    @Override
    public boolean stopCellEditing() {
        System.out.println("stopCellEditing");
        TreePath path = tree.getPathForRow(rowIndex);
        if (path != null) {
            Object node = path.getLastPathComponent();
            if ((node != null) && (node instanceof DefaultMutableTreeNode)) {
                DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) node;
                teste(treeNode);
            }
        }
        tree.repaint();
        return true;
    }

    private void teste(DefaultMutableTreeNode treeNode) {
        Object userObject = treeNode.getUserObject();
        if (vColIndex == 2) {
            ((LoginPermissaoPessoa) userObject).setVisualizar(((JCheckBox) component).isSelected());
        } else if (vColIndex == 3) {
            ((LoginPermissaoPessoa) userObject).setIncluir(((JCheckBox) component).isSelected());
        } else if (vColIndex == 4) {
            ((LoginPermissaoPessoa) userObject).setAlterar(((JCheckBox) component).isSelected());
        } else if (vColIndex == 5) {
            ((LoginPermissaoPessoa) userObject).setExcluir(((JCheckBox) component).isSelected());
        }
        for (int i = 0; i < treeNode.getChildCount(); i++) {
            if (vColIndex == 2) {
                ((LoginPermissaoPessoa) ((DefaultMutableTreeNode) treeNode.getChildAt(i)).getUserObject()).setVisualizar(((JCheckBox) component).isSelected());
            } else if (vColIndex == 3) {
                ((LoginPermissaoPessoa) ((DefaultMutableTreeNode) treeNode.getChildAt(i)).getUserObject()).setIncluir(((JCheckBox) component).isSelected());
            } else if (vColIndex == 4) {
                ((LoginPermissaoPessoa) ((DefaultMutableTreeNode) treeNode.getChildAt(i)).getUserObject()).setAlterar(((JCheckBox) component).isSelected());
            } else if (vColIndex == 5) {
                ((LoginPermissaoPessoa) ((DefaultMutableTreeNode) treeNode.getChildAt(i)).getUserObject()).setExcluir(((JCheckBox) component).isSelected());
            }
            if (treeNode.getChildAt(i).getChildCount() > 0) {
                teste((DefaultMutableTreeNode) treeNode.getChildAt(i));
            }
        }
    }

    @Override
    public void addCellEditorListener(CellEditorListener arg0) {
    }

    @Override
    public boolean isCellEditable(EventObject event) {
        return true;
//        boolean returnValue = false;
//        if (event instanceof MouseEvent) {
//            MouseEvent mouseEvent = (MouseEvent) event;
//            TreePath path = tree.getPathForLocation(mouseEvent.getX(),
//                    mouseEvent.getY());
//            if (path != null) {
//                Object node = path.getLastPathComponent();
//                if ((node != null) && (node instanceof DefaultMutableTreeNode)) {
//                    DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) node;
//                    Object userObject = treeNode.getUserObject();
//                    if (treeNode.isLeaf()) {
//                        returnValue = true;
//                    }
//                }
//            }
//        }
//        return returnValue;
    }

    @Override
    public void removeCellEditorListener(CellEditorListener arg0) {
    }

    @Override
    public boolean shouldSelectCell(EventObject arg0) {
        return true;
    }
}
