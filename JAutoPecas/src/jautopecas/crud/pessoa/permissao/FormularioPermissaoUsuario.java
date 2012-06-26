package jautopecas.crud.pessoa.permissao;

import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.login.LoginPermissaoPessoaDao;
import jautopecas.entidades.Grupo;
import jautopecas.entidades.menu.ItemMenu;
import jautopecas.entidades.pessoa.login.LoginPermissaoPessoa;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.tree.DefaultMutableTreeNode;
import org.jdesktop.swingx.JXTreeTable;
import org.jdesktop.swingx.decorator.Highlighter;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import teste.MyTreeModel;
import teste.TreeCellEditor;

/**
 *
 * @author JFFiorotto
 */
public class FormularioPermissaoUsuario extends javax.swing.JPanel implements IFormulario {

    private DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode();
    List<LoginPermissaoPessoa> listaPermissaoUsuario;

    /**
     * Creates new form formularioEmpresa
     */
    public FormularioPermissaoUsuario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        binTree = new JXTreeTable(new MyTreeModel(rootNode));
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(260, 108));

        jScrollPane1.setViewportView(binTree);

        jButton1.setText("Listar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 451, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            for (int i = 0; i < listaPermissaoUsuario.size(); i++) {
                System.out.println(listaPermissaoUsuario.get(i).toString());
                if (listaPermissaoUsuario.get(i).getIdLoginPermissaoPessoa() == null) {
                    new LoginPermissaoPessoaDao().salvar(((LoginPermissaoPessoa) listaPermissaoUsuario.get(i)));
                } else {
                    new LoginPermissaoPessoaDao().alterar(((LoginPermissaoPessoa) listaPermissaoUsuario.get(i)));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String idItemMenuPai = null;
        String idItemSubMenu = null;
        DefaultMutableTreeNode incomeNode = null;
        DefaultMutableTreeNode incomeNode2 = null;
        DefaultMutableTreeNode incomeNode3;

        listaPermissaoUsuario = new LoginPermissaoPessoaDao().listaLoginPermissaoPessoa(1);
        for (int i = 0; i < listaPermissaoUsuario.size(); i++) {
            if (listaPermissaoUsuario.get(i).getItemMenu().getTipoItem().equals(ItemMenu.MENU)) {
                incomeNode = new DefaultMutableTreeNode(listaPermissaoUsuario.get(i));
                rootNode.add(incomeNode);
                idItemMenuPai = listaPermissaoUsuario.get(i).getItemMenu().getIdItemMenu();
            } else if (listaPermissaoUsuario.get(i).getItemMenu().getTipoItem().equals(ItemMenu.SUBMENU)) {
                if (listaPermissaoUsuario.get(i).getItemMenu().getIdItemMenu().startsWith(idItemMenuPai)) {
                    incomeNode2 = new DefaultMutableTreeNode(listaPermissaoUsuario.get(i));
                    incomeNode.add(incomeNode2);
                    idItemSubMenu = listaPermissaoUsuario.get(i).getItemMenu().getIdItemMenu();
                } else {
                    incomeNode2 = null;
                }
            } else if (listaPermissaoUsuario.get(i).getItemMenu().getTipoItem().equals(ItemMenu.JANELA)) {
                incomeNode3 = new DefaultMutableTreeNode(listaPermissaoUsuario.get(i));
                if (idItemSubMenu != null && listaPermissaoUsuario.get(i).getItemMenu().getIdItemMenu().startsWith(idItemSubMenu)) {
                    incomeNode2.add(incomeNode3);
                } else {
                    incomeNode.add(incomeNode3);
                }
            }
        }
        binTree.expandAll();

        Highlighter highligher = HighlighterFactory.createSimpleStriping(HighlighterFactory.BEIGE);
        binTree.setHighlighters(highligher);
        binTree.setShowGrid(false);
        binTree.setShowsRootHandles(false);
        //configureCommonTableProperties(binTree);
        //binTree.setTreeCellRenderer(new TreeTableCellRenderer());
        binTree.getColumnModel().getColumn(2).setCellEditor(new TreeCellEditor(binTree));
        binTree.getColumnModel().getColumn(3).setCellEditor(new TreeCellEditor(binTree));
        binTree.getColumnModel().getColumn(4).setCellEditor(new TreeCellEditor(binTree));
        binTree.getColumnModel().getColumn(5).setCellEditor(new TreeCellEditor(binTree));
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXTreeTable binTree;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private LoginPermissaoPessoa permissaoUsuario;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
    }

    @Override
    public void salvar() throws Exception {
    }

    @Override
    public void alterar() throws Exception {
    }

    @Override
    public void excluir() throws Exception {
    }

    @Override
    public Grupo getObjetoFormulario() throws Exception {
        return null;
    }

    @Override
    public MensagemRodape getMensagemRodape() {
        if (getTopLevelAncestor() instanceof WindowCrud) {
            return ((WindowCrud) getTopLevelAncestor()).getMensagemRodape();
        }
        return null;
    }

    @Override
    public List pesquisar(String strPesquisa) throws Exception {
        return new LoginPermissaoPessoaDao().listarTodos();
    }
}
