/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.components;

import jautopecas.JAutoPecasMenu;
import jautopecas.components.validadores.Validador;
import jautopecas.crud.WindowCrud;
import jautopecas.entidades.menu.ItemMenu;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Field;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

/**
 *
 * @author JFFiorotto
 */
public class JFFormattedTextField extends JFormattedTextField {

    public JFFormattedTextField() {
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
                if (classeFormulario != null && e.getKeyCode() == KeyEvent.VK_F1) {
                    JFFormattedTextField jfTextField = ((JFFormattedTextField) e.getComponent());
                    WindowCrud crud = new WindowCrud(itemMenu, true, jfTextField);
                    crud.setVisible(true);
                    crud.setPesquisa(jfTextField.getText());
                } else if (classeFormulario != null && e.getKeyCode() == KeyEvent.VK_F2) {
                    WindowCrud crud = new WindowCrud(itemMenu, false, ((JFFormattedTextField) e.getComponent()));
                    crud.setVisible(true);
                }
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
    private Validador validador;
    private Object objeto;
    private String classeFormulario;
    private ItemMenu itemMenu;

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

    private JLabel getJlInformacao() {
        return ((WindowCrud) getTopLevelAncestor()).getJlInformacao();
    }

    private void jfTextFieldMouseEntered(java.awt.event.MouseEvent evt) {
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

    private void jfTextFieldMouseExited(java.awt.event.MouseEvent evt) {
        if (jlInformacao == null) {
            jlInformacao = getJlInformacao();
        }
        if (jlInformacao != null) {
            jlInformacao.setText("");
        }
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

    public void setValidador(Validador validador) {
        this.validador = validador;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) throws Exception {
        this.objeto = objeto;
        this.setText(getFieldValue());
    }

    public void setClasseFormulario(String classeFormulario) {
        this.classeFormulario = classeFormulario;
        this.itemMenu = JAutoPecasMenu.getItemMenu(classeFormulario);
    }
}
