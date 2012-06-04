/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.components;

import jautopecas.JAutoPecasMenu;
import jautopecas.components.validadores.Validador;
import jautopecas.crud.WindowCrud;
import jautopecas.entidades.menu.ItemMenu;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Field;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

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
                if (isEditable()) {
                    if (classeFormulario != null && e.getKeyCode() == KeyEvent.VK_F1) {
                        JFTextField jfTextField = ((JFTextField) e.getComponent());
                        WindowCrud crud = new WindowCrud(itemMenu, "F1", jfTextField);
                        crud.setVisible(true);
                        crud.setPesquisa(jfTextField.getText());
                    } else if (classeFormulario != null && e.getKeyCode() == KeyEvent.VK_F2) {
                        WindowCrud crud = new WindowCrud(itemMenu, "F2", ((JFTextField) e.getComponent()));
                        if (objeto != null) {
                            crud.setObjetoFormulario(objeto);
                        }
                        crud.setVisible(true);
                    } else if (classeFormulario != null && (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE)) {
                        if (objeto != null) {
                            objeto = null;
                            setText("");
                        }
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
                if (jlInformacao != null) {
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

        /*
         * ENTER funcionar como TAB para pular de campo
         */
//        HashSet conj = new HashSet(this.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
//        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
//        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
        bordaDefault = this.getBorder();
    }
    /*
     * Variaveis Privadas
     */
    private String mensagemAjuda;
    private JLabel jlInformacao;
    private boolean upperCase = true;
    private Validador validador;
    private Object objeto;
    private String classeFormulario;
    private ItemMenu itemMenu;
    private boolean requerido = false;
    private Border bordaDefault;
    private Border bordaErro = BorderFactory.createLineBorder(Color.RED);

    public boolean validaCampo() {
        boolean result = true;
        if (validador != null) {
            result = validador.validaCampo();
        } else if (classeFormulario != null) {
            if (objeto == null) {
                result = false;
            }
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
        objeto = null;
        if (validador != null) {
            validador.setValido(true);
        }
    }

    private JLabel getJlInformacao() {
        return ((WindowCrud) getTopLevelAncestor()).getJlInformacao();
    }

    private String getFieldValue() throws Exception {
        String str = "";
        try {
            if (itemMenu.getCamposJFTextField() == null) {
                throw new Exception("Informe um valor para campos_jftextfield");
            }
            if (objeto == null) {
                return "";
            }
            String[] campos = itemMenu.getCamposJFTextField().split("\\,");
            for (int i = 0; i < campos.length; i++) {
                Field field = objeto.getClass().getDeclaredField(campos[i]);
                field.setAccessible(true);
                if (i == 0) {
                    str += field.get(objeto).toString();
                } else {
                    str += " - " + field.get(objeto).toString();
                }
            }
        } catch (IllegalArgumentException | NoSuchFieldException | IllegalAccessException e) {
            throw e;
        }
        return str;
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

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) throws Exception {
        this.objeto = objeto;
        if (objeto != null) {
            this.setText(getFieldValue());
        } else {
            this.setText("");
        }
    }

    public void setClasseFormulario(String classeFormulario) {
        if (classeFormulario != null && classeFormulario.length() > 0) {
            this.classeFormulario = classeFormulario;
            this.itemMenu = JAutoPecasMenu.getItemMenu(classeFormulario);
            this.setBackground(Color.LIGHT_GRAY);
        }
    }

    public void setRequerido(boolean requerido) {
        this.requerido = requerido;
    }
}
