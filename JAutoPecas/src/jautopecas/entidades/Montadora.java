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
@Table(name = "CAD_MONTADORA")
public class Montadora implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_montadora")
    private int idMontadora;
    private String nome;

    public int getIdMontadora() {
        return idMontadora;
    }

    public void setIdMontadora(int idMontadora) {
        this.idMontadora = idMontadora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
