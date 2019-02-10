
package it.difesa.esercito.rav17.infermeria.controllo;

//import it.quasar_x7.java.swing.finestra.F;
import it.difesa.esercito.rav17.infermeria.DaseDati.DatiImpostazioni;
import it.difesa.esercito.rav17.infermeria.DaseDati.DatiMedico;
import it.difesa.esercito.rav17.infermeria.vista.FinestraImpostazioniVaccinazioni;
import it.quasar_x7.java.utile.DataOraria;
import it.quasar_x7.java.utile.Errore;
import it.quasar_x7.java.utile.Testo;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Dr Domenico della Peruta
 * @version 3.1.0 ultima modifica 21/09/2017
 */
public class FinestraImpostazioneVaccinazioniController {
    
    
    public final static String CHIAVE_VACCINO = "dati_vaccinazione_";
    public final static String INFO_CHIAVE = "vaccinazione";
    public static Object[] impostazioni;
    
    private final DatiMedico baseDiDati;
    private static final DatiImpostazioni baseDatiImp= new DatiImpostazioni();
    
    private final FinestraImpostazioniVaccinazioni finestra;

    public FinestraImpostazioneVaccinazioniController(FinestraImpostazioniVaccinazioni finestra) {
        this.finestra = finestra;
        
        if(impostazioni == null){
            caricaDB();
        }
        baseDiDati = new DatiMedico();
        
        this.caricaImpostazioni();
    }
    
    
    public static void caricaDB(){
       if(impostazioni==null)
                impostazioni = new Object[46+9];//+9
        //scanzione da 0 a 45
        for(int i=0; i< impostazioni.length-9; i++){
            String s = baseDatiImp.valore(CHIAVE_VACCINO+i);

            if(s != null){
                Testo formato = new Testo(s);

                if(formato.formatoDataSemplice()){
                    try {
                        impostazioni[i] = new DataOraria(s);
                    } catch (Errore ex) {
                         javax.swing.JOptionPane.showMessageDialog(
                                     null,"errore formato data caricato dal file temp.xml "+s+"'", 
                                     "errore", javax.swing.JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(FinestraImpostazioniVaccinazioni.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    impostazioni[i] = s; 
                }
            }

        }
        //scanzopne da 100 a 140
        for(int i=100,k=46; i <= 140; i+=5,k++){
            String s = baseDatiImp.valore(CHIAVE_VACCINO+i);

            if(s != null){
                impostazioni[k] = s; 
            }

        }
        
           
    }

    private void caricaImpostazioni(){
        DataOraria data;
        if(baseDiDati.tuttiMedici()==null){
            javax.swing.JOptionPane.showMessageDialog(finestra,
                    "Elenco medici inesistenti!\nAggiornare lista medici!!!", "avviso",
                    javax.swing.JOptionPane.WARNING_MESSAGE);            
        }else{
            finestra.valoreMedico.setModel(new javax.swing.DefaultComboBoxModel(
                     baseDiDati.tuttiMedici().toArray()));
        }
        
        if(impostazioni!=null){
           
                //inizializza
            finestra.campoNome.setText((String) impostazioni[0]);
            finestra.campoDitta.setText((String)impostazioni[1]);
            finestra.campoLotto.setText((String)impostazioni[2]);
            finestra.campoSerie.setText((String)impostazioni[3]);
            if(impostazioni[4]!=null){
                data = (DataOraria) impostazioni[4];
                finestra.campoData.setDate(data.convertiDate());
            }

            finestra.campoNome1.setText((String) impostazioni[5]);
            finestra.campoDitta1.setText((String) impostazioni[6]);
            finestra.campoLotto1.setText((String) impostazioni[7]);
            finestra.campoSerie1.setText((String) impostazioni[8]);
            if(impostazioni[9]!=null){
                data = (DataOraria)impostazioni[9];
                finestra.campoData1.setDate(data.convertiDate());
            }

            finestra.campoNome2.setText((String) impostazioni[10]);
            finestra.campoDitta2.setText((String) impostazioni[11]);
            finestra.campoLotto2.setText((String) impostazioni[12]);
            finestra.campoSerie2.setText((String) impostazioni[13]);
            if(impostazioni[14]!=null){
                data = (DataOraria)impostazioni[14];
                finestra.campoData2.setDate(data.convertiDate());
            }

            finestra.campoNome3.setText((String) impostazioni[15]);
            finestra.campoDitta3.setText((String) impostazioni[16]);
            finestra.campoLotto3.setText((String) impostazioni[17]);
            finestra.campoSerie3.setText((String) impostazioni[18]);
            if(impostazioni[19]!=null){
                data = (DataOraria)impostazioni[19];
                finestra.campoData3.setDate(data.convertiDate());
            }

            finestra.campoNome4.setText((String) impostazioni[20]);
            finestra.campoDitta4.setText((String) impostazioni[21]);
            finestra.campoLotto4.setText((String) impostazioni[22]);
            finestra.campoSerie4.setText((String) impostazioni[23]);
            if(impostazioni[24]!=null){
                data = (DataOraria)impostazioni[24];
                finestra.campoData4.setDate(data.convertiDate());
            }

            finestra.campoNome5.setText((String) impostazioni[25]);
            finestra.campoDitta5.setText((String) impostazioni[26]);
            finestra.campoLotto5.setText((String) impostazioni[27]);
            finestra.campoSerie5.setText((String) impostazioni[28]);
            if(impostazioni[29]!=null){
                data = (DataOraria)impostazioni[29];
                finestra.campoData5.setDate(data.convertiDate());
            }

            finestra.campoNome6.setText((String) impostazioni[30]);
            finestra.campoDitta6.setText((String) impostazioni[31]);
            finestra.campoLotto6.setText((String) impostazioni[32]);
            finestra.campoSerie6.setText((String) impostazioni[33]);
            if(impostazioni[34]!=null){
                data = (DataOraria)impostazioni[34];
                finestra.campoData6.setDate(data.convertiDate());
            }

            finestra.campoNome7.setText((String) impostazioni[35]);
            finestra.campoDitta7.setText((String) impostazioni[36]);
            finestra.campoLotto7.setText((String) impostazioni[37]);
            finestra.campoSerie7.setText((String) impostazioni[38]);
            if(impostazioni[39]!=null){
                data = (DataOraria)impostazioni[39];
                finestra.campoData7.setDate(data.convertiDate());
            }

            finestra.campoNome8.setText((String) impostazioni[40]);
            finestra.campoDitta8.setText((String) impostazioni[41]);
            finestra.campoLotto8.setText((String) impostazioni[42]);
            finestra.campoSerie8.setText((String) impostazioni[43]);
            if(impostazioni[44]!=null){
                data = (DataOraria)impostazioni[44];
                finestra.campoData8.setDate(data.convertiDate());
            }            
            finestra.valoreMedico.setSelectedItem(impostazioni[45]);
            
            //campi via somministrazione
            finestra.selezionaSom.setSelectedItem((String) impostazioni[46]);
            finestra.selezionaSom1.setSelectedItem((String) impostazioni[47]);
            finestra.selezionaSom2.setSelectedItem((String) impostazioni[48]);
            finestra.selezionaSom3.setSelectedItem((String) impostazioni[49]);
            finestra.selezionaSom4.setSelectedItem((String) impostazioni[50]);
            finestra.selezionaSom5.setSelectedItem((String) impostazioni[51]);
            finestra.selezionaSom6.setSelectedItem((String) impostazioni[52]);
            finestra.selezionaSom7.setSelectedItem((String) impostazioni[53]);
            finestra.selezionaSom8.setSelectedItem((String) impostazioni[54]);
            
            
            
        }else{
            this.caricaDB();
        }
    }
    
    
    public void salvaDB(){
        for(int i=0; i< impostazioni.length-9; i++){
            if(impostazioni[i]!=null){
                if(impostazioni[i] instanceof String){
                    this.baseDatiImp.valore(CHIAVE_VACCINO+i, INFO_CHIAVE, (String)impostazioni[i]);
                }else if(impostazioni[i] instanceof DataOraria){
                    this.baseDatiImp.valore(CHIAVE_VACCINO+i, INFO_CHIAVE, ((DataOraria)impostazioni[i]).stampaGiorno());
                }else {
                    this.baseDatiImp.valore(CHIAVE_VACCINO+i, INFO_CHIAVE, ((Object)impostazioni[i]).toString());
                }
            }
        }
        for(int i=100,k=46; i <= 140; i+=5,k++){
            if(impostazioni[k]!=null){
                if(impostazioni[k] instanceof String){
                    this.baseDatiImp.valore(CHIAVE_VACCINO+i, INFO_CHIAVE, (String)impostazioni[k]);
                }
            }
        }
    }
    

    public void caricaFile() {
        if(impostazioni == null){
                impostazioni = new Object[46+9];
            }
            //inizializza
            impostazioni[0]=finestra.campoNome.getText();
            impostazioni[1]=finestra.campoDitta.getText();
            impostazioni[2]=finestra.campoLotto.getText();
            impostazioni[3]=finestra.campoSerie.getText();
            if(finestra.campoData.getDate()!=null)
                impostazioni[4]=new DataOraria(finestra.campoData.getDate());

            impostazioni[5]=finestra.campoNome1.getText();
            impostazioni[6]=finestra.campoDitta1.getText();
            impostazioni[7]=finestra.campoLotto1.getText();
            impostazioni[8]=finestra.campoSerie1.getText();
            if(finestra.campoData1.getDate()!=null)
                impostazioni[9]=new DataOraria(finestra.campoData1.getDate());

            impostazioni[10]=finestra.campoNome2.getText();
            impostazioni[11]=finestra.campoDitta2.getText();
            impostazioni[12]=finestra.campoLotto2.getText();
            impostazioni[13]=finestra.campoSerie2.getText();
            if(finestra.campoData2.getDate()!=null)
                impostazioni[14]=new DataOraria(finestra.campoData2.getDate());

            impostazioni[15]=finestra.campoNome3.getText();
            impostazioni[16]=finestra.campoDitta3.getText();
            impostazioni[17]=finestra.campoLotto3.getText();
            impostazioni[18]=finestra.campoSerie3.getText();
            if(finestra.campoData3.getDate()!=null)
                impostazioni[19]=new DataOraria(finestra.campoData3.getDate());

            impostazioni[20]=finestra.campoNome4.getText();
            impostazioni[21]=finestra.campoDitta4.getText();
            impostazioni[22]=finestra.campoLotto4.getText();
            impostazioni[23]=finestra.campoSerie4.getText();
            if(finestra.campoData4.getDate()!=null)
                impostazioni[24]=new DataOraria(finestra.campoData4.getDate());

            impostazioni[25]=finestra.campoNome5.getText();
            impostazioni[26]=finestra.campoDitta5.getText();
            impostazioni[27]=finestra.campoLotto5.getText();
            impostazioni[28]=finestra.campoSerie5.getText();
            if(finestra.campoData5.getDate()!=null)
                impostazioni[29]=new DataOraria(finestra.campoData5.getDate());

            impostazioni[30]=finestra.campoNome6.getText();
            impostazioni[31]=finestra.campoDitta6.getText();
            impostazioni[32]=finestra.campoLotto6.getText();
            impostazioni[33]=finestra.campoSerie6.getText();
            if(finestra.campoData6.getDate()!=null)
                impostazioni[34]=new DataOraria(finestra.campoData6.getDate());

            impostazioni[35]=finestra.campoNome7.getText();
            impostazioni[36]=finestra.campoDitta7.getText();
            impostazioni[37]=finestra.campoLotto7.getText();
            impostazioni[38]=finestra.campoSerie7.getText();
            if(finestra.campoData7.getDate()!=null)
                impostazioni[39]=new DataOraria(finestra.campoData7.getDate());

            impostazioni[40]=finestra.campoNome8.getText();
            impostazioni[41]=finestra.campoDitta8.getText();
            impostazioni[42]=finestra.campoLotto8.getText();
            impostazioni[43]=finestra.campoSerie8.getText();
            if(finestra.campoData8.getDate()!=null)
                impostazioni[44]=new DataOraria(finestra.campoData8.getDate());

            impostazioni[45]=finestra.valoreMedico.getSelectedItem();

            impostazioni[46]=(String)finestra.selezionaSom.getSelectedItem();
            impostazioni[47]=(String)finestra.selezionaSom1.getSelectedItem();
            impostazioni[48]=(String)finestra.selezionaSom2.getSelectedItem();
            impostazioni[49]=(String)finestra.selezionaSom3.getSelectedItem();
            impostazioni[50]=(String)finestra.selezionaSom4.getSelectedItem();
            impostazioni[51]=(String)finestra.selezionaSom5.getSelectedItem();
            impostazioni[52]=(String)finestra.selezionaSom6.getSelectedItem();
            impostazioni[53]=(String)finestra.selezionaSom7.getSelectedItem();
            impostazioni[54]=(String)finestra.selezionaSom8.getSelectedItem();
            
            this.salvaDB();
            finestra.setVisible(false);
            
    }
    
    public static String medico(){
        if(impostazioni != null)
            if(impostazioni[45] != null)
                return impostazioni[45].toString();
        return null;
    }
}
