package it.difesa.esercito.rav17.infermeria.vista;

import it.difesa.esercito.rav17.infermeria.DaseDati.Dati;
import it.difesa.esercito.rav17.infermeria.controllo.FinestraModificaMilitareController;
import it.quasar_x7.java.utile.DataOraria;

/**
 * *****************************************************************************
 *
 *
 * @author Domenico della Peruta
 * @version 2.0.0 ultima modifica 04/04/2016
 *****************************************************************************
 */
public class FinestraModificaMilitare extends javax.swing.JFrame {

    private final FinestraModificaMilitareController gestore;

    public FinestraModificaMilitare(String cognome, String nome, DataOraria dataNascita) {
        initComponents();
        this.getRootPane().setDefaultButton(pulsanteSalvaModifiche);
        this.gestore = new FinestraModificaMilitareController(this, cognome, nome, dataNascita);
    }

//---------------------- codice autogenerato -----------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        pannelloNominativo = new javax.swing.JPanel();
        testoLuogo = new javax.swing.JTextField();
        luogoNascita = new javax.swing.JLabel();
        testoNome = new javax.swing.JTextField();
        testoCognome = new javax.swing.JTextField();
        testoGrado = new javax.swing.JTextField();
        dataNascita = new javax.swing.JLabel();
        cognome = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        grado = new javax.swing.JLabel();
        compRegg = new javax.swing.JLabel();
        valoreCpRgt = new javax.swing.JComboBox();
        corso = new javax.swing.JLabel();
        valoreDataNascita = new it.quasar_x7.java.swing.componenti.CampoData();
        pulsanteSalvaModifiche = new javax.swing.JButton();
        valoreCorso = new javax.swing.JComboBox();
        corso1 = new javax.swing.JLabel();
        valoreSesso = new javax.swing.JComboBox();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modifica dati Militare");
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setIconImages(null);
        setResizable(false);

        pannelloNominativo.setBackground(new java.awt.Color(255, 255, 255));
        pannelloNominativo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "MILITARTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14), new java.awt.Color(51, 0, 51))); // NOI18N

