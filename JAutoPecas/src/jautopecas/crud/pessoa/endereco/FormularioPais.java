package jautopecas.crud.pessoa.endereco;

import jautopecas.components.validadores.ValidadorStringLength;
import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.endereco.PaisDao;
import jautopecas.entidades.pessoa.endereco.Pais;
import java.util.List;

/**
 *
 * @author JFFiorotto
 */
public class FormularioPais extends javax.swing.JPanel implements IFormulario {

    /**
     * Creates new form formularioEmpresa
     */
    public FormularioPais() {
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
        jtfId.setMensagemAjuda("ID (Gerado automaticamente pelo sistema)");

        jlId.setText("ID");

        jlNome.setText("Nome");

        jtfNome.setMensagemAjuda("Nome completo do Bairro");
        jtfNome.setRequerido(true);
        jtfNome.setValidador(new ValidadorStringLength(jtfNome, 4, 50));

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
    private Pais pais;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        pais = (Pais) objetoFormulario;
        jtfId.setText(pais.getIdPais().toString());
        jtfNome.setText(pais.getNome());
    }

    @Override
    public void salvar() throws Exception {
        pais = new Pais();
        new PaisDao().salvar(getObjetoFormulario());
        setObjetoFormulario(pais);
    }

    @Override
    public void alterar() throws Exception {
        new PaisDao().alterar(getObjetoFormulario());
        setObjetoFormulario(pais);
    }

    @Override
    public void excluir() throws Exception {
        new PaisDao().excluir(pais);
    }

    @Override
    public Pais getObjetoFormulario() throws Exception {
        pais.setNome(jtfNome.getText());
        return pais;
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
        return new PaisDao().listarTodos();
    }

    public List pesquisaSimples(String strCamposPesqisa, String strPesquisa) {
        return new PaisDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
