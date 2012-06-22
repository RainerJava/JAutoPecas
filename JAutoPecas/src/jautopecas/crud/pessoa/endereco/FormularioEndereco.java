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
    private int countErrosFormulario;
    private UtilFormulario utilFormulario = new UtilFormulario();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlUf = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEnderecos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jbSalvar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jtfLogradouro = new jautopecas.components.JFTextField();
        jtfNumero = new jautopecas.components.JFTextField();
        jtfUf = new jautopecas.components.JFTextField();
        jtfCidade = new jautopecas.components.JFTextField();
        jtfBairro = new jautopecas.components.JFTextField();
        jcbTipoLogradpuro = new jautopecas.components.JFComboBox();
        jtfCep = new jautopecas.components.JFTextField();
        jcbTipoEndereco = new jautopecas.components.JFComboBox();

        jLabel1.setText("Tipo Logradouro");

        jLabel2.setText("Logradouro");

        jLabel3.setText("Numero");

        jLabel4.setText("Cep");

        jLabel5.setText("Bairro");

        jLabel6.setText("Cidade");

        jlUf.setText("Estado");

        jtEnderecos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtEnderecos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtEnderecos);

        jLabel8.setText("Tipo Endereço");

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

        jtfLogradouro.setMensagemAjuda("Logradouro");
        jtfLogradouro.setValidador(new ValidadorStringLength(jtfLogradouro, 10, 150));

        jtfNumero.setMensagemAjuda("Numero, Caso seja sem numero informar S/N");
        jtfNumero.setValidador(new ValidadorStringLength(jtfNumero, 1, 10));

        jtfUf.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioEstado");
        jtfUf.setMensagemAjuda("Estado");

        jtfCidade.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioCidade");
        jtfCidade.setMensagemAjuda("Cidade");

        jtfBairro.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioBairro");
        jtfBairro.setMensagemAjuda("Bairro");

        jcbTipoLogradpuro.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioTipoLogradouro");
        jcbTipoLogradpuro.setMensagemAjuda("Tipo de logradouro. EX:. Rua, Avenida, Viela, Etc...");

        jtfCep.setMensagemAjuda("Codigo de endereçamento postal");
        jtfCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfCepFocusLost(evt);
            }
        });

        jcbTipoEndereco.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioTipoEndereco");
        jcbTipoEndereco.setMensagemAjuda("Tipo de endereço. EX:. Comercial,Residencial,Faturamento,Etc...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(90, 90, 90)
                                .addComponent(jLabel8))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(122, 122, 122)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jtfCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jcbTipoLogradpuro, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                            .addComponent(jtfCep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jtfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jcbTipoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jlUf)
                                        .addGap(61, 61, 61))
                                    .addComponent(jtfUf, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                    .addComponent(jtfNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbSalvar)
                        .addGap(6, 6, 6)
                        .addComponent(jbLimpar)
                        .addGap(6, 6, 6)
                        .addComponent(jbExcluir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTipoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbTipoLogradpuro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlUf)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbSalvar)
                    .addComponent(jbLimpar)
                    .addComponent(jbExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            if (utilFormulario.validarFormulario(this, true, countErrosFormulario) <= 0) {
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbSalvar;
    private jautopecas.components.JFComboBox jcbTipoEndereco;
    private jautopecas.components.JFComboBox jcbTipoLogradpuro;
    private javax.swing.JLabel jlUf;
    private javax.swing.JTable jtEnderecos;
    private jautopecas.components.JFTextField jtfBairro;
    private jautopecas.components.JFTextField jtfCep;
    private jautopecas.components.JFTextField jtfCidade;
    private jautopecas.components.JFTextField jtfLogradouro;
    private jautopecas.components.JFTextField jtfNumero;
    private jautopecas.components.JFTextField jtfUf;
    // End of variables declaration//GEN-END:variables
}
