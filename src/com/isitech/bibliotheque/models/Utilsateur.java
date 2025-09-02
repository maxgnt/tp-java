package com.isitech.bibliotheque.models;

import java.util.UUID;

public abstract class Utilisateur {
    protected final String id;
    protected String nom;
    protected String email;
    protected int maxEmprunts;
    protected int empruntsActuels;


    protected Utilisateur(String nom, String email) {
        this.id = UUID.randomUUID().toString().substring(0, 8); // identifiant unique sur 8 caractères
        this.nom = nom;
        this.email = email;
        this.empruntsActuels = 0;
    }


    public abstract int getDureeEmpruntMax();
    public abstract boolean peutEmprunterType(Livre livre);
    public abstract String getTypeUtilisateur();


    public boolean peutEmprunter() {
        return empruntsActuels < maxEmprunts;
    }

    public void incrementerEmprunts() {
        if (empruntsActuels >= maxEmprunts) {
            throw new IllegalStateException("Quota d'emprunts atteint");
        }
        empruntsActuels++;
    }

    public void decrementerEmprunts() {
        if (empruntsActuels > 0) {
            empruntsActuels--;
        }
    }


    public String getId() { return id; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public int getMaxEmprunts() { return maxEmprunts; }
    public int getEmpruntsActuels() { return empruntsActuels; }
}
