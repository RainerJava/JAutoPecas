package jautopecas.crud.pessoa;

import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.pessoa.TipoPessoaDao;
import jautopecas.entidades.pessoa.TipoPessoa;
import java.util.List;

/**
 *
 * @author JFFiorotto
 */
public class FormularioTipoPessoa extends javax.swing.JPanel implements IFormulario {

    /**
     * Creates new form formularioEmpresa
     */
    public FormularioTipoPessoa() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfNome = new jautopecas.components.JTextField();
        jlTipoProduto = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jtfTipoPessoa = new jautopecas.components.JTextField();

        setPreferredSize(new java.awt.Dimension(498, 274));

        jtfNome.setMaximoCaracteres(50);
        jtfNome.setMensagemAjuda("Nome Tipo Produto");
        jtfNome.setRequerido(true);

        jlTipoProduto.setText("Tipo Pessoa");

        jlNome.setText("Nome");

        jtfTipoPessoa.setMaximoCaracteres(2);
        jtfTipoPessoa.setMensagemAjuda("Nome Tipo Produto");
        jtfTipoPessoa.setRequerido(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlTipoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlNome)
                            .addComponent(jtfTipoPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 421, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTipoProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfTipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlTipoProduto;
    private jautopecas.components.JTextField jtfNome;
    private jautopecas.components.JTextField jtfTipoPessoa;
    // End of variables declaration//GEN-END:variables
    private TipoPessoa tipoPessoa;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        jtfTipoPessoa.setSempreBloqueado(true);
        tipoPessoa = (TipoPessoa) objetoFormulario;
        jtfTipoPessoa.setText(String.valueOf(tipoPessoa.getTipoPessoa()));
        jtfNome.setText(tipoPessoa.getNome());
    }

    @Override
    public void salvar() throws Exception {
        new TipoPessoaDao().salvar(getObjetoFormulario());
        setObjetoFormulario(tipoPessoa);
    }

    @Override
    public void alterar() throws Exception {
        new TipoPessoaDao().alterar(getObjetoFormulario());
        setObjetoFormulario(tipoPessoa);
    }

    @Override
    public void excluir() throws Exception {
        new TipoPessoaDao().excluir(tipoPessoa);
    }

    @Override
    public TipoPessoa getObjetoFormulario() throws Exception {
        if (tipoPessoa == null) {
            tipoPessoa = new TipoPessoa();
        }
        tipoPessoa.setTipoPessoa(jtfTipoPessoa.getText());
        tipoPessoa.setNome(jtfNome.getText());
        return tipoPessoa;
    }

    @Override
    public MensagemRodape getMensagemRodape() {
        if (getTopLevelAncestor() instanceof WindowCrud) {
            return ((WindowCrud) getTopLevelAncestor()).getMensagemRodape();
        }
        return null;
    }

    @Override
    public List pesquisar(String strPesquisa) throws Exception {
        return new TipoPessoaDao().listarTodos();
    }

    public List pesquisaSimples(String strCamposPesqisa, String strPesquisa) {
        return new TipoPessoaDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
