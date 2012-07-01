package jautopecas.dao.produto;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.produto.Grupo;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
public class GrupoDao extends AbstractDao<Grupo> implements Serializable {

    public GrupoDao() {
        super(Grupo.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
