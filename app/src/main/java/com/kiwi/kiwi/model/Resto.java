package com.kiwi.kiwi.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Resto {
    String nom;
    String photo; // Chemin vers l'image, en res ou en url
    Boolean ouvert; // Ouvert ou Fermé, juste pour toString
    String adresse;
    String moyenPaiement;
    String telephone;
    String niveauTarif; //Entre 1 et 3
    String tempsAttente;
    String horaires;
    Categorie categorie; // Resto U, Resto INSA, ...
    String typeRestaurant; // Italien, Tacos, Juif, ..
    String menuDuJour;
    List<Avis> avis;
    LatLng positionGPS;
    Double distanceUtilisateurRestaurant;
    Integer tempsUtilisateurRestaurant;
    String description;
    List<Ami> mesAmisQuiSontDansCeResto;


    public Resto(String nom, String photo, Boolean ouvert, String adresse, String moyenPaiement,
                 String telephone, String niveauTarif, String tempsAttente, String horaires,
                 Categorie categorie, String typeRestaurant, String menuDuJour, List<Avis> avis,
                 double lat, double lon, Double distanceUtilisateurRestaurant,
                 Integer tempsUtilisateurRestaurant, String description, Boolean visible) {
        this.nom = nom;
        this.photo = photo;
        this.ouvert = ouvert;
        this.adresse = adresse;
        this.moyenPaiement = moyenPaiement;
        this.telephone = telephone;
        this.niveauTarif = niveauTarif;
        this.tempsAttente = tempsAttente;
        this.horaires = horaires;
        this.categorie = categorie;
        this.typeRestaurant = typeRestaurant;
        this.menuDuJour = menuDuJour;
        this.avis = avis;
        this.positionGPS = new LatLng(lat,lon);
        this.distanceUtilisateurRestaurant = distanceUtilisateurRestaurant;
        this.tempsUtilisateurRestaurant = tempsUtilisateurRestaurant;
        this.description = description;
        this.visible = visible;
        mesAmisQuiSontDansCeResto = new ArrayList<Ami>();
    }

    public Resto(String photo, String nom, Boolean ouvert) {
        this.ouvert = ouvert;
        this.photo = photo;
        this.nom = nom;
    }

    public void ajouteAmi(Ami monAmi){
        mesAmisQuiSontDansCeResto.add(monAmi);
    }

    public List<Ami> getListeAmi(){
        return mesAmisQuiSontDansCeResto;
    }

    public String getNom() {
        return nom;
    }

    public String getPhoto() {
        return photo;
    }

    public Boolean getOuvert() {
        return ouvert;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMoyenPaiement() {
        return moyenPaiement;
    }

    public String getNiveauTarif() {
        return niveauTarif;
    }

    public String getTempsAttente() {
        return tempsAttente;
    }

    public String getHoraires() {
        return horaires;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public String getMenuDuJour() {
        return menuDuJour;
    }

    public List<Avis> getAvis() {
        return avis;
    }
}
