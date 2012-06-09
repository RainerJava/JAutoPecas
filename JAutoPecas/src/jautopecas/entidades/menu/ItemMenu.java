package jautopecas.entidades.menu;

import jautopecas.components.anotacao.AnotacaoNomeColuna;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_ITEM_MENU")
public class ItemMenu implements Serializable {

    public static final Integer MENU = 0;
    public static final Integer SUBMENU = 1;
    public static final Integer JANELA = 2;
    @Id
    @Column(name = "id_item_menu")
    @AnotacaoNomeColuna(nome = "ID Item Menu")
    private String idItemMenu;
    @AnotacaoNomeColuna(nome = "Nome Item")
    private String nome;
    @Column(name = "caminho_imagem")
    @AnotacaoNomeColuna(nome = "Imagem")
    private String caminhoImagem;
    @Column(name = "classe_formulario")
    @AnotacaoNomeColuna(nome = "Formulario")
    private String classeFormulario;
    @Column(name = "classe_entidade")
    @AnotacaoNomeColuna(nome = "Entidade")
    private String classeEntidade;
    @Column(name = "tipo_item")
    @AnotacaoNomeColuna(nome = "Tipo Item")
    private Integer tipoItem;
    @Column(name = "metodo_pesquisa")
    @AnotacaoNomeColuna(nome = "Pesquisa")
    private String metodoPesquisa;
    @Column(name = "campos_pesquisa")
    @AnotacaoNomeColuna(nome = "Campos Pesquisa")
    private String camposPesquisa;
    @Column(name = "campos_jftextfield")
    @AnotacaoNomeColuna(nome = "Campos JFTextField")
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
