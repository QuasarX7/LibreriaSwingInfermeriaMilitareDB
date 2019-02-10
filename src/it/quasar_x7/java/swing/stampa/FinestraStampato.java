package it.quasar_x7.java.swing.stampa;

import javax.swing.JFrame;

/**
 *
 * @author Dr Domenico della Peruta
 * @version 1.0.0 ultima modifica 04/04/2016
 */
public abstract class FinestraStampato extends JFrame {
    
    public FinestraStampato() {
    }

    public abstract void aggiungiTesto(String testo);
    
}
