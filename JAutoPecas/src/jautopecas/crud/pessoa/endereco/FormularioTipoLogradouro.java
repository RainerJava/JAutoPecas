package jautopecas.crud.pessoa.endereco;

import jautopecas.components.validadores.ValidadorStringLength;
import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.endereco.EstadoDao;
import jautopecas.dao.pessoa.endereco.TipoLogradouroDao;
import jautopecas.entidades.pessoa.endereco.TipoLogradouro;
import java.util.List;
import javax.swing.JLabel;

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

        jtfId = new jautopecas.components.JTextField();
        jlId = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jtfNome = new jautopecas.components.JTextField();

        setPreferredSize(new java.awt.Dimension(384, 206));

        jtfId.setEnabled(false);
        jtfId.setMensagemAjuda("Sigla do Estado");

        jlId.setText("ID");

        jlNome.setText("Nome");

        jtfNome.setMensagemAjuda("Tipo de Logradouro Ex;. Rua,Avenida,Viela, etc...");
        jtfNome.setRequerido(true);
        jtfNome.setValidador(new ValidadorStringLength(jtfNome, 2, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jlId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jlNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNome)
                    .addComponent(jlId))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(155, 155, 155))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlId;
    private javax.swing.JLabel jlNome;
    private jautopecas.components.JTextField jtfId;
    private jautopecas.components.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
    private TipoLogradouro tipoLogradouro;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        tipoLogradouro = (TipoLogradouro) objetoFormulario;
        jtfId.setText(tipoLogradouro.getIdTipoLogradouro().toString());
        jtfNome.setText(tipoLogradouro.getNome());
    }

    @Override
    public void salvar() throws Exception {
        tipoLogradouro = new TipoLogradouro();
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
