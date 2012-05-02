/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.components;

import jautopecas.components.validadores.Validador;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author JFFiorotto
 */
public class JFTextField extends JTextField {

    public JFTextField() {
        super();

        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(final KeyEvent e) {
                if (upperCase) {
                    SwingUtilities.invokeLater(new Runnable() {

                        @Override
                        public void run() {
                            JTextField campo = (JTextField) e.getSource();
                            int posicaoCursor = campo.getCaretPosition();
                            campo.setText(campo.getText().toUpperCase());
                            if (posicaoCursor != campo.getCaretPosition()) {
                                campo.setCaretPosition(posicaoCursor);
                            }
                        }
                    });
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });

        this.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jfTextFieldMouseEntered(evt);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jfTextFieldMouseExited(evt);
            }
        });
    }
    /*
     * Variaveis Privadas
     */
    private String mensagemAjuda;
    private JLabel jlInformacao;
    private boolean upperCase = true;
    private Validador validador;

    public boolean validaCampo() {
        if (validador != null) {
            return validador.validaCampo();
        } else {
            return true;
        }
    }

    public void limpaCampo() {
        setText("");
        if (validador != null) {
            validador.setValido(true);
        }
    }

    private void localizaJlInformacao(Container container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                if (component.getName() != null) {
                    if (component.getName().equals("jlInformacao")) {
                        jlInformacao = (JLabel) component;
                        break;
                    }
                }
            } else if (component instanceof Container) {
                localizaJlInformacao((Container) component);
            }
        }
    }

    private void jfTextFieldMouseEntered(java.awt.event.MouseEvent evt) {
        if (jlInformacao == null) {
            localizaJlInformacao(getTopLevelAncestor());
        }
        if (jlInformacao != null) {
            jlInformacao.setText(mensagemAjuda);
            if (validador != null) {
                if (!validador.isValido()) {
                    jlInformacao.setText(validador.getMensagemErro());
                }
            }
        }
    }

    private void jfTextFieldMouseExited(java.awt.event.MouseEvent evt) {
        if (jlInformacao == null) {
            localizaJlInformacao(getTopLevelAncestor());
        }
        if (jlInformacao != null) {
            jlInformacao.setText("");
        }
    }

    /*
     * Geter's and Seter's
     */
    public void setMensagemAjuda(String mensagemAjuda) {
        this.mensagemAjuda = mensagemAjuda;
    }

    public void setUpperCase(boolean upperCase) {
        this.upperCase = upperCase;
    }

    public void setValidador(Validador validador) {
        this.validador = validador;
    }
}
