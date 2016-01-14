package com.kiwi.kiwi.model;

public enum Categorie {
    UNIVERSITAIRE("izly", "Universitaire"),
    ITALIEN("italien.jpg", "Italien"),
    TACOS("tacos.jpg", "Tacos"),
    PIZZERIA("pizzeria.jpg", "Pizzeria"),
    ORIENTAL("oriental.jpg", "Cuisine Orientale"),
    INDIEN("indien.jpg", "Cuisine Indienne"),
    SANDWICH("sandwich.jpg", "Sandwich"),
    INSA("logo_insa", "INSA");

    private String nom;
    private String icone;

    Categorie(String icone, String nom) {
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
