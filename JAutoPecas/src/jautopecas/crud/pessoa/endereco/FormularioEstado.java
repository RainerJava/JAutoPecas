package jautopecas.crud.pessoa.endereco;

import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.endereco.EstadoDao;
import jautopecas.entidades.pessoa.endereco.Estado;
import jautopecas.entidades.pessoa.endereco.Pais;
import java.util.List;

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

        jtfUf = new jautopecas.components.JTextField();
        jlUf = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jtfRegiao = new jautopecas.components.JTextField();
        jlRegiao = new javax.swing.JLabel();
        jtfIbge = new jautopecas.components.JTextField();
        jlIbge = new javax.swing.JLabel();
        jtfNome = new jautopecas.components.JTextField();
        jtfPais = new jautopecas.components.JTextField();
        jlPais = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(384, 206));

        jtfUf.setMaximoCaracteres(2);
        jtfUf.setMensagemAjuda("Sigla do Estado");
        jtfUf.setRequerido(true);

        jlUf.setText("Sigla Estado");

        jlNome.setText("Nome");

        jtfRegiao.setMaximoCaracteres(100);
        jtfRegiao.setMensagemAjuda("Região do Estado");
        jtfRegiao.setRequerido(true);

        jlRegiao.setText("Região");

        jtfIbge.setMaximoCaracteres(11);
        jtfIbge.setMensagemAjuda("Codigo IBGE do Estado");
        jtfIbge.setRequerido(true);

        jlIbge.setText("Cod. Ibge");

        jtfNome.setMaximoCaracteres(50);
        jtfNome.setMensagemAjuda("Nome completo do Estado");
        jtfNome.setRequerido(true);

        jtfPais.setClasseFormulario("jautopecas.crud.pessoa.endereco.FormularioPais");
        jtfPais.setMensagemAjuda("Região do Estado");
        jtfPais.setRequerido(true);

        jlPais.setText("Pais");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtfPais, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlPais, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jtfIbge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlPais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlIbge;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlPais;
    private javax.swing.JLabel jlRegiao;
    private javax.swing.JLabel jlUf;
    private jautopecas.components.JTextField jtfIbge;
    private jautopecas.components.JTextField jtfNome;
    private jautopecas.components.JTextField jtfPais;
    private jautopecas.components.JTextField jtfRegiao;
    private jautopecas.components.JTextField jtfUf;
    // End of variables declaration//GEN-END:variables
    private Estado estado;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        estado = (Estado) objetoFormulario;
        jtfUf.setText(estado.getUf());
        jtfNome.setText(estado.getNome());
        jtfRegiao.setText(estado.getRegiao());
        jtfIbge.setText(estado.getIbge());
        jtfPais.setObjeto(estado.getPais());
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
        estado.setPais((Pais) jtfPais.getObjeto());
        return estado;
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
        return new EstadoDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
