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
@Table(name="CAD_MOTOR")
public class Motor implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_motor")
    private int idMotor;
    private String nome;
    private double cilindradas;
    private int qtdCilindros;
    private int cavalos;
    private String combustivel;

    public int getCavalos() {
        return cavalos;
    }

    public void setCavalos(int cavalos) {
        this.cavalos = cavalos;
    }

    public double getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(double cilindradas) {
        this.cilindradas = cilindradas;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getIdMotor() {
        return idMotor;
    }

    public void setIdMotor(int idMotor) {
        this.idMotor = idMotor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdCilindros() {
        return qtdCilindros;
    }

    public void setQtdCilindros(int qtdCilindros) {
        this.qtdCilindros = qtdCilindros;
    }
    
    
}
