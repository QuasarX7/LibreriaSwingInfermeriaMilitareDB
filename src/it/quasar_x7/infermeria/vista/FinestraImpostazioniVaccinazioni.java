package it.quasar_x7.infermeria.vista;

import it.quasar_x7.infermeria.controllo.FinestraImpostazioneVaccinazioniController;

/*******************************************************************************
 *
 * @author Domenico della Peruta
 * @version 3.0.0 ultima modifica 12/04/2016
 ******************************************************************************/
public class FinestraImpostazioniVaccinazioni extends javax.swing.JFrame {


//--------------------------- proprietà ----------------------------------------

    private final FinestraImpostazioneVaccinazioniController gestore;

    
    
//-------------------------- costruttore ---------------------------------------
    public FinestraImpostazioniVaccinazioni() {
        initComponents();
        getRootPane().setDefaultButton(pulsanteSalva);
        this.gestore = new FinestraImpostazioneVaccinazioniController(this);
    }
    
    

    




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sfondo = new javax.swing.JPanel();
        campoData3 = new com.toedter.calendar.JDateChooser();
        campoData4 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        campoData1 = new com.toedter.calendar.JDateChooser();
        campoSerie2 = new javax.swing.JTextField();
        campoData2 = new com.toedter.calendar.JDateChooser();
        campoNome2 = new javax.swing.JTextField();
        medico = new javax.swing.JLabel();
        campoData = new com.toedter.calendar.JDateChooser();
        pulsanteSalva = new javax.swing.JButton();
        valoreMedico = new javax.swing.JComboBox();
        campoData5 = new com.toedter.calendar.JDateChooser();
        campoData6 = new com.toedter.calendar.JDateChooser();
        campoNome3 = new javax.swing.JTextField();
        campoSerie3 = new javax.swing.JTextField();
        campoLotto3 = new javax.swing.JTextField();
        campoDitta3 = new javax.swing.JTextField();
        campoDitta4 = new javax.swing.JTextField();
        campoNome4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        campoLotto4 = new javax.swing.JTextField();
        dataScadenza = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoData8 = new com.toedter.calendar.JDateChooser();
        campoLotto1 = new javax.swing.JTextField();
        campoData7 = new com.toedter.calendar.JDateChooser();
        campoDitta1 = new javax.swing.JTextField();
        campoNome1 = new javax.swing.JTextField();
        campoSerie1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        campoLotto2 = new javax.swing.JTextField();
        campoDitta2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        campoSerie8 = new javax.swing.JTextField();
        campoDitta8 = new javax.swing.JTextField();
        campoLotto8 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoNome8 = new javax.swing.JTextField();
        campoSerie = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        campoDitta = new javax.swing.JTextField();
        campoSerie7 = new javax.swing.JTextField();
        campoLotto = new javax.swing.JTextField();
        campoDitta7 = new javax.swing.JTextField();
        campoLotto7 = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        campoNome7 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        campoSerie6 = new javax.swing.JTextField();
        campoDitta6 = new javax.swing.JTextField();
        campoNome6 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        campoLotto6 = new javax.swing.JTextField();
        campoSerie5 = new javax.swing.JTextField();
        campoNome5 = new javax.swing.JTextField();
        campoDitta5 = new javax.swing.JTextField();
        campoLotto5 = new javax.swing.JTextField();
        campoSerie4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        selezionaSom8 = new javax.swing.JComboBox();
        selezionaSom = new javax.swing.JComboBox();
        selezionaSom1 = new javax.swing.JComboBox();
        selezionaSom2 = new javax.swing.JComboBox();
        selezionaSom3 = new javax.swing.JComboBox();
        selezionaSom4 = new javax.swing.JComboBox();
        selezionaSom5 = new javax.swing.JComboBox();
        selezionaSom6 = new javax.swing.JComboBox();
        selezionaSom7 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        sfondo.setBackground(new java.awt.Color(246, 246, 246));

        campoData3.setBackground(new java.awt.Color(255, 255, 255));
        campoData3.setDateFormatString("dd.MM.yyyy");
        campoData3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoData4.setBackground(new java.awt.Color(255, 255, 255));
        campoData4.setDateFormatString("dd.MM.yyyy");
        campoData4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel9.setText("Tetano/Difterite");

        campoData1.setBackground(new java.awt.Color(255, 255, 255));
        campoData1.setDateFormatString("dd.MM.yyyy");
        campoData1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoSerie2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoData2.setBackground(new java.awt.Color(255, 255, 255));
        campoData2.setDateFormatString("dd.MM.yyyy");
        campoData2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoNome2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        medico.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        medico.setForeground(new java.awt.Color(102, 0, 0));
        medico.setText("medico vaccinatore");

