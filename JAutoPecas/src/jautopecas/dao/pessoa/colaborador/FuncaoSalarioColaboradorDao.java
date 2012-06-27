package jautopecas.dao.pessoa.colaborador;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.colaborador.FuncaoSalarioColaborador;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author JFFiorotto
 */
public class FuncaoSalarioColaboradorDao extends AbstractDao<FuncaoSalarioColaborador> implements Serializable {

    public FuncaoSalarioColaboradorDao() {
        super(FuncaoSalarioColaborador.class);
    }

    public FuncaoSalarioColaborador getFuncaoSalarioColaboradorAtual(Integer idPessoa) {
        String hql = "SELECT a FROM FuncaoSalarioColaborador a "
                + "WHERE a.pessoa.idPessoa = :idPessoa AND a.dataFim is null";
        TypedQuery<FuncaoSalarioColaborador> typedQuery = getEntityManager().createQuery(hql, FuncaoSalarioColaborador.class);
        typedQuery.setParameter("idPessoa", idPessoa);
        return typedQuery.getSingleResult();
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
