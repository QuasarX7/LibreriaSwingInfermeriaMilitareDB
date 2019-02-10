package it.difesa.esercito.rav17.infermeria.controllo;

import it.quasar_x7.java.swing.finestra.Finestra;
import it.quasar_x7.java.swing.stampa.FinestraStampatoSemplice;
import it.quasar_x7.java.swing.stampa.Stampato;
import it.quasar_x7.java.swing.stampa.StampatoVerticale;
import it.difesa.esercito.rav17.infermeria.DaseDati.DatiImpostazioni;
import it.difesa.esercito.rav17.infermeria.DaseDati.DatiMedico;
import it.difesa.esercito.rav17.infermeria.DaseDati.DatiMilitare;
import it.difesa.esercito.rav17.infermeria.DaseDati.DatiModelloGL;
import it.difesa.esercito.rav17.infermeria.vista.FinestraAggiungiCausaDiServizio;
import it.difesa.esercito.rav17.infermeria.vista.FinestraModelloGL;
import it.quasar_x7.java.utile.DataOraria;
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
public final class FinestraModelloGLController {

    private final String TIPO_FORMATO_CARATTERI = "Times New Roman";
    private final DatiModelloGL datiModelloGL = new DatiModelloGL();
    private final DatiMilitare datiMilitare = new DatiMilitare();
    private final String X  = " \u22A0 ";
    private final String L  = " \u29E0 ";
    private final String trattino  = " &nbsp; ";
    private Object[][] valoriTab;
    private final FinestraModelloGL finestra;

 
    /**
     * 
     * @param finestra
     * @param data
     * @param militare
     * @param verifica se true verifica la presenza di eventuali altri modelli GL
     */
    public FinestraModelloGLController(FinestraModelloGL finestra, DataOraria data, Object[] militare, boolean verifica) {
        this.finestra=finestra;
        finestra.selezionaMedico.setModel(
                new javax.swing.DefaultComboBoxModel(
                new DatiMedico().tuttiMedici().toArray()));
        finestra.selezionaMedico.setSelectedIndex(-1);
        finestra.selezionaRelazioneAllegata.setSelectedIndex(-1);
        finestra.selezionaProspettoConv.setSelectedIndex(-1);
        finestra.selezionaDocMatricolare.setSelectedIndex(-1);
        finestra.selezionaCertificatoAssenza.setSelectedIndex(-1);
        caricaDati(data,militare,verifica);
        caricaPannelloNominativo(militare);
        caricaTabella();
    }

    public FinestraModelloGLController(FinestraModelloGL finestra, Object[] verbaleML) {
        this.finestra=finestra;
        finestra.selezionaMedico.setModel(
                new javax.swing.DefaultComboBoxModel(
                new DatiMedico().tuttiMedici().toArray()));
        finestra.selezionaMedico.setSelectedIndex(-1);
        finestra.selezionaRelazioneAllegata.setSelectedIndex(-1);
        finestra.selezionaProspettoConv.setSelectedIndex(-1);
        finestra.selezionaDocMatricolare.setSelectedIndex(-1);
        finestra.selezionaCertificatoAssenza.setSelectedIndex(-1);
        Object militare[] = datiMilitare.trovaMilitare((String)verbaleML[0],(String)verbaleML[1],(DataOraria)verbaleML[2]);
        caricaDati((DataOraria)verbaleML[3],militare,false);
        caricaPannelloNominativo(militare);
        caricaTabella();
        finestra.testoAnamnesi.setText((String)verbaleML[68]);
        finestra.testoGiudizioDiagnostico.setText((String)verbaleML[83]);
        finestra.testoEsameObiettivo.setText((String)verbaleML[80]);
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
        finestra.testoIncarico.setText((String)militare[35]);
        finestra.testoResidenza.setText((String)militare[33]);
        finestra.testoIndirizzo.setText((String)militare[34]);
        finestra.testoASL.setText((String)militare[36]);
        
         
    }
    
