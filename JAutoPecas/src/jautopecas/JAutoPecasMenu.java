/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas;

import jautopecas.entidades.CadItemMenu;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
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
    private static List<CadItemMenu> itensMenu = new ArrayList<>();
    public JAutoPecasMenu() {
        initComponents();

        CadItemMenu itemCadastro = new CadItemMenu();
        itemCadastro.setIdItemMenu("1");
        itemCadastro.setNomeItem("Cadastro");
        itemCadastro.setImagem("/jautopecas/imagens/icones/iconeCadastro16.png");
        itemCadastro.setTipoItem(CadItemMenu.PRINCIPAL);

        itensMenu.add(itemCadastro);

        CadItemMenu itemCadastroEmpresas = new CadItemMenu();
        itemCadastroEmpresas.setIdItemMenu("1.1");
        itemCadastroEmpresas.setNomeItem("Empresas");
        itemCadastroEmpresas.setImagem("/jautopecas/imagens/icones/iconeEmpresa16.png");
        itemCadastroEmpresas.setCaminho("jautopecas.crud.FormularioEmpresa");
        itemCadastroEmpresas.setTipoItem(CadItemMenu.JANELA);

        itensMenu.add(itemCadastroEmpresas);

        CadItemMenu itemCadastroClientes = new CadItemMenu();
        itemCadastroClientes.setIdItemMenu("1.2");
        itemCadastroClientes.setNomeItem("Clientes");
        itemCadastroClientes.setTipoItem(CadItemMenu.JANELA);

        itensMenu.add(itemCadastroClientes);

        CadItemMenu itemCompras = new CadItemMenu();
        itemCompras.setIdItemMenu("2");
        itemCompras.setNomeItem("Compras");
        itemCompras.setTipoItem(CadItemMenu.PRINCIPAL);

        itensMenu.add(itemCompras);

        CadItemMenu itemComprasIndicacao = new CadItemMenu();
        itemComprasIndicacao.setIdItemMenu("2.1");
        itemComprasIndicacao.setNomeItem("Indicacao");
        itemComprasIndicacao.setTipoItem(CadItemMenu.JANELA);

        itensMenu.add(itemComprasIndicacao);

        CadItemMenu itemComprasRelatorios = new CadItemMenu();
        itemComprasRelatorios.setIdItemMenu("2.2");
        itemComprasRelatorios.setNomeItem("Relatorios");
        itemComprasRelatorios.setTipoItem(CadItemMenu.SUBMENU);

        itensMenu.add(itemComprasRelatorios);

        CadItemMenu itemComprasRelatorio1 = new CadItemMenu();
        itemComprasRelatorio1.setIdItemMenu("2.2.1");
        itemComprasRelatorio1.setNomeItem("Relatorio 01");
        itemComprasRelatorio1.setTipoItem(CadItemMenu.JANELA);

        itensMenu.add(itemComprasRelatorio1);

        CadItemMenu itemComprasRelatorio2 = new CadItemMenu();
        itemComprasRelatorio2.setIdItemMenu("2.2.2");
        itemComprasRelatorio2.setNomeItem("Relatorio 02");
        itemComprasRelatorio2.setTipoItem(CadItemMenu.JANELA);

        itensMenu.add(itemComprasRelatorio2);

        CadItemMenu itemComprasCompradores = new CadItemMenu();
        itemComprasCompradores.setIdItemMenu("2.3");
        itemComprasCompradores.setNomeItem("Compradores");
        itemComprasCompradores.setTipoItem(CadItemMenu.JANELA);

        itensMenu.add(itemComprasCompradores);

        CadItemMenu itemVendas = new CadItemMenu();
        itemVendas.setIdItemMenu("3");
        itemVendas.setNomeItem("Vendas");
        itemVendas.setTipoItem(CadItemMenu.PRINCIPAL);

        itensMenu.add(itemVendas);

        CadItemMenu itemVendasPedidos = new CadItemMenu();
        itemVendasPedidos.setIdItemMenu("3.1");
        itemVendasPedidos.setNomeItem("Pedido de Venda");
        itemVendasPedidos.setTipoItem(CadItemMenu.JANELA);

        itensMenu.add(itemVendasPedidos);

        criaItensMenu();
    }

    private void criaItensMenu() {
        String idItemMenuPai = null;
        String idItemSubMenu = null;
        JMenu jMenuPrincipal = null;
        JMenu jMenuSubMenu = null;
        JMenuItem jMenuItem;
        for (int i = 0; i < itensMenu.size(); i++) {
            if (itensMenu.get(i).getTipoItem().equals(CadItemMenu.PRINCIPAL)) {
                jMenuPrincipal = new JMenu();
                jMenuPrincipal.setText(itensMenu.get(i).getNomeItem());
                if (itensMenu.get(i).getImagem() != null) {
                    jMenuPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource(itensMenu.get(i).getImagem())));
                }
                jMenuBar2.add(jMenuPrincipal);
                idItemMenuPai = itensMenu.get(i).getIdItemMenu();
            } else if (itensMenu.get(i).getTipoItem().equals(CadItemMenu.SUBMENU)) {
                if (itensMenu.get(i).getIdItemMenu().startsWith(idItemMenuPai)) {
                    jMenuSubMenu = new JMenu();
                    jMenuSubMenu.setText(itensMenu.get(i).getNomeItem());
                    if (itensMenu.get(i).getImagem() != null) {
                        jMenuSubMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource(itensMenu.get(i).getImagem())));
                    }
                    jMenuPrincipal.add(jMenuSubMenu);
                    idItemSubMenu = itensMenu.get(i).getIdItemMenu();
                } else {
                    jMenuSubMenu = null;
                }
            } else if (itensMenu.get(i).getTipoItem().equals(CadItemMenu.JANELA)) {
                jMenuItem = new JMenuItem();
                jMenuItem.setText(itensMenu.get(i).getNomeItem());
                jMenuItem.addActionListener(new JAutoPecasMenuActionListener(itensMenu.get(i)));
                if (itensMenu.get(i).getImagem() != null) {
                    jMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource(itensMenu.get(i).getImagem())));
                }
                if (idItemSubMenu != null && itensMenu.get(i).getIdItemMenu().startsWith(idItemSubMenu)) {
                    jMenuSubMenu.add(jMenuItem);
                } else {
                    jMenuPrincipal.add(jMenuItem);
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

        jMenuBar2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jMenuBar2PropertyChange(evt);
            }
        });
        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuBar2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jMenuBar2PropertyChange
        if (evt.getSource().equals("OI")) {
            System.out.println("UHUU");
        }
    }//GEN-LAST:event_jMenuBar2PropertyChange

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
