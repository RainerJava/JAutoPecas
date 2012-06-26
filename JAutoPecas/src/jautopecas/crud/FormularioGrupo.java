package jautopecas.crud;

import jautopecas.components.validadores.ValidadorStringLength;
import jautopecas.dao.GrupoDao;
import jautopecas.entidades.Grupo;
import java.util.List;
import javax.swing.JLabel;

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

        jFTextField1 = new jautopecas.components.JTextField();
        jFTextField2 = new jautopecas.components.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(260, 108));

        jFTextField1.setEditable(false);
        jFTextField1.setEnabled(false);

        jLabel1.setText("ID Grupo");

        jLabel2.setText("Nome Grupo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jFTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jFTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jFTextField1.setMensagemAjuda("Codigo do Grupo (Gerado pelo sistema)");
        jFTextField2.setValidador(new ValidadorStringLength(jFTextField2, 4, 20));
        jFTextField2.setMensagemAjuda("Informe o nome do grupo.");
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jautopecas.components.JTextField jFTextField1;
    private jautopecas.components.JTextField jFTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
    private Grupo grupo;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        grupo = (Grupo) objetoFormulario;
        jFTextField1.setText(String.valueOf(grupo.getIdGrupo()));
        jFTextField2.setText(grupo.getNome());
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
        grupo.setIdGrupo(Integer.valueOf(jFTextField1.getText().length() == 0 ? "0" : jFTextField1.getText()));
        grupo.setNome(jFTextField2.getText());
        return grupo;
    }

    @Override
    public JLabel getJlInformacao() {
        return ((WindowCrud) getTopLevelAncestor()).getJlInformacao();
    }

    @Override
    public List pesquisar(String strPesquisa) throws Exception {
        return new GrupoDao().listarTodos();
    }

    public List pesquisaSimples(String strCamposPesqisa, String strPesquisa) {
        return new GrupoDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
