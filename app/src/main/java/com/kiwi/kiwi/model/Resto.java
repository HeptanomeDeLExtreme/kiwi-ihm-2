package com.kiwi.kiwi.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Resto {
    String nom;
    String photo; // Chemin vers l'image, en res ou en url
    Boolean ouvert; // Ouvert ou Fermé
    String adresse;
    Paiement moyenPaiement;
    String telephone;
    String niveauTarif; //Entre 1 et 3
    String tempsAttente;
    String horaires;
    Categorie categorie; // Resto U, Resto INSA, ...
    String typeRestaurant; // Italien, Tacos, ..
    String menuDuJour;
    List<Avis> avis;
    LatLng positionGPS;
    Double distanceUtilisateurRestaurant;
    Integer tempsUtilisateurRestaurant;
    String description;
    List<Ami> mesAmisQuiSontDansCeResto;
    Integer nbRepasRestants;

    Boolean visible;

    public Resto(){};

    public Resto(String nom, String photo, Boolean ouvert, String adresse, Paiement moyenPaiement,
                 String telephone, String niveauTarif, String tempsAttente, String horaires,
                 Categorie categorie, String typeRestaurant, String menuDuJour, List<Avis> avis,
                 double lat, double lon, Double distanceUtilisateurRestaurant,
                 Integer tempsUtilisateurRestaurant, String description, Integer nbRepasRestants, Boolean visible) {
        
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
        this.positionGPS = new LatLng(lat, lon);
        this.distanceUtilisateurRestaurant = distanceUtilisateurRestaurant;
        this.tempsUtilisateurRestaurant = tempsUtilisateurRestaurant;
        this.description = description;
        this.visible = visible;
        this.nbRepasRestants = nbRepasRestants;

        mesAmisQuiSontDansCeResto = new ArrayList<Ami>();
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

    public Paiement getMoyenPaiement() {
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

    public String getDescription() {
        return description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getTypeRestaurant() {
        return typeRestaurant;
    }

    public LatLng getPositionGPS() {
        return positionGPS;
    }

    public Integer getTempsUtilisateurRestaurant() {
        return tempsUtilisateurRestaurant;
    }

    public List<Ami> getMesAmisQuiSontDansCeResto() {
        return mesAmisQuiSontDansCeResto;
    }

    public Integer getNbRepasRestants() {
        return nbRepasRestants;
    }

    public void addAvis (Avis avis){
        this.avis.add(avis);
    }

    public Double getNiveauTarifDouble() {
        Double tarif = 0.0;
        switch (this.niveauTarif){
            case "€":
                tarif = 4.0;
                break;
            case "€€":
                tarif = 8.0;
                break;
            case "€€€":
                tarif = 12.0;
                break;
        }
        return tarif;
    }

    public enum Paiement {
        CB,
        INSA,
        IZLY
    }
}