    private void caricaDati(DataOraria data,Object[] militare,boolean verifica){
        if(data!=null) {
            finestra.campoData.carica(data.giornoMese(), data.mese(), data.anno());
        }
        
        Object[] moduloGL = datiModelloGL.vediModelloGL(
                data, 
                (String)militare[0],
                (String)militare[1], 
                (DataOraria)militare[2]);
       
        if(moduloGL != null){
            if(verifica){
                JOptionPane.showMessageDialog(
                                    finestra, 
                                    "Modello già presente!", "errore",
                                    javax.swing.JOptionPane.ERROR_MESSAGE); 
                finestra.setVisible(false);
            }
            if(moduloGL[5]!=null)
                finestra.selezionaRelazioneAllegata.setSelectedIndex( (Boolean)moduloGL[5] ? 1 : 0);
            finestra.testoElementiNonSanitari.setText((String)moduloGL[4]);
            if(moduloGL[6] != null)
                finestra.dataFruizione.setDate(((DataOraria)moduloGL[6]).convertiDate());
            finestra.testoNumeroGiorni.setText(""+(Long)moduloGL[7]);
            if(moduloGL[8]!=null)
                finestra.selezionaProspettoConv.setSelectedIndex( (Boolean)moduloGL[8] ? 1 : 0);
            finestra.testoAllegatoProspettoConv.setText(""+(Long)moduloGL[9]);
            if(moduloGL[10]!=null)
                finestra.selezionaDocMatricolare.setSelectedIndex( (Boolean)moduloGL[10] ? 1 : 0);
            finestra.testoAllegatoDocMatricolare.setText(""+(Long)moduloGL[11]);
            if(moduloGL[12]!=null)
                finestra.selezionaCertificatoAssenza.setSelectedIndex( (Boolean)moduloGL[12] ? 1 : 0);
            finestra.testoAllegatoselezionaCertificatoAssenza.setText(""+(Long)moduloGL[13]);
            finestra.selezionaSuperamentoAssenza.setSelected((Boolean)moduloGL[14]);
            finestra.selezionaTerminePeriodoAssenza.setSelected((Boolean)moduloGL[15]);
            finestra.testoPeriodoAssenza.setText((String)moduloGL[16]);
            finestra.selezionaPersistenzaIdoneita.setSelected((Boolean)moduloGL[30]);
            finestra.selezionaPresuntaPerditaIdoneita.setSelected((Boolean)moduloGL[17]);
            finestra.selezionaAltreInabilita.setSelected((Boolean)moduloGL[18]);
            finestra.testoFormeInabilita.setText((String)moduloGL[19]);
            finestra.selezionaCausaServizio.setSelected((Boolean)moduloGL[20]);
            finestra.selezionaSuRichiesta.setSelected((Boolean)moduloGL[21]);
            finestra.selezionaAltro.setSelected((Boolean)moduloGL[22]);
            finestra.testoAltro.setText((String)moduloGL[23]);
            if(moduloGL[24]!=null)
                finestra.selezionaRiconosciutoTempNonIdoneo.setSelectedIndex( (Boolean)moduloGL[24] ? 0 : 1);
            finestra.testoAltriElementiSanitari.setText((String)moduloGL[25]);
            finestra.testoAnamnesi.setText((String)moduloGL[26]);
            finestra.testoEsameObiettivo.setText((String)moduloGL[27]);
            finestra.testoGiudizioDiagnostico.setText((String)moduloGL[28]);
            if(moduloGL[29]!= null)
                    finestra.selezionaMedico.setSelectedItem((String)moduloGL[29]);
        }
    }
    
