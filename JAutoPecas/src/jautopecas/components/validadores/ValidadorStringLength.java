package jautopecas.components.validadores;

import jautopecas.components.JTextField;

/**
 *
 * @author JFFiorotto
 */
public class ValidadorStringLength implements Validador {

    private boolean valido = true;
    private JTextField jfTextField;
    private int lengthMinimo;
    private int lengthMaximo;

    public ValidadorStringLength(JTextField jfTextField, int lengthMinimo, int lengthMaximo) {
        this.jfTextField = jfTextField;
        this.lengthMinimo = lengthMinimo;
        this.lengthMaximo = lengthMaximo;
    }

    @Override
    public boolean validaCampo() {
        setValido(validaLengthMinimoMaximo());
        return valido;
    }

    @Override
    public String getMensagemErro() {
        if (lengthMinimo == lengthMaximo) {
            if (jfTextField.getText().length() < lengthMinimo) {
                return "O campo deve ter no minimo " + lengthMinimo + " caracteres.";
            } else {
                return "O campo deve ter no maximo " + lengthMinimo + " caracteres.";
            }
        } else if (lengthMinimo > -1 && lengthMaximo >= 999) {
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
    }

    public boolean validaLengthMinimoMaximo() {
        if (jfTextField.getText().length() < lengthMinimo || jfTextField.getText().length() > lengthMaximo) {
            return false;
        } else {
            return true;
        }
    }
}
