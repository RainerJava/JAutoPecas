package jautopecas.components;

import jautopecas.JAutoPecasMenu;
import jautopecas.crud.WindowCrud;
import jautopecas.entidades.menu.ItemMenu;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author JFFiorotto
 */
public class JFComboBox extends JComboBox {

    public JFComboBox() {
        super();

        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(final KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (isEnabled()) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        transferFocus();
                        return;
                    }
                    JFComboBox jfComboBox = ((JFComboBox) e.getComponent());
                    if (classeFormulario != null && e.getKeyCode() == KeyEvent.VK_F1) {
                        WindowCrud crud = new WindowCrud(itemMenu, "F1", jfComboBox);
                        crud.setVisible(true);
                        if (jfComboBox.getSelectedItem() != null) {
                            crud.setPesquisa(jfComboBox.getSelectedItem().toString());
                        } else {
                            crud.setPesquisa("");
                        }
                    } else if (classeFormulario != null && e.getKeyCode() == KeyEvent.VK_F2) {
                        WindowCrud crud = new WindowCrud(itemMenu, "F2", jfComboBox);
                        crud.setVisible(true);
                        if (getSelectedItem() != null) {
                            crud.setObjetoFormulario(getSelectedItem());
                        }
                    }
                }
            }
        });

        this.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent evt) {
                if (jlInformacao == null) {
                    jlInformacao = getJlInformacao();
                }
                if (jlInformacao != null && isEditable()) {
                    jlInformacao.setText(mensagemAjuda);
                }
            }

            @Override
            public void focusLost(FocusEvent evt) {
                if (jlInformacao == null) {
                    jlInformacao = getJlInformacao();
                }
                if (jlInformacao != null) {
                    jlInformacao.setText("");
                }
            }
        });
    }

    private JLabel getJlInformacao() {
        return ((WindowCrud) getTopLevelAncestor()).getJlInformacao();
    }
    private List<Object> dataSet;
    private String classeFormulario;
    private ItemMenu itemMenu;
    private String mensagemAjuda;
    private JLabel jlInformacao;

    /*
     * Getter's and Setter's
     */
    public List<Object> getDataSet() {
        return dataSet;
    }

    public void refreshDataSet() throws Exception {
        if (dataSet != null && dataSet.size() > 0) {
            try {
                String strClasseDao = itemMenu.getClasseEntidade().replace("jautopecas.entidades", "jautopecas.dao") + "Dao";
                Class classeDao = Class.forName(strClasseDao);
                Method m = classeDao.getMethod("listarTodos");
                setDataSet((List) m.invoke(classeDao.newInstance()));
            } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                throw new Exception("Erro no refresh do JFComboBox");
            }
        }
    }

    public void setDataSet(List dataSet) {
        this.dataSet = dataSet;
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) getModel();
        modelo.removeAllElements();
        for (Iterator<Object> it = dataSet.iterator(); it.hasNext();) {
            modelo.addElement(it.next());
        }
    }

    public void setClasseFormulario(String classeFormulario) {
        this.classeFormulario = classeFormulario;
        this.itemMenu = JAutoPecasMenu.getItemMenu(classeFormulario);
    }

    public void setMensagemAjuda(String mensagemAjuda) {
        this.mensagemAjuda = mensagemAjuda;
    }
}
