package jautopecas.components;

import jautopecas.components.validadores.Validador;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author JFFiorotto
 */
public class JPasswordField extends javax.swing.JPasswordField {

    public JPasswordField() {
        super();

        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(final KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (isEditable()) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        transferFocus();
                    }
                }
            }
        });

        this.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent evt) {
                if (getMensagemRodape() != null && isEditable()) {
                    getMensagemRodape().mostraMensagem(mensagemAjuda, MensagemRodape.MENSAGEM_AJUDA);
                    if (!campoValido) {
                        getMensagemRodape().mostraMensagem(mensagemErro, MensagemRodape.MENSAGEM_ERRO);
                    }
                }
            }

            @Override
            public void focusLost(FocusEvent evt) {
                if (getMensagemRodape() != null) {
                    getMensagemRodape().limpaMensagem();
                }
            }
        });
        bordaDefault = this.getBorder();
    }
    /*
     * Variaveis Privadas
     */
    private String mensagemAjuda;
    private MensagemRodape mensagemRodape;
    private Validador validador;
    private boolean requerido = false;
    private boolean campoValido = true;
    private Border bordaDefault;
    private Border bordaErro = BorderFactory.createLineBorder(Color.RED);
    private String mensagemErro;

    public boolean validaCampo() {
        if (requerido) {
            if (getText().length() > 0) {
                if (validador != null) {
                    campoValido = validador.validaCampo();
                    if (!validador.isValido()) {
                        mensagemErro = validador.getMensagemErro();
                    }
                }
            } else {
                campoValido = false;
                mensagemErro = "Este campo não pode ficar vazio.";
            }
        }

        if (campoValido) {
            setBorder(bordaDefault);
        } else {
            setBorder(bordaErro);
        }
        return campoValido;
    }

    public void limpaCampo() {
        mensagemErro = "";
        setText("");
        setBorder(bordaDefault);
        if (validador != null) {
            validador.setValido(true);
        }
        campoValido = true;
    }

    /*
     * Geter's and Seter's
     */
    public MensagemRodape getMensagemRodape() {
        if (mensagemRodape == null) {
            if (getTopLevelAncestor() instanceof WindowCrud) {
                mensagemRodape = ((WindowCrud) getTopLevelAncestor()).getMensagemRodape();
            }
        }
        return mensagemRodape;
    }

    public void setMensagemAjuda(String mensagemAjuda) {
        this.mensagemAjuda = mensagemAjuda;
    }

    public void setValidador(Validador validador) {
        this.validador = validador;
        this.requerido = true;
    }

    public void setRequerido(boolean requerido) {
        this.requerido = requerido;
    }
}
