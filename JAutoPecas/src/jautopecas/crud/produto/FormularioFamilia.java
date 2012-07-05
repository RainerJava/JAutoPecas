package jautopecas.crud.produto;

import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.produto.FamiliaDao;
import jautopecas.entidades.produto.Familia;
import java.util.List;

/**
 *
 * @author JFFiorotto
 */
public class FormularioFamilia extends javax.swing.JPanel implements IFormulario {

    /**
     * Creates new form formularioEmpresa
     */
    public FormularioFamilia() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfIdFamilia = new jautopecas.components.JTextField();
        jtfNome = new jautopecas.components.JTextField();
        jlIdFamilia = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(498, 274));

        jtfIdFamilia.setEditable(false);
        jtfIdFamilia.setEnabled(false);
        jtfIdFamilia.setMensagemAjuda("ID Familia (Gerado automaticamente pelo sistema)");

        jtfNome.setMaximoCaracteres(150);
        jtfNome.setMensagemAjuda("Nome da familia");
        jtfNome.setRequerido(true);

        jlIdFamilia.setText("ID Familia");

        jlNome.setText("Nome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jlIdFamilia)
                                .addComponent(jlNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jtfIdFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 392, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlIdFamilia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfIdFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlIdFamilia;
    private javax.swing.JLabel jlNome;
    private jautopecas.components.JTextField jtfIdFamilia;
    private jautopecas.components.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
    private Familia familia;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        familia = (Familia) objetoFormulario;
        jtfIdFamilia.setText(String.valueOf(familia.getIdFamilia()));
        jtfNome.setText(familia.getNome());
    }

    @Override
    public void salvar() throws Exception {
        new FamiliaDao().salvar(getObjetoFormulario());
        setObjetoFormulario(familia);
    }

    @Override
    public void alterar() throws Exception {
        new FamiliaDao().alterar(getObjetoFormulario());
        setObjetoFormulario(familia);
    }

    @Override
    public void excluir() throws Exception {
        new FamiliaDao().excluir(familia);
    }

    @Override
    public Familia getObjetoFormulario() throws Exception {
        if (familia == null) {
            familia = new Familia();
        }
        familia.setNome(jtfNome.getText());
        return familia;
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
        return new FamiliaDao().listarTodos();
    }

    public List pesquisaSimples(String strCamposPesqisa, String strPesquisa) {
        return new FamiliaDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
