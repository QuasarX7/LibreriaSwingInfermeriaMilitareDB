package it.quasar_x7.java.swing.stampa;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * Classe astratta che implementa un pannello swing (JPanel) stampabile, e numerosi metodi 
 * che permettoni gi generare un report di stampa in modalita HTML.
 * 
 * @author Dr Domenico della Peruta
 * @version 2.0.0 ultima modifica 10/04/2016
 */
public abstract class Stampato extends JPanel implements Printable {
    
    public static final int ALL_CENTRO          = 101;
    public static final int ALL_DESTRA          = 102;
    public static final int ALL_GIUSTIFICATO    = 104;
    public static final int ALL_SINISTRA        = 103;
    public static final int BORDO               = 202;
    public static final int DOPPIO_BORDO        = 203;
    public static final int NO_BORDO            = 201;
    public static final int TRATTEGGIATO        = 204;
    public static final String X                = " \u22A0 ";
    public static final String L                = " \u29E0 ";
    
    public static final String FONT_TIMES        = "TIMES";
    public static final String FONT_HELVETICA    = "HELVETICA";
    public static final String FONT_COURIER      = "COURIER";
    public static final String TAB               = "&#9;";
    public static final String SPAZIO            = "&#160;";

    
    
    
    
    public void aggiungiBlocchi(String[] blocchi, String tipo_carattere, int dim_carattere, boolean grossetto, int allineamento, int lunghezza_bocchi) {
        String stile =  Stampato.impostaFont(dim_carattere, tipo_carattere);
        stile += Stampato.impostaGrossetto(grossetto);
        stile += Stampato.impostaAlliniamento(allineamento);
        stile += " width: " + lunghezza_bocchi + " px ;";
        String blocco = "<table><tr>";
        for (String _testo : blocchi) {
            blocco += "<td style=\"" + stile + "\" >" + _testo + "</td>";
        }
        blocco += "</tr></table>";
        this.aggiungiTesto(blocco);
    }

    public void aggiungiBlocchi(Object[] blocchi, String tipo_carattere, int dim_carattere, boolean grossetto, int allineamento, int lunghezza_bocchi) {
        String stile =  Stampato.impostaFont(dim_carattere, tipo_carattere);
        stile += Stampato.impostaGrossetto(grossetto);
        stile += Stampato.impostaAlliniamento(allineamento);
        stile += " width: " + lunghezza_bocchi + " px ;";
        String blocco = "<table><tr>";
        for (Object _testo : blocchi) {
            blocco += "<td style=\"" + stile + "\" >" + (_testo != null ?_testo.toString(): "" )+ "</td>";
        }
        blocco += "</tr></table>";
        this.aggiungiTesto(blocco);
    }
    
    void aggiungiBlocchi(Object[] blocchi, String tipo_carattere, int dim_carattere, boolean grossetto, int allineamento, int[] lunghezza_bocchi) {
        String stile =  Stampato.impostaFont(dim_carattere, tipo_carattere);
        stile += Stampato.impostaGrossetto(grossetto);
        stile += Stampato.impostaAlliniamento(allineamento);
        String blocco = "<table><tr>";
        int i=0;
        for (Object _testo : blocchi) {
            blocco += "<td style=\"" + stile + "\" width=\""+ (i < lunghezza_bocchi.length ? lunghezza_bocchi[i++] : lunghezza_bocchi[i-1])+"px\" >" + (_testo != null ?_testo.toString(): "" )+ "</td>";
        } 
        blocco += "</tr></table>";
        this.aggiungiTesto(blocco);
    }
    
    
    public void aggiungiTabella(Object[][] blocchi, String tipo_carattere, int dim_carattere, boolean grossetto, int allineamento, int lunghezza_bocchi) {
        String stile =  Stampato.impostaFont(dim_carattere, tipo_carattere);
        stile += Stampato.impostaGrossetto(grossetto);
        stile += Stampato.impostaAlliniamento(allineamento);
        
        
        boolean titolo = true;
        String tabella = "<table>";
        for(Object[] riga : blocchi) {
            if(riga != null){
                tabella +="<tr>";
                for (Object cella : riga){
                    tabella += "<td width=\""+lunghezza_bocchi+"px\" style=\"" + stile + "\" >"+ (titolo ? "<b>":"") + (cella != null ?cella.toString(): "" )+ (titolo ? "</b>":"") + "</td>";
                    
                }
                tabella += "</tr>";
                titolo = false;
            }
         }
        tabella += "</table>";
        this.aggiungiTesto(tabella);
    }
    
