/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.dao;

import jautopecas.entidades.Produto;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
public class ProdutoDao extends AbstractDao<Produto> implements Serializable {

    public ProdutoDao() {
        super(Produto.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}