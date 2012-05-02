/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.components.validadores;

import jautopecas.components.JFTextField;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author JFFiorotto
 */
public class ValidadorStringLength implements Validador {

    private boolean valido = true;
    private JFTextField jfTextField;
    private Border bordaDefault;
    private Border bordaErro = BorderFactory.createLineBorder(Color.RED);
    private int lengthMinimo;
    private int lengthMaximo;

    public ValidadorStringLength(JFTextField jfTextField, int lengthMinimo, int lengthMaximo) {
        this.jfTextField = jfTextField;
        this.lengthMinimo = lengthMinimo;
        this.lengthMaximo = lengthMaximo;
        bordaDefault = jfTextField.getBorder();
    }

    @Override
    public boolean validaCampo() {
        setValido(validaLengthMinimoMaximo());
        return valido;
    }

    @Override
    public String getMensagemErro() {
        if (lengthMinimo > -1 && lengthMaximo >= 999) {
            return "O campo deve ter no minimo " + lengthMinimo + " caracteres.";
        } else if (lengthMinimo > -1 && lengthMaximo < 999) {
            return "O campo deve conter entra " + lengthMinimo + " e " + lengthMaximo + " caracteres.";
        } else {
            return "O campo deve ter no maximo " + lengthMaximo + " caracteres.";
        }
    }

    @Override
    public boolean isValido() {
        return valido;
    }

    @Override
    public void setValido(boolean valido) {
        this.valido = valido;
        if (valido) {
            jfTextField.setBorder(bordaDefault);
        } else {
            jfTextField.setBorder(bordaErro);
        }
    }

    public boolean validaLengthMinimoMaximo() {
        if (jfTextField.getText().length() < lengthMinimo || jfTextField.getText().length() > lengthMaximo) {
            return false;
        } else {
            return true;
        }
    }
}
