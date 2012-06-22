package jautopecas.dao.pessoa.endereco;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.endereco.TipoEndereco;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class TipoEnderecoDao extends AbstractDao<TipoEndereco> implements Serializable {

    public TipoEnderecoDao() {
        super(TipoEndereco.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
