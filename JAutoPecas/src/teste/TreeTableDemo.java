/*
 *TreeTableDemo.java   Feb 23, 2008
 * Developer: sandarenu
 * Copyright (c) 2006-2008 Minimuthu Software Developers.
 * Sri Lanka.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of 
 * Minimuthu Software Developers. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Minimuthu.
 */
package teste;

/**
 * @author sandarenu
 *
 */
import jautopecas.dao.pessoa.login.LoginPermissaoPessoaDao;
import jautopecas.entidades.menu.ItemMenu;
import jautopecas.entidades.pessoa.login.LoginPermissaoPessoa;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.JXTreeTable;
import org.jdesktop.swingx.decorator.Highlighter;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import org.jdesktop.swingx.renderer.DefaultTableRenderer;
import org.jdesktop.swingx.renderer.StringValue;

public class TreeTableDemo {

    /**
     * Creates a JTree from an InfiniteBinaryTree model and displays it.
     */
    private DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode();
    
    public TreeTableDemo(Image icon) {
        String idItemMenuPai = null;
        String idItemSubMenu = null;
        DefaultMutableTreeNode incomeNode = null;
        DefaultMutableTreeNode incomeNode2 = null;
        DefaultMutableTreeNode incomeNode3;
        
        List<LoginPermissaoPessoa> permissaoUsuario = new LoginPermissaoPessoaDao().listaPermissaoUsuario(1);
        for (int i = 0; i < permissaoUsuario.size(); i++) {
            if (permissaoUsuario.get(i).getItemMenu().getTipoItem().equals(ItemMenu.MENU)) {
                //incomeNode = new DefaultMutableTreeNode(new TableRowData(permissaoUsuario.get(i).getItemMenu().getIdItemMenu(), permissaoUsuario.get(i).getItemMenu().getNome(), permissaoUsuario.get(i).getVisualizar(), permissaoUsuario.get(i).getIncluir(), permissaoUsuario.get(i).getAlterar(), permissaoUsuario.get(i).getExcluir(), true));
                rootNode.add(incomeNode);
                idItemMenuPai = permissaoUsuario.get(i).getItemMenu().getIdItemMenu();
            } else if (permissaoUsuario.get(i).getItemMenu().getTipoItem().equals(ItemMenu.SUBMENU)) {
                if (permissaoUsuario.get(i).getItemMenu().getIdItemMenu().startsWith(idItemMenuPai)) {
                    //incomeNode2 = new DefaultMutableTreeNode(new TableRowData(permissaoUsuario.get(i).getItemMenu().getIdItemMenu(), permissaoUsuario.get(i).getItemMenu().getNome(), permissaoUsuario.get(i).getVisualizar(), permissaoUsuario.get(i).getIncluir(), permissaoUsuario.get(i).getAlterar(), permissaoUsuario.get(i).getExcluir(), true));
                    incomeNode.add(incomeNode2);
                    idItemSubMenu = permissaoUsuario.get(i).getItemMenu().getIdItemMenu();
                } else {
                    incomeNode2 = null;
                }
            } else if (permissaoUsuario.get(i).getItemMenu().getTipoItem().equals(ItemMenu.JANELA)) {
               // incomeNode3 = new DefaultMutableTreeNode(new TableRowData(permissaoUsuario.get(i).getItemMenu().getIdItemMenu(), permissaoUsuario.get(i).getItemMenu().getNome(), permissaoUsuario.get(i).getVisualizar(), permissaoUsuario.get(i).getIncluir(), permissaoUsuario.get(i).getAlterar(), permissaoUsuario.get(i).getExcluir(), true));
                if (idItemSubMenu != null && permissaoUsuario.get(i).getItemMenu().getIdItemMenu().startsWith(idItemSubMenu)) {
                   // incomeNode2.add(incomeNode3);
                } else {
                    //incomeNode.add(incomeNode3);
                }
            }
        }
        
        JXTreeTable binTree = new JXTreeTable(new MyTreeModel(rootNode));
        binTree.expandAll();
        
        Highlighter highligher = HighlighterFactory.createSimpleStriping(HighlighterFactory.BEIGE);
        binTree.setHighlighters(highligher);
        binTree.setShowGrid(false);
        binTree.setShowsRootHandles(false);
        //configureCommonTableProperties(binTree);
        binTree.setTreeCellRenderer(new TreeTableCellRenderer());
        binTree.getColumnModel().getColumn(2).setCellEditor(new TreeCellEditor(binTree));
        binTree.getColumnModel().getColumn(3).setCellEditor(new TreeCellEditor(binTree));
        binTree.getColumnModel().getColumn(4).setCellEditor(new TreeCellEditor(binTree));
        binTree.getColumnModel().getColumn(5).setCellEditor(new TreeCellEditor(binTree));
        JFrame frame = new JFrame("Tree Table Demo");
        frame.getContentPane().add(new JScrollPane(binTree));
        JButton botao = new JButton("Teste");
        botao.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseClicked(MouseEvent me) {
                for (int i = 0; i < rootNode.getChildCount(); i++) {
                    System.out.println("TESTE: " + ((TableRowData) ((javax.swing.tree.DefaultMutableTreeNode) rootNode.getChildAt(i)).getUserObject()).getIdItemMenu());
                    for (int j = 0; j < rootNode.getChildAt(i).getChildCount(); j++) {
                        System.out.println("TESTE: " + ((TableRowData) ((javax.swing.tree.DefaultMutableTreeNode) rootNode.getChildAt(i).getChildAt(j)).getUserObject()).getIdItemMenu());
                        if (((javax.swing.tree.DefaultMutableTreeNode) rootNode.getChildAt(i).getChildAt(j)).getChildCount() > 0) {
                            for (int k = 0; k < ((javax.swing.tree.DefaultMutableTreeNode) rootNode.getChildAt(i).getChildAt(j)).getChildCount(); k++) {
                                System.out.println("TESTE: " + ((TableRowData) ((javax.swing.tree.DefaultMutableTreeNode) rootNode.getChildAt(i).getChildAt(j).getChildAt(k)).getUserObject()).getIdItemMenu());
                            }
                        }
                    }
                }
            }
            
            @Override
            public void mousePressed(MouseEvent me) {
            }
            
            @Override
            public void mouseReleased(MouseEvent me) {
            }
            
            @Override
            public void mouseEntered(MouseEvent me) {
            }
            
            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
        frame.getContentPane().add(botao);
        frame.setSize(new java.awt.Dimension(400, 400));
        frame.setLocation(280, 50);
        frame.setIconImage(icon);
        frame.setVisible(true);
    }
    
    private void configureCommonTableProperties(JXTable table) {
        table.setColumnControlVisible(true);
        StringValue toString = new StringValue() {
            
            @Override
            public String getString(Object value) {
                if (value instanceof Point) {
                    Point p = (Point) value;
                    return createString(p.x, p.y);
                } else if (value instanceof Dimension) {
                    Dimension dim = (Dimension) value;
                    return createString(dim.width, dim.height);
                }
                return "";
            }
            
            private String createString(int width, int height) {
                return "(" + width + ", " + height + ")";
            }
        };
        TableCellRenderer renderer = new DefaultTableRenderer(toString);
        table.setDefaultRenderer(Point.class, renderer);
        table.setDefaultRenderer(Dimension.class, renderer);
    }
}
