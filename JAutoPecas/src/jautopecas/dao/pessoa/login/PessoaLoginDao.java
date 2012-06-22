package jautopecas.dao.pessoa.login;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.login.PessoaLogin;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author JFFiorotto
 */
public class PessoaLoginDao extends AbstractDao<PessoaLogin> implements Serializable {

    public PessoaLoginDao() {
        super(PessoaLogin.class);
    }

    public PessoaLogin efetuaLogin(String usuario, String senha) {
        try {
            String sql = "SELECT a FROM PessoaLogin a"
                    + " where a.usuario = :usuario"
                    + " and a.senha <= :senha";

            TypedQuery<PessoaLogin> typedQuery = getEntityManager().createQuery(sql, PessoaLogin.class);

            typedQuery.setParameter("usuario", usuario);
            typedQuery.setParameter("senha", senha);

            return typedQuery.getSingleResult();
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
