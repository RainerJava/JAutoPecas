package jautopecas.crud.produto;

import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.produto.UnidadeDao;
import jautopecas.entidades.produto.Unidade;
import java.util.List;

/**
 *
 * @author JFFiorotto
 */
public class FormularioUnidade extends javax.swing.JPanel implements IFormulario {

    /**
     * Creates new form formularioEmpresa
     */
    public FormularioUnidade() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfIdUnidade = new jautopecas.components.JTextField();
        jtfNomeUnidade = new jautopecas.components.JTextField();
        jlIdUnidade = new javax.swing.JLabel();
        jlNomeUnidade = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(498, 274));

        jtfIdUnidade.setEditable(false);
        jtfIdUnidade.setEnabled(false);
        jtfIdUnidade.setMensagemAjuda("ID Unidade (Gerado automaticamente pelo sistema)");

        jtfNomeUnidade.setMaximoCaracteres(150);
        jtfNomeUnidade.setMensagemAjuda("Nome da unidade");
        jtfNomeUnidade.setRequerido(true);

        jlIdUnidade.setText("ID Unidade");

        jlNomeUnidade.setText("Nome Unidade");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jlIdUnidade)
                        .addComponent(jlNomeUnidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfIdUnidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jtfNomeUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlIdUnidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfIdUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNomeUnidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNomeUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlIdUnidade;
    private javax.swing.JLabel jlNomeUnidade;
    private jautopecas.components.JTextField jtfIdUnidade;
    private jautopecas.components.JTextField jtfNomeUnidade;
    // End of variables declaration//GEN-END:variables
    private Unidade unidade;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        unidade = (Unidade) objetoFormulario;
        jtfIdUnidade.setText(String.valueOf(unidade.getIdUnidade()));
        jtfNomeUnidade.setText(unidade.getNome());
    }

    @Override
    public void salvar() throws Exception {
        unidade = new Unidade();
        new UnidadeDao().salvar(getObjetoFormulario());
        setObjetoFormulario(unidade);
    }

    @Override
    public void alterar() throws Exception {
        new UnidadeDao().alterar(getObjetoFormulario());
        setObjetoFormulario(unidade);
    }

    @Override
    public void excluir() throws Exception {
        new UnidadeDao().excluir(unidade);
    }

    @Override
    public Unidade getObjetoFormulario() throws Exception {
        unidade.setIdUnidade(Integer.valueOf(jtfIdUnidade.getText().length() == 0 ? "0" : jtfIdUnidade.getText()));
        unidade.setNome(jtfNomeUnidade.getText());
        return unidade;
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
        return new UnidadeDao().listarTodos();
    }

    public List pesquisaSimples(String strCamposPesqisa, String strPesquisa) {
        return new UnidadeDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
