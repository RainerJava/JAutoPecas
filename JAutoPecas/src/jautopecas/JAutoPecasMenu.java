package jautopecas;

import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.login.LoginPermissaoPessoaDao;
import jautopecas.entidades.menu.ItemMenu;
import jautopecas.entidades.pessoa.login.LoginPermissaoPessoa;
import jautopecas.entidades.pessoa.login.LoginPessoa;
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
    private LoginPessoa pessoaLogin;
    private static List<LoginPermissaoPessoa> listaPermissaoUsuario = new ArrayList<>();
    private static HashMap<String, WindowCrud> janelas = new HashMap<>();

    public JAutoPecasMenu(LoginPessoa pessoaLogin) {
        this.pessoaLogin = pessoaLogin;
        initComponents();
        crialistaPermissaoUsuario();
    }

    private void crialistaPermissaoUsuario() {
        listaPermissaoUsuario.clear();
        listaPermissaoUsuario.addAll(new LoginPermissaoPessoaDao().listaPermissaoUsuario(pessoaLogin.getIdLoginPessoa()));

        String idItemMenuPai = null;
        String idItemSubMenu = null;
        JMenu jMenuPrincipal = null;
        JMenu jMenuSubMenu = null;
        JMenuItem jMenuItem;
        for (int i = 0; i < listaPermissaoUsuario.size(); i++) {
            if (listaPermissaoUsuario.get(i).getItemMenu().getTipoItem().equals(ItemMenu.MENU)) {
                jMenuPrincipal = new JMenu();
                jMenuPrincipal.setText(listaPermissaoUsuario.get(i).getItemMenu().getNome());
                if (listaPermissaoUsuario.get(i).getItemMenu().getCaminhoImagem() != null) {
                    jMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource(listaPermissaoUsuario.get(i).getItemMenu().getCaminhoImagem())));
                }
                jMenuPrincipal.setEnabled(listaPermissaoUsuario.get(i).getVisualizar());
                jMenuBar2.add(jMenuPrincipal);
                idItemMenuPai = listaPermissaoUsuario.get(i).getItemMenu().getIdItemMenu();
            } else if (listaPermissaoUsuario.get(i).getItemMenu().getTipoItem().equals(ItemMenu.SUBMENU)) {
                if (listaPermissaoUsuario.get(i).getItemMenu().getIdItemMenu().startsWith(idItemMenuPai)) {
                    jMenuSubMenu = new JMenu();
                    jMenuSubMenu.setText(listaPermissaoUsuario.get(i).getItemMenu().getNome());
                    if (listaPermissaoUsuario.get(i).getItemMenu().getCaminhoImagem() != null) {
                        jMenuSubMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource(listaPermissaoUsuario.get(i).getItemMenu().getCaminhoImagem())));
                    }
                    jMenuSubMenu.setEnabled(listaPermissaoUsuario.get(i).getVisualizar());
                    jMenuPrincipal.add(jMenuSubMenu);
                    idItemSubMenu = listaPermissaoUsuario.get(i).getItemMenu().getIdItemMenu();
                } else {
                    jMenuSubMenu = null;
                }
            } else if (listaPermissaoUsuario.get(i).getItemMenu().getTipoItem().equals(ItemMenu.JANELA)) {
                jMenuItem = new JMenuItem();
                jMenuItem.setText(listaPermissaoUsuario.get(i).getItemMenu().getNome());
                jMenuItem.addActionListener(new JAutoPecasMenuActionListener(listaPermissaoUsuario.get(i).getItemMenu()));
                jMenuItem.setEnabled(listaPermissaoUsuario.get(i).getVisualizar());
                if (listaPermissaoUsuario.get(i).getItemMenu().getCaminhoImagem() != null) {
                    jMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource(listaPermissaoUsuario.get(i).getItemMenu().getCaminhoImagem())));
                }
                if (idItemSubMenu != null && listaPermissaoUsuario.get(i).getItemMenu().getIdItemMenu().startsWith(idItemSubMenu)) {
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
    public static List<LoginPermissaoPessoa> getlistaPermissaoUsuario() {
        return listaPermissaoUsuario;
    }

    public static ItemMenu getItemMenu(String classeFormulario) {
        ItemMenu itemMenu = null;
        for (Iterator<LoginPermissaoPessoa> it = listaPermissaoUsuario.iterator(); it.hasNext();) {
            itemMenu = it.next().getItemMenu();
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
