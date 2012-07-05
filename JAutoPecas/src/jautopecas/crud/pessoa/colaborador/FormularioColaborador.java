package jautopecas.crud.pessoa.colaborador;

import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.ModeloPessoaDao;
import jautopecas.dao.pessoa.PessoaDao;
import jautopecas.entidades.pessoa.AdicionalPessoa;
import jautopecas.entidades.pessoa.ModeloPessoa;
import jautopecas.entidades.pessoa.Pessoa;
import jautopecas.entidades.pessoa.colaborador.FuncaoSalarioColaborador;
import jautopecas.entidades.pessoa.endereco.Cidade;
import jautopecas.entidades.pessoa.endereco.EnderecoPessoa;
import jautopecas.entidades.pessoa.login.LoginPessoa;
import jautopecas.entidades.pessoa.telefone.TelefonePessoa;
import jautopecas.util.StringUtils;
import java.util.List;

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
        jcbSexo = new jautopecas.components.JComboBox();
        jlSexo = new javax.swing.JLabel();
        jtfDataNascimento = new jautopecas.components.JTextField();
        jlDataNascimento = new javax.swing.JLabel();
        jcbRacaCor = new jautopecas.components.JComboBox();
        jlRacaCor = new javax.swing.JLabel();
        jlNacionalidade = new javax.swing.JLabel();
        jtfNaturalidade = new jautopecas.components.JTextField();
        jlNaturalidadeCidade = new javax.swing.JLabel();
        jtfNaturalidadeUf = new jautopecas.components.JTextField();
        jtfNacionalidade = new jautopecas.components.JTextField();
        jtfNomePai = new jautopecas.components.JTextField();
        jlNomePai = new javax.swing.JLabel();
        jtfNomeMae = new jautopecas.components.JTextField();
        jlNomeMae = new javax.swing.JLabel();
        jlNaturalidadeUf = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jtfRg = new jautopecas.components.JTextField();
        jlRg = new javax.swing.JLabel();
        jtfCpf = new jautopecas.components.JTextField();
        jlCpf = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        formularioFuncaoSalarioColaborador = new jautopecas.crud.pessoa.colaborador.FormularioFuncaoSalarioColaborador();

        setPreferredSize(new java.awt.Dimension(800, 550));

        jlApelido.setText("Apelido");

        jtfApelido.setClasseFormulario("");
        jtfApelido.setMensagemAjuda("Apelido (Informar Primeiro nome)");
        jtfApelido.setRequerido(false);

        jtfNome.setMensagemAjuda("Nome Completo");
        jtfNome.setRequerido(false);

        jlNome.setText("Nome Completo");

        jtfIdEmpresa.setEditable(false);
        jtfIdEmpresa.setEnabled(false);
        jtfIdEmpresa.setMensagemAjuda("ID Colaborador (Gerado pelo sistema)");

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

        jcbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
        jcbSexo.setMensagemAjuda("Sexo (Informar o mesmo que consta no RG)");

        jlSexo.setText("Sexo");

        jtfDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jtfDataNascimento.setMensagemAjuda("Data de Nascimento");
        jtfDataNascimento.setRequerido(false);

        jlDataNascimento.setText("Data Nascimento");

        jcbRacaCor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Branca", "Preta", "Amarela", "Parda", "Indigina" }));
        jcbRacaCor.setMensagemAjuda("Raça/Cor (Informar o mesmo que consta no RG)");

        jlRacaCor.setText("Raça/Cor");

        jlNacionalidade.setText("Nacionalidade");

        jtfNaturalidade.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioCidade");
        jtfNaturalidade.setMensagemAjuda("Naturalidade");
        jtfNaturalidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNaturalidadeFocusLost(evt);
            }
        });

        jlNaturalidadeCidade.setText("Naturalidade");

        jtfNaturalidadeUf.setEditable(false);
        jtfNaturalidadeUf.setEnabled(false);
        jtfNaturalidadeUf.setMensagemAjuda("ID Empresa (Gerado pelo sistema)");

        jtfNacionalidade.setEditable(false);
        jtfNacionalidade.setEnabled(false);
        jtfNacionalidade.setMensagemAjuda("ID Empresa (Gerado pelo sistema)");
        jtfNacionalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNacionalidadeActionPerformed(evt);
            }
        });

        jtfNomePai.setMensagemAjuda("Nome Completo do Pai (Se não tiver deixar em branco)");
        jtfNomePai.setRequerido(false);

        jlNomePai.setText("Nome Pai");

        jtfNomeMae.setMensagemAjuda("Nome da mãe completo");
        jtfNomeMae.setRequerido(false);

        jlNomeMae.setText("Nome Mãe");

        jlNaturalidadeUf.setText("Naturalidade");

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
                                        .addComponent(jcbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcbRacaCor, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlNaturalidadeCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jtfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jlNomePai))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfNaturalidadeUf, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlNaturalidadeUf, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jlNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jtfNacionalidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtfNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jlNomeMae)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtfNomeMae, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(jcbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbRacaCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jlNaturalidadeCidade)
                    .addComponent(jlNaturalidadeUf))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfNaturalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfNaturalidadeUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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

        jPanel6.setLayout(new java.awt.BorderLayout());
        jPanel6.add(formularioFuncaoSalarioColaborador, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab("Função/Salario", jPanel6);

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

    private void jtfNaturalidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNaturalidadeFocusLost
        if (jtfNaturalidade.getObjeto() != null) {
            jtfNaturalidadeUf.setText(((Cidade) jtfNaturalidade.getObjeto()).getUf().getUf());
        }
    }//GEN-LAST:event_jtfNaturalidadeFocusLost

    private void jtfNacionalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNacionalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNacionalidadeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jautopecas.crud.pessoa.endereco.FormularioEndereco formularioEndereco;
    private jautopecas.crud.pessoa.colaborador.FormularioFuncaoSalarioColaborador formularioFuncaoSalarioColaborador;
    private jautopecas.crud.pessoa.login.FormularioLogin formularioLogin;
    private jautopecas.crud.pessoa.telefone.FormularioTelefone formularioTelefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private jautopecas.components.JComboBox jcbRacaCor;
    private jautopecas.components.JComboBox jcbSexo;
    private javax.swing.JLabel jlApelido;
    private javax.swing.JLabel jlCpf;
    private javax.swing.JLabel jlDataNascimento;
    private javax.swing.JLabel jlIdPessoa;
    private javax.swing.JLabel jlNacionalidade;
    private javax.swing.JLabel jlNaturalidadeCidade;
    private javax.swing.JLabel jlNaturalidadeUf;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlNomeMae;
    private javax.swing.JLabel jlNomePai;
    private javax.swing.JLabel jlRacaCor;
    private javax.swing.JLabel jlRg;
    private javax.swing.JLabel jlSexo;
    private jautopecas.components.JTextField jtfApelido;
    private jautopecas.components.JTextField jtfCpf;
    private jautopecas.components.JTextField jtfDataNascimento;
    private jautopecas.components.JTextField jtfIdEmpresa;
    private jautopecas.components.JTextField jtfNacionalidade;
    private jautopecas.components.JTextField jtfNaturalidade;
    private jautopecas.components.JTextField jtfNaturalidadeUf;
    private jautopecas.components.JTextField jtfNome;
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
        jcbSexo.setSelectedItem(pessoa.getAdicionalPessoa().getSexo());
        jcbRacaCor.setSelectedItem(pessoa.getAdicionalPessoa().getRacaCor());
        jtfDataNascimento.setText(StringUtils.dateToString(pessoa.getAdicionalPessoa().getDataNascimento()));
        jtfNacionalidade.setText(pessoa.getAdicionalPessoa().getNaturalidade().getUf().getPais().getNome());
        jtfNaturalidade.setObjeto(pessoa.getAdicionalPessoa().getNaturalidade());
        jtfNaturalidadeUf.setText(pessoa.getAdicionalPessoa().getNaturalidade().getUf().getNome());
        jtfNomePai.setText(pessoa.getAdicionalPessoa().getNomePai());
        jtfNomeMae.setText(pessoa.getAdicionalPessoa().getNomeMae());

        formularioEndereco.setListaEnderecoPessoa(pessoa.getEnderecoPessoa());
        formularioTelefone.setListaTelefonePessoa(pessoa.getTelefonePessoa());
        formularioLogin.setListaPessoaLogin(pessoa.getLoginPessoa());
        formularioFuncaoSalarioColaborador.setListaFuncaoSalarioColaborador(pessoa.getFuncaoSalarioColaborador());
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
        pessoa.setModeloPessoa(modeloPessoa);
        pessoa.setNome(jtfNome.getText());
        pessoa.setApelido(jtfApelido.getText());
        pessoa.setTipoPessoa(Pessoa.TIPO_PESSOA_FISICA);
        pessoa.setDocumento(jtfCpf.getText());
        pessoa.getAdicionalPessoa().setRg(jtfRg.getText());
        pessoa.getAdicionalPessoa().setSexo(jcbSexo.getSelectedItem().toString());
        pessoa.getAdicionalPessoa().setRacaCor(jcbRacaCor.getSelectedItem().toString());
        pessoa.getAdicionalPessoa().setDataNascimento(StringUtils.stringToDate(jtfDataNascimento.getText()));
        pessoa.getAdicionalPessoa().setNaturalidade((Cidade) jtfNaturalidade.getObjeto());
        pessoa.getAdicionalPessoa().setNomePai(jtfNomePai.getText());
        pessoa.getAdicionalPessoa().setNomeMae(jtfNomeMae.getText());
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
        if (formularioFuncaoSalarioColaborador.getListaFuncaoSalarioColaborador() != null && formularioFuncaoSalarioColaborador.getListaFuncaoSalarioColaborador().size() > 0) {
            pessoa.setFuncaoSalarioColaborador(formularioFuncaoSalarioColaborador.getListaFuncaoSalarioColaborador());
            for (FuncaoSalarioColaborador funcaoSalarioColaborador : pessoa.getFuncaoSalarioColaborador()) {
                funcaoSalarioColaborador.setPessoa(pessoa);
            }
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
        return new PessoaDao().pesquisaSimples(strCamposPesqisa, strPesquisa, " and a.modeloPessoa.idModeloPessoa = 5");
    }
}
