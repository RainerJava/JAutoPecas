/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.entidades;

import jautopecas.components.anotacao.AnotacaoNomeColuna;
import jautopecas.dao.GrupoDao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "CAD_GRUPO")
public class Grupo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo")
    @AnotacaoNomeColuna(nome="ID Grupo",descricao="Identificador do Grupo")
    private Integer idGrupo;
    @AnotacaoNomeColuna(nome="Nome",descricao="Nome do Grupo")
    private String nome;

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
