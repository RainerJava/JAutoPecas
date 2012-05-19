/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.crud;

import jautopecas.components.DynamicTableModel;
import jautopecas.components.JFTextField;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

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
    private int countErrosFormulario;

    /**
     * Creates new form WindowCrud
     */
    public WindowCrud() {
        initComponents();
    }

    public WindowCrud(Object objetoFormulario, String metodoPesquisa, JPanel formulario) {
        initComponents();
        this.objetoFormulario = objetoFormulario;
        this.metodoPesquisa = metodoPesquisa;
        this.formulario = formulario;
        jpFormulario.add(this.formulario);
        this.pack();

        jtpFormPesquisa.setEnabledAt(0, false);
        jtpFormPesquisa.setEnabledAt(1, true);
        jtpFormPesquisa.setSelectedIndex(1);
        jbNovo.setEnabled(true);
        jbSalvar.setEnabled(false);
        jbLimpar.setEnabled(false);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);
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
            Logger.getLogger(WindowCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void bloquearFormulario(Boolean bloqueia, Container container) {
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

        jpMenuSuperior = new javax.swing.JPanel();
        jbNovo = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
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
        jbBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jpMenuSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpMenuSuperior.setPreferredSize(new java.awt.Dimension(754, 40));
        jpMenuSuperior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 1));

        jbNovo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeNovo24.png"))); // NOI18N
        jbNovo.setMnemonic(KeyEvent.VK_N);
        jbNovo.setText("Novo");
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
        jpMenuSuperior.add(jbNovo);

        jbSalvar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeConfirmar24.png"))); // NOI18N
        jbSalvar.setMnemonic(KeyEvent.VK_S);
        jbSalvar.setText("Salvar");
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
        jpMenuSuperior.add(jbSalvar);

        jbLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeLimpar24.png"))); // NOI18N
        jbLimpar.setMnemonic(KeyEvent.VK_L);
        jbLimpar.setText("Limpar");
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
        jpMenuSuperior.add(jbLimpar);

        jbEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeEditar24.png"))); // NOI18N
        jbEditar.setMnemonic(KeyEvent.VK_E);
        jbEditar.setText("Editar");
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
        jpMenuSuperior.add(jbEditar);

        jbExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeDeletar24.png"))); // NOI18N
        jbExcluir.setMnemonic(KeyEvent.VK_X);
        jbExcluir.setText("Excluir");
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
        jpMenuSuperior.add(jbExcluir);

        getContentPane().add(jpMenuSuperior, java.awt.BorderLayout.PAGE_START);

        jpBarraInformacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpBarraInformacao.setPreferredSize(new java.awt.Dimension(754, 25));
        jpBarraInformacao.setLayout(new java.awt.BorderLayout());

        jlInformacao.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jlInformacao.setName("jlInformacao");
        jpBarraInformacao.add(jlInformacao, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpBarraInformacao, java.awt.BorderLayout.PAGE_END);

        jpConteudo.setLayout(new java.awt.BorderLayout());

        jpFormulario.setLayout(new java.awt.BorderLayout());
        jtpFormPesquisa.addTab("Formulário", jpFormulario);

        jpPesquisa.setLayout(new java.awt.BorderLayout());

        jtablePesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtablePesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtablePesquisaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtablePesquisa);

        jpPesquisa.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));
        jPanel1.setPreferredSize(new java.awt.Dimension(832, 50));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jtfFiltroPesquisa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtfFiltroPesquisa.setMensagemAjuda("Digite oque deseja buscar. EX:. CARRO + BRANCO o resultado sera de carros na cor branca");
        jtfFiltroPesquisa.setPreferredSize(new java.awt.Dimension(250, 25));
        jPanel1.add(jtfFiltroPesquisa);

        jbBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeBuscar24.png"))); // NOI18N
        jbBuscar.setText("Pesquisar");
        jbBuscar.setPreferredSize(new java.awt.Dimension(120, 28));
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jbBuscar);

        jpPesquisa.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jtpFormPesquisa.addTab("Pesquisa", jpPesquisa);

        jpConteudo.add(jtpFormPesquisa, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpConteudo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                JOptionPane.showMessageDialog(this, ex.getCause().getMessage());
            }
        } else {
            jlInformacao.setText("Os campos em vermelho contem erros, favor corrigi-los!!");
        }

    }//GEN-LAST:event_jbSalvarActionPerformed

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

        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            jlInformacao.setText("Erro ao salvar/altrerar o registro!!");
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbNovoMouseEntered
        jlInformacao.setText("Clique para criar um NOVO registro.");
    }//GEN-LAST:event_jbNovoMouseEntered

    private void jbSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalvarMouseEntered
        jlInformacao.setText("Clique para SALVAR um registro novo ou alterado.");
    }//GEN-LAST:event_jbSalvarMouseEntered

    private void jbLimparMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLimparMouseEntered
        jlInformacao.setText("Clique para ABORTAR uma inclusão ou alteração de registro.");
    }//GEN-LAST:event_jbLimparMouseEntered

    private void jbExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbExcluirMouseEntered
        jlInformacao.setText("Clique para DELETAR um registro selecionado.");
    }//GEN-LAST:event_jbExcluirMouseEntered

    private void jbNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbNovoMouseExited
        jlInformacao.setText("");
    }//GEN-LAST:event_jbNovoMouseExited

    private void jbSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalvarMouseExited
        jlInformacao.setText("");
    }//GEN-LAST:event_jbSalvarMouseExited

    private void jbLimparMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLimparMouseExited
        jlInformacao.setText("");
    }//GEN-LAST:event_jbLimparMouseExited

    private void jbExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbExcluirMouseExited
        jlInformacao.setText("");
    }//GEN-LAST:event_jbExcluirMouseExited

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        try {
            if (resultadoPesquisa == null) {
                resultadoPesquisa = new ArrayList<>();


            }
            Method m = formulario.getClass().getMethod(metodoPesquisa, new Class[]{String.class
                    });
            resultadoPesquisa.clear();

            resultadoPesquisa.addAll(
                    (List) m.invoke(formulario, new Object[]{jtfFiltroPesquisa.getText()}));
            if (tableModel == null) {
                tableModel = new DynamicTableModel(resultadoPesquisa);
                jtablePesquisa.setModel(tableModel);
            }
            tableModel.setData(resultadoPesquisa);

        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException ex) {
            ex.printStackTrace();
            jlInformacao.setText("Erro ao pesquisar!!");
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jtablePesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtablePesquisaMouseClicked
        if (evt.getClickCount() == 2) {
            try {
                objetoFormulario = ((DynamicTableModel) jtablePesquisa.getModel()).getObjectAtRow(jtablePesquisa.getSelectedRow());
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

            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(WindowCrud.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jtablePesquisaMouseClicked

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

    public JLabel getJlInformacao() {
        return jlInformacao;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JLabel jlInformacao;
    private javax.swing.JPanel jpBarraInformacao;
    private javax.swing.JPanel jpConteudo;
    private javax.swing.JPanel jpFormulario;
    private javax.swing.JPanel jpMenuSuperior;
    private javax.swing.JPanel jpPesquisa;
    private javax.swing.JTable jtablePesquisa;
    private jautopecas.components.JFTextField jtfFiltroPesquisa;
    private javax.swing.JTabbedPane jtpFormPesquisa;
    // End of variables declaration//GEN-END:variables
}
