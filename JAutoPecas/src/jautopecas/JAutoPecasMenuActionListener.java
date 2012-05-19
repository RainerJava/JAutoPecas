package jautopecas;

import jautopecas.crud.WindowCrud;
import jautopecas.entidades.CadItemMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JAutoPecasMenuActionListener implements ActionListener {

    private CadItemMenu cadItemMenu;

    public JAutoPecasMenuActionListener(CadItemMenu cadItemMenu) {
        this.cadItemMenu = cadItemMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Class classeFormulario = Class.forName(cadItemMenu.getClasseFormulario());
            Class classePesquisa = Class.forName(cadItemMenu.getClassePesquisa());
            Object objetoFormulario = classePesquisa.newInstance();
            WindowCrud crud = new WindowCrud(objetoFormulario, "pesquisaSimples", ((JPanel) classeFormulario.newInstance()));
            if (cadItemMenu.getImagem() != null) {
                crud.setIconImage(new ImageIcon(getClass().getResource(cadItemMenu.getImagem())).getImage());
            }
            crud.setTitle(cadItemMenu.getNomeItem());
            crud.setLocationRelativeTo(null);
            crud.setVisible(true);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
}