    public void limite(javax.swing.event.CaretEvent evt,javax.swing.JTextArea campo, int max){
        if(evt.getSource() instanceof javax.swing.JTextArea ){
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
    
    private void salva(){
        // raccolta dei dati (militare) contenuti nelle caselle della maschera
            Object[] militare = new Object[datiMilitare.dimensioneMilitate()];
            militare[1] = finestra.testoNome.getText();
            militare[0] = finestra.testoCognome.getText();
            militare[2] = new DataOraria(
                    Integer.valueOf(finestra.valoreGiornoNascita.getText()),
                    Integer.valueOf(finestra.valoreMeseNascita.getText()),
                    Integer.valueOf(finestra.valoreAnnoNascita.getText()));
            militare[3] = finestra.testoLuogo.getText();
            militare[4] = finestra.testoGrado.getText();
            militare[6] = finestra.testoReparto.getText();
            
            militare[25] = Finestra.utente;
            DataOraria modifica = new DataOraria();
            modifica.adesso();
            militare[28] = modifica;
            
            militare[35] = finestra.testoIncarico.getText();
            militare[33] = finestra.testoResidenza.getText();
            militare[34] = finestra.testoIndirizzo.getText();
            militare[36] = finestra.testoASL.getText();
            
           //modifica il record (del militare) coi i dati di misurazione
            datiMilitare.modificaMilitare((String)militare[0], (String)militare[1], (DataOraria)militare[2], militare);
            
            
            
            Object[] modelloGL = new Object[datiModelloGL.dimensioneModelloGL()];
            
            if(finestra.selezionaRelazioneAllegata.getSelectedIndex()>-1){
                if(((String)finestra.selezionaRelazioneAllegata.getSelectedItem()).compareTo("SI")==0){
                    modelloGL[5] = true;
                }else if(((String)finestra.selezionaRelazioneAllegata.getSelectedItem()).compareTo("NO")==0){
                    modelloGL[5] = false; 
                }
            }
            if(finestra.testoElementiNonSanitari.getText().length()>0){
                modelloGL[4]=finestra.testoElementiNonSanitari.getText();
            }
            if(finestra.dataFruizione.getDate()!=null)
                modelloGL[6] = new DataOraria(finestra.dataFruizione.getDate());
            if(finestra.testoNumeroGiorni.getText().length()>0){
                try{
                    modelloGL[7]= Integer.parseInt(finestra.testoNumeroGiorni.getText());
                }catch(NumberFormatException e){
                }
            }
            if(finestra.selezionaProspettoConv.getSelectedIndex()>-1){
                if(((String)finestra.selezionaProspettoConv.getSelectedItem()).compareTo("SI")==0){
                    modelloGL[8] = true;
                }else if(((String)finestra.selezionaProspettoConv.getSelectedItem()).compareTo("NO")==0){
                    modelloGL[8] = false; 
                }
            }
            if(finestra.testoAllegatoProspettoConv.getText().length()>0){
                try{
                    modelloGL[9]= Integer.parseInt(finestra.testoAllegatoProspettoConv.getText());
                }catch(NumberFormatException e){
                }
            }
            if(finestra.selezionaDocMatricolare.getSelectedIndex()>-1){
                if(((String)finestra.selezionaDocMatricolare.getSelectedItem()).compareTo("SI")==0){
                    modelloGL[10] = true;
                }else if(((String)finestra.selezionaDocMatricolare.getSelectedItem()).compareTo("NO")==0){
                    modelloGL[10] = false; 
                }
            }
            if(finestra.testoAllegatoDocMatricolare.getText().length()>0){
                try{
                    modelloGL[11]= Integer.parseInt(finestra.testoAllegatoDocMatricolare.getText());
                }catch(NumberFormatException e){
                }
            }
            
            if(finestra.selezionaCertificatoAssenza.getSelectedIndex()>-1){
                if(((String)finestra.selezionaCertificatoAssenza.getSelectedItem()).compareTo("SI")==0){
                    modelloGL[12] = true;
                }else if(((String)finestra.selezionaCertificatoAssenza.getSelectedItem()).compareTo("NO")==0){
                    modelloGL[12] = false; 
                }
            }
            if(finestra.testoAllegatoselezionaCertificatoAssenza.getText().length()>0){
                try{
                    modelloGL[13]= Integer.parseInt(finestra.testoAllegatoselezionaCertificatoAssenza.getText());
                }catch(NumberFormatException e){
                }
            }
            
            if(finestra.selezionaSuperamentoAssenza.getSelectedObjects() != null)
                modelloGL[14]=true;
            else
                modelloGL[14]=false;
            if(finestra.selezionaTerminePeriodoAssenza.getSelectedObjects() != null)
                modelloGL[15]=true;
            else
                modelloGL[15]=false;
            if(finestra.testoPeriodoAssenza.getText().length()>0)
                modelloGL[16]=finestra.testoPeriodoAssenza.getText();
            
            if(finestra.selezionaPersistenzaIdoneita.getSelectedObjects() != null)
                modelloGL[30]=true;
            else
                modelloGL[30]=false;
            
            if(finestra.selezionaPresuntaPerditaIdoneita.getSelectedObjects() != null)
                modelloGL[17]=true;
            else
                modelloGL[17]=false;
            if(finestra.selezionaAltreInabilita.getSelectedObjects() != null)
                modelloGL[18]=true;
            else
                modelloGL[18]=false;
            
            if(finestra.testoFormeInabilita.getText().length()>0)
                modelloGL[19]=finestra.testoFormeInabilita.getText();
            
            if(finestra.selezionaCausaServizio.getSelectedObjects() != null)
                modelloGL[20]=true;
            else
                modelloGL[20]=false;
            
            if(finestra.selezionaSuRichiesta.getSelectedObjects() != null)
                modelloGL[21]=true;
            else
                modelloGL[21]=false;
            
            if(finestra.selezionaAltro.getSelectedObjects() != null)
                modelloGL[22]=true;
            else
                modelloGL[22]=false;
            
            if(finestra.testoAltro.getText().length()>0)
                modelloGL[23]=finestra.testoAltro.getText();
            if(finestra.selezionaRiconosciutoTempNonIdoneo.getSelectedIndex()>-1){
                if(((String)finestra.selezionaRiconosciutoTempNonIdoneo.getSelectedItem()).compareTo("SI")==0){
                    modelloGL[24] = true;
                }else if(((String)finestra.selezionaRiconosciutoTempNonIdoneo.getSelectedItem()).compareTo("NON")==0){
                    modelloGL[24] = false; 
                }
            }
            if(finestra.testoAltriElementiSanitari.getText().length()>0)
                modelloGL[25]=finestra.testoAltriElementiSanitari.getText();
            if(finestra.testoAnamnesi.getText().length()>0)
                modelloGL[26]=finestra.testoAnamnesi.getText();
            if(finestra.testoEsameObiettivo.getText().length()>0)
                modelloGL[27]=finestra.testoEsameObiettivo.getText();
            if(finestra.testoGiudizioDiagnostico.getText().length()>0)
                modelloGL[28]=finestra.testoGiudizioDiagnostico.getText();
            if(finestra.selezionaMedico.getSelectedIndex() > -1)
                modelloGL[29] = (String)finestra.selezionaMedico.getSelectedItem();
            DataOraria data;
            if((data=finestra.campoData.valore())!=null){
                datiModelloGL.aggiungiModelloGL(data, (String)militare[0], (String)militare[1], (DataOraria)militare[2], modelloGL);
                JOptionPane.showMessageDialog(
                            finestra, "Verbale salvato ^_^", "avviso",
                            JOptionPane.INFORMATION_MESSAGE);
            }else{
                javax.swing.JOptionPane.showMessageDialog(finestra, "errore data", "inserisci data", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            
                        
    }
    
    public void caricaTabella(){
        ArrayList<Object[]> records = datiModelloGL.trovaCausaDiServizio(finestra.testoCognome.getText(),
                        finestra.testoNome.getText(),
                        new DataOraria(
                            Integer.valueOf(finestra.valoreGiornoNascita.getText()),
                            Integer.valueOf(finestra.valoreMeseNascita.getText()),
                            Integer.valueOf(finestra.valoreAnnoNascita.getText())) );
        
        if(records != null){
            if(records.size() > 0){
                
                valoriTab = new Object[records.size()][6];
                int i=0;
                for(Object[] record : records){
                    valoriTab[i][0] = record[3];
                    valoriTab[i][1] = record[4];
                    valoriTab[i][2] = record[5];
                    valoriTab[i][3] = record[6];
                    valoriTab[i][4] = record[7];
                    valoriTab[i++][5] = record[8];
                }
                
                finestra.tabellaCauseDiServizio.setModel(new javax.swing.table.DefaultTableModel(
                    valoriTab,
                    new String [] {
                        "Infermità o lesione", "Dipendenza", "Tempestività domanda", "P.V. Mod. o provvedimento definitivo", "datato", "C.M.2° Instanza o C.M.O. o Direttore o Aministrazione o Ente"
                    }
                ) {
                    boolean[] canEdit = new boolean [] {
                        false, false, false, false, false, false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                });
                
                
                
            }else{
                
                svuota();
            }
        }else{
            svuota();
        }

    }
    
    private void svuota(){
        finestra.tabellaCauseDiServizio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Infermità o lesione", "Dipendenza", "Tempestività domanda", "P.V. Mod. o provvedimento definitivo", "datato", "C.M.2° Instanza o C.M.O. o Direttore o Aministrazione o Ente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }

    private boolean seleziona(JCheckBox casella){
        if(casella.getSelectedObjects()!= null) {
            return true;
        }
        return false;
    }

    public void pulsanteSalva(ActionEvent evt) {
        if (evt.getSource() instanceof javax.swing.JButton) {
            salva();
        }
    }

    public void pulsanteStampa(ActionEvent evt) {
        if (evt.getSource() instanceof javax.swing.JButton) {
            
            DatiImpostazioni impostazioni = new DatiImpostazioni();
            salva();
            String mail = (String) javax.swing.JOptionPane.showInputDialog(finestra, 
                    "mail reparto: ", 
                    "mail", 
                    javax.swing.JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    new String[]{
                        "",
                        impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_MAIL_REP_1),
                        impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_MAIL_REP_2),
                        impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_MAIL_REP_3)
                    }, ""
            );

            FinestraStampatoSemplice f=new FinestraStampatoSemplice();
            f.aggiungiTesto("Modello - GL", 6, false, StampatoVerticale.ALL_DESTRA);
            f.aggiungiTesto("Allegato: C", 6, false, StampatoVerticale.ALL_DESTRA);
            f.aggiungiTesto("DIRETTIVA DIFESAN", 6, false, StampatoVerticale.ALL_DESTRA);
            f.aggiungiTesto("Prot. N. 5000/2007", 6, false, StampatoVerticale.ALL_DESTRA);

            f.aggiungiTitolo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_INT_REGGIMENTO),9);
            //f.aggiungiTitolo("COMANDO REPARTO SUPPORTI",11); 
            f.aggiungiTitolo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_INT_UFFICIO),9);

