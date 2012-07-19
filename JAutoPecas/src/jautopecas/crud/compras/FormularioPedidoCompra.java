package jautopecas.crud.compras;

import jautopecas.JAutoPecasMenu;
import jautopecas.dao.compras.PedidoCompraDao;
import jautopecas.dao.produto.EstoqueDao;
import jautopecas.entidades.compras.PedidoCompra;
import jautopecas.entidades.compras.PedidoCompraItem;
import jautopecas.entidades.pessoa.Pessoa;
import jautopecas.entidades.produto.Estoque;
import jautopecas.entidades.substituicaoTributaria.SubstituicaoTributariaEntrada;
import jautopecas.exceptions.UtilFormularioException;
import jautopecas.util.StringUtils;
import jautopecas.util.UtilFormulario;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;

/**
 *
 * @author JFFiorotto
 */
public class FormularioPedidoCompra extends javax.swing.JPanel {

    private TableModelPesquisaProduto tableModel;
    private TableModelItensPedidoCompra tableModelItens;
    private Estoque produtoSelecionado;
    private PedidoCompra pedidoCompra;
    private PedidoCompraItem pedidoCompraItemSelecionado;
    private List<PedidoCompraItem> listaItensPedidoCompra;
    private HashMap<Integer, Integer> hashProdutoIndex = new HashMap<>();

    /**
     * Creates new form FormularioPedidoCompra
     */
    public FormularioPedidoCompra() {
        initComponents();

        jpDadosProduto.setVisible(false);
        jpPesquisaProduto.setVisible(true);
        jtPesquisaProduto.setModel(tableModel == null ? new TableModelPesquisaProduto() : tableModel);
        jtItens.setModel(tableModelItens == null ? new TableModelItensPedidoCompra() : tableModelItens);
        carregaCombos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpCabecalho = new javax.swing.JPanel();
        jtfNumeroPedido = new jautopecas.components.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfTotalPedido = new jautopecas.components.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfTotalProdutos = new jautopecas.components.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfTotalIpi = new jautopecas.components.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfTotalIcms = new jautopecas.components.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfBaseIcmsSt = new jautopecas.components.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfTotalIcmsSt = new jautopecas.components.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfTotalDesconto = new jautopecas.components.JTextField();
        jcbEmpresa = new jautopecas.components.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jtpCapaItens = new javax.swing.JTabbedPane();
        jpCapa = new javax.swing.JPanel();
        jtfFornecedor = new jautopecas.components.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfTipoPessoa = new jautopecas.components.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtfFornecedor1 = new jautopecas.components.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboBox2 = new jautopecas.components.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jTextField10 = new jautopecas.components.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtfFornecedor2 = new jautopecas.components.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jpItens = new javax.swing.JPanel();
        jpPesquisa = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jpDadosProduto = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jtfIdProduto = new jautopecas.components.JTextField();
        jtfNumeroFabricante = new jautopecas.components.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jtfFabricante = new jautopecas.components.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jtfQtd = new jautopecas.components.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jtfPreco = new jautopecas.components.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jtfIcms = new jautopecas.components.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jtfIpi = new jautopecas.components.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jpPesquisaProduto = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextField11 = new jautopecas.components.JTextField();
        jspPesquisaProduto = new javax.swing.JScrollPane();
        jtPesquisaProduto = new javax.swing.JTable();
        jpItensAdicionados = new javax.swing.JPanel();
        jspItens = new javax.swing.JScrollPane();
        jtItens = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.BorderLayout());

        jpCabecalho.setBackground(new java.awt.Color(204, 255, 204));
        jpCabecalho.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtfNumeroPedido.setSempreBloqueado(true);

        jLabel1.setText("Pedido");

        jLabel3.setText("Total Pedido");

        jtfTotalPedido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jtfTotalPedido.setSempreBloqueado(true);

        jLabel4.setText("Total Produtos");

        jtfTotalProdutos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jtfTotalProdutos.setSempreBloqueado(true);

