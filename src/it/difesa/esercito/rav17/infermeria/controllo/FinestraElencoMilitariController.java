package it.difesa.esercito.rav17.infermeria.controllo;

import it.quasar_x7.java.swing.finestra.Finestra;
import it.difesa.esercito.rav17.infermeria.DaseDati.DatiMilitare;
import it.difesa.esercito.rav17.infermeria.DaseDati.DatiUtente;
import it.difesa.esercito.rav17.infermeria.vista.FinestraElencoMilitari;
import it.difesa.esercito.rav17.infermeria.vista.FinestraModificaMilitare;
import it.quasar_x7.java.utile.DataOraria;
import it.quasar_x7.java.utile.Errore;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Dr. Domenico della Peruta
 * @version 1.0.0 ultima modifica 28/09/2016
 */
public class FinestraElencoMilitariController {
    private final FinestraElencoMilitari finestra;
    public static boolean modifica = false;
    private int RIGHE = 0;
    private final int COLONNE=5;
    private final DatiMilitare baseDiDati;
    private Object[][] valoriTabella;
    private Object[] nominativo;

    

    


    public FinestraElencoMilitariController(FinestraElencoMilitari finestra) {
        this.finestra = finestra;
        baseDiDati = new DatiMilitare();
        caricaTabella(finestra.getCampoTrova().getText() );
    }
    
    
    /**********************************************************
     * Funzione che permette di creare e inizializzare la
     * tabella dei militari accedendo alla DB
     *
     * @param ricercaCognome
     * @return vero se trova i record
     **********************************************************/
    public boolean caricaTabella(String ricercaCognome) {
        if(ricercaCognome.length() < 2) {
            this.tabella(null);
            return false;
        }
        ArrayList<Object[]> tuttiRecord =
                baseDiDati.tuttiMilitariSimili(ricercaCognome);
        if(tuttiRecord!=null){
            RIGHE = tuttiRecord.size();
        }else {
            return false;
        }

        valoriTabella = new Object[RIGHE][COLONNE];

        int i=0;
        for(Object[]x: tuttiRecord){
            valoriTabella[i][0] = (String)x[24];
            valoriTabella[i][2] = (String)x[0];
            valoriTabella[i][3] = (String)x[1];
            valoriTabella[i][4] = ((DataOraria)x[2]).stampaGiorno();
            valoriTabella[i++][1] = (String)x[6];
        }

        this.tabella(valoriTabella);
        return true;
    }
    
    private void tabella(Object[][] tabella){
        this.finestra.getElencoMilitari().setModel(new javax.swing.table.DefaultTableModel(
            tabella,
            new String [] {
                "CORSO","CP/RGT", "COGNOME", "NOME", "DATA DI NASCITA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class,java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
    
    /*********************************************
     * Restituisce il nominativo del militare 
     * selezionato 
     * 
     * @return
     *********************************************/
    public Object[] seleziona(){
        return nominativo;
    }

    public void pulsanteElimina(ActionEvent evt) {
        if(evt.getSource() instanceof javax.swing.JButton){
           
            
            if(new DatiUtente().verifica(Finestra.utente, DatiUtente.AMMINISTRATORE)){
                if(this.finestra.getElencoMilitari()!=null && (this.finestra.getElencoMilitari().getSelectedRow() > -1)){
                    String cognome =
                            (String)valoriTabella[this.finestra.getElencoMilitari().getSelectedRow()][2];
                    String nome =
                            (String)valoriTabella[this.finestra.getElencoMilitari().getSelectedRow()][3];
                    String dataNascita =
                            (String)valoriTabella[this.finestra.getElencoMilitari().getSelectedRow()][4];

                    if(JOptionPane.showConfirmDialog(
                            finestra,
                            "elimina: \""+cognome+" "+nome+" "+dataNascita+"\"",
                            "attenzione!",
                            JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION){

                        this.baseDiDati.eliminaMilitare(cognome,nome,dataNascita);
                        caricaTabella(this.finestra.getCampoTrova().getText());

                    }

                }
            }else{
                javax.swing.JOptionPane.showMessageDialog(
                        null, 
                        "Utente non autorizzato!!",
                        ":P", javax.swing.JOptionPane.WARNING_MESSAGE, 
                        new ImageIcon(
                        getClass().getResource("/it/quasar_x7/immagini/infermiera_attesa.gif")));
            }
            
        }
    }

    public void pulsanteModifica(ActionEvent evt) {
        if(evt.getSource() instanceof javax.swing.JButton){
            if(this.finestra.getElencoMilitari()!=null && (this.finestra.getElencoMilitari().getSelectedRow()>-1)){
                final String cognome =
                        (String)valoriTabella[this.finestra.getElencoMilitari().getSelectedRow()][2];
                final String nome =
                        (String)valoriTabella[this.finestra.getElencoMilitari().getSelectedRow()][3];
                final String dataNascita =
                        (String)valoriTabella[this.finestra.getElencoMilitari().getSelectedRow()][4];

                 if(dataNascita!=null){
                     try {
                        Finestra.creaFinestra(new FinestraModificaMilitare(cognome,nome,new DataOraria(dataNascita)));
                     } catch (Errore  ex) {
                                 javax.swing.JOptionPane.showMessageDialog(
                                         null,"errore formato data di nascita '"+dataNascita+"'", 
                                         "errore", javax.swing.JOptionPane.ERROR_MESSAGE);
                                 Logger.getLogger(FinestraElencoMilitari.class.getName()).log(Level.SEVERE, null, ex);
                             }  catch (java.lang.NullPointerException e){
                                 javax.swing.JOptionPane.showMessageDialog(
                                         null,"impossibile eliminare il militare\n"
                                         + "'"+cognome+"' "
                                         + "'"+nome+"' "
                                         + "'"+dataNascita+"'", 
                                         "errore", javax.swing.JOptionPane.ERROR_MESSAGE);
                            }
                     

                }

            }
        }
    }

    public void mouseTabella(MouseEvent evt) {
        if(evt.getSource() instanceof javax.swing.JTable){
            if(modifica){
                caricaTabella(this.finestra.getCampoTrova().getText());
                modifica = false;
            }
        }
    }

    public void ricercaCampoTrova(KeyEvent evt) {
        if(evt.getSource() instanceof javax.swing.JTextField){
            caricaTabella(this.finestra.getCampoTrova().getText());
        }
    }

    
    
}