            f.aggiungiTesto(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_VIA)+
                            (impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_N_CIVICO).length() > 0 ? " nr. "+ impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_N_CIVICO) : ", snc")+
                            " - "+impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_CAP)+
                            " " +impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_LOCALITA)+
                            "("+impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_PROVINCIA)+")"
                    , 8, false, StampatoVerticale.ALL_CENTRO
            );
            f.aggiungiTesto(String.format("Centralino Sotrin %s - Fax Militare %s - Telecom %s - Fax Telecom %s ",
                        impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_TEL_SOTRIN_CENTRALINO),
                        impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_FAX_SOTRIN_CENTRALINO),
                        impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_TEL_TELECOM_CENTRALINO),
                        impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_FAX_CENTRALINO)
                   )
                    , 8, false, StampatoVerticale.ALL_CENTRO);
            f.aggiungiTesto("EMAIL "+mail, 8, false, StampatoVerticale.ALL_CENTRO);
            f.aggiungiTesto("");
            f.aggiungiTesto("Prot.n.M_D/E23980/&#9;/DSS/10.3.4.2/2 &#9;&#9; Capua, lì "+new DataOraria().stampaGiorno('/'), 9, false, StampatoVerticale.ALL_SINISTRA);
            f.aggiungiTesto("&#9;&#9;&#9;&#9;&#9; Pdc.(Tel. 1556347)", 6, false, StampatoVerticale.ALL_SINISTRA);
            f.aggiungiTesto("");
            f.aggiungiTesto("AL&#9;DIPARTIMENTO MILITARE DI MEDICINA LEGALE", 9, false, StampatoVerticale.ALL_SINISTRA);
            f.aggiungiTesto(String.format("&#9;COMMISSIONE MEDICA OSPEDALIERA&#9;&#9;<u>%s</u>",
                            impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_CMO)
                    )
                    , 9, false, StampatoVerticale.ALL_SINISTRA
            );
            f.aggiungiTesto("");
            f.aggiungiTesto("OGGETTO: Richiesta di accertamenti medico legali alle competente C.M.O.", 9, false, StampatoVerticale.ALL_SINISTRA);
            f.aggiungiTesto("");
            f.aggiungiTesto("Ai fini dell'accertamento delle condizioni di idoneità al servizio, si richiede di sottoporre a visita medica collegiale, secondo quanto previsto dall'art. 15 del D.P.R. 29 ottobre 2001 n.461, il dipendente:", 9, false, StampatoVerticale.ALL_SINISTRA);
            f.aggiungiTesto("<u>"+finestra.testoGrado.getText() +"&#9;</u>"+trattino+" <u>"+finestra.testoCognome.getText()+"&#9;</u>"+trattino+"<u>"+finestra.testoNome.getText()+"</u>" , 9, false, StampatoVerticale.ALL_SINISTRA);
            f.aggiungiTesto("Nato a "+trattino+" <u>"+ finestra.testoLuogo.getText() +"&#9;</u> il "+trattino+"<u>"+finestra.valoreGiornoNascita.getText()+"/"+finestra.valoreMeseNascita.getText()+"/"+finestra.valoreAnnoNascita.getText()+"</u>", 9, false, StampatoVerticale.ALL_SINISTRA);
            f.aggiungiTesto("Residente a "+trattino+"<u>"+ finestra.testoResidenza.getText() +"</u> "+trattino+"<u>"+ finestra.testoIndirizzo.getText()+"</u> ASL di appartenenza "+trattino+"<u>"+finestra.testoASL.getText()+"</u>", 9, false, StampatoVerticale.ALL_SINISTRA);
            f.aggiungiTesto("Incarico: "+trattino+"<u>"+finestra.testoIncarico.getText()+"</u> effettivo al "+trattino+"<u>"+finestra.testoReparto.getText()+"</u> sede "+trattino+"<u>CAPUA (CE)</u>", 9, false, StampatoVerticale.ALL_SINISTRA);
            f.aggiungiTesto("");
            String sezioneA = StampatoVerticale.testo("<u>SEZIONE A: AMMINISTRATIVA</u>", 9, false, StampatoVerticale.ALL_CENTRO);

            String si = StampatoVerticale.L, no = StampatoVerticale.L;
            if(finestra.selezionaRelazioneAllegata.getSelectedIndex()==0){
                no = StampatoVerticale.X;
            }else if(finestra.selezionaRelazioneAllegata.getSelectedIndex()==1){
                si = StampatoVerticale.X;
            }
            sezioneA += StampatoVerticale.testo("ELEMENTI INFORMATIVI NON SANITARI<sup>1</sup>:&#9;&#9;Relazione allegata: "+si+" SI"+no+" NO", 8, false, StampatoVerticale.ALL_SINISTRA);
            sezioneA += "<br />";
            sezioneA += finestra.testoElementiNonSanitari.getText();
            if(finestra.testoElementiNonSanitari.getText().length()>0)sezioneA += "<br />";
            String dataF = "//////";
            try{
               dataF =  new DataOraria(finestra.dataFruizione.getDate()).stampaGiorno('/');
            }catch(java.lang.NullPointerException e){
            }
            sezioneA += StampatoVerticale.testo(
                    "AI FINI DEL COMPUTO DEL PERIODO MASSIMO DI ASPETTATIVA FRUIBILE NEL QUINQUENNIO DI VALUTAZIONE, ALLA DATA "
                    +dataF
                    +" HA FRUITO DI GG. "
                    +finestra.testoNumeroGiorni.getText()
                    +" COMPLESSIVI<sup>2</sup>", 8, false, StampatoVerticale.ALL_SINISTRA);
            sezioneA += "<br />";
            si = no = StampatoVerticale.L;
            if(finestra.selezionaProspettoConv.getSelectedIndex()==0){
                no = StampatoVerticale.X;
            }else if(finestra.selezionaProspettoConv.getSelectedIndex()==1){
                si = StampatoVerticale.X;
            }
            sezioneA += StampatoVerticale.testo("Prospetto assenze dal servizio per malatia/convalescenza/inabilità<sup>3</sup>:&#9;&#9; "+si+" SI"+no+" NO "+"Allegato n. <u>"+finestra.testoAllegatoProspettoConv.getText()+"</u>", 8, false, StampatoVerticale.ALL_SINISTRA);
            si = no = StampatoVerticale.L;
            if(finestra.selezionaDocMatricolare.getSelectedIndex()==0){
                no = StampatoVerticale.X;
            }else if(finestra.selezionaDocMatricolare.getSelectedIndex()==1){
                si = StampatoVerticale.X;
            }
            sezioneA += StampatoVerticale.testo("Documento matricolare o equivalente<sup>4</sup>:&#9;&#9;&#9; "+si+" SI"+no+" NO "+"Allegato n. <u>"+finestra.testoAllegatoDocMatricolare.getText()+"</u>", 8, false, StampatoVerticale.ALL_SINISTRA);
            si = no = StampatoVerticale.L;
            if(finestra.selezionaCertificatoAssenza.getSelectedIndex()==0){
                no = StampatoVerticale.X;
            }else if(finestra.selezionaCertificatoAssenza.getSelectedIndex()==1){
                si = StampatoVerticale.X;
            }
            sezioneA += StampatoVerticale.testo("Copia certificazione sanitaria inerente l'assenza dal servizio:&#9;&#9; "+si+" SI"+no+" NO "+"Allegato n. <u>"+finestra.testoAllegatoselezionaCertificatoAssenza.getText()+"</u>", 8, false, StampatoVerticale.ALL_SINISTRA);
            sezioneA += "<br />";
            sezioneA += StampatoVerticale.testo("RIEPILOGO DELLE INFERMITA'/LESIONI GIUDICATE AI FINI DELLA DIPENDENZA DA CAUSA DI SERVIZIO", 6, false, StampatoVerticale.ALL_CENTRO);
            //String[][] tabella = new String[][]{,{"","","","","",""}};
            String[][] tabella =null;

            final int nRighe = valoriTab!=null? valoriTab.length>0 ? valoriTab.length+1 : 2 : 2;
            final int nColonne = 6;
            tabella = new String[nRighe][nColonne];

            tabella[0] = new String[]{"Infermità o lesione","Dipendenza","Tempestività domanda","P.V. Mod. o provvedimento definitivo","datato","C.M.2° Istanza o C.M.O. o Direttore o Amministazione o Ente"};

            if(valoriTab != null){
                for(int idR = 1; idR < nRighe; idR++){
                    for(int idC=0; idC < nColonne; idC++){
                        Object s = valoriTab[idR-1][idC];
                        if(s != null)
                            if(s instanceof DataOraria)
                                tabella[idR][idC] = ((DataOraria)s).stampaGiorno('/');
                            else
                                tabella[idR][idC] = s.toString();
                        else
                             tabella[idR][idC]="//";
                    }

                }
            }else{
                tabella[1] = new String[]{"//","//","//","//","//","//"};
            }
            sezioneA += StampatoVerticale.tabella(tabella, FinestraStampatoSemplice.TIPO_FORMATO_CARATTERI, 6, true, Stampato.ALL_CENTRO, new int[]{80,50,50,80,50,80});
            f.aggiungiTesto(sezioneA, 8, false,true, StampatoVerticale.ALL_CENTRO);
            f.aggiungiTesto("ANNOTAZIONI:____________________________________________________________________________", 8, false,false, StampatoVerticale.ALL_SINISTRA);
            f.aggiungiTesto(
                    "<ol>"
                    + "<li>Riportare gli elementi informativi esserziali che caratterizzano la condizione "
                        + "per la quale risulti necessario l'accertamento sanitario presso la commissione medica. "
                        + "Redigere relazione da allegare per peculiari condizioni.</li>"
                    + "<li>Tale comunicazione è sempre necessaria ed obbigatoria al superamento di 180giorni di assenza dal servizio.</li>"
                    + "<li>Riportare tutte le assenze per malatia/convalescenza/inabilità nell'ultimo quinquennio; nel caso di "
                        + "accertamento di dipendenza da causa di servizio indicare anche eventuali assenze per infermità/lesione oggetto di valutazione, a decorrere dalla data di assunzione in servizio.</li>"
                    + "<li>Il documento matricolare o equivalente deve essere aggiornato nella parte riguardante i dati sanitari; ove non possa essere allegato tale documentazione "
                            + "matricolare riportare nel riepilogo almeno i dati relativi alle infermità/lesioni di maggior rilievo al fini dell'accertamento.</li>"
                    + "</ol>", 5, false,false, StampatoVerticale.ALL_SINISTRA);

            Finestra.creaFinestra(f);
        }
            
        
    }

    public void pulsanteAggiungi(ActionEvent evt) {
        if(evt.getSource() instanceof javax.swing.JButton){
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new FinestraAggiungiCausaDiServizio(
                            finestra.testoCognome.getText(),
                            finestra.testoNome.getText(),
                            new DataOraria(
                                Integer.valueOf(finestra.valoreGiornoNascita.getText()),
                                Integer.valueOf(finestra.valoreMeseNascita.getText()),
                                Integer.valueOf(finestra.valoreAnnoNascita.getText())),
                            finestra
                    ).setVisible(true);
                }
            });
        }
    }

    public void pulsanteElimina(ActionEvent evt) {
        if(evt.getSource() instanceof javax.swing.JButton){
            if(finestra.tabellaCauseDiServizio.getSelectedRow() > -1){
                String infermita = (String)finestra.tabellaCauseDiServizio.getValueAt(finestra.tabellaCauseDiServizio.getSelectedRow(),0);
                if(JOptionPane.showConfirmDialog(
                        finestra, "Vuoi eliminare la causa di servizio per \""+infermita+"\" ?", 
                        "conferma",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE)==JOptionPane.YES_OPTION){
                    datiModelloGL.eliminaCausaDiServizio(
                            finestra.testoCognome.getText(),
                            finestra.testoNome.getText(),
                            new DataOraria(
                                    Integer.valueOf(finestra.valoreGiornoNascita.getText()),
                                    Integer.valueOf(finestra.valoreMeseNascita.getText()),
                                    Integer.valueOf(finestra.valoreAnnoNascita.getText())),
                            infermita
                    );
                }
                caricaTabella();
            }
        }
    }

    public void pulsanteStampa2Parte(ActionEvent evt) {
        if(evt.getSource() instanceof javax.swing.JButton){
            FinestraStampatoSemplice f=new FinestraStampatoSemplice();
            f.aggiungiTesto("<u>SEZIONE B: SANITARIA</u>", 12,false,Stampato.ALL_CENTRO);

            String sezioneB = StampatoVerticale.testo("L'accertamento sanitario è richiesto in quanto sussiste la necessistà di una verifica in ordine all'idoneità<sup>5</sup>", 8, true, StampatoVerticale.ALL_SINISTRA);
            sezioneB += StampatoVerticale.testo("<br />", 8, false, StampatoVerticale.ALL_SINISTRA);
            String _x;
            if(finestra.selezionaSuperamentoAssenza.getSelectedObjects() != null){
                _x = Stampato.X;
            }else{
                _x = Stampato.L;
            }
            sezioneB += StampatoVerticale.testo(_x + "PER SUPERAMENTO DEL PERIODO DI ASSENZA DAL SERVIZIO PER CONVALESCENZA", 8, false, StampatoVerticale.ALL_SINISTRA);
            if(finestra.selezionaTerminePeriodoAssenza.getSelectedObjects() != null){
                _x = Stampato.X;
            }else{
                _x = Stampato.L;
            }
            sezioneB += StampatoVerticale.testo(_x + "AL TERMINE DI PERIODO DI ASSENZA (<u>"+finestra.testoPeriodoAssenza.getText()+"</u>)", 8, false, StampatoVerticale.ALL_SINISTRA);
            if(finestra.selezionaPersistenzaIdoneita.getSelectedObjects() != null){
                _x = Stampato.X;
            }else{
                _x = Stampato.L;
            }
            sezioneB += StampatoVerticale.testo(_x + "PER DUBBIO SELLA PERSISTENZA DELLA IDONEITA' AL SERVIZIO MILITARE", 8, false, StampatoVerticale.ALL_SINISTRA);
            if(finestra.selezionaPresuntaPerditaIdoneita.getSelectedObjects() != null){
                _x = Stampato.X;
            }else{
                _x = Stampato.L;
            }
            sezioneB += StampatoVerticale.testo(_x + "PER CONDIZIONI DI SALUTE CHE FANNO PRESUMERE UNA PERMANENTE INABILITA' AL SERVIZIO MILITARE", 8, false, StampatoVerticale.ALL_SINISTRA);
            if(finestra.selezionaAltreInabilita.getSelectedObjects() != null){
                _x = Stampato.X;
            }else{
                _x = Stampato.L;
            }
            sezioneB += StampatoVerticale.testo(_x + "PER ALTRE FORME DI INABILITA'<sup>6</sup> <u>"+finestra.testoFormeInabilita.getText()+"</u>", 8, false, StampatoVerticale.ALL_SINISTRA);
            if(finestra.selezionaCausaServizio.getSelectedObjects() != null){
                _x = Stampato.X;
            }else{
                _x = Stampato.L;
            }
            sezioneB += StampatoVerticale.testo(_x + "NELL'AMBITO DELL'ACCERTAMENTO DI UNA DIPENDENZA DA CAUSA DI SERVIZIO E/O CONNESSI BENEFICIO", 8, false, StampatoVerticale.ALL_SINISTRA);

            if(finestra.selezionaSuRichiesta.getSelectedObjects() != null){
                _x = Stampato.X;
            }else{
                _x = Stampato.L;
            }
            sezioneB += StampatoVerticale.testo(_x + "A RICHIESTA DELL’INTERESSATO SULLA BASE DI IDONEA CERTIFICAZIONE SANITARIA", 8, false, StampatoVerticale.ALL_SINISTRA);
            //
            if(finestra.selezionaAltro.getSelectedObjects() != null){
                _x = Stampato.X;
            }else{
                _x = Stampato.L;
            }
            sezioneB += StampatoVerticale.testo(_x + "ALTRO <u>"+finestra.testoAltro.getText()+"</u>", 8, false, StampatoVerticale.ALL_SINISTRA);


            sezioneB += StampatoVerticale.testo("<br />IN ATTESA DELLA VISITA COLLEGIALE, L’INTERESSATO "+trattino+"SI "+
                    ""+(finestra.selezionaRiconosciutoTempNonIdoneo.getSelectedIndex()==0 ? Stampato.X : Stampato.L)+trattino+
                    " NON "+
                    ""+(finestra.selezionaRiconosciutoTempNonIdoneo.getSelectedIndex()==1 ? Stampato.X : Stampato.L)+trattino+
                    " È STATO RICONOSCIUTO TEMPORANEAMENTE NON IDONEO AL SERVIZIO<sup>7</sup>", 8, false, StampatoVerticale.ALL_SINISTRA);

            sezioneB += StampatoVerticale.testo("ALTRI ELEMENTI INFORMATIVI (SANITARI):", 8, false, StampatoVerticale.ALL_SINISTRA);
            sezioneB += StampatoVerticale.testo(finestra.testoAltriElementiSanitari.getText(), 8, false, StampatoVerticale.ALL_SINISTRA);

            f.aggiungiTesto(sezioneB, 8 ,false,true,Stampato.ALL_CENTRO);
            f.aggiungiTesto("");
            f.aggiungiTesto(
                    StampatoVerticale.testo("ANAMNESI", 8, true, StampatoVerticale.ALL_CENTRO)+
                    StampatoVerticale.testo("", 8, true, StampatoVerticale.ALL_CENTRO)+
                    StampatoVerticale.testo(finestra.testoAnamnesi.getText(), 8, false, StampatoVerticale.ALL_SINISTRA)
                    , 8 ,false,true,Stampato.ALL_CENTRO);
            f.aggiungiTesto("");
            f.aggiungiTesto(
                    StampatoVerticale.testo("ESAME OBIETTIVO", 8, true, StampatoVerticale.ALL_CENTRO)+
                    StampatoVerticale.testo("", 8, true, StampatoVerticale.ALL_CENTRO)+
                    StampatoVerticale.testo(finestra.testoEsameObiettivo.getText(), 8, false, StampatoVerticale.ALL_SINISTRA)
                    , 8 ,false,true,Stampato.ALL_CENTRO);
            f.aggiungiTesto("");
            f.aggiungiTesto(
                    StampatoVerticale.testo("GIUDIZIO DIAGNOSTICO<sup>8</sup>", 8, true, StampatoVerticale.ALL_CENTRO)+
                    StampatoVerticale.testo("", 8, true, StampatoVerticale.ALL_CENTRO)+
                    StampatoVerticale.testo(finestra.testoGiudizioDiagnostico.getText(), 8, false, StampatoVerticale.ALL_SINISTRA)
                    , 8 ,false,true,Stampato.ALL_CENTRO);

            String cte = Stampato.testo("IL COMANDANTE<sup>9</sup>", 8, false, Stampato.ALL_CENTRO);
            String spazio = Stampato.testo("....................", 8, false, Stampato.ALL_CENTRO);
            String eMedico = Stampato.testo("UFFICIALE MEDICO", 8, false, Stampato.ALL_CENTRO);
            String bloccoFirma = Stampato.testo(new String[]{eMedico+finestra.selezionaMedico.getSelectedItem(),cte+spazio}, TIPO_FORMATO_CARATTERI, 8, false, Stampato.ALL_CENTRO, new int[]{200,200});
            f.aggiungiTesto("");
            f.aggiungiTesto(bloccoFirma);
            f.aggiungiTesto(
                    "<ol start=\"5\" >"
                    + "<li>Barrare il caso che ricorre.</li>"
                    + "<li>Indicare il tipo di inabilità (es. impiego estero o altro, se previsto da disposizioni vigenti).</li>"
                    + "<li>Condizione F e nota 9 della Tabella delle decisioni del D.S.S. annessa alla Direttiva n. 5000/2007 di DIFESAN.</li>"
                    + "<li>Indicare la diagnosi motivo dell’accertamento sanitario presso la C.M.O.</li>"
                    +"<li>Capo Ufficio, Direttore dell’Ente o Delegato.</li>"
                  + "</ol>",
                    5, false,false, StampatoVerticale.ALL_SINISTRA);
            
            Finestra.creaFinestra(f);

        }
    }
}
