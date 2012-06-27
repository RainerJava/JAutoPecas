package jautopecas.components.validadores;

import jautopecas.components.JTextField;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author JFFiorotto
 */
public class ValidadorData implements Validador {

    private boolean valido = true;
    private JTextField jfTextField;
    SimpleDateFormat sdf;

    public ValidadorData(JTextField jfTextField) {
        this.jfTextField = jfTextField;
        sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Override
    public boolean validaCampo() {
        setValido(validaData());
        return valido;
    }

    @Override
    public String getMensagemErro() {
        return "Data Inválida.";
    }

    @Override
    public boolean isValido() {
        return valido;
    }

    @Override
    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public boolean validaData() {
        sdf.setLenient(false);
        try {
            sdf.parse(jfTextField.getText());
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
}
