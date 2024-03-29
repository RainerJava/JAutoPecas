package jautopecas.components.validadores;

import jautopecas.components.JTextField;

/**
 *
 * @author JFFiorotto
 */
public class ValidadorCPF implements Validador {

    private boolean valido = true;
    private JTextField jfTextField;

    public ValidadorCPF(JTextField jfTextField) {
        this.jfTextField = jfTextField;
    }

    @Override
    public boolean validaCampo() {
        setValido(validaCPF());
        return valido;
    }

    @Override
    public String getMensagemErro() {
        return "CPF Inválido.";
    }

    @Override
    public boolean isValido() {
        return valido;
    }

    @Override
    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public boolean validaCPF() {
        if (jfTextField.getText().length() < 11) {
            return false;
        }
        int d1, d2;
        int digito1, digito2, resto;
        int digitoCPF;
        String nDigResult;

        d1 = d2 = 0;
        digito1 = digito2 = resto = 0;

        for (int nCount = 1; nCount < jfTextField.getText().length() - 1; nCount++) {
            digitoCPF = Integer.valueOf(jfTextField.getText().substring(nCount - 1, nCount)).intValue();
            d1 = d1 + (11 - nCount) * digitoCPF;
            d2 = d2 + (12 - nCount) * digitoCPF;
        };
        resto = (d1 % 11);
        if (resto < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }

        d2 += 2 * digito1;
        resto = (d2 % 11);
        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }
        String nDigVerific = jfTextField.getText().substring(jfTextField.getText().length() - 2, jfTextField.getText().length());
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
        return nDigVerific.equals(nDigResult);
    }
}
