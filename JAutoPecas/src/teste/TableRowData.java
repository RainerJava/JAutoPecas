package teste;

public class TableRowData {

    private String idItemMenu = null;
    private String nome;
    private boolean visualizar;
    private boolean incluir;
    private boolean alterar;
    private boolean excluir;
    private boolean root;

    public TableRowData(String idItemMenu, String nome, boolean visualizar, boolean incluir, boolean alterar, boolean excluir, boolean root) {
        this.idItemMenu = idItemMenu;
        this.nome = nome;
        this.visualizar = visualizar;
        this.incluir = incluir;
        this.alterar = alterar;
        this.excluir = excluir;
        this.root = root;
    }

    public boolean isAlterar() {
        return alterar;
    }

    public void setAlterar(boolean alterar) {
        this.alterar = alterar;
    }

    public boolean isExcluir() {
        return excluir;
    }

    public void setExcluir(boolean excluir) {
        this.excluir = excluir;
    }

    public String getIdItemMenu() {
        return idItemMenu;
    }

    public void setIdItemMenu(String idItemMenu) {
        this.idItemMenu = idItemMenu;
    }

    public boolean isIncluir() {
        return incluir;
    }

    public void setIncluir(boolean incluir) {
        this.incluir = incluir;
    }

    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isVisualizar() {
        return visualizar;
    }

    public void setVisualizar(boolean visualizar) {
        this.visualizar = visualizar;
    }

    @Override
    public String toString() {
        return "TableRowData{" + "idItemMenu=" + idItemMenu + ", nome=" + nome + ", visualizar=" + visualizar + ", incluir=" + incluir + ", alterar=" + alterar + ", excluir=" + excluir + ", root=" + root + '}';
    }
}
