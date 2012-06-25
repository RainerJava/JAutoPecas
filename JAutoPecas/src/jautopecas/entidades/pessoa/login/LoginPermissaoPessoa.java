package jautopecas.entidades.pessoa.login;

import jautopecas.entidades.menu.ItemMenu;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_LOGIN_PERMISSAO_PESSOA")
public class LoginPermissaoPessoa implements Serializable {

    @Id
    @Column(name = "ID_LOGIN_PERMISSAO_PESSOA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLoginPermissaoPessoa;
    @OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ITEM_MENU")
    private ItemMenu itemMenu;
    private Boolean visualizar;
    private Boolean incluir;
    private Boolean alterar;
    private Boolean excluir;
    @Transient
    private String idItemMenu;

    public Integer getIdLoginPermissaoPessoa() {
        return idLoginPermissaoPessoa;
    }

    public void setIdLoginPermissaoPessoa(Integer idLoginPermissaoPessoa) {
        this.idLoginPermissaoPessoa = idLoginPermissaoPessoa;
    }

    public Boolean getAlterar() {
        return alterar;
    }

    public void setAlterar(Boolean alterar) {
        this.alterar = alterar;
    }

    public Boolean getExcluir() {
        return excluir;
    }

    public void setExcluir(Boolean excluir) {
        this.excluir = excluir;
    }

    public String getIdItemMenu() {
        return idItemMenu;
    }

    public void setIdItemMenu(String idItemMenu) {
        this.idItemMenu = idItemMenu;
    }

    public Boolean getIncluir() {
        return incluir;
    }

    public void setIncluir(Boolean incluir) {
        this.incluir = incluir;
    }

    public ItemMenu getItemMenu() {
        return itemMenu;
    }

    public void setItemMenu(ItemMenu itemMenu) {
        this.itemMenu = itemMenu;
    }

    public Boolean getVisualizar() {
        return visualizar;
    }

    public void setVisualizar(Boolean visualizar) {
        this.visualizar = visualizar;
    }
}