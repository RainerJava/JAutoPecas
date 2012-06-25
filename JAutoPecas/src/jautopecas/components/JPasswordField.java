package jautopecas.components;

import jautopecas.components.validadores.Validador;
import jautopecas.crud.WindowCrud;
import jautopecas.entidades.menu.ItemMenu;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
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
                if (jlInformacao == null) {
                    jlInformacao = getJlInformacao();
                }
                if (jlInformacao != null && isEditable()) {
                    jlInformacao.setText(mensagemAjuda);
                    if (validador != null) {
                        if (!validador.isValido()) {
                            jlInformacao.setText(validador.getMensagemErro());
                        }
                    }
                }
            }

            @Override
            public void focusLost(FocusEvent evt) {
                if (jlInformacao == null) {
                    jlInformacao = getJlInformacao();
                }
                if (jlInformacao != null) {
                    jlInformacao.setText("");
                }
            }
        });
        bordaDefault = this.getBorder();
        colorDefault = this.getBackground();
    }
    /*
     * Variaveis Privadas
     */
    private String mensagemAjuda;
    private JLabel jlInformacao;
    private Validador validador;
    private ItemMenu itemMenu;
    private Border bordaDefault;
    private Color colorDefault;
    private Border bordaErro = BorderFactory.createLineBorder(Color.RED);

    public boolean validaCampo() {
        boolean result = true;
        if (validador != null) {
            result = validador.validaCampo();
        }
        if (result) {
            setBorder(bordaDefault);
        } else {
            setBorder(bordaErro);
        }
        return result;
    }

    public void limpaCampo() {
        setText("");
        setBorder(bordaDefault);
        if (validador != null) {
            validador.setValido(true);
        }
    }

    private JLabel getJlInformacao() {
        return ((WindowCrud) getTopLevelAncestor()).getJlInformacao();
    }
    /*
     * Geter's and Seter's
     */

    public void setMensagemAjuda(String mensagemAjuda) {
        this.mensagemAjuda = mensagemAjuda;
    }

    public void setValidador(Validador validador) {
        this.validador = validador;
    }
}
