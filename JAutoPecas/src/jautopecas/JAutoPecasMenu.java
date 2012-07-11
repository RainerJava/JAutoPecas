package jautopecas;

import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.PessoaDao;
import jautopecas.dao.pessoa.colaborador.FuncaoSalarioColaboradorDao;
import jautopecas.dao.pessoa.login.LoginPermissaoPessoaDao;
import jautopecas.entidades.menu.ItemMenu;
import jautopecas.entidades.pessoa.Pessoa;
import jautopecas.entidades.pessoa.colaborador.FuncaoSalarioColaborador;
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
    private static List<Pessoa> listaEmpresas;
    private static Pessoa empresaSelecionada;
    private static LoginPessoa loginPessoa;
    private static List<LoginPermissaoPessoa> listaLoginPermissaoPessoa = new ArrayList<>();
    private static HashMap<String, WindowCrud> janelas = new HashMap<>();

    public JAutoPecasMenu(LoginPessoa login) {
        loginPessoa = login;
        initComponents();
        populaCombos();
        selecionaEmpresaPessoa();
    }

    public void populaDadosColaborador() {
        FuncaoSalarioColaborador funcaoSalarioColaborador = new FuncaoSalarioColaboradorDao().getFuncaoSalarioColaboradorAtual(loginPessoa.getPessoa().getIdPessoa());
        jlLogin.setText(loginPessoa.getLogin());
        jlFuncao.setText(funcaoSalarioColaborador.getFuncao().getNome());
        jlDepartamento.setText(funcaoSalarioColaborador.getFuncao().getDepartamento().getNome());
    }

    public void criaMenuPrincipal() {
        listaLoginPermissaoPessoa.clear();
        listaLoginPermissaoPessoa.addAll(new LoginPermissaoPessoaDao().listaLoginPermissaoPessoa(loginPessoa.getIdLoginPessoa()));

        String idItemMenuPai = null;
        String idItemSubMenu = null;
        JMenu jMenuPrincipal = null;
        JMenu jMenuSubMenu = null;
        JMenuItem jMenuItem;
        for (int i = 0; i < listaLoginPermissaoPessoa.size(); i++) {
            if (listaLoginPermissaoPessoa.get(i).getItemMenu().getTipoItem().equals(ItemMenu.MENU)) {
                jMenuPrincipal = new JMenu();
                jMenuPrincipal.setText(listaLoginPermissaoPessoa.get(i).getItemMenu().getNome());
                if (listaLoginPermissaoPessoa.get(i).getItemMenu().getCaminhoImagem() != null) {
                    jMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource(listaLoginPermissaoPessoa.get(i).getItemMenu().getCaminhoImagem())));
                }
                jMenuPrincipal.setEnabled(listaLoginPermissaoPessoa.get(i).getVisualizar());
                jMenuBar2.add(jMenuPrincipal);
                idItemMenuPai = listaLoginPermissaoPessoa.get(i).getItemMenu().getIdItemMenu();
            } else if (listaLoginPermissaoPessoa.get(i).getItemMenu().getTipoItem().equals(ItemMenu.SUBMENU)) {
                if (listaLoginPermissaoPessoa.get(i).getItemMenu().getIdItemMenu().startsWith(idItemMenuPai)) {
                    jMenuSubMenu = new JMenu();
                    jMenuSubMenu.setText(listaLoginPermissaoPessoa.get(i).getItemMenu().getNome());
                    if (listaLoginPermissaoPessoa.get(i).getItemMenu().getCaminhoImagem() != null) {
                        jMenuSubMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource(listaLoginPermissaoPessoa.get(i).getItemMenu().getCaminhoImagem())));
                    }
                    jMenuSubMenu.setEnabled(listaLoginPermissaoPessoa.get(i).getVisualizar());
                    jMenuPrincipal.add(jMenuSubMenu);
                    idItemSubMenu = listaLoginPermissaoPessoa.get(i).getItemMenu().getIdItemMenu();
                } else {
                    jMenuSubMenu = null;
                }
            } else if (listaLoginPermissaoPessoa.get(i).getItemMenu().getTipoItem().equals(ItemMenu.JANELA)) {
                jMenuItem = new JMenuItem();
                jMenuItem.setText(listaLoginPermissaoPessoa.get(i).getItemMenu().getNome());
                jMenuItem.addActionListener(new JAutoPecasMenuActionListener(listaLoginPermissaoPessoa.get(i).getItemMenu()));
                jMenuItem.setEnabled(listaLoginPermissaoPessoa.get(i).getVisualizar());
                if (listaLoginPermissaoPessoa.get(i).getItemMenu().getCaminhoImagem() != null) {
                    jMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource(listaLoginPermissaoPessoa.get(i).getItemMenu().getCaminhoImagem())));
                }
                if (idItemSubMenu != null && listaLoginPermissaoPessoa.get(i).getItemMenu().getIdItemMenu().startsWith(idItemSubMenu)) {
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
    public static List<LoginPermissaoPessoa> getlistaLoginPermissaoPessoa() {
        return listaLoginPermissaoPessoa;
    }

    public static ItemMenu getItemMenu(String classeFormulario) {
        ItemMenu itemMenu = null;
        for (Iterator<LoginPermissaoPessoa> it = listaLoginPermissaoPessoa.iterator(); it.hasNext();) {
            itemMenu = it.next().getItemMenu();
            if (itemMenu.getClasseFormulario() != null && itemMenu.getClasseFormulario().equals(classeFormulario)) {
                break;
            }
        }
        return itemMenu;
    }

    public static LoginPermissaoPessoa getLoginPermissaoPessoa(ItemMenu itemMenu) {
        LoginPermissaoPessoa loginPermissaoPessoa = null;
        for (Iterator<LoginPermissaoPessoa> it = listaLoginPermissaoPessoa.iterator(); it.hasNext();) {
            loginPermissaoPessoa = it.next();
            if (loginPermissaoPessoa.getIdItemMenu().equals(itemMenu.getIdItemMenu())) {
                break;
            }
        }
        return loginPermissaoPessoa;
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

    public static LoginPessoa getLoginPessoa() {
        return loginPessoa;
    }

    private void populaCombos() {
        try {
            listaEmpresas = new PessoaDao().listaPessoaPorModelo("EM");
            jcbEmpresa.setDataSet(listaEmpresas);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void selecionaEmpresaPessoa() {
        empresaSelecionada = loginPessoa.getPessoa().getAdicionalPessoa().getEmpresa();
        jcbEmpresa.setSelectedItem(empresaSelecionada);
    }

    public static Pessoa getEmpresaSelecionada() {
        return empresaSelecionada;
    }

    public static List<Pessoa> getListaEmpresas() {
        return listaEmpresas;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jcbEmpresa = new jautopecas.components.JComboBox();
        jpDadosColaborador = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jlLogin = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlDepartamento = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlFuncao = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width, 200));
        setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jpDadosColaborador.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpDadosColaborador.setPreferredSize(new java.awt.Dimension(400, 25));
        jpDadosColaborador.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 2));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Login:");
        jpDadosColaborador.add(jLabel2);

        jlLogin.setText("Jefferson Pires Fiorotto");
        jpDadosColaborador.add(jlLogin);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Departamento:");
        jpDadosColaborador.add(jLabel4);

        jlDepartamento.setText("T.I");
        jpDadosColaborador.add(jlDepartamento);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Função:");
        jpDadosColaborador.add(jLabel6);

        jlFuncao.setText("Desenv. Sistemas");
        jpDadosColaborador.add(jlFuncao);

        getContentPane().add(jpDadosColaborador, java.awt.BorderLayout.SOUTH);
        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private jautopecas.components.JComboBox jcbEmpresa;
    private javax.swing.JLabel jlDepartamento;
    private javax.swing.JLabel jlFuncao;
    private javax.swing.JLabel jlLogin;
    private javax.swing.JPanel jpDadosColaborador;
    // End of variables declaration//GEN-END:variables
}
