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
        jtfNome = new jautopecas.components.JTextField();
        jlIdMarca = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(498, 274));

        jtfIdMarca.setEditable(false);
        jtfIdMarca.setEnabled(false);
        jtfIdMarca.setMensagemAjuda("ID Grupo (Gerado automaticamente pelo sistema)");

        jtfNome.setMaximoCaracteres(150);
        jtfNome.setMensagemAjuda("Nome da marca");
        jtfNome.setRequerido(true);

        jlIdMarca.setText("ID Marca");

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
                                .addComponent(jlIdMarca)
                                .addComponent(jlNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jtfIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 380, Short.MAX_VALUE))
                    .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlIdMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlIdMarca;
    private javax.swing.JLabel jlNome;
    private jautopecas.components.JTextField jtfIdMarca;
    private jautopecas.components.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
    private Marca marca;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        marca = (Marca) objetoFormulario;
        jtfIdMarca.setText(String.valueOf(marca.getIdMarca()));
        jtfNome.setText(marca.getNome());
    }

    @Override
    public void salvar() throws Exception {
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
        if (marca == null) {
            marca = new Marca();
        }
        marca.setIdMarca(Integer.valueOf(jtfIdMarca.getText().length() == 0 ? "0" : jtfIdMarca.getText()));
        marca.setNome(jtfNome.getText());
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
