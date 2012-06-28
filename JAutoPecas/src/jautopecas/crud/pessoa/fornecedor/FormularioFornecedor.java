package jautopecas.crud.pessoa.fornecedor;

import jautopecas.components.validadores.ValidadorCnpj;
import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.ModeloPessoaDao;
import jautopecas.dao.pessoa.PessoaDao;
import jautopecas.entidades.pessoa.AdicionalPessoa;
import jautopecas.entidades.pessoa.ModeloPessoa;
import jautopecas.entidades.pessoa.Pessoa;
import jautopecas.entidades.pessoa.endereco.EnderecoPessoa;
import jautopecas.entidades.pessoa.telefone.TelefonePessoa;
import java.util.List;

/**
 *
 * @author JFFiorotto
 */
public class FormularioFornecedor extends javax.swing.JPanel implements IFormulario {

    public FormularioFornecedor() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfIdEmpresa = new jautopecas.components.JTextField();
        jlIdFornecedor = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jtfApelido = new jautopecas.components.JTextField();
        jlApelido = new javax.swing.JLabel();
        jlDocumento = new javax.swing.JLabel();
        jtfNome = new jautopecas.components.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        formularioEndereco = new jautopecas.crud.pessoa.endereco.FormularioEndereco();
        jPanel2 = new javax.swing.JPanel();
        formularioTelefone = new jautopecas.crud.pessoa.telefone.FormularioTelefone();
        jtfCnpj = new jautopecas.components.JTextField();
        jcbTipoPessoa = new jautopecas.components.JComboBox();
        jlTipoPessoa = new javax.swing.JLabel();
        jlDocumento2 = new javax.swing.JLabel();
        jtfDocumento2 = new jautopecas.components.JTextField();
        jtfCpf = new jautopecas.components.JTextField();
        jcbTipoLinhaFornecimento = new jautopecas.components.JComboBox();
        jlTipoLinhaFornecimento = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 550));

        jtfIdEmpresa.setEditable(false);
        jtfIdEmpresa.setEnabled(false);
        jtfIdEmpresa.setMensagemAjuda("ID Fornecedor (Gerado pelo sistema)");

        jlIdFornecedor.setText("ID Fornecedor");

        jlNome.setText("Razão Social");

        jtfApelido.setClasseFormulario("");
        jtfApelido.setMensagemAjuda("Nome Fantasia do fornecedor");
        jtfApelido.setRequerido(false);

        jlApelido.setText("Nome Fantasia");

        jlDocumento.setText("CNPJ");

        jtfNome.setMensagemAjuda("Razão Social do fornecedor");
        jtfNome.setRequerido(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

        formularioEndereco.carregaCombos();
        jPanel1.add(formularioEndereco, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Endereços", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.add(formularioTelefone, java.awt.BorderLayout.CENTER);
        formularioTelefone.carregaCombos();

        jTabbedPane1.addTab("Telefones", jPanel2);

        try {
            jtfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfCnpj.setMensagemAjuda("CNPJ do fornecedor");
        jtfCnpj.setValidador(new ValidadorCnpj(jtfCnpj));

        jcbTipoPessoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Juridica", "Fisica" }));
        jcbTipoPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoPessoaActionPerformed(evt);
            }
        });
        jcbTipoPessoa.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jcbTipoPessoaPropertyChange(evt);
            }
        });

        jlTipoPessoa.setText("Tipo Pessoa");

        jlDocumento2.setText("Inscricão Estadual");

        jtfDocumento2.setRequerido(false);

        try {
            jtfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfCpf.setMensagemAjuda("CPF do fornecedor");

        jcbTipoLinhaFornecimento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Produtos", "Serviços" }));
        jcbTipoLinhaFornecimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoLinhaFornecimentoActionPerformed(evt);
            }
        });
        jcbTipoLinhaFornecimento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jcbTipoLinhaFornecimentoPropertyChange(evt);
            }
        });

        jlTipoLinhaFornecimento.setText("Tipo Linha Fornecimento");

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
                                .addComponent(jlDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jlDocumento2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlNome, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jlApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jtfIdEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jlIdFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlTipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlTipoLinhaFornecimento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jcbTipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcbTipoLinhaFornecimento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 160, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfApelido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDocumento2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdFornecedor)
                    .addComponent(jlTipoPessoa)
                    .addComponent(jlTipoLinhaFornecimento))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfIdEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTipoLinhaFornecimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlDocumento)
                    .addComponent(jlDocumento2))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDocumento2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlNome)
                    .addComponent(jlApelido))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcbTipoPessoaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jcbTipoPessoaPropertyChange
    }//GEN-LAST:event_jcbTipoPessoaPropertyChange

    private void jcbTipoPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoPessoaActionPerformed
        if (jcbTipoPessoa.getSelectedItem() == null) {
            jcbTipoPessoa.setSelectedIndex(0);
        }
        if (jcbTipoPessoa.getSelectedItem().equals("Juridica")) {
            jlDocumento.setText("CNPJ");
            jlNome.setText("Razão Social");
            jlApelido.setText("Nome Fantasia");
            jlDocumento2.setText("Inscrição Estadual");
            jtfCpf.setVisible(false);
            jtfCnpj.setVisible(true);
            jtfDocumento2.setMensagemAjuda("Inscrição estadual do fornecedor");
        } else if (jcbTipoPessoa.getSelectedItem().equals("Fisica")) {
            jlDocumento.setText("CPF");
            jlNome.setText("Nome Completo");
            jlApelido.setText("Apelido");
            jlDocumento2.setText("RG");
            jtfCpf.setVisible(true);
            jtfCnpj.setVisible(false);
            jtfDocumento2.setMensagemAjuda("RG do fornecedor");
        }
    }//GEN-LAST:event_jcbTipoPessoaActionPerformed

    private void jcbTipoLinhaFornecimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoLinhaFornecimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoLinhaFornecimentoActionPerformed

    private void jcbTipoLinhaFornecimentoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jcbTipoLinhaFornecimentoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoLinhaFornecimentoPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jautopecas.crud.pessoa.endereco.FormularioEndereco formularioEndereco;
    private jautopecas.crud.pessoa.telefone.FormularioTelefone formularioTelefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private jautopecas.components.JComboBox jcbTipoLinhaFornecimento;
    private jautopecas.components.JComboBox jcbTipoPessoa;
    private javax.swing.JLabel jlApelido;
    private javax.swing.JLabel jlDocumento;
    private javax.swing.JLabel jlDocumento2;
    private javax.swing.JLabel jlIdFornecedor;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlTipoLinhaFornecimento;
    private javax.swing.JLabel jlTipoPessoa;
    private jautopecas.components.JTextField jtfApelido;
    private jautopecas.components.JTextField jtfCnpj;
    private jautopecas.components.JTextField jtfCpf;
    private jautopecas.components.JTextField jtfDocumento2;
    private jautopecas.components.JTextField jtfIdEmpresa;
    private jautopecas.components.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
    private Pessoa pessoa;
    private ModeloPessoa modeloPessoa;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        jcbTipoPessoa.setSempreBloqueado(true);
        pessoa = (Pessoa) objetoFormulario;
        jtfIdEmpresa.setText(String.valueOf(pessoa.getIdPessoa()));
        jtfCnpj.setText(pessoa.getDocumento());
        jtfNome.setText(pessoa.getNome());
        jtfApelido.setText(pessoa.getApelido());
        jcbTipoPessoa.setSelectedItem(pessoa.getTipoPessoa());
        if (jcbTipoPessoa.getSelectedItem().equals("Fisica")) {
            jtfCpf.setText(pessoa.getDocumento());
            jtfDocumento2.setText(pessoa.getAdicionalPessoa().getRg());
        } else if (jcbTipoPessoa.getSelectedItem().equals("Juridica")) {
            jtfCnpj.setText(pessoa.getDocumento());
            jtfDocumento2.setText(pessoa.getAdicionalPessoa().getInscricaoEstadual());
        }
        formularioEndereco.setListaEnderecoPessoa(pessoa.getEnderecoPessoa());
        formularioTelefone.setListaTelefonePessoa(pessoa.getTelefonePessoa());
    }

    @Override
    public void salvar() throws Exception {
        new PessoaDao().salvar(getObjetoFormulario());
        setObjetoFormulario(pessoa);
    }

    @Override
    public void alterar() throws Exception {
        new PessoaDao().alterar(getObjetoFormulario());
        setObjetoFormulario(pessoa);
    }

    @Override
    public void excluir() throws Exception {
        new PessoaDao().excluir(pessoa);
    }

    @Override
    public Pessoa getObjetoFormulario() throws Exception {
        if (pessoa == null) {
            pessoa = new Pessoa();
            pessoa.setAdicionalPessoa(new AdicionalPessoa());
        }
        if (modeloPessoa == null) {
            modeloPessoa = new ModeloPessoaDao().load(2);
        }
        pessoa.setIdPessoa(Integer.valueOf(jtfIdEmpresa.getText().length() == 0 ? "0" : jtfIdEmpresa.getText()));
        pessoa.setModeloPessoa(modeloPessoa);
        pessoa.setApelido(jtfApelido.getText());
        pessoa.setNome(jtfNome.getText());
        pessoa.setTipoPessoa(jcbTipoPessoa.getSelectedItem().toString());
        pessoa.getAdicionalPessoa().setPessoa(pessoa);
        if (jcbTipoPessoa.getSelectedItem().equals("Fisica")) {
            pessoa.setDocumento(jtfCpf.getText());
            pessoa.getAdicionalPessoa().setRg(jtfDocumento2.getText());
        } else if (jcbTipoPessoa.getSelectedItem().equals("Juridica")) {
            pessoa.setDocumento(jtfCnpj.getText());
            pessoa.getAdicionalPessoa().setInscricaoEstadual(jtfDocumento2.getText());
        }

        pessoa.setEnderecoPessoa(formularioEndereco.getListaEnderecoPessoa());
        for (EnderecoPessoa enderecoPessoa : pessoa.getEnderecoPessoa()) {
            enderecoPessoa.setPessoa(pessoa);
        }
        pessoa.setTelefonePessoa(formularioTelefone.getListaTelefonePessoa());
        for (TelefonePessoa telefonePessoa : pessoa.getTelefonePessoa()) {
            telefonePessoa.setPessoa(pessoa);
        }
        return pessoa;
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
        return new PessoaDao().listarTodos();
    }

    public List pesquisaSimples(String strCamposPesqisa, String strPesquisa) {
        return new PessoaDao().pesquisaSimples(strCamposPesqisa, strPesquisa, " and a.modeloPessoa.idModeloPessoa = 2");
    }
}
