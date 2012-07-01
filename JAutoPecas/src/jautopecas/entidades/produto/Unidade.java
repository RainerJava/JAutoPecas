package jautopecas.entidades.produto;

import jautopecas.components.anotacao.AnotacaoNomeColuna;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "CAD_UNIDADE")
public class Unidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_UNIDADE")
    @AnotacaoNomeColuna(nome="ID Unidade")
    private Integer idUnidade;
    @AnotacaoNomeColuna(nome="Nome")
    private String nome;

    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
