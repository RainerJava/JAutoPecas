package jautopecas.crud;

import jautopecas.components.validadores.ValidadorCnpj;
import jautopecas.dao.pessoa.EmpresaDao;
import jautopecas.entidades.pessoa.Empresa;
import jautopecas.entidades.pessoa.endereco.Endereco;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author JFFiorotto
 */
public class FormularioEmpresa extends javax.swing.JPanel implements IFormulario {

    public FormularioEmpresa() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfIdEmpresa = new jautopecas.components.JFTextField();
        jlIdEmpresa = new javax.swing.JLabel();
        jlRazaoSocial = new javax.swing.JLabel();
        jtfNomeFantasia = new jautopecas.components.JFTextField();
        jlNomeFantasia = new javax.swing.JLabel();
        jlCnpj = new javax.swing.JLabel();
        jtfRazaoSocial = new jautopecas.components.JFTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        formularioEndereco = new jautopecas.crud.pessoa.endereco.FormularioEndereco();
        jtfCnpj = new jautopecas.components.JFTextField();

        setPreferredSize(new java.awt.Dimension(639, 473));

        jtfIdEmpresa.setEditable(false);
        jtfIdEmpresa.setEnabled(false);
        jtfIdEmpresa.setMensagemAjuda("ID Empresa (Gerado pelo sistema)");

        jlIdEmpresa.setText("ID Empresa");

        jlRazaoSocial.setText("Razão Social");

        jtfNomeFantasia.setClasseFormulario("");
        jtfNomeFantasia.setMensagemAjuda("Nome Fantasia da empresa");
        jtfNomeFantasia.setRequerido(false);

        jlNomeFantasia.setText("Nome Fantasia");

        jlCnpj.setText("CNPJ");

        jtfRazaoSocial.setMensagemAjuda("Razão Social da empresa");
        jtfRazaoSocial.setRequerido(false);

        formularioEndereco.carregaCombos();
        jPanel1.add(formularioEndereco);

        jTabbedPane1.addTab("Endereços", jPanel1);

        try {
            jtfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfCnpj.setValidador(new ValidadorCnpj(jtfCnpj));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jlIdEmpresa)
                        .addGap(11, 11, 11)
                        .addComponent(jlCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jtfRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jlNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jtfNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfIdEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlIdEmpresa)
                    .addComponent(jlCnpj))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfIdEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jlRazaoSocial)
                .addGap(6, 6, 6)
                .addComponent(jtfRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jlNomeFantasia)
                .addGap(6, 6, 6)
                .addComponent(jtfNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jautopecas.crud.pessoa.endereco.FormularioEndereco formularioEndereco;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlCnpj;
    private javax.swing.JLabel jlIdEmpresa;
    private javax.swing.JLabel jlNomeFantasia;
    private javax.swing.JLabel jlRazaoSocial;
    private jautopecas.components.JFTextField jtfCnpj;
    private jautopecas.components.JFTextField jtfIdEmpresa;
    private jautopecas.components.JFTextField jtfNomeFantasia;
    private jautopecas.components.JFTextField jtfRazaoSocial;
    // End of variables declaration//GEN-END:variables
    private Empresa empresa;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        empresa = (Empresa) objetoFormulario;
        jtfIdEmpresa.setText(String.valueOf(empresa.getIdPessoa()));
        jtfCnpj.setText(empresa.getCnpj());
        jtfRazaoSocial.setText(empresa.getRazaoSocial());
        jtfNomeFantasia.setText(empresa.getNomeFantasia());
        formularioEndereco.setListaEnderecos(empresa.getEnderecos());
    }

    @Override
    public void salvar() throws Exception {
        new EmpresaDao().salvar(getObjetoFormulario());
        setObjetoFormulario(empresa);
    }

    @Override
    public void alterar() throws Exception {
        new EmpresaDao().alterar(getObjetoFormulario());
        setObjetoFormulario(empresa);
    }

    @Override
    public void excluir() throws Exception {
        new EmpresaDao().excluir(empresa);
    }

    @Override
    public Empresa getObjetoFormulario() throws Exception {
        if (empresa == null) {
            empresa = new Empresa();
        }
        empresa.setIdPessoa(Long.valueOf(jtfIdEmpresa.getText().length() == 0 ? "0" : jtfIdEmpresa.getText()));
        empresa.setRazaoSocial(jtfRazaoSocial.getText());
        empresa.setNomeFantasia(jtfNomeFantasia.getText());
        empresa.setCnpj(jtfCnpj.getText());
        empresa.setEnderecos(formularioEndereco.getEnderecos());
        for (Endereco endereco : empresa.getEnderecos()) {
            endereco.setPessoa(empresa);
        }
        return empresa;
    }

    @Override
    public JLabel getJlInformacao() {
        return ((WindowCrud) getTopLevelAncestor()).getJlInformacao();
    }

    @Override
    public List pesquisar(String strPesquisa) throws Exception {
        return new EmpresaDao().listarTodos();
    }

    public List pesquisaSimples(String strCamposPesqisa, String strPesquisa) {
        return new EmpresaDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
