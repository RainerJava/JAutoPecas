package jautopecas.crud.produto;

import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.produto.TipoProdutoDao;
import jautopecas.entidades.produto.TipoProduto;
import java.util.List;

/**
 *
 * @author JFFiorotto
 */
public class FormularioTipoProduto extends javax.swing.JPanel implements IFormulario {

    /**
     * Creates new form formularioEmpresa
     */
    public FormularioTipoProduto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfNome = new jautopecas.components.JTextField();
        jlTipoProduto = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jtfTipoProduto = new jautopecas.components.JTextField();

        setPreferredSize(new java.awt.Dimension(498, 274));

        jtfNome.setMaximoCaracteres(50);
        jtfNome.setMensagemAjuda("Nome Tipo Produto");
        jtfNome.setRequerido(true);

        jlTipoProduto.setText("Tipo Produto");

        jlNome.setText("Nome");

        jtfTipoProduto.setMaximoCaracteres(2);
        jtfTipoProduto.setMensagemAjuda("Nome Tipo Produto");
        jtfTipoProduto.setRequerido(true);

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
                            .addComponent(jtfTipoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 417, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTipoProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private jautopecas.components.JTextField jtfTipoProduto;
    // End of variables declaration//GEN-END:variables
    private TipoProduto tipoProduto;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        jtfTipoProduto.setSempreBloqueado(true);
        tipoProduto = (TipoProduto) objetoFormulario;
        jtfTipoProduto.setText(String.valueOf(tipoProduto.getTipoProduto()));
        jtfNome.setText(tipoProduto.getNome());
    }

    @Override
    public void salvar() throws Exception {
        new TipoProdutoDao().salvar(getObjetoFormulario());
        setObjetoFormulario(tipoProduto);
    }

    @Override
    public void alterar() throws Exception {
        new TipoProdutoDao().alterar(getObjetoFormulario());
        setObjetoFormulario(tipoProduto);
    }

    @Override
    public void excluir() throws Exception {
        new TipoProdutoDao().excluir(tipoProduto);
    }

    @Override
    public TipoProduto getObjetoFormulario() throws Exception {
        if (tipoProduto == null) {
            tipoProduto = new TipoProduto();
        }
        tipoProduto.setTipoProduto(jtfTipoProduto.getText());
        tipoProduto.setNome(jtfNome.getText());
        return tipoProduto;
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
        return new TipoProdutoDao().listarTodos();
    }

    public List pesquisaSimples(String strCamposPesqisa, String strPesquisa) {
        return new TipoProdutoDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }
}
