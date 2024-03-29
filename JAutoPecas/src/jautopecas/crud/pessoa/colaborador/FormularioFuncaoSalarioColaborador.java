package jautopecas.crud.pessoa.colaborador;

import jautopecas.components.validadores.ValidadorData;
import jautopecas.entidades.pessoa.colaborador.Funcao;
import jautopecas.entidades.pessoa.colaborador.FuncaoSalarioColaborador;
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
public class FormularioFuncaoSalarioColaborador extends javax.swing.JPanel {

    public FormularioFuncaoSalarioColaborador() {
        initComponents();

        jtFuncaoSalarioColaborador.setModel(tableModel == null ? new FormularioFuncaoSalarioColaboradorTableModel() : tableModel);
        jtFuncaoSalarioColaborador.addMouseListener(
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jtfFuncao = new jautopecas.components.JTextField();
        jlFuncao = new javax.swing.JLabel();
        jtfDataInicio = new jautopecas.components.JTextField();
        jtfSalario = new jautopecas.components.JTextField();
        jlSalario = new javax.swing.JLabel();
        jlDataInicio = new javax.swing.JLabel();
        jbSalvar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFuncaoSalarioColaborador = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(400, 300));
        setLayout(new java.awt.BorderLayout());

        jtfFuncao.setClasseFormulario("jautopecas.crud.pessoa.colaborador.FormularioFuncao");

        jlFuncao.setText("Função");

        try {
            jtfDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfDataInicio.setValidador(new ValidadorData(jtfDataInicio));

        jtfSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        jlSalario.setText("Salário");

        jlDataInicio.setText("Data Inicio");

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jbSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLimpar)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFuncao)
                    .addComponent(jlSalario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDataInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbSalvar)
                    .addComponent(jbLimpar))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        add(jPanel7, java.awt.BorderLayout.NORTH);

        jtFuncaoSalarioColaborador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtFuncaoSalarioColaborador.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtFuncaoSalarioColaborador);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private FuncaoSalarioColaborador getObjetoFormulario() {
        if (funcaoSalarioColaborador == null) {
            funcaoSalarioColaborador = new FuncaoSalarioColaborador();
        }
        funcaoSalarioColaborador.setFuncao((Funcao) jtfFuncao.getObjeto());
        funcaoSalarioColaborador.setSalario(StringUtils.stringToBigDecimal(jtfSalario.getText()));

        funcaoSalarioColaborador.setDataInicio(StringUtils.stringToDate(jtfDataInicio.getText()));
        return funcaoSalarioColaborador;
    }

    private void setObjetoFormulario(FuncaoSalarioColaborador objetoFormulario) throws Exception {
        try {
            jtfFuncao.setObjeto(objetoFormulario.getFuncao());
            jtfSalario.setText(StringUtils.BigDecimalToString(objetoFormulario.getSalario()));
            jtfDataInicio.setText(StringUtils.dateToString(objetoFormulario.getDataInicio()));
        } catch (Exception ex) {
            throw new Exception("Erro ao carregar os dados do formulario", ex);
        }
    }

    public void onLimpar() {
        funcaoSalarioColaborador = null;
        jtfFuncao.limpaCampo();
        jtfSalario.limpaCampo();
        jtfDataInicio.limpaCampo();
        jtFuncaoSalarioColaborador.clearSelection();
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
            jtfFuncao.setEditable(!formularioBloqueado);
            jtfSalario.setEditable(!formularioBloqueado);
            jtfDataInicio.setEditable(!formularioBloqueado);
            jbSalvar.setEnabled(!formularioBloqueado);
            jbLimpar.setEnabled(!formularioBloqueado);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onVisualizar() throws Exception {
        funcaoSalarioColaborador = ((FormularioFuncaoSalarioColaboradorTableModel) jtFuncaoSalarioColaborador.getModel()).buscaFuncaoSalarioColaborador(jtFuncaoSalarioColaborador.getSelectedRow());
        setObjetoFormulario(funcaoSalarioColaborador);
        if (formularioBloqueado) {
            jbSalvar.setEnabled(false);
            jbLimpar.setEnabled(true);
        } else {
            jbSalvar.setEnabled(false);
            jbLimpar.setEnabled(true);
        }
    }

    private void populaListaFuncaoSalarioColaborador() {
        ((FormularioFuncaoSalarioColaboradorTableModel) jtFuncaoSalarioColaborador.getModel()).removeResultado();
        ((FormularioFuncaoSalarioColaboradorTableModel) jtFuncaoSalarioColaborador.getModel()).mostraResultado(listaFuncaoSalarioColaborador);
        onLimpar();
    }

    public void carregaCombos() {
        //jcbTipoLogradpuro.setDataSet(new TipoLogradouroDao().listarTodos());
        //jcbTipoEndereco.setDataSet(new TipoEnderecoDao().listarTodos());
    }

    public List<FuncaoSalarioColaborador> getListaFuncaoSalarioColaborador() {
        return listaFuncaoSalarioColaborador;
    }

    public void setListaFuncaoSalarioColaborador(List<FuncaoSalarioColaborador> listaFuncaoSalarioColaborador) {
        this.listaFuncaoSalarioColaborador = listaFuncaoSalarioColaborador;
        populaListaFuncaoSalarioColaborador();
    }

    public JTable getJtFuncaoSalarioColaborador() {
        return jtFuncaoSalarioColaborador;
    }
    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            if (UtilFormulario.validarFormulario(this) <= 0) {
                if (jtFuncaoSalarioColaborador.getSelectedRowCount() <= 0) {
                    if (listaFuncaoSalarioColaborador == null) {
                        listaFuncaoSalarioColaborador = new ArrayList<>();
                    }
                    listaFuncaoSalarioColaborador.add(getObjetoFormulario());
                } else {
                    listaFuncaoSalarioColaborador.set(jtFuncaoSalarioColaborador.getSelectedRow(), getObjetoFormulario());
                }
                populaListaFuncaoSalarioColaborador();
            }
        } catch (UtilFormularioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        onLimpar();
    }//GEN-LAST:event_jbLimparActionPerformed
    private FuncaoSalarioColaborador funcaoSalarioColaborador;
    private List<FuncaoSalarioColaborador> listaFuncaoSalarioColaborador;
    private boolean formularioBloqueado;
    private FormularioFuncaoSalarioColaboradorTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JLabel jlDataInicio;
    private javax.swing.JLabel jlFuncao;
    private javax.swing.JLabel jlSalario;
    private javax.swing.JTable jtFuncaoSalarioColaborador;
    private jautopecas.components.JTextField jtfDataInicio;
    private jautopecas.components.JTextField jtfFuncao;
    private jautopecas.components.JTextField jtfSalario;
    // End of variables declaration//GEN-END:variables
}
