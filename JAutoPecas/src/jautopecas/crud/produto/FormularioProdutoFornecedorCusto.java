package jautopecas.crud.produto;

import jautopecas.dao.pessoa.PessoaDao;
import jautopecas.entidades.pessoa.Pessoa;
import jautopecas.entidades.produto.ProdutoFornecedor;
import jautopecas.entidades.produto.ProdutoFornecedorCusto;
import jautopecas.exceptions.UtilFormularioException;
import jautopecas.util.StringUtils;
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
public class FormularioProdutoFornecedorCusto extends javax.swing.JPanel {

    private FormularioProdutoFornecedorCustoTableModel tableModel;
    private List<ProdutoFornecedorCusto> listaProdutoFornecedorCusto;
    private ProdutoFornecedorCusto produtoFornecedorCusto;
    private boolean formularioBloqueado;
    private List<Pessoa> listaEmpresas;
    private ProdutoFornecedor produtoFornecedor;

    /**
     * Creates new form CadEnderecoGUI
     */
    public FormularioProdutoFornecedorCusto() {
        initComponents();

        jtProdutoFornecedores.setModel(tableModel == null ? new FormularioProdutoFornecedorCustoTableModel() : tableModel);
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

    private ProdutoFornecedorCusto getObjetoFormulario() {
        if (listaEmpresas == null) {
            try {
                listaEmpresas = new ArrayList<>();
                listaEmpresas.addAll(new PessoaDao().listaPessoaPorModelo(1));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (listaProdutoFornecedorCusto == null) {
            listaProdutoFornecedorCusto = new ArrayList();
        }
        if (produtoFornecedorCusto == null) {
            produtoFornecedorCusto = new ProdutoFornecedorCusto();
        }
        for (int i = 0; i < listaEmpresas.size(); i++) {
            produtoFornecedorCusto = new ProdutoFornecedorCusto();
            produtoFornecedorCusto.setProdutoFornecedor(produtoFornecedor);
            produtoFornecedorCusto.setEmpresa(listaEmpresas.get(i));
            produtoFornecedorCusto.setCustoUnitario(StringUtils.stringToBigDecimal(jtfCustoUnitario.getText()));
            produtoFornecedorCusto.setCst(jcbCst.getSelectedItem().toString());
            produtoFornecedorCusto.setPorcentIcms(StringUtils.stringToBigDecimal(jtfIcms.getText()));
            produtoFornecedorCusto.setPorcentImpostoImportacao(StringUtils.stringToBigDecimal(jtfIi.getText()));
            produtoFornecedorCusto.setPorcentIpi(StringUtils.stringToBigDecimal(jtfIpi.getText()));
            produtoFornecedorCusto.setCustoReposicao(StringUtils.stringToBigDecimal(jtfCustoReposicao.getText()));

            listaProdutoFornecedorCusto.add(produtoFornecedorCusto);
        }
        produtoFornecedor.setProdutoFornecedorCusto(listaProdutoFornecedorCusto);
        return produtoFornecedorCusto;
    }

    private void setObjetoFormulario(ProdutoFornecedorCusto objetoFormulario) throws Exception {
        try {
            jtfCustoReposicao.setText(StringUtils.BigDecimalToString(objetoFormulario.getCustoReposicao()));
            jtfCustoUnitario.setText(StringUtils.BigDecimalToString(objetoFormulario.getCustoUnitario()));
            jtfIcms.setText(StringUtils.BigDecimalToString(objetoFormulario.getPorcentIcms()));
            jtfIi.setText(StringUtils.BigDecimalToString(objetoFormulario.getPorcentImpostoImportacao()));
            jtfIpi.setText(StringUtils.BigDecimalToString(objetoFormulario.getPorcentIpi()));
            jcbCst.setSelectedItem(objetoFormulario.getCst());
        } catch (Exception ex) {
            throw new Exception("Erro ao carregar os dados do formulario", ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbSalvar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jtfIpi = new jautopecas.components.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfIcms = new jautopecas.components.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfIi = new jautopecas.components.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfCustoReposicao = new jautopecas.components.JTextField();
        jtfCustoUnitario = new jautopecas.components.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jcbCst = new jautopecas.components.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProdutoFornecedores = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(0, 0));
        setLayout(new java.awt.BorderLayout());

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

        jLabel6.setText("IPI");

        jLabel7.setText("ICMS");

        jLabel8.setText("II");

        jLabel10.setText("Custo Reposição");

        jLabel5.setText("Custo Unitario");

        jLabel9.setText("CST");

        jcbCst.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "000-Prod Nac Tributado", "010-(N)Tributada cobranÃ§a ICMS Substituição", "020-(N) ReduÃ§Ã£o de Base de Calculo", "030-(N)Isenta/N.Tributada cobr. ICMS Subst.", "040-Isenta", "041-Nao Tributada", "050-Nacional (SuspensÃ£o)", "051-Nacional (Diferimento)", "060-(N)ICMS cobrado antecipado Substituição", "070-(N)ReduÃ§Ã£o Base ICMS cobr.Substituição", "090-Outras", "100-Importacao Direta", "110-(N)Tributada cobranÃ§a ICMS Substituição", "200-ImportaÃ§Ã£o Adquirida Mercado Interno", "210-Tritutada Cobranca ST", "260-(ID)ICMS cobrado antecipado Substituição" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jtfIpi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfIcms, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfIi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jcbCst, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfCustoUnitario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfCustoReposicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(389, 389, 389))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLimpar)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfIpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfIcms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfIi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCustoUnitario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfCustoReposicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbCst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbLimpar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbSalvar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(2, 300));

        jtProdutoFornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtProdutoFornecedores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtProdutoFornecedores);

        add(jScrollPane1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            if (UtilFormulario.validarFormulario(this) <= 0) {
                if (jtProdutoFornecedores.getSelectedRowCount() <= 0) {
                    if (listaProdutoFornecedorCusto == null) {
                        listaProdutoFornecedorCusto = new ArrayList<>();
                    }
                    listaProdutoFornecedorCusto.add(getObjetoFormulario());
                } else {
                    listaProdutoFornecedorCusto.set(jtProdutoFornecedores.getSelectedRow(), getObjetoFormulario());
                }
                populaListaProdutoFornecedorCusto();
            }
        } catch (UtilFormularioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        onLimpar();
    }//GEN-LAST:event_jbLimparActionPerformed

    public void onLimpar() {
        produtoFornecedorCusto = null;
        jtfCustoReposicao.limpaCampo();
        jtfCustoUnitario.limpaCampo();
        jtfIcms.limpaCampo();
        jtfIi.limpaCampo();
        jtfIpi.limpaCampo();
        jcbCst.limpaCampo();
        jtProdutoFornecedores.clearSelection();
        if (formularioBloqueado) {
            jbSalvar.setEnabled(false);
            jbLimpar.setEnabled(true);
        } else {
            jbSalvar.setEnabled(true);
            jbLimpar.setEnabled(true);
        }
    }

    public void onBloquear(boolean formularioBloqueado) {
        try {
            this.formularioBloqueado = formularioBloqueado;
            jtfCustoReposicao.setEditable(!formularioBloqueado);
            jtfCustoUnitario.setEditable(!formularioBloqueado);
            jtfIcms.setEditable(!formularioBloqueado);
            jtfIi.setEditable(!formularioBloqueado);
            jtfIpi.setEditable(!formularioBloqueado);
            jcbCst.setEditable(!formularioBloqueado);
            jtProdutoFornecedores.clearSelection();
            jbSalvar.setEnabled(!formularioBloqueado);
            jbLimpar.setEnabled(!formularioBloqueado);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onVisualizar() throws Exception {
        produtoFornecedorCusto = ((FormularioProdutoFornecedorCustoTableModel) jtProdutoFornecedores.getModel()).buscaProduto(jtProdutoFornecedores.getSelectedRow());
        setObjetoFormulario(produtoFornecedorCusto);
        if (formularioBloqueado) {
            jbSalvar.setEnabled(false);
            jbLimpar.setEnabled(true);
        } else {
            jbSalvar.setEnabled(true);
            jbLimpar.setEnabled(true);
        }
        populaListaProdutoFornecedorCusto();
    }

    private void populaListaProdutoFornecedorCusto() {
        ((FormularioProdutoFornecedorCustoTableModel) jtProdutoFornecedores.getModel()).removeResultado();
        ((FormularioProdutoFornecedorCustoTableModel) jtProdutoFornecedores.getModel()).mostraResultado(listaProdutoFornecedorCusto);
        onLimpar();
    }

    public void carregaCombos() {
//        jcbTipoLogradpuro.setDataSet(new TipoLogradouroDao().listarTodos());
//        jcbTipoEndereco.setDataSet(new TipoEnderecoDao().listarTodos());
    }

    public List<ProdutoFornecedorCusto> getListaProdutoFornecedorCusto() {
        return listaProdutoFornecedorCusto;
    }

    public void setListaProdutoFornecedorCusto(List<ProdutoFornecedorCusto> listaProdutoFornecedorCusto) {
        this.listaProdutoFornecedorCusto = listaProdutoFornecedorCusto;
        populaListaProdutoFornecedorCusto();
    }

    public JTable getJtlogins() {
        return jtProdutoFornecedores;
    }

    public void setProdutoFornecedor(ProdutoFornecedor produtoFornecedor) {
        this.produtoFornecedor = produtoFornecedor;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbSalvar;
    private jautopecas.components.JComboBox jcbCst;
    private javax.swing.JTable jtProdutoFornecedores;
    private jautopecas.components.JTextField jtfCustoReposicao;
    private jautopecas.components.JTextField jtfCustoUnitario;
    private jautopecas.components.JTextField jtfIcms;
    private jautopecas.components.JTextField jtfIi;
    private jautopecas.components.JTextField jtfIpi;
    // End of variables declaration//GEN-END:variables
}
