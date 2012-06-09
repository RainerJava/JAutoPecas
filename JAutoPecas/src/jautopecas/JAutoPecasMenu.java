package jautopecas;

import jautopecas.crud.WindowCrud;
import jautopecas.dao.menu.ItemMenuDao;
import jautopecas.entidades.menu.ItemMenu;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author JFFiorotto
 */
public class JAutoPecasMenu extends javax.swing.JFrame {

    /**
     * Creates new form JAutoPecasMenu
     */
    private static List<ItemMenu> itensMenu = new ArrayList<>();
    private static HashMap<String, WindowCrud> janelas = new HashMap<>();

    public JAutoPecasMenu() {
        initComponents();
        criaItensMenu();
    }

    private void criaItensMenu() {
        itensMenu.clear();
        itensMenu.addAll(new ItemMenuDao().listarTodos());

        String idItemMenuPai = null;
        String idItemSubMenu = null;
        JMenu jMenuPrincipal = null;
        JMenu jMenuSubMenu = null;
        JMenuItem jMenuItem;
        for (int i = 0; i < itensMenu.size(); i++) {
            if (itensMenu.get(i).getTipoItem().equals(ItemMenu.MENU)) {
                jMenuPrincipal = new JMenu();
                jMenuPrincipal.setText(itensMenu.get(i).getNome());
                if (itensMenu.get(i).getCaminhoImagem() != null) {
                    jMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource(itensMenu.get(i).getCaminhoImagem())));
                }
                jMenuBar2.add(jMenuPrincipal);
                idItemMenuPai = itensMenu.get(i).getIdItemMenu();
            } else if (itensMenu.get(i).getTipoItem().equals(ItemMenu.SUBMENU)) {
                if (itensMenu.get(i).getIdItemMenu().startsWith(idItemMenuPai)) {
                    jMenuSubMenu = new JMenu();
                    jMenuSubMenu.setText(itensMenu.get(i).getNome());
                    if (itensMenu.get(i).getCaminhoImagem() != null) {
                        jMenuSubMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource(itensMenu.get(i).getCaminhoImagem())));
                    }
                    jMenuPrincipal.add(jMenuSubMenu);
                    idItemSubMenu = itensMenu.get(i).getIdItemMenu();
                } else {
                    jMenuSubMenu = null;
                }
            } else if (itensMenu.get(i).getTipoItem().equals(ItemMenu.JANELA)) {
                jMenuItem = new JMenuItem();
                jMenuItem.setText(itensMenu.get(i).getNome());
                jMenuItem.addActionListener(new JAutoPecasMenuActionListener(itensMenu.get(i)));
                if (itensMenu.get(i).getCaminhoImagem() != null) {
                    jMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource(itensMenu.get(i).getCaminhoImagem())));
                }
                if (idItemSubMenu != null && itensMenu.get(i).getIdItemMenu().startsWith(idItemSubMenu)) {
                    jMenuSubMenu.add(jMenuItem);
                } else {
                    jMenuPrincipal.add(jMenuItem);
                }
            }
        }
    }

    /*
     * Getter's and Setter's
     */
    public static List<ItemMenu> getItensMenu() {
        return itensMenu;
    }

    public static ItemMenu getItemMenu(String classeFormulario) {
        ItemMenu itemMenu = null;
        for (Iterator<ItemMenu> it = itensMenu.iterator(); it.hasNext();) {
            itemMenu = it.next();
            if (itemMenu.getClasseFormulario() != null && itemMenu.getClasseFormulario().equals(classeFormulario)) {
                break;
            }
        }
        return itemMenu;
    }

    public static WindowCrud addJanela(ItemMenu itemMenu) {
        return addJanela(itemMenu, null, null);
    }

    public static WindowCrud addJanela(ItemMenu itemMenu, String modoF1F2, JComponent jComponent) {
        WindowCrud windowCrud;
        if (janelas.containsKey(itemMenu.getIdItemMenu())) {
            windowCrud = janelas.get(itemMenu.getIdItemMenu());
            windowCrud.setModoF1F2(modoF1F2);
            windowCrud.setjComponent(jComponent);
            windowCrud.setVisible(true);
        } else {
            windowCrud = new WindowCrud(itemMenu);
            windowCrud.setModoF1F2(modoF1F2);
            windowCrud.setjComponent(jComponent);
            windowCrud.setVisible(true);
            janelas.put(itemMenu.getIdItemMenu(), windowCrud);
        }
        return windowCrud;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width, 200));
        setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 25));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 2));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Usuario:");
        jPanel2.add(jLabel2);

        jLabel3.setText("Jefferson Pires Fiorotto");
        jPanel2.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Departamento:");
        jPanel2.add(jLabel4);

        jLabel5.setText("T.I");
        jPanel2.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Cargo:");
        jPanel2.add(jLabel6);

        jLabel7.setText("Desenv. Sistemas");
        jPanel2.add(jLabel7);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);
        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
