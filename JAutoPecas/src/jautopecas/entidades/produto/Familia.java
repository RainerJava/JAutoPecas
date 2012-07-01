package jautopecas.entidades.produto;

import jautopecas.components.anotacao.AnotacaoNomeColuna;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "CAD_FAMILIA")
public class Familia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FAMILIA")
    @AnotacaoNomeColuna(nome = "ID Familia")
    private Integer idFamilia;
    @AnotacaoNomeColuna(nome = "Nome")
    private String nome;

    public Integer getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
