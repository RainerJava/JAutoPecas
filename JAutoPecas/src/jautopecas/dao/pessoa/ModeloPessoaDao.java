package jautopecas.dao.pessoa;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.ModeloPessoa;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class ModeloPessoaDao extends AbstractDao<ModeloPessoa> implements Serializable {

    public ModeloPessoaDao() {
        super(ModeloPessoa.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
