package jautopecas.util;

import jautopecas.components.DynamicTableModel;
import jautopecas.components.JComboBox;
import jautopecas.components.JTextField;
import jautopecas.crud.pessoa.endereco.FormularioEndereco;
import jautopecas.crud.pessoa.endereco.FormularioEnderecoTableModel;
import jautopecas.crud.pessoa.login.FormularioLogin;
import jautopecas.crud.pessoa.login.FormularioLoginTableModel;
import jautopecas.crud.pessoa.telefone.FormularioTelefone;
import jautopecas.crud.pessoa.telefone.FormularioTelefoneTableModel;
import jautopecas.exceptions.UtilFormularioException;
import java.awt.Component;
import java.awt.Container;
import java.beans.IntrospectionException;
import javax.swing.*;

/**
 *
 * @author JFFiorotto
 */
public class UtilFormulario {

    /**
     * Receber como parametro um container e limpa todos os campos.
     *
     * @param container
     */
    public static void limpaFormulario(Container container) throws UtilFormularioException {
        try {
            Component components[] = container.getComponents();
            for (Component component : components) {
                if (component instanceof JTextField) {
                    JTextField comp = (JTextField) component;
                    comp.limpaCampo();
                } else if (component instanceof jautopecas.components.JPasswordField) {
                    jautopecas.components.JPasswordField comp = (jautopecas.components.JPasswordField) component;
                    comp.limpaCampo();
                } else if (component instanceof JTextArea) {
                    JTextArea comp = (JTextArea) component;
                    comp.setText("");
                } else if (component instanceof JComboBox) {
                    JComboBox comp = (JComboBox) component;
                    comp.setSelectedIndex(-1);
                    comp.setSempreBloqueado(false);
                } else if (component instanceof JTable) {
                    JTable comp = ((JTable) component);
                    comp.clearSelection();
                    if (comp.getModel() instanceof DynamicTableModel) {
                        ((DynamicTableModel) comp.getModel()).setData(null);
                        comp.revalidate();
                    }
                } else if (component instanceof FormularioEndereco) {
                    FormularioEndereco formularioEndereco = (FormularioEndereco) component;
                    formularioEndereco.onLimpar();
                    ((FormularioEnderecoTableModel) formularioEndereco.getJtEnderecos().getModel()).removeResultado();
                    formularioEndereco.setListaEnderecoPessoa(null);
                } else if (component instanceof FormularioTelefone) {
                    FormularioTelefone formularioTelefone = (FormularioTelefone) component;
                    formularioTelefone.onLimpar();
                    ((FormularioTelefoneTableModel) formularioTelefone.getJtTelefones().getModel()).removeResultado();
                    formularioTelefone.setListaTelefonePessoa(null);
                } else if (component instanceof FormularioLogin) {
                    FormularioLogin formularioLogin = (FormularioLogin) component;
                    formularioLogin.onLimpar();
                    ((FormularioLoginTableModel) formularioLogin.getJtlogins().getModel()).removeResultado();
                    formularioLogin.setListaPessoaLogin(null);
                } else if (component instanceof Container) {
                    limpaFormulario((Container) component);
                }
            }
        } catch (IntrospectionException ex) {
            throw new UtilFormularioException("Erro ao limpar o fomulario");
        }
    }

    public static void bloquearFormulario(Boolean formularioBloqueado, Container container) throws UtilFormularioException {
        try {
            Component components[] = container.getComponents();
            for (Component component : components) {
                if (component instanceof JTextField) {
                    JTextField comp = (JTextField) component;
                    comp.setEditable(!formularioBloqueado);
                } else if (component instanceof jautopecas.components.JPasswordField) {
                    jautopecas.components.JPasswordField comp = (jautopecas.components.JPasswordField) component;
                    comp.setEditable(!formularioBloqueado);
                } else if (component instanceof JTextArea) {
                    JTextArea comp = (JTextArea) component;
                    comp.setEditable(!formularioBloqueado);
                } else if (component instanceof JComboBox) {
                    JComboBox comp = (JComboBox) component;
                    if (!comp.isSempreBloqueado()) {
                        comp.setEnabled(!formularioBloqueado);
                    }
                } else if (component instanceof FormularioEndereco) {
                    FormularioEndereco formularioEndereco = (FormularioEndereco) component;
                    formularioEndereco.onBloquear(formularioBloqueado);
                } else if (component instanceof FormularioTelefone) {
                    FormularioTelefone formularioTelefone = (FormularioTelefone) component;
                    formularioTelefone.onBloquear(formularioBloqueado);
                } else if (component instanceof FormularioLogin) {
                    FormularioLogin formularioLogin = (FormularioLogin) component;
                    formularioLogin.onBloquear(formularioBloqueado);
                } else if (component instanceof Container) {
                    bloquearFormulario(formularioBloqueado, (Container) component);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new UtilFormularioException("Erro ao bloquear o fomulario");
        }
    }

    /**
     * Receber como parametro um container e valida todos os campos.
     *
     * @param container
     */
    public static int validarFormulario(Container container) throws UtilFormularioException {
        int countErrosFormulario = 0;
        try {
            Component components[] = container.getComponents();
            for (Component component : components) {
                if (component instanceof JTextField & component.isVisible()) {
                    JTextField comp = (JTextField) component;
                    if (!comp.validaCampo()) {
                        countErrosFormulario++;
                    }
                } else if (component instanceof jautopecas.components.JPasswordField & component.isVisible()) {
                    jautopecas.components.JPasswordField comp = (jautopecas.components.JPasswordField) component;
                    if (!comp.validaCampo()) {
                        countErrosFormulario++;
                    }
                } else if (component instanceof FormularioEndereco) {
                    FormularioEndereco formularioEndereco = (FormularioEndereco) component;
                    if (formularioEndereco.getListaEnderecoPessoa() == null || formularioEndereco.getListaEnderecoPessoa().size() <= 0) {
                        int countErrosFormularioEndereco = validarFormulario((Container) component);
                        countErrosFormulario += countErrosFormularioEndereco;
                        if (countErrosFormularioEndereco == 0) {
                            countErrosFormulario++;
                            JOptionPane.showMessageDialog(null, "Confirme o endereco antes de salvar!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            ((JTabbedPane) component.getParent().getParent()).setSelectedIndex(0);
                        }
                    }
                } else if (component instanceof FormularioTelefone) {
                    FormularioTelefone formularioTelefone = (FormularioTelefone) component;
                    if (formularioTelefone.getListaTelefonePessoa() == null || formularioTelefone.getListaTelefonePessoa().size() <= 0) {
                        int countErrosFormularioTelefone = validarFormulario((Container) component);
                        countErrosFormulario += countErrosFormularioTelefone;
                        if (countErrosFormularioTelefone == 0) {
                            countErrosFormulario++;
                            JOptionPane.showMessageDialog(null, "Confirme o telefone antes de salvar!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            ((JTabbedPane) component.getParent().getParent()).setSelectedIndex(1);
                        }
                    }
                } else if (component instanceof FormularioLogin) {
                    int countErrosFormularioLogin = validarFormulario((Container) component);
                    if (countErrosFormularioLogin == 0) {
                        countErrosFormulario++;
                        JOptionPane.showMessageDialog(null, "Confirme o login antes de salvar!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                        ((JTabbedPane) component.getParent().getParent()).setSelectedIndex(2);
                    }
                } else if (component instanceof Container) {
                    if (component instanceof JLabel) {
                        continue;
                    }
                    countErrosFormulario += validarFormulario((Container) component);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new UtilFormularioException("Erro ao validar o formulario");
        }
        return countErrosFormulario;
    }
}
