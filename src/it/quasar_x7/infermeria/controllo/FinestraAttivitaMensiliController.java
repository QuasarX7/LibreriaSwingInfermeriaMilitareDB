package it.quasar_x7.infermeria.controllo;

import it.quasar_x7.infermeria.vista.FinestraAttivitaMensili;
import it.quasar_x7.java.utile.DataOraria;
import it.quasar_x7.java.utile.settimana;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Dott. Domenico della Peruta
 * @version 2.0.0 ultima modifica 01/10/2016
 */
public class FinestraAttivitaMensiliController {

    private final FinestraAttivitaMensili finestra;
    
    private final String[] attivita = new String [] {
        /*
            "VISITE MEDICHE MATTINALI",//ok
            "VISITE MEDICHE AMBULATORIALI",
            "RICOVERI IN INFERMERIA",//ok
            "RICOVERI IN OSPEDALE PER CURE",
            "PROFILASSI VACCINALE",//ok
            "DRUG TEST", // ok
            "PROTOCOLLO MANDELLI",
            "VISITE M-L AL RIENTRO DA MALATTIA/CONV.",
            "INVIO IN CMO/OSSERVAZIONE", // ok
            "ALTRE VISITE MEDICO LEGALI",
            "VISITE DI INCORPORAMENTO",
*/          
            "CHIEDENTI VISITA MATTINALE",
            "RICOVERATI",
            "DLT / INFORTUNI",
            "RIENTRO DA MALATTIA / LIC. CONVALESCENZA",
            "INVIO IN MALATTIA",
            "INVIO IN CMO",
            "CONVALESCENZA",
            "PS / VISITE AMBULATORIALI",
            "VISITE PERIODICHE",
            "INVIO IN VISITE SPECIALISTICHE",
            "INVIO IN LABORATORIO PER ESAMI EMATICI",
            "PRATICHE MEDICO LEGALI / 5000",
            "INVIO IN OSSERVAZIONE",
            "DRUG TEST",
            "VACCINAZIONI",
            "ATTIVITA' ADDESTRATIVE / ASSISTENZA SANITARIA",
            "ACCESSO A PRONTO SOCCORSO S.S.N."
            
        };

    public FinestraAttivitaMensiliController(FinestraAttivitaMensili finestra) {
        this.finestra = finestra;
        creaCalendario();
    }

    public void creaCalendario() {
        
        int mese = finestra.seletoreMese.getMonth()+1;
        int anno = finestra.selettoreAnno.getYear();
        int nGiorni = DataOraria.giorniMese(mese, anno);
        
        String[] intestazioneColonne = new String[nGiorni+1];
        intestazioneColonne[0]="ATTIVITA'";
        for(int i=1;i<nGiorni+1;i++){
            intestazioneColonne[i]=i+"";
        }
        
        final int COLONNE = intestazioneColonne.length;
        final int RIGHE = this.attivita.length;
        Object[][] valoriTabella = new Object [RIGHE][COLONNE];
        
        
        
        for(int r=0; r <  RIGHE; r++){
            String _attivita = this.attivita[r];
            valoriTabella[r][0] = _attivita;
            for(int c =1; c < COLONNE; c++){
                //TODO
            }
        }
        
        finestra.calendario.setModel(new javax.swing.table.DefaultTableModel(
            valoriTabella,
            intestazioneColonne
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        if (finestra.calendario.getColumnModel().getColumnCount() > 0) {
            
            finestra.calendario.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer(){
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component cell = new DefaultTableCellRenderer().getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    cell.setBackground(Color.lightGray);
                    return cell;
                }
            });
            finestra.calendario.getColumnModel().getColumn(0).setResizable(false);
            finestra.calendario.getColumnModel().getColumn(0).setPreferredWidth(200);
            for(int i=1; i < COLONNE;i++){
                int giorno = i;
                final DataOraria data=new DataOraria(giorno,mese,anno);
                finestra.calendario.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(){
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component cell = new DefaultTableCellRenderer().getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    
                    if(data.giornoSettimana() == settimana.Domenica || data.giornoSettimana() == settimana.Sabato){
                        cell.setBackground(Color.red);
                    }else if(data.giornoSettimana() == settimana.Venerdì){
                        cell.setBackground(Color.orange);
                    }
                    return cell;
                }
            });
                finestra.calendario.getColumnModel().getColumn(i).setResizable(false);
                finestra.calendario.getColumnModel().getColumn(i).setPreferredWidth(1);
            }
        }
    }
    
    
}
