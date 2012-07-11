package jautopecas.dao.substituicaoTributaria;

import jautopecas.dao.AbstractDao;
import jautopecas.entidades.substituicaoTributaria.Icms;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.EntityManager;

/**
 *
 * @author JFFiorotto
 */
public class IcmsDao extends AbstractDao<Icms> implements Serializable {

    public IcmsDao() {
        super(Icms.class);
    }

    public BigDecimal getPercentIcmsEmissor(String uf, String ufEmissor) {
//        String WhereICM;
//        String TaxaICM = "0";
//        int TaxaVigente = 0;
//        WhereICM = "CUF = '" + uf + "' AND CUFE= '" + ufEmissor + "'";
//        String CursorICM;
//        CursorICM = "Cursor Ticm";
//        int ResultICM = Ticm.getQuery(WhereICM, CursorICM);
//        if (ResultICM == 0) {
//            TaxaVigente = Ticm.getInt("ITICM") - 1;
//            TaxaICM = (String) Ticm.getJFLMemory().getVResult().elementAt(TaxaVigente);
//        } else {
//            getJFLClient().setTmessage(
//                    null,
//                    "Não existe ICMS incluso na tabela de "
//                    + CufEmissor + " para " + CufDestino
//                    + ".Obrigatório cadastrar.");
//            return "0";
//        }
        return BigDecimal.ZERO;
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
