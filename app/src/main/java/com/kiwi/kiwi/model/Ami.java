package com.kiwi.kiwi.model;

public class Ami {

    String id;
    String pseudo;
    Resto restaurant; // lieu ou l'ami mange
    String photoProfil; // chemin vers la photo (url | res)

    public Ami(String id, String pseudo, Resto restaurant, String photoProfil) {
        this.id = id;
        this.pseudo = pseudo;
        this.restaurant = restaurant;
        this.photoProfil = photoProfil;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Resto getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Resto restaurant) {
        this.restaurant = restaurant;
    }

    public String getPhotoProfil() {
        return photoProfil;
    }

    public void setPhotoProfil(String photoProfil) {
        this.photoProfil = photoProfil;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
