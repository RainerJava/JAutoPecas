package jautopecas.dao.pessoa;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.Pessoa;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class PessoaDao extends AbstractDao<Pessoa> implements Serializable {
    
    public PessoaDao() {
        super(Pessoa.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
