package jautopecas.crud.pessoa.telefone;

import jautopecas.components.validadores.ValidadorStringLength;
import jautopecas.dao.pessoa.telefone.TipoTelefoneDao;
import jautopecas.entidades.pessoa.telefone.Telefone;
import jautopecas.entidades.pessoa.telefone.TelefonePessoa;
import jautopecas.entidades.pessoa.telefone.TipoTelefone;
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
public class FormularioTelefone extends javax.swing.JPanel {

    private FormularioTelefoneTableModel tableModel;
    private List<TelefonePessoa> listaTelefonePessoa;
    private TelefonePessoa telefonePessoa;
    private boolean formularioBloqueado;

    /**
     * Creates new form CadEnderecoGUI
     */
    public FormularioTelefone() {
        initComponents();

        jtTelefones.setModel(tableModel == null ? new FormularioTelefoneTableModel() : tableModel);
        jtTelefones.addMouseListener(
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

    private TelefonePessoa getObjetoFormulario() {
        if (telefonePessoa == null) {
            telefonePessoa = new TelefonePessoa();
            telefonePessoa.setTelefone(new Telefone());
        }
        telefonePessoa.getTelefone().setTelefone(jtfTelefone.getText());
        telefonePessoa.getTelefone().setTipoTelefone((TipoTelefone) jcbTipoTelefone.getSelectedItem());
        return telefonePessoa;
    }

    private void setObjetoFormulario(TelefonePessoa objetoFormulario) throws Exception {
        try {
            jtfTelefone.setText(objetoFormulario.getTelefone().getTelefone());
            jcbTipoTelefone.setSelectedItem(objetoFormulario.getTelefone().getTipoTelefone());
        } catch (Exception ex) {
            throw new Exception("Erro ao carregar os dados do formulario", ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcbTipoTelefone = new jautopecas.components.JFComboBox();
        jlTipoTelefone = new javax.swing.JLabel();
        jlTelefone = new javax.swing.JLabel();
        jtfTelefone = new jautopecas.components.JFTextField();
        jbSalvar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaObservacao = new javax.swing.JTextArea();
        jlObservacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTelefones = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(650, 300));
        setLayout(new java.awt.BorderLayout());

        jcbTipoTelefone.setClasseFormulario("jautopecas.crud.pessoa.telefone.FormularioTipoTelefone");
        jcbTipoTelefone.setMensagemAjuda("Tipo de telefone. EX:. Comercial,Residencial,Etc...");

        jlTipoTelefone.setText("Tipo Telefone");

        jlTelefone.setText("Telefone");

        try {
            jtfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfTelefone.setMensagemAjuda("Telefone");
        jtfTelefone.setValidador(new ValidadorStringLength(jtfTelefone, 10, 150));

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

        jtaObservacao.setColumns(20);
        jtaObservacao.setRows(5);
        jScrollPane2.setViewportView(jtaObservacao);

        jlObservacao.setText("Obervação");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbTipoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlTipoTelefone))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlTelefone)
                                    .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jlObservacao)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbExcluir)))
                        .addGap(0, 328, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTipoTelefone)
                    .addComponent(jlTelefone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlObservacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbSalvar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbLimpar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbExcluir, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(2, 110));

        jtTelefones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtTelefones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtTelefones);

        add(jScrollPane1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            if (UtilFormulario.validarFormulario(this) <= 0) {
                if (jtTelefones.getSelectedRowCount() <= 0) {
                    if (listaTelefonePessoa == null) {
                        listaTelefonePessoa = new ArrayList<>();
                    }
                    listaTelefonePessoa.add(getObjetoFormulario());
                } else {
                    listaTelefonePessoa.set(jtTelefones.getSelectedRow(), getObjetoFormulario());
                }
                populaListaTelefones();
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
        if (JOptionPane.showOptionDialog(null, "Deseja Excluir o telefone selecionado?", "Atenção",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]) == 0) {
            listaTelefonePessoa.remove(jtTelefones.getSelectedRow());
            populaListaTelefones();
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    public void onLimpar() {
        telefonePessoa = null;
        jtfTelefone.limpaCampo();
        jtTelefones.clearSelection();
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
            jtfTelefone.setEditable(!formularioBloqueado);
            jcbTipoTelefone.setEnabled(!formularioBloqueado);
            jbSalvar.setEnabled(!formularioBloqueado);
            jbLimpar.setEnabled(!formularioBloqueado);
            jbExcluir.setEnabled(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onVisualizar() throws Exception {

        telefonePessoa = ((FormularioTelefoneTableModel) jtTelefones.getModel()).buscaTelefone(jtTelefones.getSelectedRow());
        setObjetoFormulario(telefonePessoa);
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

    private void populaListaTelefones() {
        ((FormularioTelefoneTableModel) jtTelefones.getModel()).removeResultado();
        ((FormularioTelefoneTableModel) jtTelefones.getModel()).mostraResultado(listaTelefonePessoa);
        onLimpar();
    }

    public void carregaCombos() {
        jcbTipoTelefone.setDataSet(new TipoTelefoneDao().listarTodos());
    }

    public List<TelefonePessoa> getListaTelefonePessoa() {
        return listaTelefonePessoa;
    }

    public void setListaTelefonePessoa(List<TelefonePessoa> listaTelefonePessoa) {
        this.listaTelefonePessoa = listaTelefonePessoa;
        populaListaTelefones();
    }

    public JTable getJtTelefones() {
        return jtTelefones;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbSalvar;
    private jautopecas.components.JFComboBox jcbTipoTelefone;
    private javax.swing.JLabel jlObservacao;
    private javax.swing.JLabel jlTelefone;
    private javax.swing.JLabel jlTipoTelefone;
    private javax.swing.JTable jtTelefones;
    private javax.swing.JTextArea jtaObservacao;
    private jautopecas.components.JFTextField jtfTelefone;
    // End of variables declaration//GEN-END:variables
}
