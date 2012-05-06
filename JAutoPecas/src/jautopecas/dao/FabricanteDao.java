/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.dao;

import jautopecas.entidades.Fabricante;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
public class FabricanteDao extends AbstractDao<Fabricante> implements Serializable {

    public FabricanteDao() {
        super(Fabricante.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
