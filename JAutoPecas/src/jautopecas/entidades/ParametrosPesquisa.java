/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.entidades;

import jautopecas.components.anotacao.AnotacaoNomeColuna;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "CAD_PARAMETROS_PESQUISA")
public class ParametrosPesquisa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parametro_pesquisa")
    @AnotacaoNomeColuna(nome = "ID Parametro", descricao = "Identificador do Parametro")
    private Integer idParametroPesquisa;
    @AnotacaoNomeColuna(nome = "Classe", descricao = "Nome da classe")
    private String classe;
    @Column(name = "campos_pesquisa")
    @AnotacaoNomeColuna(nome = "Campos Pesquisa", descricao = "Campos para pesquisa")
    private String camposPesquisa;

    /*
     * Geter's and Seter's
     */
    public String getCamposPesquisa() {
        return camposPesquisa;
    }

    public void setCamposPesquisa(String camposPesquisa) {
        this.camposPesquisa = camposPesquisa;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Integer getIdParametroPesquisa() {
        return idParametroPesquisa;
    }

    public void setIdParametroPesquisa(Integer idParametroPesquisa) {
        this.idParametroPesquisa = idParametroPesquisa;
    }
}
