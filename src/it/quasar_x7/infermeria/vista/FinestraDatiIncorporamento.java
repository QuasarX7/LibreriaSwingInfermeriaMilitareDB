package it.quasar_x7.infermeria.vista;

import it.quasar_x7.infermeria.controllo.FinestraDatiIncorporamentoController;

/*******************************************************************************
 *
 * @author Domenico della Peruta
 * @version 2.0.0 ultima modifica
 ******************************************************************************/
public class FinestraDatiIncorporamento extends javax.swing.JFrame {
    
    private final FinestraDatiIncorporamentoController gestioneFinestra;
    /** Creates new form FinestraDatiVaccini */
    public FinestraDatiIncorporamento() {
        initComponents();
        this.getRootPane().setDefaultButton(this.pulsanteAggiorna);
        gestioneFinestra = new FinestraDatiIncorporamentoController(
                this,selezionaCorso,sfondoDiagramma,tabella,totale
        ); 
        
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
        totale = new javax.swing.JLabel();
        sfondoDiagramma = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("attività incorporamento");
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

        totale.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        totale.setForeground(new java.awt.Color(217, 21, 21));
        totale.setText("Incorporati: ");

        sfondoDiagramma.setBackground(new java.awt.Color(231, 247, 208));

        javax.swing.GroupLayout sfondoDiagrammaLayout = new javax.swing.GroupLayout(sfondoDiagramma);
        sfondoDiagramma.setLayout(sfondoDiagrammaLayout);
        sfondoDiagrammaLayout.setHorizontalGroup(
            sfondoDiagrammaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );
        sfondoDiagrammaLayout.setVerticalGroup(
            sfondoDiagrammaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totale, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(corso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selezionaCorso, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pulsanteAggiorna, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sfondoDiagramma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(corso)
                    .addComponent(selezionaCorso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pulsanteAggiorna))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totale)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(sfondoDiagramma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pulsanteAggiornaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteAggiornaActionPerformed
        if(evt.getSource() instanceof javax.swing.JButton){
            gestioneFinestra.caricaTabella();
        }
    }//GEN-LAST:event_pulsanteAggiornaActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel corso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pulsanteAggiorna;
    private javax.swing.JComboBox selezionaCorso;
    private javax.swing.JPanel sfondoDiagramma;
    private javax.swing.JTable tabella;
    private javax.swing.JLabel totale;
    // End of variables declaration//GEN-END:variables
}
