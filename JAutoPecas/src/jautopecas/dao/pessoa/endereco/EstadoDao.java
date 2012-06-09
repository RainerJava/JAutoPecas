package jautopecas.dao.pessoa.endereco;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.endereco.Estado;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author JFFiorotto
 */
public class EstadoDao extends AbstractDao<Estado> implements Serializable {

    public EstadoDao() {
        super(Estado.class);
    }

    public Estado getEstadoPorSigla(String sigla) {
        List<Estado> lista;
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Estado> root = cq.from(Estado.class);
        cq.select(root);
        Predicate pSigla = cb.like(root.<String>get("uf"), sigla);
        Predicate pAnd = cb.and(pSigla);
        cq.where(pAnd);
        lista = getEntityManager().createQuery(cq).getResultList();
        if (lista.size() > 0) {
            return (Estado) lista.get(0);
        } else {
            return null;
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
