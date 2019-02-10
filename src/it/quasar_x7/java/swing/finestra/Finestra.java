package it.quasar_x7.java.swing.finestra;

import java.awt.Toolkit;
import javax.swing.JFrame;

/*******************************************************************************
 * Classe che implementa tutti i comportamenti e i metodi comuni.
 * 
 * @author Dr. Domenico della Peruta
 * @version 2.0.0 ultima modifica 05/04/2016
 ******************************************************************************/
public class Finestra {
    
    public static  JFrame finestra;
    public static String utente;
    //------------------------- proprietà ------------------------------------------
    //private JFrame finestra;
    public static Object[] impostazioni;
    /***************************************************************************
     * Crea ed instanzia una finestra grafica che occupa il centro dello schermo.
     * 
     * @param finestra 
     **************************************************************************/
    static public void creaFinestra(final javax.swing.JFrame finestra){
        java.awt.EventQueue.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        double altezza = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
                        final int y = (int) ((altezza - finestra.getHeight())/2);
                        double lunghezza = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                        final int x = (int) ((lunghezza - finestra.getWidth())/2);
                        finestra.setLocation(x,y);
                        finestra.setVisible(true);
                        //finestra.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                    }
                }
        );
    }
    
    
    
    /***************************************************************************
     * Metodo statico che crea una nuova finestra e fa scomparire le altre 
     * finestre.
     * 
     * @param _finestra 
     * @deprecated 
     **************************************************************************/
    static public void spegniAltreFinestre(final JFrame _finestra){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                if(finestra==null){//non vi sono altre finestre
                    finestra = _finestra; //istanzia nuova finestra
                    finestra.setVisible(true);
                }else{
                    //se esistono altre finestre...
                    finestra.setVisible(false);
                    finestra = _finestra;
                    finestra.setVisible(true);
                }
                double altezza = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
                int y = (int) ((altezza - finestra.getHeight())/2);
                double lunghezza = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                int x = (int) ((lunghezza - finestra.getWidth())/2);
                finestra.setLocation(x,y);
                finestra.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            }
        });
    }
    
    
}