        jLabel5.setText("Total IPI");

        jtfTotalIpi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jtfTotalIpi.setSempreBloqueado(true);

        jLabel6.setText("Total ICMS");

        jtfTotalIcms.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jtfTotalIcms.setSempreBloqueado(true);

        jLabel7.setText("Base ICMS ST");

        jtfBaseIcmsSt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jtfBaseIcmsSt.setSempreBloqueado(true);

        jLabel8.setText("Total ICMS ST");

        jtfTotalIcmsSt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jtfTotalIcmsSt.setSempreBloqueado(true);

        jLabel9.setText("Total Desconto");

        jtfTotalDesconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jtfTotalDesconto.setSempreBloqueado(true);

        jLabel10.setText("Empresa");

        javax.swing.GroupLayout jpCabecalhoLayout = new javax.swing.GroupLayout(jpCabecalho);
        jpCabecalho.setLayout(jpCabecalhoLayout);
        jpCabecalhoLayout.setHorizontalGroup(
            jpCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCabecalhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtfNumeroPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpCabecalhoLayout.createSequentialGroup()
                            .addGroup(jpCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jtfTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jpCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jtfTotalProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jpCabecalhoLayout.createSequentialGroup()
                            .addGroup(jpCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jtfTotalIpi, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jpCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jtfTotalIcms, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jpCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jtfBaseIcmsSt, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jcbEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jtfTotalIcmsSt, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jtfTotalDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jpCabecalhoLayout.setVerticalGroup(
            jpCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCabecalhoLayout.createSequentialGroup()
                .addGroup(jpCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpCabecalhoLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfBaseIcmsSt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCabecalhoLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfTotalIcms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCabecalhoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfTotalIpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpCabecalhoLayout.createSequentialGroup()
                        .addGroup(jpCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCabecalhoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfTotalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCabecalhoLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfTotalProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCabecalhoLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfTotalDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCabecalhoLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfTotalIcmsSt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        add(jpCabecalho, java.awt.BorderLayout.PAGE_START);

        jtpCapaItens.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jtpCapaItensStateChanged(evt);
            }
        });

        jtfFornecedor.setClasseFormulario("jautopecas.crud.pessoa.fornecedor.FormularioFornecedor");
        jtfFornecedor.setMensagemAjuda("Estado");
        jtfFornecedor.setRequerido(true);
        jtfFornecedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfFornecedorFocusLost(evt);
            }
        });

        jLabel2.setText("Tipo Pessoa");

        jtfTipoPessoa.setEnabled(false);

        jLabel11.setText("Fornecedor");

        jtfFornecedor1.setClasseFormulario("jautopecas.crud.pessoa.fornecedor.FormularioFornecedor");
        jtfFornecedor1.setMensagemAjuda("Estado");
        jtfFornecedor1.setRequerido(false);

        jLabel12.setText("Transportadora");

        jLabel13.setText("Frete");

        jLabel14.setText("Valor Frete");

        jtfFornecedor2.setClasseFormulario("jautopecas.crud.pessoa.fornecedor.FormularioFornecedor");
        jtfFornecedor2.setMensagemAjuda("Estado");
        jtfFornecedor2.setRequerido(false);

        jLabel15.setText("Condição Pagamento");

