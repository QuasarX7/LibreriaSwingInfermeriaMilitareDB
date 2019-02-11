package it.quasar_x7.infermeria.controllo;

import it.quasar_x7.infermeria.DaseDati.DatiGenerici;
import it.quasar_x7.infermeria.DaseDati.DatiMilitare;
import it.quasar_x7.infermeria.vista.FinestraTabella;
import it.quasar_x7.java.utile.DataOraria;
import it.quasar_x7.java.utile.FileExcel;
import it.quasar_x7.java.utile.Tabella;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import jxl.write.WriteException;

/**
 *
 * @author Dott. Domenico della Peruta
 */
public class FinestraTabellaController {

    DatiGenerici baseDiDati;
    DatiMilitare datiMilitare;
    private Object[][] valoriTabella;
    private String tabellaSelezionata;
    private int RIGHE;
    private int COLONNE;
    
    private final FinestraTabella finestra;
    
    public FinestraTabellaController(FinestraTabella finestra){
        this.finestra = finestra;
        baseDiDati = new DatiGenerici();
        datiMilitare = new DatiMilitare();
        
        
        String nomeTabella = (String) javax.swing.JOptionPane.showInputDialog(
                finestra, 
                "Nome tabella", 
                "seleziona tabella", 
                javax.swing.JOptionPane.QUESTION_MESSAGE, 
                null, new String[] { 
                    "militare", 
                    "reazione_precedente_vaccinazione", 
                    "anamnesi_seduta_vaccinale", 
                    "vaccinazione", 
                    "storia_vaccinale", 
                    "visita", 
                    "ricovero",
                    "modello_gl",
                    "verbale5000"
                }, 
                "militare");
        
        if(nomeTabella!=null){

            String ordina = (String) javax.swing.JOptionPane.showInputDialog(
                    finestra, 
                    "Ordinare per ", 
                    "seleziona colonna", 
                    javax.swing.JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    baseDiDati.attributi(nomeTabella).toArray(), 
                    "militare");  

            if(ordina != null){

                String filtro = (String) javax.swing.JOptionPane.showInputDialog(
                        finestra, 
                        "filtra per ", 
                        "filtro", 
                        javax.swing.JOptionPane.QUESTION_MESSAGE,
                        null,
                        new String[] { "nessuno", "corso", "compagnia", "militare", "corso/compagnia" },
                        "militare");

                if(filtro!=null){

                    if(filtro.compareTo("corso")==0){
                        String corso = (String) JOptionPane.showInputDialog(finestra,
                                "seleziona corso ", "corso",
                                JOptionPane.QUESTION_MESSAGE, null,
                                datiMilitare.corsiPresenti(),
                                "");                        
                        if(!caricaRecordTabella(nomeTabella, ordina, corso)){
                            this.tabellaVuota(nomeTabella);
                        }
                    }else if(filtro.compareTo("compagnia")==0){//filtro compagnia
                        String cp = (String) JOptionPane.showInputDialog(finestra,
                                "seleziona compagnia ", "compagnia",
                                JOptionPane.QUESTION_MESSAGE, null,
                                datiMilitare.compagniePresenti(),
                                "");                        
                        if(!caricaRecordTabella2(nomeTabella, ordina, cp)){
                            this.tabellaVuota(nomeTabella);
                        }
                    }else if(filtro.compareTo("militare")==0){//filtro militare
                        Object[] militare = this.cercaMilitare();
                        if(militare != null){
                            if(!caricaRecordTabella(
                                    nomeTabella,
                                    (String)militare[0],
                                    (String)militare[1],
                                    (DataOraria)militare[2])){

                                this.tabellaVuota(nomeTabella);
                            }
                        }
                    }else if(filtro.compareTo("corso/compagnia")==0){//filtro corso e compagnia
                        String corso = (String) JOptionPane.showInputDialog(finestra,
                                "seleziona corso ", "corso",
                                JOptionPane.QUESTION_MESSAGE, null,
                                datiMilitare.corsiPresenti(),
                                "");
                        String cp = (String) JOptionPane.showInputDialog(finestra,
                                "seleziona compagnia ", "compagnia",
                                JOptionPane.QUESTION_MESSAGE, null,
                                datiMilitare.compagniePresenti(corso),
                                ""); 
                        if(!caricaRecordTabella(nomeTabella, ordina, corso,cp)){
                            this.tabellaVuota(nomeTabella);
                        }
                    }else{
                        //seleziona nessun filtro (ordina solamente)
                        this.caricaRecordTabella(
                                nomeTabella,
                                ordina);
                    }
                }else{
                    this.tabellaVuota(nomeTabella);
                }

            }else{
                this.tabellaVuota(nomeTabella);
            }


        }else{
            this.tabellaVuota(nomeTabella);

        }  
    }
    
    
    
