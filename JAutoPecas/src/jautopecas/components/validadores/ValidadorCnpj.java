/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.components.validadores;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import jautopecas.components.JFTextField;

/**
 *
 * @author JFFiorotto
 */
public class ValidadorCnpj implements Validador {

    private boolean valido = true;
    private JFTextField jfTextField;

    public ValidadorCnpj(JFTextField jfTextField) {
        this.jfTextField = jfTextField;
    }

    @Override
    public boolean validaCampo() {
        setValido(validaCnpj());
        return valido;
    }

    @Override
    public String getMensagemErro() {
        return "CNPJ Inválido.";
    }

    @Override
    public boolean isValido() {
        return valido;
    }

    @Override
    public void setValido(boolean valido) {
        this.valido = valido;
    }

    private Boolean validaCnpj() {
        CNPJValidator validator = new CNPJValidator(true);
        try {
            validator.assertValid(jfTextField.getText());
            return true;
        } catch (InvalidStateException e) {
            return false;
        }
    }
}
