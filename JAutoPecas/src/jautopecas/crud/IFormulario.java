package jautopecas.crud;

import java.util.List;

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

    public MensagemRodape getMensagemRodape();

    public List pesquisar(String strPesquisa) throws Exception;
}
