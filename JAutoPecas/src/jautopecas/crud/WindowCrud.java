/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.crud;

import jautopecas.components.DynamicTableModel;
import jautopecas.components.JFFormattedTextField;
import jautopecas.components.JFTextField;
import jautopecas.entidades.menu.ItemMenu;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author JFFiorotto
 */
public class WindowCrud extends javax.swing.JFrame {

    /*
     * Variaveis Privadas
     */
    private List<Object[]> resultadoPesquisa = new ArrayList<>();
    private DynamicTableModel tableModel;
    private JPanel formulario;
    private Object objetoFormulario;
    private String metodoPesquisa;
    private String camposPesquisa;
    private boolean modoPesquisa;
    private JTextField jTextField;
    private int countErrosFormulario;
    private boolean pesquisando;

    /**
     * Creates new form WindowCrud
     */
    public WindowCrud() {
        initComponents();
    }

    public WindowCrud(ItemMenu itemMenu, boolean modoPesquisa, JTextField jTextField) {
        try {
            initComponents();
            Class classeFormulario = Class.forName(itemMenu.getClasseFormulario());
            Class classeEntidade = Class.forName(itemMenu.getClasseEntidade());
            this.objetoFormulario = classeEntidade.newInstance();
            this.formulario = (JPanel) classeFormulario.newInstance();
            this.metodoPesquisa = itemMenu.getMetodoPesquisa();
            this.camposPesquisa = itemMenu.getCamposPesquisa();
            this.modoPesquisa = modoPesquisa;
            this.jTextField = jTextField;
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

            if (this.modoPesquisa) {
                jToolBar2.setVisible(false);
            } else {
                jbNovo.setEnabled(true);
                jbSalvar.setEnabled(false);
                jbLimpar.setEnabled(false);
                jbEditar.setEnabled(false);
                jbExcluir.setEnabled(false);
            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao iniciar o CRUD");
        }
    }

    //public void initComponentsExternal() {
    //    initComponents();
    //}
    /**
     * Receber como parametro um container e limpa todos os campos.
     *
     * @param container
     */
    private void limpaFormulario(Container container) {
        try {
            Component components[] = container.getComponents();
            for (Component component : components) {
                if (component instanceof JFormattedTextField) {
                    JFormattedTextField field = (JFormattedTextField) component;
                    field.setValue(null);
                } else if (component instanceof JFTextField) {
                    JFTextField jfField = (JFTextField) component;
                    jfField.limpaCampo();
                } else if (component instanceof JTextField) {
                    JTextField field = (JTextField) component;
                    field.setText("");
                } else if (component instanceof JTextArea) {
                    JTextArea area = (JTextArea) component;
                    area.setText("");
                } else if (component instanceof JComboBox) {
                    JComboBox comboBox = (JComboBox) component;
                    comboBox.setSelectedIndex(-1);
                } else if (component instanceof JTable) {
                    JTable jtable = ((JTable) component);
                    jtable.clearSelection();
                    if (jtable.getModel() instanceof DynamicTableModel) {
                        ((DynamicTableModel) jtable.getModel()).setData(null);
                    }
                } else if (component instanceof Container) {
                    limpaFormulario((Container) component);
                }
            }
        } catch (IntrospectionException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao limpar o formulario");
        }
    }

    private void bloquearFormulario(Boolean bloqueia, Container container) {
        try {
            Component components[] = container.getComponents();
            for (Component component : components) {
                if (component instanceof JFormattedTextField) {
                    JFormattedTextField field = (JFormattedTextField) component;
                    field.setEditable(!bloqueia);
                } else if (component instanceof JFTextField) {
                    JFTextField jfField = (JFTextField) component;
                    jfField.setEditable(!bloqueia);
                } else if (component instanceof JTextArea) {
                    JTextArea area = (JTextArea) component;
                    area.setEditable(!bloqueia);
                } else if (component instanceof JComboBox) {
                    JComboBox comboBox = (JComboBox) component;
                    comboBox.setEditable(!bloqueia);
                } else if (component instanceof Container) {
                    bloquearFormulario(bloqueia, (Container) component);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao bloquear o formulario");
        }
    }

    /**
     * Receber como parametro um container e valida todos os campos.
     *
     * @param container
     */
    private boolean validarFormulario(Container container, boolean recursive) {
        if (recursive) {
            countErrosFormulario = 0;
        }
        try {
            Component components[] = container.getComponents();
            for (Component component : components) {
                if (component instanceof JFormattedTextField) {
                    JFormattedTextField field = (JFormattedTextField) component;
                    field.setValue(null);
                } else if (component instanceof JFTextField) {
                    JFTextField field = (JFTextField) component;
                    if (!field.validaCampo()) {
                        countErrosFormulario++;
                    }
                } else if (component instanceof JTextArea) {
                    JTextArea area = (JTextArea) component;
                    area.setText("");
                } else if (component instanceof Container) {
                    validarFormulario((Container) component, false);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao validar o formulario");
        }
        return countErrosFormulario > 0 ? false : true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        limpaFormulario(this);
        bloquearFormulario(false, jpFormulario);
        jtpFormPesquisa.setEnabledAt(0, true);
        jtpFormPesquisa.setEnabledAt(1, false);
        jtpFormPesquisa.setSelectedIndex(0);
        jbNovo.setEnabled(false);
        jbSalvar.setEnabled(true);
        jbLimpar.setEnabled(true);
        jbExcluir.setEnabled(false);
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalvarMouseEntered
        jlInformacao.setText("Clique para SALVAR um registro novo ou alterado.");
    }//GEN-LAST:event_jbSalvarMouseEntered

    private void jbSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalvarMouseExited
        jlInformacao.setText("");
    }//GEN-LAST:event_jbSalvarMouseExited

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        if (validarFormulario(this, true)) {
            try {
                Method m;
                if (jtablePesquisa.getSelectedRow() > -1) {
                    m = formulario.getClass().getMethod("alterar");
                } else {
                    m = formulario.getClass().getMethod("salvar");
                }
                m.invoke(formulario);

                limpaFormulario(this);
                jtpFormPesquisa.setEnabledAt(0, false);
                jtpFormPesquisa.setEnabledAt(1, true);
                jtpFormPesquisa.setSelectedIndex(1);
                jbNovo.setEnabled(true);
                jbSalvar.setEnabled(false);
                jbLimpar.setEnabled(false);
                jbExcluir.setEnabled(false);

                if (jtablePesquisa.getSelectedRow() > -1) {
                    JOptionPane.showMessageDialog(this, "Registro Alterado com Sucesso!!");
                } else {
                    JOptionPane.showMessageDialog(this, "Registro Salvo com Sucesso!!");
                }
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } else {
            jlInformacao.setText("Os campos em vermelho contem erros, favor corrigi-los!!");
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbLimparMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLimparMouseEntered
        jlInformacao.setText("Clique para ABORTAR uma inclusão ou alteração de registro.");
    }//GEN-LAST:event_jbLimparMouseEntered

    private void jbLimparMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLimparMouseExited
        jlInformacao.setText("");
    }//GEN-LAST:event_jbLimparMouseExited

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        limpaFormulario(this);
        bloquearFormulario(false, jpFormulario);
        jtpFormPesquisa.setEnabledAt(0, false);
        jtpFormPesquisa.setEnabledAt(1, true);
        jtpFormPesquisa.setSelectedIndex(1);
        jbNovo.setEnabled(true);
        jbSalvar.setEnabled(false);
        jbLimpar.setEnabled(false);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jbEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEditarMouseEntered
        jlInformacao.setText("Clique pra EDITAR o registro selecionado.");
    }//GEN-LAST:event_jbEditarMouseEntered

    private void jbEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEditarMouseExited
        jlInformacao.setText("");
    }//GEN-LAST:event_jbEditarMouseExited

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        bloquearFormulario(false, jpFormulario);
        jtpFormPesquisa.setEnabledAt(0, true);
        jtpFormPesquisa.setEnabledAt(1, false);
        jtpFormPesquisa.setSelectedIndex(0);
        jbNovo.setEnabled(false);
        jbSalvar.setEnabled(true);
        jbLimpar.setEnabled(true);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbExcluirMouseEntered
        jlInformacao.setText("Clique para EXCLUIR um registro selecionado.");
    }//GEN-LAST:event_jbExcluirMouseEntered

    private void jbExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbExcluirMouseExited
        jlInformacao.setText("");
    }//GEN-LAST:event_jbExcluirMouseExited

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        try {
            Method m = formulario.getClass().getMethod("excluir");
            m.invoke(formulario);

            limpaFormulario(this);
            jtpFormPesquisa.setEnabledAt(0, false);
            jtpFormPesquisa.setEnabledAt(1, true);
            jtpFormPesquisa.setSelectedIndex(1);
            jbNovo.setEnabled(true);
            jbSalvar.setEnabled(false);
            jbLimpar.setEnabled(false);
            jbEditar.setEnabled(false);
            jbExcluir.setEnabled(false);

            JOptionPane.showMessageDialog(this, "Registro Excluido com Sucesso!!");
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
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
                                    TableRowSorter<DynamicTableModel> sorter = new TableRowSorter<>(tableModel);
                                    jtablePesquisa.setRowSorter(sorter);

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
                                JOptionPane.showMessageDialog(null, "Erro ao Pesquisa");
                            }
                        }
                    };
                    worker.start(); // So we don't hold up the dispatch thread.
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao Pesquisa");
            }
        }
    }//GEN-LAST:event_jtfFiltroPesquisaKeyPressed

    private void jtablePesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtablePesquisaMouseClicked
        if (evt.getClickCount() == 2) {
            onVisualizar();
        }
    }//GEN-LAST:event_jtablePesquisaMouseClicked

    private void jtablePesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtablePesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            onVisualizar();
        }
    }//GEN-LAST:event_jtablePesquisaKeyPressed

    private void onVisualizar() {
        try {
            if (modoPesquisa) {
                if (jTextField instanceof JFTextField) {
                    JFTextField jfTextField = (JFTextField) jTextField;
                    jfTextField.setObjeto(((DynamicTableModel) jtablePesquisa.getModel()).getObjectAtRow(jtablePesquisa.getSelectedRow()));
                } else if (jTextField instanceof JFFormattedTextField) {
                    JFFormattedTextField jfFormattedTextField = (JFFormattedTextField) jTextField;
                    jfFormattedTextField.setObjeto(((DynamicTableModel) jtablePesquisa.getModel()).getObjectAtRow(jtablePesquisa.getSelectedRow()));
                }
                dispose();
            } else {
                setObjetoFormulario(((DynamicTableModel) jtablePesquisa.getModel()).getObjectAtRow(jtablePesquisa.getSelectedRow()));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao executar onVisualizar");
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
            bloquearFormulario(true, jpFormulario);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao executar setObjetoFormulario");
        }
    }

    public void setPesquisa(String pesquisa) {
        String str = "";
        for (StringTokenizer stringTokenizer = new StringTokenizer(pesquisa); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();
            if (token.equals("-")) {
                continue;
            }
            str += (str.length() > 0 ? "+" : "") + token;
        }
        jtfFiltroPesquisa.setText(str);
        jtfFiltroPesquisaKeyPressed(null);
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
