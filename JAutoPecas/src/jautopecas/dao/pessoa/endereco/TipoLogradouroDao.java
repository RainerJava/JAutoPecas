package jautopecas.dao.pessoa.endereco;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.endereco.TipoLogradouro;
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
public class TipoLogradouroDao extends AbstractDao<TipoLogradouro> implements Serializable {

    public TipoLogradouroDao() {
        super(TipoLogradouro.class);
    }

    public TipoLogradouro getTipoLogradouroPorNome(String nome) {
        List<TipoLogradouro> lista;
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<TipoLogradouro> root = cq.from(TipoLogradouro.class);
        cq.select(root);
        Predicate pNome = cb.like(root.<String>get("nome"), nome);
        Predicate pAnd = cb.and(pNome);
        cq.where(pAnd);
        lista = getEntityManager().createQuery(cq).getResultList();
        if (lista.size() > 0) {
            return (TipoLogradouro) lista.get(0);
        } else {
            return null;
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
