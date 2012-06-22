package jautopecas.dao.pessoa.login;

import jautopecas.dao.AbstractDao;
import jautopecas.dao.menu.ItemMenuDao;
import jautopecas.entidades.pessoa.login.PessoaLoginPermissao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author JFFiorotto
 */
public class PessoaLoginPermissaoDao extends AbstractDao<PessoaLoginPermissao> implements Serializable {

    public PessoaLoginPermissaoDao() {
        super(PessoaLoginPermissao.class);
    }

    public List<PessoaLoginPermissao> listaPermissaoUsuario(Integer idPessoaLogin) {
        List<PessoaLoginPermissao> listaPermissaoUsuario = new ArrayList<>();
        Query query = getEntityManager().createNativeQuery("SELECT b.id_pessoa_login_permissao,a.id_item_menu,b.visualizar,b.incluir,b.alterar,b.excluir "
                + "FROM cad_item_menu a LEFT OUTER JOIN cad_pessoa_login_permissao b ON (a.id_item_menu=b.id_item_menu) "
                + "WHERE b.id_pessoa_login = " + idPessoaLogin);
        List<Object[]> list = query.getResultList();
        for (int i = 0; i < list.size(); i++) {
            PessoaLoginPermissao permissaoUsuario = new PessoaLoginPermissao();
            permissaoUsuario.setIdPessoaLoginPermissao(((Integer) list.get(i)[0]));
            permissaoUsuario.setIdItemMenu(((String) list.get(i)[1]));
            permissaoUsuario.setVisualizar(((Boolean) list.get(i)[2]) == null ? false : ((Boolean) list.get(i)[2]));
            permissaoUsuario.setIncluir(((Boolean) list.get(i)[3]) == null ? false : ((Boolean) list.get(i)[3]));
            permissaoUsuario.setAlterar(((Boolean) list.get(i)[4]) == null ? false : ((Boolean) list.get(i)[4]));
            permissaoUsuario.setExcluir(((Boolean) list.get(i)[5]) == null ? false : ((Boolean) list.get(i)[5]));
            permissaoUsuario.setItemMenu(new ItemMenuDao().load(list.get(i)[1]));
            listaPermissaoUsuario.add(permissaoUsuario);
        }
        return listaPermissaoUsuario;
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
