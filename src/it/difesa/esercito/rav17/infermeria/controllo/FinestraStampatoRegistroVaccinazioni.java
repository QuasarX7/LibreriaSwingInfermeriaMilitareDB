package it.difesa.esercito.rav17.infermeria.controllo;

import it.difesa.esercito.rav17.infermeria.DaseDati.DatiImpostazioni;
import it.difesa.esercito.rav17.infermeria.DaseDati.Dati;
import it.difesa.esercito.rav17.infermeria.DaseDati.DatiVaccinazioni;
import it.quasar_x7.java.swing.stampa.FinestraDiStampaOrizzontaleMultiplaEventi;
import it.quasar_x7.java.utile.DataOraria;
import java.util.ArrayList;

/*******************************************************************************
 *
 * @author Domenico della Peruta
 * @version 1.0.1 ultima modifica 06/07/2017
 ******************************************************************************/
public class FinestraStampatoRegistroVaccinazioni extends FinestraDiStampaOrizzontaleMultiplaEventi{

    public Dati dati;
    private final DatiImpostazioni impostazioni;
    
    public FinestraStampatoRegistroVaccinazioni(DataOraria data){
        super();
        dati = new DatiVaccinazioni();
        impostazioni = new DatiImpostazioni();
        gestore.nomiColonne = new String[]{
            "Data","Grado","Cognome","Nome","Nascita","CP/RGT","Vaccino","Lotto","Scadenza","Dose","Medico"};
        gestore.dimColonne = new int[]{40,35,80,80,40,80,60,50,40,20,190};
        if(data != null){
            getCampoData().setDate(data.convertiDate());
            caricaPagine();
        }
    }
    
    public FinestraStampatoRegistroVaccinazioni(){
        this(null);
    }
    
    
    @Override
    public ArrayList<Object[]> caricaDati() {
        ArrayList<Object[]> _vaccinazioni;
                        
        if(data != null){
            if(data.getDate() != null){
            _vaccinazioni = ((DatiVaccinazioni)dati).trovaVaccinazioni(new DataOraria(data.getDate()));

                if(_vaccinazioni != null){
                    return _vaccinazioni;
                }
            }
        }
        return null;
    }

    @Override
    public String[] intestazione() {
        return new String[]{
            impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_INT_REGGIMENTO),
            impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_INT_UFFICIO)
        };
    }

}