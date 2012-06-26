package jautopecas.crud;

import jautopecas.JAutoPecasMenu;
import jautopecas.components.DynamicTableModel;
import jautopecas.components.JComboBox;
import jautopecas.components.JTextField;
import jautopecas.entidades.menu.ItemMenu;
import jautopecas.entidades.pessoa.login.LoginPermissaoPessoa;
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
    private boolean pesquisando;
    private ItemMenu itemMenu;

    /**
     * Creates new form WindowCrud
     */
    public WindowCrud() {
        initComponents();
    }

    public WindowCrud(ItemMenu itemMenu) {
        try {
            initComponents();
            Class classeFormulario = Class.forName(itemMenu.getClasseFormulario());
            Class classeEntidade = Class.forName(itemMenu.getClasseEntidade());
            this.objetoFormulario = classeEntidade.newInstance();
            this.formulario = (JPanel) classeFormulario.newInstance();
            this.metodoPesquisa = itemMenu.getMetodoPesquisa();
            this.camposPesquisa = itemMenu.getCamposPesquisa();
            this.itemMenu = itemMenu;
            jpFormulario.add(this.formulario);
            this.pack();

            if (itemMenu.getCaminhoImagem() != null) {
                this.setIconImage(new ImageIcon(getClass().getResource(itemMenu.getCaminhoImagem())).getImage());
            }
            this.setTitle(itemMenu.getNome());
            this.setResizable(false);
            this.setLocationRelativeTo(null);

            verificaLoginPermissaPessoa();

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
            ex.printStackTrace();
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
        jtfFiltroPesquisa = new jautopecas.components.JTextField();
        jToolBar2 = new javax.swing.JToolBar();
        jbNovo = new jautopecas.components.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jbSalvar = new jautopecas.components.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jbLimpar = new jautopecas.components.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jbEditar = new jautopecas.components.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jbExcluir = new jautopecas.components.JButton();

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

        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeNovo24.png"))); // NOI18N
        jbNovo.setMnemonic(KeyEvent.VK_N);
        jbNovo.setText("Novo");
        jbNovo.setFocusable(false);
        jbNovo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbNovo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });
        jToolBar2.add(jbNovo);
        jToolBar2.add(jSeparator1);

        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeConfirmar24.png"))); // NOI18N
        jbSalvar.setMnemonic(KeyEvent.VK_S);
        jbSalvar.setText("Salvar");
        jbSalvar.setFocusable(false);
        jbSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });
        jToolBar2.add(jbSalvar);
        jToolBar2.add(jSeparator2);

        jbLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeLimpar24.png"))); // NOI18N
        jbLimpar.setMnemonic(KeyEvent.VK_L);
        jbLimpar.setText("Limpar");
        jbLimpar.setFocusable(false);
        jbLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbLimpar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });
        jToolBar2.add(jbLimpar);
        jToolBar2.add(jSeparator3);

        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeEditar24.png"))); // NOI18N
        jbEditar.setMnemonic(KeyEvent.VK_E);
        jbEditar.setText("Editar");
        jbEditar.setFocusable(false);
        jbEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });
        jToolBar2.add(jbEditar);
        jToolBar2.add(jSeparator4);

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeDeletar24.png"))); // NOI18N
        jbExcluir.setMnemonic(KeyEvent.VK_X);
        jbExcluir.setText("Excluir");
        jbExcluir.setFocusable(false);
        jbExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });
        jToolBar2.add(jbExcluir);

        getContentPane().add(jToolBar2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                                Method m = formulario.getClass().getMethod(metodoPesquisa, new Class[]{String.class, String.class});
                                resultadoPesquisa.clear();

                                resultadoPesquisa.addAll(
                                        (List) m.invoke(formulario, new Object[]{camposPesquisa, jtfFiltroPesquisa.getText()}));
                                if (tableModel == null) {
                                    tableModel = new DynamicTableModel(resultadoPesquisa);
                                    jtablePesquisa.setModel(tableModel);
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

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        try {
            UtilFormulario.limpaFormulario(this);
            UtilFormulario.bloquearFormulario(false, this);
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

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            if (UtilFormulario.validarFormulario(formulario) <= 0) {

                Method m;
                if (modoOperacao == MODO_ALTERACAO) {
                    m = formulario.getClass().getMethod("alterar");
                } else {
                    m = formulario.getClass().getMethod("salvar");
                }
                m.invoke(formulario);
                try {
                    UtilFormulario.limpaFormulario(this);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
                jtpFormPesquisa.setEnabledAt(0, false);
                jtpFormPesquisa.setEnabledAt(1, true);
                jtpFormPesquisa.setSelectedIndex(1);
                jbNovo.setEnabled(true);
                jbSalvar.setEnabled(false);
                jbLimpar.setEnabled(false);
                jbExcluir.setEnabled(false);

                if (modoOperacao == MODO_ALTERACAO) {
                    JOptionPane.showMessageDialog(this, "Registro Alterado com Sucesso!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Registro Salvo com Sucesso!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
                refreshJComponent();
                modoOperacao = MODO_OBSERVACAO;
            } else {
                jlInformacao.setText("Os campos em vermelho contem erros, favor corrigi-los!!");
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | UtilFormularioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        try {
            UtilFormulario.limpaFormulario(this);
            UtilFormulario.bloquearFormulario(false, this);
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

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        try {
            UtilFormulario.bloquearFormulario(false, this);
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

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        try {
            Object[] options = {"Sim", "Não"};
            if (JOptionPane.showOptionDialog(null, "Deseja Excluir o registro selecionado?", "Atenção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]) == 0) {
                Method m = formulario.getClass().getMethod("excluir");
                m.invoke(formulario);

                UtilFormulario.limpaFormulario(this);
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
                modoOperacao = MODO_OBSERVACAO;
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | UtilFormularioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void onVisualizar(int keyCode) {
        objetoFormulario = ((DynamicTableModel) jtablePesquisa.getModel()).getObjectAtRow(jtablePesquisa.getSelectedRow());
        try {
            if ((keyCode == KeyEvent.VK_ENTER || keyCode == 0) && modoF1F2 != null) {
                if (modoF1F2.equals("F1")) {
                    if (jComponent instanceof JTextField) {
                        JTextField jfTextField = (JTextField) jComponent;
                        jfTextField.setObjeto(objetoFormulario);
                    } else if (jComponent instanceof JComboBox) {
                        JComboBox jfComboBox = (JComboBox) jComponent;
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
            if (objetoFormulario != null) {
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
                UtilFormulario.bloquearFormulario(true, this);
            } else {
                jtpFormPesquisa.setEnabledAt(0, false);
                jtpFormPesquisa.setEnabledAt(1, true);
                jtpFormPesquisa.setSelectedIndex(1);
                jbNovo.setEnabled(true);
                jbSalvar.setEnabled(false);
                jbLimpar.setEnabled(false);
                jbEditar.setEnabled(false);
                jbExcluir.setEnabled(false);
            }

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
                if (jComponent instanceof JTextField) {
                    JTextField jfTextField = (JTextField) jComponent;
                    jfTextField.setObjeto(objetoFormulario);
                } else if (jComponent instanceof JComboBox) {
                    JComboBox jfComboBox = (JComboBox) jComponent;
                    jfComboBox.refreshDataSet();
                    jfComboBox.setSelectedItem(objetoFormulario);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar componente", "OOOPSS!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setjComponent(JComponent jComponent) {
        this.jComponent = jComponent;
    }

    public void setModoF1F2(String modoF1F2) {
        this.modoF1F2 = modoF1F2;
        if (modoF1F2 != null && modoF1F2.equals("F1")) {
            jToolBar2.setVisible(false);
            jtpFormPesquisa.setEnabledAt(0, false);
            jtpFormPesquisa.setEnabledAt(1, true);
            jtpFormPesquisa.setSelectedIndex(1);
        } else {
            jToolBar2.setVisible(true);
            jtpFormPesquisa.setEnabledAt(0, false);
            jtpFormPesquisa.setEnabledAt(1, true);
            jtpFormPesquisa.setSelectedIndex(1);
            jbNovo.setEnabled(true);
            jbSalvar.setEnabled(false);
            jbLimpar.setEnabled(false);
            jbEditar.setEnabled(false);
            jbExcluir.setEnabled(false);
        }
    }

    private void verificaLoginPermissaPessoa() {
        LoginPermissaoPessoa loginPermissaoPessoa = JAutoPecasMenu.getLoginPermissaoPessoa(itemMenu);
        jbNovo.setPessoaComPermissao(loginPermissaoPessoa.getIncluir());
        jbEditar.setPessoaComPermissao(loginPermissaoPessoa.getAlterar());
        jbExcluir.setPessoaComPermissao(loginPermissaoPessoa.getExcluir());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar2;
    private jautopecas.components.JButton jbEditar;
    private jautopecas.components.JButton jbExcluir;
    private jautopecas.components.JButton jbLimpar;
    private jautopecas.components.JButton jbNovo;
    private jautopecas.components.JButton jbSalvar;
    private javax.swing.JLabel jlInformacao;
    private javax.swing.JPanel jpBarraInformacao;
    private javax.swing.JPanel jpConteudo;
    private javax.swing.JPanel jpFormulario;
    private javax.swing.JPanel jpPesquisa;
    private javax.swing.JTable jtablePesquisa;
    private jautopecas.components.JTextField jtfFiltroPesquisa;
    private javax.swing.JTabbedPane jtpFormPesquisa;
    // End of variables declaration//GEN-END:variables
}
