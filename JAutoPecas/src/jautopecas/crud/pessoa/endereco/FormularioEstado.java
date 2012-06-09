package jautopecas.crud.pessoa.endereco;

import jautopecas.components.validadores.ValidadorStringLength;
import jautopecas.crud.IFormulario;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.endereco.EstadoDao;
import jautopecas.entidades.pessoa.endereco.Estado;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author JFFiorotto
 */
public class FormularioEstado extends javax.swing.JPanel implements IFormulario {

    /**
     * Creates new form formularioEmpresa
     */
    public FormularioEstado() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfUf = new jautopecas.components.JFTextField();
        jlUf = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jtfRegiao = new jautopecas.components.JFTextField();
        jlRegiao = new javax.swing.JLabel();
        jtfIbge = new jautopecas.components.JFTextField();
        jlIbge = new javax.swing.JLabel();
        jtfNome = new jautopecas.components.JFTextField();

        setPreferredSize(new java.awt.Dimension(384, 206));

        jtfUf.setMensagemAjuda("Sigla do Estado");
        jtfUf.setValidador(new ValidadorStringLength(jtfUf, 2, 2));

        jlUf.setText("Sigla Estado");

        jlNome.setText("Nome");

        jtfRegiao.setMensagemAjuda("Região do Estado");
        jtfRegiao.setValidador(new ValidadorStringLength(jtfRegiao, -1, 100));

        jlRegiao.setText("Região");

        jtfIbge.setMensagemAjuda("Codigo IBGE do Estado");
        jtfIbge.setValidador(new ValidadorStringLength(jtfIbge, 2, 2));

        jlIbge.setText("Cod. Ibge");

        jtfNome.setMensagemAjuda("Nome completo do Estado");
        jtfNome.setValidador(new ValidadorStringLength(jtfNome, 5, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlUf, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jlNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlRegiao, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jlIbge, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfRegiao, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jtfIbge, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jtfUf, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNome)
                    .addComponent(jlUf))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlRegiao)
                    .addComponent(jlIbge))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfRegiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfIbge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlIbge;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlRegiao;
    private javax.swing.JLabel jlUf;
    private jautopecas.components.JFTextField jtfIbge;
    private jautopecas.components.JFTextField jtfNome;
    private jautopecas.components.JFTextField jtfRegiao;
    private jautopecas.components.JFTextField jtfUf;
    // End of variables declaration//GEN-END:variables
    private Estado estado;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) {
        estado = (Estado) objetoFormulario;
        jtfUf.setText(estado.getUf());
        jtfNome.setText(estado.getNome());
        jtfRegiao.setText(estado.getRegiao());
        jtfIbge.setText(estado.getIbge());
    }

    @Override
    public void salvar() throws Exception {
        estado = new Estado();
        new EstadoDao().salvar(getObjetoFormulario());
        setObjetoFormulario(estado);
    }

    @Override
    public void alterar() throws Exception {
        new EstadoDao().alterar(getObjetoFormulario());
        setObjetoFormulario(estado);
    }

    @Override
    public void excluir() throws Exception {
        new EstadoDao().excluir(estado);
    }

    @Override
    public Estado getObjetoFormulario() {
        estado.setUf(jtfUf.getText());
        estado.setNome(jtfNome.getText());
        estado.setRegiao(jtfRegiao.getText());
        estado.setIbge(jtfIbge.getText());
        return estado;
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
        return new EstadoDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}