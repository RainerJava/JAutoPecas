package jautopecas.components;

/**
 *
 * @author JFFiorotto
 */
public class JButton extends javax.swing.JButton {
    
    private boolean pessoaComPermissao = true;
    
    @Override
    public void setEnabled(boolean b) {
        if (!pessoaComPermissao) {
            super.setEnabled(false);
        } else {
            super.setEnabled(b);
        }
    }

    public boolean isPessoaComPermissao() {
        return pessoaComPermissao;
    }

    public void setPessoaComPermissao(boolean pessoaComPermissao) {
        this.pessoaComPermissao = pessoaComPermissao;
    }   
}
