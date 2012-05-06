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
@Table(name = "CAD_APLICACAO")
public class Aplicacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_APLICACAO")
    private int idAplicacao;
    @Column(name = "ID_PRODUTO")
    private int idProduto;
    @Column(name = "ID_GRUPO")
    private int idGrupo;
    private String seguimento;

    public int getIdAplicacao() {
        return idAplicacao;
    }

    public void setIdAplicacao(int idAplicacao) {
        this.idAplicacao = idAplicacao;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getSeguimento() {
        return seguimento;
    }

    public void setSeguimento(String seguimento) {
        this.seguimento = seguimento;
    }
}
