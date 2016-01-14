package com.kiwi.kiwi.model;

import com.kiwi.kiwi.MainActivity;

import java.util.ArrayList;
import java.util.Iterator;

public class Filtre {

    private Boolean cb;
    private Boolean INSA;
    private Boolean IZLY;

    private Boolean universitaire;
    private Boolean italien;
    private Boolean tacos;
    private Boolean pizzeria;
    private Boolean oriental;
    private Boolean indien;
    private Boolean sandwich;

    private Boolean ouvert;

    private Double prixMin;
    private Double prixMax;

    public Filtre() {
        cb = true;
        INSA = true;
        IZLY = true;

        universitaire = true;
        italien = true;
        tacos = true;
        pizzeria = true;
        oriental = true;
        indien = true;
        sandwich = true;

        ouvert = false;

        prixMin = 0.0;
        prixMax = 15.0;
    }

    public void majRestos() {
        MainActivity.listeRestosVisibles = (ArrayList) MainActivity.listeRestos.clone();
        for (Iterator<Resto> itr = MainActivity.listeRestosVisibles.iterator(); itr.hasNext(); ) {
            Resto resto = itr.next();
            if (ouvert && !resto.getOuvert() ||
                    (!cb && resto.getMoyenPaiement() == Resto.Paiement.CB) ||
                    (!INSA && resto.getMoyenPaiement() == Resto.Paiement.INSA) ||
                    (!IZLY && resto.getMoyenPaiement() == Resto.Paiement.IZLY) ||
                    (!universitaire && resto.getCategorie() == Categorie.UNIVERSITAIRE) ||
                    (!italien && resto.getCategorie() == Categorie.ITALIEN) ||
                    (!tacos && resto.getCategorie() == Categorie.TACOS) ||
                    (!pizzeria && resto.getCategorie() == Categorie.PIZZERIA) ||
                    (!oriental && resto.getCategorie() == Categorie.ORIENTAL) ||
                    (!indien && resto.getCategorie() == Categorie.INDIEN) ||
                    (!sandwich && resto.getCategorie() == Categorie.SANDWICH) ||
                    //Méthode sale pour le filtre des prix , pour raisons historiques :
                    // € signifie 5€, €€ = 10€, €€€ = 15€
                    (resto.getNiveauTarifDouble() > prixMax) ||
                    (resto.getNiveauTarifDouble() < prixMin)
                    )
                itr.remove();
        }
    }

    public Boolean getCb() {
        return cb;
    }

    public void setCb(Boolean cb) {
        this.cb = cb;
        majRestos();
    }

    public Boolean getINSA() {
        return INSA;
    }

    public void setINSA(Boolean INSA) {
        this.INSA = INSA;
        majRestos();
    }

    public Boolean getIZLY() {
        return IZLY;
    }

    public void setIZLY(Boolean IZLY) {
        this.IZLY = IZLY;
        majRestos();
    }

    public Boolean getUniversitaire() {
        return universitaire;
    }

    public void setUniversitaire(Boolean universitaire) {
        this.universitaire = universitaire;
        majRestos();
    }

    public Boolean getItalien() {
        return italien;
    }

    public void setItalien(Boolean italien) {
        this.italien = italien;
        majRestos();
    }

    public Boolean getTacos() {
        return tacos;
    }

    public void setTacos(Boolean tacos) {
        this.tacos = tacos;
        majRestos();
    }

    public Boolean getPizzeria() {
        return pizzeria;
    }

    public void setPizzeria(Boolean pizzeria) {
        this.pizzeria = pizzeria;
        majRestos();
    }

    public Boolean getOriental() {
        return oriental;
    }

    public void setOriental(Boolean oriental) {
        this.oriental = oriental;
        majRestos();
    }

    public Boolean getIndien() {
        return indien;
    }

    public void setIndien(Boolean indien) {
        this.indien = indien;
        majRestos();
    }

    public Boolean getSandwich() {
        return sandwich;
    }

    public void setSandwich(Boolean sandwich) {
        this.sandwich = sandwich;
        majRestos();
    }

    public Boolean getOuvert() {
        return ouvert;
    }

    public void setOuvert(Boolean ouvert) {
        this.ouvert = ouvert;
        majRestos();
    }

    public void setPrixMin(Double prixMin) {
        this.prixMin = prixMin;
        majRestos();
    }

    public void setPrixMax(Double prixMax) {
        this.prixMax = prixMax;
        majRestos();
    }
}
