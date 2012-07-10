package jautopecas.dao.substituicaoTributaria;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.substituicaoTributaria.SubstituicaoTributariaEntrada;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author JFFiorotto
 */
public class SubstituicaoTributariaEntradaDao extends AbstractDao<SubstituicaoTributariaEntrada> implements Serializable {

    public SubstituicaoTributariaEntradaDao() {
        super(SubstituicaoTributariaEntrada.class);
    }

    public SubstituicaoTributariaEntrada getSubstituicaoTributariaEntrada(String classificacaoFiscal, String ufEmissor, String tipoPessoa, String uf, String cstIcms) throws Exception {
        String sql = "SELECT a FROM SubstituicaoTributariaEntrada a"
                + " where a.classificacaoFiscal.classificacaoFiscal = :classificacaoFiscal"
                + " and a.ufEmissor.uf = :ufEmissor"
                + " and a.tipoPessoa = :tipoPessoa"
                + " and a.uf.uf = :uf"
                + " and a.cstIcms = :cstIcms";
        TypedQuery<SubstituicaoTributariaEntrada> typedQuery = getEntityManager().createQuery(sql, SubstituicaoTributariaEntrada.class);
        typedQuery.setParameter("classificacaoFiscal", classificacaoFiscal);
        typedQuery.setParameter("ufEmissor", ufEmissor);
        typedQuery.setParameter("tipoPessoa", tipoPessoa);
        typedQuery.setParameter("uf", uf);
        typedQuery.setParameter("cstIcms", cstIcms);
        return typedQuery.getSingleResult();
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