    /**********************************************************
     * Funzione che permette di creare e inizializzare la
     * tabella dei militari accedendo alla DB
     *
     * @return vero se trova i record
     **********************************************************/
    private boolean caricaRecordTabella(String tabella) {

        if(baseDiDati.attributi(tabella) == null){
            return false;
        }
        ArrayList<Object[]> dati = baseDiDati.trovaTabella(tabella);
        if(dati == null){            
            return false;
        }
        return this.caricaTabella(
                dati,
                baseDiDati.attributi(tabella).toArray());
        
    }


    /**********************************************************
     * Funzione che permette di creare e inizializzare la
     * tabella dei militari accedendo alla DB
     *
     * @return vero se trova i record
     **********************************************************/
    private boolean caricaRecordTabella(String tabella,String ordina) {

        if(this.baseDiDati.attributi(tabella)==null){
            return false;
        }
        this.tabellaSelezionata=tabella;
        return this.caricaTabella(
                baseDiDati.trovaTabella(tabella,ordina),
                baseDiDati.attributi(tabella).toArray());

    }

    private boolean caricaRecordTabella(String tabella,String ordina,String corso) {
        if(this.baseDiDati.attributi(tabella)==null){
            return false;
        }
        this.tabellaSelezionata=tabella;
        return this.caricaTabella(
                baseDiDati.filtraTabellaCorso(tabella,ordina,corso),
                baseDiDati.attributi(tabella).toArray());
    }

    private boolean caricaRecordTabella(String tabella,String ordina,String corso,String compagnia) {
        if(this.baseDiDati.attributi(tabella)==null){
            return false;
        }
        this.tabellaSelezionata=tabella;
        return this.caricaTabella(
                baseDiDati.filtraTabellaCorsoCompagnia(tabella,ordina,corso,compagnia),
                baseDiDati.attributi(tabella).toArray());
    }
    
    private boolean caricaRecordTabella(String tabella,String cognome,String nome,DataOraria nato) {
        if(this.baseDiDati.attributi(tabella)==null){
            return false;
        }
        this.tabellaSelezionata=tabella;
        return this.caricaTabella(
                baseDiDati.filtraTabellaPerNominativo(tabella,cognome,nome,nato),
                baseDiDati.attributi(tabella).toArray());
    }
    
    private boolean caricaRecordTabella2(String tabella,String ordina,String cp) {
        if(this.baseDiDati.attributi(tabella)==null){
            return false;
        }
        this.tabellaSelezionata=tabella;
        return this.caricaTabella(
                baseDiDati.filtraTabellaCompagnia(tabella,ordina,cp),
                baseDiDati.attributi(tabella).toArray());
    }

    private boolean caricaTabella(ArrayList<Object[]> tuttiRecord, Object[] colonne){
        if(tuttiRecord!=null){
            RIGHE = tuttiRecord.size();
            COLONNE = tuttiRecord.get(0).length;
        }else
            return false;

        valoriTabella = new Object[RIGHE][COLONNE];

        int i=0;
        for(Object[]x: tuttiRecord){
            System.arraycopy(x, 0, valoriTabella[i++], 0, x.length);
        }
        finestra.tabella.setModel(new javax.swing.table.DefaultTableModel(
            valoriTabella,
            colonne
        ) );
        return true;
    }

