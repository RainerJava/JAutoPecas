/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.entidades;

/**
 *
 * @author JFFiorotto
 */
public class CadItemMenu {

    public static final Integer PRINCIPAL = 0;
    public static final Integer MENU = 1;
    public static final Integer SUBMENU = 2;
    public static final Integer JANELA = 3;
    private String idItemMenu;
    private String nomeItem;
    private Integer tipoItem;
    private String classeFormulario;
    private String imagem;
    private String classePesquisa;

    public String getIdItemMenu() {
        return idItemMenu;
    }

    public void setIdItemMenu(String idItemMenu) {
        this.idItemMenu = idItemMenu;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public Integer getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(Integer tipoItem) {
        this.tipoItem = tipoItem;
    }

    public String getClasseFormulario() {
        return classeFormulario;
    }

    public void setClasseFormulario(String classeFormulario) {
        this.classeFormulario = classeFormulario;
    }

    public String getClassePesquisa() {
        return classePesquisa;
    }

    public void setClassePesquisa(String classePesquisa) {
        this.classePesquisa = classePesquisa;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
