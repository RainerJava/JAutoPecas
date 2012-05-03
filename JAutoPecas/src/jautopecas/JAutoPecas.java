/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jautopecas;

import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author JFFiorotto
 */
public class JAutoPecas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Toolkit.getDefaultToolkit().setDynamicLayout(true);
        System.setProperty("sun.awt.noerasebackground", "true");
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        try {
            UIManager.setLookAndFeel("de.muntjak.tinylookandfeel.TinyLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JAutoPecasMenu jAutoPecasMenu = new JAutoPecasMenu();
                jAutoPecasMenu.setTitle("ERP JAutoPecas - Versão BETA");
                jAutoPecasMenu.setVisible(true);
            }
        });
    }
}
