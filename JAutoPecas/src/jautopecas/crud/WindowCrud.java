/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.crud;

import jautopecas.components.DynamicTableModel;
import jautopecas.components.JFComboBox;
import jautopecas.components.JFTextField;
import jautopecas.entidades.menu.ItemMenu;
import jautopecas.exceptions.UtilFormularioException;
import jautopecas.util.UtilFormulario;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.*;

/**
 *
 * @author JFFiorotto
 */
public class WindowCrud extends javax.swing.JFrame {

    /*
     * Variaveis Privadas
     */
    private static final int MODO_OBSERVACAO = 0;
    private static final int MODO_INCULSAO = 1;
    private static final int MODO_ALTERACAO = 2;
    private int modoOperacao;
    private List<Object[]> resultadoPesquisa = new ArrayList<>();
    private DynamicTableModel tableModel;
    private JPanel formulario;
    private Object objetoFormulario;
    private String metodoPesquisa;
    private String camposPesquisa;
    private String modoF1F2;
    private JComponent jComponent;
    private int countErrosFormulario;
    private boolean pesquisando;
    private UtilFormulario utilFormulario = new UtilFormulario();

    /**
     * Creates new form WindowCrud
     */
    public WindowCrud() {
        initComponents();
    }

    public WindowCrud(ItemMenu itemMenu, String modoF1F2, JComponent jComponent) {
        try {
            initComponents();
            Class classeFormulario = Class.forName(itemMenu.getClasseFormulario());
            Class classeEntidade = Class.forName(itemMenu.getClasseEntidade());
            this.objetoFormulario = classeEntidade.newInstance();
            this.formulario = (JPanel) classeFormulario.newInstance();
            this.metodoPesquisa = itemMenu.getMetodoPesquisa();
            this.camposPesquisa = itemMenu.getCamposPesquisa();
            this.modoF1F2 = modoF1F2;
            this.jComponent = jComponent;
            jpFormulario.add(this.formulario);
            this.pack();

            if (itemMenu.getCaminhoImagem() != null) {
                this.setIconImage(new ImageIcon(getClass().getResource(itemMenu.getCaminhoImagem())).getImage());
            }
            this.setTitle(itemMenu.getNome());
            this.setLocationRelativeTo(null);

            jtpFormPesquisa.setEnabledAt(0, false);
            jtpFormPesquisa.setEnabledAt(1, true);
            jtpFormPesquisa.setSelectedIndex(1);

            if (modoF1F2 != null && modoF1F2.equals("F1")) {
                jToolBar2.setVisible(false);
            } else {
                jbNovo.setEnabled(true);
                jbSalvar.setEnabled(false);
                jbLimpar.setEnabled(false);
                jbEditar.setEnabled(false);
                jbExcluir.setEnabled(false);
            }

            this.addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosing(WindowEvent ev) {
                    if (modoOperacao != MODO_OBSERVACAO) {
                        JOptionPane.showMessageDialog(null, "Confirme ou Limpe antes de fechar a janela", "Atenção!", JOptionPane.WARNING_MESSAGE);
                    } else {
                        dispose();
                    }
                }
            });
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao iniciar o CRUD", "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBarraInformacao = new javax.swing.JPanel();
        jlInformacao = new javax.swing.JLabel();
        jpConteudo = new javax.swing.JPanel();
        jtpFormPesquisa = new javax.swing.JTabbedPane();
        jpFormulario = new javax.swing.JPanel();
        jpPesquisa = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablePesquisa = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jtfFiltroPesquisa = new jautopecas.components.JFTextField();
        jToolBar2 = new javax.swing.JToolBar();
        jbNovo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jbSalvar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jbLimpar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jbEditar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jbExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jpBarraInformacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpBarraInformacao.setMinimumSize(new java.awt.Dimension(0, 20));
        jpBarraInformacao.setPreferredSize(new java.awt.Dimension(20, 20));
        jpBarraInformacao.setLayout(new java.awt.BorderLayout());

        jlInformacao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlInformacao.setName("jlInformacao");
        jpBarraInformacao.add(jlInformacao, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpBarraInformacao, java.awt.BorderLayout.PAGE_END);

        jpConteudo.setLayout(new java.awt.BorderLayout());

        jpFormulario.setLayout(new java.awt.BorderLayout());
        jtpFormPesquisa.addTab("Formulário", jpFormulario);

