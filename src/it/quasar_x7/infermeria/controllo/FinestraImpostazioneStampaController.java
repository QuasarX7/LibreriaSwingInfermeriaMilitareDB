package it.quasar_x7.infermeria.controllo;

import it.quasar_x7.infermeria.DaseDati.DatiImpostazioni;
import it.quasar_x7.infermeria.DaseDati.DatiMedico;
import it.quasar_x7.infermeria.vista.FinestraImpostazioneStampa;

import java.awt.event.ActionEvent;

/**
 *
 * @author Dr Domenico della Peruta
 * @version 1.0.0 ultima modifica 12/04/2016
 */
public class FinestraImpostazioneStampaController {

    static public String CHIAVE_INT_REGGIMENTO  = "REGGIMENTO";
    static public String CHIAVE_INT_UFFICIO     = "UFFICIO";
    static public String CHIAVE_FIRMA_DSS       = "DSS";
    static public String CHIAVE_TIPO            = "INTESTAZIONE";
    
    static public String CHIAVE_LOCALITA        = "LOCALITA";
    static public String CHIAVE_PROVINCIA       = "PROVINCIA";
    static public String CHIAVE_CAP             = "CAP";
    static public String CHIAVE_ASL             = "ASL";
    static public String CHIAVE_VIA             = "VIA";
    static public String CHIAVE_N_CIVICO        = "N. CIVICO";
    static public String CHIAVE_TEL_SOTRIN      = "SOTRIN";
    static public String CHIAVE_TEL_TELECOM     = "TELECOM";
    static public String CHIAVE_TEL_ALTRO       = "TEL ALTRO";
    static public String CHIAVE_FAX             = "FAX";
    static public String CHIAVE_FAX_SOTRIN      = "FAX SOTRIN";
    static public String CHIAVE_TEL_SOTRIN_CENTRALINO      = "SOTRIN CENTRALINO";
    static public String CHIAVE_TEL_TELECOM_CENTRALINO     = "TELECOM CENTRALINO";
    static public String CHIAVE_FAX_CENTRALINO             = "FAX CENTRALINO";
    static public String CHIAVE_FAX_SOTRIN_CENTRALINO      = "FAX SOTRIN CENTRALINO";
    
    static public String CHIAVE_MAIL_REP_1      = "EMAIL REP 1";
    static public String CHIAVE_MAIL_REP_2      = "EMAIL REP 2";
    static public String CHIAVE_MAIL_REP_3      = "EMAIL REP 3";
    static public String CHIAVE_MAIL_DSS        = "EMAIL DSS";
    static public String CHIAVE_CMO             = "CMO";
    
   
    private final FinestraImpostazioneStampa finestra;
    private DatiImpostazioni impostazioni;

    public FinestraImpostazioneStampaController(FinestraImpostazioneStampa finestra) {
        this.finestra = finestra;
        impostazioni = new DatiImpostazioni();
        caricaMedici();
        caricaCampi();
    }

    private void caricaMedici(){
        DatiMedico medici = new DatiMedico();
        for(String firma : medici.tuttiMedici()){
            finestra.campoFirma.addItem(firma);
        }
    }
    
    private void caricaCampi(){
        this.finestra.campoReggimento.setText(impostazioni.valore(CHIAVE_INT_REGGIMENTO));
        this.finestra.campoUfficio.setText(impostazioni.valore(CHIAVE_INT_UFFICIO));
        this.finestra.campoFirma.setSelectedItem(impostazioni.valore(CHIAVE_FIRMA_DSS));
        
        this.finestra.campoLocalita.setText(impostazioni.valore(CHIAVE_LOCALITA));
        this.finestra.campoProvincia.setText(impostazioni.valore(CHIAVE_PROVINCIA));
        this.finestra.campoCAP.setText(impostazioni.valore(CHIAVE_CAP));
        this.finestra.campoASL.setText(impostazioni.valore(CHIAVE_ASL));
        this.finestra.campoVia.setText(impostazioni.valore(CHIAVE_VIA));
        this.finestra.campoNumeroCiv.setText(impostazioni.valore(CHIAVE_N_CIVICO));
        this.finestra.campoSotrin.setText(impostazioni.valore(CHIAVE_TEL_SOTRIN));
        this.finestra.campoTelecom.setText(impostazioni.valore(CHIAVE_TEL_TELECOM));
        this.finestra.campoTelefonoAltro.setText(impostazioni.valore(CHIAVE_TEL_ALTRO));
        this.finestra.campoFax.setText(impostazioni.valore(CHIAVE_FAX));
        this.finestra.campoFaxSotrin.setText(impostazioni.valore(CHIAVE_FAX_SOTRIN));
        
        this.finestra.campoCentralinoSotrin.setText(impostazioni.valore(CHIAVE_TEL_SOTRIN_CENTRALINO));
        this.finestra.campoCentralinoTelecom.setText(impostazioni.valore(CHIAVE_TEL_TELECOM_CENTRALINO));
        this.finestra.campoCentralinoFax.setText(impostazioni.valore(CHIAVE_FAX_CENTRALINO));
        this.finestra.campoCentralinoFaxSotrin.setText(impostazioni.valore(CHIAVE_FAX_SOTRIN_CENTRALINO));
        
        this.finestra.campoEMail.setText(impostazioni.valore(CHIAVE_MAIL_REP_1));
        this.finestra.campoEMail1.setText(impostazioni.valore(CHIAVE_MAIL_REP_2));
        this.finestra.campoEMail2.setText(impostazioni.valore(CHIAVE_MAIL_REP_3));
        this.finestra.campoEMail3.setText(impostazioni.valore(CHIAVE_MAIL_DSS));
        this.finestra.campoSedeCMO.setText(impostazioni.valore(CHIAVE_CMO));
        
    }
    
