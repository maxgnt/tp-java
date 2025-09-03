package com.isitech.bibliotheque.models;

import java.time.LocalDate;

public class Emprunt {
    private Utilisateur utilisateur;
    private Livre livre;
    private LocalDate dateEmprunt;
    private LocalDate dateRetourPrevue;
    private LocalDate dateRetourReelle;

    public Emprunt(Utilisateur utilisateur, Livre livre, int dureeJours) {
        this.utilisateur = utilisateur;
        this.livre = livre;
        this.dateEmprunt = LocalDate.now();
        this.dateRetourPrevue = dateEmprunt.plusDays(dureeJours);
        this.dateRetourReelle = null;
    }


    public void retourner() {
        this.dateRetourReelle = LocalDate.now();
        livre.retourner();
        utilisateur.decrementerEmprunts();
    }


    public boolean estEnRetard() {
        return dateRetourReelle == null && LocalDate.now().isAfter(dateRetourPrevue);
    }


    public Utilisateur getUtilisateur() { return utilisateur; }
    public Livre getLivre() { return livre; }
    public LocalDate getDateEmprunt() { return dateEmprunt; }
    public LocalDate getDateRetourPrevue() { return dateRetourPrevue; }
    public LocalDate getDateRetourReelle() { return dateRetourReelle; }

    @Override
    public String toString() {
        return String.format("Emprunt [Livre=%s, Utilisateur=%s, Emprunté le=%s, Retour prévu=%s, Retour réel=%s]",
                livre.getTitre(),
                utilisateur.getNom(),
                dateEmprunt,
                dateRetourPrevue,
                (dateRetourReelle == null ? "Pas encore rendu" : dateRetourReelle.toString()));
    }
}
