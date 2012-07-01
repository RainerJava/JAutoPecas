package jautopecas.entidades.produto;

import jautopecas.components.anotacao.AnotacaoNomeColuna;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_SUBGRUPO")
public class Subgrupo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SUBGRUPO")
    @AnotacaoNomeColuna(nome = "ID Subgrupo")
    private Integer idSubgrupo;
    @AnotacaoNomeColuna(nome = "Nome")
    private String nome;

    public Integer getIdSubgrupo() {
        return idSubgrupo;
    }

    public void setIdSubgrupo(Integer idSubgrupo) {
        this.idSubgrupo = idSubgrupo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
