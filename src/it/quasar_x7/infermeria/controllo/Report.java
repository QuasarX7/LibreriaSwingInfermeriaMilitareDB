package it.quasar_x7.infermeria.controllo;

import it.quasar_x7.infermeria.DaseDati.BASE_DATI;
import it.quasar_x7.infermeria.DaseDati.DatiImpostazioni;
import it.quasar_x7.infermeria.DaseDati.DatiMilitare;
import it.quasar_x7.infermeria.DaseDati.DatiStoriaVaccinale;
import it.quasar_x7.infermeria.DaseDati.DatiVaccinazioni;
import it.quasar_x7.infermeria.DaseDati.BASE_DATI.MILITARE;
import it.quasar_x7.infermeria.DaseDati.BASE_DATI.STORIA_VACCINALE;
import it.quasar_x7.infermeria.DaseDati.BASE_DATI.VACCINAZIONI;
import it.quasar_x7.infermeria.vista.FinestraElencoSelezioneMilitari;
import it.quasar_x7.java.swing.finestra.Finestra;
import it.quasar_x7.java.swing.stampa.FinestraStampatiOrizzontali;
import it.quasar_x7.java.swing.stampa.FinestraStampatiVerticali;
import it.quasar_x7.java.swing.stampa.FinestraStampato;
import it.quasar_x7.java.swing.stampa.FinestraStampatoSemplice;
import it.quasar_x7.java.swing.stampa.Stampato;
import it.quasar_x7.java.swing.stampa.StampatoVerticale;
import it.quasar_x7.java.utile.DataOraria;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dr Domenico della Peruta
 * @version 1.0.0 ultima modifica 06/03/2016
 */
public class Report {
    
    public static void aggiungiReportAllegatoLibMilitare(FinestraStampato finestraStampato, Object[] militare) {
        final String font = Stampato.FONT_COURIER;
        DatiImpostazioni impostazioni = new DatiImpostazioni();
        finestraStampato.aggiungiTesto(
                riquadro("Riferimento al<br>LIBRETTO SANITARIO<br>Quadro C e D pag. 7 e 8",titolo(impostazioni)) + 
                "<br />" + "" + 
                dataLuogo() + "<br />" + 
                Report.incorporamento(font, militare) + 
                Stampato.testo(
                        "<br>VACCINAZIONI PRECEDENTI", 8, true, Stampato.ALL_SINISTRA, 10, 20, Stampato.NO_BORDO, 1
                ) + 
                Stampato.tabella(creaTabStoriaVaccinale(militare), font, 4, false, Stampato.ALL_CENTRO) + 
                Stampato.testo("<br>VACCINAZIONI", 8, true, Stampato.ALL_SINISTRA, 10, 20, Stampato.NO_BORDO, 1) +
                Stampato.tabella(creaTabVaccinazioni(militare), font, 4, false, Stampato.ALL_CENTRO) + 
                "<br />" + 
                "<br />" + 
                "<br />" + 
                Report.timbro(impostazioni)
        );
    }
    
    public static void aggiungiReportStralcioVaccinale(FinestraStampato finestraStampato, Object[] militare) {
        final String font = Stampato.FONT_COURIER;
        DatiImpostazioni impostazioni = new DatiImpostazioni();
        finestraStampato.aggiungiTesto(
                riquadro("Riferimento al<br>LIBRETTO SANITARIO<br>Quadro D pag. 8",titolo(impostazioni)) + 
                "<br />" + "" + 
                dataLuogo() + "<br />" + 
                nominativo(font,militare) + "<br />" + 
                Stampato.testo(
                        "<br>VACCINAZIONI PRECEDENTI", 8, true, Stampato.ALL_SINISTRA, 10, 20, Stampato.NO_BORDO, 1
                ) + 
                Stampato.tabella(creaTabStoriaVaccinale(militare), font, 4, false, Stampato.ALL_CENTRO) + 
                Stampato.testo("<br>VACCINAZIONI", 8, true, Stampato.ALL_SINISTRA, 10, 20, Stampato.NO_BORDO, 1) +
                Stampato.tabella(creaTabVaccinazioni(militare), font, 4, false, Stampato.ALL_CENTRO) + 
                "<br />" + 
                "<br />" + 
                "<br />" + 
                Report.timbroWeb(impostazioni)
        );
    }
    
