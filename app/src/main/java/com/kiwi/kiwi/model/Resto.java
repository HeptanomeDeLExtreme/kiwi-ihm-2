package com.kiwi.kiwi.model;

import java.util.List;

public class Resto {
    String nom;
    String photo; // Chemin vers l'image, en res ou en url
    Boolean ouvert; // Ouvert ou Fermé, juste pour toString
    String adresse;
    String moyenPaiement;
    Integer niveauTarif; //Entre 1 et 3
    Integer tempsAttenteAvantManger;
    Integer tempsMarcheVersResto;
    Integer tempsTotal; // attente pour manger + marche vers resto
    String horaires;
    Categorie categorie; // Resto U, Resto INSA, ...
    String menuDuJour;
    List<Avis> avis;

    public Resto(String nom, String photo, Boolean ouvert, String adresse, String moyenPaiement,
                 Integer niveauTarif, Integer tempsAttenteAvantManger, Integer tempsMarcheVersResto,
                 String horaires, Categorie categorie, String menuDuJour, List<Avis> avis) {
        this.nom = nom;
        this.photo = photo;
        this.ouvert = ouvert;
        this.adresse = adresse;
        this.moyenPaiement = moyenPaiement;
        this.niveauTarif = niveauTarif;
        this.tempsAttenteAvantManger = tempsAttenteAvantManger;
        this.tempsMarcheVersResto = tempsMarcheVersResto;
        this.tempsTotal = tempsAttenteAvantManger + tempsMarcheVersResto;
        this.horaires = horaires;
        this.categorie = categorie;
        this.menuDuJour = menuDuJour;
        this.avis = avis;
    }

    public Resto(String photo, String nom, Boolean ouvert) {
        this.ouvert = ouvert;
        this.photo = photo;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Boolean getOuvert() {
        return ouvert;
    }

    public void setOuvert(Boolean ouvert) {
        this.ouvert = ouvert;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMoyenPaiement() {
        return moyenPaiement;
    }

    public void setMoyenPaiement(String moyenPaiement) {
        this.moyenPaiement = moyenPaiement;
    }

    public Integer getNiveauTarif() {
        return niveauTarif;
    }

    public void setNiveauTarif(Integer niveauTarif) {
        this.niveauTarif = niveauTarif;
    }

    public Integer getTempsAttenteAvantManger() {
        return tempsAttenteAvantManger;
    }

    public void setTempsAttenteAvantManger(Integer tempsAttenteAvantManger) {
        this.tempsAttenteAvantManger = tempsAttenteAvantManger;
    }

    public Integer getTempsMarcheVersResto() {
        return tempsMarcheVersResto;
    }

    public void setTempsMarcheVersResto(Integer tempsMarcheVersResto) {
        this.tempsMarcheVersResto = tempsMarcheVersResto;
    }

    public Integer getTempsTotal() {
        return tempsTotal;
    }

    public void setTempsTotal(Integer tempsTotal) {
        this.tempsTotal = tempsTotal;
    }

    public String getHoraires() {
        return horaires;
    }

    public void setHoraires(String horaires) {
        this.horaires = horaires;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getMenuDuJour() {
        return menuDuJour;
    }

    public void setMenuDuJour(String menuDuJour) {
        this.menuDuJour = menuDuJour;
    }

    public List<Avis> getAvis() {
        return avis;
    }

    public void setAvis(List<Avis> avis) {
        this.avis = avis;
    }
}
