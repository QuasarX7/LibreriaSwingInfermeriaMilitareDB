package it.difesa.esercito.rav17.infermeria.controllo;


import it.difesa.esercito.rav17.infermeria.DaseDati.Dati;
import it.difesa.esercito.rav17.infermeria.DaseDati.DatiImpostazioni;
import it.difesa.esercito.rav17.infermeria.DaseDati.DatiMilitare;
import it.quasar_x7.java.swing.stampa.FinestraDiStampaOrizzontaleMultiplaEventi;
import it.quasar_x7.java.utile.DataOraria;
import java.util.ArrayList;

/*******************************************************************************
 *
 * @author Domenico della Peruta
 * @version 2.1.0 07/07/2017
 ******************************************************************************/
public class FinestraStampatoRegistroIncorporamento extends FinestraDiStampaOrizzontaleMultiplaEventi{

    public Dati dati;
    private final DatiImpostazioni impostazioni;
    
    public FinestraStampatoRegistroIncorporamento(DataOraria data){
        super();
        dati = new DatiMilitare();
        impostazioni = new DatiImpostazioni();

        gestore.nomiColonne = new String[]{
            "GRADO","COGNOME","NOME","DATA DI MASCITA","CP / RGT","DATA","GML"
        };
        gestore.dimColonne = new int[]{70,90,90,90,90,90,200};
        if(data != null){
            getCampoData().setDate(data.convertiDate());
            caricaPagine();
        }

    }
    
    public FinestraStampatoRegistroIncorporamento(){
        this(null);
    }
    
    
    @Override
    public ArrayList<Object[]> caricaDati() {
        ArrayList<Object[]> _militare;
                        
        if(data != null){
            if(data.getDate() != null){
            _militare = ((DatiMilitare)dati).elencoIncorporati(new DataOraria(data.getDate()));

                if(_militare != null){
                    return _militare;
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