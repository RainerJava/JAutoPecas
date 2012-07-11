package jautopecas.entidades.pessoa;

import jautopecas.entidades.pessoa.colaborador.FuncaoSalarioColaborador;
import jautopecas.entidades.pessoa.endereco.EnderecoPessoa;
import jautopecas.entidades.pessoa.login.LoginPessoa;
import jautopecas.entidades.pessoa.telefone.TelefonePessoa;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 * @author JFFiorotto
 *
 */
@Entity
@Table(name = "CAD_PESSOA")
public class Pessoa implements Serializable {

    public static final String TIPO_PESSOA_FISICA = "Fisica";
    public static final String TIPO_PESSOA_JURIDICA = "Juridica";
    @Id
    @Column(name = "ID_PESSOA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPessoa;
    private String nome;
    private String apelido;
    private String documento;
    @OneToOne
    @JoinColumn(name = "MODELO_PESSOA")
    private ModeloPessoa modeloPessoa;
    @OneToOne(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private AdicionalPessoa adicionalPessoa;
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnderecoPessoa> enderecoPessoa;
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TelefonePessoa> telefonePessoa;
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoginPessoa> loginPessoa;
    @Column(name = "FISICA_JURIDICA")
    private String fisicaJuridica;
    @OneToOne
    @JoinColumn(name = "TIPO_PESSOA")
    private TipoPessoa tipoPessoa;
    /*
     * Colaborador
     */
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FuncaoSalarioColaborador> funcaoSalarioColaborador;

    /*
     * Getter's and Setter's
     */
    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<EnderecoPessoa> getEnderecoPessoa() {
        return enderecoPessoa;
    }

    public void setEnderecoPessoa(List<EnderecoPessoa> enderecoPessoa) {
        this.enderecoPessoa = enderecoPessoa;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public ModeloPessoa getModeloPessoa() {
        return modeloPessoa;
    }

    public void setModeloPessoa(ModeloPessoa modeloPessoa) {
        this.modeloPessoa = modeloPessoa;
    }

    public AdicionalPessoa getAdicionalPessoa() {
        return adicionalPessoa;
    }

    public void setAdicionalPessoa(AdicionalPessoa adicionalPessoa) {
        this.adicionalPessoa = adicionalPessoa;
    }

    public List<TelefonePessoa> getTelefonePessoa() {
        return telefonePessoa;
    }

    public void setTelefonePessoa(List<TelefonePessoa> telefonePessoa) {
        this.telefonePessoa = telefonePessoa;
    }

    public String getFisicaJuridica() {
        return fisicaJuridica;
    }

    public void setFisicaJuridica(String fisicaJuridica) {
        this.fisicaJuridica = fisicaJuridica;
    }

    public List<LoginPessoa> getLoginPessoa() {
        return loginPessoa;
    }

    public void setLoginPessoa(List<LoginPessoa> loginPessoa) {
        this.loginPessoa = loginPessoa;
    }

    public List<FuncaoSalarioColaborador> getFuncaoSalarioColaborador() {
        return funcaoSalarioColaborador;
    }

    public void setFuncaoSalarioColaborador(List<FuncaoSalarioColaborador> funcaoSalarioColaborador) {
        this.funcaoSalarioColaborador = funcaoSalarioColaborador;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.idPessoa, other.idPessoa)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.apelido, other.apelido)) {
            return false;
        }
        if (!Objects.equals(this.documento, other.documento)) {
            return false;
        }
        if (!Objects.equals(this.modeloPessoa, other.modeloPessoa)) {
            return false;
        }
        if (!Objects.equals(this.adicionalPessoa, other.adicionalPessoa)) {
            return false;
        }
        if (!Objects.equals(this.enderecoPessoa, other.enderecoPessoa)) {
            return false;
        }
        if (!Objects.equals(this.telefonePessoa, other.telefonePessoa)) {
            return false;
        }
        if (!Objects.equals(this.loginPessoa, other.loginPessoa)) {
            return false;
        }
        if (!Objects.equals(this.fisicaJuridica, other.fisicaJuridica)) {
            return false;
        }
        if (!Objects.equals(this.tipoPessoa, other.tipoPessoa)) {
            return false;
        }
        if (!Objects.equals(this.funcaoSalarioColaborador, other.funcaoSalarioColaborador)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idPessoa);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.apelido);
        hash = 97 * hash + Objects.hashCode(this.documento);
        hash = 97 * hash + Objects.hashCode(this.modeloPessoa);
        hash = 97 * hash + Objects.hashCode(this.adicionalPessoa);
        hash = 97 * hash + Objects.hashCode(this.enderecoPessoa);
        hash = 97 * hash + Objects.hashCode(this.telefonePessoa);
        hash = 97 * hash + Objects.hashCode(this.loginPessoa);
        hash = 97 * hash + Objects.hashCode(this.fisicaJuridica);
        hash = 97 * hash + Objects.hashCode(this.tipoPessoa);
        hash = 97 * hash + Objects.hashCode(this.funcaoSalarioColaborador);
        return hash;
    }

    @Override
    public String toString() {
        return idPessoa + "-" + apelido;
    }
}
