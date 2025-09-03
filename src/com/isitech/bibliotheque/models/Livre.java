package com.isitech.bibliotheque.models;

import com.isitech.bibliotheque.interfaces.Empruntable;
import com.isitech.bibliotheque.interfaces.Cherchable;

import java.time.LocalDate;

public class Livre implements Empruntable, Cherchable {
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

    // Si tu veux, tu peux garder un constructeur plus simple
    public Livre(String isbn, String titre, String auteur) {
        this(isbn, titre, auteur, 0, "Inconnu", LocalDate.now());
    }

    // --- Implémentation de Empruntable ---
    @Override
    public boolean isDisponible() {
        return disponible;
    }

    @Override
    public void emprunter() {
        if (!disponible) {
            throw new IllegalStateException("Le livre est déjà emprunté.");
        }
        disponible = false;
    }

    @Override
    public void retourner() {
        disponible = true;
    }


    @Override
    public boolean correspond(String critere) {
        return titre.equalsIgnoreCase(critere)
                || auteur.equalsIgnoreCase(critere)
                || isbn.equalsIgnoreCase(critere);
    }


    public String getIsbn() { return isbn; }
    public String getTitre() { return titre; }
    public String getAuteur() { return auteur; }
    public int getNbPages() { return nbPages; }
    public String getEditeur() { return editeur; }
    public LocalDate getDatePublication() { return datePublication; }

    @Override
    public String toString() {
        return String.format("Livre [ISBN=%s, Titre=%s, Auteur=%s, Disponible=%s]",
                isbn, titre, auteur, disponible ? "Oui" : "Non");
    }
}
