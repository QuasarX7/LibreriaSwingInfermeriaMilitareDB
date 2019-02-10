package it.difesa.esercito.rav17.infermeria.controllo;

import it.difesa.esercito.rav17.infermeria.DaseDati.DatiMilitare;
import it.difesa.esercito.rav17.infermeria.DaseDati.DatiVisita;
import it.difesa.esercito.rav17.infermeria.vista.FinestraElencoMilitari;
import it.difesa.esercito.rav17.infermeria.vista.FinestraRicovero;
import it.difesa.esercito.rav17.infermeria.vista.FinestraVisita;
import it.quasar_x7.java.swing.finestra.Finestra;
import it.quasar_x7.java.swing.stampa.FinestraStampatoSemplice;
import it.quasar_x7.java.swing.stampa.Stampato;
import it.quasar_x7.java.utile.DataOraria;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Dott. Domenico della Peruta
 * @version 1.0.0 ultima modifica 07/10/2016
 */
public class FinestraVisitaController {
    
    private FinestraVisita finestra;
    private Color verde;
    private DatiVisita datiVisita; 
    private DatiMilitare datiMilitare;
    private Object[] militare;
    private FinestraElencoMilitari finestraElenco;
    private DataOraria _dataOrariaVisita;
    private String medico;

    public FinestraVisitaController(FinestraVisita finestra, Object[] militare, String medico) {
        this.finestra = finestra;
        datiVisita = new DatiVisita();
        datiMilitare = new DatiMilitare();
        finestra.getRootPane().setDefaultButton(finestra.pulsanteSalva);
        this.militare=militare;
        this.medico=medico;
        verde = this.finestra.pannelloVisita.getBackground();

        this.bloccaElementi(true);
        this.caricaCampi();
    }

    public FinestraVisitaController(FinestraVisita finestra, Object[] militare, DataOraria visita) {
        this.finestra = finestra;
        datiVisita = new DatiVisita();
        
        this._dataOrariaVisita = visita;

        this.militare=militare;
        verde = this.finestra.pannelloVisita.getBackground();

        

        this.bloccaElementi(true);
        this.caricaCampi();
        this.coloraSfondo();
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


        Object[] visita=null;

        if(this._dataOrariaVisita != null){
            visita = this.datiVisita.trovaVisita(
                    this._dataOrariaVisita,
                    (String) militare[0],
                    (String) militare[1],
                    (DataOraria) militare[2]
                    );
        }

       
        if(visita!=null){
            
            if(((String)visita[0]).compareTo("CHIEDENTI VISITA")==0){
                finestra.tipoVisite.setSelectedIndex(0);
            }else{
                finestra.tipoVisite.setSelectedIndex(1);
            }
            finestra.testoAnamnesi.setText((String) visita[5]);
            finestra.testoDatiClinici.setText((String)visita[6]);
            finestra.testoEO.setText((String)visita[7]);
            finestra.testoDiagnosi.setText((String)visita[8]);
            finestra.testoTerapia.setText((String)visita[9]);
            finestra.testoTrasferimentoOC.setText((String)visita[10]);
            finestra.testoPML.setText((String)visita[11]);
            finestra.selezionaRicovero.setSelected((Boolean)visita[13]);
            finestra.selezionaDLT.setSelected((Boolean)visita[12]);
            finestra.etichettaMedico.setText("medico: "+visita[15]);
            if(visita[16] != null) {
                finestra.etichettaOperatore.setText("ultima modifica: "+visita[14]+" - "+((DataOraria)visita[16]).stampa());
            }
            else {
                finestra.etichettaOperatore.setText("ultima modifica: "+visita[14]);
            }
            
            finestra.dataOraVisita.carica(
                    _dataOrariaVisita.giornoMese(),
                    _dataOrariaVisita.mese(),
                    _dataOrariaVisita.anno(),
                    _dataOrariaVisita.ore() ,
                    _dataOrariaVisita.minuti());

        }else{
            DataOraria _visita = new DataOraria();
            _visita.adesso();

            finestra.dataOraVisita.carica(
                    _visita.giornoMese(),
                    _visita.mese(),
                    _visita.anno(),
                    _visita.ore() ,
                    _visita.minuti());    
            finestra.etichettaOperatore.setText("operatore: "+Finestra.utente);
            finestra.etichettaMedico.setText("medico: "+medico);
        }
        
        this.bloccaElementi(false);

    }

