package it.quasar_x7.java.swing.componenti;

import it.quasar_x7.java.utile.DataOraria;

/*******************************************************************************
 *
 * @author Domenico della Peruta
 ******************************************************************************/
public class CampoDataOraria extends javax.swing.JPanel {

    /** Creates new form CampoData */
    public CampoDataOraria() {
        initComponents();    
    }

    public void svuotaCampi(){
        campoData.svuotaCampi();
        campoOra.svuotaCampi();
    }

    
    public boolean controllo(){
        return campoData.controllo() && campoOra.controllo();
    }
    
    /*****************************************************
     * controlla la correttezza dei campi inseriti
     * 
     * @return restistuisce true se trova errori
     *****************************************************/
    public boolean erroreCampi(){
        return campoData.erroreCampo() || campoOra.erroreCampo();
    }

    public DataOraria valore(){
        if(!erroreCampi()){
            DataOraria d = campoData.valore();
            d.ora(campoOra.valore().stampaOra());
            return d;
        }
        return null;
    }

    public void carica(int gg, int mm, int aaaa, int h, int min) {
        campoData.carica(gg, mm, aaaa);
        campoOra.carica(h, min);
    }
    
    public void carica(DataOraria data){
        campoData.carica(data);
        campoOra.carica(data);
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoData = new it.quasar_x7.java.swing.componenti.CampoData();
        campoOra = new it.quasar_x7.java.swing.componenti.CampoOra();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(campoOra, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoOra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private it.quasar_x7.java.swing.componenti.CampoData campoData;
    private it.quasar_x7.java.swing.componenti.CampoOra campoOra;
    // End of variables declaration//GEN-END:variables

}
