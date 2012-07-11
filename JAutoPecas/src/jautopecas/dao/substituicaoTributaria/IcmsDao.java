package jautopecas.dao.substituicaoTributaria;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.substituicaoTributaria.Icms;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author JFFiorotto
 */
public class IcmsDao extends AbstractDao<Icms> implements Serializable {

    public IcmsDao() {
        super(Icms.class);
    }

    public BigDecimal getPercentIcmsEmissor(String ufEmissor, String uf) {
        String sql = "SELECT a FROM Icms a"
                + " where a.uf.uf = :uf"
                + " and a.ufEmissor.uf = :ufEmissor";
        TypedQuery<Icms> typedQuery = getEntityManager().createQuery(sql, Icms.class);
        typedQuery.setParameter("uf", uf);
        typedQuery.setParameter("ufEmissor", ufEmissor);
        Icms icms = typedQuery.getSingleResult();
        if (icms != null) {
            switch (icms.getTaxaVigente()) {
                case 1:
                    return icms.getPercentIcms1();
                case 2:
                    return icms.getPercentIcms2();
                case 3:
                    return icms.getPercentIcms3();
                case 4:
                    return icms.getPercentIcms4();
                case 5:
                    return icms.getPercentIcms5();
                case 6:
                    return icms.getPercentIcms6();
            }
        } else {
            return BigDecimal.ZERO;
        }
        return BigDecimal.ZERO;
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
