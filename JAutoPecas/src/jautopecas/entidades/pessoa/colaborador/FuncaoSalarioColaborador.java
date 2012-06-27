package jautopecas.entidades.pessoa.colaborador;

import jautopecas.entidades.pessoa.Pessoa;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author JFFiorotto
 */
@Entity
@Table(name = "MOV_FUNCAO_SALARIO_COLABORADOR")
public class FuncaoSalarioColaborador implements Serializable {

    @Id
    @Column(name = "ID_FUNCAO_SALARIO_COLABORADOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFuncaoSalarioColaborador;
    @Column(name = "DATA_INICIO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "DATA_FIM")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFim;
    private BigDecimal salario;
    @OneToOne
    @JoinColumn(name = "ID_FUNCAO")
    private Funcao funcao;
    @OneToOne
    @JoinColumn(name = "ID_PESSOA")
    private Pessoa pessoa;
    /*
     * Getter's and Setter's
     */

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public Integer getIdFuncaoSalarioColaborador() {
        return idFuncaoSalarioColaborador;
    }

    public void setIdFuncaoSalarioColaborador(Integer idFuncaoSalarioColaborador) {
        this.idFuncaoSalarioColaborador = idFuncaoSalarioColaborador;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
