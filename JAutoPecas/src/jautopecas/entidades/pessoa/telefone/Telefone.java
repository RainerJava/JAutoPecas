package jautopecas.entidades.pessoa.telefone;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "CAD_TELEFONE")
public class Telefone implements Serializable {

    public Telefone() {
        super();
    }
    @Id
    @Column(name = "ID_TELEFONE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTelefone;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_TIPO_TELEFONE", referencedColumnName = "ID_TIPO_TELEFONE")
    private TipoTelefone tipoTelefone;
    private String telefone;

    /*
     * Getter's and Setter's
     */
    public Integer getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }
}
