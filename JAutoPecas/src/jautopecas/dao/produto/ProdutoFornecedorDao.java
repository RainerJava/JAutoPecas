package jautopecas.dao.produto;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.produto.ProdutoFornecedor;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class ProdutoFornecedorDao extends AbstractDao<ProdutoFornecedor> implements Serializable {

    public ProdutoFornecedorDao() {
        super(ProdutoFornecedor.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
