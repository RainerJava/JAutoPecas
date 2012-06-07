package jautopecas.entidades.pessoa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author JFFiorotto
 *
 * This class stores the links e devices to be monitored
 *
 */
@Entity
@Table(name = "cad_empresa")
@PrimaryKeyJoinColumn(name = "id_pessoa")
@DiscriminatorValue("EM") 
public class Empresa extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "razao_social")
    private String razaoSocial;
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    private String cnpj;

    /*
     * Getter's and Setter's
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
