package it.quasar_x7.java.swing.stampa;


import it.quasar_x7.immagini.Risorse;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/*******************************************************************************
 *
 * @author Domenico della Peruta
 * @version 2.0.2 ultima modifica 11/04/2016
 ******************************************************************************/
public class FinestraStampatoSemplice extends FinestraStampato {

    public static final String TIPO_FORMATO_CARATTERI = "Times New Roman";
//--------------------------- costruttore --------------------------------------
    public FinestraStampatoSemplice() {
        initComponents();
    }
    
    public void aggiungi(String testo){
        stampato.aggiungiBlocco(testo);
    }
    
    @Override
    public void aggiungiTesto(String testo){
       stampato.aggiungiBlocco(testo, TIPO_FORMATO_CARATTERI, 8, false,StampatoVerticale.ALL_SINISTRA);
    }
    
    public void aggiungiTesto(String testo,int dimenzione, boolean grossetto, int allineamento){
       stampato.aggiungiBlocco(testo, TIPO_FORMATO_CARATTERI, dimenzione, grossetto, allineamento);
    }
    
    public void aggiungiTesto(String testo,int dimenzione, boolean grossetto,boolean bordo, int allineamento){
       stampato.aggiungiBlocco(testo, TIPO_FORMATO_CARATTERI, dimenzione, grossetto,bordo, allineamento);
    }
     
    public void aggiungiBlocchi(String[] testo,int dim_caratteri, boolean grossetto, int allineamento,int lunghezza){
       stampato.aggiungiBlocchi(testo, TIPO_FORMATO_CARATTERI, dim_caratteri, grossetto, allineamento,lunghezza);
    }
    
    public void aggiungiBlocchi(String[] testo,int dim_caratteri, boolean grossetto, int allineamento,int[] lunghezza){
       stampato.aggiungiBlocchi(testo, TIPO_FORMATO_CARATTERI, dim_caratteri, grossetto, allineamento,lunghezza);
    }
    
    public void aggiungiBlocchi(String[] testo,int dim_caratteri, boolean grossetto, boolean bordo, int allineamento,int lunghezza){
       stampato.aggiungiBlocchi(testo, TIPO_FORMATO_CARATTERI, dim_caratteri, grossetto, allineamento,lunghezza);
    }
    
    public void aggiungiTitolo(String testo,int dimensione){
       stampato.aggiungiBlocco(testo, TIPO_FORMATO_CARATTERI, dimensione, true, StampatoVerticale.ALL_CENTRO);
    }
    
    public void aggiungiTabella(String[][] blocchi, String tipo_carattere, int dim_carattere, boolean grossetto, int allineamento, int lunghezza_bocchi[],boolean bordi) {
        stampato.aggiungiTabella(blocchi, tipo_carattere, dim_carattere, grossetto, allineamento, lunghezza_bocchi,bordi);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pulsanteStampa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        stampato = new it.quasar_x7.java.swing.stampa.StampatoVerticale();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Finestra di Stampa");
        setResizable(false);

        pulsanteStampa.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        pulsanteStampa.setText("Stampa");
        pulsanteStampa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulsanteStampaActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stampato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(354, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(stampato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                    .addComponent(pulsanteStampa, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(pulsanteStampa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void pulsanteStampaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteStampaActionPerformed
        if(evt.getSource() instanceof javax.swing.JButton){
            PrinterJob pj = PrinterJob.getPrinterJob();
            PageFormat pf = pj.defaultPage();
            Paper paper = new Paper();
    
            double margin = 0; // half inch
            paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2,
            paper.getHeight() - margin * 2);
            pf.setPaper(paper);
            pf.setOrientation(PageFormat.PORTRAIT);

            pj.setPrintable(stampato, pf);
                           
            try {                            
                pj.print(); 
                
                javax.swing.JOptionPane.showMessageDialog(
                        this, "Foglio stampato con successo ^_^", "OK!", 
                        javax.swing.JOptionPane.OK_OPTION, 
                        new javax.swing.ImageIcon(
                        getClass().getResource(Risorse.Immagini.BALLERINA)));
                this.setVisible(false);
            } catch (PrinterException e) {
                javax.swing.JOptionPane.showMessageDialog(
                        this, "Foglio non stampato", "Errore!", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();      
            }
            
        }
    }//GEN-LAST:event_pulsanteStampaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pulsanteStampa;
    private it.quasar_x7.java.swing.stampa.StampatoVerticale stampato;
    // End of variables declaration//GEN-END:variables

}
