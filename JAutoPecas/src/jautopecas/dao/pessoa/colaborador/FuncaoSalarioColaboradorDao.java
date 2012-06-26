package jautopecas.dao.pessoa.colaborador;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.colaborador.FuncaoSalarioColaborador;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class FuncaoSalarioColaboradorDao extends AbstractDao<FuncaoSalarioColaborador> implements Serializable {

    public FuncaoSalarioColaboradorDao() {
        super(FuncaoSalarioColaborador.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
