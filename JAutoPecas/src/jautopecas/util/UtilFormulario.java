package jautopecas.util;

import jautopecas.components.DynamicTableModel;
import jautopecas.components.JFTextField;
import jautopecas.crud.pessoa.endereco.FormularioEndereco;
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
    public void limpaFormulario(Container container) throws UtilFormularioException {
        try {
            Component components[] = container.getComponents();
            for (Component component : components) {
                if (component instanceof JFormattedTextField) {
                    JFormattedTextField field = (JFormattedTextField) component;
                    field.setValue(null);
                } else if (component instanceof JFTextField) {
                    JFTextField jfField = (JFTextField) component;
                    jfField.limpaCampo();
                } else if (component instanceof JTextField) {
                    JTextField field = (JTextField) component;
                    field.setText("");
                } else if (component instanceof JTextArea) {
                    JTextArea area = (JTextArea) component;
                    area.setText("");
                } else if (component instanceof JComboBox) {
                    JComboBox comboBox = (JComboBox) component;
                    comboBox.setSelectedIndex(-1);
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
                } else if (component instanceof Container) {
                    limpaFormulario((Container) component);
                }
            }
        } catch (IntrospectionException ex) {
            throw new UtilFormularioException("Erro ao limpar o fomulario");
        }
    }

    public void bloquearFormulario(Boolean bloqueia, Container container) throws UtilFormularioException {
        try {
            Component components[] = container.getComponents();
            for (Component component : components) {
                if (component instanceof JFormattedTextField) {
                    JFormattedTextField field = (JFormattedTextField) component;
                    field.setEditable(!bloqueia);
                } else if (component instanceof JFTextField) {
                    JFTextField jfField = (JFTextField) component;
                    jfField.setEditable(!bloqueia);
                } else if (component instanceof JTextArea) {
                    JTextArea area = (JTextArea) component;
                    area.setEditable(!bloqueia);
                } else if (component instanceof JComboBox) {
                    JComboBox comboBox = (JComboBox) component;
                    comboBox.setEnabled(!bloqueia);
                } else if (component instanceof FormularioEndereco) {
                    FormularioEndereco formularioEndereco = (FormularioEndereco) component;
                    formularioEndereco.onBloquear(!bloqueia);
                } else if (component instanceof Container) {
                    bloquearFormulario(bloqueia, (Container) component);
                }
            }
        } catch (Exception ex) {
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
                if (component instanceof JFormattedTextField) {
                    JFormattedTextField field = (JFormattedTextField) component;
                    field.setValue(null);
                } else if (component instanceof JFTextField) {
                    JFTextField field = (JFTextField) component;
                    if (!field.validaCampo()) {
                        countErrosFormulario++;
                    }
                } else if (component instanceof JTextArea) {
                    JTextArea area = (JTextArea) component;
                    area.setText("");
                } else if (component instanceof FormularioEndereco) {
                    FormularioEndereco formularioEndereco = (FormularioEndereco) component;
                    if (formularioEndereco.getEnderecos() == null || formularioEndereco.getEnderecos().size() <= 0) {
                        countErrosFormulario += validarFormulario((Container) component, false, countErrosFormulario);
                    }
                } else if (component instanceof Container) {
                    countErrosFormulario += validarFormulario((Container) component, false, countErrosFormulario);
                }
            }
        } catch (Exception ex) {
            throw new UtilFormularioException("Erro ao validar o formulario");
        }
        return countErrosFormulario;
    }
}
