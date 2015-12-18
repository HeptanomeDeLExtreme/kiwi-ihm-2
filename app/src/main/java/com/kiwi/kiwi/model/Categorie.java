package com.kiwi.kiwi.model;

/**
 * Created by root on 11/12/15.
 */
public class Categorie {
    String nom;
    String icone; // TODO Voir comment fonctionne icone

    public Categorie(String icone, String nom) {
        this.icone = icone;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public String getIcone() {
        return icone;
    }


}
