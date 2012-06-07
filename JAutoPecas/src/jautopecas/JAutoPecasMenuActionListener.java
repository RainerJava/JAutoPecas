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
        crud.setVisible(true);
    }
}
