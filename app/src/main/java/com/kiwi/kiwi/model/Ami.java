package com.kiwi.kiwi.model;

/**
 * Created by root on 06/01/16.
 */
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

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Resto getRestaurantActuel() {
        return restaurantActuel;
    }

    public void setRestaurantActuel(Resto restaurantActuel) {
        this.restaurantActuel = restaurantActuel;
    }
}
