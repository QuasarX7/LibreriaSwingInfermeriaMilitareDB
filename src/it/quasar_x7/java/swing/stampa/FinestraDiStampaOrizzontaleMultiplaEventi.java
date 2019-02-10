package it.quasar_x7.java.swing.stampa;


import com.toedter.calendar.JDateChooser;
import it.quasar_x7.java.utile.DataOraria;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;

/*******************************************************************************
 *
 * @author Domenico della Peruta
 * @version 2.0.0 ultima modifica 04/04/2016
 ******************************************************************************/
public abstract class FinestraDiStampaOrizzontaleMultiplaEventi extends javax.swing.JFrame implements FinestraStrampaMultiEventi {

    
    protected  FinestraDiStampaOrizzontaleMultiplaEventiController gestore;
//--------------------------- costruttore --------------------------------------
    public FinestraDiStampaOrizzontaleMultiplaEventi() {
        initComponents();
        gestore = new FinestraDiStampaOrizzontaleMultiplaEventiController(this);
        data.setDate(new DataOraria().convertiDate());
      
    }
    
    


    public JDateChooser getCampoData() {
        return data;
    }

    public JButton getPulsanteCerca() {
        return pulsanteCerca;
    }

    public JButton getPulsanteStampa() {
        return pulsanteStampa;
    }

    public JButton getPulsanteStampaPagine() {
        return pulsanteStampaPagine;
    }

    public JButton getPulsanteStampaTutte() {
        return pulsanteStampaTutte;
    }

    public JButton getPunsanteAvanti() {
        return punsanteAvanti;
    }

    public JButton getPunsanteDietro() {
        return punsanteDietro;
    }

    public StampatoOrizzontale getStampato() {
        return stampato;
    }

    public JTextField getCampoIndice() {
        return campoIndice;
    }
    
    /**
     * Carica le pagine automaticamente, senza premere il pulsante caricaPagine.
     */
    protected void caricaPagine(){
        gestore.cerca();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sfondo = new javax.swing.JPanel();
        stampato = new it.quasar_x7.java.swing.stampa.StampatoOrizzontale();
        punsanteDietro = new javax.swing.JButton();
        campoIndice = new javax.swing.JTextField();
        punsanteAvanti = new javax.swing.JButton();
        pulsanteStampaTutte = new javax.swing.JButton();
        pulsanteStampa = new javax.swing.JButton();
        pulsanteStampaPagine = new javax.swing.JButton();
        data = new com.toedter.calendar.JDateChooser();
        etichettaData = new javax.swing.JLabel();
        pulsanteCerca = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        sfondo.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout sfondoLayout = new javax.swing.GroupLayout(sfondo);
        sfondo.setLayout(sfondoLayout);
        sfondoLayout.setHorizontalGroup(
            sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sfondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stampato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        sfondoLayout.setVerticalGroup(
            sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sfondoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(stampato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(336, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(sfondo);

        punsanteDietro.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        punsanteDietro.setText("<");
        punsanteDietro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                punsanteDietroActionPerformed(evt);
            }
        });

        campoIndice.setEditable(false);
        campoIndice.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        campoIndice.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        punsanteAvanti.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        punsanteAvanti.setText(">");
        punsanteAvanti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                punsanteAvantiActionPerformed(evt);
            }
        });

        pulsanteStampaTutte.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        pulsanteStampaTutte.setText("Stampa TUTTE le pagine");
        pulsanteStampaTutte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulsanteStampaTutteActionPerformed(evt);
            }
        });

        pulsanteStampa.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        pulsanteStampa.setText("Stampa pagina");
        pulsanteStampa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulsanteStampaActionPerformed(evt);
            }
        });

        pulsanteStampaPagine.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        pulsanteStampaPagine.setText("Stampa pagine");
        pulsanteStampaPagine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulsanteStampaPagineActionPerformed(evt);
            }
        });

        data.setForeground(new java.awt.Color(0, 0, 255));
        data.setDateFormatString("dd/MM/yyyy");

        etichettaData.setForeground(new java.awt.Color(51, 51, 255));
        etichettaData.setText("data");

        pulsanteCerca.setForeground(new java.awt.Color(0, 0, 255));
        pulsanteCerca.setText("Cerca");
        pulsanteCerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulsanteCercaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pulsanteStampa)
                        .addGap(18, 18, 18)
                        .addComponent(etichettaData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pulsanteCerca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(punsanteDietro, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(punsanteAvanti, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pulsanteStampaPagine, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pulsanteStampaTutte, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pulsanteStampa)
                        .addComponent(punsanteDietro)
                        .addComponent(campoIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pulsanteStampaTutte)
                        .addComponent(punsanteAvanti)
                        .addComponent(pulsanteStampaPagine)
                        .addComponent(etichettaData)
                        .addComponent(pulsanteCerca)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pulsanteStampaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteStampaActionPerformed
        gestore.stampa(evt);
        
    }//GEN-LAST:event_pulsanteStampaActionPerformed

    private void punsanteAvantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_punsanteAvantiActionPerformed
        gestore.pulsanteAvanti(evt);
        
    }//GEN-LAST:event_punsanteAvantiActionPerformed

    private void punsanteDietroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_punsanteDietroActionPerformed
        gestore.pulsanteDietro(evt);
    }//GEN-LAST:event_punsanteDietroActionPerformed

    private void pulsanteStampaTutteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteStampaTutteActionPerformed
        gestore.stampaTuttePagine(evt);
        
    }//GEN-LAST:event_pulsanteStampaTutteActionPerformed

    private void pulsanteStampaPagineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteStampaPagineActionPerformed
        gestore.stampaPagine(evt);
}//GEN-LAST:event_pulsanteStampaPagineActionPerformed

    private void pulsanteCercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteCercaActionPerformed
        if(evt.getSource() instanceof javax.swing.JButton){
            gestore.cerca();
        }
    }//GEN-LAST:event_pulsanteCercaActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoIndice;
    protected com.toedter.calendar.JDateChooser data;
    private javax.swing.JLabel etichettaData;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pulsanteCerca;
    private javax.swing.JButton pulsanteStampa;
    private javax.swing.JButton pulsanteStampaPagine;
    private javax.swing.JButton pulsanteStampaTutte;
    private javax.swing.JButton punsanteAvanti;
    private javax.swing.JButton punsanteDietro;
    private javax.swing.JPanel sfondo;
    private it.quasar_x7.java.swing.stampa.StampatoOrizzontale stampato;
    // End of variables declaration//GEN-END:variables

    

}
