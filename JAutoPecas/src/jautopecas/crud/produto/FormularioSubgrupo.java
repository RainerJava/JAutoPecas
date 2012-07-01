package jautopecas.crud.produto;

import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.produto.SubgrupoDao;
import jautopecas.entidades.produto.Subgrupo;
import java.util.List;

/**
 *
 * @author JFFiorotto
 */
public class FormularioSubgrupo extends javax.swing.JPanel implements IFormulario {

    /**
     * Creates new form formularioEmpresa
     */
    public FormularioSubgrupo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfIdSubgrupo = new jautopecas.components.JTextField();
        jtfNomeSubgrupo = new jautopecas.components.JTextField();
        jlIdSubgrupo = new javax.swing.JLabel();
        jlNomeSubgrupo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(498, 274));

        jtfIdSubgrupo.setEditable(false);
        jtfIdSubgrupo.setEnabled(false);
        jtfIdSubgrupo.setMensagemAjuda("ID Subgrupo (Gerado automaticamente pelo sistema)");

        jtfNomeSubgrupo.setMaximoCaracteres(150);
        jtfNomeSubgrupo.setMensagemAjuda("Nome do subgrupo");
        jtfNomeSubgrupo.setRequerido(true);

        jlIdSubgrupo.setText("ID Subgrupo");

        jlNomeSubgrupo.setText("Nome Subgrupo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jlIdSubgrupo)
                        .addComponent(jlNomeSubgrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfIdSubgrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jtfNomeSubgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlIdSubgrupo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfIdSubgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNomeSubgrupo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNomeSubgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlIdSubgrupo;
    private javax.swing.JLabel jlNomeSubgrupo;
    private jautopecas.components.JTextField jtfIdSubgrupo;
    private jautopecas.components.JTextField jtfNomeSubgrupo;
    // End of variables declaration//GEN-END:variables
    private Subgrupo subgrupo;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        subgrupo = (Subgrupo) objetoFormulario;
        jtfIdSubgrupo.setText(String.valueOf(subgrupo.getIdSubgrupo()));
        jtfNomeSubgrupo.setText(subgrupo.getNome());
    }

    @Override
    public void salvar() throws Exception {
        subgrupo = new Subgrupo();
        new SubgrupoDao().salvar(getObjetoFormulario());
        setObjetoFormulario(subgrupo);
    }

    @Override
    public void alterar() throws Exception {
        new SubgrupoDao().alterar(getObjetoFormulario());
        setObjetoFormulario(subgrupo);
    }

    @Override
    public void excluir() throws Exception {
        new SubgrupoDao().excluir(subgrupo);
    }

    @Override
    public Subgrupo getObjetoFormulario() throws Exception {
        subgrupo.setIdSubgrupo(Integer.valueOf(jtfIdSubgrupo.getText().length() == 0 ? "0" : jtfIdSubgrupo.getText()));
        subgrupo.setNome(jtfNomeSubgrupo.getText());
        return subgrupo;
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
        return new SubgrupoDao().listarTodos();
    }

    public List pesquisaSimples(String strCamposPesqisa, String strPesquisa) {
        return new SubgrupoDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
