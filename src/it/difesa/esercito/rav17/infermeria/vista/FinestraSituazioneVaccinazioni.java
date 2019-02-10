package it.difesa.esercito.rav17.infermeria.vista;

import it.difesa.esercito.rav17.infermeria.controllo.FinestraSituazioneVaccinazioniController;



/*******************************************************************************
 *
 * @author Domenico della Peruta
 * @version 2.0.0 modifica 31/01/2016
 ******************************************************************************/
public class FinestraSituazioneVaccinazioni extends javax.swing.JFrame {
    
    
    private FinestraSituazioneVaccinazioniController gestore;
    /** Creates new form FinestraDatiVaccini */
    public FinestraSituazioneVaccinazioni() {
        initComponents();
        gestore=new FinestraSituazioneVaccinazioniController(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabella = new javax.swing.JTable();
        pulsanteAggiorna = new javax.swing.JButton();
        corso = new javax.swing.JLabel();
        selezionaCorso = new javax.swing.JComboBox();
        selezionaCompagnia = new javax.swing.JComboBox();
        corso1 = new javax.swing.JLabel();
        pulsanteFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("copertura vaccinale");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        tabella.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabella.setGridColor(new java.awt.Color(255, 153, 51));
        jScrollPane1.setViewportView(tabella);

        pulsanteAggiorna.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pulsanteAggiorna.setForeground(new java.awt.Color(0, 204, 51));
        pulsanteAggiorna.setText("Aggiorna");
        pulsanteAggiorna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulsanteAggiornaActionPerformed(evt);
            }
        });

        corso.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        corso.setText("corso");

        selezionaCorso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selezionaCorsoItemStateChanged(evt);
            }
        });

        corso1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        corso1.setText("Cp/RGT");

        pulsanteFile.setFont(new java.awt.Font("Heiti SC", 1, 14)); // NOI18N
        pulsanteFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/quasar_x7/immagini/excel.jpeg"))); // NOI18N
        pulsanteFile.setText("crea file");
        pulsanteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulsanteFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(corso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selezionaCorso, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(corso1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selezionaCompagnia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(pulsanteAggiorna, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(pulsanteFile, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(corso)
                    .addComponent(selezionaCorso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pulsanteAggiorna)
                    .addComponent(pulsanteFile)
                    .addComponent(corso1)
                    .addComponent(selezionaCompagnia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pulsanteAggiornaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteAggiornaActionPerformed
        gestore.pulsanteAggiorna(evt);
    }//GEN-LAST:event_pulsanteAggiornaActionPerformed

    private void pulsanteFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteFileActionPerformed
        gestore.pulsanteFile(evt);
    }//GEN-LAST:event_pulsanteFileActionPerformed

    private void selezionaCorsoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selezionaCorsoItemStateChanged
        gestore.caricaCompagnia(evt);
    }//GEN-LAST:event_selezionaCorsoItemStateChanged

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel corso;
    private javax.swing.JLabel corso1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton pulsanteAggiorna;
    public javax.swing.JButton pulsanteFile;
    public javax.swing.JComboBox selezionaCompagnia;
    public javax.swing.JComboBox selezionaCorso;
    public javax.swing.JTable tabella;
    // End of variables declaration//GEN-END:variables

    
}