    public void salva(ActionEvent evt) {
        if(evt.getSource() instanceof javax.swing.JButton){
            impostazioni.valore(CHIAVE_INT_REGGIMENTO,CHIAVE_TIPO, this.finestra.campoReggimento.getText());
            impostazioni.valore(CHIAVE_INT_UFFICIO,CHIAVE_TIPO, this.finestra.campoUfficio.getText());
            impostazioni.valore(CHIAVE_FIRMA_DSS,CHIAVE_TIPO, this.finestra.campoFirma.getSelectedItem().toString());
            
            impostazioni.valore(CHIAVE_LOCALITA,CHIAVE_TIPO, this.finestra.campoLocalita.getText());
            impostazioni.valore(CHIAVE_PROVINCIA,CHIAVE_TIPO, this.finestra.campoProvincia.getText());
            impostazioni.valore(CHIAVE_CAP,CHIAVE_TIPO, this.finestra.campoCAP.getText());
            impostazioni.valore(CHIAVE_ASL,CHIAVE_TIPO, this.finestra.campoASL.getText());
            impostazioni.valore(CHIAVE_VIA,CHIAVE_TIPO, this.finestra.campoVia.getText());
            impostazioni.valore(CHIAVE_N_CIVICO,CHIAVE_TIPO, this.finestra.campoNumeroCiv.getText());
            impostazioni.valore(CHIAVE_TEL_SOTRIN,CHIAVE_TIPO, this.finestra.campoSotrin.getText());
            impostazioni.valore(CHIAVE_TEL_TELECOM,CHIAVE_TIPO, this.finestra.campoTelecom.getText());
            impostazioni.valore(CHIAVE_TEL_ALTRO,CHIAVE_TIPO, this.finestra.campoTelefonoAltro.getText());
            impostazioni.valore(CHIAVE_FAX,CHIAVE_TIPO, this.finestra.campoFax.getText());
            impostazioni.valore(CHIAVE_FAX_SOTRIN,CHIAVE_TIPO, this.finestra.campoFaxSotrin.getText());
            
            impostazioni.valore(CHIAVE_TEL_SOTRIN_CENTRALINO,CHIAVE_TIPO, this.finestra.campoCentralinoSotrin.getText());
            impostazioni.valore(CHIAVE_TEL_TELECOM_CENTRALINO,CHIAVE_TIPO, this.finestra.campoCentralinoTelecom.getText());
            impostazioni.valore(CHIAVE_FAX_CENTRALINO,CHIAVE_TIPO, this.finestra.campoCentralinoFax.getText());
            impostazioni.valore(CHIAVE_FAX_SOTRIN_CENTRALINO,CHIAVE_TIPO, this.finestra.campoCentralinoFaxSotrin.getText());
            
            impostazioni.valore(CHIAVE_MAIL_REP_1,CHIAVE_TIPO, this.finestra.campoEMail.getText());
            impostazioni.valore(CHIAVE_MAIL_REP_2,CHIAVE_TIPO, this.finestra.campoEMail1.getText());
            impostazioni.valore(CHIAVE_MAIL_REP_3,CHIAVE_TIPO, this.finestra.campoEMail2.getText());
            impostazioni.valore(CHIAVE_MAIL_DSS,CHIAVE_TIPO, this.finestra.campoEMail3.getText());
            impostazioni.valore(CHIAVE_CMO,CHIAVE_TIPO, this.finestra.campoSedeCMO.getText());
            
            this.finestra.setVisible(false);
        }
    }
    
}