        testoLuogo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        testoLuogo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                testoLuogoFocusGained(evt);
            }
        });
        testoLuogo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                testoLuogoKeyReleased(evt);
            }
        });

        luogoNascita.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        luogoNascita.setText("luogo di nascita");

        testoNome.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        testoNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                testoNomeFocusGained(evt);
            }
        });
        testoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                testoNomeKeyReleased(evt);
            }
        });

        testoCognome.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        testoCognome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                testoCognomeFocusGained(evt);
            }
        });
        testoCognome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                testoCognomeKeyReleased(evt);
            }
        });

        testoGrado.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        testoGrado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                testoGradoFocusGained(evt);
            }
        });
        testoGrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                testoGradoKeyReleased(evt);
            }
        });

        dataNascita.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        dataNascita.setText("data di nascita");

        cognome.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        cognome.setText("cognome");

        nome.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        nome.setText("nome");

        grado.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        grado.setText("grado");

        compRegg.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        compRegg.setText("cp/rgt");

        valoreCpRgt.setEditable(true);
        valoreCpRgt.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        valoreCpRgt.setForeground(new java.awt.Color(0, 102, 102));
        valoreCpRgt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1ªcp. 1°btg. 17°rgt.", "2ªcp. 1°btg. 17°rgt.", "3ªcp. 1°btg. 17°rgt.", "1ªcp. 2°btg. 17°rgt.", "2ªcp. 2°btg. 17°rgt.", "3ªcp. 2°btg. 17°rgt.", "C.C.S.L. - REP SPT", "TRAS. e MANT. - REP SPT", "C.DO - REP SPT", "C.DO RUA" }));
        valoreCpRgt.setSelectedIndex(-1);
        valoreCpRgt.setToolTipText("");
        valoreCpRgt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                valoreCpRgtKeyReleased(evt);
            }
        });

        corso.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        corso.setText("corso");

        pulsanteSalvaModifiche.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        pulsanteSalvaModifiche.setForeground(new java.awt.Color(0, 51, 51));
        pulsanteSalvaModifiche.setText("Salva modifiche");
        pulsanteSalvaModifiche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulsanteSalvaModificheActionPerformed(evt);
            }
        });

        corso1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        corso1.setText("sesso");

        valoreSesso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "F" }));

        javax.swing.GroupLayout pannelloNominativoLayout = new javax.swing.GroupLayout(pannelloNominativo);
        pannelloNominativo.setLayout(pannelloNominativoLayout);
        pannelloNominativoLayout.setHorizontalGroup(
            pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloNominativoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannelloNominativoLayout.createSequentialGroup()
                        .addComponent(compRegg, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(valoreCpRgt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(corso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(valoreCorso, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(corso1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(valoreSesso, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelloNominativoLayout.createSequentialGroup()
                        .addComponent(dataNascita, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valoreDataNascita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(luogoNascita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(testoLuogo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelloNominativoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pulsanteSalvaModifiche)
                            .addGroup(pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pannelloNominativoLayout.createSequentialGroup()
                                    .addComponent(grado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(testoGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pannelloNominativoLayout.createSequentialGroup()
                                    .addComponent(cognome)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(testoCognome, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(nome)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(testoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
        );
        pannelloNominativoLayout.setVerticalGroup(
            pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloNominativoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compRegg)
                    .addComponent(valoreCpRgt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corso)
                    .addComponent(valoreCorso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(corso1)
                    .addComponent(valoreSesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grado)
                    .addComponent(testoGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cognome)
                    .addComponent(testoCognome)
                    .addComponent(testoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome))
                .addGap(0, 0, 0)
                .addGroup(pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(luogoNascita)
                        .addComponent(testoLuogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dataNascita))
                    .addComponent(valoreDataNascita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(pulsanteSalvaModifiche)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pannelloNominativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pannelloNominativo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * ***************************************************
     * metodo che implementa le aggioni del pulsante che salva le modifiche
     *
     * @param evt
     ****************************************************
     */
    private void pulsanteSalvaModificheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteSalvaModificheActionPerformed
        this.gestore.pulsanteModifica(evt);

    }//GEN-LAST:event_pulsanteSalvaModificheActionPerformed

    private void testoGradoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_testoGradoFocusGained
        if (evt.getSource() instanceof javax.swing.JTextField) {
            this.testoGrado.selectAll();
        }
    }//GEN-LAST:event_testoGradoFocusGained

    private void testoCognomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_testoCognomeFocusGained
        if (evt.getSource() instanceof javax.swing.JTextField) {
            this.testoCognome.selectAll();
        }
    }//GEN-LAST:event_testoCognomeFocusGained

    private void testoNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_testoNomeFocusGained
        if (evt.getSource() instanceof javax.swing.JTextField) {
            this.testoNome.selectAll();
        }
    }//GEN-LAST:event_testoNomeFocusGained

    private void testoLuogoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_testoLuogoFocusGained
        if (evt.getSource() instanceof javax.swing.JTextField) {
            this.testoLuogo.selectAll();
        }
    }//GEN-LAST:event_testoLuogoFocusGained

    private void testoCognomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_testoCognomeKeyReleased
        if (evt.getSource() instanceof javax.swing.JTextField) {
            String _cognome = testoCognome.getText();
            if (!Dati.alfanumerico(_cognome)) {
                testoCognome.setText(_cognome.substring(0, _cognome.length() - 1));
            }
        }
    }//GEN-LAST:event_testoCognomeKeyReleased

    private void testoNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_testoNomeKeyReleased
        if (evt.getSource() instanceof javax.swing.JTextField) {
            String _nome = testoNome.getText();
            if (!Dati.alfanumerico(_nome)) {
                testoNome.setText(_nome.substring(0, _nome.length() - 1));
            }
        }
    }//GEN-LAST:event_testoNomeKeyReleased

    private void testoLuogoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_testoLuogoKeyReleased
        if (evt.getSource() instanceof javax.swing.JTextField) {
            String _luogo = testoLuogo.getText();
            if (!Dati.alfanumerico(_luogo)) {
                testoLuogo.setText(_luogo.substring(0, _luogo.length() - 1));
            }
        }
    }//GEN-LAST:event_testoLuogoKeyReleased

    private void testoGradoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_testoGradoKeyReleased
        if (evt.getSource() instanceof javax.swing.JTextField) {
            String _grado = testoGrado.getText();
            if (!Dati.alfanumerico(_grado)) {
                testoGrado.setText(_grado.substring(0, _grado.length() - 1));
            }
        }
    }//GEN-LAST:event_testoGradoKeyReleased

    private void valoreCpRgtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valoreCpRgtKeyReleased

    }//GEN-LAST:event_valoreCpRgtKeyReleased

//------------------------- proprietà autogenerate  ----------------------------
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cognome;
    private javax.swing.JLabel compRegg;
    private javax.swing.JLabel corso;
    private javax.swing.JLabel corso1;
    private javax.swing.JLabel dataNascita;
    private javax.swing.JLabel grado;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel luogoNascita;
    private javax.swing.JLabel nome;
    private javax.swing.JPanel pannelloNominativo;
    public javax.swing.JButton pulsanteSalvaModifiche;
    public javax.swing.JTextField testoCognome;
    public javax.swing.JTextField testoGrado;
    public javax.swing.JTextField testoLuogo;
    public javax.swing.JTextField testoNome;
    public javax.swing.JComboBox valoreCorso;
    public javax.swing.JComboBox valoreCpRgt;
    public it.quasar_x7.java.swing.componenti.CampoData valoreDataNascita;
    public javax.swing.JComboBox valoreSesso;
    // End of variables declaration//GEN-END:variables

}