    private void bloccaElementi(boolean b) {
        finestra.tipoVisite.setEnabled(!b);
        finestra.selezionaDLT.setEnabled(!b);
        finestra.selezionaRicovero.setEnabled(!b);
        finestra.pulsanteSalva.setEnabled(!b);
        finestra.testoDatiClinici.setEnabled(!b);
        finestra.testoDiagnosi.setEnabled(!b);
        finestra.testoEO.setEnabled(!b);
        finestra.testoAnamnesi.setEnabled(!b);
        finestra.testoPML.setEnabled(!b);
        finestra.testoTerapia.setEnabled(!b);
        finestra.testoTrasferimentoOC.setEnabled(!b);
        finestra.dataOraVisita.setEnabled(!b);
    }

    public void creaRicovero(){
        finestra.setVisible(false);
        if(JOptionPane.showConfirmDialog(null,
                        "Registra nuovo ricovero?",
                        "avviso",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                    )     ==    JOptionPane.YES_OPTION){
                
            if(militare !=null){
                   

                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        DataOraria ingresso = new DataOraria();
                        ingresso.adesso();
                        Object[] datiClinici = new Object[]{
                            (String)finestra.testoAnamnesi.getText(),
                            (String)finestra.testoDatiClinici.getText(),
                            (String)finestra.testoEO.getText(),
                            (String)finestra.testoDiagnosi.getText(),
                            (String)finestra.testoTerapia.getText(),
                            (String)finestra.testoPML.getText()
                        }; 
                        FinestraRicovero finestraRicovero =new FinestraRicovero(militare,ingresso,datiClinici);
                        finestraRicovero.setVisible(true);
                        finestra.selezionaRicovero.setSelected(true);
                    }
                });
                
            }
        }
    }
   
    private boolean controllaCampi(){
        boolean errore = finestra.dataOraVisita.erroreCampi();
        int n=0;
        if((n=finestra.testoAnamnesi.getText().length()) > 250){
            JOptionPane.showMessageDialog(finestra, "Errore anamnesi: n° caratteri = "+n+" (>250)",
                        "errore",
                        JOptionPane.ERROR_MESSAGE);
                errore = true;
        }
        
        if((n=finestra.testoDatiClinici.getText().length()) > 250){
            JOptionPane.showMessageDialog(finestra, "Errore dati clinici: n° caratteri = "+n+" (>250)",
                        "errore",
                        JOptionPane.ERROR_MESSAGE);
                errore = true;
        }
        
        if((n=finestra.testoEO.getText().length()) > 250){
            JOptionPane.showMessageDialog(finestra, "Errore esame obiettivo: n° caratteri = "+n+" (>250)",
                        "errore",
                        JOptionPane.ERROR_MESSAGE);
                errore = true;
        }
        if((n=finestra.testoDiagnosi.getText().length()) > 250){
            JOptionPane.showMessageDialog(finestra, "Errore diagnosi: n° caratteri = "+n+" (>250)",
                        "errore",
                        JOptionPane.ERROR_MESSAGE);
                errore = true;
        }
        if((n=finestra.testoTerapia.getText().length()) > 250){
            JOptionPane.showMessageDialog(finestra, "Errore terapia: n° caratteri = "+n+" (>250)",
                        "errore",
                        JOptionPane.ERROR_MESSAGE);
                errore = true;
        }
        if((n=finestra.testoPML.getText().length()) > 250){
            JOptionPane.showMessageDialog(finestra, "Errore PMLi: n° caratteri = "+n+" (>250)",
                        "errore",
                        JOptionPane.ERROR_MESSAGE);
                errore = true;
        }
        if((n=finestra.testoTrasferimentoOC.getText().length()) > 50){
            JOptionPane.showMessageDialog(finestra, "Errore trasferimento O.C:: n° caratteri = "+n+" (>50)",
                        "errore",
                        JOptionPane.ERROR_MESSAGE);
                errore = true;
        }
        return errore;
    }
    
     public boolean salvaDati() {
         boolean salva;
         if(salva = !controllaCampi()){
            Object[] visita = new Object[datiVisita.dimensioneVisita()];

            visita[5] =  finestra.testoAnamnesi.getText();
            visita[6] =  finestra.testoDatiClinici.getText();
            visita[7] =  finestra.testoEO.getText();
            visita[8] =  finestra.testoDiagnosi.getText();
            visita[9] =  finestra.testoTerapia.getText();
            visita[10] = finestra.testoTrasferimentoOC.getText();
            visita[11] = finestra.testoPML.getText();

            if(finestra.selezionaRicovero.getSelectedObjects()!=null) {
                 visita[13] = true;
             }
            else {
                 visita[13] = false;
             }

            if(finestra.selezionaDLT.getSelectedObjects()!=null) {
                 visita[12] = true;
             }
            else {
                 visita[12] = false;
             }

            visita[14] = Finestra.utente;
            visita[15] = medico;

            DataOraria modifica = new DataOraria();
            modifica.adesso();
            visita[16] = modifica;

            if(_dataOrariaVisita != null){
                //se viene selezionato un record già
                //esistente, viene eliminato prima di
                //essere sostituito
                datiVisita.eliminaVisita(
                        this._dataOrariaVisita,
                        (String) this.militare[0],
                        (String) this.militare[1],
                        (DataOraria) this.militare[2]);
            }

            datiVisita.aggiungiVisita(
                    (String)finestra.tipoVisite.getSelectedItem(),
                    finestra.dataOraVisita.valore(),
                    (String)this.militare[0],
                    (String)this.militare[1],
                    (DataOraria)this.militare[2],
                    visita);

            this.bloccaElementi(true);
            finestra.setVisible(false);
        }
         return salva;
     }

    public void coloraSfondo() {
        
            if(finestra.tipoVisite.getSelectedIndex()==1) {
                finestra.pannelloVisita.setBackground(Color.red);
            }
            else{
                finestra.pannelloVisita.setBackground(verde);
            }
        
    }

    

    public void stampa(ActionEvent evt) {
        if(evt.getSource() instanceof javax.swing.JButton){
            salvaDati();
            FinestraStampatoSemplice f = new  FinestraStampatoSemplice();
            f.aggiungiTitolo("RAGGRUPPAMENTO UNITA' ADDESTRATIVE",10);
            f.aggiungiTitolo("Reparto Supporti",10);
            f.aggiungiTitolo("- INFERMERIA -",12);
            f.aggiungiTitolo("",14);
            f.aggiungiTitolo(finestra.tipoVisite.getSelectedItem().toString(),14);
            f.aggiungiTitolo("",10);
            f.aggiungiTesto("Capua, lì "+new DataOraria().stampaGiorno(), 9, false, Stampato.ALL_DESTRA);
            f.aggiungiTitolo("",10);
            String nominativo = ((String)militare[4]).toString() +" "+
                    ((String)militare[0]).toString()  +" "+
                    ((String)militare[1]).toString()  +" nato il "+
                    ((DataOraria)militare[2]).stampaGiorno()  +" a "+
                    ((String)militare[3]).toString()  +".";
            f.aggiungiTesto("OGGETTO: Visita medica del "+nominativo);
            f.aggiungiTitolo("",10);
            f.aggiungiTesto("giorno: "+finestra.dataOraVisita.valore().stampaGiornoCompleto());
            f.aggiungiTesto("ore: "+finestra.dataOraVisita.valore().stampaOra());
            f.aggiungiTesto("_________________________________________________________________________",9,false,Stampato.ALL_SINISTRA);
            f.aggiungiTesto("ANAMNESI:",10,false,Stampato.ALL_SINISTRA);
            f.aggiungiTesto(finestra.testoAnamnesi.getText(), 9, false, Stampato.ALL_SINISTRA);
            f.aggiungiTesto("_________________________________________________________________________",9,false,Stampato.ALL_SINISTRA);
            f.aggiungiTesto("DATI CLINICI:",10,false,Stampato.ALL_SINISTRA);
            f.aggiungiTesto(finestra.testoDatiClinici.getText(), 9, false, Stampato.ALL_SINISTRA);
            f.aggiungiTesto("_________________________________________________________________________",9,false,Stampato.ALL_SINISTRA);
            f.aggiungiTesto("ESAME OBIETTIVO:",10,false,Stampato.ALL_SINISTRA);
            f.aggiungiTesto(finestra.testoEO.getText(), 9, false, Stampato.ALL_SINISTRA);
            f.aggiungiTesto("_________________________________________________________________________",9,false,Stampato.ALL_SINISTRA);
            f.aggiungiTesto("DIAGNOSI:",10,false,Stampato.ALL_SINISTRA);
            f.aggiungiTesto(finestra.testoDiagnosi.getText(), 9, false, Stampato.ALL_SINISTRA);
            f.aggiungiTesto("_________________________________________________________________________",9,false,Stampato.ALL_SINISTRA);
            f.aggiungiTesto("PML:",10,false,Stampato.ALL_SINISTRA);
            f.aggiungiTesto(finestra.testoPML.getText(), 9, false, Stampato.ALL_SINISTRA);
            f.aggiungiTesto("_________________________________________________________________________",9,false,Stampato.ALL_SINISTRA);
            f.aggiungiTesto("TERAPIA:",10,false,Stampato.ALL_SINISTRA);
            f.aggiungiTesto(finestra.testoTerapia.getText(), 9, false, Stampato.ALL_SINISTRA);
            f.aggiungiTesto("_________________________________________________________________________",9,false,Stampato.ALL_SINISTRA);
            f.aggiungiTesto("Trasferimento O.C.:",10,false,Stampato.ALL_SINISTRA);
            f.aggiungiTesto(finestra.testoTrasferimentoOC.getText(), 9, false, Stampato.ALL_SINISTRA);
            f.aggiungiTesto("_________________________________________________________________________",10,false,Stampato.ALL_SINISTRA);
            String _ricovero,_dlt;
            if(finestra.selezionaRicovero.getSelectedObjects() != null){
                _ricovero = "SI";
            }else{
                _ricovero = "NO";
            }
            f.aggiungiTesto("ricovero: "+_ricovero,9,false,Stampato.ALL_SINISTRA);
            if(finestra.selezionaDLT.getSelectedObjects() != null){
                _dlt = "SI";
            }else{
                _dlt = "NO";
            }
            f.aggiungiTesto("DLT: "+_dlt, 9, false, Stampato.ALL_SINISTRA);
            f.aggiungiTesto(finestra.etichettaMedico.getText(), 9, false, Stampato.ALL_SINISTRA);
            f.aggiungiTesto(finestra.etichettaOperatore.getText(), 9, false, Stampato.ALL_SINISTRA);
            f.aggiungiTitolo("",10);
            String timbro = "<b><div>IL DIRIGENTE DEL SERVIZIO SANITARIO</div>"
                    + /*"<div>Ten. Col. (me) Cesare VIGLIONE</div>*/"</b>";
            String[] dati = new String[]{
                     Stampato.testo("", 9, false, Stampato.ALL_SINISTRA, 5, 200, Stampato.NO_BORDO, 1),
                     Stampato.testo(timbro, 9, false, Stampato.ALL_CENTRO, 5, 200, Stampato.NO_BORDO, 1)
            };
            f.aggiungiTesto(Stampato.testo(dati,"Arial", 9, true,Stampato.ALL_CENTRO,600));
             f.setVisible(true);
        }
    }
    
}