    private static String titolo(DatiImpostazioni impostazioni){
        String titolo = "";
        titolo += Stampato.titolo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_INT_REGGIMENTO), 7);
        titolo += Stampato.titolo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_INT_UFFICIO), 6);
        titolo += Stampato.titolo(" ", 8);
        titolo += Stampato.titolo(" ", 8);
        return titolo;
    }
    
    private static String riquadro(String testo,String titolo){
        
        return Stampato.testo(
                new String[]{
                    titolo, 
                    Stampato.testo(
                            testo,
                            6, true, Stampato.ALL_SINISTRA, 10, 20, Stampato.BORDO, 2
                    )
                }, 
                Stampato.FONT_TIMES, 6, false, Stampato.ALL_CENTRO, new int[]{600, 150}
        );
    }
    
    private static String dataLuogo(){
        return Stampato.testo(
                "Capua, l\u00ec " + new DataOraria().stampaGiornoRidotto('/')
                , 6, false, Stampato.ALL_DESTRA
        );
    }
    
    private static String timbro(DatiImpostazioni impostazioni){
        return Stampato.testo(
                new String[]{
                    "", 
                    Stampato.testo("IL DIRIGENTE DEL SERVIZIO SANITARIO", 6, true, Stampato.ALL_CENTRO) + 
                    Stampato.testo(
                            impostazioni.valore("DSS") != null ? impostazioni.valore("DSS") : "",
                            6, true, Stampato.ALL_CENTRO) + ""
                }, 
                Stampato.FONT_TIMES, 6, true, Stampato.ALL_CENTRO, 300
        );
    }
    
    private static String timbroWeb(DatiImpostazioni impostazioni){
        return Stampato.testo(
                new String[]{
                    "", 
                    Stampato.testo("IL DIRIGENTE DEL SERVIZIO SANITARIO", 6, true, Stampato.ALL_CENTRO) + 
                    Stampato.testo(
                            impostazioni.valore("DSS") != null ? impostazioni.valore("DSS") : "",
                            6, true, Stampato.ALL_CENTRO) + 
                    Stampato.testo("ORIGINALE FIRMATO AGLI ATTI", 6, true, Stampato.ALL_CENTRO) + 
                    Stampato.testo("D.Lgs. 07-03-2005, n.82", 4, true, Stampato.ALL_CENTRO) +
                    Stampato.testo("Codice dell'amministrazione digitale", 4, false, Stampato.ALL_CENTRO) +
                    Stampato.testo("Pubblicato nella Gazz. Uff. 16 maggio 2005, n.112, S.O.", 4, false, Stampato.ALL_CENTRO) +
                    Stampato.testo("Capo IV - Trasmissione informatica dei documenti", 4, false, Stampato.ALL_CENTRO) +
                    Stampato.testo("Art.45. Valore giuridico della trasmissione", 4, false, Stampato.ALL_CENTRO) +
                    ""
                }, 
                Stampato.FONT_TIMES, 6, true, Stampato.ALL_CENTRO, 300
        );
    }
    
    private static String timbroMedico(DatiImpostazioni impostazioni, Object medico){
        return Stampato.testo(
                        new String[]{
                            "", 
                            Stampato.testo("UFFICIALE MEDICO", 6, true, Stampato.ALL_CENTRO) + 
                            Stampato.testo(
                                     medico != null ? (String)medico : "",
                                    6, true, Stampato.ALL_CENTRO) + ""
                        }, 
                        Stampato.FONT_TIMES, 6, true, Stampato.ALL_CENTRO, 300
                );
    }
    
    
    private static String nominativo(String font, Object[] militare){
        return Stampato.testo(
                    new String[][]{
                        new String[]{
                            "grado: ", militare[MILITARE.GRADO] != null ? (String)militare[MILITARE.GRADO] : "",
                            "Cp/RGT: ", (String)militare[MILITARE.COMPAGNIA]
                        }, 
                        new String[]{
                            "cognome: ", (String)militare[MILITARE.COGNOME], 
                            "nome: ", (String)militare[MILITARE.NOME], 
                            "nato il ",((DataOraria)militare[MILITARE.DATA_NASCITA]).stampaGiorno('/'),
                            "a ", (String)militare[MILITARE.LUOGO_NASCITA]
                        }
                    }, font, 6, false, 
                    Stampato.ALL_SINISTRA, 
                    new int[]{
                        40, 150, 30, 150, 40, 40, 10, 150
                    }
            );
    }
    
    private static String incorporamento(String font, Object[] militare){
        String testo = Stampato.testo(
                        "VISITA DI INCORPORAMENTO", 8, true, Stampato.ALL_SINISTRA, 10, 20, Stampato.NO_BORDO, 1
            ) + 
            nominativo(font,militare) + 
            Stampato.testo(
                    new String[]{
                        "anamnesi familiare:"
                    }, font, 6, false, Stampato.ALL_SINISTRA, 350) +
            Stampato.testo(
                    new String[]{
                        (String)militare[MILITARE.ANAMNESI_FAMILIARE]
                    }, font, 6, false, Stampato.ALL_SINISTRA, 350
            ) + 
            Stampato.testo("anamnesi patologiaca remota:", font, 6) + 
            Stampato.testo(
                    new String[]{
                        (String)militare[MILITARE.ANAMNESI_REMOTA]
                    }, font, 6, false, Stampato.ALL_SINISTRA, 350
            ) + 
            Stampato.testo("anamnesi patologiaca prossima:", font, 6) + 
            Stampato.testo(
                    new String[]{
                        (String)militare[MILITARE.ANAMNESI_PROSSIMA]
                    }, font, 6, false, Stampato.ALL_SINISTRA, 350
            ) + 
            Stampato.testo(
                    new String[][]{
                        new String[]{
                            "altezza: ", militare[MILITARE.ALTEZZA] + " cm",
                            "peso: ", militare[MILITARE.PESO] + " kg",
                            "torace: ", militare[MILITARE.TORACE] + " cm"
                        }, 
                        new String[]{
                            "visus OD: ", militare[MILITARE.VISUS_OD] + "/10", 
                            "corretto: ",
                            ((Long) militare[MILITARE.VISUS_OD_CORRETTO] > 0) 
                                    ? 
                                    militare[MILITARE.VISUS_OD_CORRETTO] + "/10" 
                                    :
                                    "//"
                        }, 
                        new String[]{
                            "visus OS: ", militare[MILITARE.VISUS_OS] + "/10", 
                            "corretto: ", ((Long) militare[MILITARE.VISUS_OS_CORRETTO] > 0) 
                                    ? 
                                    militare[MILITARE.VISUS_OS_CORRETTO] + "/10" 
                                    : 
                                    "//"
                        }, 
                        new String[]{
                            "pressione max: ", 
                            militare[MILITARE.PRESSIONE_MAX] + "",
                            "pressione min: ", 
                            militare[MILITARE.PRESSIONE_MIN] + "",
                            "frequenza: ", 
                            militare[MILITARE.FREQUENZA] + ""
                        }
                    }, font, 6, false, Stampato.ALL_SINISTRA, 
                    new int[]{45, 60, 45, 60, 45, 60}
            ) + 
            Stampato.testo("GML: ", font, 6) + 
            Stampato.testo(
                    new String[]{
                        militare[MILITARE.GML] != null 
                                ? 
                                (String)militare[MILITARE.GML]
                                : 
                                ""
                    }, font, 6, false, Stampato.ALL_SINISTRA, 350
            ) + 
            Stampato.testo("Data GML: ", font, 6) + 
            Stampato.testo(
                    new String[]{
                        militare[MILITARE.DATA_GML] != null ? ((DataOraria)militare[MILITARE.DATA_GML]).stampaGiorno('/') : ""
                    }, font, 6, false, Stampato.ALL_SINISTRA, 350
            );
        return testo;
    }
    
    public static void aggiungiReportGML(FinestraStampato finestraStampato, Object[] militare) {
        final String font = Stampato.FONT_COURIER;
        DatiImpostazioni impostazioni = new DatiImpostazioni();
        finestraStampato.aggiungiTesto(
                riquadro("Riferimento al<br>LIBRETTO SANITARIO<br>Quadro C pag. 7",titolo(impostazioni)) + "<br />" + "" + 
                dataLuogo() + "<br />" + 
                Report.incorporamento(font, militare) + 
                "<br />" + 
                "<br />" + 
                "<br />" + 
                Report.timbroMedico(impostazioni,militare[MILITARE.MEDICO])
        );
    }
    

    private static String[][] creaTabStoriaVaccinale(Object[] militare) {
        ArrayList<String[]> tabellaStoria = new ArrayList<String[]>();
        DatiStoriaVaccinale datiStoria = new DatiStoriaVaccinale();
        ArrayList<Object[]> vaccini = datiStoria.storiaVaccinale((String)militare[MILITARE.COGNOME], (String)militare[MILITARE.NOME], (DataOraria) militare[MILITARE.DATA_NASCITA]);
        if (vaccini != null) {
            tabellaStoria.add(new String[]{"<b>TIPO PROFILASSI</b>", "<b>ULTIMA VACCINAZIONE</b>", "<b>TIPO DOSE</b>", "<b>DATA VACCINAZIONE</b>"});
            for (Object[] vaccino : vaccini) {
                String[] riga = new String[4];
                DataOraria data = (DataOraria) vaccino[STORIA_VACCINALE.DATA_VACCINAZIONE];
                if (data != null) {
                    riga[3] = data.stampaGiorno('/');
                } else {
                    continue;
                }
                String profilassi = (String) vaccino[STORIA_VACCINALE.PROFILASSI];
                if (profilassi != null) {
                    riga[0] = profilassi;
                } else {
                    riga[0] = "?";
                }
                String docCivile = (String) vaccino[STORIA_VACCINALE.VACCINAZIONE_CIVILE];
                String docMilitare = (String) vaccino[STORIA_VACCINALE.VACCINAZIONE_MILITARE];
                riga[1] = "";
                if (docCivile != null && docMilitare != null) {
                    if (docCivile.compareTo("D") == 0 || docCivile.compareTo("R") == 0) {
                        riga[1] = "CIVILE";
                    } else if (docMilitare.compareTo("D") == 0 || docMilitare.compareTo("R") == 0) {
                        riga[1] = "MILITARE";
                    }
                }
                String tipo = (String) vaccino[STORIA_VACCINALE.DOSE];
                if (tipo != null) {
                    riga[2] = (String) tipo;
                } else {
                    riga[2] = "";
                }
                tabellaStoria.add(riga);
            }
        }
        return tabellaStoria.toArray(new String[tabellaStoria.size()][4]);
    }

    private static String[][] creaTabVaccinazioni(Object[] militare) {
        ArrayList<String[]> tabellaVaccini = tabellaVaccini = new ArrayList<String[]>();
        DatiVaccinazioni datiVaccini = new DatiVaccinazioni();
        ArrayList<Object[]> vaccini = datiVaccini.trovaVaccinazioni((String)militare[MILITARE.COGNOME], (String)militare[MILITARE.NOME], (DataOraria) militare[MILITARE.DATA_NASCITA]);
        if (vaccini != null) {
            tabellaVaccini.add(new String[]{"<b>TIPO PROFILASSI</b>", "<b>NOME VACCINO</b>", "<b>TIPO DOSE</b>", "<b>DATA VACCINAZIONE</b>","<b>INADEMPIENZA</b>"});
            for (Object[] vaccino : vaccini) {
                String[] riga = new String[5];
                riga[0] = (String) vaccino[VACCINAZIONI.TIPO_PROFILASSI];
                riga[1] = (String) vaccino[VACCINAZIONI.NOME_VACCINO];
                riga[2] = (String) vaccino[VACCINAZIONI.DOSE];
                DataOraria data = (DataOraria) vaccino[VACCINAZIONI.DATA_SEDUTA];
                if (data != null) {
                    riga[3] = data.stampaGiorno('/');
                }
                riga[4] = (String) vaccino[VACCINAZIONI.INADEMPIENZA];
                if(riga[4] == null)
                    riga[4] = "";
                    
                tabellaVaccini.add(riga);
            }
        }
        return tabellaVaccini.toArray(new String[tabellaVaccini.size()][5]);
    }

    /**
     * Metodo che implementa la finestra dello stampato della Storia Vaccinale.
     *
     * @param militare
     * @param dati
     * @param reparto
     * @param ufficio
     * @param sede
     * @param medico
     */
    public static void stampaStoriaVaccinale(Object[] militare, String reparto, String ufficio, String sede,String[][]dati, String medico) {
        final int DIM = 7;
        FinestraStampatoSemplice finestra = new FinestraStampatoSemplice();
        finestra.aggiungiTitolo(reparto, DIM + 2);
        finestra.aggiungiTitolo(ufficio, DIM + 1);
        finestra.aggiungiTesto("<hr>", 5, false, Stampato.ALL_CENTRO);
        finestra.aggiungiTesto(Risorse.Stampato.StoriaVaccinale.ANAMNESI_INDIVIDUALE, DIM + 2, false, Stampato.ALL_CENTRO);
        finestra.aggiungiTesto(Risorse.Stampato.StoriaVaccinale.DATI_INFETTIVOLOGICO_LOCALI, DIM, false, Stampato.ALL_CENTRO);
        finestra.aggiungiTesto(String.format("%s, l\u00ec %s", sede, new DataOraria().stampaGiorno('/')), 8, false, Stampato.ALL_DESTRA);
        finestra.aggiungiBlocchi(
                new String[]{
                    Risorse.Stampato.StoriaVaccinale.GRADO, (String)militare[BASE_DATI.MILITARE.GRADO],
                    Risorse.Stampato.StoriaVaccinale.COGNOME, (String)militare[BASE_DATI.MILITARE.COGNOME], 
                    Risorse.Stampato.StoriaVaccinale.NOME, (String)militare[BASE_DATI.MILITARE.NOME]
                }, 8, false, Stampato.ALL_SINISTRA, 
                new int[]{10, 60, 10, 100, 10, 100}
        );
        
        finestra.aggiungiBlocchi(
                new String[]{
                    Risorse.Stampato.StoriaVaccinale.DATA_NASCITA, ((DataOraria)militare[BASE_DATI.MILITARE.DATA_NASCITA]).stampaGiorno('/'), 
                    Risorse.Stampato.StoriaVaccinale.LUOGO_NASCITA, (String)militare[BASE_DATI.MILITARE.LUOGO_NASCITA]
                }, 8, false, Stampato.ALL_SINISTRA, 
                new int[]{60, 60, 60, 150}
        );
        finestra.aggiungiTesto("<hr>", 5, false, Stampato.ALL_CENTRO);
        
        String obbligo = Stampato.L;
        String superiori = Stampato.L;
        String universita = Stampato.L;
        
        String scuola = (String)militare[BASE_DATI.MILITARE.SCUOLA];
        
        if (scuola.equals(Risorse.Stampato.StoriaVaccinale.SUPERIORI)) {
            superiori = Stampato.X;
        }else if (scuola.equals(Risorse.Stampato.StoriaVaccinale.OBBLIGO)) {
            obbligo = Stampato.X;
        }else if (scuola.equals(Risorse.Stampato.StoriaVaccinale.UNIVERSITA)) {
            universita = Stampato.X;
        }
        finestra.aggiungiTesto(Stampato.SPAZIO + Risorse.Stampato.StoriaVaccinale.SCOLARITA, DIM+2, false, Stampato.ALL_SINISTRA);
        
        finestra.aggiungiBlocchi(
                new String[]{
                    //Risorse.Stampato.StoriaVaccinale.SCOLARITA, 
                    Risorse.Stampato.StoriaVaccinale.OBBLIGO, obbligo, 
                    Risorse.Stampato.StoriaVaccinale.SUPERIORI, superiori,
                    Risorse.Stampato.StoriaVaccinale.UNIVERSITA, universita
                }, DIM + 1, false, Stampato.ALL_SINISTRA, 
                new int[]{ 40, 20, 40, 20, 40, 20}
        );
        finestra.aggiungiTesto(Stampato.SPAZIO + Risorse.Stampato.StoriaVaccinale.STATO_IMMUNITARIO, DIM+2, false, Stampato.ALL_SINISTRA);
        
        int[] dimTabella = new int[]{60, 60, 60, 60, 60, 60, 60, 60};
        String[][] tabella = new String[dati.length+1][8];
        //titoli
        tabella[0][0] = "";//Stampato.SPAZIO + Risorse.Stampato.StoriaVaccinale.VACCINO;
        tabella[0][1] = Risorse.Stampato.StoriaVaccinale.PREGRESSA;
        tabella[0][2] = Risorse.Stampato.StoriaVaccinale.PREGRESSA_DOC;
        tabella[0][3] = Risorse.Stampato.StoriaVaccinale.ULTIMA_CIVILE;
        tabella[0][4] = Risorse.Stampato.StoriaVaccinale.ULTIMA_MILITARE;
        tabella[0][5] = Risorse.Stampato.StoriaVaccinale.DOSE;
        tabella[0][6] = Risorse.Stampato.StoriaVaccinale.TIPO_VACC;
        tabella[0][7] = Risorse.Stampato.StoriaVaccinale.DATA_VACC;
        int i=1;
        for(String[] riga:dati){
            tabella[i++] = riga;
        }
        
        finestra.aggiungiTabella(tabella, "ARIAL", 6, false, Stampato.ALL_SINISTRA, dimTabella, true);
        
        finestra.aggiungiTesto(Risorse.Stampato.StoriaVaccinale.FIRMA_INTERESSATO, 8, true, Stampato.ALL_DESTRA);
        finestra.aggiungiTesto("<br><br><br><br>", 8, true, Stampato.ALL_CENTRO);
        finestra.aggiungiTabella(
                new String[][]{
                    {"", Risorse.Stampato.StoriaVaccinale.FIRMA_MEDICO}, 
                    {"", medico != null ? medico : ""}
                }, "ARIAL", DIM+1, true, Stampato.ALL_CENTRO, 
                new int[]{250, 250}, false
        );
        Finestra.creaFinestra(finestra);
    }

    /**
     * Metodo che implementa la finestra di stampa della seduta vaccinale.
     *
     * @param militare
     * @param dati
     * @param reparto
     * @param ufficio
     * @param sede
     * @param data
     */
    public static void stampaVaccinazioni(Object[] militare, Object[] dati, String reparto, String ufficio, String sede, String data, String medico) {
        FinestraStampatoSemplice finestra = new FinestraStampatoSemplice();
        final int DIM = 7;
        finestra.aggiungiTitolo(reparto, DIM + 2);
        finestra.aggiungiTitolo(ufficio, DIM + 1);
        finestra.aggiungiTitolo("", DIM);
        finestra.aggiungiTesto("<hr width=100% size=1 color=#555555 >");
        finestra.aggiungiTesto("ANAMNESI INDIVIDUALE", DIM + 2, false, StampatoVerticale.ALL_CENTRO);
        finestra.aggiungiTesto("DATI INFETTIVOLOGICO-VACCINALI", DIM, false, StampatoVerticale.ALL_CENTRO);
        finestra.aggiungiTitolo("", DIM);
        String luogoData =sede + " l\u00ec, " + data;
        finestra.aggiungiTesto(luogoData, DIM, false, StampatoVerticale.ALL_DESTRA);
        finestra.aggiungiBlocchi(
                new String[]{
                    Risorse.Stampato.StoriaVaccinale.GRADO, (String)militare[BASE_DATI.MILITARE.GRADO], 
                    Risorse.Stampato.StoriaVaccinale.COGNOME, (String)militare[BASE_DATI.MILITARE.COGNOME],
                    Risorse.Stampato.StoriaVaccinale.NOME, (String)militare[BASE_DATI.MILITARE.NOME]
                },
                DIM, false, Stampato.ALL_SINISTRA, 
                new int[]{10, 60, 10, 100, 10, 100}
        );
        finestra.aggiungiBlocchi(
                new String[]{
                    Risorse.Stampato.StoriaVaccinale.DATA_NASCITA, ((DataOraria)militare[BASE_DATI.MILITARE.DATA_NASCITA]).stampaGiorno('/'), 
                    Risorse.Stampato.StoriaVaccinale.LUOGO_NASCITA,  (String)militare[BASE_DATI.MILITARE.LUOGO_NASCITA]
                }, DIM, false, Stampato.ALL_SINISTRA, 
                new int[]{60, 60, 60, 150}
        );
        // reazioni ai vaccini
        finestra.aggiungiTesto("3. REAZIONI A PRECEDENTI VACCINI", DIM + 2, false, StampatoVerticale.ALL_SINISTRA);
        String[][] titoloReazioni = new String[][]{{"TIPO VACCINO", "LOCALI GRAVI", "GENERALI LIEVI", "GENERALI GRAVI", "DATA"}};
        String[][] sottotitoloReazioni = new String[][]{{"(nome commerciale del vaccino)", "(necrotiche)", "(febbre<40\u00b0C, malessere, cefalea, vomito, diarrea, eruzione cutanea)", "allergiche o neurologiche o altro tipo", ""}};
        int[] dimCelle = new int[]{120, 60, 60, 60, 60};
        finestra.aggiungiTabella(titoloReazioni, "ARIAL", DIM - 1, false, Stampato.ALL_CENTRO, dimCelle, false);
        finestra.aggiungiTabella(sottotitoloReazioni, "ARIAL", DIM - 3, false, Stampato.ALL_CENTRO, dimCelle, false);
        String[][] reazioni = new String[][]{{"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}, {"", "", "", "", ""}};
        if (dati != null) {
            if (dati[0] != null) {
                if (dati[0] instanceof Object[]) {
                    int i = 0;
                    int k = 0;
                    for (Object cella : (Object[]) dati[0]) {
                        reazioni[k][i++] = cella != null ? (cella.toString().length() > 0 && !cella.toString().equals("**/**/****") ? cella.toString() : "/////") : "///";
                        if (i > 4) {
                            i = 0;
                            k++;
                        }
                        if (k > 3) {
                            break;
                        }
                    }
                }
            }
        }
        finestra.aggiungiTabella(reazioni, "ARIAL", DIM - 1, false, Stampato.ALL_CENTRO, dimCelle, true);
        // allergie
        finestra.aggiungiTesto("4. ALLERGIE sospette (S) o documentate (D)", DIM + 2, false, StampatoVerticale.ALL_SINISTRA);
        String[][] campiAllergia = new String[][]{{"uova/carne/piume-POLLO", casella("//"), "uova/carne/piume-ANATRA", casella("//"), "carne BOVINA/gelatina", casella("//"), "formaldeide", casella("//")}, {"ANTIBIOTICI:  neomicina", casella("//"), "streptomicina", casella("//"), "kanamicina", casella("//"), "", ""}, {"polimixin B", casella("//"), "composti mercuriali", casella("//"), "altro", casella("//"), "", ""}};
        if (dati != null) {
            if (dati[1] != null) {
                if (dati[1] instanceof Object[]) {
                    Object[] allergie = (Object[]) dati[1];
                    if (allergie[0] != null) {
                        if (allergie[0].toString().length() > 0) {
                            campiAllergia[0][1] = casella(allergie[0].toString());
                        }
                    }
                    if (allergie[1] != null) {
                        if (allergie[1].toString().length() > 0) {
                            campiAllergia[0][3] = casella(allergie[1].toString());
                        }
                    }
                    if (allergie[2] != null) {
                        if (allergie[2].toString().length() > 0) {
                            campiAllergia[0][5] = casella(allergie[2].toString());
                        }
                    }
                    if (allergie[3] != null) {
                        if (allergie[3].toString().length() > 0) {
                            campiAllergia[0][7] = casella(allergie[3].toString());
                        }
                    }
                    if (allergie[4] != null) {
                        if (allergie[4].toString().length() > 0) {
                            campiAllergia[1][1] = casella(allergie[4].toString());
                        }
                    }
                    if (allergie[5] != null) {
                        if (allergie[5].toString().length() > 0) {
                            campiAllergia[1][3] = casella(allergie[5].toString());
                        }
                    }
                    if (allergie[6] != null) {
                        if (allergie[6].toString().length() > 0) {
                            campiAllergia[1][5] = casella(allergie[6].toString());
                        }
                    }
                    if (allergie[7] != null) {
                        if (allergie[7].toString().length() > 0) {
                            campiAllergia[2][1] = casella(allergie[7].toString());
                        }
                    }
                    if (allergie[8] != null) {
                        if (allergie[8].toString().length() > 0) {
                            campiAllergia[2][3] = casella(allergie[8].toString());
                        }
                    }
                    if (allergie[9] != null) {
                        if (allergie[9].toString().length() > 0) {
                            campiAllergia[2][5] = casella(allergie[9].toString());
                        }
                    }
                }
            }
        }
        finestra.aggiungiTabella(campiAllergia, "ARIAL", DIM - 2, false, Stampato.ALL_DESTRA, new int[]{100, 40, 100, 40, 100, 40, 100, 40}, false);
        // anamnesi
        finestra.aggiungiTesto("5. CONVIVENTI/CONTATTI con (barra con X)", DIM + 2, false, StampatoVerticale.ALL_SINISTRA);
        String[][] campiConviventi = new String[][]{{"immunodepessioni gravi", casella("//"), "tumori solidi del sangue", casella("//"), "gravidanze in corso", casella("//"), "", ""}};
        if (dati != null) {
            if (dati[2] != null) {
                if (dati[2] instanceof Object[]) {
                    Object[] conviventi = (Object[]) dati[2];
                    if (conviventi[0] != null) {
                        if (conviventi[0].toString().length() > 0) {
                            campiConviventi[0][1] = casella(conviventi[0].toString());
                        }
                    }
                    if (conviventi[1] != null) {
                        if (conviventi[1].toString().length() > 0) {
                            campiConviventi[0][3] = casella(conviventi[1].toString());
                        }
                    }
                    if (conviventi[2] != null) {
                        if (conviventi[2].toString().length() > 0) {
                            campiConviventi[0][5] = casella(conviventi[2].toString());
                        }
                    }
                }
            }
        }
        finestra.aggiungiTabella(campiConviventi, "ARIAL", DIM - 2, false, Stampato.ALL_DESTRA, new int[]{100, 40, 100, 40, 100, 40, 100, 40}, false);
        // anamnesi recenti
        finestra.aggiungiTesto("6. ANAMNESI RECENTI", DIM + 2, false, StampatoVerticale.ALL_SINISTRA);
        String[][] campoAnamnesiRec1 = new String[][]{{"febbre in atto > 38\u00b0C", casella("//"), "disturbi vie aeree (tosse, mal di gola, catarro)", casella("//"), "diarrea in atto", casella("//"), "", ""}};
        String[][] campoAnamnesiRec2 = new String[][]{{"terapie recenti (H72) in corso (antibiotici, aspirina e fans, cortisonici, antimalarici)", casella("//"), "", ""}, {"emotrasfusioni recenti (6 mesi) o somministrazione immunoglobuline", casella("//"), "", ""}};
        if (dati != null) {
            if (dati[3] != null) {
                if (dati[3] instanceof Object[]) {
                    Object[] anamnesi = (Object[]) dati[3];
                    if (anamnesi[0] != null) {
                        if (anamnesi[0].toString().length() > 0) {
                            campoAnamnesiRec1[0][1] = casella(anamnesi[0].toString());
                        }
                    }
                    if (anamnesi[1] != null) {
                        if (anamnesi[1].toString().length() > 0) {
                            campoAnamnesiRec1[0][3] = casella(anamnesi[1].toString());
                        }
                    }
                    if (anamnesi[2] != null) {
                        if (anamnesi[2].toString().length() > 0) {
                            campoAnamnesiRec1[0][5] = casella(anamnesi[2].toString());
                        }
                    }
                    if (anamnesi[3] != null) {
                        if (anamnesi[3].toString().length() > 0) {
                            campoAnamnesiRec2[0][1] = casella(anamnesi[3].toString());
                        }
                    }
                    if (anamnesi[4] != null) {
                        if (anamnesi[4].toString().length() > 0) {
                            campoAnamnesiRec2[1][1] = casella(anamnesi[4].toString());
                        }
                    }
                }
            }
        }
        finestra.aggiungiTabella(campoAnamnesiRec1, "ARIAL", DIM - 2, false, Stampato.ALL_DESTRA, new int[]{100, 40, 250, 40, 100, 40, 100, 40}, false);
        finestra.aggiungiTabella(campoAnamnesiRec2, "ARIAL", DIM - 2, false, Stampato.ALL_SINISTRA, new int[]{500, 40, 300, 40}, false);
        // anamnesi ginecologica
        finestra.aggiungiTesto("7. ANAMNESI GINECOLOGICA", DIM + 2, false, StampatoVerticale.ALL_SINISTRA);
        String[][] campoAnamnesiGinecologica = new String[][]{{"<b>periodicit\u00e0 mestruale</b>", "regolare", casella("//"), "irregolare", casella("//"), "data ultima mestruazione", casella("__/__/____")}, {"<b>stato gravido</b>", "non incorso", casella("//"), "incorso", casella("//"), "non noto", casella("//")}, {"<b>test di gravidanza pre-vaccinale</b>", "positivo", casella("//"), "negativo", casella("//"), "data esecuzione del test", casella("__/__/____")}};
        if (dati != null) {
            if (dati[4] != null) {
                if (dati[4] instanceof Object[]) {
                    Object[] ginecologica = (Object[]) dati[4];
                    if (ginecologica[0] != null) {
                        if (ginecologica[0].toString().length() > 0) {
                            campoAnamnesiGinecologica[0][2] = casella(ginecologica[0].toString());
                        }
                    }
                    if (ginecologica[1] != null) {
                        if (ginecologica[1].toString().length() > 0) {
                            campoAnamnesiGinecologica[0][4] = casella(ginecologica[1].toString());
                        }
                    }
                    if (ginecologica[2] != null) {
                        if (ginecologica[2].toString().length() > 0) {
                            campoAnamnesiGinecologica[0][6] = casella(ginecologica[2].toString());
                        }
                    }
                    if (ginecologica[3] != null) {
                        if (ginecologica[3].toString().length() > 0) {
                            campoAnamnesiGinecologica[1][2] = casella(ginecologica[3].toString());
                        }
                    }
                    if (ginecologica[4] != null) {
                        if (ginecologica[4].toString().length() > 0) {
                            campoAnamnesiGinecologica[1][4] = casella(ginecologica[4].toString());
                        }
                    }
                    if (ginecologica[5] != null) {
                        if (ginecologica[5].toString().length() > 0) {
                            campoAnamnesiGinecologica[1][6] = casella(ginecologica[5].toString());
                        }
                    }
                    if (ginecologica[6] != null) {
                        if (ginecologica[6].toString().length() > 0) {
                            campoAnamnesiGinecologica[2][2] = casella(ginecologica[6].toString());
                        }
                    }
                    if (ginecologica[7] != null) {
                        if (ginecologica[7].toString().length() > 0) {
                            campoAnamnesiGinecologica[2][4] = casella(ginecologica[7].toString());
                        }
                    }
                    if (ginecologica[8] != null) {
                        if (ginecologica[8].toString().length() > 0) {
                            campoAnamnesiGinecologica[2][6] = casella(ginecologica[8].toString());
                        }
                    }
                }
            }
        }
        finestra.aggiungiTabella(campoAnamnesiGinecologica, "ARIAL", DIM - 2, false, Stampato.ALL_SINISTRA, new int[]{120, 50, 30, 50, 30, 50, 40}, false);
        // firma
        finestra.aggiungiTesto("<br><br>firma dell'interessato/a___________________________________", DIM + 2, true, StampatoVerticale.ALL_DESTRA);
        // vaccinazioni
        finestra.aggiungiTesto("<br><br>PRATICHE IMMUNOPROFILATTICHE EFFETTUATE NEL CORSO DELLA SEDUTA", DIM + 2, false, StampatoVerticale.ALL_CENTRO);
        finestra.aggiungiTabella(new String[][]{{"", "", "", "", ""}, {"PROTOCOLLO OPERATIVO N\u00b0", casella("1 a"), "", "MODULO INTEGRATIVO", casella("//")}, {"", "", "", "", ""}}, "ARIAL", DIM - 2, false, Stampato.ALL_DESTRA, new int[]{200, 30, 200, 200, 30}, false);
        String[] intestazioneVacc = new String[]{"<b>PROFILASSI</b>", "<b>DOSE</b>", "<b>SOMM</b>.", "<b>NOME VACC.</b>", "<b>DITTA</b>", "<b>LOTTO</b>", "<b>SERIE</b>", "<b>SCADENZA</b>", "<b>INADEMPIENZA</b>"};
        int righe = 1;
        String[][] campiVaccinazioni = null;
        if (dati != null) {
            if (dati[5] != null) {
                if (dati[5] instanceof Object[]) {
                    Object[] vaccini = (Object[]) dati[5];
                    righe += vaccini.length;
                    campiVaccinazioni = new String[righe][9];
                    campiVaccinazioni[0] = intestazioneVacc;
                    int riga = 1;
                    for (Object vaccino : vaccini) {
                        Object[] datiVaccino = (Object[]) vaccino;
                        campiVaccinazioni[riga++] = new String[]{
                            (String)datiVaccino[0], 
                            (String)datiVaccino[1], 
                            (String)datiVaccino[2], 
                            (String)datiVaccino[3], 
                            (String)datiVaccino[4], 
                            (String)datiVaccino[5], 
                            (String)datiVaccino[6], 
                            (String)datiVaccino[7], 
                            (String)datiVaccino[8]
                        };
                    }
                }
            }
        }
        if(campiVaccinazioni == null){
            // stampa solo l'intestazione delle vaccinazioni
            campiVaccinazioni = new String[righe][9];
            campiVaccinazioni[0] = intestazioneVacc;
        } 
        finestra.aggiungiTabella(campiVaccinazioni, "ARIAL", DIM - 2, false, Stampato.ALL_SINISTRA, new int[]{70, 30, 30, 50, 50, 50, 10, 50, 70}, true);
        
        // firma
        finestra.aggiungiTabella(new String[][]{{"", ""}, {"", "Sanitario Vaccinatore"}, {"", medico}}, "TIMES", DIM + 1, true, Stampato.ALL_CENTRO, new int[]{250, 250}, false);
        Finestra.creaFinestra(finestra);
    }

    private static String casella(String contenuto) {
        return Stampato.testo(contenuto, 7, false, Stampato.ALL_CENTRO, 6, 12, Stampato.BORDO, 1, "gray");
    }

    
    
    /**
     * Crea una finestra per la stampa delle visite mediche
     * 
     * @param listaVisite
     * @param medico
     * @param datiMilitare 
     */
    public static void stampaVisiteMediche(ArrayList<Object[]> listaVisite, String medico, DatiMilitare datiMilitare) {
        if (listaVisite != null) {
            final int numero_visite = listaVisite.size();
            final int numero_pagina = 10;
            final String CARATTERE = "Courier New";
            final int DIM_CAR = 5;
            final int ALTEZZA = 3;
            final int LUNGHEZZA_S = 10;
            final int LUNGHEZZA_M = 40;
            final int LUNGHEZZA_G = 75;
            FinestraStampatiOrizzontali f = new FinestraStampatiOrizzontali();
            int inizio = 0;
            int fine = numero_pagina;
            if (numero_pagina > numero_visite) {
                fine = numero_visite;
            }
            do {
                // INTESTAZIONE PAGINA
                DatiImpostazioni impostazioni = new DatiImpostazioni();
                String stampato = "";
                stampato += Stampato.titolo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_INT_REGGIMENTO), 7);
                stampato += Stampato.titolo(impostazioni.valore(FinestraImpostazioneStampaController.CHIAVE_INT_UFFICIO), 6);
                stampato += Stampato.titolo("", 4);
                stampato += Stampato.titolo(listaVisite.get(0)[0] + " " + ((DataOraria) listaVisite.get(0)[1]).stampaGiornoCompleto(), 12);
                String[] dati = new String[]{Stampato.testo("ORE", DIM_CAR, false, Stampato.ALL_CENTRO, ALTEZZA, LUNGHEZZA_S, Stampato.BORDO, 1), Stampato.testo("NOMINATIVO", DIM_CAR, false, Stampato.ALL_CENTRO, ALTEZZA, LUNGHEZZA_G, Stampato.BORDO, 1), Stampato.testo("ANAMNESI", DIM_CAR, false, Stampato.ALL_CENTRO, ALTEZZA, LUNGHEZZA_G, Stampato.BORDO, 1), Stampato.testo("DATI CLINICI", DIM_CAR, false, Stampato.ALL_CENTRO, ALTEZZA, LUNGHEZZA_M, Stampato.BORDO, 1), Stampato.testo("ESAME OBIETTIVO", DIM_CAR, false, Stampato.ALL_CENTRO, ALTEZZA, LUNGHEZZA_G, Stampato.BORDO, 1), Stampato.testo("DIAGNOSI", DIM_CAR, false, Stampato.ALL_CENTRO, ALTEZZA, LUNGHEZZA_G, Stampato.BORDO, 1), Stampato.testo("TERTAPIA", DIM_CAR, false, Stampato.ALL_CENTRO, ALTEZZA, LUNGHEZZA_G, Stampato.BORDO, 1), Stampato.testo("PML", DIM_CAR, false, Stampato.ALL_CENTRO, ALTEZZA, LUNGHEZZA_M, Stampato.BORDO, 1)};
                stampato += Stampato.testo(dati, CARATTERE, DIM_CAR, false, Stampato.ALL_GIUSTIFICATO, 20);
                // TABELLA PAGINA
                for (Object[] visita : listaVisite.subList(inizio, fine)) {
                    Object[] militare = datiMilitare.trovaMilitare((String) visita[2], (String) visita[3], (DataOraria) visita[4]);
                    String nominativo = militare[4] + " " + visita[2] + " " + visita[3] + " " + visita[4] + " (" + militare[6] + ")";
                    String note = "";
                    if ((Boolean) visita[12]) {
                        note += " - DLT - ";
                    }
                    if ((Boolean) visita[13]) {
                        note += " - ricovero - ";
                    }
                    note += " " + visita[10] + " ";
                    if (visita[15] != null) {
                        note += " (" + visita[15] + ")";
                    }
                    dati = new String[]{Stampato.testo(((DataOraria) visita[1]).stampaOra(), DIM_CAR, false, Stampato.ALL_SINISTRA, ALTEZZA, LUNGHEZZA_S, Stampato.NO_BORDO, 1), Stampato.testo(nominativo, DIM_CAR, false, Stampato.ALL_SINISTRA, ALTEZZA, LUNGHEZZA_G, Stampato.NO_BORDO, 1), Stampato.testo(visita[5].toString(), DIM_CAR, false, Stampato.ALL_SINISTRA, ALTEZZA, LUNGHEZZA_G, Stampato.NO_BORDO, 1), Stampato.testo(visita[6].toString(), DIM_CAR, false, Stampato.ALL_SINISTRA, ALTEZZA, LUNGHEZZA_M, Stampato.NO_BORDO, 1), Stampato.testo(visita[7].toString(), DIM_CAR, false, Stampato.ALL_SINISTRA, ALTEZZA, LUNGHEZZA_G, Stampato.NO_BORDO, 1), Stampato.testo(visita[8].toString(), DIM_CAR, false, Stampato.ALL_SINISTRA, ALTEZZA, LUNGHEZZA_G, Stampato.NO_BORDO, 1), Stampato.testo(visita[9].toString(), DIM_CAR, false, Stampato.ALL_SINISTRA, ALTEZZA, LUNGHEZZA_G, Stampato.NO_BORDO, 1), Stampato.testo(visita[11].toString(), DIM_CAR, false, Stampato.ALL_SINISTRA, ALTEZZA, LUNGHEZZA_M, Stampato.NO_BORDO, 1)};
                    stampato += Stampato.testo(dati, CARATTERE, DIM_CAR, false, Stampato.ALL_GIUSTIFICATO, 20);
                }
                stampato += Stampato.titolo("", 10);
                // TIMBRO
                String timbro = "<b><div>UFFICALE  MEDICO</div><div>" + medico + "</div></b>";
                dati = new String[]{Stampato.testo("", DIM_CAR, false, Stampato.ALL_SINISTRA, ALTEZZA, 150, Stampato.NO_BORDO, 1), Stampato.testo("", DIM_CAR, false, Stampato.ALL_SINISTRA, ALTEZZA, 150, Stampato.NO_BORDO, 1), Stampato.testo(timbro, DIM_CAR + 2, false, Stampato.ALL_CENTRO, ALTEZZA, 150, Stampato.NO_BORDO, 1)};
                stampato += Stampato.testo(dati, CARATTERE, DIM_CAR + 2, false, Stampato.ALL_GIUSTIFICATO, 20);
                f.aggiungiTesto(stampato);
                //AGGIORNAMENTO
                if (fine >= numero_visite) {
                    break;
                }
                inizio = fine;
                if (fine + numero_pagina <= numero_visite) {
                    fine += numero_pagina;
                } else {
                    fine = numero_visite;
                }
            } while (true);
            f.setVisible(true);
        }
    }

    /**
     * Crea una finestra di stampa degli allegati al libbretto militare per cpmpagnia.
     * 
     * @param finestra
     * @param datiMilitare 
     */
    public static void creaFinestraStampaReportAllegatoLibMilitare(Component finestra, DatiMilitare datiMilitare) {
        FinestraStampatiVerticali finestraStampato = new FinestraStampatiVerticali();
        
        String corso = (String) JOptionPane.showInputDialog(
            finestra,
            "seleziona corso ", "corso",
            JOptionPane.QUESTION_MESSAGE, null,
            datiMilitare.corsiPresenti(),
            "");
        if(corso == null)return;
        String cp = (String) JOptionPane.showInputDialog(
            finestra,
            "seleziona la compagnia ", "compagnia",
            JOptionPane.QUESTION_MESSAGE, null,
            datiMilitare.compagniePresenti(corso),
            "");
        if(cp == null)return;
        ArrayList<Object[]> record = datiMilitare.tuttaLaCompagnia(cp, corso);
        if(record != null)
            for (Object[] militare : record) {
                Report.aggiungiReportAllegatoLibMilitare(finestraStampato, militare);
            }
        Finestra.spegniAltreFinestre(finestraStampato);
    }

    /**
     * Crea due finestre, una per selezionare i militari di un corso, l'altra per
     * stampare i relativi allegati ai libbretti militari.
     * 
     * @param finestra
     * @param datiMilitare 
     */
    public static void creaFinestraStampaReportAllegatoLibCorso(Component finestra, DatiMilitare datiMilitare) {
        String corso = (String) JOptionPane.showInputDialog(
            finestra,
            "seleziona corso ", "corso",
            JOptionPane.QUESTION_MESSAGE, null,
            datiMilitare.corsiPresenti(),
            ""
        );
        Finestra.spegniAltreFinestre(new FinestraElencoSelezioneMilitari(corso));
    }

    /**
     * Crea una finestra di stampa di un solo allegato al libretto militare
     * 
     * @param finestra
     * @param datiMilitare 
     */
    public static void creaFinestraStampaReportAllegatoLibSingolo(Component finestra, DatiMilitare datiMilitare){
        creaFinestraStampaReportAllegatoLibSingolo(finestra,datiMilitare,false);
    }
    
    /**
     * Crea una finestra di stampa di uno stralcio vaccinale.
     * 
     * @param finestra
     * @param datiMilitare 
     */
    public static void creaFinestraStampaReportStralcioVaccinale(Component finestra, DatiMilitare datiMilitare){
        creaFinestraStampaReportAllegatoLibSingolo(finestra,datiMilitare,true);
    }
    
    /**
     * Crea una finestra di stampa di un solo allegato al libretto militare oppure lo stralcio vaccinale.
     * 
     * @param finestra
     * @param datiMilitare 
     * @param stralcio true se solo vaccinazioni
     */
    private static void creaFinestraStampaReportAllegatoLibSingolo(Component finestra, DatiMilitare datiMilitare,boolean stralcio) {
        FinestraStampatiVerticali finestraStampato = new FinestraStampatiVerticali();
        String corso = (String) JOptionPane.showInputDialog(
            finestra,
            "seleziona corso ", "corso",
            JOptionPane.QUESTION_MESSAGE, null,
            datiMilitare.corsiPresenti(),
            "");
        if(corso == null)return;
        String cognome = JOptionPane.showInputDialog("inserisci cognome");
        if (cognome != null) {
            ArrayList<Object[]> listaCognomi =
                    datiMilitare.trovaMilitare(cognome, corso);
            Object[] militare=null;
            if (listaCognomi != null) {

                if (listaCognomi.size() == 1) { // se esiste un solo cognome
                    militare = listaCognomi.get(0);

                } else if (listaCognomi.size() > 1) { //se esistono più cognomi uguali

                    String[] nomi = new String[listaCognomi.size()];
                    int i = 0;//cerca i nomi dei militari con lo stesso cognome
                    for (Object[] x : listaCognomi) {
                        nomi[i++] = (String) x[1] + "  ("
                                + ((DataOraria) x[2]).stampaGiorno() + ")";
                    }

                    //seleziona nome
                    String nome = (String) JOptionPane.showInputDialog(
                            finestra,
                            "esistono più militari con lo stesso cognome,\n"
                            + "seleziona nome", "stesso cognome",
                            JOptionPane.QUESTION_MESSAGE, null, nomi, "");

                    i = 0;//definisci l'indice del record
                    for (Object[] x : listaCognomi) {
                        if (nome.compareTo((String) x[1] + "  ("
                                + ((DataOraria) x[2]).stampaGiorno() + ")") == 0) {
                            break;
                        }
                        i++;
                    }
                    militare = listaCognomi.get(i);

                }
            }else{
                return;
            }
            if(!stralcio)
                Report.aggiungiReportAllegatoLibMilitare(finestraStampato, militare);
            else
                Report.aggiungiReportStralcioVaccinale(finestraStampato, militare);
            Finestra.spegniAltreFinestre(finestraStampato);
        }
    }
    
}
