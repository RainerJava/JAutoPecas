package jautopecas.dao.compras;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.compras.PedidoCompraItem;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class PedidoCompraItemDao extends AbstractDao<PedidoCompraItem> implements Serializable {

    public PedidoCompraItemDao() {
        super(PedidoCompraItem.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
