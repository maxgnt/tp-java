package com.isitech.bibliotheque;

public class Livre {
    private String titre;
    private String auteur;
    private String isbn;
    private boolean disponible;


    public Livre() {
        this.disponible = true;
    }


    public Livre(String titre, String auteur, String isbn) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.disponible = true;
    }


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }


    @Override
    public String toString() {
        String statut = disponible ? "Disponible" : "Emprunté";
        return String.format("'%s' par %s (ISBN: %s) - %s",
                titre, auteur, isbn, statut);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Livre autre = (Livre) obj;
        return isbn != null && isbn.equals(autre.isbn);
    }
}
