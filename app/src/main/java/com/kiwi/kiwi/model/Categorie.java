package com.kiwi.kiwi.model;

/**
 * Created by root on 11/12/15.
 */
public class Categorie {
    String nom;
    String icone; // TODO Voir comment fonctionne icone
    static Categorie universitaire;

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

    public static Categorie getUniversitaire(){
        if(universitaire == null){
            universitaire = new Categorie("universitaire.jpg","Universitaire");
        }
        return universitaire;
    }

    public static Categorie getItalien(){
        if(universitaire == null){
            universitaire = new Categorie("italien.jpg","Italien");
        }
        return universitaire;
    }

    public static Categorie getTacos() {
        if(universitaire == null){
            universitaire = new Categorie("tacos.jpg","Tacos");
        }
        return universitaire;
    }

    public static Categorie getPizzeria() {
        if(universitaire == null){
            universitaire = new Categorie("pizzeria.jpg","Pizzeria");
        }
        return universitaire;
    }

    public static Categorie getOriental() {
        if(universitaire == null){
            universitaire = new Categorie("oriental.jpg","Cuisine Orientale");
        }
        return universitaire;
    }

    public static Categorie getIndien() {
        if(universitaire == null){
            universitaire = new Categorie("indien.jpg","Cuisine Indienne");
        }
        return universitaire;
    }

    public static Categorie getSandwich() {
        if(universitaire == null){
            universitaire = new Categorie("sandwich.jpg","Sandwich");
        }
        return universitaire;
    }
}
