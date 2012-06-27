package jautopecas.dao.pessoa.colaborador;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.colaborador.Funcao;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class FuncaoDao extends AbstractDao<Funcao> implements Serializable {

    public FuncaoDao() {
        super(Funcao.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
