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

    public void setObjetoFormulario(Object obejetoFormulario) throws Exception;

    public Object getObjetoFormulario() throws Exception;

    public void salvar() throws Exception;

    public void alterar() throws Exception;

    public void excluir() throws Exception;

    public JLabel getJlInformacao();

    public List pesquisar(String strPesquisa) throws Exception;
}
