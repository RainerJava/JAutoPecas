package jautopecas.crud.pessoa.fabricante;

import jautopecas.crud.pessoa.fornecedor.*;
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
public class FormularioFabricante extends javax.swing.JPanel implements IFormulario {

    public FormularioFabricante() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfIdFabricante = new jautopecas.components.JTextField();
        jlIdFabricante = new javax.swing.JLabel();
        jlRazaoSocial = new javax.swing.JLabel();
        jtfNomeFantasia = new jautopecas.components.JTextField();
        jlNomeFantasia = new javax.swing.JLabel();
        jlCnpj = new javax.swing.JLabel();
        jtfRazaoSocial = new jautopecas.components.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        formularioEndereco = new jautopecas.crud.pessoa.endereco.FormularioEndereco();
        jPanel2 = new javax.swing.JPanel();
        formularioTelefone = new jautopecas.crud.pessoa.telefone.FormularioTelefone();
        jtfCnpj = new jautopecas.components.JTextField();
        jlInscricaoEstadual = new javax.swing.JLabel();
        jtfInscricaoEstadual = new jautopecas.components.JTextField();

        setPreferredSize(new java.awt.Dimension(800, 550));

        jtfIdFabricante.setEditable(false);
        jtfIdFabricante.setEnabled(false);
        jtfIdFabricante.setMensagemAjuda("ID Fornecedor (Gerado pelo sistema)");

        jlIdFabricante.setText("ID Fabricante");

        jlRazaoSocial.setText("Razão Social");

        jtfNomeFantasia.setClasseFormulario("");
        jtfNomeFantasia.setMensagemAjuda("Nome Fantasia do fornecedor");
        jtfNomeFantasia.setRequerido(false);

        jlNomeFantasia.setText("Nome Fantasia");

        jlCnpj.setText("CNPJ");

        jtfRazaoSocial.setMensagemAjuda("Razão Social do fornecedor");
        jtfRazaoSocial.setRequerido(false);

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

        jlInscricaoEstadual.setText("Inscricão Estadual");

        jtfInscricaoEstadual.setRequerido(false);

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
                                .addComponent(jlCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jlInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jlNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtfIdFabricante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlIdFabricante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 160, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jtfRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNomeFantasia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jtfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfInscricaoEstadual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jlIdFabricante)
                .addGap(6, 6, 6)
                .addComponent(jtfIdFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCnpj)
                    .addComponent(jlInscricaoEstadual))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfInscricaoEstadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlRazaoSocial)
                    .addComponent(jlNomeFantasia))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jautopecas.crud.pessoa.endereco.FormularioEndereco formularioEndereco;
    private jautopecas.crud.pessoa.telefone.FormularioTelefone formularioTelefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlCnpj;
    private javax.swing.JLabel jlIdFabricante;
    private javax.swing.JLabel jlInscricaoEstadual;
    private javax.swing.JLabel jlNomeFantasia;
    private javax.swing.JLabel jlRazaoSocial;
    private jautopecas.components.JTextField jtfCnpj;
    private jautopecas.components.JTextField jtfIdFabricante;
    private jautopecas.components.JTextField jtfInscricaoEstadual;
    private jautopecas.components.JTextField jtfNomeFantasia;
    private jautopecas.components.JTextField jtfRazaoSocial;
    // End of variables declaration//GEN-END:variables
    private Pessoa pessoa;
    private ModeloPessoa modeloPessoa;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        pessoa = (Pessoa) objetoFormulario;
        jtfIdFabricante.setText(String.valueOf(pessoa.getIdPessoa()));
        jtfRazaoSocial.setText(pessoa.getNome());
        jtfNomeFantasia.setText(pessoa.getApelido());
        jtfInscricaoEstadual.setText(pessoa.getAdicionalPessoa().getInscricaoEstadual());
        jtfCnpj.setText(pessoa.getDocumento());
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
            modeloPessoa = new ModeloPessoaDao().load(3);
        }
        pessoa.setIdPessoa(Integer.valueOf(jtfIdFabricante.getText().length() == 0 ? "0" : jtfIdFabricante.getText()));
        pessoa.setModeloPessoa(modeloPessoa);
        pessoa.setApelido(jtfNomeFantasia.getText());
        pessoa.setNome(jtfRazaoSocial.getText());
        pessoa.getAdicionalPessoa().setPessoa(pessoa);
        pessoa.setDocumento(jtfCnpj.getText());
        pessoa.getAdicionalPessoa().setInscricaoEstadual(jtfInscricaoEstadual.getText());
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
        return new PessoaDao().pesquisaSimples(strCamposPesqisa, strPesquisa, " and a.modeloPessoa.idModeloPessoa = 3");
    }
}
