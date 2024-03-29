package jautopecas.components.validadores;

/**
 *
 * @author JFFiorotto
 */
public interface Validador {

    abstract void setValido(boolean erro);

    abstract boolean isValido();

    abstract String getMensagemErro();

    abstract boolean validaCampo();
}
