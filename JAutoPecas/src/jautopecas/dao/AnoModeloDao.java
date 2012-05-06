/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.dao;

import jautopecas.entidades.AnoModelo;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
public class AnoModeloDao extends AbstractDao<AnoModelo> implements Serializable {


    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    public AnoModeloDao() {
        super(AnoModelo.class);
    }
}
