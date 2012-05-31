package jautopecas.entidades.pessoa.endereco;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CAD_ESTADO")
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "UF")
    private String uf;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "REGIAO")
    private String regiao;
    @Column(name = "IBGE")
    private String ibge;

    /*
     * Getter's and Setter's
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }
}
