package it.quasar_x7.java.swing.stampa;


import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*******************************************************************************
 *
 * @author Domenico della Peruta
 ******************************************************************************/
public class FinestraStampatiOrizzontali extends FinestraStampato {

    
    private int id = 0;
    private ArrayList<String> fogli;    
//--------------------------- costruttore --------------------------------------
    
    public FinestraStampatiOrizzontali() {
        initComponents();
        fogli = new ArrayList<String>();  
        
    }

    public void aggiungiTesto(String testo){
       String stile = "font-family: Times; font-size: 8px";
        String blocco = "<div style=\"" + stile + "\" >" + testo + "</div>";
        fogli.add(blocco);
        this.seleziona(id);
    }
    

    
    private void seleziona(int id){        
        if(!fogli.isEmpty()){
            this.campoIndice.setText(
                    String.valueOf((id+1)+" di "+fogli.size()));

            stampato.cancella();
            stampato.aggiungiBlocco(fogli.get(id));
            
            
        }else{
            JOptionPane.showMessageDialog(
                    this,
                    "Pagina vuota!",
                    "avviso", JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
        }
    }
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sfondo = new javax.swing.JPanel();
        stampato = new it.quasar_x7.java.swing.stampa.StampatoOrizzontale();
        punsanteDietro = new javax.swing.JButton();
        campoIndice = new javax.swing.JTextField();
        punsanteAvanti = new javax.swing.JButton();
        pulsanteStampaTutte = new javax.swing.JButton();
        pulsanteStampa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stampato Visite");
        setResizable(false);

        sfondo.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout sfondoLayout = new javax.swing.GroupLayout(sfondo);
        sfondo.setLayout(sfondoLayout);
        sfondoLayout.setHorizontalGroup(
            sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sfondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stampato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        sfondoLayout.setVerticalGroup(
            sfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sfondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stampato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pulsanteStampa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(punsanteDietro)
                        .addGap(3, 3, 3)
                        .addComponent(campoIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(punsanteAvanti)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pulsanteStampaTutte)
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pulsanteStampa)
                    .addComponent(punsanteDietro)
                    .addComponent(campoIndice, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pulsanteStampaTutte)
                    .addComponent(punsanteAvanti))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
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
            pf.setOrientation(PageFormat.LANDSCAPE);

            pj.setPrintable(stampato, pf);
                           
            try {                            
                pj.print(); 
                javax.swing.JOptionPane.showMessageDialog(
                        this, "Foglio stampato con successo ^_^", "OK!", 
                        javax.swing.JOptionPane.OK_OPTION, 
                        new javax.swing.ImageIcon(
                        getClass().getResource(
                        "/it/esercito/rua/repSup/gestoreProgramma/ballerina.gif")));
                this.setVisible(false);
            } catch (PrinterException e) {
                javax.swing.JOptionPane.showMessageDialog(
                        this, "Foglio non stampato", "Errore!", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();      
            }
         
            /*
             * Stampa processoStampa = new Stampa(this.stampato);
           processoStampa.orientamento(Stampa.ORIZZONTALE);
           processoStampa.formato(Stampa.A4);
            processoStampa.attivaStampante(this);*/
        }
    }//GEN-LAST:event_pulsanteStampaActionPerformed

    private void punsanteAvantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_punsanteAvantiActionPerformed
        if(evt.getSource() instanceof javax.swing.JButton){
            if(fogli != null){
                if((id+1)<fogli.size()){
                    this.seleziona(++id);
                }
            }
        }
    }//GEN-LAST:event_punsanteAvantiActionPerformed

    private void punsanteDietroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_punsanteDietroActionPerformed
        if(evt.getSource() instanceof javax.swing.JButton){
            if(fogli != null){
                if((id-1)>=0){
                    this.seleziona(--id);
                }
            }
        }
    }//GEN-LAST:event_punsanteDietroActionPerformed

    private void pulsanteStampaTutteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulsanteStampaTutteActionPerformed
        if(evt.getSource() instanceof javax.swing.JButton){
            if(fogli!=null){
                PrinterJob pj = PrinterJob.getPrinterJob();
                PageFormat pf = pj.defaultPage();
                Paper paper = new Paper();

                double margin = 0; // half inch
                paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2,
                paper.getHeight() - margin * 2);
                pf.setPaper(paper);
                pf.setOrientation(PageFormat.LANDSCAPE);

                pj.setPrintable(stampato, pf);

                                   
                try {
                    for(int i=0;i<fogli.size();i++){
                        this.seleziona(i);
                        pj.print();
                    }
                    javax.swing.JOptionPane.showMessageDialog(
                        this, "Stampa avvenuta con successo ^_^", "OK!", 
                        javax.swing.JOptionPane.OK_OPTION, 
                        new javax.swing.ImageIcon(
                        getClass().getResource(
                        "/it/esercito/rua/repSup/gestoreProgramma/ballerina.gif")));
                    this.setVisible(false);
                } catch (PrinterException e) {                            
                   javax.swing.JOptionPane.showMessageDialog(
                        this, "Foglio non stampato", "Errore!", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();    
                }
                
                /*
                Properties proprietà = new Properties();
               Toolkit tk= Toolkit.getDefaultToolkit();  // Acquisiamo il toolkit

                PrintJob pj= tk.getPrintJob(this,"stampa report java",proprietà);
                
                if(pj!=null){
                     for(int i=0;i<fogli.size();i++){
                         Graphics g = pj.getGraphics(); //acquisisce pagina/e
                         if (g!=null){
                             this.seleziona(i);
                            this.stampato.printAll(g);
                            g.dispose();
                         }
                     }
                     pj.end();
                }*/

            }
        }
    }//GEN-LAST:event_pulsanteStampaTutteActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoIndice;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pulsanteStampa;
    private javax.swing.JButton pulsanteStampaTutte;
    private javax.swing.JButton punsanteAvanti;
    private javax.swing.JButton punsanteDietro;
    private javax.swing.JPanel sfondo;
    private it.quasar_x7.java.swing.stampa.StampatoOrizzontale stampato;
    // End of variables declaration//GEN-END:variables

}
