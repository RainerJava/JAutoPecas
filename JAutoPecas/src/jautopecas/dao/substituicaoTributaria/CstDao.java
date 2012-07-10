package jautopecas.dao.substituicaoTributaria;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.substituicaoTributaria.Cst;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author JFFiorotto
 */
public class CstDao extends AbstractDao<Cst> implements Serializable {

    public CstDao() {
        super(Cst.class);
    }

    public List<Cst> listarCstIcms() throws Exception {
        String sql = "SELECT a FROM Cst a"
                + " where a.tipoCst = 'ICMS'";
        TypedQuery<Cst> typedQuery = getEntityManager().createQuery(sql, Cst.class);
        return typedQuery.getResultList();
    }

    public List<Cst> listarCstIpi() throws Exception {
        String sql = "SELECT a FROM Cst a"
                + " where a.tipoCst = 'IPI'";
        TypedQuery<Cst> typedQuery = getEntityManager().createQuery(sql, Cst.class);
        return typedQuery.getResultList();
    }

    public List<Cst> listarCstPis() throws Exception {
        String sql = "SELECT a FROM Cst a"
                + " where a.tipoCst = 'PIS'";
        TypedQuery<Cst> typedQuery = getEntityManager().createQuery(sql, Cst.class);
        return typedQuery.getResultList();
    }

    public List<Cst> listarCstCofins() throws Exception {
        String sql = "SELECT a FROM Cst a"
                + " where a.tipoCst = 'COFINS'";
        TypedQuery<Cst> typedQuery = getEntityManager().createQuery(sql, Cst.class);
        return typedQuery.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
