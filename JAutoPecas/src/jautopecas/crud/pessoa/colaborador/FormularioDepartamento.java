package jautopecas.crud.pessoa.colaborador;

import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.colaborador.DepartamentoDao;
import jautopecas.dao.pessoa.endereco.EstadoDao;
import jautopecas.entidades.pessoa.colaborador.Departamento;
import java.util.List;

/**
 *
 * @author JFFiorotto
 */
public class FormularioDepartamento extends javax.swing.JPanel implements IFormulario {

    /**
     * Creates new form formularioEmpresa
     */
    public FormularioDepartamento() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfId = new jautopecas.components.JTextField();
        jlId = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jtfNome = new jautopecas.components.JTextField();

        setPreferredSize(new java.awt.Dimension(498, 274));

        jtfId.setEnabled(false);
        jtfId.setMensagemAjuda("ID (Gerado automaticamente pelo sistema)");

        jlId.setText("ID");

        jlNome.setText("Nome");

        jtfNome.setMaximoCaracteres(150);
        jtfNome.setMensagemAjuda("Nome do Departamento");
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
                                .addComponent(jlId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jlId)
                .addGap(6, 6, 6)
                .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNome)
                .addGap(6, 6, 6)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlId;
    private javax.swing.JLabel jlNome;
    private jautopecas.components.JTextField jtfId;
    private jautopecas.components.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
    private Departamento departamento;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        departamento = (Departamento) objetoFormulario;
        jtfId.setText(departamento.getIdDepartamento().toString());
        jtfNome.setText(departamento.getNome());
    }

    @Override
    public void salvar() throws Exception {
        new DepartamentoDao().salvar(getObjetoFormulario());
        setObjetoFormulario(departamento);
    }

    @Override
    public void alterar() throws Exception {
        new DepartamentoDao().alterar(getObjetoFormulario());
        setObjetoFormulario(departamento);
    }

    @Override
    public void excluir() throws Exception {
        new DepartamentoDao().excluir(departamento);
    }

    @Override
    public Departamento getObjetoFormulario() throws Exception {
        if (departamento == null) {
            departamento = new Departamento();
        }
        departamento.setNome(jtfNome.getText());
        return departamento;
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
        return new DepartamentoDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
