package jautopecas.dao.pessoa;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.Empresa;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class EmpresaDao extends AbstractDao<Empresa> implements Serializable {

    public EmpresaDao() {
        super(Empresa.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
