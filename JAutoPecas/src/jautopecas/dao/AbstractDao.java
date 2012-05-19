/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Daniel
 */
public abstract class AbstractDao<T> {

    private Class<T> entityClass;
    private static EntityManagerFactory emf = null;

    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("JAutoPecasPU");
        }
        return emf;
    }

    public void salvar(T entity) {
        EntityManager em = getEntityManager();
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void alterar(T entity) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void excluir(T entity) {
        EntityManager em = getEntityManager();
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            //em.remove(entity);
            em.remove(em.contains(entity) ? entity : em.merge(entity));
            em.getTransaction().commit();

        } catch (Exception ex) {
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public T listar(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> listarTodos() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> listarTodosEmRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int contar() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public List<T> pesquisaSimples(String camposPesquisa, String strPesquisa) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("SELECT a FROM ").append(entityClass.getSimpleName()).append(" a");

        String[] v = strPesquisa.split("\\+");
        for (int i = 0; i < v.length; i++) {
            if (i == 0) {
                strBuilder.append(" WHERE CONCAT(").append(camposPesquisa).append(") LIKE :parm").append(i);
            } else {
                strBuilder.append(" AND CONCAT(").append(camposPesquisa).append(") LIKE :parm").append(i);
            }
        }

        TypedQuery<T> typedQuery = getEntityManager().createQuery(strBuilder.toString(), entityClass);

        for (int i = 0; i < v.length; i++) {
            typedQuery.setParameter(("parm" + i), "%" + v[i] + "%");
        }
        return typedQuery.getResultList();
    }
}