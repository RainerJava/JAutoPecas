package jautopecas.dao.produto;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.produto.ProdutoFornecedorCusto;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author JFFiorotto
 */
public class ProdutoFornecedorCustoDao extends AbstractDao<ProdutoFornecedorCusto> implements Serializable {

    public ProdutoFornecedorCustoDao() {
        super(ProdutoFornecedorCusto.class);
    }

    public ProdutoFornecedorCusto getProdutoFornecedorCusto(Integer idFornecedor, Integer idProduto, Integer idEmpresa) throws Exception {
        String sql = "SELECT a FROM ProdutoFornecedorCusto a"
                + " where a.produtoFornecedor.fornecedor.idPessoa = :idFornecedor"
                + " and a.produtoFornecedor.produto.idProduto = :idProduto"
                + " and a.empresa.idPessoa = :idEmpresa";
        TypedQuery<ProdutoFornecedorCusto> typedQuery = getEntityManager().createQuery(sql, ProdutoFornecedorCusto.class);
        typedQuery.setParameter("idFornecedor", idFornecedor);
        typedQuery.setParameter("idProduto", idProduto);
        typedQuery.setParameter("idEmpresa", idEmpresa);
        return typedQuery.getSingleResult();
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
