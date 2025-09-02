package com.isitech.bibliotheque.models;

public class Professeur extends Utilisateur {
    private String departement;
    private boolean accesRessourcesSpeciales;

    public Professeur(String nom, String email, String departement, boolean accesRessourcesSpeciales) {
        super(nom, email);
        this.departement = departement;
        this.accesRessourcesSpeciales = accesRessourcesSpeciales;
        this.maxEmprunts = 10;
    }

    @Override
    public int getDureeEmpruntMax() {
        return 30;
    }

    @Override
    public boolean peutEmprunterType(Livre livre) {
        return true;
    }

    @Override
    public String getTypeUtilisateur() {
        return "Professeur";
    }

    // Getters (optionnels, utiles pour tests)
    public String getDepartement() {
        return departement;
    }

    public boolean hasAccesRessourcesSpeciales() {
        return accesRessourcesSpeciales;
    }
}
