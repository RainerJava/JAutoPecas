package jautopecas.crud.produto;

import jautopecas.JAutoPecasMenu;
import jautopecas.dao.substituicaoTributaria.CstDao;
import jautopecas.dao.substituicaoTributaria.IcmsDao;
import jautopecas.entidades.pessoa.Pessoa;
import jautopecas.entidades.produto.ProdutoFornecedor;
import jautopecas.entidades.produto.ProdutoFornecedorCusto;
import jautopecas.entidades.substituicaoTributaria.Cst;
import jautopecas.util.StringUtils;
import jautopecas.util.UtilFormulario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
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
        carregaCombos();
    }

    private ProdutoFornecedorCusto getObjetoFormulario() {
        try {
            if (produtoFornecedorCusto == null) {
                produtoFornecedorCusto = new ProdutoFornecedorCusto();
                produtoFornecedorCusto.setEmpresa(JAutoPecasMenu.getEmpresaSelecionada());
            }
            produtoFornecedorCusto.setProdutoFornecedor(produtoFornecedor);
            produtoFornecedorCusto.setCustoUnitario(StringUtils.stringToBigDecimal(jtfCustoUnitario.getText()));
            produtoFornecedorCusto.setCstIcms((Cst) jcbCst.getSelectedItem());
            produtoFornecedorCusto.setPercentIcms(StringUtils.stringToBigDecimal(jtfIcms.getText()));
            produtoFornecedorCusto.setPercentImpostoImportacao(StringUtils.stringToBigDecimal(jtfIi.getText()));
            produtoFornecedorCusto.setPercentIpi(StringUtils.stringToBigDecimal(jtfIpi.getText()));
            produtoFornecedorCusto.setCustoReposicao(StringUtils.stringToBigDecimal(jtfCustoReposicao.getText()));
            produtoFornecedorCusto.calculaCustoNet();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
        return produtoFornecedorCusto;
    }

    public void criaProdutoFornecedorCustoEmpresa(final ProdutoFornecedorCusto produtoFornecedorCustoOrigem) {
        try {
            double vTaxaICMS = new IcmsDao().getPercentIcmsEmissor(produtoFornecedor.getFornecedor().getEnderecoPessoa().get(0).getEndereco().getUf().getUf(),
                    JAutoPecasMenu.getEmpresaSelecionada().getEnderecoPessoa().get(0).getEndereco().getUf().getUf()).doubleValue();
            double TaxaPis = (produtoFornecedor.getProduto().getClassificacaoFiscal().getPercentPis().doubleValue() / 100);
            double TaxaCofins = (produtoFornecedor.getProduto().getClassificacaoFiscal().getPercentCofins().doubleValue() / 100);

            for (Pessoa empresa : JAutoPecasMenu.getListaEmpresas()) {
                ProdutoFornecedorCusto newTfar = new ProdutoFornecedorCusto();
                newTfar.setProdutoFornecedor(produtoFornecedorCusto.getProdutoFornecedor());
                newTfar.setCustoUnitario(produtoFornecedorCusto.getCustoUnitario());
                newTfar.setCstIcms(produtoFornecedorCusto.getCstIcms());
                newTfar.setPercentImpostoImportacao(produtoFornecedorCusto.getPercentImpostoImportacao());
                newTfar.setPercentIpi(produtoFornecedorCusto.getPercentIpi());

                double vTaxaICMSEmpresa = new IcmsDao().getPercentIcmsEmissor(produtoFornecedor.getFornecedor().getEnderecoPessoa().get(0).getEndereco().getUf().getUf(),
                        empresa.getEnderecoPessoa().get(0).getEndereco().getUf().getUf()).doubleValue();
                if (vTaxaICMS != vTaxaICMSEmpresa) {
                    vTaxaICMSEmpresa = (vTaxaICMSEmpresa / 100);
                    double vTaxas = TaxaPis + TaxaCofins + vTaxaICMSEmpresa;
                    double valorNetCalculado = produtoFornecedorCusto.getCustoNet().doubleValue() / (1 - vTaxas);
                    newTfar.setCustoUnitario(new BigDecimal(valorNetCalculado));
                    newTfar.setPercentIcms(new BigDecimal(vTaxaICMSEmpresa * 100));
                } else {
                    newTfar.setCustoUnitario(produtoFornecedorCustoOrigem.getCustoUnitario());
                    newTfar.setPercentIcms(produtoFornecedorCustoOrigem.getPercentIcms());
                }
                newTfar.setEmpresa(empresa);
                newTfar.calculaCustoNet();
                produtoFornecedorCusto = newTfar;
                listaProdutoFornecedorCusto.add(newTfar);
            }
            produtoFornecedor.setProdutoFornecedorCusto(listaProdutoFornecedorCusto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void setObjetoFormulario(ProdutoFornecedorCusto objetoFormulario) throws Exception {
        try {
            jtfCustoReposicao.setText(StringUtils.BigDecimalToString(objetoFormulario.getCustoReposicao()));
            jtfCustoUnitario.setText(StringUtils.BigDecimalToString(objetoFormulario.getCustoUnitario()));
            jtfIcms.setText(StringUtils.BigDecimalToString(objetoFormulario.getPercentIcms()));
            jtfIi.setText(StringUtils.BigDecimalToString(objetoFormulario.getPercentImpostoImportacao()));
            jtfIpi.setText(StringUtils.BigDecimalToString(objetoFormulario.getPercentIpi()));
            jcbCst.setSelectedItem(objetoFormulario.getCstIcms());
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jcbCst = new jautopecas.components.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jtfIpi = new jautopecas.components.JTextField();
        jtfIcms = new jautopecas.components.JTextField();
        jtfIi = new jautopecas.components.JTextField();
        jtfCustoReposicao = new jautopecas.components.JTextField();
        jtfCustoUnitario = new jautopecas.components.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProdutoFornecedores = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
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

        jLabel6.setText("%IPI");

        jLabel7.setText("%ICMS");

        jLabel8.setText("%II");

        jLabel5.setText("Custo Unitario");

        jLabel9.setText("CST");

        jLabel11.setText("Custo Reposição");

        jtfIpi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jtfIcms.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jtfIi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jtfCustoReposicao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        jtfCustoUnitario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbCst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbLimpar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jtfIpi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfIcms, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfIi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfCustoUnitario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                    .addComponent(jtfCustoReposicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfIpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfIcms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfIi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCustoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCustoReposicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbCst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
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
                    if (listaProdutoFornecedorCusto == null || listaProdutoFornecedorCusto.isEmpty()) {
                        listaProdutoFornecedorCusto = new ArrayList<>();
                        getObjetoFormulario();
                        criaProdutoFornecedorCustoEmpresa(produtoFornecedorCusto);
                    }
                } else {
                    listaProdutoFornecedorCusto.set(jtProdutoFornecedores.getSelectedRow(), getObjetoFormulario());
                }
                populaListaProdutoFornecedorCusto();
            }
        } catch (Exception ex) {
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
            jbSalvar.setEnabled(false);
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
            jcbCst.setEnabled(!formularioBloqueado);
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
    }

    private void populaListaProdutoFornecedorCusto() {
        ((FormularioProdutoFornecedorCustoTableModel) jtProdutoFornecedores.getModel()).removeResultado();
        ((FormularioProdutoFornecedorCustoTableModel) jtProdutoFornecedores.getModel()).mostraResultado(listaProdutoFornecedorCusto);
        onLimpar();
    }

    public void carregaCombos() {
        try {
            jcbCst.setDataSet(new CstDao().listarCstIcms());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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

    public JButton getJbSalvar() {
        return jbSalvar;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
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
