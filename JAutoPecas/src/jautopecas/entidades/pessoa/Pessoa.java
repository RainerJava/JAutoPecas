package jautopecas.entidades.pessoa;

import jautopecas.entidades.pessoa.colaborador.FuncaoSalarioColaborador;
import jautopecas.entidades.pessoa.endereco.EnderecoPessoa;
import jautopecas.entidades.pessoa.login.LoginPessoa;
import jautopecas.entidades.pessoa.telefone.TelefonePessoa;
import java.io.Serializable;
import java.util.List;
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
    @JoinColumn(name = "ID_MODELO_PESSOA")
    private ModeloPessoa modeloPessoa;
    @OneToOne(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private AdicionalPessoa adicionalPessoa;
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnderecoPessoa> enderecoPessoa;
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TelefonePessoa> telefonePessoa;
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoginPessoa> loginPessoa;
    @Column(name = "TIPO_PESSOA")
    private String tipoPessoa;
    
    /*Colaborador*/
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

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
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
}
