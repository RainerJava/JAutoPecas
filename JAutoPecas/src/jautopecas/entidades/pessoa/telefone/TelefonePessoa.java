package jautopecas.entidades.pessoa.telefone;

import jautopecas.entidades.pessoa.telefone.Telefone;
import jautopecas.entidades.pessoa.Pessoa;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_TELEFONE_PESSOA")
public class TelefonePessoa implements Serializable {

    @Id
    @Column(name = "ID_TELEFONE_PESSOA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTelefonePessoa;
    @OneToOne
    @JoinColumn(name = "ID_PESSOA")
    private Pessoa pessoa;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TELEFONE")
    private Telefone telefone;

    /*
     * Getter's and Setter's
     */
    public Integer getIdTelefonePessoa() {
        return idTelefonePessoa;
    }

    public void setIdTelefonePessoa(Integer idTelefonePessoa) {
        this.idTelefonePessoa = idTelefonePessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
}
