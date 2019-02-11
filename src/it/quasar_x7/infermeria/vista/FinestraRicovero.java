package it.quasar_x7.infermeria.vista;

import it.quasar_x7.infermeria.controllo.FinestraRicoveroController;
import it.quasar_x7.java.utile.DataOraria;
/*******************************************************************************
 *
 * @author Domenico della Peruta
 * @version 2.0.0 ultima modifica 03/10/2016
 ******************************************************************************/
public class FinestraRicovero extends javax.swing.JFrame {

    private final FinestraRicoveroController gestore;
    
//------------------------ costruttore -----------------------------------------    
    public FinestraRicovero(Object[] militare) {
        initComponents();
        gestore = new FinestraRicoveroController(this,militare);

    }

    public FinestraRicovero(Object[] militare,DataOraria ricovero) {
        initComponents();
        gestore = new FinestraRicoveroController(this,militare,ricovero);
        

    }
    
    public FinestraRicovero(Object[] militare,DataOraria ricovero,Object[] datiClinici) {
        initComponents();
        gestore = new FinestraRicoveroController(this,militare,ricovero,datiClinici);


    }
//--------------------------- metodi privati -----------------------------------

    

//------------------- codice autogenerato --------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pannelloVisita = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        testoEO = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        testoDiagnosi = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        testoTerapia = new javax.swing.JTextArea();
        pulsanteSalva = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        testoPML = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        testoDatiClinici = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        testoAnamnesi = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        dataOraIngresso = new it.quasar_x7.java.swing.componenti.CampoDataOraria();
        dataOraUscita = new it.quasar_x7.java.swing.componenti.CampoDataOraria();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        etichettaUtente = new javax.swing.JLabel();
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
        valoreGiornoNascita = new javax.swing.JFormattedTextField();
        valoreAnnoNascita = new javax.swing.JFormattedTextField();
        valoreMeseNascita = new javax.swing.JFormattedTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Finesta Ricovero");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel2MouseMoved(evt);
            }
        });

        pannelloVisita.setBackground(new java.awt.Color(255, 255, 255));
        pannelloVisita.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "VISITA MEDICA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        pannelloVisita.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pannelloVisitaMouseMoved(evt);
            }
        });

        jLabel1.setText("anamnesi");

        jLabel2.setText("dati clinici");

        jLabel3.setText("esame obiettivo");

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        testoEO.setColumns(20);
        testoEO.setLineWrap(true);
        testoEO.setRows(5);
        jScrollPane3.setViewportView(testoEO);

        jLabel4.setText("diagnosi");

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        testoDiagnosi.setColumns(20);
        testoDiagnosi.setLineWrap(true);
        testoDiagnosi.setRows(5);
        jScrollPane4.setViewportView(testoDiagnosi);

        jLabel5.setText("terapia");

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        testoTerapia.setColumns(20);
        testoTerapia.setLineWrap(true);
        testoTerapia.setRows(5);
        jScrollPane5.setViewportView(testoTerapia);

        pulsanteSalva.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        pulsanteSalva.setForeground(new java.awt.Color(0, 102, 0));
        pulsanteSalva.setText("Salva");
        pulsanteSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulsanteSalvaActionPerformed(evt);
            }
        });

        jLabel10.setText("PML e diagnosi ");

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        testoPML.setColumns(20);
        testoPML.setLineWrap(true);
        testoPML.setRows(5);
        jScrollPane6.setViewportView(testoPML);

        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        testoDatiClinici.setColumns(20);
        testoDatiClinici.setLineWrap(true);
        testoDatiClinici.setRows(5);
        jScrollPane7.setViewportView(testoDatiClinici);

        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        testoAnamnesi.setColumns(20);
        testoAnamnesi.setLineWrap(true);
        testoAnamnesi.setRows(5);
        jScrollPane8.setViewportView(testoAnamnesi);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel6.setText("data ingresso");

        jLabel7.setText("data uscita");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(31, 31, 31)
                        .addComponent(dataOraIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dataOraUscita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(382, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dataOraIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(dataOraUscita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel11.setText("fine degenza");

        etichettaUtente.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        etichettaUtente.setForeground(new java.awt.Color(255, 0, 0));
        etichettaUtente.setText("utente: ");

        javax.swing.GroupLayout pannelloVisitaLayout = new javax.swing.GroupLayout(pannelloVisita);
        pannelloVisita.setLayout(pannelloVisitaLayout);
        pannelloVisitaLayout.setHorizontalGroup(
            pannelloVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloVisitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelloVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pannelloVisitaLayout.createSequentialGroup()
                        .addComponent(etichettaUtente, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(pulsanteSalva, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                    .addGroup(pannelloVisitaLayout.createSequentialGroup()
                        .addGroup(pannelloVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pannelloVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pannelloVisitaLayout.setVerticalGroup(
            pannelloVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloVisitaLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pannelloVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pannelloVisitaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(25, 25, 25))
                    .addComponent(jScrollPane8, 0, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelloVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelloVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addGroup(pannelloVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelloVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addGroup(pannelloVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pannelloVisitaLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pannelloVisitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pulsanteSalva)
                    .addComponent(etichettaUtente)))
        );

        pannelloNominativo.setBackground(new java.awt.Color(51, 51, 51));
        pannelloNominativo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "MILITARE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        pannelloNominativo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pannelloNominativoMouseMoved(evt);
            }
        });

        testoLuogo.setEditable(false);
        testoLuogo.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        luogoNascita.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        luogoNascita.setForeground(new java.awt.Color(255, 255, 255));
        luogoNascita.setText("luogo di nascita");

        testoNome.setEditable(false);
        testoNome.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        testoCognome.setEditable(false);
        testoCognome.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        testoGrado.setEditable(false);
        testoGrado.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        dataNascita.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        dataNascita.setForeground(new java.awt.Color(255, 255, 255));
        dataNascita.setText("data di nascita");

        cognome.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        cognome.setForeground(new java.awt.Color(255, 255, 255));
        cognome.setText("cognome");

        nome.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        nome.setForeground(new java.awt.Color(255, 255, 255));
        nome.setText("nome");

        grado.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        grado.setForeground(new java.awt.Color(255, 255, 255));
        grado.setText("grado");

        valoreGiornoNascita.setEditable(false);
        valoreGiornoNascita.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        valoreAnnoNascita.setEditable(false);
        valoreAnnoNascita.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        valoreAnnoNascita.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        valoreMeseNascita.setEditable(false);
        valoreMeseNascita.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        javax.swing.GroupLayout pannelloNominativoLayout = new javax.swing.GroupLayout(pannelloNominativo);
        pannelloNominativo.setLayout(pannelloNominativoLayout);
        pannelloNominativoLayout.setHorizontalGroup(
            pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloNominativoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pannelloNominativoLayout.createSequentialGroup()
                        .addGroup(pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(grado)
                            .addComponent(cognome))
                        .addGap(26, 26, 26)
                        .addGroup(pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelloNominativoLayout.createSequentialGroup()
                                .addComponent(testoCognome, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(nome))
                            .addComponent(testoGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pannelloNominativoLayout.createSequentialGroup()
                        .addComponent(dataNascita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(valoreGiornoNascita, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valoreMeseNascita, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valoreAnnoNascita, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(luogoNascita)))
                .addGap(49, 49, 49)
                .addGroup(pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(testoNome)
                    .addComponent(testoLuogo, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pannelloNominativoLayout.setVerticalGroup(
            pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloNominativoLayout.createSequentialGroup()
                .addGroup(pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grado)
                    .addComponent(testoGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cognome)
                    .addComponent(testoCognome)
                    .addComponent(nome)
                    .addComponent(testoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pannelloNominativoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataNascita)
                    .addComponent(valoreGiornoNascita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valoreMeseNascita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(luogoNascita)
                    .addComponent(testoLuogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valoreAnnoNascita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pannelloVisita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pannelloNominativo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pannelloNominativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pannelloVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pannelloNominativoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pannelloNominativoMouseMoved
        if(evt.getSource() instanceof javax.swing.JPanel){
            this.gestore.acquisisciSelezione();
        }
    }//GEN-LAST:event_pannelloNominativoMouseMoved

    private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved
        if(evt.getSource() instanceof javax.swing.JPanel){
            this.gestore.acquisisciSelezione();
        }
    }//GEN-LAST:event_jPanel2MouseMoved

    private void pannelloVisitaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pannelloVisitaMouseMoved
        if(evt.getSource() instanceof javax.swing.JPanel){
            this.gestore.acquisisciSelezione();
        }
}//GEN-LAST:event_pannelloVisitaMouseMoved

    private void pulsanteSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteSalvaActionPerformed
        if(evt.getSource() instanceof javax.swing.JButton){
            this.gestore.salvaDati();
        }
}//GEN-LAST:event_pulsanteSalvaActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cognome;
    private javax.swing.JLabel dataNascita;
    public it.quasar_x7.java.swing.componenti.CampoDataOraria dataOraIngresso;
    public it.quasar_x7.java.swing.componenti.CampoDataOraria dataOraUscita;
    public javax.swing.JLabel etichettaUtente;
    private javax.swing.JLabel grado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel luogoNascita;
    private javax.swing.JLabel nome;
    private javax.swing.JPanel pannelloNominativo;
    private javax.swing.JPanel pannelloVisita;
    public javax.swing.JButton pulsanteSalva;
    public javax.swing.JTextArea testoAnamnesi;
    public javax.swing.JTextField testoCognome;
    public javax.swing.JTextArea testoDatiClinici;
    public javax.swing.JTextArea testoDiagnosi;
    public javax.swing.JTextArea testoEO;
    public javax.swing.JTextField testoGrado;
    public javax.swing.JTextField testoLuogo;
    public javax.swing.JTextField testoNome;
    public javax.swing.JTextArea testoPML;
    public javax.swing.JTextArea testoTerapia;
    public javax.swing.JFormattedTextField valoreAnnoNascita;
    public javax.swing.JFormattedTextField valoreGiornoNascita;
    public javax.swing.JFormattedTextField valoreMeseNascita;
    // End of variables declaration//GEN-END:variables


}
