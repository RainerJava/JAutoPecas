package jautopecas.crud.pessoa.endereco;

import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.endereco.TipoEnderecoDao;
import jautopecas.entidades.pessoa.endereco.TipoEndereco;
import java.util.List;

/**
 *
 * @author JFFiorotto
 */
public class FormularioTipoEndereco extends javax.swing.JPanel implements IFormulario {

    public FormularioTipoEndereco() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfIdTipoEndereco = new jautopecas.components.JTextField();
        jlIdTipoEndereco = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jtfNome = new jautopecas.components.JTextField();

        setPreferredSize(new java.awt.Dimension(498, 274));

        jtfIdTipoEndereco.setEnabled(false);
        jtfIdTipoEndereco.setMensagemAjuda("ID Tipo Endereço (Gerado automaticamente pelo sistema)");

        jlIdTipoEndereco.setText("ID Tipo Endereço");

        jlNome.setText("Nome");

        jtfNome.setMaximoCaracteres(50);
        jtfNome.setMensagemAjuda("Tipo de endereço");
        jtfNome.setRequerido(true);

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
                            .addComponent(jlNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jtfIdTipoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlIdTipoEndereco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 198, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jlIdTipoEndereco)
                .addGap(6, 6, 6)
                .addComponent(jtfIdTipoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNome)
                .addGap(6, 6, 6)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlIdTipoEndereco;
    private javax.swing.JLabel jlNome;
    private jautopecas.components.JTextField jtfIdTipoEndereco;
    private jautopecas.components.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
    private TipoEndereco tipoEndereco;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        tipoEndereco = (TipoEndereco) objetoFormulario;
        jtfIdTipoEndereco.setText(tipoEndereco.getIdTipoEndereco().toString());
        jtfNome.setText(tipoEndereco.getNome());
    }

    @Override
    public void salvar() throws Exception {
        new TipoEnderecoDao().salvar(getObjetoFormulario());
        setObjetoFormulario(tipoEndereco);
    }

    @Override
    public void alterar() throws Exception {
        new TipoEnderecoDao().alterar(getObjetoFormulario());
        setObjetoFormulario(tipoEndereco);
    }

    @Override
    public void excluir() throws Exception {
        new TipoEnderecoDao().excluir(tipoEndereco);
    }

    @Override
    public TipoEndereco getObjetoFormulario() throws Exception {
        if (tipoEndereco == null) {
            tipoEndereco = new TipoEndereco();
        }
        tipoEndereco.setNome(jtfNome.getText());
        return tipoEndereco;
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
        return new TipoEnderecoDao().listarTodos();
    }

    public List pesquisaSimples(String strCamposPesqisa, String strPesquisa) {
        return new TipoEnderecoDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
