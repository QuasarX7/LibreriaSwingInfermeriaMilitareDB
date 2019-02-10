package it.quasar_x7.java.swing.stampa;

/*******************************************************************************
 *
 * @author Domenico della Peruta
 * @version 2.0.0 ultima modifica 16.10.2016
 ******************************************************************************/
public abstract class FinestraDiStampaVerticaleMultiplaEventi extends javax.swing.JFrame  implements FinestraStrampaMultiEventi {

    protected FinestraDiStampaVerticaleMultiplaEventiController gestore;
    
//--------------------------- costruttore --------------------------------------
    public FinestraDiStampaVerticaleMultiplaEventi() {
        initComponents();
        gestore = new FinestraDiStampaVerticaleMultiplaEventiController(this);
        
    }

  
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sfondo = new javax.swing.JPanel();
        stampato = new it.quasar_x7.java.swing.stampa.StampatoVerticale();
        punsanteDietro = new javax.swing.JButton();
        campoIndice = new javax.swing.JTextField();
        punsanteAvanti = new javax.swing.JButton();
        pulsanteStampaTutte = new javax.swing.JButton();
        pulsanteStampa = new javax.swing.JButton();
        pulsanteStampaPagine = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pulsanteCerca = new javax.swing.JButton();
        data = new com.toedter.calendar.JDateChooser();
        etichettaData = new javax.swing.JLabel();

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
                .addGap(0, 0, Short.MAX_VALUE))
        );
        sfondoLayout.setVerticalGroup(
            sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sfondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stampato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
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

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        pulsanteCerca.setForeground(new java.awt.Color(0, 0, 255));
        pulsanteCerca.setText("Cerca");
        pulsanteCerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulsanteCercaActionPerformed(evt);
            }
        });

        data.setForeground(new java.awt.Color(0, 0, 255));
        data.setDateFormatString("dd/MM/yyyy");

        etichettaData.setForeground(new java.awt.Color(153, 255, 102));
        etichettaData.setText("data");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(etichettaData)
                .addGap(18, 18, 18)
                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pulsanteCerca)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pulsanteCerca)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etichettaData)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pulsanteStampa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(punsanteDietro, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(punsanteAvanti, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pulsanteStampaPagine, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pulsanteStampaTutte, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pulsanteStampa)
                    .addComponent(pulsanteStampaTutte)
                    .addComponent(pulsanteStampaPagine)
                    .addComponent(punsanteDietro)
                    .addComponent(campoIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(punsanteAvanti))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pulsanteStampaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteStampaActionPerformed
        gestore.pulsanteStampa(evt);
                
    }//GEN-LAST:event_pulsanteStampaActionPerformed

    private void punsanteAvantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_punsanteAvantiActionPerformed
       gestore.pulsanteAvanti(evt);
        
    }//GEN-LAST:event_punsanteAvantiActionPerformed

    private void punsanteDietroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_punsanteDietroActionPerformed
        gestore.pulsanteDietro(evt);
        
    }//GEN-LAST:event_punsanteDietroActionPerformed

    private void pulsanteStampaTutteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteStampaTutteActionPerformed
        gestore.pulsanteStampaTutte(evt);
    }//GEN-LAST:event_pulsanteStampaTutteActionPerformed

    private void pulsanteStampaPagineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteStampaPagineActionPerformed
        gestore.pulsanteStampaPagine(evt);
        
}//GEN-LAST:event_pulsanteStampaPagineActionPerformed

    private void pulsanteCercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteCercaActionPerformed
        gestore.pulsanteCerca(evt);
    }//GEN-LAST:event_pulsanteCercaActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField campoIndice;
    public com.toedter.calendar.JDateChooser data;
    private javax.swing.JLabel etichettaData;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton pulsanteCerca;
    public javax.swing.JButton pulsanteStampa;
    public javax.swing.JButton pulsanteStampaPagine;
    public javax.swing.JButton pulsanteStampaTutte;
    public javax.swing.JButton punsanteAvanti;
    public javax.swing.JButton punsanteDietro;
    private javax.swing.JPanel sfondo;
    public it.quasar_x7.java.swing.stampa.StampatoVerticale stampato;
    // End of variables declaration//GEN-END:variables

    

}
