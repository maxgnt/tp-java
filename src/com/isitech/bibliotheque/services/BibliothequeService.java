package com.isitech.bibliotheque.services;

import com.isitech.bibliotheque.models.Livre;

import java.util.ArrayList;
import java.util.List;

public class BibliothequeService {
    private List<Livre> livres;

    public BibliothequeService() {
        this.livres = new ArrayList<>();
    }

    public void ajouterLivre(Livre livre) {
        livres.add(livre);
    }


    public boolean supprimerLivre(String isbn) {
        return livres.removeIf(l -> l.getIsbn().equals(isbn));
    }


    public Livre rechercherParTitre(String titre) {
        for (Livre l : livres) {
            if (l.getTitre().equalsIgnoreCase(titre)) {
                return l;
            }
        }
        return null;
    }


    public List<Livre> rechercherParAuteur(String auteur) {
        List<Livre> resultats = new ArrayList<>();
        for (Livre l : livres) {
            if (l.getAuteur().equalsIgnoreCase(auteur)) {
                resultats.add(l);
            }
        }
        return resultats;
    }


    public void afficherCatalogue() {
        System.out.println("\n=== Catalogue ===");
        if (livres.isEmpty()) {
            System.out.println("Aucun livre dans la bibliothèque.");
        } else {
            for (Livre l : livres) {
                System.out.println(l);
            }
        }
    }

    public List<Livre> getLivres() {
        return livres;
    }
}
