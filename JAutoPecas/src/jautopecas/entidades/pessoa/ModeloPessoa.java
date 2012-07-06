package jautopecas.entidades.pessoa;

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
@Table(name = "CAD_MODELO_PESSOA")
public class ModeloPessoa implements Serializable {

    @Id
    @Column(name = "MODELO_PESSOA")
    private String modeloPessoa;
    private String nome;

    public String getModeloPessoa() {
        return modeloPessoa;
    }

    public void setModeloPessoa(String modeloPessoa) {
        this.modeloPessoa = modeloPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
