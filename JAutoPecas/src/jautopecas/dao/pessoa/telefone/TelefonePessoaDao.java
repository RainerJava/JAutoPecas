package jautopecas.dao.pessoa.telefone;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.telefone.TelefonePessoa;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class TelefonePessoaDao extends AbstractDao<TelefonePessoa> implements Serializable {

    public TelefonePessoaDao() {
        super(TelefonePessoa.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
