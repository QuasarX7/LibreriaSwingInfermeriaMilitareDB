package it.quasar_x7.infermeria.controllo;

import it.quasar_x7.infermeria.DaseDati.DatiMilitare;
import it.quasar_x7.infermeria.DaseDati.DatiRicovero;
import it.quasar_x7.infermeria.DaseDati.DatiStoriaVaccinale;
import it.quasar_x7.infermeria.DaseDati.DatiVaccinazioni;
import it.quasar_x7.infermeria.DaseDati.DatiVisita;
import it.quasar_x7.infermeria.vista.FinestraModificaMilitare;
import it.quasar_x7.java.BaseDati.EccezioneBaseDati;
import it.quasar_x7.java.utile.DataOraria;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dr. Domenico della Peruta
 */
public class FinestraModificaMilitareController {
    
    private final FinestraModificaMilitare finestra;
    
    private final DatiRicovero datiRicovero;
    private final DatiVisita datiVisita;
    private final DatiMilitare datiMilitare;
    private final DatiVaccinazioni datiVaccinazioni;
    private final DatiStoriaVaccinale datiStoriaVaccinale;
    //valiri chiave della tabella militare
    private String nomeMilitare,cognomeMilitare;
    private DataOraria nascitaMilitare;

    public FinestraModificaMilitareController(FinestraModificaMilitare finestra,String cognome,String nome,DataOraria dataNascita) {
        this.finestra = finestra;
        //connessione alla BD
        datiRicovero = new DatiRicovero();
        datiVisita = new DatiVisita();
        datiVaccinazioni = new DatiVaccinazioni();
        datiMilitare = new DatiMilitare();
        datiStoriaVaccinale = new DatiStoriaVaccinale();
        this.finestra.valoreCorso.setModel(
                new javax.swing.DefaultComboBoxModel(
                datiMilitare.corsiPresenti()));
        caricaMilitare(cognome,nome,dataNascita);
        String valoreInizCpRgt = this.finestra.valoreCpRgt.getSelectedItem().toString();
        this.finestra.valoreCpRgt.setModel(
                new javax.swing.DefaultComboBoxModel(
                    datiMilitare.compagniePresenti(this.finestra.valoreCorso.getSelectedItem().toString())
                )
        );
        this.finestra.valoreCpRgt.setSelectedItem(valoreInizCpRgt);
    }
    
    private void caricaMilitare(String cognome, String nome, DataOraria dataNascita) {

        Object[] militare =  datiMilitare.trovaMilitare(cognome, nome, dataNascita);
        
         cognomeMilitare =  (String) militare[0];
         nomeMilitare = (String) militare[1];
         nascitaMilitare = (DataOraria) militare[2];

        //inizializza i campi della maschera
        this.finestra.testoCognome.setText((String) militare[0]);
        this.finestra.testoNome.setText((String) militare[1]);
       
        this.finestra.valoreDataNascita.carica(
                ((DataOraria)militare[2]).giornoMese(),
                ((DataOraria)militare[2]).mese(),
                ((DataOraria)militare[2]).anno());

        this.finestra.testoLuogo.setText((String)militare[3]);
        this.finestra.testoGrado.setText((String)militare[4]);
        this.finestra.valoreCpRgt.setSelectedItem((String)militare[6]);
        this.finestra.valoreCorso.setSelectedItem((String)militare[24]);
        this.finestra.valoreSesso.setSelectedItem((String)militare[30]);

    }

    public void pulsanteModifica(ActionEvent evt) {
    
        if(evt.getSource() instanceof javax.swing.JButton){
                if(!this.finestra.valoreDataNascita.erroreCampo()){
                // raccolta dei dati (militare) contenuti nelle caselle della maschera
                Object[] militare = new Object[datiMilitare.dimensioneMilitate()];
                militare[1] = finestra.testoNome.getText();
                militare[0] = finestra.testoCognome.getText();
                militare[2] = finestra.valoreDataNascita.valore();
                militare[3] = finestra.testoLuogo.getText();
                militare[4] = finestra.testoGrado.getText();
                militare[6] = (String)finestra.valoreCpRgt.getSelectedItem();
                militare[24]= (String)finestra.valoreCorso.getSelectedItem();   
                militare[30]= (String)finestra.valoreSesso.getSelectedItem(); 
               //modifica il record (del militare) coi i dati di misurazione
                datiMilitare.modificaMilitare(cognomeMilitare, nomeMilitare, nascitaMilitare, militare);
                
                Object[] storico = new Object[132];
                storico[1] = finestra.testoNome.getText();
                storico[0] = finestra.testoCognome.getText();
                storico[2] = finestra.valoreDataNascita.valore();
                try {
                    datiStoriaVaccinale.modificaStoriaVaccinale(cognomeMilitare, nomeMilitare, nascitaMilitare, storico);
                } catch (EccezioneBaseDati ex) {
                    Logger.getLogger(FinestraModificaMilitare.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                Object[] vaccinazione = new Object[datiVaccinazioni.dimensioneVaccinazioni()];
                vaccinazione[3] = finestra.testoNome.getText();
                vaccinazione[2] = finestra.testoCognome.getText();
                vaccinazione[4] = finestra.valoreDataNascita.valore();
                datiVaccinazioni.modificaVaccinazioni(cognomeMilitare, nomeMilitare, nascitaMilitare, vaccinazione);

                Object[] anamnesiSedutaVaccinale = new Object[datiVaccinazioni.dimensioneSedutaVaccinale()];
                anamnesiSedutaVaccinale[1] = finestra.testoNome.getText();
                anamnesiSedutaVaccinale[0] = finestra.testoCognome.getText();
                anamnesiSedutaVaccinale[2] = finestra.valoreDataNascita.valore();
                datiVaccinazioni.modificaAnamnesiVaccinale(cognomeMilitare, nomeMilitare, nascitaMilitare, anamnesiSedutaVaccinale);
                
                Object[] anamnesiReazioneVaccinale = new Object[datiVaccinazioni.dimensioneReazioniVaccinali()];
                anamnesiReazioneVaccinale[1] = finestra.testoNome.getText();
                anamnesiReazioneVaccinale[0] = finestra.testoCognome.getText();
                anamnesiReazioneVaccinale[2] = finestra.valoreDataNascita.valore();
                datiVaccinazioni.modificaAnamnesiReazioneVaccinale(cognomeMilitare, nomeMilitare, nascitaMilitare, anamnesiReazioneVaccinale);
                
                Object[] visitaMedica = new Object[datiVisita.dimensioneVisita()];
                visitaMedica[3] = finestra.testoNome.getText();
                visitaMedica[2] = finestra.testoCognome.getText();
                visitaMedica[4] = finestra.valoreDataNascita.valore();
                datiVisita.modificaVisitaMedica(cognomeMilitare, nomeMilitare, nascitaMilitare, visitaMedica);
                
                Object[] ricovero = new Object[datiRicovero.dimensioneRicovero()];
                ricovero[1] = finestra.testoNome.getText();
                ricovero[0] = finestra.testoCognome.getText();
                ricovero[2] = finestra.valoreDataNascita.valore();
                datiRicovero.modificaRicoveri(cognomeMilitare, nomeMilitare, nascitaMilitare, ricovero);
                
                
                //GestioneFinestraElencoMilitari.modifica = true;
                finestra.setVisible(false);
            }else{
                javax.swing.JOptionPane.showMessageDialog(
                        finestra, "valori data non corretti!","errore",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
