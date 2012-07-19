package jautopecas.dao.produto;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.produto.Estoque;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author JFFiorotto
 */
public class EstoqueDao extends AbstractDao<EstoqueDao> implements Serializable {

    public EstoqueDao() {
        super(EstoqueDao.class);
    }

    public List<Estoque> pesquisaProduto(Integer idFornecedor, Integer idEmpresa) throws Exception {
        String sql = "SELECT a FROM Estoque a"
                + " where a.empresa.idPessoa = :idEmpresa";
        TypedQuery<Estoque> typedQuery = getEntityManager().createQuery(sql, Estoque.class);
        typedQuery.setParameter("idEmpresa", idEmpresa);
        List<Estoque> lista = typedQuery.getResultList();
        for (Estoque estoque : lista) {
            estoque.getProduto().setCustoFornecedor(new ProdutoFornecedorCustoDao().getProdutoFornecedorCusto(idFornecedor, estoque.getProduto().getIdProduto(), idEmpresa));
        }
        return lista;
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
