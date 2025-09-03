package com.isitech.bibliotheque;
import com.isitech.bibliotheque.models.Livre;


import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
    private List<Livre> livres;
    private String nom;

    public Bibliotheque(String nom) {
        this.nom = nom;
        this.livres = new ArrayList<>();
    }


    public void ajouterLivre(Livre livre) {
        for (Livre l : livres) {
            if (l.getIsbn().equals(livre.getIsbn())) {
                System.out.println(" Un livre avec cet ISBN existe déjà !");
                return;
            }
        }
        livres.add(livre);
        System.out.println(" Livre ajouté : " + livre.getTitre());
    }


    public boolean supprimerLivre(String isbn) {
        for (Livre l : livres) {
            if (l.getIsbn().equals(isbn)) {
                livres.remove(l);
                return true;
            }
        }
        return false;
    }


    public Livre rechercherParTitre(String titre) {
        for (Livre l : livres) {
            if (l.getTitre().equalsIgnoreCase(titre)) {
                return l;
            }
        }
        return null;
    }


    public Livre rechercherParAuteur(String auteur) {
        for (Livre l : livres) {
            if (l.getAuteur().equalsIgnoreCase(auteur)) {
                return l;
            }
        }
        return null;
    }


    public Livre rechercherParISBN(String isbn) {
        for (Livre l : livres) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }


    public List<Livre> rechercherLivresDisponibles() {
        List<Livre> disponibles = new ArrayList<>();
        for (Livre l : livres) {
            if (l.isDisponible()) {
                disponibles.add(l);
            }
        }
        return disponibles;
    }


    public void afficherCatalogue() {
        System.out.println("\n=== Catalogue de " + nom + " ===");
        if (livres.isEmpty()) {
            System.out.println("Aucun livre dans la bibliothèque.");
        } else {
            for (int i = 0; i < livres.size(); i++) {
                System.out.println((i + 1) + ". " + livres.get(i));
            }
        }
        System.out.println("Total: " + livres.size() + " livres\n");
    }

    public void afficherStatistiques() {
        long disponibles = livres.stream().filter(Livre::isDisponible).count();
        long empruntes = livres.size() - disponibles;

        System.out.println("\n=== Statistiques ===");
        System.out.println("Total livres: " + livres.size());
        System.out.println("Disponibles: " + disponibles);
        System.out.println("Empruntés: " + empruntes);
    }
}
