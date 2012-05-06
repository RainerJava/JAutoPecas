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
@Table(name = "CAD_NUMERO_ORIGINAL")
public class NumeroOriginal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_numero_original")
    private int idNumOriginal;
    @Column(name = "numero_original")
    private String numOriginal;
    @Column(name = "id_montadora")
    private int idMontadora;
    @Column(name = "id_produto")
    private int idProduto;

    public int getIdMontadora() {
        return idMontadora;
    }

    public void setIdMontadora(int idMontadora) {
        this.idMontadora = idMontadora;
    }

    public int getIdNumOriginal() {
        return idNumOriginal;
    }

    public void setIdNumOriginal(int idNumOriginal) {
        this.idNumOriginal = idNumOriginal;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNumOriginal() {
        return numOriginal;
    }

    public void setNumOriginal(String numOriginal) {
        this.numOriginal = numOriginal;
    }
}
