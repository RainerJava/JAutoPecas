package jautopecas.components;

import jautopecas.JAutoPecasMenu;
import jautopecas.components.validadores.Validador;
import jautopecas.crud.MensagemRodape;
import jautopecas.crud.WindowCrud;
import jautopecas.entidades.menu.ItemMenu;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Field;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author JFFiorotto
 */
public class JTextField extends JFormattedTextField {
    
    public JTextField() {
        super();
        setDocument(new PlainDocument(maximoCaracteres, upperCase));
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
                if (isEditable()) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        transferFocus();
                        return;
                    }
                    JTextField jfTextField = ((JTextField) e.getComponent());
                    if (classeFormulario != null && e.getKeyCode() == KeyEvent.VK_F1) {
                        windowCrud = JAutoPecasMenu.addJanela(itemMenu, "F1", jfTextField);
                        windowCrud.setPesquisa(jfTextField.getText());
                    } else if (classeFormulario != null && e.getKeyCode() == KeyEvent.VK_F2) {
                        windowCrud = JAutoPecasMenu.addJanela(itemMenu, "F2", jfTextField);
                        windowCrud.setObjetoFormulario(objeto);
                    } else if (classeFormulario != null && (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE)) {
                        if (objeto != null) {
                            objeto = null;
                            setText("");
                        }
                    }
                }
            }
        });
        
        this.addFocusListener(new FocusAdapter() {
            
            @Override
            public void focusGained(FocusEvent evt) {
                if (getMensagemRodape() != null && isEditable()) {
                    getMensagemRodape().mostraMensagem(mensagemAjuda, MensagemRodape.MENSAGEM_AJUDA);
                    if (!campoValido) {
                        getMensagemRodape().mostraMensagem(mensagemErro, MensagemRodape.MENSAGEM_ERRO);
                    }
                }
            }
            
            @Override
            public void focusLost(FocusEvent evt) {
                if (getMensagemRodape() != null) {
                    getMensagemRodape().limpaMensagem();
                }
            }
        });
        bordaDefault = this.getBorder();
        colorDefault = this.getBackground();
    }
    /*
     * Variaveis Privadas
     */
    private String mensagemAjuda;
    private MensagemRodape mensagemRodape;
    private boolean upperCase = true;
    private int maximoCaracteres = 99999;
    private Validador validador;
    private Object objeto;
    private String classeFormulario;
    private ItemMenu itemMenu;
    private boolean requerido = false;
    private boolean campoValido = true;
    private String camposJFTextField;
    private Border bordaDefault;
    private Color colorDefault;
    private Border bordaErro = BorderFactory.createLineBorder(Color.RED);
    private String mensagemErro;
    private boolean sempreBloqueado;
    
    public boolean validaCampo() {
        if (requerido) {
            campoValido = true;
            mensagemErro = "";
            if (getText().length() > 0) {
                if (validador != null) {
                    campoValido = validador.validaCampo();
                    if (!validador.isValido()) {
                        mensagemErro = validador.getMensagemErro();
                    }
                }
                if (classeFormulario != null) {
                    if (objeto == null) {
                        campoValido = false;
                        mensagemErro = "Este campo não pode ficar vazio.";
                    }
                }
                if (this.getFormatter() instanceof MaskFormatter) {
                    if (((MaskFormatter) this.getFormatter()).getMask().length() > 0 & !this.isEditValid()) {
                        campoValido = false;
                        mensagemErro = "Formato inválido.";
                    }
                }
            } else {
                campoValido = false;
                mensagemErro = "Este campo não pode ficar vazio.";
            }
        }
        
        if (campoValido) {
            setBorder(bordaDefault);
        } else {
            setBorder(bordaErro);
        }
        return campoValido;
    }
    
    public void limpaCampo() {
        mensagemErro = "";
        setText("");
        setValue(null);
        setBorder(bordaDefault);
        objeto = null;
        if (validador != null) {
            validador.setValido(true);
        }
        campoValido = true;
        setSempreBloqueado(false);
    }
    
    private String getFieldValue() throws Exception {
        String str = "";
        try {
            if (itemMenu.getCamposJFTextField() == null) {
                throw new Exception("Informe um valor para campos_jftextfield");
            }
            if (objeto == null) {
                return "";
            }
            String[] campos = camposJFTextField != null ? camposJFTextField.split("\\,") : itemMenu.getCamposJFTextField().split("\\,");
            for (int i = 0; i < campos.length; i++) {
                Field field = objeto.getClass().getDeclaredField(campos[i]);
                field.setAccessible(true);
                if (i == 0) {
                    str += field.get(objeto).toString();
                } else {
                    str += " - " + field.get(objeto).toString();
                }
            }
        } catch (IllegalArgumentException | NoSuchFieldException | IllegalAccessException e) {
            throw e;
        }
        return str;
    }
    /*
     * Geter's and Seter's
     */
    
    public MensagemRodape getMensagemRodape() {
        if (mensagemRodape == null) {
            if (getTopLevelAncestor() instanceof WindowCrud) {
                mensagemRodape = ((WindowCrud) getTopLevelAncestor()).getMensagemRodape();
            }
        }
        return mensagemRodape;
    }
    
    public void setMensagemAjuda(String mensagemAjuda) {
        this.mensagemAjuda = mensagemAjuda;
    }
    
    public void setUpperCase(boolean upperCase) {
        this.upperCase = upperCase;
    }
    
    public void setValidador(Validador validador) {
        this.validador = validador;
        this.requerido = true;
    }
    
    public Object getObjeto() {
        return objeto;
    }
    
    public void setObjeto(Object objeto) throws Exception {
        this.objeto = objeto;
        if (objeto != null) {
            this.setText(getFieldValue());
        } else {
            this.setText("");
        }
    }
    
    public void setClasseFormulario(String classeFormulario) {
        if (classeFormulario != null && classeFormulario.length() > 0) {
            this.classeFormulario = classeFormulario;
            this.itemMenu = JAutoPecasMenu.getItemMenu(classeFormulario);
        }
    }
    
    public void setRequerido(boolean requerido) {
        this.requerido = requerido;
    }
    
    @Override
    public void setEditable(boolean b) {
        super.setEditable(b);
        if (classeFormulario != null && classeFormulario.length() > 0 && isEditable()) {
            this.setBackground(new Color(255, 255, 102));
        } else {
            this.setBackground(colorDefault);
        }
    }
    
    public void setCamposJFTextField(String camposJFTextField) {
        this.camposJFTextField = camposJFTextField;
    }
    
    public void setMaximoCaracteres(int maximoCaracteres) {
        this.maximoCaracteres = maximoCaracteres;
        ((PlainDocument) getDocument()).setMaximoCaracteres(maximoCaracteres);
    }
    
    public boolean isSempreBloqueado() {
        return sempreBloqueado;
    }
    
    public void setSempreBloqueado(boolean sempreBloqueado) {
        this.sempreBloqueado = sempreBloqueado;
        if (sempreBloqueado) {
            this.setEditable(false);
        }
    }
}
