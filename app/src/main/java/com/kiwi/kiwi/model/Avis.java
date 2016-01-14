package com.kiwi.kiwi.model;

public class Avis {
    Integer note; // Entre 1 et 5
    String texte;
    Ami auteur;

    public Avis(Integer note, String texte, Ami auteur) {
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

    public Ami getAuteur() {
        return auteur;
    }
}
