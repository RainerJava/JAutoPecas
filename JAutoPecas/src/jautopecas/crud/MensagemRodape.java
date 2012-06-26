package jautopecas.crud;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author JFFiorotto
 */
public class MensagemRodape extends javax.swing.JPanel {

    public MensagemRodape() {
        initComponents();

        corDefault = jlMensagem.getForeground();
        corErro = new java.awt.Color(255, 0, 51);
        iconeInformacao = new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeMensagemInformacao22.png"));
        iconeAlerta = new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeMensagemAlerta22.png"));
        iconeErro = new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeMensagemErro22.png"));
        iconeAjuda = new javax.swing.ImageIcon(getClass().getResource("/jautopecas/imagens/icones/iconeMensagemAjuda22.png"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlMensagem = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setPreferredSize(new java.awt.Dimension(100, 24));
        setLayout(new java.awt.BorderLayout());

        jlMensagem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add(jlMensagem, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlMensagem;
    // End of variables declaration//GEN-END:variables
    public static final int MENSAGEM_INFORMACAO = 0;
    public static final int MENSAGEM_ALERTA = 1;
    public static final int MENSAGEM_ERRO = 2;
    public static final int MENSAGEM_AJUDA = 3;
    private final Color corDefault;
    private final Color corErro;
    private final ImageIcon iconeInformacao;
    private final ImageIcon iconeAlerta;
    private final ImageIcon iconeErro;
    private final ImageIcon iconeAjuda;

    public void mostraMensagem(String mensagem, int tipoMensagem) {
        switch (tipoMensagem) {
            case 0:
                mostraMensagemInformacao(mensagem);
                break;
            case 1:
                mostraMensagemAlerta(mensagem);
                break;
            case 2:
                mostraMensagemErro(mensagem);
                break;
            case 3:
                mostraMensagemAjuda(mensagem);
                break;
        }
    }

    public void limpaMensagem() {
        jlMensagem.setIcon(null);
        jlMensagem.setForeground(corDefault);
        jlMensagem.setText("");
    }

    private void mostraMensagemInformacao(String mensagem) {
        jlMensagem.setIcon(iconeInformacao);
        jlMensagem.setForeground(corDefault);
        jlMensagem.setText(mensagem);
    }

    private void mostraMensagemAlerta(String mensagem) {
        jlMensagem.setIcon(iconeAlerta);
        jlMensagem.setForeground(corDefault);
        jlMensagem.setText(mensagem);
    }

    private void mostraMensagemErro(String mensagem) {
        jlMensagem.setIcon(iconeErro);
        jlMensagem.setForeground(corErro);
        jlMensagem.setText(mensagem);
    }

    private void mostraMensagemAjuda(String mensagem) {
        jlMensagem.setIcon(iconeAjuda);
        jlMensagem.setForeground(corDefault);
        jlMensagem.setText(mensagem);
    }
}
