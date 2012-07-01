package jautopecas.crud.produto;

import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.produto.GrupoDao;
import jautopecas.entidades.produto.Grupo;
import java.util.List;

/**
 *
 * @author JFFiorotto
 */
public class FormularioGrupo extends javax.swing.JPanel implements IFormulario {

    /**
     * Creates new form formularioEmpresa
     */
    public FormularioGrupo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfIdGrupo = new jautopecas.components.JTextField();
        jtfNomeGrupo = new jautopecas.components.JTextField();
        jlIdGrupo = new javax.swing.JLabel();
        jlNomeGrupo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(498, 274));

        jtfIdGrupo.setEditable(false);
        jtfIdGrupo.setEnabled(false);
        jtfIdGrupo.setMensagemAjuda("ID Grupo (Gerado automaticamente pelo sistema)");

        jtfNomeGrupo.setMaximoCaracteres(45);
        jtfNomeGrupo.setMensagemAjuda("Nome do grupo");
        jtfNomeGrupo.setRequerido(true);

        jlIdGrupo.setText("ID Grupo");

        jlNomeGrupo.setText("Nome Grupo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jlIdGrupo)
                        .addComponent(jlNomeGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfIdGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jtfNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlIdGrupo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfIdGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNomeGrupo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlIdGrupo;
    private javax.swing.JLabel jlNomeGrupo;
    private jautopecas.components.JTextField jtfIdGrupo;
    private jautopecas.components.JTextField jtfNomeGrupo;
    // End of variables declaration//GEN-END:variables
    private Grupo grupo;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        grupo = (Grupo) objetoFormulario;
        jtfIdGrupo.setText(String.valueOf(grupo.getIdGrupo()));
        jtfNomeGrupo.setText(grupo.getNome());
    }

    @Override
    public void salvar() throws Exception {
        grupo = new Grupo();
        new GrupoDao().salvar(getObjetoFormulario());
        setObjetoFormulario(grupo);
    }

    @Override
    public void alterar() throws Exception {
        new GrupoDao().alterar(getObjetoFormulario());
        setObjetoFormulario(grupo);
    }

    @Override
    public void excluir() throws Exception {
        new GrupoDao().excluir(grupo);
    }

    @Override
    public Grupo getObjetoFormulario() throws Exception {
        grupo.setIdGrupo(Integer.valueOf(jtfIdGrupo.getText().length() == 0 ? "0" : jtfIdGrupo.getText()));
        grupo.setNome(jtfNomeGrupo.getText());
        return grupo;
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
        return new GrupoDao().listarTodos();
    }

    public List pesquisaSimples(String strCamposPesqisa, String strPesquisa) {
        return new GrupoDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
