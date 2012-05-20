/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.entidades.pessoa;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "cad_pessoa")
@PersistenceContext(type = PersistenceContextType.EXTENDED)
@DiscriminatorColumn(name="pj", discriminatorType=DiscriminatorType.STRING,length=1) 
@DiscriminatorValue("O")
public class Pessoa implements Serializable {

    @Id
    @Column(name = "id_pessoa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;
    @OneToOne(optional = true, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private Empresa empresa;
    //@OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<CadEndereco> enderecos;

    /*
     * Getter's and Setter's
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
//    public List<CadEndereco> getEnderecos() {
//        return enderecos;
//    }
//
//    public void setEnderecos(List<CadEndereco> enderecos) {
//        this.enderecos = enderecos;
//    }
}