    public void aggiungiTabella(Object[][] blocchi, String tipo_carattere, int dim_carattere, boolean grossetto, int allineamento, int lunghezza_bocchi[],boolean bordi) {
        
        String[][] _blocchi = new String[blocchi.length][blocchi[0].length];
        int r=0;
        for(Object[] riga :blocchi){
            int c =0;
            if(riga != null){
                for(Object cella : riga){
                    _blocchi[r][c++] = cella != null ? cella.toString() : "";
                }
            }
            r++;
        }
        aggiungiTabella(_blocchi, tipo_carattere, dim_carattere, grossetto, allineamento, lunghezza_bocchi, bordi);
    }
    
    public void aggiungiTabella(String[][] blocchi, String tipo_carattere, int dim_carattere, boolean grossetto, int allineamento, int lunghezza_bocchi[],boolean bordi) {
        if(bordi)
            aggiungiTesto(Stampato.tabella( blocchi, tipo_carattere, dim_carattere, grossetto, allineamento, lunghezza_bocchi));
        else
            aggiungiTesto(Stampato.testo( blocchi, tipo_carattere, dim_carattere, grossetto, allineamento, lunghezza_bocchi));
        
    }
    
    public void aggiungiBlocco(String testo, String tipo, int dimensione, boolean grossetto, boolean centrato, boolean bordo, int altezza, int larghezza) {
        String stile  = Stampato.impostaFont(dimensione, tipo);
        stile += Stampato.impostaGrossetto(grossetto);
        if (centrato) {
            stile += " text-align: center;";
        }
        stile += " width: " + String.valueOf(larghezza) + "px;";
        stile += " height: " + String.valueOf(altezza) + "px;";
        stile += " float: left;";
        if (bordo) {
            stile += " border-style: solid; padding: 5px; border-width: 2px";
        }
        String blocco = "<div style=\"" + stile + "\" >" + testo + "</div>";
        this.aggiungiTesto(blocco);
    }

    
    public void aggiungiBlocco(String testo, String tipo, int dimensione, boolean grossetto, int allineamento) {
        String stile =  Stampato.impostaFont(dimensione, tipo);
        if (grossetto) {
            stile += " font-weight: bold; ";
        }
        stile += Stampato.impostaAlliniamento(allineamento);
        String blocco = "<div style=\"" + stile + "\" >" + testo + "</div>";
        this.aggiungiTesto(blocco);
    }
    
    public void aggiungiBlocco(String testo, String tipo, int dimensione, boolean grossetto, boolean bordo, int allineamento) {
        String stile =  Stampato.impostaFont(dimensione, tipo);
        stile += Stampato.impostaGrossetto(grossetto);
        if (bordo) {
            stile += " border-style: solid; padding: 5px; border-width: 1px";
        }
        stile += Stampato.impostaAlliniamento(allineamento);
        String blocco = "<div style=\"" + stile + "\" >" + testo + "</div>";
        this.aggiungiTesto(blocco);
    }

    public void aggiungiBlocco(String testo) {
        String blocco = "<div style=\" margin: 0px; padding: 0px; \" >" + testo + "</div>";
        this.aggiungiTesto(blocco);
    }
    
    public void aggiungiBlocco(String testo,int dimensione) {
        String stile =  Stampato.impostaFont(dimensione);
        String blocco = "<div style=\"" + stile + "\">" + testo + "</div>";
        this.aggiungiTesto(blocco);
    }

    private static String impostaAlliniamento(int allineamento){
        String stile = "";
        switch (allineamento) {
            case ALL_CENTRO:
                stile += " text-align: center;";
                break;
            case ALL_DESTRA:
                stile += " text-align: right;";
                break;
            case ALL_SINISTRA:
                stile += " text-align: left;";
                break;
            case ALL_GIUSTIFICATO:
                stile += " text-align: justify;";
                break;
            default:
                break;
        }
        return stile;
    }
        
    private static String impostaBordo(int bordo){
        String stile = "";
        switch (bordo) {
            case NO_BORDO:
                stile += " border-style: none;";
                break;
            case BORDO:
                stile += " border-style: solid;";
                break;
            case DOPPIO_BORDO:
                stile += " border-style: double;";
                break;
            case TRATTEGGIATO:
                stile += " border-style: dashed;";
                break;
            default:
                break;
        }
        return stile;
    }
    
