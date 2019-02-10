/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.quasar_x7.java.swing.stampa;

import java.util.ArrayList;

/**
 *
 * @author Dott. Domenico della Peruta
 * @version 1.1.0 ultima modifica 16.10.2016
 */
public interface FinestraStrampaMultiEventi {

    /**
     * Metodo astratto che genera una lista di record da stampale in funzione della "data".
     *
     * @return
     */
    public ArrayList<Object[]> caricaDati();

    /**
     * Metodo astratto che restituisce due stringhe con il titolo e il sottotitolo di ogni stampa.
     *
     * @return new String[]{"intestazione 1", "intestazione 2"};
     */
    public String[] intestazione();
    
}
