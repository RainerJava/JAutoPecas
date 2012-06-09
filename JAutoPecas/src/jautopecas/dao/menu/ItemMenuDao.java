package jautopecas.dao.menu;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.menu.ItemMenu;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class ItemMenuDao extends AbstractDao<ItemMenu> implements Serializable {

    public ItemMenuDao() {
        super(ItemMenu.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
