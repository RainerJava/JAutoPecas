/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.dao.pessoa.endereco;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.endereco.Cidade;
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
public class CidadeDao extends AbstractDao<Cidade> implements Serializable {

    public CidadeDao() {
        super(Cidade.class);
    }

    public Cidade getCidadePorNome(String nome) {
        List<Cidade> lista;
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Cidade> root = cq.from(Cidade.class);
        cq.select(root);
        Predicate pNome = cb.like(root.<String>get("nome"), nome);
        Predicate pAnd = cb.and(pNome);
        cq.where(pAnd);
        lista = getEntityManager().createQuery(cq).getResultList();
        if (lista.size() > 0) {
            return (Cidade) lista.get(0);
        } else {
            return null;
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
