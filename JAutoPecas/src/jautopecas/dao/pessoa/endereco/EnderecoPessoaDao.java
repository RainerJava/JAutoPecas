package jautopecas.dao.pessoa.endereco;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.endereco.EnderecoPessoa;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class EnderecoPessoaDao extends AbstractDao<EnderecoPessoa> implements Serializable {

    public EnderecoPessoaDao() {
        super(EnderecoPessoa.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
