package com.kiwi.kiwi.model;

import com.kiwi.kiwi.MainActivity;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Enregistre tous les paramètres de tri
 */
public class Filtre {

    private Boolean ouvert;

    public Filtre() {
        ouvert = false;
    }

    public void majRestos() {
        MainActivity.listeRestosVisibles = (ArrayList) MainActivity.listeRestos.clone();
        for (Iterator<Resto> itr = MainActivity.listeRestosVisibles.iterator(); itr.hasNext(); ) {
            Resto resto = itr.next();
            if (ouvert && !resto.getOuvert()) itr.remove();
        }
    }

    public Boolean getOuvert() {
        return ouvert;
    }

    public void setOuvert(Boolean ouvert) {
        this.ouvert = ouvert;
        majRestos();
    }
}
