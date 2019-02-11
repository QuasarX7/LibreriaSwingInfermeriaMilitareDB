package it.quasar_x7.infermeria.controllo;

import it.quasar_x7.infermeria.DaseDati.BASE_DATI;
import it.quasar_x7.infermeria.DaseDati.DatiImpostazioni;
import it.quasar_x7.infermeria.DaseDati.DatiMedico;
import it.quasar_x7.infermeria.DaseDati.DatiVerbaleVisita;
import it.quasar_x7.infermeria.DaseDati.BASE_DATI.MODELLO_ML;
import it.quasar_x7.infermeria.vista.FinestraModelloGL;
import it.quasar_x7.infermeria.vista.FinestraModelloML;
import it.quasar_x7.java.swing.finestra.Finestra;
import it.quasar_x7.java.swing.stampa.FinestraStampatoSemplice;
import it.quasar_x7.java.swing.stampa.Stampato;
import it.quasar_x7.java.utile.DataOraria;
import it.quasar_x7.java.utile.Testo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Dr Domenico della Peruta
 * @version 1.0.0 modifica 03/02/2016
 */
public class FinestraModelloMLController {

    DatiVerbaleVisita DB = new DatiVerbaleVisita();
    final String X  = " \u22A0 ";
    final String L    = " \u29E0 ";
    final String trattino  = " &nbsp; ";
    final String TIPO_FORMATO_CARATTERI = "Times New Roman";
    private Object[] verbaleML;
    
    private String _cognome,_nome,_grado;
    private DataOraria _nascita,_data;

    private boolean nuovoVerbale = true;
    private final FinestraModelloML finestra;

    public FinestraModelloMLController(FinestraModelloML finestra,Object[] militare,DataOraria data) {
        this.finestra=finestra;
        this.finestra.selezionaMedico.setModel(
                new javax.swing.DefaultComboBoxModel(
                new DatiMedico().tuttiMedici().toArray()));
        this.finestra.selezionaMedico.setSelectedIndex(-1);
        this.finestra.pulsanteModelloGL.setEnabled(false);
        caricaDati(data,militare);
        caricaPannelloNominativo(militare);
        
        
    }
    
    private void caricaPannelloNominativo(Object[] militare){
        finestra.testoGrado.setText((String)militare[4]);
        finestra.testoCognome.setText((String)militare[0]);
        finestra.testoNome.setText((String)militare[1]);
        finestra.testoReparto.setText((String)militare[6]);
        finestra.valoreAnnoNascita.setText(((DataOraria)militare[2]).anno()+"");
        finestra.valoreMeseNascita.setText(((DataOraria)militare[2]).mese()+"");
        finestra.valoreGiornoNascita.setText(((DataOraria)militare[2]).giornoMese()+"");
        finestra.testoLuogo.setText((String)militare[3]);
        finestra.campoML_anno.setText(finestra.campoData.valore().anno()+"");
         
    }
    
    public void limite(javax.swing.event.CaretEvent evt, javax.swing.JTextArea campo, int max){
        if(evt.getSource() instanceof javax.swing.JTextArea){
            String testo = campo.getText();
            if(testo!=null){
                if(testo.length()>max){
                    campo.setForeground(Color.RED);
                }else{
                    campo.setForeground(Color.blue);
                }
            }
        }
    }
    
