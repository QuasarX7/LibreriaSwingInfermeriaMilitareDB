package it.difesa.esercito.rav17.infermeria.vista;

import it.difesa.esercito.rav17.infermeria.controllo.FinestraTabellaController;


/*******************************************************************************
 *
 * @author Domenico della Peruta
 ******************************************************************************/
public class FinestraTabella extends javax.swing.JFrame {

    
    private final FinestraTabellaController gestore;
    
    /** Creates new form FinestraTabella */
    public FinestraTabella() {
        initComponents();
        gestore = new FinestraTabellaController(this);
                   
               
    }



    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sfondo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabella = new javax.swing.JTable();
        pulsanteFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("tabelle");
        setResizable(false);

        sfondo.setBackground(new java.awt.Color(153, 153, 153));

        tabella.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        tabella.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tabella.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabella.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabella.setGridColor(new java.awt.Color(0, 0, 102));
        tabella.setSelectionBackground(new java.awt.Color(102, 102, 255));
        tabella.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tabella.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tabellaMouseMoved(evt);
            }
        });
        jScrollPane2.setViewportView(tabella);

        pulsanteFile.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        pulsanteFile.setForeground(new java.awt.Color(1, 103, 43));
        pulsanteFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/it/quasar_x7/immagini/excel.jpeg"))); // NOI18N
        pulsanteFile.setText("Crea FILE");
        pulsanteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulsanteFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sfondoLayout = new javax.swing.GroupLayout(sfondo);
        sfondo.setLayout(sfondoLayout);
        sfondoLayout.setHorizontalGroup(
            sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sfondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sfondoLayout.createSequentialGroup()
                        .addGap(856, 856, 856)
                        .addComponent(pulsanteFile)))
                .addContainerGap())
        );
        sfondoLayout.setVerticalGroup(
            sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sfondoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(pulsanteFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sfondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sfondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabellaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaMouseMoved

}//GEN-LAST:event_tabellaMouseMoved

    private void pulsanteFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteFileActionPerformed
        if(evt.getSource() instanceof javax.swing.JButton){
            gestore.salvaFileExel();
        }
    }//GEN-LAST:event_pulsanteFileActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JButton pulsanteFile;
    private javax.swing.JPanel sfondo;
    public javax.swing.JTable tabella;
    // End of variables declaration//GEN-END:variables

   

}
