package jautopecas;

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
        JAutoPecasMenu.addJanela(itemMenu);
    }
}
