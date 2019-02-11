package it.quasar_x7.infermeria.controllo;

import it.quasar_x7.infermeria.DaseDati.DatiMilitare;
import it.quasar_x7.infermeria.DaseDati.DatiStoriaVaccinale;
import it.quasar_x7.infermeria.DaseDati.DatiVaccinazioni;
import it.quasar_x7.infermeria.vista.FinestraSituazioneVaccinazioni;
import it.quasar_x7.java.utile.DataOraria;
import it.quasar_x7.java.utile.FileExcel;
import it.quasar_x7.java.utile.Tabella;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import jxl.write.WriteException;

/**
 *
 * @author Dr Domenico della Peruta
 * @version 1.0.0 modifica 31/01/2016
 */
public class FinestraSituazioneVaccinazioniController {

    private final DatiMilitare militare;
    private final DatiVaccinazioni vaccini;
    private Object[][] valoriTabella;

    class Copertura {

        private final HashMap<String, Object[]> lista;

        Copertura() {
            lista = new HashMap<String, Object[]>();
        }

        void aggiungi(String cognome, String nome, DataOraria nascita, Object[] dati) {
            String chiave = cognome + " " + nome + " " + nascita.stampaGiorno();
            Object[] valore = lista.get(chiave);
            if (valore == null) {//nuovo
                lista.put(chiave, dati);
            } else { // aggiorna campi
                for (int i = 0; i < valore.length; i++) {
                    if (dati[i] != null) {
                        if (dati[i].toString().length() > valore[i].toString().length()) {
                            valore[i] = dati[i];
                        }
                    }
                }
                lista.put(chiave, valore);
            }
        }

        void svuota() {
            lista.clear();
        }

        private Object[][] tabella() {
            Object[][] tab = new Object[lista.size()][10];
            Map ordinata = new TreeMap();
            ordinata.putAll(lista);
            int i = 0;
            for (Object riga : ordinata.values()) {
                tab[i++] = (Object[]) riga;
            }
            return tab;
        }

    };

    private final FinestraSituazioneVaccinazioni finestra;

    public FinestraSituazioneVaccinazioniController(FinestraSituazioneVaccinazioni finestra) {
        this.finestra = finestra;
        finestra.getRootPane().setDefaultButton(finestra.pulsanteAggiorna);
        //connessione alla BD
        militare = new DatiMilitare();
        vaccini = new DatiVaccinazioni();

        finestra.selezionaCorso.setModel(
                new javax.swing.DefaultComboBoxModel(
                        militare.corsiPresenti()
                )
        );

    }