    private void caricaDati(DataOraria data,Object[] militare){
        if(data!=null) {
            finestra.campoData.carica(data.giornoMese(), data.mese(), data.anno());
        }
        _cognome = (String)militare[0];
        _nome = (String)militare[1];
        _nascita = (DataOraria)militare[2];
        _grado = (String)militare[BASE_DATI.MILITARE.GRADO];
        _data = finestra.campoData.valore();
        
        Object[] verbale = DB.vediVerbale(_data, _cognome, _nome, _nascita);
       finestra.selezionaRichiedente.setModel(
                    new javax.swing.DefaultComboBoxModel(
                new Object[]{
                    " ",
                    militare[4]+" "+militare[1]+" "+militare[0],
                    "17° RAV \"ACQUI\"",
                    "47° RAV \"FERRARA\"",
                    "REPARTO SUPPORTI",
                    "COMANDO RUA"
                }));
        
        if(verbale != null){
            nuovoVerbale = false;
                Testo t = new Testo((String)verbale[4]);
                ArrayList<Object> ML_EI = t.scomposizione();
                if(ML_EI.size()==3){
                    try{
                        finestra.campoML_EIprogr.setText(((Integer)ML_EI.get(0)).toString());
                    }catch(java.lang.ClassCastException ex){
                        finestra.campoML_EIprogr.setText("?");
                    }
                    finestra.campoML_anno.setText(((Integer)ML_EI.get(2)).toString());
                }else{
                    finestra.campoML_EIprogr.setText("?");
                    finestra.campoML_anno.setText("?");
                }
                finestra.selezionaRichiedente.setModel(
                    new javax.swing.DefaultComboBoxModel(
                new Object[]{
                    verbale[5],
                    militare[4]+" "+militare[1]+" "+militare[0],
                    "17° RAV \"ACQUI\"",
                    "47° RAV \"FERRARA\"",
                    "REPARTO SUPPORTI",
                    "COMANDO RUA"
                }));
                finestra.selezionaRichiedente.setSelectedItem(verbale[5]);
                finestra.selezionaVisitaMedica.setSelected((Boolean)verbale[6]);
                finestra.selezionaControlloCertificato.setSelected((Boolean)verbale[7]);
                finestra.selezionaIdoneità.setSelected((Boolean)verbale[10]);
                finestra.campoIncarico.setText((String)verbale[8]);
                finestra.campoReparto.setSelectedItem(verbale[9]);
                finestra.campoTO.setText((String)verbale[11]);
                finestra.selezionaIdoneitàTO.setSelected((Boolean)verbale[12]);
                finestra.selezionaTempNonIdoneoTO.setSelected((Boolean)verbale[13]);
                if(verbale[15] != null) {
                    finestra.campoMesiNonIdoneoTO.setText(((Long)verbale[15]).toString());
                }
                else {
                    finestra.campoMesiNonIdoneoTO.setText(null);
                }
                finestra.selezionaPermanentementeNonIdTO.setSelected((Boolean)verbale[14]);
                finestra.selezionaAssentiContrEO.setSelected((Boolean)verbale[16]);
                finestra.selezionaTempContrEO.setSelected((Boolean)verbale[18]);
                finestra.campoMesiNonIdoneoEO.setText((String)verbale[19]);
                finestra.selezionaPermanentementeNonId.setSelected((Boolean)verbale[17]);
                finestra.selezionaSottoporreVisitaFiscale.setSelected((Boolean)verbale[20]);
                finestra.selezionaAmmalato.setSelected((Boolean)verbale[21]);
                finestra.selezionaConvalescente.setSelected((Boolean)verbale[23]);
                finestra.dataAmmalato.carica((DataOraria)verbale[22]);
                finestra.dataConvalescente.carica((DataOraria)verbale[24]);
                finestra.selezionaTempNonIdoneoServizio.setSelected((Boolean)verbale[25]);
                finestra.selezionaTempNonIDInvioCMO.setSelected((Boolean)verbale[26]);
                finestra.selezionaTempNonIDInvioOsservazione.setSelected((Boolean)verbale[27]);
                finestra.selezionaImpiegoIncarTecnicoAmm.setSelected((Boolean)verbale[28]);
                finestra.selezionaIncarTecnicoAmmCMO.setSelected((Boolean)verbale[29]);
                finestra.selezionaIncarTecnicoAmmOsservazione.setSelected((Boolean)verbale[30]);
                finestra.selezionaCausaInfermitàLes.setSelected((Boolean)verbale[31]);
                finestra.selezionaCausaInfermitàLesEsclusivamente.setSelected((Boolean)verbale[32]);
                finestra.selezionaCausaInfermitàLesPrevalente.setSelected((Boolean)verbale[33]);
                finestra.selezionaCausaInfermitàLesDipendenteCausaServ.setSelected((Boolean)verbale[34]);
                finestra.selezionaCausaInfermitàLesNonDipendenteCausaServ.setSelected((Boolean)verbale[35]);
                finestra.selezionaCausaInfermitàLesAccertamentoDipendenteCausaServ.setSelected((Boolean)verbale[36]);
                finestra.selezionaCausaInfermitàLesNonOggettoAcc.setSelected((Boolean)verbale[37]);
                finestra.selezionaCausaFeriteLesioniTr.setSelected((Boolean)verbale[38]);
                finestra.selezionaCausaInfermitàInsorte.setSelected((Boolean)verbale[39]);
                //campoNoteContr.setText((String)verbale[40]);

                finestra.selezionaVisitaPeriodica.setSelected((Boolean)verbale[41]);
                finestra.selezionaControlloCert.setSelected((Boolean)verbale[42]);
                if(finestra.campoTO.getText().length()>0)
                    finestra.campoTO_riepilogo.setText(finestra.campoTO.getText());
                else
                    finestra.campoTO_riepilogo.setVisible(false);
                finestra.selezionaVisitaPreimpiegoTO.setSelected((Boolean)verbale[43]);
                finestra.selezionaVisitaRientroTO.setSelected((Boolean)verbale[44]);
                finestra.selezionaVisitaTermineMalConv.setSelected((Boolean)verbale[45]);
                finestra.selezionaVisitaFiscale.setSelected((Boolean)verbale[46]);
                finestra.selezionaVisitaRichiesta.setSelected((Boolean)verbale[47]);
                finestra.selezionaAltraVisita.setSelected((Boolean)verbale[48]);
                finestra.campoAltraVisita.setText((String)verbale[49]);
                finestra.selezionaIncondizionata.setSelected((Boolean)verbale[50]);
                finestra.selezionaIdoneitaPerziale.setSelected((Boolean)verbale[51]);
                finestra.selezionaFumoSI.setSelected((Boolean)verbale[52]);
                finestra.selezionaFumoNO.setSelected((Boolean)verbale[53]);
                if(verbale[54] !=null)
                    finestra.campoNrSigarette.setText(((Long)verbale[54]).toString());
                finestra.dataFumo.carica((DataOraria)verbale[55]);
                finestra.selezionaExFumatore.setSelected((Boolean)verbale[56]);
                finestra.dataExFumatore.carica((DataOraria)verbale[57]);
                finestra.selezionaAlcoolSI.setSelected((Boolean)verbale[58]);
                finestra.selezionaAlcoolNO.setSelected((Boolean)verbale[59]);
                finestra.campoAlvo.setText((String)verbale[60]);
                finestra.campoDiuresi.setText((String)verbale[61]);
                finestra.campoRitmoSonnoVeglia.setText((String)verbale[62]);
                finestra.selezionaStatoVaccCompleto.setSelected((Boolean)verbale[63]);
                finestra.selezionaStatoVaccDaCompletare.setSelected((Boolean)verbale[64]);
                finestra.campoVaccinazioneDaComp.setText((String)verbale[65]);
                finestra.selezionaStatoVaccNonDesumibile.setSelected((Boolean)verbale[66]);
                finestra.campoAnamnesiPatologicaRemota.setText((String)verbale[67]);
                finestra.campoAnamnesiPatologicaProssima.setText((String)verbale[68]);
                finestra.campoIntolleranze.setText((String)verbale[69]);
                finestra.campoTerapieAtto.setText((String)verbale[70]);
                if(verbale[71]!=null)
                    finestra.campoPeso.setText(((Long)verbale[71]).toString());
                if(verbale[72]!=null)
                    finestra.campoStatura.setText(((Long)verbale[72]).toString());
                finestra.campoCondizioniGenerale.setText((String)verbale[73]);
                finestra.campoVista.setText((String)verbale[74]);
                finestra.campoUdito.setText((String)verbale[75]);
                finestra.campoAzioneCardiaca.setText((String)verbale[76]);
                if(verbale[77]!=null)
                    finestra.campoFrequenza.setText(((Long)verbale[77]).toString());
                if(verbale[78]!=null)
                    finestra.campoPressioneMax.setText(((Long)verbale[78]).toString());
                if(verbale[79]!=null)
                    finestra.campoPressioneMin.setText(((Long)verbale[79]).toString());
                finestra.campoEsameObiettivoLoc.setText((String)verbale[80]);
                finestra.selezioneNullaDiRilevante.setSelected((Boolean)verbale[81]);
                finestra.campoAccertamenti.setText((String)verbale[82]);
                finestra.campoDiagnosi.setText((String)verbale[83]);
                finestra.campoNote.setText((String)verbale[84]);
                if(verbale[85] != null)
                    finestra.selezionaMedico.setSelectedItem((String)verbale[85]);

                if(verbale[71]!=null && verbale[72]!=null){
                    double p = (Long)verbale[71];
                    double h = (Long)verbale[72];

                    if(h != 0){

                        finestra.campoICM.setText(new Float(p/(h*h)*10000).toString());
                    }
                }
                
                finestra.selezionaMonitoraggioEccPond.setSelected((Boolean)verbale[MODELLO_ML.ECCESSO_PONDERALE]);
                if(verbale[MODELLO_ML.GIORNI_ECCESSO_PONTERALE]!=null)
                    finestra.campoGiorniEccessoPond.setText(((Long)verbale[MODELLO_ML.GIORNI_ECCESSO_PONTERALE]).toString());
            
        }else{
            //nuovoVerbale = true;
            
            finestra.campoReparto.setSelectedItem((String)militare[6]);//reparto
            
            finestra.campoAnamnesiPatologicaRemota.setText((String)militare[8]);
            finestra.campoAnamnesiPatologicaProssima.setText((String)militare[9]);
            
            finestra.campoVista.setText(" OD: "+(Long)militare[13]+"/10"+" OS: "+(Long)militare[14]+"/10");
            Long peso = (Long)militare[11];
            finestra.campoPeso.setText(peso.toString());
            Long altezza = (Long)militare[10];
            finestra.campoStatura.setText(altezza.toString());
            if(altezza != 0L)
                finestra.campoICM.setText(new Float(
                        peso/(float)(altezza*altezza)*10000.0f
                ).toString());
            
            finestra.campoFrequenza.setText(((Long)militare[19]).toString());
            finestra.campoPressioneMax.setText(((Long)militare[17]).toString());
            finestra.campoPressioneMin.setText(((Long)militare[18]).toString());
             
            finestra.campoAccertamenti.setText("ESAMI EMATOCHIMICI\nECG\nHIV + MARKES EP. B");
            finestra.campoAlvo.setText("REGOLARE");
            finestra.campoDiuresi.setText("REGOLARE");
            finestra.campoRitmoSonnoVeglia.setText("REGOLARE");
            finestra.campoIntolleranze.setText("NESSUNA");
            finestra.campoTerapieAtto.setText("NESSUNA");
            finestra.campoCondizioniGenerale.setText("BUONE");
            finestra.campoUdito.setText("BUONO");
        }
    }
    
    
    private void salva(){
        finestra.pulsanteModelloGL.setEnabled(true);
        aggiornaICM();
        finestra.dataConvalescente.disattivaSegnalazione(true);
        finestra.dataAmmalato.disattivaSegnalazione(true);
        finestra.dataFumo.disattivaSegnalazione(true);
        finestra.dataExFumatore.disattivaSegnalazione(true);
        //if(campoML_EIprogr.getText().length()>0 && campoML_anno.getText().length()==4){
            verbaleML = new Object[DB.dimensioneVerbaleVisite()];
            /*carica verbaleML*/
            verbaleML[4]=finestra.campoML_EIprogr.getText()+"/"+finestra.campoML_anno.getText();
                if(finestra.selezionaRichiedente.getSelectedIndex() > -1)
                    verbaleML[5] = (String)finestra.selezionaRichiedente.getSelectedItem();
                
            verbaleML[6] = seleziona(finestra.selezionaVisitaMedica);
            verbaleML[7] = seleziona(finestra.selezionaControlloCertificato);
            verbaleML[10] = seleziona(finestra.selezionaIdoneità);
            verbaleML[8] = finestra.campoIncarico.getText();
            verbaleML[9] = finestra.campoReparto.getSelectedItem();
            verbaleML[11] = finestra.campoTO.getText();
            verbaleML[12] = seleziona(finestra.selezionaIdoneitàTO);
            verbaleML[13] = seleziona(finestra.selezionaTempNonIdoneoTO);
            if(finestra.campoMesiNonIdoneoTO.getText().length()>0)
                verbaleML[15] = new Integer(finestra.campoMesiNonIdoneoTO.getText());
            verbaleML[14] = seleziona(finestra.selezionaPermanentementeNonIdTO);
            verbaleML[16] = seleziona(finestra.selezionaAssentiContrEO);
            verbaleML[18] = seleziona(finestra.selezionaTempContrEO);
            verbaleML[19] = finestra.campoMesiNonIdoneoEO.getText();
            verbaleML[17] = seleziona(finestra.selezionaPermanentementeNonId);
            verbaleML[20] = seleziona(finestra.selezionaSottoporreVisitaFiscale);
            verbaleML[21] = seleziona(finestra.selezionaAmmalato);
            verbaleML[23] = seleziona(finestra.selezionaConvalescente);
            if(finestra.dataAmmalato.controllo())
                verbaleML[22] = finestra.dataAmmalato.valore();
            if(finestra.dataConvalescente.controllo())
                verbaleML[24] = finestra.dataConvalescente.valore();
            verbaleML[25] = seleziona(finestra.selezionaTempNonIdoneoServizio);
            verbaleML[26] = seleziona(finestra.selezionaTempNonIDInvioCMO);
            verbaleML[27] = seleziona(finestra.selezionaTempNonIDInvioOsservazione);
            verbaleML[28] = seleziona(finestra.selezionaImpiegoIncarTecnicoAmm);
            verbaleML[29] = seleziona(finestra.selezionaIncarTecnicoAmmCMO);
            verbaleML[30] = seleziona(finestra.selezionaIncarTecnicoAmmOsservazione);
            verbaleML[31] = seleziona(finestra.selezionaCausaInfermitàLes);
            verbaleML[32] = seleziona(finestra.selezionaCausaInfermitàLesEsclusivamente);
            verbaleML[33] = seleziona(finestra.selezionaCausaInfermitàLesPrevalente);
            verbaleML[34] = seleziona(finestra.selezionaCausaInfermitàLesDipendenteCausaServ);
            verbaleML[35] = seleziona(finestra.selezionaCausaInfermitàLesNonDipendenteCausaServ);
            verbaleML[36] = seleziona(finestra.selezionaCausaInfermitàLesAccertamentoDipendenteCausaServ);
            verbaleML[37] = seleziona(finestra.selezionaCausaInfermitàLesNonOggettoAcc);
            verbaleML[38] = seleziona(finestra.selezionaCausaFeriteLesioniTr);
            verbaleML[39] = seleziona(finestra.selezionaCausaInfermitàInsorte);
            //record[40] = campoNoteContr.getText();
            
            verbaleML[41] = seleziona(finestra.selezionaVisitaPeriodica);
            verbaleML[42] = seleziona(finestra.selezionaControlloCert);
            verbaleML[43] = seleziona(finestra.selezionaVisitaPreimpiegoTO);
            verbaleML[44] = seleziona(finestra.selezionaVisitaRientroTO);
            verbaleML[45] = seleziona(finestra.selezionaVisitaTermineMalConv);
            verbaleML[46] = seleziona(finestra.selezionaVisitaFiscale);
            verbaleML[47] = seleziona(finestra.selezionaVisitaRichiesta);
            verbaleML[48] = seleziona(finestra.selezionaAltraVisita);
            verbaleML[49] = finestra.campoAltraVisita.getText();
            verbaleML[50] = seleziona(finestra.selezionaIncondizionata);
            verbaleML[51] = seleziona(finestra.selezionaIdoneitaPerziale);
            verbaleML[52] = seleziona(finestra.selezionaFumoSI);
            verbaleML[53] = seleziona(finestra.selezionaFumoNO);
            
            String n = finestra.campoNrSigarette.getText();
            if(n.length()>0)
                verbaleML[54]= Integer.valueOf(n);
            
            if(finestra.dataFumo.controllo())
                verbaleML[55] = finestra.dataFumo.valore();
            verbaleML[56] = seleziona(finestra.selezionaExFumatore);
            
            if(finestra.dataExFumatore.controllo())
                verbaleML[57] = finestra.dataExFumatore.valore();
            
            verbaleML[58] = seleziona(finestra.selezionaAlcoolSI);
            verbaleML[59] = seleziona(finestra.selezionaAlcoolNO);
            verbaleML[60] = finestra.campoAlvo.getText();
            verbaleML[61] = finestra.campoDiuresi.getText();
            verbaleML[62] = finestra.campoRitmoSonnoVeglia.getText();
            verbaleML[63] = seleziona(finestra.selezionaStatoVaccCompleto);
            verbaleML[64] = seleziona(finestra.selezionaStatoVaccDaCompletare);
            verbaleML[65] = finestra.campoVaccinazioneDaComp.getText();
            verbaleML[66] = seleziona(finestra.selezionaStatoVaccNonDesumibile);
            verbaleML[67] = finestra.campoAnamnesiPatologicaRemota.getText();
            verbaleML[68] = finestra.campoAnamnesiPatologicaProssima.getText();
            verbaleML[69] = finestra.campoIntolleranze.getText();
            verbaleML[70] = finestra.campoTerapieAtto.getText();
            n = finestra.campoPeso.getText();
            if(n.length()>0) {
                verbaleML[71] = Integer.valueOf(n);
            }
            n = finestra.campoStatura.getText();
            if(n.length()>0) {
                verbaleML[72] = Integer.valueOf(n);
            }
            verbaleML[73] = finestra.campoCondizioniGenerale.getText();
            verbaleML[74] = finestra.campoVista.getText();
            verbaleML[75] = finestra.campoUdito.getText();
            verbaleML[76] = finestra.campoAzioneCardiaca.getText();
            n = finestra.campoFrequenza.getText();
            if(n.length()>0)
                verbaleML[77]= Integer.valueOf(n);
             n = finestra.campoPressioneMax.getText();
            if(n.length()>0)
                verbaleML[78]= Integer.valueOf(n);
            n = finestra.campoPressioneMin.getText();
            if(n.length()>0)
                verbaleML[79]= Integer.valueOf(n);
            verbaleML[80] = finestra.campoEsameObiettivoLoc.getText();
            verbaleML[81] = seleziona(finestra.selezioneNullaDiRilevante);
            verbaleML[82] = finestra.campoAccertamenti.getText();
            verbaleML[83] = finestra.campoDiagnosi.getText();
            verbaleML[MODELLO_ML.NOTE] = finestra.campoNote.getText();
            
            verbaleML[MODELLO_ML.ECCESSO_PONDERALE] = seleziona(finestra.selezionaMonitoraggioEccPond);
            n = finestra.campoGiorniEccessoPond.getText();
            if(n.length()>0)
                verbaleML[MODELLO_ML.GIORNI_ECCESSO_PONTERALE] = Integer.valueOf(n);
            
            if(finestra.selezionaMedico.getSelectedIndex() > -1)
                verbaleML[MODELLO_ML.MEDICO] = (String)finestra.selezionaMedico.getSelectedItem();
                
            
            if(!finestra.campoData.erroreCampo()){
                if(nuovoVerbale){
                    if(!DB.aggiungiVerbale(finestra.campoData.valore(),_cognome,_nome,_nascita,verbaleML)){
                        JOptionPane.showMessageDialog(
                                finestra, "Errore: salvataggio non riuscito...", "errore",
                                JOptionPane.ERROR_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(
                                finestra, "Verbale salvato ^_^", "avviso",
                                JOptionPane.INFORMATION_MESSAGE);
                    }


                }else{
                    if(_data.stampa().compareTo(finestra.campoData.valore().stampa())==0){
                        if(javax.swing.JOptionPane.showConfirmDialog(
                                finestra, "Il file gia' esiste, salva le modifiche? O.o", "avviso",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){

                                    if(!DB.modificaVerbale(_data,_cognome,_nome,_nascita,verbaleML)){
                                        JOptionPane.showMessageDialog(
                                        finestra, "Errore: modifica non riuscito...", "errore",
                                        JOptionPane.ERROR_MESSAGE);
                                    }
                        }
                    }else{
                        if(DB.aggiungiVerbale(finestra.campoData.valore(),_cognome,_nome,_nascita,verbaleML)){
                                JOptionPane.showMessageDialog(
                                        finestra, "Salvato nuovo verbale ^_^", "avviso",
                                        JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            if(javax.swing.JOptionPane.showConfirmDialog(
                                finestra, "Il file gia' esiste, salva le modifiche? O.o", "avviso",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){

                                    if(!DB.modificaVerbale(finestra.campoData.valore(),_cognome,_nome,_nascita,verbaleML)){
                                        JOptionPane.showMessageDialog(
                                        finestra, "Errore: modifica non riuscito...", "errore",
                                        JOptionPane.ERROR_MESSAGE);
                                    }
                            }
                        }
                    }
                }
            }else{
                    JOptionPane.showMessageDialog(
                                finestra, "Errore: inserisci data verbale!", "avviso",
                                JOptionPane.ERROR_MESSAGE);
                }
            //this.setVisible(false);
        /*}else{
            javax.swing.JOptionPane.showMessageDialog(
                    this, "Aggiungere n° protocollo e anno!", "avviso",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
        }*/
    }

    private boolean seleziona(JCheckBox casella){
        return casella.getSelectedObjects()!= null;
    }
    
    public void aggiornaICM(){
        if(finestra.campoPeso.getValue() != null && finestra.campoStatura.getValue() != null){
                try{
                    float p = new Float(finestra.campoPeso.getText());
                    float h = new Float(finestra.campoStatura.getText());
                    finestra.campoICM.setText(Float.toString(p/(h*h)*10000));
                }catch(java.lang.NumberFormatException ex){
                }
            }
    }

    public void pulsanteSalva(ActionEvent evt) {
        if (evt.getSource() instanceof javax.swing.JButton) {
            salva();
        }
    }

    public void PrimaStampa(ActionEvent evt) {
        if (evt.getSource() instanceof javax.swing.JButton) {
            salva();
            DatiImpostazioni impostazioni = new DatiImpostazioni();
            FinestraStampatoSemplice f=new FinestraStampatoSemplice();
            String EtichettaVerbale = Stampato.testo("Verbale di visita medica n.", 6, false, Stampato.ALL_CENTRO, 10, 85, Stampato.NO_BORDO, 1);
            String protocollo = Stampato.testo("ML/EI n."+(finestra.campoML_EIprogr.getText().length() > 0 ? finestra.campoML_EIprogr.getText() : "______")+" / "+finestra.campoData.valore().anno(), 6, true, Stampato.ALL_CENTRO, 10, 85, Stampato.NO_BORDO, 1);
            String bloccoVerbale = Stampato.testo(EtichettaVerbale+protocollo+" n.progr.   anno ", 6, false, Stampato.ALL_CENTRO, 30, 90, Stampato.BORDO, 2);

            String unita = Stampato.testo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_INT_REGGIMENTO), 8, true, Stampato.ALL_CENTRO);
            String infermeria = Stampato.testo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_INT_UFFICIO), 8, true, Stampato.ALL_CENTRO);

            String rigo1 = Stampato.testo(new String[]{unita+infermeria,bloccoVerbale}, TIPO_FORMATO_CARATTERI, 11, false, Stampato.ALL_CENTRO, new int[]{300,10});

            String localita = Stampato.testo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_LOCALITA)
                    , 8, false, Stampato.ALL_CENTRO, 10, 20, Stampato.BORDO, 1);
            String eLocalita = Stampato.testo(localita+"Località", 6, false, Stampato.ALL_CENTRO, 10, 20, Stampato.NO_BORDO, 1);

