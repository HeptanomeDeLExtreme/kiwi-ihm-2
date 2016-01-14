package com.kiwi.kiwi.model;

public class Ami {

    String nom;
    String prenom;
    String photo;
    Resto restaurantActuel;
    int tempsAttente;
    int tempsChemin;

    public Ami(String nom, String prenom, String photo, int tempsAttente, int tempsChemin, Resto resto) {
        this.nom = nom;
        this.prenom = prenom;
        this.photo = photo;
        this.tempsAttente = tempsAttente;
        this.tempsChemin = tempsChemin;
        this.restaurantActuel = resto;
    }

    public Ami(String nom, String prenom, String photo, int tempsAttente, int tempsChemin) {
        this.nom = nom;
        this.prenom = prenom;
        this.photo = photo;
        this.tempsAttente = tempsAttente;
        this.tempsChemin = tempsChemin;
    }

    public Ami(String nom, String prenom, String photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.photo = photo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTempsAttente() {
        return tempsAttente;
    }

    public int getTempsChemin() {
        return tempsChemin;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPhoto() {
        return photo;
    }

    public Resto getRestaurantActuel() {
        return restaurantActuel;
    }

}