    /**
     * ********************************************************
     * Funzione che permette di creare e inizializzare la tabella dei copertura
     * accedendo alla DB
     *
     * @return vero se trova i record
     *********************************************************
     */
    private void caricaTabella() {
        if (finestra.selezionaCorso.getSelectedIndex() >= 0 && finestra.selezionaCompagnia.getSelectedIndex() >= 0) {
            Copertura lista = new Copertura();
            ArrayList<Object[]> copertura
                    = vaccini.coperturaVaccinale(
                            (String) finestra.selezionaCompagnia.getSelectedItem(),
                            (String) finestra.selezionaCorso.getSelectedItem()
                    );
            if (copertura != null) {
                for (Object[] riga : copertura) {
                    System.out.println(riga[0] + " " + riga[1]);
                    lista.aggiungi((String) riga[0], (String) riga[1], (DataOraria) riga[2], riga);
                }

                valoriTabella = lista.tabella();

                finestra.tabella.setModel(new javax.swing.table.DefaultTableModel(
                        valoriTabella,
                        new String[]{
                            "cognome", "nome", "nascita", "Polio", "Tetano", "Men", "Var", "MRP", "Ep. A", "Ep. B"
                        }
                ) {
                    Class[] types = new Class[]{
                        java.lang.String.class, java.lang.String.class, java.lang.String.class,
                        java.lang.String.class, java.lang.String.class, java.lang.String.class,
                        java.lang.String.class, java.lang.String.class, java.lang.String.class,
                        java.lang.String.class
                    };
                    boolean[] canEdit = new boolean[]{
                        false, false, false, false, false, false, false, false, false, false
                    };

                    @Override
                    public Class getColumnClass(int columnIndex) {
                        return types[columnIndex];
                    }

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });

                finestra.tabella.getColumnModel().getColumn(0).setPreferredWidth(200);
                finestra.tabella.getColumnModel().getColumn(1).setPreferredWidth(200);
                finestra.tabella.getColumnModel().getColumn(2).setPreferredWidth(150);

            } else {
                javax.swing.JOptionPane.showMessageDialog(finestra,
                        "nessuna attivita' registrata",
                        "avviso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                finestra.tabella.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {},
                            {},
                            {},
                            {},
                            {},
                            {},
                            {},
                            {},
                            {},
                            {}
                        },
                        new String[]{}
                ));
            }

        } else {
            javax.swing.JOptionPane.showMessageDialog(finestra, "nessuna compagnia o corso presente",
                    "errore", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }

    public void salvaFileExel() {

        File file = null;
        if (valoriTabella != null) {
            JFileChooser salvaFile = new JFileChooser();
            DataOraria d = new DataOraria();
            d.oggi();
            salvaFile.setSelectedFile(new File(
                    finestra.selezionaCompagnia.getSelectedItem().toString() + " " + d.stampaGiorno()));

            salvaFile.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    if (file.isDirectory()) {
                        return true;
                    }
                    String estenzione = getEstenzione(file);
                    if (estenzione != null) {
                        if (estenzione.equals("xls")) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    return false;
                }

                @Override
                public String getDescription() {
                    return "File exel (*.xls)";
                }
            });

            int risultato = salvaFile.showSaveDialog(finestra);

            if (risultato == JFileChooser.APPROVE_OPTION) {

                try {
                    file = salvaFile.getSelectedFile();
                    File f = new File(file.getCanonicalPath() + ".xls");
                    creaFile(f);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(
                            finestra,
                            "Nessun file creato!",
                            "errore", JOptionPane.ERROR_MESSAGE);
                }

            }

        } else {
            JOptionPane.showMessageDialog(
                    finestra,
                    "Nessun tabella selezionata!",
                    "avviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static String getEstenzione(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    private void creaFile(File f) {
        Tabella tab = creaTabellaFile();
        if (tab != null) {
            try {
                FileExcel file = new FileExcel(f);
                file.creaFoglo("elenco");
                for (int i = 0; i < tab.colonne(); i++) {
                    file.dimensionaColonna(i, 6);
                }
                file.dimensionaColonna(0, 18);
                file.dimensionaColonna(1, 18);
                file.dimensionaColonna(2, 10);

                file.carattere(FileExcel.Carattere.ARIAL, FileExcel.Stile.NORMALE, 10, FileExcel.Colore.NERO);
                file.aggiungiCella("X  = vaccinato", 0, 2);
                file.aggiungiCella("OK = già vaccinato", 0, 3);
                file.aggiungiSempliceTabella(tab, 0, 5, FileExcel.Carattere.TIMES, 9);

                file.chiudi();
            } catch (WriteException ex) {
                String msg = "";
                if (ex.getMessage().compareTo("The maximum number of rows permitted on a worksheet been exceeded") == 0) {
                    msg = "nunero eccessivo di record da salvare";
                } else {
                    msg = ex.getMessage();
                }
                JOptionPane.showMessageDialog(
                        finestra,
                        "Nessun file creato:\n" + msg,
                        "errore", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(FinestraSituazioneVaccinazioniController.class.getName()).log(Level.SEVERE, null, ex);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(
                        finestra,
                        "Nessun file creato:\n" + ex.getMessage(),
                        "errore", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(FinestraSituazioneVaccinazioniController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(
                    finestra,
                    "Nessun file creato!",
                    "errore", JOptionPane.ERROR_MESSAGE);

        }
    }

    private Tabella creaTabellaFile() {
        if (finestra.tabella != null) {

            String[] colonne
                    = new String[]{"COGNOME", "NOME", "NASCITA", "Polio", "Tetano", "Men.", "Var.", "M.R.P.", "Ep. A", "Ep. B"};

            String[] righe = new String[valoriTabella.length];

            Tabella tabellaF = new Tabella("tabella", colonne, righe);
            for (int c = 0; c < colonne.length; c++) {
                for (int r = 0; r < valoriTabella.length; r++) {
                    if (valoriTabella[r][c] != null) {
                        tabellaF.set(c, r, valoriTabella[r][c]);
                    }
                }
            }
            return tabellaF;
        }
        return null;
    }

    public void pulsanteAggiorna(ActionEvent evt) {
        if (evt.getSource() instanceof javax.swing.JButton) {
            this.caricaTabella();
        }
    }

    public void pulsanteFile(ActionEvent evt) {
        if (evt.getSource() instanceof javax.swing.JButton) {
            this.salvaFileExel();
        }
    }

    public void caricaCompagnia(ItemEvent evt) {
        if (evt.getSource() instanceof javax.swing.JComboBox) {
            Object corso;
            if ((corso = finestra.selezionaCorso.getSelectedItem()) != null) {
                finestra.selezionaCompagnia.setModel(
                        new javax.swing.DefaultComboBoxModel(
                                militare.compagniePresenti(corso.toString())
                        )
                );
            }
        }
    }

}
