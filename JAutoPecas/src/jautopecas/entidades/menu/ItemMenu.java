/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.entidades.menu;

import jautopecas.components.anotacao.AnotacaoNomeColuna;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jefferson
 */
@Entity
@Table(name = "CAD_ITEM_MENU")
public class ItemMenu implements Serializable {

    public static final Integer MENU = 0;
    public static final Integer SUBMENU = 1;
    public static final Integer JANELA = 2;
    @Id
    @Column(name = "id_item_menu")
    @AnotacaoNomeColuna(nome = "ID Item Menu", descricao = "Identificador do Item no menu")
    private String idItemMenu;
    @AnotacaoNomeColuna(nome = "Nome Item", descricao = "Nome do item no menu")
    private String nome;
    @Column(name = "caminho_imagem")
    @AnotacaoNomeColuna(nome = "Imagem", descricao = "Caminho imagem")
    private String caminhoImagem;
    @Column(name = "classe_formulario")
    @AnotacaoNomeColuna(nome = "Formulario", descricao = "Caminho do formulario")
    private String classeFormulario;
    @Column(name = "classe_entidade")
    @AnotacaoNomeColuna(nome = "Entidade", descricao = "Caminho da entidade")
    private String classeEntidade;
    @Column(name = "tipo_item")
    @AnotacaoNomeColuna(nome = "Tipo Item", descricao = "Tipo do item no menu")
    private Integer tipoItem;
    @Column(name = "metodo_pesquisa")
    @AnotacaoNomeColuna(nome = "Pesquisa", descricao = "Metodo utilizado para pesquisa")
    private String metodoPesquisa;
    @Column(name = "campos_pesquisa")
    @AnotacaoNomeColuna(nome = "Campos Pesquisa", descricao = "Campos utilizados na pesquisa")
    private String camposPesquisa;
    @Column(name = "campos_jftextfield")
    @AnotacaoNomeColuna(nome = "Campos JFTextField", descricao = "Campos apresentados no Field (modo pesquisa)")
    private String camposJFTextField;

    /*
     * Getter's and Setter's
     */
    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public String getClasseEntidade() {
        return classeEntidade;
    }

    public void setClasseEntidade(String classeEntidade) {
        this.classeEntidade = classeEntidade;
    }

    public String getClasseFormulario() {
        return classeFormulario;
    }

    public void setClasseFormulario(String classeFormulario) {
        this.classeFormulario = classeFormulario;
    }

    public String getIdItemMenu() {
        return idItemMenu;
    }

    public void setIdItemMenu(String idItemMenu) {
        this.idItemMenu = idItemMenu;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(Integer tipoItem) {
        this.tipoItem = tipoItem;
    }

    public String getCamposPesquisa() {
        return camposPesquisa;
    }

    public void setCamposPesquisa(String camposPesquisa) {
        this.camposPesquisa = camposPesquisa;
    }

    public String getMetodoPesquisa() {
        return metodoPesquisa;
    }

    public void setMetodoPesquisa(String metodoPesquisa) {
        this.metodoPesquisa = metodoPesquisa;
    }

    public String getCamposJFTextField() {
        return camposJFTextField;
    }

    public void setCamposJFTextField(String camposJFTextField) {
        this.camposJFTextField = camposJFTextField;
    }
}
