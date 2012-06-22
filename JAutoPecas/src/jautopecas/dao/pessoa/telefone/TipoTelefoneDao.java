package jautopecas.dao.pessoa.telefone;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.telefone.TipoTelefone;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class TipoTelefoneDao extends AbstractDao<TipoTelefone> implements Serializable {

    public TipoTelefoneDao() {
        super(TipoTelefone.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
