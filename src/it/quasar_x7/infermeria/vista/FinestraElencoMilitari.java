package it.quasar_x7.infermeria.vista;


import javax.swing.JButton;

import javax.swing.JTable;
import javax.swing.JTextField;

import it.quasar_x7.infermeria.controllo.FinestraElencoMilitariController;

/*******************************************************************************
 * Finestra che permette di modificare i dati principali di un militare, non 
 * modificabili con quella di GML, come i dati anagrafici.
 * 
 * 
 * @author Dott. Domenico della Peruta
 * @version 1.0.0    ulrima modifica 29.09.2016
 ******************************************************************************/
public class FinestraElencoMilitari extends javax.swing.JFrame {

    
    public FinestraElencoMilitariController gestore;
    
    public FinestraElencoMilitari() {
        initComponents();
        this.gestore = new FinestraElencoMilitariController(this);
    }

    /*********************************************
     * Restituisce il nominativo del militare 
     * selezionato 
     * 
     * @return
     *********************************************/
    public Object[] seleziona(){
        return this.gestore.seleziona();
    }

     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        elencoMilitari = new javax.swing.JTable();
        pulsanteModifica = new javax.swing.JButton();
        pulsanteElimina = new javax.swing.JButton();
        campoTrova = new javax.swing.JTextField();
        etichetta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Elenco Militari");
        setBackground(new java.awt.Color(255, 204, 204));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        elencoMilitari.setBackground(new java.awt.Color(0, 0, 0));
        elencoMilitari.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        elencoMilitari.setForeground(new java.awt.Color(255, 255, 255));
        elencoMilitari.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "CORSO", "CP/RGT", "COGNOME", "NOME", "DATA DI NASCITA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        elencoMilitari.setSelectionBackground(new java.awt.Color(255, 255, 255));
        elencoMilitari.setSelectionForeground(new java.awt.Color(0, 0, 0));
        elencoMilitari.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                elencoMilitariMouseMoved(evt);
            }
        });
        jScrollPane1.setViewportView(elencoMilitari);

        pulsanteModifica.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        pulsanteModifica.setForeground(new java.awt.Color(0, 51, 51));
        pulsanteModifica.setText("Modifica");
        pulsanteModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulsanteModificaActionPerformed(evt);
            }
        });

        pulsanteElimina.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        pulsanteElimina.setForeground(new java.awt.Color(102, 0, 0));
        pulsanteElimina.setText("Elimina");
        pulsanteElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulsanteEliminaActionPerformed(evt);
            }
        });

        campoTrova.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoTrovaKeyReleased(evt);
            }
        });

        etichetta.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        etichetta.setText("Cognome");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(etichetta, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(campoTrova)
                .addGap(12, 12, 12))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pulsanteElimina, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pulsanteModifica, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 399, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTrova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etichetta))
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pulsanteElimina)
                    .addComponent(pulsanteModifica)))
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

    private void pulsanteEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteEliminaActionPerformed
        this.gestore.pulsanteElimina(evt);
        
    }//GEN-LAST:event_pulsanteEliminaActionPerformed

    private void pulsanteModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteModificaActionPerformed
        this.gestore.pulsanteModifica(evt);
        
    }//GEN-LAST:event_pulsanteModificaActionPerformed

    private void elencoMilitariMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_elencoMilitariMouseMoved
        this.gestore.mouseTabella(evt);
        
    }//GEN-LAST:event_elencoMilitariMouseMoved

    private void campoTrovaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTrovaKeyReleased
        this.gestore.ricercaCampoTrova(evt);
        
    }//GEN-LAST:event_campoTrovaKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    

    

    public JTable getElencoMilitari() {
        return elencoMilitari;
    }

    public JTextField getCampoTrova() {
        return campoTrova;
    }

    public JButton getPulsanteElimina() {
        return pulsanteElimina;
    }

    public JButton getPulsanteModifica() {
        return pulsanteModifica;
    }


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoTrova;
    private javax.swing.JTable elencoMilitari;
    private javax.swing.JLabel etichetta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pulsanteElimina;
    private javax.swing.JButton pulsanteModifica;
    // End of variables declaration//GEN-END:variables


}
