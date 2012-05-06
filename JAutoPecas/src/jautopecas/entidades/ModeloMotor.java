/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "CAD_MODELO_MOTOR")
public class ModeloMotor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_modelo_motor")
    private int idModeloMotor;
    @Column(name = "id_modelo")
    private int idModelo;
    @Column(name = "id_motor")
    private int idMotor;

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public int getIdModeloMotor() {
        return idModeloMotor;
    }

    public void setIdModeloMotor(int idModeloMotor) {
        this.idModeloMotor = idModeloMotor;
    }

    public int getIdMotor() {
        return idMotor;
    }

    public void setIdMotor(int idMotor) {
        this.idMotor = idMotor;
    }
}
