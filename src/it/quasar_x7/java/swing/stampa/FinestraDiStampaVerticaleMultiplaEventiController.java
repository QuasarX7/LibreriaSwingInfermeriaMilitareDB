package it.quasar_x7.java.swing.stampa;

import it.quasar_x7.java.utile.DataOraria;
import java.awt.event.ActionEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dr Domenico della Peruta
 * @version 2.0.0 ultima modifica 09/03/2016
 */
public class FinestraDiStampaVerticaleMultiplaEventiController {
    FinestraDiStampaVerticaleMultiplaEventi finestra;
    protected ArrayList<Object[]> listaDati;
    protected String intestazione1="";
    protected String intestazione2="";
    private int id = 0;

    public FinestraDiStampaVerticaleMultiplaEventiController(FinestraDiStampaVerticaleMultiplaEventi finestra) {
        this.finestra = finestra;
        this.finestra.data.setDate(new DataOraria().convertiDate());
     
    }
    
    
    
    protected String intestazione(){
        String titolo = "";
        titolo += Stampato.titolo(intestazione1,7);
        titolo += Stampato.titolo(intestazione2,6);
        titolo += Stampato.titolo(" ",8);
        return titolo;
    }
    
    private void seleziona(int id){        
        if(listaDati !=null){
            this.finestra.stampato.cancella();
            
            this.finestra.stampato.aggiungiBlocco(intestazione());
            this.finestra.campoIndice.setText(String.valueOf((id+1)+" di "+this.pagine(listaDati.size())));

            inizializzaPagina(id);
            
            
        }else{
            JOptionPane.showMessageDialog(
                    finestra,
                    "Nessun evento presente!",
                    "avviso", JOptionPane.WARNING_MESSAGE);
            this.finestra.setVisible(false);
        }
    }
    
    public void aggiungiTabella(Object[][] tabella,int[] dimColonne,boolean bordi){
        if(dimColonne != null)
            finestra.stampato.aggiungiTabella(
                    tabella, "Times", 5, false, Stampato.ALL_SINISTRA  , dimColonne, bordi);
    }
    
    

