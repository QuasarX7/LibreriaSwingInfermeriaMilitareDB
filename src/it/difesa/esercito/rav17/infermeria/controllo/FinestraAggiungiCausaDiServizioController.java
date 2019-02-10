
package it.difesa.esercito.rav17.infermeria.controllo;

import it.difesa.esercito.rav17.infermeria.DaseDati.DatiModelloGL;
import it.difesa.esercito.rav17.infermeria.vista.FinestraAggiungiCausaDiServizio;
import it.difesa.esercito.rav17.infermeria.vista.FinestraModelloGL;
import it.quasar_x7.java.utile.DataOraria;
import java.util.Date;
import javax.swing.JTextField;

/**
 *
 * @author Dott. Domenico della Peruta
 * @version 2.0.0 ultima modifica 01/10/2016
 */
public class FinestraAggiungiCausaDiServizioController {
    public String cognome;
    public String nome;
    public DataOraria nascita;
    private final DatiModelloGL DB;
    private final FinestraModelloGL finestraPadre;
    private final FinestraAggiungiCausaDiServizio finestra;

    public FinestraAggiungiCausaDiServizioController(FinestraAggiungiCausaDiServizio finestra,FinestraModelloGL finestraPadre) {
        this.finestra = finestra;
        this.finestraPadre = finestraPadre;
        DB = new DatiModelloGL();
    }

    public void pulsante(JTextField campoDipendenza,JTextField campoEnte,JTextField campoInfermita,
            JTextField campoProvvDefinitivo,JTextField campoTempestivita,com.toedter.calendar.JDateChooser dataProvvedimento) {
        Date d;
            if((d=dataProvvedimento.getDate())!=null){
                DataOraria data = new DataOraria(d); data.ora(0, 0, 0);
                Object[] record = new Object[DB.dimensioneCausaDiServizio()];
                record[3] = campoInfermita.getText();
                if(((String)record[3]).length()<1)
                    return;
                record[4] = campoDipendenza.getText();
                record[5] = campoTempestivita.getText();
                record[6] = campoProvvDefinitivo.getText();
                record[7] = data;
                record[8] = campoEnte.getText();
                
                DB.aggiungiCausaDiServizio(cognome, nome, nascita, (String)record[3], record);
                finestraPadre.getGestore().caricaTabella();
                finestra.setVisible(false);
            }
    }
    
}
