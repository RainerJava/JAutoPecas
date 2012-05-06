/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "CAD_FABRICANTE")
public class Fabricante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_fabricante")
    private int idFabricante;
    @Column(name = "razao_social")
    private String razaoSocial;

    public int getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(int idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
