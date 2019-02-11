package it.quasar_x7.infermeria.controllo;

import it.quasar_x7.infermeria.DaseDati.DatiMilitare;
import it.quasar_x7.infermeria.vista.FinestraElencoSelezioneMilitari;
import it.quasar_x7.java.swing.finestra.Finestra;
import it.quasar_x7.java.swing.stampa.FinestraStampatiVerticali;
import it.quasar_x7.java.utile.DataOraria;
import java.util.ArrayList;

/**
 *
 * @author Dr. Domenico della Peruta
 */
public class FinestraElencoSelezioneMilitariController {
    
    private int RIGHE = 0;
    private final int COLONNE = 5;
    private DatiMilitare dati;

    ArrayList<Object[]> militari;
    private Object[][] valoriTabella;
    private final FinestraElencoSelezioneMilitari finestra;
            
    public FinestraElencoSelezioneMilitariController(FinestraElencoSelezioneMilitari finestra,String corso) {
        this.finestra = finestra;
        dati = new DatiMilitare();
        militari = dati.tuttiMilitari(corso);
        caricaTabella();
        
    }
    
    private boolean caricaTabella() {

        
        
        if(militari !=null){
            RIGHE = militari.size();
        }else
            return false;

        valoriTabella = new Object[RIGHE][COLONNE];

        int i=0;
        for(Object[] riga: militari){
            valoriTabella[i][0] = (String)riga[it.quasar_x7.infermeria.DaseDati.BASE_DATI.MILITARE.COGNOME];
            valoriTabella[i][1] = (String)riga[it.quasar_x7.infermeria.DaseDati.BASE_DATI.MILITARE.NOME];
            valoriTabella[i][2] = ((DataOraria)riga[it.quasar_x7.infermeria.DaseDati.BASE_DATI.MILITARE.DATA_NASCITA]).stampaGiorno('/');
            valoriTabella[i][3] = (String)riga[it.quasar_x7.infermeria.DaseDati.BASE_DATI.MILITARE.COMPAGNIA];
            valoriTabella[i][4] = false;//new JCheckBox();
            i++;
        }

        finestra.tabella.setModel(new javax.swing.table.DefaultTableModel(
            valoriTabella,
            new String [] {
                "cognome", "nome", "nascita", "compagnia", "seleziona"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        finestra.bordiScorrevoli.setViewportView(finestra.tabella);
        if (finestra.tabella.getColumnModel().getColumnCount() > 0) {
            finestra.tabella.getColumnModel().getColumn(0).setPreferredWidth(100);
            finestra.tabella.getColumnModel().getColumn(1).setPreferredWidth(100);
            finestra.tabella.getColumnModel().getColumn(2).setPreferredWidth(50);
            finestra.tabella.getColumnModel().getColumn(3).setResizable(false);
            finestra.tabella.getColumnModel().getColumn(3).setPreferredWidth(60);
            finestra.tabella.getColumnModel().getColumn(4).setPreferredWidth(20);
        }
        
        return true;
    }

    public void seleziona() {
        ArrayList<Object[]> selezione = new ArrayList();
        
       for(int riga=0; riga < RIGHE;riga++){
           if(((Boolean)finestra.tabella.getValueAt(riga, 4))){
               selezione.add(militari.get(riga));
           }
       } 
       if(selezione.size() > 0){
           FinestraStampatiVerticali finestraStampato = new FinestraStampatiVerticali();
           for (Object[] militare : selezione) {
                Report.aggiungiReportAllegatoLibMilitare(finestraStampato, militare);
            }
            Finestra.spegniAltreFinestre(finestraStampato);
       }
    }
    
}
