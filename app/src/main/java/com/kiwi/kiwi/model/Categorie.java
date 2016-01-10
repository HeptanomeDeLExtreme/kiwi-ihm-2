package com.kiwi.kiwi.model;

public enum Categorie {
    UNIVERSITAIRE("universitaire.jpg", "Universitaire"),
    ITALIEN("italien.jpg", "Italien"),
    TACOS("tacos.jpg", "Tacos"),
    PIZZERIA("pizzeria.jpg", "Pizzeria"),
    ORIENTAL("oriental.jpg", "Cuisine Orientale"),
    INDIEN("indien.jpg", "Cuisine Indienne"),
    SANDWICH("sandwich.jpg", "Sandwich");

    private String nom;
    private String icone; // TODO Voir comment fonctionne icone

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
