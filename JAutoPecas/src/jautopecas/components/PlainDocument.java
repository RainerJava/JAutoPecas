package jautopecas.components;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

public class PlainDocument extends javax.swing.text.PlainDocument {

    private int maximoCaracteres;
    // optional uppercase conversion
    private boolean toUppercase = false;

    PlainDocument(int maximoCaracteres) {
        super();
        this.maximoCaracteres = maximoCaracteres;
    }

    PlainDocument(int maximoCaracteres, boolean upper) {
        super();
        this.maximoCaracteres = maximoCaracteres;
        toUppercase = upper;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {
        if (str == null) {
            return;
        }

        if ((getLength() + str.length()) <= maximoCaracteres) {
            if (toUppercase) {
                str = str.toUpperCase();
            }
            super.insertString(offset, str, attr);
        }
    }

    public void setMaximoCaracteres(int maximoCaracteres) {
        this.maximoCaracteres = maximoCaracteres;
    }
}