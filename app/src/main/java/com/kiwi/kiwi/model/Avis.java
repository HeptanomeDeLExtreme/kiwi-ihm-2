package com.kiwi.kiwi.model;

/**
 * Created by root on 11/12/15.
 */
public class Avis {
    Integer note; // Entre 1 et 5
    String texte;
    String auteur;

    public Avis(Integer note, String texte, String auteur) {
        this.note = note;
        this.texte = texte;
        this.auteur = auteur;
    }

    public Integer getNote() {
        return note;
    }

    public String getTexte() {
        return texte;
    }

    public String getAuteur() {
        return auteur;
    }
}
