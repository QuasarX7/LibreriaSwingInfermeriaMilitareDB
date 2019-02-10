package it.quasar_x7.java.swing.stampa;


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
 * @author Dr. Domenico della Peruta
 * @version 1.0.1 11/04/16
 */
public class FinestraDiStampaOrizzontaleMultiplaEventiController {

    private final int N_RIGHE = 40;
    
    
    private String intestazione1 = "";
    private String intestazione2 = "";
    private ArrayList<Object[]> listaDati;
    public String[] nomiColonne;
    public int[] dimColonne;
    private int id = 0;
    protected final FinestraDiStampaOrizzontaleMultiplaEventi finestra;
    
    
    public FinestraDiStampaOrizzontaleMultiplaEventiController(FinestraDiStampaOrizzontaleMultiplaEventi finestra) {
        this.finestra = finestra;
        //impostazioni = new DatiImpostazioni();
    }
    
    
    
    
    protected String intestazione(){
        
        String titolo = "";
        titolo += Stampato.titolo(intestazione1,7);
        titolo += Stampato.titolo(intestazione2,6);
        titolo += Stampato.titolo(" ",8);
        titolo += Stampato.titolo(" ",8);
        return titolo;
    }
    
    private void seleziona(int id){        
        if(listaDati !=null){
            finestra.getStampato().cancella();
            
            finestra.getStampato().aggiungiBlocco(intestazione());
            finestra.getCampoIndice().setText(String.valueOf((id+1)+" di "+this.pagine(listaDati.size())));

            
            Object[][] tabella = new Object[N_RIGHE+1][];
            
            if(nomiColonne != null)
                tabella[0]= nomiColonne;
            
            for(int i=0; i < N_RIGHE && i+N_RIGHE*(id) < listaDati.size();i++){
                tabella[i+1] = correggi(listaDati.get(i+N_RIGHE*(id)));
            }
          
            if(dimColonne != null)
                finestra.getStampato().aggiungiTabella(tabella, "Times", 5, false, Stampato.ALL_SINISTRA  , dimColonne,false);

        }else{
            JOptionPane.showMessageDialog(
                    finestra,
                    "Nessun evento presente!",
                    "avviso", JOptionPane.WARNING_MESSAGE);
            finestra.setVisible(false);
        }
    }

    private Object[] correggi(Object[] input){
        Object[] output = new Object[input.length];
        for(int i=0; i < input.length ; i++){
            if(input[i] != null){
                int p = input[i].toString().indexOf("\n");
                output[i] = p > 0 ? input[i].toString().substring(0,p) : input[i] ;
            }
        }
        return output;
    }
    
    private int pagine(int campi){
        if(campi%N_RIGHE ==0)
            return campi/N_RIGHE;
        return campi/N_RIGHE+1;
    }

    public void stampa(ActionEvent evt) {
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
                pf.setOrientation(PageFormat.LANDSCAPE);

               
                pj.setPrintable(finestra.getStampato(), pf);

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
                    Logger.getLogger(FinestraDiStampaOrizzontaleMultiplaEventi.class.getName()).log(Level.SEVERE, null, ex);
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

    public void stampaTuttePagine(ActionEvent evt) {
        
        if(evt.getSource() instanceof javax.swing.JButton){
            if(listaDati!=null){
                
                
                PrinterJob pj = PrinterJob.getPrinterJob();
                PageFormat pf = pj.defaultPage();
                Paper paper = new Paper();
    
                double margin = 0; // half inch
                paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2,
                paper.getHeight() - margin * 2);
                pf.setPaper(paper);
                pf.setOrientation(PageFormat.LANDSCAPE);

               
                pj.setPrintable(finestra.getStampato(), pf);

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
                        "/it/quasar_x7/immagini/ballerina.gif")));
                }catch (PrinterException ex) {
                     javax.swing.JOptionPane.showMessageDialog(
                        finestra, "Foglio non stampato", "Errore!", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(FinestraDiStampaOrizzontaleMultiplaEventi.class.getName()).log(Level.SEVERE, null, ex);
                }
                
             
            }
            
        }
    }

    public void stampaPagine(ActionEvent evt) {
        
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
                pf.setOrientation(PageFormat.LANDSCAPE);

               
                pj.setPrintable(finestra.getStampato(), pf);

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
                        "/it/quasar_x7/immagini/ballerina.gif")));
                }catch (PrinterException ex) {
                     javax.swing.JOptionPane.showMessageDialog(
                        finestra, "Foglio non stampato", "Errore!", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(FinestraDiStampaOrizzontaleMultiplaEventi.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                 
            }
        }
    }

    /**
     * Metodo che carica i dati provenienti dalla finestra.
     *  
     */
    public void cerca() {
            listaDati = finestra.caricaDati();
            intestazione1 = finestra.intestazione()[0];
            intestazione2 = finestra.intestazione()[1];
            this.seleziona(id);
    }
    
  
}
