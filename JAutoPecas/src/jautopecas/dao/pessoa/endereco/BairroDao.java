package jautopecas.dao.pessoa.endereco;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.endereco.Bairro;
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
public class BairroDao extends AbstractDao<Bairro> implements Serializable {

    public BairroDao() {
        super(Bairro.class);
    }

    public Bairro getBairroPorNome(String nome) {
        List<Bairro> lista;
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Bairro> root = cq.from(Bairro.class);
        cq.select(root);
        Predicate pNome = cb.like(root.<String>get("nome"), nome);
        Predicate pAnd = cb.and(pNome);
        cq.where(pAnd);
        lista = getEntityManager().createQuery(cq).getResultList();
        if (lista.size() > 0) {
            return (Bairro) lista.get(0);
        } else {
            return null;
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
