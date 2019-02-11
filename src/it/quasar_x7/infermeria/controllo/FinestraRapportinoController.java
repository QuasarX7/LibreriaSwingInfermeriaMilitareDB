package it.quasar_x7.infermeria.controllo;

import it.quasar_x7.infermeria.DaseDati.DatiMilitare;
import it.quasar_x7.infermeria.DaseDati.DatiRicovero;
import it.quasar_x7.infermeria.DaseDati.DatiVaccinazioni;
import it.quasar_x7.infermeria.DaseDati.DatiVerbaleVisita;
import it.quasar_x7.infermeria.DaseDati.DatiVisita;
import it.quasar_x7.infermeria.vista.FinestraRapportino;
import it.quasar_x7.java.BaseDati.EccezioneBaseDati;
import it.quasar_x7.java.utile.DataOraria;
import it.quasar_x7.java.utile.FileExcel;
import it.quasar_x7.java.utile.Tabella;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import jxl.write.WriteException;

/**
 *
 * @author Dr. Domenico della Peruta
 * @version 1.0.0 ultima modifica 24/04/2016
 */
public class FinestraRapportinoController {
    
    private Object[][] valoriTabella;
    private final DatiMilitare datiMilitare;
    private final DatiVaccinazioni datiVaccinazioni;
    private final DatiVisita datiVisita;
    private final DatiRicovero datiRicovero;
    private final DatiVerbaleVisita datiML;
    private String[] intestazioneTab;
    private final FinestraRapportino finestra;
    private  DataOraria data;

    public FinestraRapportinoController(FinestraRapportino finestra) {
        this.finestra=finestra;
        datiRicovero = new DatiRicovero();//eliminaaaaa
        datiMilitare = new DatiMilitare();
        datiVisita = new DatiVisita();
        datiVaccinazioni = new DatiVaccinazioni();
        datiML = new DatiVerbaleVisita();
        DataOraria oggi = new DataOraria();
        oggi.oggi();
        finestra.campoData.setDate(oggi.convertiDate());
        inizializzaTabella();
        creaTabella();
    }
    
    public void salvaFileExel(DataOraria d){
        data = d;
        File file = null;
        if(valoriTabella != null){
            JFileChooser salvaFile=new  JFileChooser(); 
            salvaFile.setSelectedFile(new File("rapportino "+d.stampaGiorno()));
            
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
                file.creaFoglo("rapportino");
                file.dimensionaColonna(0, 60);
                
                file.aggiungiCella("RAPPORTINO GIORNALIERO DELL' INFERMERIA - "+data.stampaGiornoRidotto('/'), 0, 0);
                
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
                Logger.getLogger(FinestraRapportino.class.getName()).log(Level.SEVERE, null, ex);
            
            } catch (java.io.IOException ex) {
                JOptionPane.showMessageDialog(
                    finestra,
                    "Nessun file creato:\n"+ex.getMessage(),
                    "errore", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(FinestraRapportino.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } else{             
            JOptionPane.showMessageDialog(
                    finestra,
                    "Nessun file creato!",
                    "errore", JOptionPane.ERROR_MESSAGE);
                
        }                 
    }    
    
    private Tabella creaTabellaFile() {
         if(valoriTabella!= null){
             
             String[] colonne = this.intestazioneTab;
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
    
    public void creaTabella(){
        intestazioneTab=new String [] {
                "Attività", "n°"
        };
        finestra.tabellaAttivitaGiornaliera.setModel(new javax.swing.table.DefaultTableModel(
            valoriTabella,
            intestazioneTab
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        finestra.jScrollPane2.setViewportView(finestra.tabellaAttivitaGiornaliera);
        if (finestra.tabellaAttivitaGiornaliera.getColumnModel().getColumnCount() > 0) {
            finestra.tabellaAttivitaGiornaliera.getColumnModel().getColumn(0).setResizable(false);
            finestra.tabellaAttivitaGiornaliera.getColumnModel().getColumn(0).setPreferredWidth(1000);
            finestra.tabellaAttivitaGiornaliera.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(finestra.jPanel3);
        finestra.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(finestra.jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(finestra.jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

    }
    public void inizializzaTabella(){
        valoriTabella = new Object [][] {
            {"CHIEDENTI VISITA MATTINALE", null}, // ok
            {"RICOVERATI", null}, // ok
            {"DLT / INFORTUNI", null}, //ok
            {"RIENTRO DA MALATTIA / LIC. CONVALESCENZA", null}, // ok
            {"INVIO IN MALATTIA", null},  // ok
            {"INVIO IN CMO", null}, // ok
            {"CONVALESCENZA", null}, // ok
            {"PS / VISITE AMBULATORIALI", null},// ok
            {"VISITE PERIODICHE", null}, // ok
            {"INVIO IN VISITE SPECIALISTICHE", null}, // ok
            {"INVIO IN LABORATORIO PER ESAMI EMATICI", null}, // ok
            {"PRATICHE MEDICO LEGALI / 5000", null}, // ok
            {"INVIO IN OSSERVAZIONE", null}, // ok
            {"DRUG TEST", null}, // ok
            {"VACCINAZIONI", null}, // ok
            {"VISITE DI INCORPORAMENTO", null}, // ok
            {"ATTIVITA' ADDESTRATIVE / ASSISTENZA SANITARIA", null},
            {"ACCESSO A PRONTO SOCCORSO S.S.N.", null}
        };
    }
    public void aggiornaTabella(){
        try {
            if(finestra.campoData.getDate() != null){
                DataOraria data = new DataOraria(finestra.campoData.getDate());
                valoriTabella[0][1] = datiVisita.numeroVisite("CHIEDENTI VISITA", data);
                valoriTabella[1][1] = datiRicovero.numeroRicoverati(data);
                valoriTabella[2][1] = datiVisita.numeroVisitaDLT(data);
                valoriTabella[3][1] = datiML.numeroRientriMalatticaConv("", data);
                valoriTabella[4][1] = datiML.numeroInviiMalattia(data);
                valoriTabella[5][1] = datiML.numeroInviiCMO(data);
                valoriTabella[6][1] = datiML.numeroInviiConvalesenza(data);
                valoriTabella[7][1] = datiVisita.numeroVisite("PRONTO SOCCORSO", data); 
                valoriTabella[8][1] = datiML.numeroVisitePeriodiche(data);
                valoriTabella[9][1] = ""; // v. specialistiche
                valoriTabella[10][1] = ""; // v. lab. esame ematico
                valoriTabella[11][1] = datiML.numeroVerbali("", data);
                valoriTabella[12][1] = datiML.numeroInviiOsservazione(data);
                valoriTabella[13][1] = ""; // drug test
                valoriTabella[14][1] = datiVaccinazioni.numeroVaccinati("", data);
                valoriTabella[15][1] = datiMilitare.numeroVisiteIncorporo("",data);
                valoriTabella[16][1] = "";
                valoriTabella[17][1] = "";
                
            }
                
                
            } catch (EccezioneBaseDati ex) {
                Logger.getLogger(FinestraRapportino.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    
    
}
