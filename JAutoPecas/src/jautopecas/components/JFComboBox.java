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
                WindowCrud windowCrud;
                if (isEnabled()) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        transferFocus();
                        return;
                    }
                    JFComboBox jfComboBox = ((JFComboBox) e.getComponent());
                    if (classeFormulario != null && e.getKeyCode() == KeyEvent.VK_F1) {
                        windowCrud = JAutoPecasMenu.addJanela(itemMenu, "F1", jfComboBox);
                        if (jfComboBox.getSelectedItem() != null) {
                            windowCrud.setPesquisa(jfComboBox.getSelectedItem().toString());
                        } else {
                            windowCrud.setPesquisa("");
                        }
                    } else if (classeFormulario != null && e.getKeyCode() == KeyEvent.VK_F2) {
                        windowCrud = JAutoPecasMenu.addJanela(itemMenu, "F2", jfComboBox);
                        if (getSelectedItem() != null) {
                            windowCrud.setObjetoFormulario(getSelectedItem());
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
                if (jlInformacao != null && isEnabled()) {
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
    private boolean sempreBloqueado;
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
    
    public boolean isSempreBloqueado() {
        return sempreBloqueado;
    }
    
    public void setSempreBloqueado(boolean sempreBloqueado) {
        this.sempreBloqueado = sempreBloqueado;
        if (sempreBloqueado) {
            this.setEnabled(false);
        }
    }
}
