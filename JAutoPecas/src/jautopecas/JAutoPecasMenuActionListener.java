package jautopecas;

import jautopecas.crud.WindowCrud;
import jautopecas.entidades.menu.ItemMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JAutoPecasMenuActionListener implements ActionListener {

    private ItemMenu itemMenu;

    public JAutoPecasMenuActionListener(ItemMenu itemMenu) {
        this.itemMenu = itemMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WindowCrud crud = new WindowCrud(itemMenu, null, null);
//        if (itemMenu.getCaminhoImagem() != null) {
//            crud.setIconImage(new ImageIcon(getClass().getResource(itemMenu.getCaminhoImagem())).getImage());
//        }
//        crud.setTitle(itemMenu.getNome());
//        crud.setLocationRelativeTo(null);
        crud.setVisible(true);
    }
}