    private static String impostaGrossetto(boolean grossetto){
        String stile = "";
        if (grossetto) {
            stile += " font-weight: bold;";
        }
        return stile;
    }
    
    private static String impostaFont(int dim_carattere, String tipo_carattere){
        return "font-family: " + tipo_carattere + "; font-size: " + String.valueOf(dim_carattere) + " px ;";
    }
    
    private static String impostaFont(int dim_carattere){
        return " font-size: " + String.valueOf(dim_carattere) + " px ;";
    }
    
    public static String testo(String testo, int dim_carattere, boolean grossetto, int allineamento, int altezza, int lunghezza, int bordo, int dim_bordo,String colore_bordo) {
        String stile = Stampato.impostaFont(dim_carattere);
        stile += Stampato.impostaGrossetto(grossetto);
        stile += Stampato.impostaAlliniamento(allineamento);
        stile += Stampato.impostaBordo(bordo);
        
        stile += " border-width: " + dim_bordo + "px;";
        stile += " border-color: " + colore_bordo +";";
        stile += " height: " + altezza + "px;";
        stile += " width: " + lunghezza + "px";
        return "<div style=\"" + stile + "\" >" + testo + "</div>";
    }
    
    public static String testo(String testo, int dim_carattere, boolean grossetto, int allineamento, int altezza, int lunghezza, int bordo,int dim_bordo) {
        return testo(testo,dim_carattere,grossetto,allineamento,altezza,lunghezza,bordo, dim_bordo,"black");
    }
    
    public static String testo(String testo, int dim_carattere, boolean grossetto, int allineamento) {
        String stile = " font-size: " + dim_carattere + "px;";
        stile += Stampato.impostaGrossetto(grossetto);
        stile += Stampato.impostaAlliniamento(allineamento);
        
        return "<div style=\"" + stile + "\" >" + testo + "</div>";
    }
    
    public static String testo(String testo,String tipo_carattere ,int dim_carattere, boolean grossetto, int allineamento) {
        String stile = Stampato.impostaFont(dim_carattere, tipo_carattere);
        stile += Stampato.impostaGrossetto(grossetto);
        stile += Stampato.impostaAlliniamento(allineamento);
        
        return "<div style=\"" + stile + "\" >" + testo + "</div>";
    }
    
    public static String testo(String testo,String tipo_carattere ,int dim_carattere) {
        return Stampato.testo(testo, tipo_carattere, dim_carattere, false, Stampato.ALL_SINISTRA);
    }
       
    public static String titolo(String testo, int dim_carattere) {
        String stile =  Stampato.impostaFont(dim_carattere);
        stile += " font-weight: bold;";
        stile += " text-align: center;";
        stile += " height: 100%;";
        stile += " width: 100%";
        return "<div style=\"" + stile + "\" >" + testo + "</div>";
    }
    
    public static String testo(Object[] blocchi, String tipo_carattere, int dim_carattere, boolean grossetto, int allineamento, int lunghezza_bocchi) {
        String stile = Stampato.impostaFont(dim_carattere, tipo_carattere);
        stile += Stampato.impostaGrossetto(grossetto);
        stile += Stampato.impostaAlliniamento(allineamento);
        
        stile += " width: " + lunghezza_bocchi + " px ;";
        String blocco = "<table><tr>";
        for (Object _testo : blocchi) {
            blocco += "<td style=\"" + stile + "\" >" + _testo != null ? _testo.toString() : ""  + "</td>";
        }
        blocco += "</tr></table>";
        return blocco;
    }
    
    
    
    public static String testo(String[] blocchi, String tipo_carattere, int dim_carattere, boolean grossetto, int allineamento, int lunghezza_bocchi) {
        String stile = Stampato.impostaFont(dim_carattere, tipo_carattere);
        stile += Stampato.impostaGrossetto(grossetto);
        stile += Stampato.impostaAlliniamento(allineamento);
        
        stile += " width: " + lunghezza_bocchi + " px ;";
        String blocco = "<table cellpadding=\"0px\" cellspacing=\"0px\" style=\"padding: 0; margin: 0;\" ><tr>";
        for (String _testo : blocchi) {
            blocco += "<td style=\"" + stile + "\" >" + _testo + "</td>";
        }
        blocco += "</tr></table>";
        return blocco;
    }
    
