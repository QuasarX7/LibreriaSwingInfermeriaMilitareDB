package it.difesa.esercito.rav17.infermeria.vista;

import it.difesa.esercito.rav17.infermeria.controllo.FinestraElencoSelezioneMilitariController;


/**
 *
 * @author Dr Domenico della Peruta
 */
public class FinestraElencoSelezioneMilitari extends javax.swing.JFrame {

    private final FinestraElencoSelezioneMilitariController gestore;
    
    /**
     * Creates new form FinestraElencoSelezioneMilitari
     * @param corso
     */
    public FinestraElencoSelezioneMilitari(String corso) {
        initComponents();
        gestore = new FinestraElencoSelezioneMilitariController(this,corso);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        bordiScorrevoli = new javax.swing.JScrollPane();
        tabella = new javax.swing.JTable();
        pulsante = new javax.swing.JButton();

        jScrollPane2.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabella.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "cognome", "nome", "nascita", "compagnia", "seleziona"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        bordiScorrevoli.setViewportView(tabella);
        if (tabella.getColumnModel().getColumnCount() > 0) {
            tabella.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabella.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabella.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabella.getColumnModel().getColumn(3).setResizable(false);
            tabella.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabella.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        pulsante.setText("Ok");
        pulsante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulsanteActionPerformed(evt);
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
                        .addComponent(pulsante, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bordiScorrevoli, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(pulsante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bordiScorrevoli, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pulsanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteActionPerformed
        if(evt.getSource() instanceof javax.swing.JButton){
            gestore.seleziona();
        }
    }//GEN-LAST:event_pulsanteActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane bordiScorrevoli;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    public javax.swing.JButton pulsante;
    public javax.swing.JTable tabella;
    // End of variables declaration//GEN-END:variables
}