        javax.swing.GroupLayout jpCapaLayout = new javax.swing.GroupLayout(jpCapa);
        jpCapa.setLayout(jpCapaLayout);
        jpCapaLayout.setHorizontalGroup(
            jpCapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCapaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCapaLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCapaLayout.createSequentialGroup()
                        .addGroup(jpCapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpCapaLayout.createSequentialGroup()
                                .addGroup(jpCapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfFornecedor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jpCapaLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jtfFornecedor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jpCapaLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(351, 351, 351)))
                        .addGroup(jpCapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jtfTipoPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCapaLayout.createSequentialGroup()
                                .addGroup(jpCapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpCapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jpCapaLayout.setVerticalGroup(
            jpCapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCapaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTipoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCapaLayout.createSequentialGroup()
                        .addGroup(jpCapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpCapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfFornecedor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpCapaLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfFornecedor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(320, Short.MAX_VALUE))
        );

        jtpCapaItens.addTab("Capa", jpCapa);

        jpItens.setLayout(new java.awt.GridLayout(2, 1));

        jpPesquisa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpPesquisa.setLayout(new java.awt.BorderLayout());

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(0, 60));

        jpDadosProduto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpDadosProduto.setPreferredSize(new java.awt.Dimension(791, 60));

        jLabel17.setText("ID");

        jtfIdProduto.setEnabled(false);

        jtfNumeroFabricante.setEnabled(false);

        jLabel18.setText("Numero Fabricante");

        jtfFabricante.setEnabled(false);

        jLabel19.setText("Fabricante");

        jtfQtd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfQtdKeyPressed(evt);
            }
        });

        jLabel20.setText("Quantidade");

        jtfPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfPrecoKeyPressed(evt);
            }
        });

        jLabel21.setText("Preço");

        jtfIcms.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfIcmsKeyPressed(evt);
            }
        });

        jLabel22.setText("% ICMS");

        jtfIpi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfIpiKeyPressed(evt);
            }
        });

        jLabel23.setText("% IPI");

        javax.swing.GroupLayout jpDadosProdutoLayout = new javax.swing.GroupLayout(jpDadosProduto);
        jpDadosProduto.setLayout(jpDadosProdutoLayout);
        jpDadosProdutoLayout.setHorizontalGroup(
            jpDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosProdutoLayout.createSequentialGroup()
                .addGroup(jpDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(jtfIdProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfNumeroFabricante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDadosProdutoLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 44, Short.MAX_VALUE))
                    .addGroup(jpDadosProdutoLayout.createSequentialGroup()
                        .addComponent(jtfFabricante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jpDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfIcms, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfIpi, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jpDadosProdutoLayout.setVerticalGroup(
            jpDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosProdutoLayout.createSequentialGroup()
                .addGroup(jpDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpDadosProdutoLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfIcms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpDadosProdutoLayout.createSequentialGroup()
                                    .addComponent(jLabel20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpDadosProdutoLayout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jpDadosProdutoLayout.createSequentialGroup()
                            .addComponent(jLabel23)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfIpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpDadosProdutoLayout.createSequentialGroup()
                            .addGroup(jpDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(jLabel17))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jpDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfNumeroFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDadosProdutoLayout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jpDadosProduto.setBounds(0, 0, 791, 60);
        jLayeredPane1.add(jpDadosProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jpPesquisaProduto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpPesquisaProduto.setPreferredSize(new java.awt.Dimension(791, 60));

        jLabel16.setText("Pesquisa");

        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField11KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jpPesquisaProdutoLayout = new javax.swing.GroupLayout(jpPesquisaProduto);
        jpPesquisaProduto.setLayout(jpPesquisaProdutoLayout);
        jpPesquisaProdutoLayout.setHorizontalGroup(
            jpPesquisaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPesquisaProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPesquisaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(504, Short.MAX_VALUE))
        );
        jpPesquisaProdutoLayout.setVerticalGroup(
            jpPesquisaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPesquisaProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpPesquisaProduto.setBounds(0, 0, 791, 60);
        jLayeredPane1.add(jpPesquisaProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jpPesquisa.add(jLayeredPane1, java.awt.BorderLayout.NORTH);

        jtPesquisaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtPesquisaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPesquisaProdutoMouseClicked(evt);
            }
        });
        jspPesquisaProduto.setViewportView(jtPesquisaProduto);

        jpPesquisa.add(jspPesquisaProduto, java.awt.BorderLayout.CENTER);

        jpItens.add(jpPesquisa);

        jpItensAdicionados.setLayout(new java.awt.BorderLayout());

        jtItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtItensMouseClicked(evt);
            }
        });
        jspItens.setViewportView(jtItens);

        jpItensAdicionados.add(jspItens, java.awt.BorderLayout.CENTER);

        jpItens.add(jpItensAdicionados);

        jtpCapaItens.addTab("Itens", jpItens);

        add(jtpCapaItens, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void carregaCombos() {
        jcbEmpresa.setDataSet(JAutoPecasMenu.getListaEmpresas());
    }

    private void jTextField11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            onPesquisar();
        }
    }//GEN-LAST:event_jTextField11KeyPressed

    private void jtpCapaItensStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jtpCapaItensStateChanged
        if (jtpCapaItens.getSelectedIndex() == 1) {
            try {
                if (UtilFormulario.validarFormulario(jpCapa) != 0) {
                    jtpCapaItens.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "Preencha todos dados obrigatorios antes de inserir os itens", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (pedidoCompra != null && pedidoCompra.getIdPedidoCompra() != null) {
                    } else {
                        criaPedidoCompraTmp();
                    }
                }
            } catch (UtilFormularioException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Validar a capa", "OOPSS!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jtpCapaItensStateChanged

    private void jtfFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfFornecedorFocusLost
        jtfTipoPessoa.setText(((Pessoa) jtfFornecedor.getObjeto()).getTipoPessoa().getNome());
    }//GEN-LAST:event_jtfFornecedorFocusLost

    private void jtfIpiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIpiKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (jpDadosProduto.isVisible()) {
                produtoSelecionado = null;
                pedidoCompraItemSelecionado = null;
                jpDadosProduto.setVisible(false);
                jpPesquisaProduto.setVisible(true);
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            try {
                if (pedidoCompraItemSelecionado == null) {
                    pedidoCompraItemSelecionado = new PedidoCompraItem();
                    pedidoCompraItemSelecionado.setPedido(pedidoCompra);
                    pedidoCompraItemSelecionado.setQuantidadeEntregue(BigDecimal.ZERO);
                    pedidoCompraItemSelecionado.setValorBaseIcmsSt(BigDecimal.ZERO);
                    pedidoCompraItemSelecionado.setValorDesconto(BigDecimal.ZERO);
                    pedidoCompraItemSelecionado.setValorIcms(BigDecimal.ZERO);
                    pedidoCompraItemSelecionado.setValorIcmsSt(BigDecimal.ZERO);
                    pedidoCompraItemSelecionado.setValorIpi(BigDecimal.ZERO);
                    pedidoCompraItemSelecionado.setValorUnitarioLiquido(BigDecimal.ZERO);
                    pedidoCompraItemSelecionado.setValorUnitarioBruto(BigDecimal.ZERO);
                    pedidoCompraItemSelecionado.setTotalUnitarioLiquido(BigDecimal.ZERO);
                    pedidoCompraItemSelecionado.setTotalUnitarioBruto(BigDecimal.ZERO);
                    pedidoCompraItemSelecionado.setPercentIcms(BigDecimal.ZERO);
                    pedidoCompraItemSelecionado.setPercentIpi(BigDecimal.ZERO);
                    pedidoCompraItemSelecionado.setProduto(produtoSelecionado.getProduto());
                    pedidoCompraItemSelecionado.setValorUnitarioLiquido(pedidoCompraItemSelecionado.getProduto().getCustoFornecedor().getCustoUnitario());
                }

                pedidoCompraItemSelecionado.setQuantidadePedida(StringUtils.stringToBigDecimal(jtfQtd.getText()));
                pedidoCompraItemSelecionado.setPercentIcms(StringUtils.stringToBigDecimal(jtfIcms.getText()));
                pedidoCompraItemSelecionado.setPercentIpi(StringUtils.stringToBigDecimal(jtfIpi.getText()));

                calculaTotalUnitarioLiquido();
                calculaValorIpi();
                pedidoCompraItemSelecionado.setValorBaseIcmsSt(pedidoCompraItemSelecionado.getTotalUnitarioLiquido());
                calculaValorIcms();
                calculaValorIcmsSt();
                pedidoCompraItemSelecionado.setValorDesconto(BigDecimal.ZERO);
                calculaValorUnitarioBruto();
                calculaTotalUnitarioBruto();

                if (jtItens.getSelectedRowCount() <= 0) {
                    listaItensPedidoCompra.add(pedidoCompraItemSelecionado);
                    hashProdutoIndex.put(pedidoCompraItemSelecionado.getProduto().getIdProduto(), (listaItensPedidoCompra.size() - 1));
                } else {
                    listaItensPedidoCompra.set(jtItens.getSelectedRow(), pedidoCompraItemSelecionado);
                }
                atualizaDadosCapa();
                new PedidoCompraDao().alterar(pedidoCompra);

                pedidoCompraItemSelecionado = null;
                produtoSelecionado = null;
                ((TableModelItensPedidoCompra) jtItens.getModel()).removeResultado();
                ((TableModelItensPedidoCompra) jtItens.getModel()).mostraResultado(listaItensPedidoCompra);
                jpDadosProduto.setVisible(false);
                jpPesquisaProduto.setVisible(true);
                jtPesquisaProduto.clearSelection();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao incluir item no pedido", "OOPSS!", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jtfIpiKeyPressed

    private void jtfQtdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfQtdKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (jpDadosProduto.isVisible()) {
                produtoSelecionado = null;
                pedidoCompraItemSelecionado = null;
                jpDadosProduto.setVisible(false);
                jpPesquisaProduto.setVisible(true);
            }
        }
    }//GEN-LAST:event_jtfQtdKeyPressed

    private void jtfPrecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPrecoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (jpDadosProduto.isVisible()) {
                produtoSelecionado = null;
                pedidoCompraItemSelecionado = null;
                jpDadosProduto.setVisible(false);
                jpPesquisaProduto.setVisible(true);
            }
        }
    }//GEN-LAST:event_jtfPrecoKeyPressed

    private void jtfIcmsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIcmsKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (jpDadosProduto.isVisible()) {
                produtoSelecionado = null;
                pedidoCompraItemSelecionado = null;
                jpDadosProduto.setVisible(false);
                jpPesquisaProduto.setVisible(true);
            }
        }
    }//GEN-LAST:event_jtfIcmsKeyPressed

    private void posicionaParaInclusao() {
        try {
            Object hashObj = hashProdutoIndex.get(((TableModelPesquisaProduto) jtPesquisaProduto.getModel()).buscaProduto(jtPesquisaProduto.getSelectedRow()).getProduto().getIdProduto());
            if (hashObj != null) {
                JOptionPane.showMessageDialog(null, "Item já lançado no pedido", "Atenção!", JOptionPane.WARNING_MESSAGE);
                jtItens.setRowSelectionInterval(Integer.valueOf(hashObj.toString()), Integer.valueOf(hashObj.toString()));
            } else {
                jtItens.clearSelection();
                jpPesquisaProduto.setVisible(false);
                jpDadosProduto.setVisible(true);
                produtoSelecionado = ((TableModelPesquisaProduto) jtPesquisaProduto.getModel()).buscaProduto(jtPesquisaProduto.getSelectedRow());

                jtfIdProduto.setText(produtoSelecionado.getProduto().getIdProduto().toString());
                jtfNumeroFabricante.setText(produtoSelecionado.getProduto().getNumeroFabricante());
                jtfFabricante.setText(produtoSelecionado.getProduto().getFabricante().getNome());
                jtfPreco.setText(StringUtils.BigDecimalToString(produtoSelecionado.getProduto().getCustoFornecedor().getCustoUnitario()));
                jtfIcms.setText(StringUtils.BigDecimalToString(produtoSelecionado.getProduto().getCustoFornecedor().getPercentIcms()));
                jtfIpi.setText(StringUtils.BigDecimalToString(produtoSelecionado.getProduto().getCustoFornecedor().getPercentIpi()));
                jtfQtd.requestFocus();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void posicinaParaAlteracao() {
        try {
            jpPesquisaProduto.setVisible(false);
            jpDadosProduto.setVisible(true);
            pedidoCompraItemSelecionado = ((TableModelItensPedidoCompra) jtItens.getModel()).buscaProduto(jtItens.getSelectedRow());
            jtfIdProduto.setText(pedidoCompraItemSelecionado.getProduto().getIdProduto().toString());
            jtfNumeroFabricante.setText(pedidoCompraItemSelecionado.getProduto().getNumeroFabricante());
            jtfFabricante.setText(pedidoCompraItemSelecionado.getProduto().getFabricante().getNome());
            jtfPreco.setText(StringUtils.BigDecimalToString(pedidoCompraItemSelecionado.getValorUnitarioLiquido()));
            jtfIcms.setText(StringUtils.BigDecimalToString(pedidoCompraItemSelecionado.getPercentIcms()));
            jtfIpi.setText(StringUtils.BigDecimalToString(pedidoCompraItemSelecionado.getPercentIpi()));
            jtfQtd.requestFocus();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void jtItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtItensMouseClicked
        posicinaParaAlteracao();
    }//GEN-LAST:event_jtItensMouseClicked

    private void jtPesquisaProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPesquisaProdutoMouseClicked
        posicionaParaInclusao();
    }//GEN-LAST:event_jtPesquisaProdutoMouseClicked

    private void calculaTotalUnitarioLiquido() {
        pedidoCompraItemSelecionado.setTotalUnitarioLiquido(pedidoCompraItemSelecionado.getValorUnitarioLiquido().multiply(pedidoCompraItemSelecionado.getQuantidadePedida()));
    }

    private void calculaValorUnitarioBruto() {
        pedidoCompraItemSelecionado.setValorUnitarioBruto(pedidoCompraItemSelecionado.getValorUnitarioLiquido().add(pedidoCompraItemSelecionado.getValorIcmsSt()).add(pedidoCompraItemSelecionado.getValorIpi()));
    }

    private void calculaTotalUnitarioBruto() {
        pedidoCompraItemSelecionado.setTotalUnitarioBruto(pedidoCompraItemSelecionado.getValorUnitarioBruto().multiply(pedidoCompraItemSelecionado.getQuantidadePedida()));
    }

    private void calculaValorIpi() {
        pedidoCompraItemSelecionado.setValorIpi(pedidoCompraItemSelecionado.getValorUnitarioLiquido().multiply(pedidoCompraItemSelecionado.getProduto().getCustoFornecedor().getPercentIpi().divide(new BigDecimal(100))));
    }

    private void calculaValorIcms() {
        pedidoCompraItemSelecionado.setValorIcms(pedidoCompraItemSelecionado.getValorUnitarioLiquido().multiply(pedidoCompraItemSelecionado.getProduto().getCustoFornecedor().getPercentIcms().divide(new BigDecimal(100))));
    }

    private void calculaValorIcmsSt() throws Exception {
        try {
            SubstituicaoTributariaEntrada substTribEntrada = new SubstituicaoTributariaEntrada();
            substTribEntrada.calculaSubstituicaoTributaria(pedidoCompraItemSelecionado.getProduto().getCustoFornecedor(), pedidoCompraItemSelecionado.getValorUnitarioLiquido(), pedidoCompraItemSelecionado.getValorIpi(), pedidoCompraItemSelecionado.getProduto().getCustoFornecedor().getPercentIcms());
            pedidoCompraItemSelecionado.setValorIcmsSt(substTribEntrada.getIcmsSubstituicao());
            pedidoCompraItemSelecionado.setValorBaseIcmsSt(substTribEntrada.getBaseSubstituicao());
        } catch (Exception ex) {
            if (ex instanceof NoResultException) {
                pedidoCompraItemSelecionado.setValorIcmsSt(BigDecimal.ZERO);
            } else {
                throw new Exception(ex);
            }
        }
    }

    private void onPesquisar() {
        List<Estoque> lista;
        try {
            lista = new EstoqueDao().pesquisaProduto(pedidoCompra.getFornecedor().getIdPessoa(), pedidoCompra.getEmpresa().getIdPessoa());
            ((TableModelPesquisaProduto) jtPesquisaProduto.getModel()).removeResultado();
            ((TableModelPesquisaProduto) jtPesquisaProduto.getModel()).mostraResultado(lista);
        } catch (Exception ex) {
            Logger.getLogger(FormularioPedidoCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void criaPedidoCompraTmp() {
        pedidoCompra = null;
        pedidoCompra = new PedidoCompra();
        pedidoCompra.setTemporario(Boolean.TRUE);
        pedidoCompra.setDataEmissao(new Date());
        pedidoCompra.setDataPrevisaoEntrega(new Date());
        pedidoCompra.setEmpresa((Pessoa) jcbEmpresa.getSelectedItem());
        pedidoCompra.setFornecedor((Pessoa) jtfFornecedor.getObjeto());
        pedidoCompra.criaNumeroPedido();

        atualizaDadosCapa();
        if (listaItensPedidoCompra == null) {
            listaItensPedidoCompra = new ArrayList<>();
        }
        listaItensPedidoCompra.clear();
        pedidoCompra.setItens(listaItensPedidoCompra);

        new PedidoCompraDao().salvar(pedidoCompra);
    }

    private void atualizaDadosCapa() {
        calculaTotalBruto();
        calculaTotalLiquido();
        calculaTotalIpi();
        calculaTotalIcms();
        calculaTotalBaseIcmsSt();
        calculaTotalIcmsSt();
        calculaTotalDesconto();

        jtfNumeroPedido.setText(pedidoCompra.getNumeroPedido());
        jtfTotalPedido.setText(StringUtils.BigDecimalToString(pedidoCompra.getTotalPedido()));
        jtfTotalProdutos.setText(StringUtils.BigDecimalToString(pedidoCompra.getTotalProduto()));
        jtfTotalIpi.setText(StringUtils.BigDecimalToString(pedidoCompra.getTotalIpi()));
        jtfTotalIcms.setText(StringUtils.BigDecimalToString(pedidoCompra.getTotalIcms()));
        jtfBaseIcmsSt.setText(StringUtils.BigDecimalToString(pedidoCompra.getTotalBaseIcmsSt()));
        jtfTotalIcmsSt.setText(StringUtils.BigDecimalToString(pedidoCompra.getTotalIcmsSt()));
        jtfTotalDesconto.setText(StringUtils.BigDecimalToString(pedidoCompra.getTotalDesconto()));
    }

    private void calculaTotalLiquido() {
        pedidoCompra.setTotalProduto(BigDecimal.ZERO);
        if (listaItensPedidoCompra != null) {
            for (PedidoCompraItem pedidoCompraItem : listaItensPedidoCompra) {
                pedidoCompra.setTotalProduto(pedidoCompra.getTotalProduto().add(pedidoCompraItem.getTotalUnitarioLiquido()));
            }
        }
    }

    private void calculaTotalBruto() {
        pedidoCompra.setTotalPedido(BigDecimal.ZERO);
        if (listaItensPedidoCompra != null) {
            for (PedidoCompraItem pedidoCompraItem : listaItensPedidoCompra) {
                pedidoCompra.setTotalPedido(pedidoCompra.getTotalPedido().add(pedidoCompraItem.getTotalUnitarioBruto()));
            }
        }
    }

    private void calculaTotalIpi() {
        pedidoCompra.setTotalIpi(BigDecimal.ZERO);
        if (listaItensPedidoCompra != null) {
            for (PedidoCompraItem pedidoCompraItem : listaItensPedidoCompra) {
                pedidoCompra.setTotalIpi(pedidoCompra.getTotalIpi().add(pedidoCompraItem.getValorIpi().multiply(pedidoCompraItem.getQuantidadePedida())));
            }
        }
    }

    private void calculaTotalIcms() {
        pedidoCompra.setTotalIcms(BigDecimal.ZERO);
        if (listaItensPedidoCompra != null) {
            for (PedidoCompraItem pedidoCompraItem : listaItensPedidoCompra) {
                pedidoCompra.setTotalIcms(pedidoCompra.getTotalIcms().add(pedidoCompraItem.getValorIcms().multiply(pedidoCompraItem.getQuantidadePedida())));
            }
        }
    }

    private void calculaTotalBaseIcmsSt() {
        pedidoCompra.setTotalBaseIcmsSt(BigDecimal.ZERO);
        if (listaItensPedidoCompra != null) {
            for (PedidoCompraItem pedidoCompraItem : listaItensPedidoCompra) {
                pedidoCompra.setTotalBaseIcmsSt(pedidoCompra.getTotalBaseIcmsSt().add(pedidoCompraItem.getValorBaseIcmsSt().multiply(pedidoCompraItem.getQuantidadePedida())));
            }
        }
    }

    private void calculaTotalIcmsSt() {
        pedidoCompra.setTotalIcmsSt(BigDecimal.ZERO);
        if (listaItensPedidoCompra != null) {
            for (PedidoCompraItem pedidoCompraItem : listaItensPedidoCompra) {
                pedidoCompra.setTotalIcmsSt(pedidoCompra.getTotalIcmsSt().add(pedidoCompraItem.getValorIcmsSt().multiply(pedidoCompraItem.getQuantidadePedida())));
            }
        }
    }

    private void calculaTotalDesconto() {
        pedidoCompra.setTotalDesconto(BigDecimal.ZERO);
        if (listaItensPedidoCompra != null) {
            for (PedidoCompraItem pedidoCompraItem : listaItensPedidoCompra) {
                pedidoCompra.setTotalDesconto(pedidoCompra.getTotalDesconto().add(pedidoCompraItem.getValorDesconto()));
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jautopecas.components.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private jautopecas.components.JTextField jTextField10;
    private jautopecas.components.JTextField jTextField11;
    private jautopecas.components.JComboBox jcbEmpresa;
    private javax.swing.JPanel jpCabecalho;
    private javax.swing.JPanel jpCapa;
    private javax.swing.JPanel jpDadosProduto;
    private javax.swing.JPanel jpItens;
    private javax.swing.JPanel jpItensAdicionados;
    private javax.swing.JPanel jpPesquisa;
    private javax.swing.JPanel jpPesquisaProduto;
    private javax.swing.JScrollPane jspItens;
    private javax.swing.JScrollPane jspPesquisaProduto;
    private javax.swing.JTable jtItens;
    private javax.swing.JTable jtPesquisaProduto;
    private jautopecas.components.JTextField jtfBaseIcmsSt;
    private jautopecas.components.JTextField jtfFabricante;
    private jautopecas.components.JTextField jtfFornecedor;
    private jautopecas.components.JTextField jtfFornecedor1;
    private jautopecas.components.JTextField jtfFornecedor2;
    private jautopecas.components.JTextField jtfIcms;
    private jautopecas.components.JTextField jtfIdProduto;
    private jautopecas.components.JTextField jtfIpi;
    private jautopecas.components.JTextField jtfNumeroFabricante;
    private jautopecas.components.JTextField jtfNumeroPedido;
    private jautopecas.components.JTextField jtfPreco;
    private jautopecas.components.JTextField jtfQtd;
    private jautopecas.components.JTextField jtfTipoPessoa;
    private jautopecas.components.JTextField jtfTotalDesconto;
    private jautopecas.components.JTextField jtfTotalIcms;
    private jautopecas.components.JTextField jtfTotalIcmsSt;
    private jautopecas.components.JTextField jtfTotalIpi;
    private jautopecas.components.JTextField jtfTotalPedido;
    private jautopecas.components.JTextField jtfTotalProdutos;
    private javax.swing.JTabbedPane jtpCapaItens;
    // End of variables declaration//GEN-END:variables
}
