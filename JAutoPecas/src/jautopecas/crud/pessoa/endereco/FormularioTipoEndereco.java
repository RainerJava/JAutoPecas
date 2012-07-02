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

        jtfTipoEndereco = new jautopecas.components.JTextField();
        jlTipoEndereco = new javax.swing.JLabel();
        jlDescricaoTipoEndereco = new javax.swing.JLabel();
        jtfDescricaoTipoEndereco = new jautopecas.components.JTextField();

        setPreferredSize(new java.awt.Dimension(498, 274));

        jtfTipoEndereco.setMensagemAjuda("ID (Gerado automaticamente pelo sistema)");

        jlTipoEndereco.setText("Tipo Endereço");

        jlDescricaoTipoEndereco.setText("Nome");

        jtfDescricaoTipoEndereco.setMaximoCaracteres(50);
        jtfDescricaoTipoEndereco.setMensagemAjuda("Tipo de endereço");
        jtfDescricaoTipoEndereco.setRequerido(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlDescricaoTipoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDescricaoTipoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jtfTipoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlTipoEndereco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jlTipoEndereco)
                .addGap(6, 6, 6)
                .addComponent(jtfTipoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDescricaoTipoEndereco)
                .addGap(6, 6, 6)
                .addComponent(jtfDescricaoTipoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlDescricaoTipoEndereco;
    private javax.swing.JLabel jlTipoEndereco;
    private jautopecas.components.JTextField jtfDescricaoTipoEndereco;
    private jautopecas.components.JTextField jtfTipoEndereco;
    // End of variables declaration//GEN-END:variables
    private TipoEndereco tipoEndereco;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        jtfTipoEndereco.setSempreBloqueado(true);
        tipoEndereco = (TipoEndereco) objetoFormulario;
        jtfTipoEndereco.setText(tipoEndereco.getTipoEndereco());
        jtfDescricaoTipoEndereco.setText(tipoEndereco.getDescricao());
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
        tipoEndereco.setTipoEndereco(jtfTipoEndereco.getText());
        tipoEndereco.setDescricao(jtfDescricaoTipoEndereco.getText());
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
