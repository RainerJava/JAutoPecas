package jautopecas.entidades.pessoa.login;

import jautopecas.entidades.pessoa.Pessoa;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_LOGIN_PESSOA")
public class LoginPessoa implements Serializable {

    @Id
    @Column(name = "ID_LOGIN_PESSOA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLoginPessoa;
    private String login;
    private String senha;
    private String status;
    @OneToOne
    @JoinColumn(name = "ID_PESSOA")
    private Pessoa pessoa;

    /*
     * Getter's and Setter's
     */
    public Integer getIdLoginPessoa() {
        return idLoginPessoa;
    }

    public void setIdLoginPessoa(Integer idLoginPessoa) {
        this.idLoginPessoa = idLoginPessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}