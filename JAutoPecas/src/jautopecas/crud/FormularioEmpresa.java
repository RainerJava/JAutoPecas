package jautopecas.crud;

import jautopecas.components.validadores.ValidadorCPF;
import jautopecas.dao.pessoa.EmpresaDao;
import jautopecas.entidades.pessoa.Empresa;
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
        jtfCnpj = new jautopecas.components.JFTextField();
        jlCnpj = new javax.swing.JLabel();
        jtfRazaoSocial = new jautopecas.components.JFTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        cadEnderecoGUI1 = new jautopecas.crud.pessoa.endereco.FormularioEndereco();

        setMinimumSize(new java.awt.Dimension(587, 153));
        setPreferredSize(new java.awt.Dimension(639, 547));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtfIdEmpresa.setEditable(false);
        jtfIdEmpresa.setEnabled(false);
        jtfIdEmpresa.setMensagemAjuda("ID Empresa (Gerado pelo sistema)");
        add(jtfIdEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 60, -1));

        jlIdEmpresa.setText("ID Empresa");
        add(jlIdEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jlRazaoSocial.setText("Razão Social");
        add(jlRazaoSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 57, 333, -1));

        jtfNomeFantasia.setClasseFormulario("");
        jtfNomeFantasia.setMensagemAjuda("Nome Fantasia da empresa");
        jtfNomeFantasia.setRequerido(false);
        add(jtfNomeFantasia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, 333, -1));

        jlNomeFantasia.setText("Nome Fantasia");
        add(jlNomeFantasia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 103, 333, -1));

        jtfCnpj.setMensagemAjuda("CNPJ da empresa");
        jtfCnpj.setRequerido(false);
        jtfCnpj.setValidador(new ValidadorCPF(jtfCnpj));
        add(jtfCnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 31, 267, -1));

        jlCnpj.setText("CNPJ");
        add(jlCnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 11, 267, -1));

        jtfRazaoSocial.setMensagemAjuda("Razão Social da empresa");
        jtfRazaoSocial.setRequerido(false);
        add(jtfRazaoSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 77, 332, -1));

        jPanel1.add(cadEnderecoGUI1);

        jTabbedPane1.addTab("Endereços", jPanel1);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 620, 390));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jautopecas.crud.pessoa.endereco.FormularioEndereco cadEnderecoGUI1;
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

        cadEnderecoGUI1.setListaEnderecos(empresa.getEnderecos());
        cadEnderecoGUI1.setPessoa(empresa);
    }

    @Override
    public void salvar() throws Exception {
        empresa = new Empresa();
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
        empresa.setIdPessoa(Long.valueOf(jtfIdEmpresa.getText().length() == 0 ? "0" : jtfIdEmpresa.getText()));
        empresa.setRazaoSocial(jtfRazaoSocial.getText());
        empresa.setNomeFantasia(jtfNomeFantasia.getText());
        empresa.setCnpj(jtfCnpj.getText());
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
