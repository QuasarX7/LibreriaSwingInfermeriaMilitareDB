package it.difesa.esercito.rav17.infermeria.controllo;

import it.difesa.esercito.rav17.infermeria.DaseDati.DatiUtente;
import it.difesa.esercito.rav17.infermeria.vista.FinestraGestioneUtenti;
import it.difesa.esercito.rav17.infermeria.vista.RigaSelettiva;
import it.quasar_x7.java.swing.finestra.Finestra;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Dr. Domenico della Peruta
 * @version 1.0.0 ultima modifica
 */
public class FinestraGestioneUtentiController {
    private final DatiUtente datiUtente;

    private final FinestraGestioneUtenti finestra;

    public FinestraGestioneUtentiController(FinestraGestioneUtenti finestra) {
        this.finestra= finestra;
        datiUtente = new DatiUtente();
        
    }
    
    public void salva() {
        for(Component riga :finestra.pannello.getComponents()){
            if(((RigaSelettiva)riga).attivo()){
                datiUtente.modificaLivello(
                        ((RigaSelettiva)riga).etichetta(),
                        ((RigaSelettiva)riga).selezione()
                    );
            }
        }
    }
    
    public void creaLista(){
        finestra.pannello.setLayout(new GridLayout(datiUtente.tuttiUtenti().size(),1));
        ArrayList<String> voci =new ArrayList<String>();
        voci.add(DatiUtente.MEDICO);
        voci.add(DatiUtente.INFERMIERE);
        voci.add(DatiUtente.ASA_VSP);
        voci.add(DatiUtente.ASA_VFP);
        voci.add(DatiUtente.OPERATORE);
        voci.add(DatiUtente.AMMINISTRATORE);
        
        for(String utente: datiUtente.tuttiUtenti()){
            RigaSelettiva riga =new RigaSelettiva(utente,null,voci);
            String livello = datiUtente.livello(utente);
            if(livello != null)
                riga.selezione(livello);
            finestra.pannello.add(riga);
        }
    }

    public void salva(ActionEvent evt) {
        if(evt.getSource() instanceof javax.swing.JButton){
            String livello = datiUtente.livello(Finestra.utente);
            if(livello != null)
                if(livello.compareTo(DatiUtente.AMMINISTRATORE)==0){
                    salva();
                    JOptionPane.showMessageDialog(
                            finestra, "Lista livelli modificata!","avviso",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    return;
                }
            JOptionPane.showMessageDialog(
                    finestra, "Solo l'AMMINISTRATORE può modifivare la lista.","errore",
                    JOptionPane.WARNING_MESSAGE,
                    new ImageIcon(
                        getClass().getResource("/it/quasar_x7/immagini/infermiera_attesa.gif"))

            );
            
        }
    }

    public void elimina(ActionEvent evt) {
        if(evt.getSource() instanceof javax.swing.JButton){
            if(datiUtente.verifica(Finestra.utente, DatiUtente.AMMINISTRATORE)){
                String utente = (String) JOptionPane.showInputDialog(
                        finestra,
                        "seleziona l'utente da ELIMINARE:",
                        "attenzione!",
                        JOptionPane.QUESTION_MESSAGE,
                        new ImageIcon(getClass().getResource("/it/quasar_x7/immagini/infermiera_attesa.gif")),
                        datiUtente.tuttiUtenti().toArray(),
                        null
                );
                if(utente != null){
                    datiUtente.eliminaUtente(utente);
                    javax.swing.JOptionPane.showMessageDialog(
                    null,
                    "Utenti"+utente+" eliminato!",
                    "ERRORE", javax.swing.JOptionPane.WARNING_MESSAGE
                    );
                }
                
            }else{
                javax.swing.JOptionPane.showMessageDialog(
                    null,
                    "solo l'Amministratore puo' eliminare gli utenti. :P ",
                    "ERRORE", javax.swing.JOptionPane.WARNING_MESSAGE,
                    new ImageIcon(
                        getClass().getResource("/it/quasar_x7/immagini/infermiera_attesa.gif")));
            }
        }
    }
    
}
