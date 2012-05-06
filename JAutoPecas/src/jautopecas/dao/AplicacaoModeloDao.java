/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.dao;

import jautopecas.entidades.AplicacaoModelo;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
public class AplicacaoModeloDao extends AbstractDao<AplicacaoModelo> implements Serializable {

    public AplicacaoModeloDao() {
        super(AplicacaoModelo.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}