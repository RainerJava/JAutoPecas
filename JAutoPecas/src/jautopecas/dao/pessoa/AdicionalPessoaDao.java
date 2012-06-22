package jautopecas.dao.pessoa;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.AdicionalPessoa;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class AdicionalPessoaDao extends AbstractDao<AdicionalPessoa> implements Serializable {

    public AdicionalPessoaDao() {
        super(AdicionalPessoa.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
