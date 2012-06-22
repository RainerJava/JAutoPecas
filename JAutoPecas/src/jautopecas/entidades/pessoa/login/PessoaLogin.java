package jautopecas.entidades.pessoa.login;

import jautopecas.entidades.pessoa.Pessoa;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_PESSOA_LOGIN")
public class PessoaLogin implements Serializable {

    @Id
    @Column(name = "ID_PESSOA_LOGIN")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPessoaLogin;
    private String usuario;
    private String senha;
    @OneToOne
    @JoinColumn(name = "ID_PESSOA")
    private Pessoa pessoa;

    /*
     * Getter's and Setter's
     */
    public Integer getIdPessoaLogin() {
        return idPessoaLogin;
    }

    public void setIdPessoaLogin(Integer idPessoaLogin) {
        this.idPessoaLogin = idPessoaLogin;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}