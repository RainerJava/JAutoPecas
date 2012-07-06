package jautopecas.crud.pessoa;

import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.ModeloPessoaDao;
import jautopecas.entidades.pessoa.ModeloPessoa;
import java.util.List;

/**
 *
 * @author JFFiorotto
 */
public class FormularioModeloPessoa extends javax.swing.JPanel implements IFormulario {

    /**
     * Creates new form formularioEmpresa
     */
    public FormularioModeloPessoa() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfNome = new jautopecas.components.JTextField();
        jlModeloPessoa = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jtfModeloPessoa = new jautopecas.components.JTextField();

        setPreferredSize(new java.awt.Dimension(498, 274));

        jtfNome.setMaximoCaracteres(50);
        jtfNome.setMensagemAjuda("Nome Tipo Produto");
        jtfNome.setRequerido(true);

        jlModeloPessoa.setText("Tipo Pessoa");

        jlNome.setText("Nome");

        jtfModeloPessoa.setMaximoCaracteres(2);
        jtfModeloPessoa.setMensagemAjuda("Nome Tipo Produto");
        jtfModeloPessoa.setRequerido(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlModeloPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlNome)
                            .addComponent(jtfModeloPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 421, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlModeloPessoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfModeloPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlModeloPessoa;
    private javax.swing.JLabel jlNome;
    private jautopecas.components.JTextField jtfModeloPessoa;
    private jautopecas.components.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
    private ModeloPessoa modeloPessoa;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        jtfModeloPessoa.setSempreBloqueado(true);
        modeloPessoa = (ModeloPessoa) objetoFormulario;
        jtfModeloPessoa.setText(String.valueOf(modeloPessoa.getModeloPessoa()));
        jtfNome.setText(modeloPessoa.getNome());
    }

    @Override
    public void salvar() throws Exception {
        new ModeloPessoaDao().salvar(getObjetoFormulario());
        setObjetoFormulario(modeloPessoa);
    }

    @Override
    public void alterar() throws Exception {
        new ModeloPessoaDao().alterar(getObjetoFormulario());
        setObjetoFormulario(modeloPessoa);
    }

    @Override
    public void excluir() throws Exception {
        new ModeloPessoaDao().excluir(modeloPessoa);
    }

    @Override
    public ModeloPessoa getObjetoFormulario() throws Exception {
        if (modeloPessoa == null) {
            modeloPessoa = new ModeloPessoa();
        }
        modeloPessoa.setModeloPessoa(jtfModeloPessoa.getText());
        modeloPessoa.setNome(jtfNome.getText());
        return modeloPessoa;
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
        return new ModeloPessoaDao().listarTodos();
    }

    public List pesquisaSimples(String strCamposPesqisa, String strPesquisa) {
        return new ModeloPessoaDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
