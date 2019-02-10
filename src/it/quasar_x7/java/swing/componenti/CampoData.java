package it.quasar_x7.java.swing.componenti;

import it.quasar_x7.java.utile.DataOraria;
import it.quasar_x7.java.utile.Errore;
import it.quasar_x7.java.utile.Testo;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/*******************************************************************************
 *
 * @author Domenico della Peruta
 ******************************************************************************/
public class CampoData extends javax.swing.JPanel {
    private javax.swing.JFormattedTextField campo;
    //private DateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
    private boolean abilitaSegnalazione = true;

    /** Creates new form CampoData */
    public CampoData() {
        try {
            initComponents(); 
            MaskFormatter mascheraInput = new MaskFormatter("**/**/****");
            mascheraInput.setPlaceholderCharacter('*');
            mascheraInput.install(campo);
            campo = new JFormattedTextField(mascheraInput);
            campo.setColumns(20);
            campo.setFocusLostBehavior(JFormattedTextField.COMMIT);
            campo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
            campo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
            
            campo.addMouseListener(new MouseAdapter(){

                @Override
                public void mouseClicked(MouseEvent e) {
                    campo.selectAll();
                }
                
            });
            
            campo.addFocusListener(new FocusAdapter(){
                @Override
                public void focusLost(FocusEvent e) {
                    if(campo.getText().compareTo("**/**/****")!=0) {
                        controllo();
                    }
                }

                
            });
            
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(campo, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(campo, javax.swing.GroupLayout.PREFERRED_SIZE, 
                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            );
            add(campo);
        } catch (ParseException ex) {
            Logger.getLogger(CampoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void disattivaSegnalazione(boolean disabilita){
        this.abilitaSegnalazione = !disabilita;
    }
    
    public void svuotaCampi(){
        campo.setText("**/**/****");
    }


    /*****************************************************
     * Controlla la correttezza del campo e avvisa 
     * tramite finestra dialogo.
     * 
     * @return restituisce true se i dati sono corretti
     *****************************************************/ 
    public boolean controllo(){
        if(erroreCampo()){
            if(abilitaSegnalazione){
                javax.swing.JOptionPane.showMessageDialog(
                        this, 
                        "Errore data: '"+campo.getText()+"'", "errore", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    
    /*****************************************************
     * Controlla la correttezza del campo di testo
     * 
     * @return restistuisce true se trova errori
     *****************************************************/
    public boolean erroreCampo(){
        boolean errore = !campo.isEditValid();
        if(!errore){//se è un valore valido (errore == false)
            try {
                campo.commitEdit();
                Testo data = new Testo(campo.getText());
                if(data.cercaCarattere('*') != -1) {
                    errore = true;
                }else{
                    ArrayList<Object> l = data.scomposizione();
                    int gg   = (Integer) l.get(0);
                    int mm   = (Integer) l.get(2);
                    int aaaa = (Integer) l.get(4);

                    if(gg < 1 || gg > DataOraria.giorniMese(mm, aaaa) ||
                       mm < 1 || mm > 12 || aaaa < 0){
                        errore = true;
                    }
                }
            } catch (ParseException ex) {
                errore = true;
            } catch (Exception ex){
                errore = true;
            }
        }
        return errore;
    }

    public DataOraria valore(){
        if(!erroreCampo()) {
            try {
                return new DataOraria(campo.getText());
            } catch (Errore ex) {
                return null;
            }
        }
        return null;
    }

    
    
    public void carica(int giorno, int mese, int anno) {
        String valoreGiorno = "**",valoreMese="**",valoreAnno="****";
        if(giorno>0 && giorno<= DataOraria.giorniMese(mese, anno)) {
            if(giorno>9){
                valoreGiorno = String.valueOf(giorno);
            }else{
                valoreGiorno =  "0"+ String.valueOf(giorno);
            }
        }

        if(mese>0 && mese<=12){
            if(mese>9){
                valoreMese = String.valueOf(mese);
            }else{
                valoreMese = "0"+String.valueOf(mese);
            }
        }
        
        if(anno>=1000 && anno<=9999){
            valoreAnno = String.valueOf(anno);
        }
        
        campo.setText(valoreGiorno+"/"+valoreMese+"/"+valoreAnno);

    }
    
    public void carica(DataOraria data){
        if(data != null){
            this.carica(data.giornoMese(), data.mese(), data.anno());
        }
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.campo.setEnabled(enabled);
        if(enabled) {
            this.campo.setCaretColor(Color.red);
        }
    }
   
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

   

}
