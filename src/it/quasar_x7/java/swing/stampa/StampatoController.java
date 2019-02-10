package it.quasar_x7.java.swing.stampa;

/**
 *
 * @author Dr. Domenico della Peruta
 * @version 1.0.0 ultima modifica 10/04/2016
 */
public class StampatoController {

    private final Stampato finestra;

    private String testo = "";
    
    StampatoController(Stampato finestra) {
        this.finestra=finestra;
        
    }

    public void aggiungiTesto(String testo) {
         this.testo += testo;
        //------------------------------------
        String html = "<!DOCTYPE HTML>" + 
                        "<html>" + 
                            "<head>" + 
                            "</head>" + 
                            "<body>" + 
                                this.testo + 
                            "</body>" + 
                        "</html>";
        //------------------------------------
        
        finestra.areaTesto().setText(html);
    }

    public void cancella() {
        finestra.areaTesto().setText("");
        this.testo = "";
    }
    
}
