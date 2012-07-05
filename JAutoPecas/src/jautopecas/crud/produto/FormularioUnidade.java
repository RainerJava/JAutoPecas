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
        jtfNome = new jautopecas.components.JTextField();
        jlIdUnidade = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(498, 274));

        jtfIdUnidade.setEditable(false);
        jtfIdUnidade.setEnabled(false);
        jtfIdUnidade.setMensagemAjuda("ID Unidade (Gerado automaticamente pelo sistema)");

        jtfNome.setMaximoCaracteres(150);
        jtfNome.setMensagemAjuda("Nome da unidade");
        jtfNome.setRequerido(true);

        jlIdUnidade.setText("ID Unidade");

        jlNome.setText("Nome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jlIdUnidade)
                                .addComponent(jlNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jtfIdUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 373, Short.MAX_VALUE))
                    .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlIdUnidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfIdUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlIdUnidade;
    private javax.swing.JLabel jlNome;
    private jautopecas.components.JTextField jtfIdUnidade;
    private jautopecas.components.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
    private Unidade unidade;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        unidade = (Unidade) objetoFormulario;
        jtfIdUnidade.setText(String.valueOf(unidade.getIdUnidade()));
        jtfNome.setText(unidade.getNome());
    }

    @Override
    public void salvar() throws Exception {
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
        if (unidade == null) {
            unidade = new Unidade();
        }
        unidade.setIdUnidade(Integer.valueOf(jtfIdUnidade.getText().length() == 0 ? "0" : jtfIdUnidade.getText()));
        unidade.setNome(jtfNome.getText());
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
