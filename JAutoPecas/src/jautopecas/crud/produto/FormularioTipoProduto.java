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

        jtfDescricaoTipoProduto = new jautopecas.components.JTextField();
        jlTipoProduto = new javax.swing.JLabel();
        jlDescricaoTipoProduto = new javax.swing.JLabel();
        jtfTipoProduto = new jautopecas.components.JTextField();

        setPreferredSize(new java.awt.Dimension(498, 274));

        jtfDescricaoTipoProduto.setMaximoCaracteres(50);
        jtfDescricaoTipoProduto.setMensagemAjuda("Nome Tipo Produto");
        jtfDescricaoTipoProduto.setRequerido(true);

        jlTipoProduto.setText("Tipo Produto");

        jlDescricaoTipoProduto.setText("Descrição Tipo Produto");

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
                    .addComponent(jlTipoProduto)
                    .addComponent(jtfDescricaoTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtfTipoProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlDescricaoTipoProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTipoProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDescricaoTipoProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDescricaoTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlDescricaoTipoProduto;
    private javax.swing.JLabel jlTipoProduto;
    private jautopecas.components.JTextField jtfDescricaoTipoProduto;
    private jautopecas.components.JTextField jtfTipoProduto;
    // End of variables declaration//GEN-END:variables
    private TipoProduto tipoProduto;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        jtfTipoProduto.setSempreBloqueado(true);
        tipoProduto = (TipoProduto) objetoFormulario;
        jtfTipoProduto.setText(String.valueOf(tipoProduto.getTipoProduto()));
        jtfDescricaoTipoProduto.setText(tipoProduto.getDescricao());
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
        tipoProduto.setDescricao(jtfDescricaoTipoProduto.getText());
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
