package jautopecas.dao.produto;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.produto.Produto;
import jautopecas.entidades.produto.ProdutoVo;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author JFFiorotto
 */
public class ProdutoDao extends AbstractDao<Produto> implements Serializable {

    public ProdutoDao() {
        super(Produto.class);
    }

    public List<ProdutoVo> pesquisaProduto(String modeloPessoa) throws Exception {
        String sql = "SELECT a FROM Produto a";
        TypedQuery<Produto> typedQuery = getEntityManager().createQuery(sql, Produto.class);
        //typedQuery.setParameter("modeloPessoa", modeloPessoa);
        List<ProdutoVo> listaProdutoVo = new ArrayList<>();
        List<Produto> lista = typedQuery.getResultList();
        for (int i = 0; i < lista.size(); i++) {
            ProdutoVo produtoVo = new ProdutoVo();
            produtoVo.setProduto(lista.get(i));
            produtoVo.setEstoque(BigDecimal.ZERO);
            produtoVo.setPreco(BigDecimal.ZERO);
            listaProdutoVo.add(produtoVo);
        }
        return listaProdutoVo;
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
