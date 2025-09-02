package com.isitech.bibliotheque.models;

import java.time.LocalDate;

public class Livre {
    private final String isbn;
    private String titre;
    private String auteur;
    private int nbPages;
    private String editeur;
    private LocalDate datePublication;
    private boolean disponible;

    public Livre(String isbn, String titre, String auteur, int nbPages, String editeur, LocalDate datePublication) {
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.nbPages = nbPages;
        this.editeur = editeur;
        this.datePublication = datePublication;
        this.disponible = true;
    }


    public String getIsbn() { return isbn; }
    public String getTitre() { return titre; }
    public String getAuteur() { return auteur; }
    public int getNbPages() { return nbPages; }
    public String getEditeur() { return editeur; }
    public LocalDate getDatePublication() { return datePublication; }
    public boolean isDisponible() { return disponible; }


    public void setTitre(String titre) { this.titre = titre; }
    public void setAuteur(String auteur) { this.auteur = auteur; }
    public void setNbPages(int nbPages) { this.nbPages = nbPages; }
    public void setEditeur(String editeur) { this.editeur = editeur; }
    public void setDatePublication(LocalDate datePublication) { this.datePublication = datePublication; }


    public void emprunter() {
        if (!disponible) {
            throw new IllegalStateException("Le livre est déjà emprunté.");
        }
        disponible = false;
    }

    public void retourner() {
        disponible = true;
    }

    @Override
    public String toString() {
        return String.format("Livre [ISBN=%s, Titre=%s, Auteur=%s, Disponible=%s]",
                isbn, titre, auteur, disponible ? "Oui" : "Non");
    }
}
