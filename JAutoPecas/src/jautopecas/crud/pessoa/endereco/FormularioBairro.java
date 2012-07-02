package jautopecas.crud.pessoa.endereco;

import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.endereco.BairroDao;
import jautopecas.dao.pessoa.endereco.EstadoDao;
import jautopecas.entidades.pessoa.endereco.Bairro;
import java.util.List;

/**
 *
 * @author JFFiorotto
 */
public class FormularioBairro extends javax.swing.JPanel implements IFormulario {

    /**
     * Creates new form formularioEmpresa
     */
    public FormularioBairro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfIdBairro = new jautopecas.components.JTextField();
        jlIdBairro = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jtfNome = new jautopecas.components.JTextField();

        setPreferredSize(new java.awt.Dimension(498, 274));

        jtfIdBairro.setEnabled(false);
        jtfIdBairro.setMensagemAjuda("ID Bairro (Gerado automaticamente pelo sistema)");

        jlIdBairro.setText("ID Bairro");

        jlNome.setText("Nome");

        jtfNome.setMaximoCaracteres(250);
        jtfNome.setMensagemAjuda("Nome completo do Bairro");
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
                                .addComponent(jlIdBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jtfIdBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jlIdBairro)
                .addGap(6, 6, 6)
                .addComponent(jtfIdBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNome)
                .addGap(6, 6, 6)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlIdBairro;
    private javax.swing.JLabel jlNome;
    private jautopecas.components.JTextField jtfIdBairro;
    private jautopecas.components.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
    private Bairro bairro;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        bairro = (Bairro) objetoFormulario;
        jtfIdBairro.setText(bairro.getIdBairro().toString());
        jtfNome.setText(bairro.getNome());
    }

    @Override
    public void salvar() throws Exception {
        new BairroDao().salvar(getObjetoFormulario());
        setObjetoFormulario(bairro);
    }

    @Override
    public void alterar() throws Exception {
        new BairroDao().alterar(getObjetoFormulario());
        setObjetoFormulario(bairro);
    }

    @Override
    public void excluir() throws Exception {
        new BairroDao().excluir(bairro);
    }

    @Override
    public Bairro getObjetoFormulario() throws Exception {
        if (bairro == null) {
            bairro = new Bairro();
        }
        bairro.setNome(jtfNome.getText());
        return bairro;
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
        return new BairroDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
