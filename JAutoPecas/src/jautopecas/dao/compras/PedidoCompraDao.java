package jautopecas.dao.compras;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.compras.PedidoCompra;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class PedidoCompraDao extends AbstractDao<PedidoCompra> implements Serializable {

    public PedidoCompraDao() {
        super(PedidoCompra.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
