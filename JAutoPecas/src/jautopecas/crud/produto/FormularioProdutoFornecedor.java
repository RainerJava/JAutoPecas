package jautopecas.crud.produto;

import jautopecas.entidades.pessoa.Pessoa;
import jautopecas.entidades.produto.Produto;
import jautopecas.entidades.produto.ProdutoFornecedor;
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
public class FormularioProdutoFornecedor extends javax.swing.JPanel {

    private Produto produtoSelecionado;
    private FormularioProdutoFornecedorTableModel tableModel;
    private List<ProdutoFornecedor> listaProdutoFornecedor;
    private ProdutoFornecedor produtoFornecedor;
    private boolean formularioBloqueado;

    /**
     * Creates new form CadEnderecoGUI
     */
    public FormularioProdutoFornecedor() {
        initComponents();

        jtProdutoFornecedores.setModel(tableModel == null ? new FormularioProdutoFornecedorTableModel() : tableModel);
        jtProdutoFornecedores.addMouseListener(
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

    private ProdutoFornecedor getObjetoFormulario() {
        if (produtoFornecedor == null) {
            produtoFornecedor = new ProdutoFornecedor();
        }
        produtoFornecedor.setProduto(produtoSelecionado);
        produtoFornecedor.setFornecedor((Pessoa) jtfFornecedor.getObjeto());
        produtoFornecedor.setNumeroFornecedor(jtfNUmeroFornecedor.getText());
        return produtoFornecedor;
    }

    private void setObjetoFormulario(ProdutoFornecedor objetoFormulario) throws Exception {
        try {
            jtfFornecedor.setObjeto(objetoFormulario.getFornecedor());
            jtfNUmeroFornecedor.setText(objetoFormulario.getNumeroFornecedor());
        } catch (Exception ex) {
            throw new Exception("Erro ao carregar os dados do formulario", ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpProdutoFornecedor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProdutoFornecedores = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jbSalvar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jtfNUmeroFornecedor = new jautopecas.components.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfFornecedor = new jautopecas.components.JTextField();
        jLabel2 = new javax.swing.JLabel();
        formularioProdutoFornecedorCusto = new jautopecas.crud.produto.FormularioProdutoFornecedorCusto();

        setPreferredSize(new java.awt.Dimension(795, 522));
        setLayout(new java.awt.GridLayout(1, 2));

        jpProdutoFornecedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpProdutoFornecedor.setPreferredSize(new java.awt.Dimension(0, 0));
        jpProdutoFornecedor.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(2, 370));

        jtProdutoFornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtProdutoFornecedores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtProdutoFornecedores);

        jpProdutoFornecedor.add(jScrollPane1, java.awt.BorderLayout.SOUTH);

        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));

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

        jLabel1.setText("Numero Fornecedor");

        jtfFornecedor.setClasseFormulario("jautopecas.crud.pessoa.fornecedor.FormularioFornecedor");
        jtfFornecedor.setMensagemAjuda("Estado");
        jtfFornecedor.setRequerido(true);

        jLabel2.setText("Fornecedor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jtfNUmeroFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jbSalvar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbLimpar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbExcluir))
                                    .addComponent(jLabel2))
                                .addGap(0, 214, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNUmeroFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbLimpar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbSalvar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbExcluir, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jpProdutoFornecedor.add(jPanel1, java.awt.BorderLayout.CENTER);

        add(jpProdutoFornecedor);
        add(formularioProdutoFornecedorCusto);
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            if (UtilFormulario.validarFormulario(this) <= 0) {
                if (jtProdutoFornecedores.getSelectedRowCount() <= 0) {
                    if (listaProdutoFornecedor == null) {
                        listaProdutoFornecedor = new ArrayList<>();
                    }
                    listaProdutoFornecedor.add(getObjetoFormulario());
                } else {
                    listaProdutoFornecedor.set(jtProdutoFornecedores.getSelectedRow(), getObjetoFormulario());
                }
                populaListaProdutoFornecedor();
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
        if (JOptionPane.showOptionDialog(null, "Deseja Excluir a relação Produto X Fornecedor selecionada?", "Atenção",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]) == 0) {
            listaProdutoFornecedor.remove(jtProdutoFornecedores.getSelectedRow());
            populaListaProdutoFornecedor();
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    public void onLimpar() {
        produtoFornecedor = null;
        //formularioProdutoFornecedorCusto.onLimpar();
        formularioProdutoFornecedorCusto.setListaProdutoFornecedorCusto(null);
        jtfFornecedor.limpaCampo();
        jtfNUmeroFornecedor.limpaCampo();
        jtProdutoFornecedores.clearSelection();
        if (formularioBloqueado) {
            jbSalvar.setEnabled(false);
            jbLimpar.setEnabled(true);
            jbExcluir.setEnabled(false);
        } else {
            jbSalvar.setEnabled(true);
            jbLimpar.setEnabled(true);
            jbExcluir.setEnabled(false);
        }
        formularioProdutoFornecedorCusto.onLimpar();
    }

    public void onBloquear(boolean formularioBloqueado) {
        try {
            this.formularioBloqueado = formularioBloqueado;
            jtfFornecedor.setEditable(!formularioBloqueado);
            jtfNUmeroFornecedor.setEditable(!formularioBloqueado);
            jbSalvar.setEnabled(!formularioBloqueado);
            jbLimpar.setEnabled(!formularioBloqueado);
            jbExcluir.setEnabled(false);
            formularioProdutoFornecedorCusto.onBloquear(formularioBloqueado);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onVisualizar() throws Exception {
        produtoFornecedor = ((FormularioProdutoFornecedorTableModel) jtProdutoFornecedores.getModel()).buscaProduto(jtProdutoFornecedores.getSelectedRow());
        formularioProdutoFornecedorCusto.setListaProdutoFornecedorCusto(produtoFornecedor.getProdutoFornecedorCusto());
        formularioProdutoFornecedorCusto.setProdutoFornecedor(produtoFornecedor);
        setObjetoFormulario(produtoFornecedor);
        if (formularioBloqueado) {
            jbSalvar.setEnabled(false);
            jbLimpar.setEnabled(true);
            jbExcluir.setEnabled(false);
        } else {
            jbSalvar.setEnabled(true);
            jbLimpar.setEnabled(true);
            jbExcluir.setEnabled(true);
        }
        if (formularioProdutoFornecedorCusto.getListaProdutoFornecedorCusto() == null || formularioProdutoFornecedorCusto.getListaProdutoFornecedorCusto().isEmpty()) {
            formularioProdutoFornecedorCusto.getJbSalvar().setEnabled(true);
        } else {
            formularioProdutoFornecedorCusto.getJbSalvar().setEnabled(false);
        }
    }

    private void populaListaProdutoFornecedor() {
        ((FormularioProdutoFornecedorTableModel) jtProdutoFornecedores.getModel()).removeResultado();
        ((FormularioProdutoFornecedorTableModel) jtProdutoFornecedores.getModel()).mostraResultado(listaProdutoFornecedor);
        onLimpar();
    }

    public void carregaCombos() {
//        jcbTipoLogradpuro.setDataSet(new TipoLogradouroDao().listarTodos());
//        jcbTipoEndereco.setDataSet(new TipoEnderecoDao().listarTodos());
    }

    public List<ProdutoFornecedor> getListaProdutoFornecedor() {
        return listaProdutoFornecedor;
    }

    public void setListaProdutoFornecedor(List<ProdutoFornecedor> listaProdutoFornecedor) {
        this.listaProdutoFornecedor = listaProdutoFornecedor;
        populaListaProdutoFornecedor();
    }

    public JTable getJtlogins() {
        return jtProdutoFornecedores;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jautopecas.crud.produto.FormularioProdutoFornecedorCusto formularioProdutoFornecedorCusto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JPanel jpProdutoFornecedor;
    private javax.swing.JTable jtProdutoFornecedores;
    private jautopecas.components.JTextField jtfFornecedor;
    private jautopecas.components.JTextField jtfNUmeroFornecedor;
    // End of variables declaration//GEN-END:variables
}
