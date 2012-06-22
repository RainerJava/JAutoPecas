package jautopecas.dao.pessoa.telefone;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.telefone.Telefone;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class TelefoneDao extends AbstractDao<Telefone> implements Serializable {

    public TelefoneDao() {
        super(Telefone.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
