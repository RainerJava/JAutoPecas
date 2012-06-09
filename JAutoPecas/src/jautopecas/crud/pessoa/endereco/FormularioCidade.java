package jautopecas.crud.pessoa.endereco;

import jautopecas.components.validadores.ValidadorStringLength;
import jautopecas.crud.IFormulario;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.endereco.CidadeDao;
import jautopecas.dao.pessoa.endereco.EstadoDao;
import jautopecas.entidades.pessoa.endereco.Cidade;
import jautopecas.entidades.pessoa.endereco.Estado;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author JFFiorotto
 */
public class FormularioCidade extends javax.swing.JPanel implements IFormulario {

    /**
     * Creates new form formularioEmpresa
     */
    public FormularioCidade() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfId = new jautopecas.components.JFTextField();
        jlId = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jtfEstado = new jautopecas.components.JFTextField();
        jlEstado = new javax.swing.JLabel();
        jtfIbge = new jautopecas.components.JFTextField();
        jlIbge = new javax.swing.JLabel();
        jtfNome = new jautopecas.components.JFTextField();

        setPreferredSize(new java.awt.Dimension(384, 206));

        jtfId.setEnabled(false);
        jtfId.setMensagemAjuda("ID (Gerado automaticamente pelo sistema)");

        jlId.setText("ID");

        jlNome.setText("Nome");

        jtfEstado.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioEstado");
        jtfEstado.setMensagemAjuda("Estado");
        jtfEstado.setRequerido(true);

        jlEstado.setText("Estado");

        jtfIbge.setMensagemAjuda("Codigo IBGE da Cidade");
        jtfIbge.setRequerido(true);
        jtfIbge.setValidador(new ValidadorStringLength(jtfIbge, 7, 7));

        jlIbge.setText("Cod. Ibge");

        jtfNome.setMensagemAjuda("Nome completo da Cidade");
        jtfNome.setRequerido(true);
        jtfNome.setValidador(new ValidadorStringLength(jtfNome, 4, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlId, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jlNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jlIbge, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jtfIbge, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlEstado)
                    .addComponent(jlIbge))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfIbge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlIbge;
    private javax.swing.JLabel jlId;
    private javax.swing.JLabel jlNome;
    private jautopecas.components.JFTextField jtfEstado;
    private jautopecas.components.JFTextField jtfIbge;
    private jautopecas.components.JFTextField jtfId;
    private jautopecas.components.JFTextField jtfNome;
    // End of variables declaration//GEN-END:variables
    private Cidade cidade;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        cidade = (Cidade) objetoFormulario;
        jtfId.setText(cidade.getIdCidade().toString());
        jtfNome.setText(cidade.getNome());
        jtfEstado.setObjeto(cidade.getUf());
        jtfIbge.setText(cidade.getIbge());
    }

    @Override
    public void salvar() throws Exception {
        cidade = new Cidade();
        new CidadeDao().salvar(getObjetoFormulario());
        setObjetoFormulario(cidade);
    }

    @Override
    public void alterar() throws Exception {
        new CidadeDao().alterar(getObjetoFormulario());
        setObjetoFormulario(cidade);
    }

    @Override
    public void excluir() throws Exception {
        new CidadeDao().excluir(cidade);
    }

    @Override
    public Cidade getObjetoFormulario() throws Exception {
        cidade.setUf((Estado) jtfEstado.getObjeto());
        cidade.setNome(jtfNome.getText());
        cidade.setIbge(jtfIbge.getText());
        return cidade;
    }

    @Override
    public JLabel getJlInformacao() {
        return ((WindowCrud) getTopLevelAncestor()).getJlInformacao();
    }

    @Override
    public List pesquisar(String strPesquisa) {
        return new EstadoDao().listarTodos();
    }

    public List pesquisaSimples(String strCamposPesqisa, String strPesquisa) {
        return new CidadeDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
