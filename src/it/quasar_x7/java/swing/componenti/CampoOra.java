package it.quasar_x7.java.swing.componenti;

import it.quasar_x7.java.utile.DataOraria;
import it.quasar_x7.java.utile.Testo;
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
public class CampoOra extends javax.swing.JPanel {
    private javax.swing.JFormattedTextField campo;
    
    /** Creates new form CampoData */
    public CampoOra() {
        try {
            initComponents(); 
            MaskFormatter mascheraInput = new MaskFormatter("**:**");
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
                    if(campo.getText().compareTo("**:**")!=0) {
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
            Logger.getLogger(CampoOra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void svuotaCampi(){
        campo.setText("**:**");
    }


    /*****************************************************
     * Controlla la correttezza del campo e avvisa 
     * tramite finestra dialogo.
     * 
     * @return restituisce true se i dati sono corretti
     *****************************************************/ 
    public boolean controllo(){
        if(erroreCampo()){
            javax.swing.JOptionPane.showMessageDialog(
                    this, 
                    "Errore ora: '"+campo.getText()+"'", "errore", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            return false;
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
                Testo ora = new Testo(campo.getText());
                ArrayList<Object> l = ora.scomposizione();
                int h   = (Integer) l.get(0);
                int min   = (Integer) l.get(2);
               
                if(h < 0 || h > 23 || min < 0 || min > 59){
                    errore = true;
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
            DataOraria d= new DataOraria();
            d.ora(campo.getText());
            return d;
        }
        return null;
    }

    
    
    public void carica(int h, int min) {
        String valoreH = "**",valoreMin="**";
        if(h >=0 && h < 24) {
            if(h<10){
                valoreH = "0"+String.valueOf(h);
            }else{
                valoreH = String.valueOf(h);
            }
        }

        if(min>=0 && min < 60){
            if(min<10){
                valoreMin = "0"+String.valueOf(min);
            }else{
                valoreMin = String.valueOf(min);
            }
        }
        
        
        campo.setText(valoreH+":"+valoreMin);

    }
    
    public void carica(DataOraria data){
        if(data != null){
            this.carica(data.ore(), data.minuti());
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
            .addGap(0, 58, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

   

}
