package jautopecas.crud.pessoa.login;

import jautopecas.components.validadores.ValidadorSenha;
import jautopecas.entidades.pessoa.login.LoginPessoa;
import jautopecas.exceptions.UtilFormularioException;
import jautopecas.util.UtilFormulario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author JFFiorotto
 */
public class FormularioLogin extends javax.swing.JPanel {

    private FormularioLoginTableModel tableModel;
    private List<LoginPessoa> listaLoginPessoa;
    private LoginPessoa loginPessoa;
    private boolean formularioBloqueado;

    /**
     * Creates new form CadEnderecoGUI
     */
    public FormularioLogin() {
        initComponents();

        jtLogins.setModel(tableModel == null ? new FormularioLoginTableModel() : tableModel);
        jtLogins.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) {
                            try {
                                onVisualizar();
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                });
    }

    private LoginPessoa getObjetoFormulario() {
        if (loginPessoa == null) {
            loginPessoa = new LoginPessoa();
        }
        loginPessoa.setLogin(jtfLogin.getText());
        loginPessoa.setSenha(jpfSenha.getSelectedText());
        loginPessoa.setStatus("A");
        return loginPessoa;
    }

    private void setObjetoFormulario(LoginPessoa objetoFormulario) throws Exception {
        try {
            jtfLogin.setText(objetoFormulario.getLogin());
            jpfSenha.setText(objetoFormulario.getSenha());
            jpfSenha.setText(objetoFormulario.getSenha());

        } catch (Exception ex) {
            throw new Exception("Erro ao carregar os dados do formulario", ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlLogin = new javax.swing.JLabel();
        jtfLogin = new jautopecas.components.JFTextField();
        jlSenha = new javax.swing.JLabel();
        jpfSenha = new jautopecas.components.JPasswordField();
        jpfConfirmaSenha = new jautopecas.components.JPasswordField();
        jlConfirmaSenha = new javax.swing.JLabel();
        jbSalvar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLogins = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(650, 300));
        setLayout(new java.awt.BorderLayout());

        jlLogin.setText("Login");

        jtfLogin.setMensagemAjuda("Numero, Caso seja sem numero informar S/N");

        jlSenha.setText("Senha");

        jpfSenha.setValidador(new ValidadorSenha(jpfSenha, jpfConfirmaSenha));

        jpfConfirmaSenha.setValidador(new ValidadorSenha(jpfSenha, jpfConfirmaSenha));

        jlConfirmaSenha.setText("Confirma Senha");

        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeConfirmar16.png"))); // NOI18N
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeEditar16.png"))); // NOI18N
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeDeletar16.png"))); // NOI18N
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbExcluir))
                    .addComponent(jlLogin)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlConfirmaSenha)
                            .addComponent(jpfConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jtfLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(308, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlConfirmaSenha)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpfConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbLimpar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbSalvar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbExcluir, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(2, 110));

        jtLogins.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtLogins.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtLogins);

        add(jScrollPane1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            if (UtilFormulario.validarFormulario(this) <= 0) {
                if (jtLogins.getSelectedRowCount() <= 0) {
                    if (listaLoginPessoa == null) {
                        listaLoginPessoa = new ArrayList<>();
                    }
                    listaLoginPessoa.add(getObjetoFormulario());
                } else {
                    listaLoginPessoa.set(jtLogins.getSelectedRow(), getObjetoFormulario());
                }
                populaListaLoginPessoa();
            }
        } catch (UtilFormularioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        onLimpar();
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        Object[] options = {"Sim", "Não"};
        if (JOptionPane.showOptionDialog(null, "Deseja Excluir o login selecionado?", "Atenção",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]) == 0) {
            listaLoginPessoa.remove(jtLogins.getSelectedRow());
            populaListaLoginPessoa();
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    public void onLimpar() {
        loginPessoa = null;
        jtfLogin.limpaCampo();
        jpfSenha.setText("");
        jpfConfirmaSenha.setText("");
        jtLogins.clearSelection();
        if (formularioBloqueado) {
            jbSalvar.setEnabled(false);
            jbLimpar.setEnabled(true);
            jbExcluir.setEnabled(false);
        } else {
            jbSalvar.setEnabled(true);
            jbLimpar.setEnabled(true);
            jbExcluir.setEnabled(false);
        }
    }

    public void onBloquear(boolean formularioBloqueado) {
        try {
            this.formularioBloqueado = formularioBloqueado;
            jtfLogin.setEditable(!formularioBloqueado);
            jpfSenha.setEditable(!formularioBloqueado);
            jpfConfirmaSenha.setEditable(!formularioBloqueado);
            jbSalvar.setEnabled(!formularioBloqueado);
            jbLimpar.setEnabled(!formularioBloqueado);
            jbExcluir.setEnabled(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onVisualizar() throws Exception {

        loginPessoa = ((FormularioLoginTableModel) jtLogins.getModel()).buscaProduto(jtLogins.getSelectedRow());
        setObjetoFormulario(loginPessoa);
        if (formularioBloqueado) {
            jbSalvar.setEnabled(false);
            jbLimpar.setEnabled(true);
            jbExcluir.setEnabled(false);
        } else {
            jbSalvar.setEnabled(true);
            jbLimpar.setEnabled(true);
            jbExcluir.setEnabled(true);
        }
    }

    private void populaListaLoginPessoa() {
        ((FormularioLoginTableModel) jtLogins.getModel()).removeResultado();
        ((FormularioLoginTableModel) jtLogins.getModel()).mostraResultado(listaLoginPessoa);
        onLimpar();
    }

    public void carregaCombos() {
//        jcbTipoLogradpuro.setDataSet(new TipoLogradouroDao().listarTodos());
//        jcbTipoEndereco.setDataSet(new TipoEnderecoDao().listarTodos());
    }

    public List<LoginPessoa> getListaLoginPessoa() {
        return listaLoginPessoa;
    }

    public void setListaPessoaLogin(List<LoginPessoa> listaLoginPessoa) {
        this.listaLoginPessoa = listaLoginPessoa;
        populaListaLoginPessoa();
    }

    public JTable getJtlogins() {
        return jtLogins;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JLabel jlConfirmaSenha;
    private javax.swing.JLabel jlLogin;
    private javax.swing.JLabel jlSenha;
    private jautopecas.components.JPasswordField jpfConfirmaSenha;
    private jautopecas.components.JPasswordField jpfSenha;
    private javax.swing.JTable jtLogins;
    private jautopecas.components.JFTextField jtfLogin;
    // End of variables declaration//GEN-END:variables
}
