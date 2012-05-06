/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas.crud;

import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author JFFiorotto
 */
public interface IFormulario {

    public void setObjetoFormulario(Object obejetoFormulario);

    public Object getObjetoFormulario();

    public void salvar();

    public void alterar();

    public void excluir();

    public JLabel getJlInformacao();
    
    public List pesquisar(String camposFiltro, String strPesquisa);
}
