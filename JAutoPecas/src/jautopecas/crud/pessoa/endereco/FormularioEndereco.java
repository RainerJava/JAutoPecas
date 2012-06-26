package jautopecas.crud.pessoa.endereco;

import jautopecas.components.validadores.ValidadorStringLength;
import jautopecas.dao.pessoa.endereco.TipoEnderecoDao;
import jautopecas.dao.pessoa.endereco.TipoLogradouroDao;
import jautopecas.entidades.pessoa.endereco.*;
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
public class FormularioEndereco extends javax.swing.JPanel {

    private FormularioEnderecoTableModel tableModel;
    private List<EnderecoPessoa> listaEnderecoPessoa;
    private EnderecoPessoa enderecoPessoa;
    private boolean formularioBloqueado;

    /**
     * Creates new form CadEnderecoGUI
     */
    public FormularioEndereco() {
        initComponents();

        jtEnderecos.setModel(tableModel == null ? new FormularioEnderecoTableModel() : tableModel);
        jtEnderecos.addMouseListener(
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

    private EnderecoPessoa getObjetoFormulario() {
        if (enderecoPessoa == null) {
            enderecoPessoa = new EnderecoPessoa();
            enderecoPessoa.setEndereco(new Endereco());
        }
        enderecoPessoa.getEndereco().setUf((Estado) jtfUf.getObjeto());
        enderecoPessoa.getEndereco().setBairro((Bairro) jtfBairro.getObjeto());
        enderecoPessoa.getEndereco().setCidade((Cidade) jtfCidade.getObjeto());
        enderecoPessoa.getEndereco().setCep(jtfCep.getText());
        enderecoPessoa.getEndereco().setLogradouro(jtfLogradouro.getText());
        enderecoPessoa.getEndereco().setTipoLogradouro((TipoLogradouro) jcbTipoLogradpuro.getSelectedItem());
        enderecoPessoa.getEndereco().setNumero(jtfNumero.getText());
        enderecoPessoa.getEndereco().setTipoEndereco((TipoEndereco) jcbTipoEndereco.getSelectedItem());
        return enderecoPessoa;
    }

    private void setObjetoFormulario(EnderecoPessoa objetoFormulario) throws Exception {
        try {
            jtfLogradouro.setText(objetoFormulario.getEndereco().getLogradouro());
            jtfUf.setObjeto(objetoFormulario.getEndereco().getUf());
            jtfCidade.setObjeto(objetoFormulario.getEndereco().getCidade());
            jtfBairro.setObjeto(objetoFormulario.getEndereco().getBairro());
            jtfNumero.setText(objetoFormulario.getEndereco().getNumero());
            jtfCep.setText(objetoFormulario.getEndereco().getCep());
            jcbTipoLogradpuro.setSelectedItem(objetoFormulario.getEndereco().getTipoLogradouro());
            jcbTipoEndereco.setSelectedItem(objetoFormulario.getEndereco().getTipoEndereco());
        } catch (Exception ex) {
            throw new Exception("Erro ao carregar os dados do formulario", ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtfBairro = new jautopecas.components.JTextField();
        jlUf = new javax.swing.JLabel();
        jtfNumero = new jautopecas.components.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfLogradouro = new jautopecas.components.JTextField();
        jtfCidade = new jautopecas.components.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfUf = new jautopecas.components.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbTipoLogradpuro = new jautopecas.components.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfCep = new jautopecas.components.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbSalvar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jcbTipoEndereco = new jautopecas.components.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEnderecos = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(650, 300));
        setLayout(new java.awt.BorderLayout());

        jtfBairro.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioBairro");
        jtfBairro.setMensagemAjuda("Bairro");

        jlUf.setText("Estado");

        jtfNumero.setMensagemAjuda("Numero, Caso seja sem numero informar S/N");
        jtfNumero.setValidador(new ValidadorStringLength(jtfNumero, 1, 10));

        jLabel6.setText("Cidade");

        jLabel5.setText("Bairro");

        jtfLogradouro.setMensagemAjuda("Logradouro");
        jtfLogradouro.setValidador(new ValidadorStringLength(jtfLogradouro, 10, 150));

        jtfCidade.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioCidade");
        jtfCidade.setMensagemAjuda("Cidade");

        jLabel4.setText("Cep");

        jtfUf.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioEstado");
        jtfUf.setMensagemAjuda("Estado");

        jLabel3.setText("Numero");

        jcbTipoLogradpuro.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioTipoLogradouro");
        jcbTipoLogradpuro.setMensagemAjuda("Tipo de logradouro. EX:. Rua, Avenida, Viela, Etc...");

        jLabel1.setText("Tipo Logradouro");

        jLabel8.setText("Tipo Endereço");

        jtfCep.setMensagemAjuda("Codigo de endereçamento postal");
        jtfCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfCepFocusLost(evt);
            }
        });

        jLabel2.setText("Logradouro");

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

        jcbTipoEndereco.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioTipoEndereco");
        jcbTipoEndereco.setMensagemAjuda("Tipo de endereço. EX:. Comercial,Residencial,Faturamento,Etc...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlUf)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbExcluir))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2)
                                    .addComponent(jcbTipoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfUf, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jcbTipoLogradpuro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(88, 96, Short.MAX_VALUE))
                                            .addComponent(jtfNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE))
                                            .addComponent(jtfBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTipoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoLogradpuro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlUf)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbExcluir)
                    .addComponent(jbSalvar)
                    .addComponent(jbLimpar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(2, 110));

