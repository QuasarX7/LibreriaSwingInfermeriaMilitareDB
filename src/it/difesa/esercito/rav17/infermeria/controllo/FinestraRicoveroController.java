package it.difesa.esercito.rav17.infermeria.controllo;

import it.difesa.esercito.rav17.infermeria.DaseDati.DatiMilitare;
import it.difesa.esercito.rav17.infermeria.DaseDati.DatiRicovero;
import it.difesa.esercito.rav17.infermeria.vista.FinestraElencoMilitari;
import it.difesa.esercito.rav17.infermeria.vista.FinestraRicovero;
import it.quasar_x7.java.swing.finestra.Finestra;
import it.quasar_x7.java.utile.DataOraria;



/**
 *
 * @author Dott. Domenico della Peruta
 * @version 0.0.1 ultima modifica 03/10/2016
 */
public class FinestraRicoveroController {
    
    private FinestraRicovero finestra;
    
    private final DatiRicovero datiRicovero;   
    private final DatiMilitare datiMilitare;
    private Object[] militare;
    private FinestraElencoMilitari finestraElenco;
    private DataOraria _dataOrariaRicovero;
    
    
    public FinestraRicoveroController(FinestraRicovero finestra,Object[] militare){
        this.finestra = finestra;
        datiRicovero = new DatiRicovero();
        datiMilitare = new DatiMilitare();
        this.militare=militare;
        bloccaElementi(true);
        caricaCampi();
    }
    
    public FinestraRicoveroController(FinestraRicovero finestra,Object[] militare,DataOraria ricovero){
        this.finestra = finestra;
        datiRicovero = new DatiRicovero();
        datiMilitare = new DatiMilitare();
        _dataOrariaRicovero = ricovero;
        this.militare=militare;    
        this.bloccaElementi(true);
        this.caricaCampi();
    }
    
    public FinestraRicoveroController(FinestraRicovero finestra,Object[] militare,DataOraria ricovero,Object[] datiClinici){
        this.finestra = finestra;
        datiRicovero = new DatiRicovero();
        datiMilitare = new DatiMilitare();
        this._dataOrariaRicovero = ricovero;
        this.militare=militare;   
        this.bloccaElementi(true);
        this.creaCampi(datiClinici);
    }
    
    
    public void acquisisciSelezione(){
        if (finestraElenco != null){
            Object[] nominativo = finestraElenco.seleziona();//nominativo selezionato in tabella


            if(nominativo != null){
                militare =
                        datiMilitare.trovaMilitare(
                                (String)nominativo[0],
                                (String)nominativo[1],
                                (DataOraria)nominativo[2]);

                this.caricaCampi();
            }

        }
        finestraElenco = null;
    }
    
    
    private void caricaCampi(){
        
        if(militare == null){
            return;
        }

        //inizializza i campi della maschera
        finestra.testoCognome.setText((String)militare[0]);
        finestra.testoNome.setText((String) militare[1]);

        finestra.valoreAnnoNascita.setValue(((DataOraria)militare[2]).anno());
        finestra.valoreMeseNascita.setValue(((DataOraria)militare[2]).mese());
        finestra.valoreGiornoNascita.setValue(((DataOraria)militare[2]).giornoMese());

        finestra.testoLuogo.setText((String)militare[3]);
        finestra.testoGrado.setText((String)militare[4]);


        Object[] ricoveri=null;

        if(this._dataOrariaRicovero != null){
            ricoveri = this.datiRicovero.trovaRicovero(
                    this._dataOrariaRicovero,
                    (String) militare[0],
                    (String) militare[1],
                    (DataOraria) militare[2]
                    );
        }

               

        if(ricoveri!=null){
                        
            finestra.testoAnamnesi.setText((String) ricoveri[5]);
            finestra.testoDatiClinici.setText((String)ricoveri[6]);
            finestra.testoEO.setText((String)ricoveri[7]);
            finestra.testoDiagnosi.setText((String)ricoveri[8]);
            finestra.testoTerapia.setText((String)ricoveri[9]);
            finestra.testoPML.setText((String)ricoveri[10]);
            if(ricoveri[12] != null)
                finestra.etichettaUtente.setText("ultima modifica: "+(String)ricoveri[11]+" - "+((DataOraria)ricoveri[12]).stampa());        
            else
                finestra.etichettaUtente.setText("ultima modifica: "+(String)ricoveri[11]);        

            finestra.dataOraIngresso.carica(
                    _dataOrariaRicovero.giornoMese(),
                    _dataOrariaRicovero.mese(),
                    _dataOrariaRicovero.anno(),
                    _dataOrariaRicovero.ore() ,
                    _dataOrariaRicovero.minuti());

            if(ricoveri[4]!=null){
                finestra.dataOraUscita.carica(
                        ((DataOraria) ricoveri[4]).giornoMese(),
                         ((DataOraria) ricoveri[4]).mese(),
                         ((DataOraria) ricoveri[4]).anno(),
                         ((DataOraria) ricoveri[4]).ore() ,
                         ((DataOraria) ricoveri[4]).minuti());
            }

        }else{
            DataOraria _visita = new DataOraria();
            _visita.adesso();

            finestra.dataOraIngresso.carica(
                    _visita.giornoMese(),
                    _visita.mese(),
                    _visita.anno(),
                    _visita.ore() ,
                    _visita.minuti());            
        }
        
        bloccaElementi(false);
    }
    
