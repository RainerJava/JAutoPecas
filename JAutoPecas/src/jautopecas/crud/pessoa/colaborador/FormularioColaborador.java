package jautopecas.crud.pessoa.colaborador;

import jautopecas.crud.IFormulario;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.ModeloPessoaDao;
import jautopecas.dao.pessoa.PessoaDao;
import jautopecas.entidades.pessoa.AdicionalPessoa;
import jautopecas.entidades.pessoa.ModeloPessoa;
import jautopecas.entidades.pessoa.Pessoa;
import jautopecas.entidades.pessoa.endereco.Cidade;
import jautopecas.entidades.pessoa.endereco.EnderecoPessoa;
import jautopecas.entidades.pessoa.login.LoginPessoa;
import jautopecas.entidades.pessoa.telefone.TelefonePessoa;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author JFFiorotto
 */
public class FormularioColaborador extends javax.swing.JPanel implements IFormulario {

    public FormularioColaborador() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jlApelido = new javax.swing.JLabel();
        jtfApelido = new jautopecas.components.JTextField();
        jtfNome = new jautopecas.components.JTextField();
        jlNome = new javax.swing.JLabel();
        jtfIdEmpresa = new jautopecas.components.JTextField();
        jlIdPessoa = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        formularioEndereco = new jautopecas.crud.pessoa.endereco.FormularioEndereco();
        jPanel2 = new javax.swing.JPanel();
        formularioTelefone = new jautopecas.crud.pessoa.telefone.FormularioTelefone();
        jPanel3 = new javax.swing.JPanel();
        formularioLogin = new jautopecas.crud.pessoa.login.FormularioLogin();
        jFComboBox1 = new jautopecas.components.JComboBox();
        jlSexo = new javax.swing.JLabel();
        jtfNome1 = new jautopecas.components.JTextField();
        jlDataNascimento = new javax.swing.JLabel();
        jFComboBox2 = new jautopecas.components.JComboBox();
        jlRacaCor = new javax.swing.JLabel();
        jlNacionalidade = new javax.swing.JLabel();
        jtfNaturalidade = new jautopecas.components.JTextField();
        jlNaturalidade = new javax.swing.JLabel();
        jtfNaturalidadeUf = new jautopecas.components.JTextField();
        jtfNaturalidade1 = new jautopecas.components.JTextField();
        jtfNaturalidadeUf1 = new jautopecas.components.JTextField();
        jtfNomePai = new jautopecas.components.JTextField();
        jlNomePai = new javax.swing.JLabel();
        jtfNomeMae = new jautopecas.components.JTextField();
        jlNomeMae = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jtfRg = new jautopecas.components.JTextField();
        jlRg = new javax.swing.JLabel();
        jtfCpf = new jautopecas.components.JTextField();
        jlCpf = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 550));

        jlApelido.setText("Apelido");

        jtfApelido.setClasseFormulario("");
        jtfApelido.setMensagemAjuda("Nome Fantasia da empresa");
        jtfApelido.setRequerido(false);

        jtfNome.setMensagemAjuda("Razão Social da empresa");
        jtfNome.setRequerido(false);

        jlNome.setText("Nome Completo");

        jtfIdEmpresa.setEditable(false);
        jtfIdEmpresa.setEnabled(false);
        jtfIdEmpresa.setMensagemAjuda("ID Empresa (Gerado pelo sistema)");

        jlIdPessoa.setText("ID Colaborador");

        jPanel1.setLayout(new java.awt.BorderLayout());

        formularioEndereco.setMinimumSize(new java.awt.Dimension(626, 274));
        formularioEndereco.carregaCombos();
        jPanel1.add(formularioEndereco, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Endereços", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.add(formularioTelefone, java.awt.BorderLayout.CENTER);
        formularioTelefone.carregaCombos();

        jTabbedPane1.addTab("Telefones", jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel3.add(formularioLogin, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Login", jPanel3);

        jFComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));

        jlSexo.setText("Sexo");

        jtfNome1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jtfNome1.setMensagemAjuda("Razão Social da empresa");
        jtfNome1.setRequerido(false);

        jlDataNascimento.setText("Data Nascimento");

        jFComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Branca", "Preta", "Amarela", "Parda", "Indigina" }));

        jlRacaCor.setText("Raça/Cor");

        jlNacionalidade.setText("Nacionalidade");

        jtfNaturalidade.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioCidade");
        jtfNaturalidade.setMensagemAjuda("Cidade");
        jtfNaturalidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNaturalidadeFocusLost(evt);
            }
        });

        jlNaturalidade.setText("Naturalidade");

        jtfNaturalidadeUf.setEditable(false);
        jtfNaturalidadeUf.setEnabled(false);
        jtfNaturalidadeUf.setMensagemAjuda("ID Empresa (Gerado pelo sistema)");

        jtfNaturalidade1.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioCidade");
        jtfNaturalidade1.setMensagemAjuda("Cidade");

        jtfNaturalidadeUf1.setEditable(false);
        jtfNaturalidadeUf1.setEnabled(false);
        jtfNaturalidadeUf1.setMensagemAjuda("ID Empresa (Gerado pelo sistema)");
        jtfNaturalidadeUf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNaturalidadeUf1ActionPerformed(evt);
            }
        });

        jtfNomePai.setMensagemAjuda("Razão Social da empresa");
        jtfNomePai.setRequerido(false);

        jlNomePai.setText("Nome Pai");

        jtfNomeMae.setMensagemAjuda("Razão Social da empresa");
        jtfNomeMae.setRequerido(false);

        jlNomeMae.setText("Nome Mãe");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtfNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNomeMae, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jlIdPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jlSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(jlRacaCor))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jtfIdEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jFComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jlNome)
                                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jlApelido)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jtfApelido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jlDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jlNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jtfNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jtfNaturalidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfNaturalidadeUf1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jlNomePai))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jtfNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfNaturalidadeUf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlNomeMae)
                                            .addComponent(jlNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlIdPessoa)
                    .addComponent(jlSexo)
                    .addComponent(jlRacaCor))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfIdEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNome)
                    .addComponent(jlApelido))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDataNascimento)
                    .addComponent(jlNacionalidade)
                    .addComponent(jlNaturalidade))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNaturalidade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNaturalidadeUf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfNaturalidadeUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlNomePai)
                    .addComponent(jlNomeMae))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dados Basicos", jPanel4);

        jtfRg.setMensagemAjuda("Razão Social da empresa");
        jtfRg.setRequerido(false);

        jlRg.setText("RG");

        try {
            jtfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jlCpf.setText("CPF");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jlCpf)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfRg, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlRg))
                .addContainerGap(347, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCpf)
                    .addComponent(jlRg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(471, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Documentação", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNaturalidadeUf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNaturalidadeUf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNaturalidadeUf1ActionPerformed

    private void jtfNaturalidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNaturalidadeFocusLost
        if (jtfNaturalidade.getObjeto() != null) {
            jtfNaturalidadeUf.setText(((Cidade) jtfNaturalidade.getObjeto()).getUf().getUf());
        }
    }//GEN-LAST:event_jtfNaturalidadeFocusLost
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jautopecas.crud.pessoa.endereco.FormularioEndereco formularioEndereco;
    private jautopecas.crud.pessoa.login.FormularioLogin formularioLogin;
    private jautopecas.crud.pessoa.telefone.FormularioTelefone formularioTelefone;
    private jautopecas.components.JComboBox jFComboBox1;
    private jautopecas.components.JComboBox jFComboBox2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel jlApelido;
    private javax.swing.JLabel jlCpf;
    private javax.swing.JLabel jlDataNascimento;
    private javax.swing.JLabel jlIdPessoa;
    private javax.swing.JLabel jlNacionalidade;
    private javax.swing.JLabel jlNaturalidade;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlNomeMae;
    private javax.swing.JLabel jlNomePai;
    private javax.swing.JLabel jlRacaCor;
    private javax.swing.JLabel jlRg;
    private javax.swing.JLabel jlSexo;
    private jautopecas.components.JTextField jtfApelido;
    private jautopecas.components.JTextField jtfCpf;
    private jautopecas.components.JTextField jtfIdEmpresa;
    private jautopecas.components.JTextField jtfNaturalidade;
    private jautopecas.components.JTextField jtfNaturalidade1;
    private jautopecas.components.JTextField jtfNaturalidadeUf;
    private jautopecas.components.JTextField jtfNaturalidadeUf1;
    private jautopecas.components.JTextField jtfNome;
    private jautopecas.components.JTextField jtfNome1;
    private jautopecas.components.JTextField jtfNomeMae;
    private jautopecas.components.JTextField jtfNomePai;
    private jautopecas.components.JTextField jtfRg;
    // End of variables declaration//GEN-END:variables
    private Pessoa pessoa;
    private ModeloPessoa modeloPessoa;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        pessoa = (Pessoa) objetoFormulario;
        jtfIdEmpresa.setText(String.valueOf(pessoa.getIdPessoa()));
        jtfCpf.setText(pessoa.getDocumento());
        jtfRg.setText(pessoa.getAdicionalPessoa().getRg());
        jtfNome.setText(pessoa.getNome());
        jtfApelido.setText(pessoa.getApelido());

        formularioEndereco.setListaEnderecoPessoa(pessoa.getEnderecoPessoa());
        formularioTelefone.setListaTelefonePessoa(pessoa.getTelefonePessoa());
        formularioLogin.setListaPessoaLogin(pessoa.getLoginPessoa());
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
            modeloPessoa = new ModeloPessoaDao().load(5);
        }
        pessoa.setIdPessoa(Integer.valueOf(jtfIdEmpresa.getText().length() == 0 ? "0" : jtfIdEmpresa.getText()));
        pessoa.setModeloPessoa(modeloPessoa);
        pessoa.setNome(jtfNome.getText());
        pessoa.setApelido(jtfApelido.getText());
        pessoa.setTipoPessoa(Pessoa.TIPO_PESSOA_FISICA);
        pessoa.setDocumento(jtfCpf.getText());
        pessoa.getAdicionalPessoa().setRg(jtfRg.getText());
        pessoa.getAdicionalPessoa().setPessoa(pessoa);

        pessoa.setEnderecoPessoa(formularioEndereco.getListaEnderecoPessoa());
        for (EnderecoPessoa enderecoPessoa : pessoa.getEnderecoPessoa()) {
            enderecoPessoa.setPessoa(pessoa);
        }
        pessoa.setTelefonePessoa(formularioTelefone.getListaTelefonePessoa());
        for (TelefonePessoa telefonePessoa : pessoa.getTelefonePessoa()) {
            telefonePessoa.setPessoa(pessoa);
        }
        if (formularioLogin.getListaLoginPessoa() != null && formularioLogin.getListaLoginPessoa().size() > 0) {
            pessoa.setLoginPessoa(formularioLogin.getListaLoginPessoa());
            for (LoginPessoa loginPessoa : pessoa.getLoginPessoa()) {
                loginPessoa.setPessoa(pessoa);
            }
        }
        return pessoa;
    }

    @Override
    public JLabel getJlInformacao() {
        return ((WindowCrud) getTopLevelAncestor()).getJlInformacao();
    }

    @Override
    public List pesquisar(String strPesquisa) throws Exception {
        return new PessoaDao().listarTodos();
    }

    public List pesquisaSimples(String strCamposPesqisa, String strPesquisa) {
        return new PessoaDao().pesquisaSimples(strCamposPesqisa, strPesquisa, " and a.modeloPessoa.idModeloPessoa = 5");
    }
}
