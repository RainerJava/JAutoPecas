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
@Table(name = "CAD_APLICACAO_MODELO")
public class AplicacaoModelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_aplicacao_modelo")
    private int idAplicacaoModelo;
    @Column(name = "id_modelo")
    private int idModelo;
    @Column(name = "id_aplicacao")
    private int idAplicacao;

    public int getIdAplicacao() {
        return idAplicacao;
    }

    public void setIdAplicacao(int idAplicacao) {
        this.idAplicacao = idAplicacao;
    }

    public int getIdAplicacaoModelo() {
        return idAplicacaoModelo;
    }

    public void setIdAplicacaoModelo(int idAplicacaoModelo) {
        this.idAplicacaoModelo = idAplicacaoModelo;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }
}
