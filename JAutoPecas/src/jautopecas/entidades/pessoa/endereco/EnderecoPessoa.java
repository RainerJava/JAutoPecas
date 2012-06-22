package jautopecas.entidades.pessoa.endereco;

import jautopecas.entidades.pessoa.Pessoa;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_ENDERECO_PESSOA")
public class EnderecoPessoa implements Serializable {

    @Id
    @Column(name = "ID_ENDERECO_PESSOA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEnderecoPessoa;
    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getIdEnderecoPessoa() {
        return idEnderecoPessoa;
    }

    public void setIdEnderecoPessoa(Integer idEnderecoPessoa) {
        this.idEnderecoPessoa = idEnderecoPessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