    public void pulsanteStampa(ActionEvent evt) {
    if(evt.getSource() instanceof javax.swing.JButton){
            //Stampa processoStampa = new Stampa(this.stampato);
            //processoStampa.attivaStampante(this);
            if(listaDati!=null){
                PrinterJob pj = PrinterJob.getPrinterJob();
                PageFormat pf = pj.defaultPage();
                Paper paper = new Paper();
    
                double margin = 0; // half inch
                paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2,
                paper.getHeight() - margin * 2);
                pf.setPaper(paper);
                pf.setOrientation(PageFormat.PORTRAIT);

               
                pj.setPrintable(this.finestra.stampato, pf);

                try {
                    if(this.pagine(listaDati.size())>0){
                        this.seleziona(id);
                        pj.print();
                    }
                    javax.swing.JOptionPane.showMessageDialog(
                        finestra, "Foglio stampato con successo ^_^", "OK!", 
                        javax.swing.JOptionPane.OK_OPTION, 
                        new javax.swing.ImageIcon(
                            getClass().getResource(
                                    it.quasar_x7.immagini.Risorse.Immagini.BALLERINA
                            )
                        )
                    );
                }catch (PrinterException ex) {
                     javax.swing.JOptionPane.showMessageDialog(
                        finestra, "Foglio non stampato", "Errore!", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(FinestraDiStampaVerticaleMultiplaEventi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void pulsanteAvanti(ActionEvent evt) {
       if(evt.getSource() instanceof javax.swing.JButton){
            if(listaDati != null){
                if((id+1)<this.pagine(listaDati.size())){
                    this.seleziona(++id);
                }
            }
        }
    }

    public void pulsanteDietro(ActionEvent evt) {
        if(evt.getSource() instanceof javax.swing.JButton){
            if(listaDati != null){
                if((id-1)>=0){
                    this.seleziona(--id);
                }
            }
        }
    }

    public void pulsanteStampaTutte(ActionEvent evt) {
        if(evt.getSource() instanceof javax.swing.JButton){
            if(listaDati!=null){
                
                
                PrinterJob pj = PrinterJob.getPrinterJob();
                PageFormat pf = pj.defaultPage();
                Paper paper = new Paper();
    
                double margin = 0; // half inch
                paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2,
                paper.getHeight() - margin * 2);
                pf.setPaper(paper);
                pf.setOrientation(PageFormat.PORTRAIT);

               
                pj.setPrintable(finestra.stampato, pf);

                try {
                    for(int i=0;i<this.pagine(listaDati.size());i++){
                        this.seleziona(i);
                        pj.print();
                    }
                    javax.swing.JOptionPane.showMessageDialog(
                        finestra, "Foglio stampato con successo ^_^", "OK!", 
                        javax.swing.JOptionPane.OK_OPTION, 
                        new javax.swing.ImageIcon(
                        getClass().getResource(
                        "/it/esercito/rua/repSup/gestoreProgramma/ballerina.gif")));
                }catch (PrinterException ex) {
                     javax.swing.JOptionPane.showMessageDialog(
                        finestra, "Foglio non stampato", "Errore!", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(FinestraDiStampaVerticaleMultiplaEventi.class.getName()).log(Level.SEVERE, null, ex);
                }
                
             
            }
            
        }
    }

    public void pulsanteStampaPagine(ActionEvent evt) {
        if(evt.getSource() instanceof javax.swing.JButton){
            if(listaDati!=null){
                int pagina_inizio=0,pagina_fine=0;

                String str_inizio = (String)javax.swing.JOptionPane.showInputDialog(
                        finestra, "dalla pagina numero", "seleziona pagina",
                        javax.swing.JOptionPane.QUESTION_MESSAGE);

                String str_fine = (String)javax.swing.JOptionPane.showInputDialog(
                        finestra, "alla pagina numero", "seleziona pagina",
                        javax.swing.JOptionPane.QUESTION_MESSAGE);


                try{
                    pagina_inizio=Integer.parseInt(str_inizio);
                    pagina_fine=Integer.parseInt(str_fine);

                }catch(NumberFormatException e){
                    javax.swing.JOptionPane.showMessageDialog(
                            finestra, "Errore: valore immesso non numerico", "errore",
                            javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if(pagina_fine <= pagina_inizio){
                    return;
                }

                PrinterJob pj = PrinterJob.getPrinterJob();
                PageFormat pf = pj.defaultPage();
                Paper paper = new Paper();
    
                double margin = 0; // half inch
                paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2,
                paper.getHeight() - margin * 2);
                pf.setPaper(paper);
                pf.setOrientation(PageFormat.PORTRAIT);

               
                pj.setPrintable(finestra.stampato, pf);

                try {
                    for(int i =pagina_inizio-1;i< pagina_fine;i++){
                        this.seleziona(i);
                        pj.print();
                    }
                    javax.swing.JOptionPane.showMessageDialog(
                        finestra, "Foglio stampato con successo ^_^", "OK!", 
                        javax.swing.JOptionPane.OK_OPTION, 
                        new javax.swing.ImageIcon(
                        getClass().getResource(
                        "/it/esercito/rua/repSup/gestoreProgramma/ballerina.gif")));
                }catch (PrinterException ex) {
                     javax.swing.JOptionPane.showMessageDialog(
                        finestra, "Foglio non stampato", "Errore!", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(FinestraDiStampaVerticaleMultiplaEventi.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                 
            }
        }
    }

    public void pulsanteCerca(ActionEvent evt) {
        if(evt.getSource() instanceof javax.swing.JButton){
            listaDati = finestra.caricaDati();
            intestazione1 = finestra.intestazione()[0];
            intestazione2 = finestra.intestazione()[1];
            this.seleziona(id);
        }
    }
    
    
    protected void inizializzaPagina(int id){
        
    }

     
    protected int pagine(int campi){
        return 0;
    }

    

    
}