    private void creaCampi(Object[] datiClinici){

        if(militare == null){
            return;
        }

        //inizializza i campi della maschera
        finestra.testoCognome.setText((String)militare[0]);
        finestra.testoNome.setText((String) militare[1]);

        finestra.valoreAnnoNascita.setValue(((DataOraria)militare[2]).anno());
        finestra.valoreMeseNascita.setValue(((DataOraria)militare[2]).mese());
        finestra.valoreGiornoNascita.setValue(((DataOraria)militare[2]).giornoMese());

        finestra.testoLuogo.setText((String)militare[3]);
        finestra.testoGrado.setText((String)militare[4]);

        
        Object[] ricoveri=null;

        if(this._dataOrariaRicovero != null){
            ricoveri = this.datiRicovero.trovaRicovero(
                    this._dataOrariaRicovero,
                    (String) militare[0],
                    (String) militare[1],
                    (DataOraria) militare[2]
                    );
        }

       
        if(ricoveri!=null){
            
            javax.swing.JOptionPane.showMessageDialog(finestra,
                    "dati clinici già esistenti", "informazioni",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
            finestra.testoAnamnesi.setText((String) ricoveri[5]);
            finestra.testoDatiClinici.setText((String)ricoveri[6]);
            finestra.testoEO.setText((String)ricoveri[7]);
            finestra.testoDiagnosi.setText((String)ricoveri[8]);
            finestra.testoTerapia.setText((String)ricoveri[9]);
            finestra.testoPML.setText((String)ricoveri[10]);
            finestra.etichettaUtente.setText("ultima modifica: "+(String)ricoveri[11]+" - "+((DataOraria)ricoveri[12]).stampa());        


            finestra.dataOraIngresso.carica(
                    _dataOrariaRicovero.giornoMese(),
                    _dataOrariaRicovero.mese(),
                    _dataOrariaRicovero.anno(),
                    _dataOrariaRicovero.ore() ,
                    _dataOrariaRicovero.minuti());

            if(ricoveri[4]!=null){
                finestra.dataOraUscita.carica(
                        ((DataOraria) ricoveri[4]).giornoMese(),
                         ((DataOraria) ricoveri[4]).mese(),
                         ((DataOraria) ricoveri[4]).anno(),
                         ((DataOraria) ricoveri[4]).ore() ,
                         ((DataOraria) ricoveri[4]).minuti());
            }

        }else if(datiClinici!=null){            
                        
            finestra.testoAnamnesi.setText((String) datiClinici[0]);
            finestra.testoDatiClinici.setText((String)datiClinici[1]);
            finestra.testoEO.setText((String)datiClinici[2]);
            finestra.testoDiagnosi.setText((String)datiClinici[3]);
            finestra.testoTerapia.setText((String)datiClinici[4]);
            finestra.testoPML.setText((String)datiClinici[5]);

            finestra.dataOraIngresso.carica(
                    _dataOrariaRicovero.giornoMese(),
                    _dataOrariaRicovero.mese(),
                    _dataOrariaRicovero.anno(),
                    _dataOrariaRicovero.ore() ,
                    _dataOrariaRicovero.minuti());

            

        }else{
            DataOraria _visita = new DataOraria();
            _visita.adesso();

            finestra.dataOraIngresso.carica(
                    _visita.giornoMese(),
                    _visita.mese(),
                    _visita.anno(),
                    _visita.ore() ,
                    _visita.minuti());            
        }
        
        this.bloccaElementi(false);

    }

    private void bloccaElementi(boolean b) {
        
        finestra.pulsanteSalva.setEnabled(!b);
        finestra.testoDatiClinici.setEnabled(!b);
        finestra.testoDiagnosi.setEnabled(!b);
        finestra.testoEO.setEnabled(!b);
        finestra.testoAnamnesi.setEnabled(!b);
        finestra.testoPML.setEnabled(!b);
        finestra.testoTerapia.setEnabled(!b);
        finestra.dataOraUscita.setEnabled(!b);
        finestra.dataOraIngresso.setEnabled(!b);
    }

   

public void salvaDati() {
        if(finestra.dataOraIngresso.controllo()){
            Object[] ricoveri = new Object[datiRicovero.dimensioneRicovero()];

            if(finestra.dataOraUscita.valore()!=null) {
                if(finestra.dataOraUscita.controllo()){
                    ricoveri[4] = finestra.dataOraUscita.valore();
                }else{
                    return;
                }
            }
            ricoveri[5] =  finestra.testoAnamnesi.getText();
            ricoveri[6] =  finestra.testoDatiClinici.getText();
            ricoveri[7] =  finestra.testoEO.getText();
            ricoveri[8] =  finestra.testoDiagnosi.getText();
            ricoveri[9] =  finestra.testoTerapia.getText();
            ricoveri[10] = finestra.testoPML.getText();
            ricoveri[11] = Finestra.utente;
            DataOraria modifica = new DataOraria();
            modifica.adesso();
            ricoveri[12] = modifica;
            
            if(_dataOrariaRicovero != null){
                //se viene selezionato un record già
                //esistente, viene eliminato prima di
                //essere sostituito
                datiRicovero.eliminaRicovero(
                         this._dataOrariaRicovero,
                        (String) this.militare[0],
                        (String) this.militare[1],
                        (DataOraria) this.militare[2]);
            }

            datiRicovero.aggiungiRicovero(
                    finestra.dataOraIngresso.valore(),
                    (String)this.militare[0],
                    (String)this.militare[1],
                    (DataOraria)this.militare[2],
                    ricoveri);

            bloccaElementi(true);
            finestra.setVisible(false);
        }
    }

}
