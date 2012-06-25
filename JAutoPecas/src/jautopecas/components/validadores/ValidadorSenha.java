package jautopecas.components.validadores;

import jautopecas.components.JPasswordField;

/**
 *
 * @author JFFiorotto
 */
public class ValidadorSenha implements Validador {

    private boolean valido = true;
    private JPasswordField jpfSenha;
    private JPasswordField jpfConfirmaSenha;

    public ValidadorSenha(JPasswordField jpfSenha, JPasswordField jpfConfirmaSenha) {
        this.jpfSenha = jpfSenha;
        this.jpfConfirmaSenha = jpfConfirmaSenha;
    }

    @Override
    public boolean validaCampo() {
        setValido(validaSenha());
        return valido;
    }

    @Override
    public String getMensagemErro() {
        return "Senha Inválida";
    }

    @Override
    public boolean isValido() {
        return valido;
    }

    @Override
    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public boolean validaSenha() {
        if(jpfSenha.getText().length() <=0){
            return false;
        }
        return jpfConfirmaSenha.getText().equals(jpfSenha.getText());
    }
}
