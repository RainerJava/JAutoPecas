package jautopecas.dao.produto;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.produto.TipoProduto;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class TipoProdutoDao extends AbstractDao<TipoProduto> implements Serializable {

    public TipoProdutoDao() {
        super(TipoProduto.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
