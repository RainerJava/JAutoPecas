package jautopecas.util;

import jautopecas.components.DynamicTableModel;
import jautopecas.components.JFComboBox;
import jautopecas.components.JFTextField;
import jautopecas.crud.pessoa.endereco.FormularioEnderecoTableModel;
import jautopecas.crud.pessoa.endereco.FormularioEndereco;
import jautopecas.crud.pessoa.telefone.FormularioTelefone;
import jautopecas.crud.pessoa.telefone.FormularioTelefoneTableModel;
import jautopecas.exceptions.UtilFormularioException;
import java.awt.Component;
import java.awt.Container;
import java.beans.IntrospectionException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

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
    public void limpaFormulario(Container container) throws UtilFormularioException {
        try {
            Component components[] = container.getComponents();
            for (Component component : components) {
                if (component instanceof JFTextField) {
                    JFTextField jfField = (JFTextField) component;
                    jfField.limpaCampo();
                } else if (component instanceof JTextArea) {
                    JTextArea area = (JTextArea) component;
                    area.setText("");
                } else if (component instanceof JComboBox) {
                    JFComboBox comboBox = (JFComboBox) component;
                    comboBox.setSelectedIndex(-1);
                    comboBox.setSempreBloqueado(false);
                } else if (component instanceof JTable) {
                    JTable jtable = ((JTable) component);
                    jtable.clearSelection();
                    if (jtable.getModel() instanceof DynamicTableModel) {
                        ((DynamicTableModel) jtable.getModel()).setData(null);
                        jtable.revalidate();
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
                } else if (component instanceof Container) {
                    limpaFormulario((Container) component);
                }
            }
        } catch (IntrospectionException ex) {
            throw new UtilFormularioException("Erro ao limpar o fomulario");
        }
    }

    public void bloquearFormulario(Boolean formularioBloqueado, Container container) throws UtilFormularioException {
        try {
            Component components[] = container.getComponents();
            for (Component component : components) {
                if (component instanceof JFTextField) {
                    JFTextField jfField = (JFTextField) component;
                    jfField.setEditable(!formularioBloqueado);
                } else if (component instanceof JTextArea) {
                    JTextArea area = (JTextArea) component;
                    area.setEditable(!formularioBloqueado);
                } else if (component instanceof JComboBox) {
                    JFComboBox comboBox = (JFComboBox) component;
                    if (!comboBox.isSempreBloqueado()) {
                        comboBox.setEnabled(!formularioBloqueado);
                    }
                } else if (component instanceof FormularioEndereco) {
                    FormularioEndereco formularioEndereco = (FormularioEndereco) component;
                    formularioEndereco.onBloquear(formularioBloqueado);
                } else if (component instanceof FormularioTelefone) {
                    FormularioTelefone formularioTelefone = (FormularioTelefone) component;
                    formularioTelefone.onBloquear(formularioBloqueado);
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
    public int validarFormulario(Container container, boolean recursive, int countErrosFormulario) throws UtilFormularioException {
        if (recursive) {
            countErrosFormulario = 0;
        }
        try {
            Component components[] = container.getComponents();
            for (Component component : components) {
                if (component instanceof JFTextField & component.isVisible()) {
                    JFTextField field = (JFTextField) component;
                    if (!field.validaCampo()) {
                        countErrosFormulario++;
                    }
                } else if (component instanceof FormularioEndereco) {
                    FormularioEndereco formularioEndereco = (FormularioEndereco) component;
                    if (formularioEndereco.getListaEnderecoPessoa() == null || formularioEndereco.getListaEnderecoPessoa().size() <= 0) {
                        int countErrosFormularioEndereco = validarFormulario((Container) component, false, countErrosFormulario);
                        countErrosFormulario += countErrosFormularioEndereco;
                        if (countErrosFormularioEndereco == 0) {
                            countErrosFormulario++;
                            JOptionPane.showMessageDialog(null, "Confirme o endereco antes de salvar!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else if (component instanceof FormularioTelefone) {
                    FormularioTelefone formularioTelefone = (FormularioTelefone) component;
                    if (formularioTelefone.getListaTelefonePessoa() == null || formularioTelefone.getListaTelefonePessoa().size() <= 0) {
                        int countErrosFormularioTelefone = validarFormulario((Container) component, false, countErrosFormulario);
                        countErrosFormulario += countErrosFormularioTelefone;
                        if (countErrosFormularioTelefone == 0) {
                            countErrosFormulario++;
                            JOptionPane.showMessageDialog(null, "Confirme o telefone antes de salvar!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else if (component instanceof Container) {
                    countErrosFormulario += validarFormulario((Container) component, false, countErrosFormulario);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new UtilFormularioException("Erro ao validar o formulario");
        }
        return countErrosFormulario;
    }
}
