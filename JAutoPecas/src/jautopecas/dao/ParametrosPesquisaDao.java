/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.dao;

import jautopecas.entidades.ParametrosPesquisa;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel
 */
public class ParametrosPesquisaDao extends AbstractDao<ParametrosPesquisa> implements Serializable {

    public ParametrosPesquisaDao() {
        super(ParametrosPesquisa.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
