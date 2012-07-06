package jautopecas.dao.produto;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.produto.ClassificacaoFiscal;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class ClassificacaoFiscalDao extends AbstractDao<ClassificacaoFiscal> implements Serializable {

    public ClassificacaoFiscalDao() {
        super(ClassificacaoFiscal.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
