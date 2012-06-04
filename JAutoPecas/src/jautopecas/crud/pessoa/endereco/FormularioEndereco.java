package jautopecas.crud.pessoa.endereco;

import jautopecas.components.validadores.ValidadorStringLength;
import jautopecas.dao.pessoa.endereco.TipoLogradouroDao;
import jautopecas.entidades.pessoa.Pessoa;
import jautopecas.entidades.pessoa.endereco.*;
import jautopecas.exceptions.UtilFormularioException;
import jautopecas.util.UtilFormulario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JFFiorotto
 */
public class FormularioEndereco extends javax.swing.JPanel {

    private CadEnderecoTableModel tableModel;
    private List<Endereco> enderecos;
    private Endereco endereco;
    private Pessoa pessoa;
    private int countErrosFormulario;
    private UtilFormulario utilFormulario = new UtilFormulario();

    /**
     * Creates new form CadEnderecoGUI
     */
    public FormularioEndereco() {
        initComponents();

        jTable1.setModel(tableModel == null ? new CadEnderecoTableModel() : tableModel);
        jTable1.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) {
                            try {
                                onVisualizar();
                            } catch (Exception ex) {
                            }
                        }
                    }
                });

        TipoLogradouroDao tipoLogradouro = new TipoLogradouroDao();
        jFComboBox1.setDataSet(tipoLogradouro.listarTodos());
    }

    private Endereco getObjetoFormulario() {
        if (endereco == null) {
            endereco = new Endereco();
        }
        endereco.setUf((Estado) jtfUf.getObjeto());
        endereco.setBairro((Bairro) jtfBairro.getObjeto());
        endereco.setCidade((Cidade) jtfCidade.getObjeto());
        endereco.setCep(jtfCep.getText());
        endereco.setLogradouro(jtfLogradouro.getText());
        endereco.setTipoLogradouro((TipoLogradouro) jFComboBox1.getSelectedItem());
        endereco.setNumero(jtfNumero.getText());
        endereco.setPessoa(pessoa);
        return endereco;
    }

    private void setObjetoFormulario(Endereco objetoFormulario) throws Exception {
        try {
            jtfLogradouro.setText(objetoFormulario.getLogradouro());
            jtfUf.setObjeto(objetoFormulario.getUf());
            jtfCidade.setObjeto(objetoFormulario.getCidade());
            jtfBairro.setObjeto(objetoFormulario.getBairro());
            jtfNumero.setText(objetoFormulario.getNumero());
            jtfCep.setText(objetoFormulario.getCep());
            jFComboBox1.setSelectedItem(objetoFormulario.getTipoLogradouro());
        } catch (Exception ex) {
            throw ex;
        }
    }

    /*
     * Geter's and Seter's
     */
    public void setListaEnderecos(List<Endereco> listaEnderecos) {
        this.enderecos = listaEnderecos;
        populaListaEnderecos();
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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
        jTable1 = new javax.swing.JTable();
        jcbTipoEndereco = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jbSalvar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jtfLogradouro = new jautopecas.components.JFTextField();
        jtfNumero = new jautopecas.components.JFTextField();
        jtfUf = new jautopecas.components.JFTextField();
        jtfCidade = new jautopecas.components.JFTextField();
        jtfBairro = new jautopecas.components.JFTextField();
        jFComboBox1 = new jautopecas.components.JFComboBox();
        jtfCep = new jautopecas.components.JFTextField();

        jLabel1.setText("Tipo Logradouro");

        jLabel2.setText("Logradouro");

        jLabel3.setText("Numero");

        jLabel4.setText("Cep");

        jLabel5.setText("Bairro");

        jLabel6.setText("Cidade");

        jlUf.setText("Estado");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jcbTipoEndereco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Comercial", "Residencial", "Faturamento", "Entrega" }));

        jLabel8.setText("Tipo Endereço");

        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeConfirmar24.png"))); // NOI18N
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeLimpar24.png"))); // NOI18N
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeDeletar24.png"))); // NOI18N
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jtfLogradouro.setMensagemAjuda("Logradouro");
        jtfLogradouro.setValidador(new ValidadorStringLength(jtfLogradouro, 10, 150));

        jtfNumero.setMensagemAjuda("Numero");
        jtfNumero.setValidador(new ValidadorStringLength(jtfNumero, 1, 10));

        jtfUf.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioEstado");
        jtfUf.setMensagemAjuda("Codigo de endereçamento postal");
        jtfUf.setValidador(new ValidadorStringLength(jtfCep, 8, 8));

        jtfCidade.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioCidade");
        jtfCidade.setMensagemAjuda("Codigo de endereçamento postal");
        jtfCidade.setValidador(new ValidadorStringLength(jtfCep, 8, 8));

        jtfBairro.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioBairro");
        jtfBairro.setMensagemAjuda("Codigo de endereçamento postal");
        jtfBairro.setValidador(new ValidadorStringLength(jtfCep, 8, 8));

        jFComboBox1.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioTipoLogradouro");

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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2)
                                .addGap(349, 349, 349)
                                .addComponent(jLabel3))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(122, 122, 122)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jtfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jFComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                            .addComponent(jtfCep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jcbTipoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jtfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlUf)
                                        .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtfUf, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSalvar)
                        .addGap(6, 6, 6)
                        .addComponent(jbLimpar)
                        .addGap(6, 6, 6)
                        .addComponent(jbExcluir)))
                .addContainerGap())
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
                    .addComponent(jcbTipoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbSalvar)
                    .addComponent(jbLimpar)
                    .addComponent(jbExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            if (utilFormulario.validarFormulario(this, true, countErrosFormulario) <= 0) {
                Endereco endereco = getObjetoFormulario();
                if (endereco.getIdEndereco() == null) {
                    enderecos.add(endereco);
                } else {
                    enderecos.set(jTable1.getSelectedRow(), endereco);
                }

                populaListaEnderecos();
            }
        } catch (UtilFormularioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        enderecos.remove(jTable1.getSelectedRow());
        populaListaEnderecos();
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        onLimpar();
    }//GEN-LAST:event_jbLimparActionPerformed

    public void onLimpar() {
        try {
            jtfCep.limpaCampo();
            jtfLogradouro.limpaCampo();
            jtfNumero.limpaCampo();
            jtfBairro.limpaCampo();
            jtfCidade.limpaCampo();
            jtfUf.limpaCampo();
            jbSalvar.setEnabled(false);
            jbLimpar.setEnabled(false);
            jbExcluir.setEnabled(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public void onBloquear(boolean bloqueia) {
        try {
            jtfCep.setEditable(bloqueia);
            jtfLogradouro.setEditable(bloqueia);
            jtfNumero.setEditable(bloqueia);
            jtfBairro.setEditable(bloqueia);
            jtfCidade.setEditable(bloqueia);
            jtfUf.setEditable(bloqueia);
            jbSalvar.setEnabled(bloqueia);
            jbLimpar.setEnabled(bloqueia);
            jbExcluir.setEnabled(bloqueia);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void onVisualizar() {
        try {
            endereco = ((CadEnderecoTableModel) jTable1.getModel()).buscaProduto(jTable1.getSelectedRow());
            setObjetoFormulario(endereco);
            jbSalvar.setEnabled(true);
            jbLimpar.setEnabled(true);
            jbExcluir.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(FormularioEndereco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void populaListaEnderecos() {
        ((CadEnderecoTableModel) jTable1.getModel()).removeResultado();
        ((CadEnderecoTableModel) jTable1.getModel()).mostraResultado(enderecos);
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jautopecas.components.JFComboBox jFComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox jcbTipoEndereco;
    private javax.swing.JLabel jlUf;
    private jautopecas.components.JFTextField jtfBairro;
    private jautopecas.components.JFTextField jtfCep;
    private jautopecas.components.JFTextField jtfCidade;
    private jautopecas.components.JFTextField jtfLogradouro;
    private jautopecas.components.JFTextField jtfNumero;
    private jautopecas.components.JFTextField jtfUf;
    // End of variables declaration//GEN-END:variables
}