    private void tabellaVuota(String nomeTabella){
        finestra.pulsanteFile.setEnabled(false);
        
        finestra.tabella.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {}
        ));
       
        
        javax.swing.JOptionPane.showMessageDialog(
                finestra, ":'(", "avviso!!",
                javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    
    /***********************************************
     * Cerca il record della tabella militare
     * tramite il dialogo con l'utente.
     *
     * @return
     **********************************************/
    private Object[] cercaMilitare(){
        String corsoMilitare = (String) JOptionPane.showInputDialog(
                finestra,
                "seleziona corso ", "corso",
                JOptionPane.QUESTION_MESSAGE, null,
                datiMilitare.corsiPresenti()," "
                );
       if(corsoMilitare == null)
           return null;

        String cognomeMilitare = 
                (String) JOptionPane.showInputDialog("inserisci cognome");
        if(cognomeMilitare==null || ((String)cognomeMilitare).compareTo("")==0)
            return null;

        String nomeMilitare =null;
        Object[] militare = null; 
        if(cognomeMilitare != null){
            ArrayList<Object[]> listaCognomi =
                    datiMilitare.trovaMilitare(cognomeMilitare,corsoMilitare);

            if(listaCognomi!=null){

                if(listaCognomi.size()==1){ // se esiste un solo cognome
                   militare = listaCognomi.get(0);
                }else if(listaCognomi.size()>1){ //se esistono più cognomi uguali
                    String[] nomi = new String[listaCognomi.size()];
                    int i = 0;//cerca i nomi dei militari con lo stesso cognome
                    for(Object[] x :listaCognomi){
                        nomi[i++]= (String)x[1]+"  ("+
                                ((DataOraria)x[2]).stampaGiorno()+")";
                    }
                    //seleziona mome
                    nomeMilitare= (String)JOptionPane.showInputDialog(
                            null,
                            "esistono più militari con lo stesso cognome,\n" +
                            "seleziona nome", "stesso cognome",
                            JOptionPane.QUESTION_MESSAGE, null, nomi, "");

                    i = 0;//definisci l'indice del record
                    for(Object[] x :listaCognomi){
                        if(nomeMilitare.compareTo((String)x[1]+"  ("+
                                ((DataOraria)x[2]).stampaGiorno()+")")==0){
                            break;
                        }
                        i++;
                    }
                    militare = listaCognomi.get(i);
                }
            }else{
            JOptionPane.showMessageDialog(
                         finestra,
                         "Militare non trovato!",
                         "avviso",
                         JOptionPane.WARNING_MESSAGE);
            return null;
           }
        }
        return militare;
    }
    
    public void salvaFileExel(){
        
        File file = null;
        if(valoriTabella != null){
            JFileChooser salvaFile=new  JFileChooser();            
           DataOraria d = new DataOraria(); d.oggi();
            salvaFile.setSelectedFile(new File("tabella "+d.stampaGiorno()));
            
            salvaFile.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File file) {
                        if (file.isDirectory()) {
                            return true;
                        }
                        String estenzione = getEstenzione(file);
                        if (estenzione != null) {
                            if (estenzione.equals("xls")) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                        return false;                    
                    }
                    @Override
                    public String getDescription() {
                        return "File exel (*.xls)"; 
                    }
                });
            
            int risultato = salvaFile.showSaveDialog(finestra);
            
            if(risultato == JFileChooser.APPROVE_OPTION){ 
               
                try {
                    file = salvaFile.getSelectedFile();
                    File f = new File(file.getCanonicalPath()+".xls");  
                    creaFile(f) ;            
                   
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(
                    finestra,
                    "Nessun file creato!",
                    "errore", JOptionPane.ERROR_MESSAGE);
                }
                                
            }
           
        }else{
            JOptionPane.showMessageDialog(
                    finestra,
                    "Nessun tabella selezionata!",
                    "avviso", JOptionPane.WARNING_MESSAGE);
        }     
    }
    
    
     private static String getEstenzione(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
     
     private void creaFile(File f){
        Tabella tab = creaTabellaFile();
        if(tab !=null){
             try {
                FileExcel file = new FileExcel(f);
                file.creaFoglo("elenco");
                for(int i=0;i< tab.colonne();i++){
                    file.dimensionaColonna(i, 20);
                }
                file.carattere(FileExcel.Carattere.ARIAL, FileExcel.Stile.NORMALE, 10, FileExcel.Colore.NERO);
                file.aggiungiSempliceTabella(tab, 0, 2, FileExcel.Carattere.TIMES, 9);

                file.chiudi();
            } catch (WriteException ex) {
                String msg = "";
                if(ex.getMessage().compareTo("The maximum number of rows permitted on a worksheet been exceeded")==0){
                    msg = "nunero eccessivo di record da salvare";
                }else{
                    msg = ex.getMessage();
                }
                JOptionPane.showMessageDialog(
                    finestra,
                    "Nessun file creato:\n"+msg,
                    "errore", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(FinestraTabella.class.getName()).log(Level.SEVERE, null, ex);
            
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(
                    finestra,
                    "Nessun file creato:\n"+ex.getMessage(),
                    "errore", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(FinestraTabella.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } else{             
            JOptionPane.showMessageDialog(
                    finestra,
                    "Nessun file creato!",
                    "errore", JOptionPane.ERROR_MESSAGE);
                
        }                 
    }    
      
     private Tabella creaTabellaFile() {
         if(tabellaSelezionata!= null){
             
             String[] colonne = baseDiDati.attributi(tabellaSelezionata)
                     .toArray(new String[baseDiDati.attributi(tabellaSelezionata).size()]);
             
             String[] righe = new String[valoriTabella.length];
             
             Tabella tabellaF = new Tabella("tabella",colonne,righe);
             for(int c=0; c<colonne.length;c++){
                 for(int r=0; r<valoriTabella.length;r++){
                     if(valoriTabella[r][c]!=null){
                         tabellaF.set(c, r, valoriTabella[r][c]);
                     }
                 }
             }
            return tabellaF;
         }
         return null;
     }
    
}
