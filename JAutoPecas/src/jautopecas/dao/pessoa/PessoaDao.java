package jautopecas.dao.pessoa;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author JFFiorotto
 */
public class PessoaDao extends AbstractDao<Pessoa> implements Serializable {

    public PessoaDao() {
        super(Pessoa.class);
    }

    public List<Pessoa> listaPessoaPorModelo(Integer modeloPessoa) throws Exception {
        String sql = "SELECT a FROM Pessoa a"
                + " where a.modeloPessoa.idModeloPessoa = :par1";
        TypedQuery<Pessoa> typedQuery = getEntityManager().createQuery(sql, Pessoa.class);
        typedQuery.setParameter("par1", modeloPessoa);
        List<Pessoa> lista = typedQuery.getResultList();
        return lista;
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
