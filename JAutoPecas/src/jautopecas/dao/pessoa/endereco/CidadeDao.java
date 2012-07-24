package jautopecas.dao.pessoa.endereco;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.endereco.Cidade;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author JFFiorotto
 */
public class CidadeDao extends AbstractDao<Cidade> implements Serializable {

    public CidadeDao() {
        super(Cidade.class);
    }

    public Cidade getCidadePorNome(String nome, String uf) throws Exception {
        String sql = "SELECT a FROM Cidade a"
                + " where a.nome = :nome"
                + " and a.uf.uf = :uf ";
        TypedQuery<Cidade> typedQuery = getEntityManager().createQuery(sql, Cidade.class);
        typedQuery.setParameter("nome", nome);
        typedQuery.setParameter("uf", uf);
        return typedQuery.getSingleResult();
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
