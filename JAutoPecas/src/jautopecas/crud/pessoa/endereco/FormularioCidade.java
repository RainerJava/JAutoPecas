package jautopecas.crud.pessoa.endereco;

import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.endereco.CidadeDao;
import jautopecas.dao.pessoa.endereco.EstadoDao;
import jautopecas.entidades.pessoa.endereco.Cidade;
import jautopecas.entidades.pessoa.endereco.Estado;
import java.util.List;

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

        jtfIdCidade = new jautopecas.components.JTextField();
        jlIdCidade = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jtfUf = new jautopecas.components.JTextField();
        jlUf = new javax.swing.JLabel();
        jtfIbge = new jautopecas.components.JTextField();
        jlIbge = new javax.swing.JLabel();
        jtfNome = new jautopecas.components.JTextField();

        setPreferredSize(new java.awt.Dimension(498, 274));

        jtfIdCidade.setEnabled(false);
        jtfIdCidade.setMensagemAjuda("ID Cidade (Gerado automaticamente pelo sistema)");

        jlIdCidade.setText("ID Cidade");

        jlNome.setText("Nome");

        jtfUf.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioEstado");
        jtfUf.setMensagemAjuda("Estado");
        jtfUf.setRequerido(true);

        jlUf.setText("Estado");

        jtfIbge.setMaximoCaracteres(11);
        jtfIbge.setMensagemAjuda("Codigo IBGE da Cidade");
        jtfIbge.setRequerido(true);

        jlIbge.setText("Cod. Ibge");

        jtfNome.setMaximoCaracteres(250);
        jtfNome.setMensagemAjuda("Nome completo da Cidade");
        jtfNome.setRequerido(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfUf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfIbge, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jlNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlUf, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                                .addComponent(jlIbge, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jtfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNome)
                    .addComponent(jlIdCidade))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlUf)
                    .addComponent(jlIbge))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfIbge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlIbge;
    private javax.swing.JLabel jlIdCidade;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlUf;
    private jautopecas.components.JTextField jtfIbge;
    private jautopecas.components.JTextField jtfIdCidade;
    private jautopecas.components.JTextField jtfNome;
    private jautopecas.components.JTextField jtfUf;
    // End of variables declaration//GEN-END:variables
    private Cidade cidade;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        cidade = (Cidade) objetoFormulario;
        jtfIdCidade.setText(cidade.getIdCidade().toString());
        jtfNome.setText(cidade.getNome());
        jtfUf.setObjeto(cidade.getUf());
        jtfIbge.setText(cidade.getIbge());
    }

    @Override
    public void salvar() throws Exception {
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
        if (cidade == null) {
            cidade = new Cidade();
        }
        cidade.setUf((Estado) jtfUf.getObjeto());
        cidade.setNome(jtfNome.getText());
        cidade.setIbge(jtfIbge.getText());
        return cidade;
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
        return new CidadeDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
