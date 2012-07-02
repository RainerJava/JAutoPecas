package jautopecas.crud.pessoa.endereco;

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

        jtfIdPais = new jautopecas.components.JTextField();
        jlIdPais = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jtfNome = new jautopecas.components.JTextField();

        setPreferredSize(new java.awt.Dimension(498, 274));

        jtfIdPais.setEnabled(false);
        jtfIdPais.setMensagemAjuda("ID (Gerado automaticamente pelo sistema)");

        jlIdPais.setText("ID Pais");

        jlNome.setText("Nome");

        jtfNome.setMaximoCaracteres(150);
        jtfNome.setMensagemAjuda("Nome completo do Bairro");
        jtfNome.setRequerido(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jlIdPais, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jtfIdPais, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jlIdPais)
                .addGap(6, 6, 6)
                .addComponent(jtfIdPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNome)
                .addGap(6, 6, 6)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlIdPais;
    private javax.swing.JLabel jlNome;
    private jautopecas.components.JTextField jtfIdPais;
    private jautopecas.components.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
    private Pais pais;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        pais = (Pais) objetoFormulario;
        jtfIdPais.setText(pais.getIdPais().toString());
        jtfNome.setText(pais.getNome());
    }

    @Override
    public void salvar() throws Exception {
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
        if (pais == null) {
            pais = new Pais();
        }
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