            String provincia = Stampato.testo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_PROVINCIA),
                    8, false, Stampato.ALL_CENTRO, 10, 20, Stampato.BORDO, 1);
            String eProvincia = Stampato.testo(provincia+"Prov.", 6, false, Stampato.ALL_CENTRO, 10, 20, Stampato.NO_BORDO, 1);

            String asl = Stampato.testo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_ASL),
                    8, false, Stampato.ALL_CENTRO, 10, 100, Stampato.BORDO, 1);
            String eAsl = Stampato.testo(asl+"A.S.L. di competenza per l'Ente", 6, false, Stampato.ALL_CENTRO, 10, 20, Stampato.NO_BORDO, 1);

            String rigo2 = Stampato.testo(new String[]{eLocalita,eProvincia,eAsl}, TIPO_FORMATO_CARATTERI, 11, false, Stampato.ALL_CENTRO, new int[]{200,10,100});

            String via = Stampato.testo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_VIA), 
                    8, false, Stampato.ALL_CENTRO, 10, 20, Stampato.BORDO, 1);
            String eVia = Stampato.testo(via+"Via/Viale/Corso/Piazza/Piazzale/Vocabolo/Strada", 6, false, Stampato.ALL_CENTRO, 10, 20, Stampato.NO_BORDO, 1);

            String nCivico = Stampato.testo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_N_CIVICO), 
                    8, false, Stampato.ALL_CENTRO, 10, 30, Stampato.BORDO, 1);
            String eNCivico = Stampato.testo(nCivico+"n. civico", 6, false, Stampato.ALL_CENTRO, 10, 30, Stampato.NO_BORDO, 1);

            String cap = Stampato.testo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_CAP), 
                    8, false, Stampato.ALL_CENTRO, 10, 100, Stampato.BORDO, 1);
            String eCap = Stampato.testo(cap+"C.A.P.", 6, false, Stampato.ALL_CENTRO, 10, 20, Stampato.NO_BORDO, 1);

            String rigo3 = Stampato.testo(new String[]{eVia,eNCivico,eCap}, TIPO_FORMATO_CARATTERI, 11, false, Stampato.ALL_CENTRO, new int[]{250,30,100});


            String sotrin = Stampato.testo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_TEL_SOTRIN),
                    8, false, Stampato.ALL_CENTRO, 5, 100, Stampato.BORDO, 1);
            String eSotrin = Stampato.testo(sotrin+"recapito telefonico SOTRIN", 6, false, Stampato.ALL_CENTRO, 5, 100, Stampato.NO_BORDO, 1);

            String telecom = Stampato.testo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_TEL_TELECOM),
                    8, false, Stampato.ALL_CENTRO, 5, 150, Stampato.BORDO, 1);
            String eTelecom = Stampato.testo(telecom+"recapito telefonico Telecom", 6, false, Stampato.ALL_CENTRO, 5, 150, Stampato.NO_BORDO, 1);

            String altro = Stampato.testo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_TEL_ALTRO)
                    , 8, false, Stampato.ALL_CENTRO, 5, 100, Stampato.BORDO, 1);
            String eAltro = Stampato.testo(altro+"altro", 6, false, Stampato.ALL_CENTRO, 5, 100, Stampato.NO_BORDO, 1);

            String rigo4 = Stampato.testo(new String[]{eSotrin,eTelecom,eAltro},TIPO_FORMATO_CARATTERI, 11, false, Stampato.ALL_CENTRO, new int[]{100,150,150});

            String fax = Stampato.testo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_FAX)
                    , 8, false, Stampato.ALL_CENTRO, 5, 100, Stampato.BORDO, 1);
            String eFax = Stampato.testo(fax+"fax", 6, false, Stampato.ALL_CENTRO, 5, 100, Stampato.NO_BORDO, 1);

            String postaElettronica  = Stampato.testo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_MAIL_DSS),
                    8, false, Stampato.ALL_CENTRO, 5, 200, Stampato.BORDO, 1);
            String ePostaElettronica = Stampato.testo(postaElettronica+"indirizzo di posta elettronica", 6, false, Stampato.ALL_CENTRO, 5, 200, Stampato.NO_BORDO, 1);

            String rigo5 = Stampato.testo(new String[]{eFax,ePostaElettronica},TIPO_FORMATO_CARATTERI, 11, false, Stampato.ALL_CENTRO, new int[]{300,400});

            String intestazione = Stampato.testo(rigo1+"<br>"+rigo2+"<br>"+rigo3+"<br>"+rigo4+"<br>"+rigo5, 12, false, Stampato.ALL_SINISTRA, 50, 375, Stampato.BORDO, 1);

            f.aggiungiTesto(intestazione);


            String nominativo = finestra.testoGrado.getText() +" "+finestra.testoNome.getText() +" "+ finestra.testoCognome.getText();
            f.aggiungiTesto("");
            f.aggiungiTesto("A: "+finestra.campoReparto.getSelectedItem());
            f.aggiungiTesto("A richiesta di "+finestra.selezionaRichiedente.getSelectedItem()); 

            if(finestra.selezionaVisitaMedica.getSelectedObjects()!=null){
                f.aggiungiTesto(X+"ho sottoposto a visita medica il "+nominativo);
            }else{
                f.aggiungiTesto(L+"ho sottoposto a visita medica il ");
            }

            if(finestra.selezionaControlloCertificato.getSelectedObjects() != null){
                f.aggiungiTesto(X+"ho esaminato il certificato medico inviato dal "+nominativo);
            }else{
                f.aggiungiTesto(L+"ho esaminato il certificato medico inviato dal ");
            }

            f.aggiungiTesto("nato a "+finestra.testoLuogo.getText()+ " il "+finestra.valoreGiornoNascita.getText()+"/"+finestra.valoreMeseNascita.getText()+"/"+finestra.valoreAnnoNascita.getText());
            f.aggiungiTesto("in servizio presso "+finestra.campoReparto.getSelectedItem());
            f.aggiungiTesto("con l'incarico di "+finestra.campoIncarico.getText());
            f.aggiungiTesto("");
            f.aggiungiTesto("Per quanto desumibile dagli atti e dalle risultanze clinico-diagnostiche riportate in retropagina, il dipendente/militare è:");
            f.aggiungiTesto((finestra.selezionaIdoneità.getSelectedObjects() != null ? X : L)+"in condizioni psico-fisiche tali da potersi confermare l'idoneità al servizio già posseduta (specificata in retropagina)");
            f.aggiungiTesto(
                    "Impiego in T.O. <u>"+trattino+(finestra.campoTO.getText().length() > 0 ? finestra.campoTO.getText() : trattino+trattino+trattino+trattino+trattino+trattino+trattino+trattino+trattino+trattino+trattino+trattino+trattino+trattino+trattino+trattino)+"</u> : "+
                    (finestra.selezionaIdoneitàTO.getSelectedObjects() != null ? X : L)+"idoneo"+trattino+trattino+trattino+trattino+trattino+
                    (finestra.selezionaTempNonIdoneoTO.getSelectedObjects() != null ? X : L)+"t.n.i. per mesi <u>"+trattino+(finestra.campoMesiNonIdoneoTO.getText().length() > 0 ? finestra.campoMesiNonIdoneoTO.getText() : trattino+trattino+trattino+trattino+trattino)+"</u>"+trattino+trattino+trattino+
                    (finestra.selezionaPermanentementeNonIdTO.getSelectedObjects() != null ? X : L)+"permanentemente non idoneo.");
            f.aggiungiTesto(
                    "Controindicazioni alle prove di efficienza operativa:"+trattino+
                    (finestra.selezionaAssentiContrEO.getSelectedObjects() != null ? X : L)+"assenti"+trattino+trattino+
                    (finestra.selezionaTempContrEO.getSelectedObjects() != null ? X : L)+"temporanee per <u>"+trattino+
                    (finestra.campoMesiNonIdoneoEO.getText().length() > 0 ? finestra.campoMesiNonIdoneoEO.getText() : trattino+trattino)+"</u>"+trattino+trattino+trattino+trattino+
                    (finestra.selezionaPermanentementeNonId.getSelectedObjects() != null ? X : L)+"permanenti.");
            f.aggiungiTesto(
                    (finestra.selezionaSottoporreVisitaFiscale.getSelectedObjects() != null ? X : L)+"da sottoporre a visita fiscale secondo le modalità previste dalle disposizioni vigenti"
            );

            f.aggiungiTesto(
                    (finestra.selezionaAmmalato.getSelectedObjects() != null ? X : L)+"AMMALATO"+trattino+trattino+trattino+trattino+trattino+trattino+trattino+trattino+trattino+trattino+" con prognosi clinica inabilitante fina al "+
                    (finestra.dataAmmalato.valore() != null ? finestra.dataAmmalato.valore().stampaGiorno('/') : trattino+trattino+trattino+trattino+trattino)+" s.c."
            );

            f.aggiungiTesto(
                    (finestra.selezionaConvalescente.getSelectedObjects() != null ? X : L)+"CONVALESCENTE"+trattino+trattino+trattino+trattino+trattino+trattino+"con prognosi clinica inabilitante fina al "+
                    (finestra.dataConvalescente.valore() != null ? finestra.dataConvalescente.valore().stampaGiorno('/') : trattino+trattino+trattino+trattino+trattino)+" s.c."
            );
            f.aggiungiTesto(
                    (finestra.selezionaTempNonIdoneoServizio.getSelectedObjects() != null ? X : L)+"TEMPORANEAMENTE NON IDONEO AL SERVIZIO in attesa di invio in:"+trattino+trattino+
                    (finestra.selezionaTempNonIDInvioCMO.getSelectedObjects() != null ? X : L)+"C.M.O."+trattino+trattino+
                    (finestra.selezionaTempNonIDInvioOsservazione.getSelectedObjects() != null ? X : L)+"Osservazione"
            );
            f.aggiungiTesto(
                    (finestra.selezionaImpiegoIncarTecnicoAmm.getSelectedObjects() != null ? X : L)+"da impiegare in incarichi tecnico-amministrativi in attesa di invio in:"+trattino+trattino+trattino+trattino+trattino+trattino+trattino+trattino+trattino+trattino+
                    (finestra.selezionaIncarTecnicoAmmCMO.getSelectedObjects() != null ? X : L)+"C.M.O."+trattino+trattino+
                    (finestra.selezionaIncarTecnicoAmmOsservazione.getSelectedObjects() != null ? X : L)+"Osservazione"
            );
            f.aggiungiTesto(
                    (finestra.selezionaMonitoraggioEccPond.getSelectedObjects() != null ? X : L)+"in monitoraggio ai sensi delle \"linee guida per il trattamento delle condizioni di eccesso ponderale\" per gg. "+trattino+trattino+
                    "<u><b>"+finestra.campoGiorniEccessoPond.getText()+"</b></u>"
            );
            f.aggiungiTesto("");
            f.aggiungiTesto("Lo stato di malattia/convalescenza è determinato da:");

            String rigo0 = Stampato.testo(
                    new String[]{
                        (finestra.selezionaCausaInfermitàLes.getSelectedObjects() != null ? X : L)+"infermità/lesioni che, sulla base degli atti disponibili, risultano ",
                        (finestra.selezionaCausaInfermitàLesEsclusivamente.getSelectedObjects() != null ? X : L)+"esclusivamente",
                        (finestra.selezionaCausaInfermitàLesPrevalente.getSelectedObjects() != null ? X : L)+"in misura prevalente"
                    }, 
                    TIPO_FORMATO_CARATTERI, 8, false, Stampato.ALL_SINISTRA, new int[]{300,70,100}
            );
            rigo1 = Stampato.testo((finestra.selezionaCausaInfermitàLesDipendenteCausaServ.getSelectedObjects() != null ? X : L)+"SI dipendenti da causa di servizio;", 8, false, Stampato.ALL_SINISTRA);
            rigo2 = Stampato.testo((finestra.selezionaCausaInfermitàLesNonDipendenteCausaServ.getSelectedObjects() != null ? X : L)+"NON dipendenti da causa di servizio;", 8, false, Stampato.ALL_SINISTRA);
            rigo3 = Stampato.testo((finestra.selezionaCausaInfermitàLesAccertamentoDipendenteCausaServ.getSelectedObjects() != null ? X : L)+"in corso di accertamento per la dipendenza;", 8, false, Stampato.ALL_SINISTRA);
            rigo4 = Stampato.testo((finestra.selezionaCausaInfermitàLesNonOggettoAcc.getSelectedObjects() != null ? X : L)+"non oggetto di accertamento per la dipendenza;", 8, false, Stampato.ALL_SINISTRA);

            String blocco = Stampato.testo(new String[]{"",rigo1+rigo2+rigo3+rigo4},TIPO_FORMATO_CARATTERI, 8, false, Stampato.ALL_SINISTRA, new int[]{250,200});
            rigo5 = Stampato.testo((finestra.selezionaCausaFeriteLesioniTr.getSelectedObjects() != null ? X : L)+"ferie o lesioni traumatiche riportate in servizio", 8, false, Stampato.ALL_SINISTRA);
            String rigo6 = Stampato.testo((finestra.selezionaCausaInfermitàInsorte.getSelectedObjects() != null ? X : L)+"infermità insorte a seguito di missioni internazionali o in attività addestrative o operative", 8, false, Stampato.ALL_SINISTRA);

            String blocco2 = Stampato.testo(rigo0+blocco+rigo5+rigo6, 8, false, Stampato.ALL_SINISTRA);

            f.aggiungiTesto(blocco2);

            f.aggiungiTesto("");
            f.aggiungiTesto("NOTE / CONTROINDICAZIONI / MOTIVAZIONI:");
            String note = finestra.campoNote.getText();
            f.aggiungiTesto(note);

            String data = Stampato.testo("data "+(finestra.campoData.valore()!=null?finestra.campoData.valore().stampaGiorno('/'):""), 8, false, Stampato.ALL_SINISTRA);
            String eMedico = Stampato.testo("UFFICIALE MEDICO", 8, false, Stampato.ALL_CENTRO);

            String bloccoFirma = Stampato.testo(new String[]{data,eMedico+finestra.selezionaMedico.getSelectedItem()},TIPO_FORMATO_CARATTERI, 8, false, Stampato.ALL_CENTRO, new int[]{250,200});

            f.aggiungiTesto(bloccoFirma);
            f.aggiungiTesto(L+"il presente verbale sarà consegnato al Comando di appartenenza a cura dell'interessato",6,false,Stampato.ALL_SINISTRA);
            f.aggiungiTesto("<br />firma:............................................................",6,false,Stampato.ALL_SINISTRA);
            
            Finestra.creaFinestra(f);
            
        }
        
    }

    public void SecondaStampa(ActionEvent evt) {
        if (evt.getSource() instanceof javax.swing.JButton) {
            
            final int DIM  = 7;
            salva();
            FinestraStampatoSemplice f=new FinestraStampatoSemplice();

            String protocollo = Stampato.testo("VERBALE DI VISITA MEDICA  ML / EI n "+(finestra.campoML_EIprogr.getText().length() > 0 ? finestra.campoML_EIprogr.getText() : "______")+" / "+finestra.campoData.valore().anno(), 7, false, Stampato.ALL_DESTRA, 5, 370, Stampato.BORDO, 1);
            f.aggiungi(protocollo);

            f.aggiungi(Stampato.testo(
                    new String[]{
                        (finestra.selezionaVisitaPeriodica.getSelectedObjects() != null ? X : L)+" VISITA PERIODICA",
                        (finestra.selezionaControlloCert.getSelectedObjects() != null ? X : L)+" CONTROLLO CERTIFICAZIONE MEDICA"
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{200,200})
            );
            f.aggiungi(Stampato.testo(
                    new String[]{
                        "IMPIEGO FUORI AREA in: "+finestra.campoTO_riepilogo.getText(),
                        (finestra.selezionaVisitaPreimpiegoTO.getSelectedObjects() != null ? X : L)+" VISITA PREIMPIEGO",
                        (finestra.selezionaVisitaRientroTO.getSelectedObjects() != null ? X : L)+" VISITA AL RIENTRO"
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{170,100,100})
            );
            f.aggiungi(Stampato.testo(
                    new String[]{
                        (finestra.selezionaVisitaTermineMalConv.getSelectedObjects() != null ? X : L)+" VISITA AL TERMINE DI UN PERIODO DI MALATTIA / CONVALESCENZA"
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{300})
            );
            f.aggiungi(Stampato.testo(
                    new String[]{
                        (finestra.selezionaVisitaFiscale.getSelectedObjects() != null ? X : L)+" VISITA FISCALE",
                        (finestra.selezionaVisitaRichiesta.getSelectedObjects() != null ? X : L)+" VISITA RICHIESTA DALL'INTERESSATO"
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{200,200})
            );
            f.aggiungi(Stampato.testo(
                    new String[]{
                        (finestra.selezionaAltraVisita.getSelectedObjects() != null ? X : L)+" ALTRO: "+finestra.campoAltraVisita.getText()
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{300})
            );
            f.aggiungi("<b>__________________________________________________________________________________________________________</b>");

            f.aggiungi(Stampato.testo(
                    new String[]{
                        Stampato.testo("A. ANAMNESI ", 7, true, Stampato.ALL_SINISTRA, 5, 70, Stampato.BORDO, 1),
                        " Idoneità al servizio già posseduta: ",
                        (finestra.selezionaIncondizionata.getSelectedObjects() != null ? X : L)+" incondizionata ",
                        (finestra.selezionaIdoneitaPerziale.getSelectedObjects() != null ? X : L)+" inidoneità parziale"
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{90,120,70,70})
            );
            f.aggiungi(Stampato.testo(
                    new String[]{
                        "<b>Fumo:</b> ",
                        "SI "+(finestra.selezionaFumoSI.getSelectedObjects() != null ? X : L),
                        "NO "+(finestra.selezionaFumoNO.getSelectedObjects() != null ? X : L),
                        "("+finestra.campoNrSigarette.getText()+" sigarette/die dal "+(finestra.dataFumo.valore() != null ? finestra.dataFumo.valore().stampaGiorno('/'):"_________")+")",
                        "EX "+(finestra.selezionaExFumatore.getSelectedObjects() != null ? X : L),
                        "(fino al "+(finestra.dataExFumatore.valore() != null ? finestra.dataExFumatore.valore().stampaGiorno('/'):"_________")+")",
                        "<b>Alcool:</b> ",
                        "SI "+(finestra.selezionaAlcoolSI.getSelectedObjects() != null ? X : L),
                        "NO "+(finestra.selezionaAlcoolNO.getSelectedObjects() != null ? X : L)
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{20,20,25,120,25,70,20,20,25})
            );
            f.aggiungi(Stampato.testo(
                    new String[]{
                        "<b>Alvo:</b> "+finestra.campoAlvo.getText(),
                        "<b>Diuresi:</b> "+finestra.campoDiuresi.getText(),
                        "<b>Ritmo sonno/veglia:</b> "+finestra.campoRitmoSonnoVeglia.getText()
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{120,120,120})
            );
            f.aggiungi(Stampato.testo(
                    new String[]{
                        "<b>Stato vaccinale: </b> ",
                        (finestra.selezionaStatoVaccCompleto.getSelectedObjects() != null ? X : L)+" completo",
                        (finestra.selezionaStatoVaccDaCompletare.getSelectedObjects() != null ? X : L)+" da completare: "+finestra.campoVaccinazioneDaComp.getText(),
                        (finestra.selezionaStatoVaccNonDesumibile.getSelectedObjects() != null ? X : L)+" non desumibile"
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{70,50,150,70})
            );
            f.aggiungi(Stampato.testo(
                    new String[]{
                        "<b>Anamnesi Patologica Remota</b>"
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{200})
            );
            f.aggiungi(Stampato.testo(
                    new String[]{
                        Stampato.testo(finestra.campoAnamnesiPatologicaRemota.getText(), 7, false, Stampato.ALL_SINISTRA, 20, 370, Stampato.NO_BORDO, 1)
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{350})
            );
            f.aggiungi(Stampato.testo(
                    new String[]{
                        "<b>Anamnesi Patologica Prossima e Disturbi Attuali</b>"
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{200})
            );
            f.aggiungi(Stampato.testo(
                    new String[]{
                        Stampato.testo(finestra.campoAnamnesiPatologicaProssima.getText(), 7, false, Stampato.ALL_SINISTRA, 20, 370, Stampato.NO_BORDO, 1)
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{350})
            );
            f.aggiungi(Stampato.testo(
                    new String[]{
                        "Intolleranze/allergie: "+finestra.campoIntolleranze.getText(),
                        "Terapie in atto: "+finestra.campoTerapieAtto.getText()
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{150,150})
            );
            f.aggiungi("<b>__________________________________________________________________________________________________________</b>");
            f.aggiungi(Stampato.testo(
                    new String[]{
                        Stampato.testo("B. ESAME OBIETTIVO ", 7, true, Stampato.ALL_SINISTRA, 5, 100, Stampato.BORDO, 1),
                        " Peso kg <b><u>"+finestra.campoPeso.getText()+"</u></b>",
                        " Statura cm <b><u>"+finestra.campoStatura.getText()+"</u></b>",
                        " I.M.C. <b><u>"+finestra.campoICM.getText()+"</u></b>"
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{150,50,100,100})
            );
            f.aggiungi(Stampato.testo(
                    new String[]{
                        " Condizioni generali: "+finestra.campoCondizioniGenerale.getText(),
                        " Vista: "+finestra.campoVista.getText(),
                        " Udito: "+finestra.campoUdito.getText()
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{150,150,150})
            );
            f.aggiungi(Stampato.testo(
                    new String[]{
                        " Azione cardiaca: "+finestra.campoAzioneCardiaca.getText(),
                        " Frequenza cardiaca: "+finestra.campoFrequenza.getText()+"bpm",
                        " Pressione arteriosa: "+finestra.campoPressioneMax.getText()+"/"+finestra.campoPressioneMin.getText()+"mmHg"
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{140,120,120})
            );
            f.aggiungi(Stampato.testo(
                    new String[]{
                        "<b>Esame obiettivo locale:</b>"
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{200})
            );
            f.aggiungi(Stampato.testo(
                    new String[]{
                        Stampato.testo(finestra.campoEsameObiettivoLoc.getText(), 7, false, Stampato.ALL_SINISTRA, 20, 370, Stampato.NO_BORDO, 1)
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{350})
            );
            f.aggiungi(Stampato.testo(
                    new String[]{
                        (finestra.selezioneNullaDiRilevante.getSelectedObjects() != null ? X : L)+"nulla di rilevante ai fini della presente valutazione, a carico dei restanti sistemi, organi ed apparati esplorati."
                    }, TIPO_FORMATO_CARATTERI, DIM-1, false, Stampato.ALL_SINISTRA, new int[]{300})
            );
            f.aggiungi("<b>__________________________________________________________________________________________________________</b>");
            f.aggiungi(Stampato.testo(
                    new String[]{
                        Stampato.testo("C. ACCERTAMENTI ", 7, true, Stampato.ALL_SINISTRA, 5, 100, Stampato.NO_BORDO, 1)
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{300})
            );
            f.aggiungiTesto(Stampato.testo(
                    new String[]{
                        Stampato.testo(finestra.campoAccertamenti.getText(), 7, false, Stampato.ALL_SINISTRA, 20, 370, Stampato.NO_BORDO, 1)
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{350})
            );
            f.aggiungi("<b>__________________________________________________________________________________________________________</b>");
            f.aggiungi(Stampato.testo(
                    new String[]{
                        Stampato.testo("D. DIAGNOSI ", 7, true, Stampato.ALL_SINISTRA, 5, 100, Stampato.NO_BORDO, 1)
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{300})
            );
            f.aggiungi(Stampato.testo(
                    new String[]{
                        Stampato.testo(finestra.campoDiagnosi.getText(), 7, false, Stampato.ALL_SINISTRA, 20, 370, Stampato.NO_BORDO, 1)
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{350})
            );
            f.aggiungi("<b>__________________________________________________________________________________________________________</b>");
            f.aggiungi(Stampato.testo(
                    new String[]{
                        "<b>E. Giudizio medico-legale: riportato sul MODELLO ML/EI</b> (Conforme alla Direttiva 5000/2007), <b>in allegato</b>"
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{400})
            );

            f.aggiungi(Stampato.testo(
                    new String[]{
                        Stampato.testo("<b>F. Note:</b>"+finestra.campoNote.getText(), 7, false, Stampato.ALL_SINISTRA, 20, 370, Stampato.NO_BORDO, 1)
                    }, TIPO_FORMATO_CARATTERI, DIM, false, Stampato.ALL_SINISTRA, new int[]{350})
            );

            String data = Stampato.testo("data "+(finestra.campoData.valore()!=null?finestra.campoData.valore().stampaGiorno('/'):""), 7, false, Stampato.ALL_SINISTRA);
            String eMedico = Stampato.testo("UFFICIALE MEDICO", 7, false, Stampato.ALL_CENTRO);
            String bloccoFirma = Stampato.testo(new String[]{data,eMedico+finestra.selezionaMedico.getSelectedItem()}, TIPO_FORMATO_CARATTERI, 8, false, Stampato.ALL_CENTRO, new int[]{200,200});
            f.aggiungi(bloccoFirma);

            f.aggiungiTesto(""); 
            f.aggiungiTesto(X + " confermo l'esattezza dei dati anamnestici sopra riportati e di quelli contenuti nella scheda Anagrafica Personale", 5, false, Stampato.ALL_SINISTRA);
            f.aggiungiTesto(X + " prendo visione del giudizio espresso in retropagina, della quale ho ben compreso le ricadute amministrative", 5, false, Stampato.ALL_SINISTRA);
            f.aggiungiTesto("<br><br>firma:............................................................",6,false,Stampato.ALL_SINISTRA);
            
            Finestra.creaFinestra(f);
        }
    }

    public void pulsanteModelloGL(ActionEvent evt) {
        if(evt.getSource() instanceof javax.swing.JButton){
            if(verbaleML != null){//se è avvenuto il salvataggio
                Finestra.creaFinestra(new FinestraModelloGL(verbaleML));
            }
        }
    }
    
    public void stampaAllegatoD(ActionEvent evt) {
        if(evt.getSource() instanceof javax.swing.JButton){
            DatiImpostazioni impostazioni = new DatiImpostazioni();
            final int DIM  = 7;
            salva();
            
            FinestraStampatoSemplice f=new FinestraStampatoSemplice();

            
            String unita = Stampato.testo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_INT_REGGIMENTO), 8, true, Stampato.ALL_CENTRO);
            String infermeria = Stampato.testo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_INT_UFFICIO), 8, true, Stampato.ALL_CENTRO);

            String intestazione = Stampato.testo("ALLEGATO D", 8, false, Stampato.ALL_DESTRA);
            f.aggiungi(intestazione);
            
            f.aggiungi(unita);
            f.aggiungi(infermeria);
            f.aggiungi("");
            
            f.aggiungiTesto("NULLA OSTA SANITARIO AI FINI DELL'ESECUZIONE DELLE PROVE DI EFFICENZA FISICA", 8, false, Stampato.ALL_SINISTRA);
            
            f.aggiungi("");
            
            f.aggiungiTesto("Si comunica che a seguito della visita medica del giorno <u>"+_data.stampaGiorno('/')+"</u> è stata adottata nei confronti del militare:", 7, false, Stampato.ALL_SINISTRA);
            f.aggiungiTesto(_grado + " "+_cognome + " "+_nome, 8, false, Stampato.ALL_SINISTRA);
            f.aggiungiTesto("la seguente decisione sanitaria:", 7, false, Stampato.ALL_SINISTRA);
            
            f.aggiungiTesto("", 7, false, Stampato.ALL_SINISTRA);
            
            
            f.aggiungiTesto((finestra.selezionaIdoneità.getSelectedObjects() != null ? X : L )+"Nulla Osta all'esercitazione delle prove di efficienza fisica");
            f.aggiungiTesto(L+"Sospeso in attesa di ulteriori accertamenti.");
            f.aggiungiTesto((finestra.selezionaTempContrEO.getSelectedObjects() != null ? X : L) +"Controindicazione temporanea all'esercitazione delle prove di efficenza fisica per "+
                    ((finestra.campoMesiNonIdoneoEO.getText().length() > 0) ? ("<u>"+finestra.campoMesiNonIdoneoEO.getText()+"</u>") : "_________________")
                    +"  (max 5 mesi)");
            
            f.aggiungiTesto("", 7, false, Stampato.ALL_SINISTRA);
            f.aggiungiTesto("", 7, false, Stampato.ALL_SINISTRA);
            
            String data = Stampato.testo("data "+(finestra.campoData.valore()!=null?finestra.campoData.valore().stampaGiorno('/'):""), 7, false, Stampato.ALL_SINISTRA);
            String eMedico = Stampato.testo("UFFICIALE MEDICO", 7, false, Stampato.ALL_CENTRO);
            String bloccoFirma = Stampato.testo(new String[]{data,eMedico+finestra.selezionaMedico.getSelectedItem()}, TIPO_FORMATO_CARATTERI, 8, false, Stampato.ALL_CENTRO, new int[]{200,200});
            f.aggiungi(bloccoFirma);

            
            Finestra.creaFinestra(f);
        }
    }
}
