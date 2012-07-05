package jautopecas.crud;

import java.util.List;

/**
 *
 * @author JFFiorotto
 */
public interface IFormularioLista {

    public void setObjetoFormulario(Object obejetoFormulario) throws Exception;

    public Object getObjetoFormulario() throws Exception;

    public void onSalvar() throws Exception;

    public void onAlterar() throws Exception;

    public void onExcluir() throws Exception;

    public void onLimpar() throws Exception;

    public void onBloquear(boolean formularioBloqueado) throws Exception;

    public void onVisualizar() throws Exception;

    public void onPopulaLista() throws Exception;

    public void onCarregaCombo() throws Exception;

    public void getLista() throws Exception;

    public void setLista(List<Object[]> lista) throws Exception;

    public void getJTable() throws Exception;
}
