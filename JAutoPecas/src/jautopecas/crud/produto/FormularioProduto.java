package jautopecas.crud.produto;

import jautopecas.crud.IFormulario;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.dao.produto.ProdutoDao;
import jautopecas.dao.produto.TipoProdutoDao;
import jautopecas.entidades.pessoa.Pessoa;
import jautopecas.entidades.produto.*;
import jautopecas.util.StringUtils;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JFFiorotto
 */
public class FormularioProduto extends javax.swing.JPanel implements IFormulario {

    public FormularioProduto() {
        initComponents();
        carregaCombos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jtfIdProduto = new jautopecas.components.JTextField();
        jlIdProduto = new javax.swing.JLabel();
        jtfNumeroFabricante = new jautopecas.components.JTextField();
        jlIdProduto1 = new javax.swing.JLabel();
        jtfDescricao = new jautopecas.components.JTextField();
        jlIdProduto2 = new javax.swing.JLabel();
        jlIdProduto10 = new javax.swing.JLabel();
        jtfFabricante = new jautopecas.components.JTextField();
        jlIdProduto3 = new javax.swing.JLabel();
        jtfGrupo = new jautopecas.components.JTextField();
        jlIdProduto11 = new javax.swing.JLabel();
        jtfSubgrupo = new jautopecas.components.JTextField();
        jlIdProduto16 = new javax.swing.JLabel();
        jtfFamilia = new jautopecas.components.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaAplicacao = new javax.swing.JTextArea();
        jlIdProduto17 = new javax.swing.JLabel();
        jtfMarca = new jautopecas.components.JTextField();
        jlIdProduto18 = new javax.swing.JLabel();
        jcbTipoProduto = new jautopecas.components.JComboBox();
        jlIdProduto19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jlIdProduto4 = new javax.swing.JLabel();
        jtfQtdEmbalagemCompra = new jautopecas.components.JTextField();
        jlIdProduto5 = new javax.swing.JLabel();
        jtfQtdEmbalagemVenda = new jautopecas.components.JTextField();
        jlIdProduto6 = new javax.swing.JLabel();
        jtfFatorEmbalagemCompra = new jautopecas.components.JTextField();
        jlIdProduto7 = new javax.swing.JLabel();
        jtfFatorEmbalagemVenda = new jautopecas.components.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jlIdProduto8 = new javax.swing.JLabel();
        jtfPesoLiquido = new jautopecas.components.JTextField();
        jlIdProduto9 = new javax.swing.JLabel();
        jtfPesoBruto = new jautopecas.components.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jlIdProduto12 = new javax.swing.JLabel();
        jtfUnidadeCompra = new jautopecas.components.JTextField();
        jlIdProduto13 = new javax.swing.JLabel();
        jtfUnidadeVenda = new jautopecas.components.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jlIdProduto14 = new javax.swing.JLabel();
        jtfCodigoBarraFabricante = new jautopecas.components.JTextField();
        jlIdProduto15 = new javax.swing.JLabel();
        jtfCodigoBarraEmpresa = new jautopecas.components.JTextField();
        jPanel7 = new javax.swing.JPanel();
        formularioProdutoFornecedor = new jautopecas.crud.produto.FormularioProdutoFornecedor();

        setPreferredSize(new java.awt.Dimension(800, 550));

        jtfIdProduto.setEditable(false);
        jtfIdProduto.setEnabled(false);
        jtfIdProduto.setMensagemAjuda("ID Colaborador (Gerado pelo sistema)");

        jlIdProduto.setText("ID Produto");

        jtfNumeroFabricante.setMaximoCaracteres(150);
        jtfNumeroFabricante.setRequerido(true);

        jlIdProduto1.setText("Numero Fabricante");

        jtfDescricao.setMaximoCaracteres(250);
        jtfDescricao.setRequerido(true);

        jlIdProduto2.setText("Descrição");

        jlIdProduto10.setText("Fabricante");

        jtfFabricante.setClasseFormulario("jautopecas.crud.pessoa.fabricante.FormularioFabricante");
        jtfFabricante.setRequerido(true);

        jlIdProduto3.setText("Grupo");

        jtfGrupo.setClasseFormulario("jautopecas.crud.produto.FormularioGrupo");
        jtfGrupo.setRequerido(true);

        jlIdProduto11.setText("Subgrupo");

        jtfSubgrupo.setClasseFormulario("jautopecas.crud.produto.FormularioSubgrupo");

        jlIdProduto16.setText("Familia");

        jtfFamilia.setClasseFormulario("jautopecas.crud.produto.FormularioFamilia");

        jtaAplicacao.setColumns(20);
        jtaAplicacao.setRows(5);
        jScrollPane1.setViewportView(jtaAplicacao);

        jlIdProduto17.setText("Aplicação");

        jtfMarca.setClasseFormulario("jautopecas.crud.produto.FormularioMarca");
        jtfMarca.setRequerido(true);

        jlIdProduto18.setText("Marca");

        jcbTipoProduto.setClasseFormulario("jautopecas.crud.pessoa.telefone.FormularioTipoTelefone");
        jcbTipoProduto.setMensagemAjuda("Tipo de telefone. EX:. Comercial,Residencial,Etc...");

        jlIdProduto19.setText("Tipo Produto");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlIdProduto19, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlIdProduto17, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlIdProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfNumeroFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jlIdProduto2, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jtfDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jtfFabricante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jlIdProduto3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jtfGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jlIdProduto11, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jtfSubgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jlIdProduto10, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfFamilia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlIdProduto18, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlIdProduto16, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 107, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdProduto)
                    .addComponent(jlIdProduto19))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdProduto10)
                    .addComponent(jlIdProduto18))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jlIdProduto3)
                        .addGap(6, 6, 6)
                        .addComponent(jtfGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jlIdProduto11)
                        .addGap(6, 6, 6)
                        .addComponent(jtfSubgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jlIdProduto16)
                        .addGap(6, 6, 6)
                        .addComponent(jtfFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdProduto1)
                    .addComponent(jlIdProduto2))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNumeroFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlIdProduto17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dados Basicos", jPanel4);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quantidades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        jlIdProduto4.setText("Qtd. Embalagem Compra");

        jtfQtdEmbalagemCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jtfQtdEmbalagemCompra.setRequerido(true);

        jlIdProduto5.setText("Qtd. Embalagem Venda");

        jtfQtdEmbalagemVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jtfQtdEmbalagemVenda.setRequerido(true);

        jlIdProduto6.setText("Fator Embalagem Compra");

        jtfFatorEmbalagemCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jtfFatorEmbalagemCompra.setRequerido(true);

        jlIdProduto7.setText("Fator Embalagem Venda");

        jtfFatorEmbalagemVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jtfFatorEmbalagemVenda.setRequerido(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfQtdEmbalagemCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlIdProduto4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfQtdEmbalagemVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlIdProduto5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfFatorEmbalagemCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlIdProduto6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfFatorEmbalagemVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlIdProduto7, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlIdProduto7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlIdProduto6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfFatorEmbalagemCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfFatorEmbalagemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlIdProduto5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfQtdEmbalagemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlIdProduto4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfQtdEmbalagemCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        jlIdProduto8.setText("Peso Liquido");

        jtfPesoLiquido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.000"))));
        jtfPesoLiquido.setRequerido(true);

        jlIdProduto9.setText("Peso Bruto");

        jtfPesoBruto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.000"))));
        jtfPesoBruto.setRequerido(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfPesoLiquido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlIdProduto8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfPesoBruto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlIdProduto9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlIdProduto9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPesoBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlIdProduto8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPesoLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unidades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        jlIdProduto12.setText("Unidade Compra");

        jtfUnidadeCompra.setClasseFormulario("jautopecas.crud.produto.FormularioUnidade");
        jtfUnidadeCompra.setRequerido(true);

        jlIdProduto13.setText("Unidade Venda");

        jtfUnidadeVenda.setClasseFormulario("jautopecas.crud.produto.FormularioUnidade");
        jtfUnidadeVenda.setRequerido(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfUnidadeCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlIdProduto12, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfUnidadeVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlIdProduto13, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(501, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jlIdProduto13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfUnidadeVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jlIdProduto12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfUnidadeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Codigos Barra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        jlIdProduto14.setText("Codigo Barra Fabricante");

        jtfCodigoBarraFabricante.setRequerido(true);

        jlIdProduto15.setText("Codigo Barra Empresa");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfCodigoBarraFabricante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlIdProduto14, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfCodigoBarraEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlIdProduto15, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(501, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jlIdProduto15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCodigoBarraEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jlIdProduto14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCodigoBarraFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Embalagem", jPanel5);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formularioProdutoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formularioProdutoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPane2.addTab("Produto X Fornecedor", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jautopecas.crud.produto.FormularioProdutoFornecedor formularioProdutoFornecedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private jautopecas.components.JComboBox jcbTipoProduto;
    private javax.swing.JLabel jlIdProduto;
    private javax.swing.JLabel jlIdProduto1;
    private javax.swing.JLabel jlIdProduto10;
    private javax.swing.JLabel jlIdProduto11;
    private javax.swing.JLabel jlIdProduto12;
    private javax.swing.JLabel jlIdProduto13;
    private javax.swing.JLabel jlIdProduto14;
    private javax.swing.JLabel jlIdProduto15;
    private javax.swing.JLabel jlIdProduto16;
    private javax.swing.JLabel jlIdProduto17;
    private javax.swing.JLabel jlIdProduto18;
    private javax.swing.JLabel jlIdProduto19;
    private javax.swing.JLabel jlIdProduto2;
    private javax.swing.JLabel jlIdProduto3;
    private javax.swing.JLabel jlIdProduto4;
    private javax.swing.JLabel jlIdProduto5;
    private javax.swing.JLabel jlIdProduto6;
    private javax.swing.JLabel jlIdProduto7;
    private javax.swing.JLabel jlIdProduto8;
    private javax.swing.JLabel jlIdProduto9;
    private javax.swing.JTextArea jtaAplicacao;
    private jautopecas.components.JTextField jtfCodigoBarraEmpresa;
    private jautopecas.components.JTextField jtfCodigoBarraFabricante;
    private jautopecas.components.JTextField jtfDescricao;
    private jautopecas.components.JTextField jtfFabricante;
    private jautopecas.components.JTextField jtfFamilia;
    private jautopecas.components.JTextField jtfFatorEmbalagemCompra;
    private jautopecas.components.JTextField jtfFatorEmbalagemVenda;
    private jautopecas.components.JTextField jtfGrupo;
    private jautopecas.components.JTextField jtfIdProduto;
    private jautopecas.components.JTextField jtfMarca;
    private jautopecas.components.JTextField jtfNumeroFabricante;
    private jautopecas.components.JTextField jtfPesoBruto;
    private jautopecas.components.JTextField jtfPesoLiquido;
    private jautopecas.components.JTextField jtfQtdEmbalagemCompra;
    private jautopecas.components.JTextField jtfQtdEmbalagemVenda;
    private jautopecas.components.JTextField jtfSubgrupo;
    private jautopecas.components.JTextField jtfUnidadeCompra;
    private jautopecas.components.JTextField jtfUnidadeVenda;
    // End of variables declaration//GEN-END:variables
    private Produto produto;

    @Override
    public void setObjetoFormulario(Object objetoFormulario) throws Exception {
        produto = (Produto) objetoFormulario;
        jtfIdProduto.setText(String.valueOf(produto.getIdProduto()));
        jtfFabricante.setObjeto(produto.getFabricante());
        jtfMarca.setObjeto(produto.getMarca());
        jtfGrupo.setObjeto(produto.getGrupo());
        jtfSubgrupo.setObjeto(produto.getSubGrupo());
        jtfFamilia.setObjeto(produto.getFamilia());
        jtfNumeroFabricante.setText(produto.getNumeroFabricante());
        jtfDescricao.setText(produto.getDescricao());
        jtaAplicacao.setText(produto.getAplicacao());
        jtfQtdEmbalagemCompra.setText(StringUtils.BigDecimalToString(produto.getQtdEmbalagemCompra()));
        jtfQtdEmbalagemVenda.setText(StringUtils.BigDecimalToString(produto.getQtdEmbalagemVenda()));
        jtfFatorEmbalagemCompra.setText(StringUtils.BigDecimalToString(produto.getFatorEmbalagemCompra()));
        jtfFatorEmbalagemVenda.setText(StringUtils.BigDecimalToString(produto.getFatorEmbalagemVenda()));
        jtfPesoLiquido.setText(StringUtils.BigDecimalToString(produto.getPesoLiguido()));
        jtfPesoBruto.setText(StringUtils.BigDecimalToString(produto.getPesoBruto()));
        jtfCodigoBarraFabricante.setText(produto.getCodigoBarraFabricante());
        jtfCodigoBarraEmpresa.setText(produto.getCodigoBarraEmpresa());
        jtfUnidadeCompra.setObjeto(produto.getUnidadeCompra());
        jtfUnidadeVenda.setObjeto(produto.getUnidadeVenda());
        jcbTipoProduto.setSelectedItem(produto.getTipoProduto());
        formularioProdutoFornecedor.setProdutoSelecionado(produto);
        formularioProdutoFornecedor.setListaProdutoFornecedor(produto.getProdutoFornecedor());
    }

    @Override
    public void salvar() throws Exception {
        new ProdutoDao().salvar(getObjetoFormulario());
        setObjetoFormulario(produto);
    }

    @Override
    public void alterar() throws Exception {
        new ProdutoDao().alterar(getObjetoFormulario());
        setObjetoFormulario(produto);
    }

    @Override
    public void excluir() throws Exception {
        new ProdutoDao().excluir(produto);
    }

    @Override
    public Produto getObjetoFormulario() throws Exception {
        if (produto == null) {
            produto = new Produto();
            produto.setDataCadastro(new Date());
        }
        produto.setFabricante((Pessoa) jtfFabricante.getObjeto());
        produto.setMarca((Marca) jtfMarca.getObjeto());
        produto.setGrupo((Grupo) jtfGrupo.getObjeto());
        produto.setSubGrupo((Subgrupo) jtfSubgrupo.getObjeto());
        produto.setFamilia((Familia) jtfFamilia.getObjeto());
        produto.setNumeroFabricante(jtfNumeroFabricante.getText());
        produto.setDescricao(jtfDescricao.getText());
        produto.setAplicacao(jtaAplicacao.getText());
        produto.setQtdEmbalagemCompra(StringUtils.stringToBigDecimal(jtfQtdEmbalagemCompra.getText()));
        produto.setQtdEmbalagemVenda(StringUtils.stringToBigDecimal(jtfQtdEmbalagemVenda.getText()));
        produto.setFatorEmbalagemCompra(StringUtils.stringToBigDecimal(jtfFatorEmbalagemCompra.getText()));
        produto.setFatorEmbalagemVenda(StringUtils.stringToBigDecimal(jtfFatorEmbalagemVenda.getText()));
        produto.setPesoLiguido(StringUtils.stringToBigDecimal(jtfPesoLiquido.getText()));
        produto.setPesoBruto(StringUtils.stringToBigDecimal(jtfPesoBruto.getText()));
        produto.setCodigoBarraFabricante(jtfCodigoBarraFabricante.getText());
        produto.setCodigoBarraEmpresa(jtfCodigoBarraEmpresa.getText());
        produto.setUnidadeCompra((Unidade) jtfUnidadeCompra.getObjeto());
        produto.setUnidadeVenda((Unidade) jtfUnidadeVenda.getObjeto());
        produto.setTipoProduto((TipoProduto) jcbTipoProduto.getSelectedItem());
        return produto;
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
        return new ProdutoDao().listarTodos();
    }

    public List pesquisaSimples(String strCamposPesqisa, String strPesquisa) {
        return new ProdutoDao().pesquisaSimples(strCamposPesqisa, strPesquisa);
    }

    private void carregaCombos() {
        jcbTipoProduto.setDataSet(new TipoProdutoDao().listarTodos());
    }
}
