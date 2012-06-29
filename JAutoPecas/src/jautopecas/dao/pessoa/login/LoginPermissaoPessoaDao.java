package jautopecas.dao.pessoa.login;

import jautopecas.dao.AbstractDao;
import jautopecas.dao.menu.ItemMenuDao;
import jautopecas.entidades.pessoa.login.LoginPermissaoPessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author JFFiorotto
 */
public class LoginPermissaoPessoaDao extends AbstractDao<LoginPermissaoPessoa> implements Serializable {

    public LoginPermissaoPessoaDao() {
        super(LoginPermissaoPessoa.class);
    }

    public List<LoginPermissaoPessoa> listaLoginPermissaoPessoa(Integer idPessoaLogin) {
        List<LoginPermissaoPessoa> listaLoginPermissaoPessoa = new ArrayList<>();
        Query query = getEntityManager().createNativeQuery("SELECT b.id_login_permissao_pessoa,a.id_item_menu,b.visualizar,b.incluir,b.alterar,b.excluir "
                + "FROM cad_item_menu a LEFT OUTER JOIN cad_login_permissao_pessoa b ON (a.id_item_menu=b.id_item_menu and b.id_login_pessoa = " + idPessoaLogin + ") order by a.id_item_menu");
        List<Object[]> list = query.getResultList();
        for (int i = 0; i < list.size(); i++) {
            LoginPermissaoPessoa loginPermissaoPessoa = new LoginPermissaoPessoa();
            loginPermissaoPessoa.setIdLoginPermissaoPessoa(((Integer) list.get(i)[0]));
            loginPermissaoPessoa.setIdItemMenu(((String) list.get(i)[1]));
            loginPermissaoPessoa.setVisualizar(((Boolean) list.get(i)[2]) == null ? false : ((Boolean) list.get(i)[2]));
            loginPermissaoPessoa.setIncluir(((Boolean) list.get(i)[3]) == null ? false : ((Boolean) list.get(i)[3]));
            loginPermissaoPessoa.setAlterar(((Boolean) list.get(i)[4]) == null ? false : ((Boolean) list.get(i)[4]));
            loginPermissaoPessoa.setExcluir(((Boolean) list.get(i)[5]) == null ? false : ((Boolean) list.get(i)[5]));
            loginPermissaoPessoa.setItemMenu(new ItemMenuDao().load(list.get(i)[1]));
            listaLoginPermissaoPessoa.add(loginPermissaoPessoa);
        }
        return listaLoginPermissaoPessoa;
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
