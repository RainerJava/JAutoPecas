package jautopecas.dao.pessoa.login;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.login.LoginPessoa;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author JFFiorotto
 */
public class LoginPessoaDao extends AbstractDao<LoginPessoa> implements Serializable {

    public LoginPessoaDao() {
        super(LoginPessoa.class);
    }

    public LoginPessoa efetuaLogin(String login, String senha) {
        try {
            String sql = "SELECT a FROM LoginPessoa a"
                    + " where a.login = :login"
                    + " and a.senha <= :senha";

            TypedQuery<LoginPessoa> typedQuery = getEntityManager().createQuery(sql, LoginPessoa.class);

            typedQuery.setParameter("login", login);
            typedQuery.setParameter("senha", senha);

            return typedQuery.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<LoginPessoa> listaLoginsPessoa(Integer idPessoa) {
        try {
            String sql = "SELECT a FROM LoginPessoa a"
                    + " where a.pessoa.idPessoa = :idPessoa";

            TypedQuery<LoginPessoa> typedQuery = getEntityManager().createQuery(sql, LoginPessoa.class);
            typedQuery.setParameter("idPessoa", idPessoa);

            return typedQuery.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
