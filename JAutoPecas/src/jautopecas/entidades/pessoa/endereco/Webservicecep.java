package jautopecas.entidades.pessoa.endereco;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Webservicecep {
    
    private String resultado;
    private String resultado_txt;
    private String uf;
    private String cidade;
    private String bairro;
    private String tipo_logradouro;
    private String logradouro;
    
    public String getResultado() {
        return resultado;
    }
    
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    public String getResultado_txt() {
        return resultado_txt;
    }
    
    public void setResultado_txt(String resultado_txt) {
        this.resultado_txt = resultado_txt;
    }
    
    public String getUf() {
        return uf;
    }
    
    public void setUf(String uf) {
        if (!uf.isEmpty()) {
            this.uf = uf.toUpperCase();
        }
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public void setCidade(String cidade) {
        if (!cidade.isEmpty()) {
            this.cidade = cidade.toUpperCase();
        }
    }
    
    public String getBairro() {
        return bairro;
    }
    
    public void setBairro(String bairro) {
        if (!bairro.isEmpty()) {
            this.bairro = bairro.toUpperCase();
        }
    }
    
    public String getTipo_logradouro() {
        return tipo_logradouro;
    }
    
    public void setTipo_logradouro(String tipo_logradouro) {
        if (!tipo_logradouro.isEmpty()) {
            this.tipo_logradouro = tipo_logradouro.toUpperCase();
        }
    }
    
    public String getLogradouro() {
        return logradouro;
    }
    
    public void setLogradouro(String logradouro) {
        if (!logradouro.isEmpty()) {
            this.logradouro = logradouro.toUpperCase();
        }
    }
}
