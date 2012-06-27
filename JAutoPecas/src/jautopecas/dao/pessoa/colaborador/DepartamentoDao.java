package jautopecas.dao.pessoa.colaborador;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.pessoa.colaborador.Departamento;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class DepartamentoDao extends AbstractDao<Departamento> implements Serializable {

    public DepartamentoDao() {
        super(Departamento.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
