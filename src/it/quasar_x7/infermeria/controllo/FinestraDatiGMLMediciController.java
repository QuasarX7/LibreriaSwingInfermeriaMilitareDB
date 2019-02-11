
package it.quasar_x7.infermeria.controllo;

import com.toedter.calendar.JDateChooser;

import it.quasar_x7.infermeria.DaseDati.DatiMilitare;
import it.quasar_x7.infermeria.vista.FinestraDatiGMLMedici;
import it.quasar_x7.java.swing.diagrammi.Diagramma;
import it.quasar_x7.java.swing.diagrammi.DiagrammaBarre;
import it.quasar_x7.java.swing.diagrammi.DiagrammaBarreOrizzontale;
import it.quasar_x7.java.utile.DataOraria;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Ing. Domenico della Peruta
 * @version 1.0.0 ultima modifica 14/03/2015
 */
public class FinestraDatiGMLMediciController {
    
    private final FinestraDatiGMLMedici finestra;
    private final JPanel sfondoDiagramma;
    private final JTable tabella;
    private final JDateChooser campoDataFine;
    private final JDateChooser campoDataInizio;

    private final DatiMilitare baseDiDati;
    private int RIGHE;
    private final int COLONNE = 2;
    private Object[][] valoriTabella;
    
        
    private Diagramma diagramma = null;
    
    public FinestraDatiGMLMediciController(
            FinestraDatiGMLMedici finestra,JPanel sfondoDiagramma,JTable tabella,
            JDateChooser campoDataInizio,JDateChooser campoDataFine) {
        this.campoDataFine = campoDataFine;
        this.campoDataInizio = campoDataInizio;
        this.finestra = finestra;
        this.tabella =tabella;
        this.sfondoDiagramma = sfondoDiagramma;
        baseDiDati = new DatiMilitare();
    }
    
    public void diagramma(ArrayList<Object[]> v){
        
        diagramma = new DiagrammaBarreOrizzontale(
                "visite medici", "medici","n° visite mediche", true);
        
        if(v!= null)
            for(Object[] record: v){
                if(record[0] != null && record[1] != null )
                    ((DiagrammaBarre)diagramma).caricaDati(                    
                            "", 
                            (String)record[0], 
                            (Number)record[1]);           
            }
        javax.swing.JPanel pDiagramma = diagramma.creaPannello();
        pDiagramma.setSize(sfondoDiagramma.getWidth(), sfondoDiagramma.getHeight());
        sfondoDiagramma.add(pDiagramma);
        
        
        
    }

    public void svuotaTabella(){
        if(diagramma != null)
            ((DiagrammaBarre)diagramma).svuota();
        sfondoDiagramma.removeAll();
        sfondoDiagramma.repaint();
        tabella.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null,  null},
                {null,  null},
                {null,  null},
                {null,  null}
            },
            new String [] {
                "medico",  "numero"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class,  java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }
    /**********************************************************
     * Funzione che permette di creare e inizializzare la
     * tabella dei militari accedendo alla DB
     *
     * 
     **********************************************************/
    public void caricaTabella() {
        
        this.svuotaTabella();
        
        if(this.campoDataFine.getDate()!=null && this.campoDataInizio.getDate()!=null){
            
            DataOraria inizio = new DataOraria(this.campoDataInizio.getDate());
            DataOraria fine = new DataOraria(this.campoDataFine.getDate());
            
            ArrayList<Object[]> tuttiRecord =
                    baseDiDati.situazioneMedici(inizio,fine);

            if(tuttiRecord != null){
                if(tuttiRecord.size() > 0){
                    RIGHE = tuttiRecord.size();
                    diagramma(tuttiRecord);
                }else{
                    javax.swing.JOptionPane.showMessageDialog(finestra, "nessuna attività presente",
                            "avviso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    this.svuotaTabella();
                    return;
                }
            }else{
                javax.swing.JOptionPane.showMessageDialog(finestra, "nessuna attività presente",
                            "avviso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    this.svuotaTabella();
                    return;
            }
            valoriTabella = new Object[RIGHE][COLONNE];

            int i=0;
            for(Object[]x: tuttiRecord){
                valoriTabella[i][0] = (String)x[0];
                valoriTabella[i][1] = (Long)x[1];
                i++;
            }

            this.tabella.setModel(new javax.swing.table.DefaultTableModel(

                valoriTabella,
                new String [] {
                    "medico",  "numero"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Integer.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            tabella.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabella.getColumnModel().getColumn(1).setPreferredWidth(10);
        }else{
            javax.swing.JOptionPane.showMessageDialog(finestra, "data incompleta",
                    "errore", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
