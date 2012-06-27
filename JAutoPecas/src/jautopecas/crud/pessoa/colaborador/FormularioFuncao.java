package jautopecas.crud.pessoa.colaborador;

import jautopecas.components.validadores.ValidadorStringLength;
import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.colaborador.FuncaoDao;
import jautopecas.entidades.pessoa.colaborador.Departamento;
import jautopecas.entidades.pessoa.colaborador.Funcao;
import java.util.List;

/**
 *
 * @author JFFiorotto
 */
public class FormularioFuncao extends javax.swing.JPanel implements IFormulario {

    /**
     * Creates new form formularioEmpresa
     */
    public FormularioFuncao() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfId = new jautopecas.components.JTextField();
        jlId = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jtfDepartamento = new jautopecas.components.JTextField();
        jlDepartamento = new javax.swing.JLabel();
        jtfNome = new jautopecas.components.JTextField();

        setPreferredSize(new java.awt.Dimension(384, 206));

        jtfId.setEnabled(false);
        jtfId.setMensagemAjuda("ID (Gerado automaticamente pelo sistema)");

        jlId.setText("ID");

        jlNome.setText("Nome");

        jtfDepartamento.setClasseFormulario("jautopecas.crud.pessoa.colaborador.FormularioDepartamento");
        jtfDepartamento.setMensagemAjuda("Departamento");
        jtfDepartamento.setRequerido(true);

        jlDepartamento.setText("Departamento");

        jtfNome.setMensagemAjuda("Nome da função");
        jtfNome.setRequerido(true);
        jtfNome.setValidador(new ValidadorStringLength(jtfNome, 4, 50));

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
                                .addComponent(jlId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jlNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNome)
                    .addComponent(jlId))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jlDepartamento)
                .addGap(6, 6, 6)
                .addComponent(jtfDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlDepartamento;
    private javax.swing.JLabel jlId;
    private javax.swing.JLabel jlNome;
    private jautopecas.components.JTextField jtfDepartamento;
    private jautopecas.components.JTextField jtfId;
    private jautopecas.components.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
    private Funcao funcao;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        funcao = (Funcao) objetoFormulario;
        jtfId.setText(funcao.getIdFuncao().toString());
        jtfNome.setText(funcao.getNome());
        jtfDepartamento.setObjeto(funcao.getDepartamento());
    }

    @Override
    public void salvar() throws Exception {
        funcao = new Funcao();
        new FuncaoDao().salvar(getObjetoFormulario());
        setObjetoFormulario(funcao);
    }

    @Override
    public void alterar() throws Exception {
        new FuncaoDao().alterar(getObjetoFormulario());
        setObjetoFormulario(funcao);
    }

    @Override
    public void excluir() throws Exception {
        new FuncaoDao().excluir(funcao);
    }

    @Override
    public Funcao getObjetoFormulario() throws Exception {
        funcao.setDepartamento((Departamento) jtfDepartamento.getObjeto());
        funcao.setNome(jtfNome.getText());
        return funcao;
    }

    @Override
    public MensagemRodape getMensagemRodape() {
        if (getTopLevelAncestor() instanceof WindowCrud) {
            return ((WindowCrud) getTopLevelAncestor()).getMensagemRodape();
        }
        return null;
    }

    @Override
    public List pesquisar(String strPesquisa) {
        return new FuncaoDao().listarTodos();
    }

    public List pesquisaSimples(String strCamposPesqisa, String strPesquisa) {
        return new FuncaoDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
