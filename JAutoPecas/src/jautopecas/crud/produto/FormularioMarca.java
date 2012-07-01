package jautopecas.crud.produto;

import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.produto.MarcaDao;
import jautopecas.entidades.produto.Marca;
import java.util.List;

/**
 *
 * @author JFFiorotto
 */
public class FormularioMarca extends javax.swing.JPanel implements IFormulario {

    /**
     * Creates new form formularioEmpresa
     */
    public FormularioMarca() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfIdMarca = new jautopecas.components.JTextField();
        jtfNomeMarca = new jautopecas.components.JTextField();
        jlIdMarca = new javax.swing.JLabel();
        jlNomeMarca = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(498, 274));

        jtfIdMarca.setEditable(false);
        jtfIdMarca.setEnabled(false);
        jtfIdMarca.setMensagemAjuda("ID Grupo (Gerado automaticamente pelo sistema)");

        jtfNomeMarca.setMaximoCaracteres(150);
        jtfNomeMarca.setMensagemAjuda("Nome da marca");
        jtfNomeMarca.setRequerido(true);

        jlIdMarca.setText("ID Marca");

        jlNomeMarca.setText("Nome Marca");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jlIdMarca)
                        .addComponent(jlNomeMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfIdMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jtfNomeMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlIdMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNomeMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNomeMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlIdMarca;
    private javax.swing.JLabel jlNomeMarca;
    private jautopecas.components.JTextField jtfIdMarca;
    private jautopecas.components.JTextField jtfNomeMarca;
    // End of variables declaration//GEN-END:variables
    private Marca marca;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        marca = (Marca) objetoFormulario;
        jtfIdMarca.setText(String.valueOf(marca.getIdMarca()));
        jtfNomeMarca.setText(marca.getNome());
    }

    @Override
    public void salvar() throws Exception {
        marca = new Marca();
        new MarcaDao().salvar(getObjetoFormulario());
        setObjetoFormulario(marca);
    }

    @Override
    public void alterar() throws Exception {
        new MarcaDao().alterar(getObjetoFormulario());
        setObjetoFormulario(marca);
    }

    @Override
    public void excluir() throws Exception {
        new MarcaDao().excluir(marca);
    }

    @Override
    public Marca getObjetoFormulario() throws Exception {
        marca.setIdMarca(Integer.valueOf(jtfIdMarca.getText().length() == 0 ? "0" : jtfIdMarca.getText()));
        marca.setNome(jtfNomeMarca.getText());
        return marca;
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
        return new MarcaDao().listarTodos();
    }

    public List pesquisaSimples(String strCamposPesqisa, String strPesquisa) {
        return new MarcaDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