        campoData.setBackground(new java.awt.Color(255, 255, 255));
        campoData.setDateFormatString("dd.MM.yyyy");
        campoData.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        pulsanteSalva.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pulsanteSalva.setText("salva");
        pulsanteSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulsanteSalvaActionPerformed(evt);
            }
        });

        valoreMedico.setEditable(true);
        valoreMedico.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        valoreMedico.setForeground(new java.awt.Color(153, 0, 0));

        campoData5.setBackground(new java.awt.Color(255, 255, 255));
        campoData5.setDateFormatString("dd.MM.yyyy");
        campoData5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoData6.setBackground(new java.awt.Color(255, 255, 255));
        campoData6.setDateFormatString("dd.MM.yyyy");
        campoData6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoNome3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoSerie3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoLotto3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoDitta3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoDitta4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoNome4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel10.setText("Tetano/Difterite/Polio");

        campoLotto4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        dataScadenza.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        dataScadenza.setText("data di scadenza");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel5.setText("serie");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel7.setText("EPATITE B");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel6.setText("EPATITE A");

        campoData8.setBackground(new java.awt.Color(255, 255, 255));
        campoData8.setDateFormatString("dd.MM.yyyy");
        campoData8.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoLotto1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoData7.setBackground(new java.awt.Color(255, 255, 255));
        campoData7.setDateFormatString("dd.MM.yyyy");
        campoData7.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoDitta1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoNome1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoSerie1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel8.setText("EPATITE A+B");

        campoLotto2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoDitta2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel2.setText("nome farmaco");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Impostazioni Temporaree");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("(UTILIZZARE SOLO I CAMPI NECESSARI)");

        campoSerie8.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoDitta8.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoLotto8.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel4.setText("lotto");

        campoNome8.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoSerie.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel14.setText("Morbillo/Parotite/Rosolia");

        campoDitta.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoSerie7.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoLotto.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoDitta7.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoLotto7.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoNome.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoNome7.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel3.setText("ditta");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel13.setText("MENINGITE");

        campoSerie6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoDitta6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoNome6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel12.setText("VARICELLA");

        campoLotto6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoSerie5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoNome5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoDitta5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoLotto5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        campoSerie4.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel11.setText("POLIO");

        selezionaSom8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        selezionaSom8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SC", "IM", "OS" }));
        selezionaSom8.setSelectedIndex(-1);

        selezionaSom.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        selezionaSom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SC", "IM", "OS" }));
        selezionaSom.setSelectedIndex(-1);

        selezionaSom1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        selezionaSom1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SC", "IM", "OS" }));
        selezionaSom1.setSelectedIndex(-1);

        selezionaSom2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        selezionaSom2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SC", "IM", "OS" }));
        selezionaSom2.setSelectedIndex(-1);

        selezionaSom3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        selezionaSom3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SC", "IM", "OS" }));
        selezionaSom3.setSelectedIndex(-1);

        selezionaSom4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        selezionaSom4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SC", "IM", "OS" }));
        selezionaSom4.setSelectedIndex(-1);

        selezionaSom5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        selezionaSom5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SC", "IM", "OS" }));
        selezionaSom5.setSelectedIndex(-1);

        selezionaSom6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        selezionaSom6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SC", "IM", "OS" }));
        selezionaSom6.setSelectedIndex(-1);

        selezionaSom7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        selezionaSom7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SC", "IM", "OS" }));
        selezionaSom7.setSelectedIndex(-1);

        javax.swing.GroupLayout sfondoLayout = new javax.swing.GroupLayout(sfondo);
        sfondo.setLayout(sfondoLayout);
        sfondoLayout.setHorizontalGroup(
            sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sfondoLayout.createSequentialGroup()
                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(sfondoLayout.createSequentialGroup()
                        .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sfondoLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69))
                            .addGroup(sfondoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(dataScadenza)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sfondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sfondoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                                .addComponent(medico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valoreMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(pulsanteSalva, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sfondoLayout.createSequentialGroup()
                                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sfondoLayout.createSequentialGroup()
                                        .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(sfondoLayout.createSequentialGroup()
                                                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(selezionaSom6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(selezionaSom7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(6, 6, 6))
                                            .addGroup(sfondoLayout.createSequentialGroup()
                                                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sfondoLayout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(selezionaSom, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(sfondoLayout.createSequentialGroup()
                                                        .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(selezionaSom2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(selezionaSom1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(selezionaSom3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(selezionaSom4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(selezionaSom5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(sfondoLayout.createSequentialGroup()
                                                .addComponent(campoNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoDitta1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoLotto1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoSerie1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(sfondoLayout.createSequentialGroup()
                                                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoDitta, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoLotto, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(sfondoLayout.createSequentialGroup()
                                                .addComponent(campoNome2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoDitta2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoLotto2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoSerie2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(sfondoLayout.createSequentialGroup()
                                                .addComponent(campoNome3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoDitta3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoLotto3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoSerie3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(sfondoLayout.createSequentialGroup()
                                                .addComponent(campoNome4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoDitta4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoLotto4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoSerie4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(sfondoLayout.createSequentialGroup()
                                                .addComponent(campoNome5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoDitta5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoLotto5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoSerie5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sfondoLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(campoNome6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoDitta6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoLotto6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoSerie6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sfondoLayout.createSequentialGroup()
                                        .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(sfondoLayout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(selezionaSom8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoNome8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoDitta8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoLotto8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoSerie8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(sfondoLayout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(campoNome7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoDitta7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoLotto7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoSerie7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)))
                                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoData8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoData7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoData6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoData5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoData4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoData3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoData2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoData1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoData, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        sfondoLayout.setVerticalGroup(
            sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sfondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(0, 0, 0)
                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(dataScadenza))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sfondoLayout.createSequentialGroup()
                        .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(campoNome)
                        .addComponent(campoDitta)
                        .addComponent(campoLotto)
                        .addComponent(campoSerie)
                        .addComponent(selezionaSom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(campoNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoDitta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoLotto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoSerie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(selezionaSom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoData1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoSerie2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoLotto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoDitta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoNome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(selezionaSom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoData2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoSerie3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoLotto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoDitta3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoNome3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(selezionaSom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoData3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoSerie4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoLotto4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoDitta4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoNome4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(selezionaSom4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoData4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoSerie5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoLotto5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoDitta5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoNome5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(selezionaSom5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoData5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoSerie6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoLotto6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoDitta6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoNome6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(selezionaSom6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoData6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoSerie7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoLotto7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoDitta7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoNome7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(selezionaSom7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoData7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoSerie8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoLotto8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoDitta8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoNome8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(selezionaSom8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoData8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pulsanteSalva)
                    .addComponent(valoreMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medico))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(sfondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sfondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pulsanteSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteSalvaActionPerformed
        if(evt.getSource() instanceof javax.swing.JButton){
            this.gestore.caricaFile();
        }

    }//GEN-LAST:event_pulsanteSalvaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.toedter.calendar.JDateChooser campoData;
    public com.toedter.calendar.JDateChooser campoData1;
    public com.toedter.calendar.JDateChooser campoData2;
    public com.toedter.calendar.JDateChooser campoData3;
    public com.toedter.calendar.JDateChooser campoData4;
    public com.toedter.calendar.JDateChooser campoData5;
    public com.toedter.calendar.JDateChooser campoData6;
    public com.toedter.calendar.JDateChooser campoData7;
    public com.toedter.calendar.JDateChooser campoData8;
    public javax.swing.JTextField campoDitta;
    public javax.swing.JTextField campoDitta1;
    public javax.swing.JTextField campoDitta2;
    public javax.swing.JTextField campoDitta3;
    public javax.swing.JTextField campoDitta4;
    public javax.swing.JTextField campoDitta5;
    public javax.swing.JTextField campoDitta6;
    public javax.swing.JTextField campoDitta7;
    public javax.swing.JTextField campoDitta8;
    public javax.swing.JTextField campoLotto;
    public javax.swing.JTextField campoLotto1;
    public javax.swing.JTextField campoLotto2;
    public javax.swing.JTextField campoLotto3;
    public javax.swing.JTextField campoLotto4;
    public javax.swing.JTextField campoLotto5;
    public javax.swing.JTextField campoLotto6;
    public javax.swing.JTextField campoLotto7;
    public javax.swing.JTextField campoLotto8;
    public javax.swing.JTextField campoNome;
    public javax.swing.JTextField campoNome1;
    public javax.swing.JTextField campoNome2;
    public javax.swing.JTextField campoNome3;
    public javax.swing.JTextField campoNome4;
    public javax.swing.JTextField campoNome5;
    public javax.swing.JTextField campoNome6;
    public javax.swing.JTextField campoNome7;
    public javax.swing.JTextField campoNome8;
    public javax.swing.JTextField campoSerie;
    public javax.swing.JTextField campoSerie1;
    public javax.swing.JTextField campoSerie2;
    public javax.swing.JTextField campoSerie3;
    public javax.swing.JTextField campoSerie4;
    public javax.swing.JTextField campoSerie5;
    public javax.swing.JTextField campoSerie6;
    public javax.swing.JTextField campoSerie7;
    public javax.swing.JTextField campoSerie8;
    private javax.swing.JLabel dataScadenza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel medico;
    public javax.swing.JButton pulsanteSalva;
    public javax.swing.JComboBox selezionaSom;
    public javax.swing.JComboBox selezionaSom1;
    public javax.swing.JComboBox selezionaSom2;
    public javax.swing.JComboBox selezionaSom3;
    public javax.swing.JComboBox selezionaSom4;
    public javax.swing.JComboBox selezionaSom5;
    public javax.swing.JComboBox selezionaSom6;
    public javax.swing.JComboBox selezionaSom7;
    public javax.swing.JComboBox selezionaSom8;
    private javax.swing.JPanel sfondo;
    public javax.swing.JComboBox valoreMedico;
    // End of variables declaration//GEN-END:variables

}
