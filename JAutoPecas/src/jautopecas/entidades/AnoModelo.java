/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "CAD_ANO_MODELO")
public class AnoModelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ano_modelo")
    private int idAnoModelo;
    @Column(name = "id_modelo")
    private int idModelo;
    @Column(name = "ano_inicio")
    @Temporal(TemporalType.DATE)
    private Date anoInicio;
    @Column(name = "ano_fim")
    @Temporal(TemporalType.DATE)
    private Date anoFim;

    public Date getAnoFim() {
        return anoFim;
    }

    public void setAnoFim(Date anoFim) {
        this.anoFim = anoFim;
    }

    public Date getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(Date anoInicio) {
        this.anoInicio = anoInicio;
    }

    public int getIdAnoModelo() {
        return idAnoModelo;
    }

    public void setIdAnoModelo(int idAnoModelo) {
        this.idAnoModelo = idAnoModelo;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }
}
