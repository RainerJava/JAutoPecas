package jautopecas.crud.pessoa.endereco;

import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.endereco.EstadoDao;
import jautopecas.dao.pessoa.endereco.TipoLogradouroDao;
import jautopecas.entidades.pessoa.endereco.TipoLogradouro;
import java.util.List;

/**
 *
 * @author JFFiorotto
 */
public class FormularioTipoLogradouro extends javax.swing.JPanel implements IFormulario {

    /**
     * Creates new form formularioEmpresa
     */
    public FormularioTipoLogradouro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfIdTipoLogradouro = new jautopecas.components.JTextField();
        jlIdTipoLogradouro = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jtfNome = new jautopecas.components.JTextField();

        setPreferredSize(new java.awt.Dimension(498, 274));

        jtfIdTipoLogradouro.setEnabled(false);
        jtfIdTipoLogradouro.setMensagemAjuda("Sigla do Estado");

        jlIdTipoLogradouro.setText("ID");

        jlNome.setText("Nome");

        jtfNome.setMaximoCaracteres(50);
        jtfNome.setMensagemAjuda("Tipo de Logradouro Ex;. Rua,Avenida,Viela, etc...");
        jtfNome.setRequerido(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jlIdTipoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jtfIdTipoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 198, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jlIdTipoLogradouro)
                .addGap(6, 6, 6)
                .addComponent(jtfIdTipoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNome)
                .addGap(6, 6, 6)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlIdTipoLogradouro;
    private javax.swing.JLabel jlNome;
    private jautopecas.components.JTextField jtfIdTipoLogradouro;
    private jautopecas.components.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
    private TipoLogradouro tipoLogradouro;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        tipoLogradouro = (TipoLogradouro) objetoFormulario;
        jtfIdTipoLogradouro.setText(tipoLogradouro.getIdTipoLogradouro().toString());
        jtfNome.setText(tipoLogradouro.getNome());
    }

    @Override
    public void salvar() throws Exception {
        new TipoLogradouroDao().salvar(getObjetoFormulario());
        setObjetoFormulario(tipoLogradouro);
    }

    @Override
    public void alterar() throws Exception {
        new TipoLogradouroDao().alterar(getObjetoFormulario());
        setObjetoFormulario(tipoLogradouro);
    }

    @Override
    public void excluir() throws Exception {
        new TipoLogradouroDao().excluir(tipoLogradouro);
    }

    @Override
    public TipoLogradouro getObjetoFormulario() throws Exception {
        if (tipoLogradouro == null) {
            tipoLogradouro = new TipoLogradouro();
        }
        tipoLogradouro.setNome(jtfNome.getText());
        return tipoLogradouro;
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
        return new EstadoDao().listarTodos();
    }

    public List pesquisaSimples(String strCamposPesqisa, String strPesquisa) {
        return new TipoLogradouroDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
