package com.kiwi.kiwi.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Resto {
    String nom;
    String photo; // Chemin vers l'image, en res ou en url
    Boolean ouvert; // Ouvert ou Fermé, juste pour toString
    String adresse;
    Paiement moyenPaiement;
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

    public Boolean getVisible() {
        return visible;
    }

    public void cacher() {
        visible = false;
    }

    public void montrer() {
        visible = true;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setOuvert(Boolean ouvert) {
        this.ouvert = ouvert;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setMoyenPaiement(Paiement moyenPaiement) {
        this.moyenPaiement = moyenPaiement;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setNiveauTarif(String niveauTarif) {
        this.niveauTarif = niveauTarif;
    }

    public void setTempsAttente(String tempsAttente) {
        this.tempsAttente = tempsAttente;
    }

    public void setHoraires(String horaires) {
        this.horaires = horaires;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getTypeRestaurant() {
        return typeRestaurant;
    }

    public void setTypeRestaurant(String typeRestaurant) {
        this.typeRestaurant = typeRestaurant;
    }

    public void setMenuDuJour(String menuDuJour) {
        this.menuDuJour = menuDuJour;
    }

    public void setAvis(List<Avis> avis) {
        this.avis = avis;
    }

    public LatLng getPositionGPS() {
        return positionGPS;
    }

    public void setPositionGPS(LatLng positionGPS) {
        this.positionGPS = positionGPS;
    }

    public Double getDistanceUtilisateurRestaurant() {
        return distanceUtilisateurRestaurant;
    }

    public void setDistanceUtilisateurRestaurant(Double distanceUtilisateurRestaurant) {
        this.distanceUtilisateurRestaurant = distanceUtilisateurRestaurant;
    }

    public Integer getTempsUtilisateurRestaurant() {
        return tempsUtilisateurRestaurant;
    }

    public void setTempsUtilisateurRestaurant(Integer tempsUtilisateurRestaurant) {
        this.tempsUtilisateurRestaurant = tempsUtilisateurRestaurant;
    }

    public List<Ami> getMesAmisQuiSontDansCeResto() {
        return mesAmisQuiSontDansCeResto;
    }

    public void setMesAmisQuiSontDansCeResto(List<Ami> mesAmisQuiSontDansCeResto) {
        this.mesAmisQuiSontDansCeResto = mesAmisQuiSontDansCeResto;
    }

    public Integer getNbRepasRestants() {
        return nbRepasRestants;
    }

    public void addAvis (Avis avis){
        this.avis.add(avis);
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
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
