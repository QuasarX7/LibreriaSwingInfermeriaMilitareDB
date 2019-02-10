package it.difesa.esercito.rav17.infermeria.controllo;

import it.difesa.esercito.rav17.infermeria.DaseDati.DatiMilitare;
import it.difesa.esercito.rav17.infermeria.vista.FinestraDatiIncorporamento;
import it.quasar_x7.java.swing.diagrammi.DiagrammaBarreOrizzontale;
import it.quasar_x7.java.utile.DataOraria;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Ing. Domenico della Peruta
 * @version 1.0.0 ultima modifica 14/03/2014
 */
public class FinestraDatiIncorporamentoController {
    
    private final DatiMilitare baseDiDati;
    private int RIGHE;
    private final int COLONNE = 3;
    private Object[][] valoriTabella;
    DiagrammaBarreOrizzontale diagramma = null;
    
    private final FinestraDatiIncorporamento finestra;
    
    private final javax.swing.JComboBox selezionaCorso;
    private final javax.swing.JPanel sfondoDiagramma;
    private final javax.swing.JTable tabella;
    private final javax.swing.JLabel totale;

    public FinestraDatiIncorporamentoController(
            FinestraDatiIncorporamento finestra,
            JComboBox selezionaCorso,
            JPanel sfondoDiagramma,
            JTable tabella,JLabel totale) {
        
        
            this.selezionaCorso = selezionaCorso;
            this.sfondoDiagramma = sfondoDiagramma;
            this.tabella=tabella;
            this.totale=totale;
    
        this.finestra = finestra;
        baseDiDati = new DatiMilitare();
        this.selezionaCorso.setModel(
                new javax.swing.DefaultComboBoxModel(
                    this.baseDiDati.corsiPresenti()
                )
        );
    }
    
    /**********************************************************
     * Funzione che permette di creare e inizializzare la
     * tabella dei militari accedendo alla DB
     *
     **********************************************************/
    public void caricaTabella() {        
        if(this.selezionaCorso.getSelectedIndex()>=0){
            if(diagramma != null)
                diagramma.svuota();
            sfondoDiagramma.removeAll();
            sfondoDiagramma.repaint();
            diagramma = new DiagrammaBarreOrizzontale(
                "incorporamento", "","n° visitati", true);        
        
        
            ArrayList<Object[]> militari_visitati = 
                    this.baseDiDati.situazioneIncorporamento(
                    (String)this.selezionaCorso.getSelectedItem());
            if(militari_visitati != null){
                if(militari_visitati.size() > 0){
                    RIGHE = militari_visitati.size();
                }else{
                    javax.swing.JOptionPane.showMessageDialog(finestra, "militare visitato presente",
                            "avviso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }
                valoriTabella = new Object[RIGHE][COLONNE];

                long nTotale=0;
                int i=0;
                for(Object[]x: militari_visitati){
                    if(x[0]!=null){
                        valoriTabella[i][0] =
                                ((DataOraria)x[0]).stampaGiorno()
                                +" ["+((DataOraria)x[0]).stampaGiornoSettimana()+"]";
                        valoriTabella[i][1] = (String)x[1];
                        valoriTabella[i][2] = (Long)x[2];
                        if((Long)x[2]>5)
                            diagramma.caricaDati(((DataOraria)x[0]).stampaGiorno(),(String)x[1], (Long)x[2]);
                        
                        nTotale += (Long)x[2];
                    }
                    i++;
                }
                
                javax.swing.JPanel pDiagramma = diagramma.creaPannello();
                pDiagramma.setSize(sfondoDiagramma.getWidth(), sfondoDiagramma.getHeight());
                this.sfondoDiagramma.add(pDiagramma);                
                
                this.totale.setText("Incorporati:"+nTotale);
                this.tabella.setModel(new javax.swing.table.DefaultTableModel(

                    valoriTabella,
                    new String [] {
                        "data","compagnia", "visitati"
                    }
                ) {
                    Class[] types = new Class [] {
                        java.lang.String.class,java.lang.String.class, java.lang.Integer.class
                    };
                    boolean[] canEdit = new boolean [] {
                        false, false, false
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
                
                
                
            }else{
                javax.swing.JOptionPane.showMessageDialog(finestra,
                        "nessuna attivita' registrata",
                    "avviso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                tabella.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {
                        {},
                        {},
                        {},
                        {}
                    },
                    new String [] {

                    }
                ));
            }
            
        }else{
            javax.swing.JOptionPane.showMessageDialog(finestra, "data incompleta",
                    "errore", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
       
    }
    
}
