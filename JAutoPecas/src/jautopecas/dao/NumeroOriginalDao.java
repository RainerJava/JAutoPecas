/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.dao;

import jautopecas.entidades.NumeroOriginal;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
public class NumeroOriginalDao extends AbstractDao<NumeroOriginal> implements Serializable {

    public NumeroOriginalDao() {
        super(NumeroOriginal.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}