    public static String testo(String[] blocchi, String tipo_carattere, int dim_carattere, boolean grossetto, int allineamento, int[] lunghezza_blocchi) {
        if(blocchi.length != lunghezza_blocchi.length) 
            return "errore! lunghezza blocchi! :(";
        String stile =  Stampato.impostaFont(dim_carattere, tipo_carattere);
        stile += Stampato.impostaGrossetto(grossetto);
        stile += Stampato.impostaAlliniamento(allineamento);
        
        String blocco = "<table cellpadding=\"0px\" cellspacing=\"0px\" style=\"padding: 0; margin: 0;\" ><tr>";
        int i=0;
        for (String _testo : blocchi) {
            blocco += "<td style=\"" + stile+ " width: " + lunghezza_blocchi[i++] + " px ;" + "\" >" + _testo + "</td>";
        }
        blocco += "</tr></table>";
        return blocco;
    }
        
    public static String testo(String[][] blocchi, String tipo_carattere, int dim_carattere, boolean grossetto, int allineamento) {
        return Stampato.testo(blocchi, tipo_carattere, dim_carattere, grossetto, allineamento, null);
    }
    
    public static String testo(String[][] blocchi, String tipo_carattere, int dim_carattere, boolean grossetto, int allineamento, int lunghezza_blocchi) {
        String stile =  Stampato.impostaFont(dim_carattere, tipo_carattere);
        stile += Stampato.impostaGrossetto(grossetto);
        stile += Stampato.impostaAlliniamento(allineamento);
        String inizializzaTab = " cellpadding=\"1px\" cellspacing=\"0px\" style=\"border-style: none\" ";
        return Stampato.creaTabella(blocchi, new int[]{lunghezza_blocchi}, inizializzaTab, stile);
    }
    
    public static String testo(String[][] blocchi, String tipo_carattere, int dim_carattere, boolean grossetto, int allineamento, int[] lunghezza_blocchi) {
        String stile =  Stampato.impostaFont(dim_carattere, tipo_carattere);
        stile += Stampato.impostaGrossetto(grossetto);
        stile += Stampato.impostaAlliniamento(allineamento);
        String inizializzaTab = " cellpadding=\"1px\" cellspacing=\"0px\" style=\"border-style: none\" ";
        return Stampato.creaTabella(blocchi, lunghezza_blocchi, inizializzaTab, stile);
    }
      
    public static String tabella(String[][] blocchi, String tipo_carattere, int dim_carattere, boolean grossetto, int allineamento, int[] lunghezza_blocchi) {
        String stile =  Stampato.impostaFont(dim_carattere, tipo_carattere);
        stile += Stampato.impostaGrossetto(grossetto);
        stile += Stampato.impostaAlliniamento(allineamento);
        
        stile +=  " border-style: solid; border-width: 1px;  border-color: gray; " ;
        String inizializzaTab = " cellpadding=\"1px\" cellspacing=\"1px\" style=\"border-style: none\" ";
       
        return Stampato.creaTabella(blocchi, lunghezza_blocchi,inizializzaTab, stile);
    }
    
    public static String tabella(String[][] blocchi, String tipo_carattere, int dim_carattere, boolean grossetto, int allineamento) {
        return Stampato.tabella(blocchi, tipo_carattere, dim_carattere, grossetto, allineamento, null);
    }
        
        
    private static String creaTabella(String[][] blocchi, int[] lunghezza_bocchi, String attributiTab, String stileCella){
        String blocco = String.format("<table %s >",attributiTab);
        for (String _testo[] : blocchi) {
            blocco += "<tr>";
            int i=0;
            for(String testo: _testo) {
                if(lunghezza_bocchi != null){
                    blocco += String.format("<td style=\" %s width: %s px; \" >%s</td>",stileCella,lunghezza_bocchi[i],testo != null ? testo : "");
                    if(i < lunghezza_bocchi.length) i++;else i=0;
                }else{
                    blocco += String.format("<td style=\" %s \" >%s</td>",stileCella,testo);
                }
            }
            blocco += "</tr>";
        }
        blocco += "</table>";
        return blocco;
    }
        
    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex) {
        if (pageIndex != 0) {
             return NO_SUCH_PAGE;
        }
        if (g!=null){
            printAll(g);
            g.dispose();
        }
        return PAGE_EXISTS;
    }
    
    
    protected abstract void aggiungiTesto(String testo);
    
    public abstract void cancella();
    
    // Variables declaration - do not modify
    protected abstract JTextPane areaTesto();
    
    
}
