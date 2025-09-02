package com.isitech.bibliotheque.models;

import com.isitech.bibliotheque.models.Livre;

public class Etudiant extends Utilisateur {
    private String numeroEtudiant;
    private String niveau;
    private String filiere;

    public Etudiant(String nom, String email, String numeroEtudiant, String niveau, String filiere) {
        super(nom, email);
        this.numeroEtudiant = numeroEtudiant;
        this.niveau = niveau;
        this.filiere = filiere;
        this.maxEmprunts = 3;
    }

    @Override
    public int getDureeEmpruntMax() {
        return 15;
    }

    @Override
    public boolean peutEmprunterType(Livre livre) {
        return "Livre".equalsIgnoreCase(livre.getClass().getSimpleName());
    }

    @Override
    public String getTypeUtilisateur() {
        return "Etudiant";
    }
}