        jpPesquisa.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(0, 0));

        jtablePesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtablePesquisa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtablePesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtablePesquisaMouseClicked(evt);
            }
        });
        jtablePesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtablePesquisaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtablePesquisa);

        jpPesquisa.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));
        jPanel1.setPreferredSize(new java.awt.Dimension(43, 43));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jtfFiltroPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtfFiltroPesquisa.setMensagemAjuda("Digite oque deseja buscar. EX:. CARRO + BRANCO o resultado sera de carros na cor branca");
        jtfFiltroPesquisa.setPreferredSize(new java.awt.Dimension(250, 20));
        jtfFiltroPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfFiltroPesquisaKeyPressed(evt);
            }
        });
        jPanel1.add(jtfFiltroPesquisa);

        jpPesquisa.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jtpFormPesquisa.addTab("Pesquisa", jpPesquisa);

        jpConteudo.add(jtpFormPesquisa, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpConteudo, java.awt.BorderLayout.CENTER);

        jToolBar2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar2.setRollover(true);
        jToolBar2.setMaximumSize(new java.awt.Dimension(0, 0));

        jbNovo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeNovo24.png"))); // NOI18N
        jbNovo.setMnemonic(KeyEvent.VK_N);
        jbNovo.setFocusable(false);
        jbNovo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbNovo.setLabel("Novo");
        jbNovo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jbNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbNovoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbNovoMouseExited(evt);
            }
        });
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });
        jToolBar2.add(jbNovo);
        jToolBar2.add(jSeparator1);

        jbSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeConfirmar24.png"))); // NOI18N
        jbSalvar.setMnemonic(KeyEvent.VK_S);
        jbSalvar.setFocusable(false);
        jbSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbSalvar.setLabel("Salvar");
        jbSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbSalvarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbSalvarMouseExited(evt);
            }
        });
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });
        jToolBar2.add(jbSalvar);
        jToolBar2.add(jSeparator2);

        jbLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeLimpar24.png"))); // NOI18N
        jbLimpar.setMnemonic(KeyEvent.VK_L);
        jbLimpar.setFocusable(false);
        jbLimpar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbLimpar.setLabel("Limpar");
        jbLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbLimparMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbLimparMouseExited(evt);
            }
        });
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });
        jToolBar2.add(jbLimpar);
        jToolBar2.add(jSeparator3);

        jbEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeEditar24.png"))); // NOI18N
        jbEditar.setMnemonic(KeyEvent.VK_E);
        jbEditar.setFocusable(false);
        jbEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbEditar.setLabel("Editar");
        jbEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbEditarMouseExited(evt);
            }
        });
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });
        jToolBar2.add(jbEditar);
        jToolBar2.add(jSeparator4);

        jbExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeDeletar24.png"))); // NOI18N
        jbExcluir.setMnemonic(KeyEvent.VK_X);
        jbExcluir.setFocusable(false);
        jbExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbExcluir.setLabel("Excluir");
        jbExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbExcluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbExcluirMouseExited(evt);
            }
        });
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });
        jToolBar2.add(jbExcluir);

        getContentPane().add(jToolBar2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbNovoMouseEntered
        jlInformacao.setText("Clique para criar um NOVO registro.");
    }//GEN-LAST:event_jbNovoMouseEntered

    private void jbNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbNovoMouseExited
        jlInformacao.setText("");
    }//GEN-LAST:event_jbNovoMouseExited

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        try {
            utilFormulario.limpaFormulario(formulario);
            utilFormulario.bloquearFormulario(false, formulario);
            jtpFormPesquisa.setEnabledAt(0, true);
            jtpFormPesquisa.setEnabledAt(1, false);
            jtpFormPesquisa.setSelectedIndex(0);
            jbNovo.setEnabled(false);
            jbSalvar.setEnabled(true);
            jbLimpar.setEnabled(true);
            jbExcluir.setEnabled(false);
            modoOperacao = MODO_INCULSAO;
        } catch (UtilFormularioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalvarMouseEntered
        jlInformacao.setText("Clique para SALVAR um registro novo ou alterado.");
    }//GEN-LAST:event_jbSalvarMouseEntered

    private void jbSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalvarMouseExited
        jlInformacao.setText("");
    }//GEN-LAST:event_jbSalvarMouseExited

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            if (utilFormulario.validarFormulario(formulario, true, countErrosFormulario) <= 0) {

                Method m;
                if (objetoFormulario != null) {
                    m = formulario.getClass().getMethod("alterar");
                } else {
                    m = formulario.getClass().getMethod("salvar");
                }
                m.invoke(formulario);
                try {
                    utilFormulario.limpaFormulario(formulario);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
                }
                jtpFormPesquisa.setEnabledAt(0, false);
                jtpFormPesquisa.setEnabledAt(1, true);
                jtpFormPesquisa.setSelectedIndex(1);
                jbNovo.setEnabled(true);
                jbSalvar.setEnabled(false);
                jbLimpar.setEnabled(false);
                jbExcluir.setEnabled(false);

                if (objetoFormulario != null) {
                    JOptionPane.showMessageDialog(this, "Registro Alterado com Sucesso!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Registro Salvo com Sucesso!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }

                refreshJComponent();

            } else {
                jlInformacao.setText("Os campos em vermelho contem erros, favor corrigi-los!!");
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | UtilFormularioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbLimparMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLimparMouseEntered
        jlInformacao.setText("Clique para ABORTAR uma inclusão ou alteração de registro.");
    }//GEN-LAST:event_jbLimparMouseEntered

    private void jbLimparMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLimparMouseExited
        jlInformacao.setText("");
    }//GEN-LAST:event_jbLimparMouseExited

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        try {
            utilFormulario.limpaFormulario(formulario);
            utilFormulario.bloquearFormulario(false, formulario);
            jtpFormPesquisa.setEnabledAt(0, false);
            jtpFormPesquisa.setEnabledAt(1, true);
            jtpFormPesquisa.setSelectedIndex(1);
            jbNovo.setEnabled(true);
            jbSalvar.setEnabled(false);
            jbLimpar.setEnabled(false);
            jbEditar.setEnabled(false);
            jbExcluir.setEnabled(false);
            objetoFormulario = null;
            modoOperacao = MODO_OBSERVACAO;
        } catch (UtilFormularioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jbEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEditarMouseEntered
        jlInformacao.setText("Clique pra EDITAR o registro selecionado.");
    }//GEN-LAST:event_jbEditarMouseEntered

    private void jbEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEditarMouseExited
        jlInformacao.setText("");
    }//GEN-LAST:event_jbEditarMouseExited

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        try {
            utilFormulario.bloquearFormulario(false, formulario);
            jtpFormPesquisa.setEnabledAt(0, true);
            jtpFormPesquisa.setEnabledAt(1, false);
            jtpFormPesquisa.setSelectedIndex(0);
            jbNovo.setEnabled(false);
            jbSalvar.setEnabled(true);
            jbLimpar.setEnabled(true);
            jbEditar.setEnabled(false);
            jbExcluir.setEnabled(false);
            modoOperacao = MODO_ALTERACAO;
        } catch (UtilFormularioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbExcluirMouseEntered
        jlInformacao.setText("Clique para EXCLUIR um registro selecionado.");
    }//GEN-LAST:event_jbExcluirMouseEntered

    private void jbExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbExcluirMouseExited
        jlInformacao.setText("");
    }//GEN-LAST:event_jbExcluirMouseExited

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        try {
            Object[] options = {"Sim", "Não"};
            if (JOptionPane.showOptionDialog(null, "Deseja Excluir o registro selecionado?", "Atenção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]) == 0) {
                Method m = formulario.getClass().getMethod("excluir");
                m.invoke(formulario);

                utilFormulario.limpaFormulario(formulario);
                jtpFormPesquisa.setEnabledAt(0, false);
                jtpFormPesquisa.setEnabledAt(1, true);
                jtpFormPesquisa.setSelectedIndex(1);
                jbNovo.setEnabled(true);
                jbSalvar.setEnabled(false);
                jbLimpar.setEnabled(false);
                jbEditar.setEnabled(false);
                jbExcluir.setEnabled(false);

                JOptionPane.showMessageDialog(this, "Registro Excluido com Sucesso!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                refreshJComponent();
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | UtilFormularioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jtfFiltroPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfFiltroPesquisaKeyPressed
        int keyCode = KeyEvent.VK_ENTER;
        if (evt != null) {
            keyCode = evt.getKeyCode();
        }
        if (keyCode == KeyEvent.VK_ENTER) {
            try {
                if (!pesquisando) {
                    pesquisando = true;
                    Thread worker = new Thread() {

                        @Override
                        public void run() {
                            try {
                                jlInformacao.setText("Pesquisando...");
                                if (resultadoPesquisa == null) {
                                    resultadoPesquisa = new ArrayList<>();
                                }
                                Method m = formulario.getClass().getMethod(metodoPesquisa, new Class[]{String.class, String.class
                                        });
                                resultadoPesquisa.clear();

                                resultadoPesquisa.addAll(
                                        (List) m.invoke(formulario, new Object[]{camposPesquisa, jtfFiltroPesquisa.getText()}));
                                if (tableModel == null) {
                                    tableModel = new DynamicTableModel(resultadoPesquisa);
                                    jtablePesquisa.setModel(tableModel);
//                                    TableRowSorter<DynamicTableModel> sorter = new TableRowSorter<>(tableModel);
//                                    jtablePesquisa.setRowSorter(sorter);

                                } else if (!tableModel.isInicializado()) {
                                    tableModel = null;
                                    tableModel = new DynamicTableModel(resultadoPesquisa);
                                    jtablePesquisa.setModel(tableModel);
                                } else {
                                    tableModel.setData(resultadoPesquisa);
                                }
                                if (resultadoPesquisa.size() > 0) {
                                    jtablePesquisa.changeSelection(0, 0, false, false);
                                    jtablePesquisa.requestFocus();
                                    pesquisando = false;
                                    jlInformacao.setText(resultadoPesquisa.size() + " Registros encontrados!!");
                                } else {
                                    pesquisando = false;
                                    jlInformacao.setText("Nenhum registro encontrado!!");
                                }
                            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException ex) {
                                JOptionPane.showMessageDialog(null, "Erro ao pesquisar", "OOOPSS!", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    };
                    worker.start();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao pesquisar", "OOOPSS!", JOptionPane.ERROR_MESSAGE);
            } finally {
                jtablePesquisa.revalidate();
            }
        }
    }//GEN-LAST:event_jtfFiltroPesquisaKeyPressed

    private void jtablePesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtablePesquisaMouseClicked
        if (evt.getClickCount() == 2) {
            onVisualizar(0);
        }
    }//GEN-LAST:event_jtablePesquisaMouseClicked

    private void jtablePesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtablePesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            onVisualizar(evt.getKeyCode());
        }
    }//GEN-LAST:event_jtablePesquisaKeyPressed

    private void onVisualizar(int keyCode) {
        objetoFormulario = ((DynamicTableModel) jtablePesquisa.getModel()).getObjectAtRow(jtablePesquisa.getSelectedRow());
        try {
            if ((keyCode == KeyEvent.VK_ENTER || keyCode == 0) && modoF1F2 != null) {
                if (modoF1F2.equals("F1")) {
                    if (jComponent instanceof JFTextField) {
                        JFTextField jfTextField = (JFTextField) jComponent;
                        jfTextField.setObjeto(objetoFormulario);
                    } else if (jComponent instanceof JFComboBox) {
                        JFComboBox jfComboBox = (JFComboBox) jComponent;
                        jfComboBox.refreshDataSet();
                        jfComboBox.setSelectedItem(objetoFormulario);
                    }
                    jComponent.requestFocus();
                    dispose();
                } else {
                    setObjetoFormulario(objetoFormulario);
                }
            } else {
                setObjetoFormulario(objetoFormulario);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar visualização", "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JLabel getJlInformacao() {
        return jlInformacao;
    }

    public void setObjetoFormulario(Object objetoFormulario) {
        try {
            this.objetoFormulario = objetoFormulario;
            Method m = formulario.getClass().getMethod("setObjetoFormulario", Object.class);
            m.invoke(formulario,
                    new Object[]{objetoFormulario});

            jtpFormPesquisa.setEnabledAt(0, true);
            jtpFormPesquisa.setEnabledAt(1, false);
            jtpFormPesquisa.setSelectedIndex(0);
            jbNovo.setEnabled(false);
            jbSalvar.setEnabled(false);
            jbLimpar.setEnabled(true);
            jbEditar.setEnabled(true);
            jbExcluir.setEnabled(true);
            utilFormulario.bloquearFormulario(true, formulario);
        } catch (UtilFormularioException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setPesquisa(String pesquisa) {
        String str = "";
        for (StringTokenizer stringTokenizer = new StringTokenizer(pesquisa); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();
            if (token.equals("-") || token.equals(" ")) {
                continue;
            }
            str += (str.length() > 0 ? "+" : "") + token;
        }
        jtfFiltroPesquisa.setText(str);
        jtfFiltroPesquisaKeyPressed(null);
    }

    private void refreshJComponent() {
        try {
            if (modoF1F2 != null && modoF1F2.equals("F2")) {
                if (jComponent instanceof JFTextField) {
                    JFTextField jfTextField = (JFTextField) jComponent;
                    jfTextField.setObjeto(objetoFormulario);
                } else if (jComponent instanceof JFComboBox) {
                    JFComboBox jfComboBox = (JFComboBox) jComponent;
                    jfComboBox.refreshDataSet();
                    jfComboBox.setSelectedItem(objetoFormulario);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar componente", "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JLabel jlInformacao;
    private javax.swing.JPanel jpBarraInformacao;
    private javax.swing.JPanel jpConteudo;
    private javax.swing.JPanel jpFormulario;
    private javax.swing.JPanel jpPesquisa;
    private javax.swing.JTable jtablePesquisa;
    private jautopecas.components.JFTextField jtfFiltroPesquisa;
    private javax.swing.JTabbedPane jtpFormPesquisa;
    // End of variables declaration//GEN-END:variables
}