        jtEnderecos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtEnderecos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtEnderecos);

        add(jScrollPane1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCepFocusLost
        try {
            Object[] options = {"Sim", "Não"};
            if (JOptionPane.showOptionDialog(null, "Deseja buscar o CEP automaticamente?", "Informação",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]) == 0) {
                enderecoPessoa = null;
                enderecoPessoa = new EnderecoPessoa();
                enderecoPessoa.setEndereco(CepService.getEndereco(jtfCep.getText()));
                if (enderecoPessoa.getEndereco() != null) {
                    jtfBairro.setObjeto(enderecoPessoa.getEndereco().getBairro());
                    jtfCidade.setObjeto(enderecoPessoa.getEndereco().getCidade());
                    jtfUf.setObjeto(enderecoPessoa.getEndereco().getUf());
                    jtfLogradouro.setText(enderecoPessoa.getEndereco().getLogradouro());
                    jcbTipoLogradpuro.setSelectedItem(enderecoPessoa.getEndereco().getTipoLogradouro());
                    jtfNumero.requestFocus();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtfCepFocusLost

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            if (UtilFormulario.validarFormulario(this) <= 0) {
                if (jtEnderecos.getSelectedRowCount() <= 0) {
                    if (listaEnderecoPessoa == null) {
                        listaEnderecoPessoa = new ArrayList<>();
                    }
                    listaEnderecoPessoa.add(getObjetoFormulario());
                } else {
                    listaEnderecoPessoa.set(jtEnderecos.getSelectedRow(), getObjetoFormulario());
                }
                populaListaEnderecos();
            }
        } catch (UtilFormularioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        Object[] options = {"Sim", "Não"};
        if (JOptionPane.showOptionDialog(null, "Deseja Excluir o endereço selecionado?", "Atenção",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]) == 0) {
            listaEnderecoPessoa.remove(jtEnderecos.getSelectedRow());
            populaListaEnderecos();
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        onLimpar();
    }//GEN-LAST:event_jbLimparActionPerformed

    public void onLimpar() {
        enderecoPessoa = null;
        jtfCep.limpaCampo();
        jtfLogradouro.limpaCampo();
        jtfNumero.limpaCampo();
        jtfBairro.limpaCampo();
        jtfCidade.limpaCampo();
        jtfUf.limpaCampo();
        jtEnderecos.clearSelection();
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
            jtfCep.setEditable(!formularioBloqueado);
            jtfLogradouro.setEditable(!formularioBloqueado);
            jtfNumero.setEditable(!formularioBloqueado);
            jtfBairro.setEditable(!formularioBloqueado);
            jtfCidade.setEditable(!formularioBloqueado);
            jtfUf.setEditable(!formularioBloqueado);
            jcbTipoEndereco.setEnabled(!formularioBloqueado);
            jcbTipoLogradpuro.setEnabled(!formularioBloqueado);
            jbSalvar.setEnabled(!formularioBloqueado);
            jbLimpar.setEnabled(!formularioBloqueado);
            jbExcluir.setEnabled(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onVisualizar() throws Exception {

        enderecoPessoa = ((FormularioEnderecoTableModel) jtEnderecos.getModel()).buscaProduto(jtEnderecos.getSelectedRow());
        setObjetoFormulario(enderecoPessoa);
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

    private void populaListaEnderecos() {
        ((FormularioEnderecoTableModel) jtEnderecos.getModel()).removeResultado();
        ((FormularioEnderecoTableModel) jtEnderecos.getModel()).mostraResultado(listaEnderecoPessoa);
        onLimpar();
    }

    public void carregaCombos() {
        jcbTipoLogradpuro.setDataSet(new TipoLogradouroDao().listarTodos());
        jcbTipoEndereco.setDataSet(new TipoEnderecoDao().listarTodos());
    }

    public List<EnderecoPessoa> getListaEnderecoPessoa() {
        return listaEnderecoPessoa;
    }

    public void setListaEnderecoPessoa(List<EnderecoPessoa> listaEnderecoPessoa) {
        this.listaEnderecoPessoa = listaEnderecoPessoa;
        populaListaEnderecos();
    }

    public JTable getJtEnderecos() {
        return jtEnderecos;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbSalvar;
    private jautopecas.components.JComboBox jcbTipoEndereco;
    private jautopecas.components.JComboBox jcbTipoLogradpuro;
    private javax.swing.JLabel jlUf;
    private javax.swing.JTable jtEnderecos;
    private jautopecas.components.JTextField jtfBairro;
    private jautopecas.components.JTextField jtfCep;
    private jautopecas.components.JTextField jtfCidade;
    private jautopecas.components.JTextField jtfLogradouro;
    private jautopecas.components.JTextField jtfNumero;
    private jautopecas.components.JTextField jtfUf;
    // End of variables declaration//GEN-END:variables
}
