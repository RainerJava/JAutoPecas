/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.dao;

import jautopecas.entidades.Modelo;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
public class ModeloDao extends AbstractDao<Modelo> implements Serializable {

    public ModeloDao() {
        super(Modelo.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
