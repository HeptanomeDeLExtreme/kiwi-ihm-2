package com.kiwi.kiwi.model;

import java.util.List;

public class Resto {
    String nom;
    String photo; // Chemin vers l'image, en res ou en url
    Boolean ouvert; // Ouvert ou Fermé, juste pour toString
    String adresse;
    String moyenPaiement;
    Integer niveauTarif; //Entre 1 et 3
    String tempsAttente;
    String horaires;
    Categorie categorie; // Resto U, Resto INSA, ...
    String menuDuJour;
    List<Avis> avis;


    public Resto(String nom, String photo, Boolean ouvert, String adresse, String moyenPaiement,
                 Integer niveauTarif, String tempsAttente, String horaires, Categorie categorie,
                 String menuDuJour, List<Avis> avis) {
        this.nom = nom;
        this.photo = photo;
        this.ouvert = ouvert;
        this.adresse = adresse;
        this.moyenPaiement = moyenPaiement;
        this.niveauTarif = niveauTarif;
        this.tempsAttente = tempsAttente;
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

    public Integer getNiveauTarif() {
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
