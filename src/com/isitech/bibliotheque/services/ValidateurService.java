package com.isitech.bibliotheque.services;

import com.isitech.bibliotheque.interfaces.Validateur;
import com.isitech.bibliotheque.models.Livre;
import com.isitech.bibliotheque.models.Utilisateur;
import com.isitech.bibliotheque.exceptions.*;

import java.util.regex.Pattern;

public class ValidateurService {

    private static final Pattern PATTERN_EMAIL = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );
    private static final Pattern PATTERN_ISBN_13 = Pattern.compile(
            "^(978|979)[0-9]{10}$"
    );
    private static final Pattern PATTERN_ISBN_10 = Pattern.compile(
            "^[0-9]{9}[0-9X]$"
    );


    public boolean validerLivre(Livre livre) throws BibliothequeException {
        return validerISBN(livre.getIsbn())
                && validerTitre(livre.getTitre())
                && validerAuteur(livre.getAuteur())
                && livre.getNbPages() >= 0;
    }

    public boolean validerISBN(String isbn) throws DonneesInvalidesException {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new DonneesInvalidesException("ISBN requis");
        }
        String isbnNettoye = isbn.replaceAll("[^0-9X]", "");
        if (!PATTERN_ISBN_13.matcher(isbnNettoye).matches() &&
                !PATTERN_ISBN_10.matcher(isbnNettoye).matches()) {
            throw new DonneesInvalidesException("Format ISBN invalide: " + isbn);
        }
        return true;
    }

    public boolean validerTitre(String titre) throws DonneesInvalidesException {
        if (titre == null || titre.trim().isEmpty()) {
            throw new DonneesInvalidesException("Titre requis");
        }
        if (titre.length() > 200) {
            throw new DonneesInvalidesException("Titre trop long (max 200 caractères)");
        }
        return true;
    }

    public boolean validerAuteur(String auteur) throws DonneesInvalidesException {
        if (auteur == null || auteur.trim().isEmpty()) {
            throw new DonneesInvalidesException("Auteur requis");
        }
        if (auteur.length() > 100) {
            throw new DonneesInvalidesException("Nom d'auteur trop long (max 100 caractères)");
        }
        return true;
    }


    public boolean validerUtilisateur(Utilisateur utilisateur) throws UtilisateurInvalideException {
        return validerNom(utilisateur.getNom()) && validerEmail(utilisateur.getEmail());
    }

    public boolean validerNom(String nom) throws UtilisateurInvalideException {
        if (nom == null || nom.trim().isEmpty()) {
            throw new UtilisateurInvalideException("Nom requis");
        }
        if (nom.length() < 2) {
            throw new UtilisateurInvalideException("Nom trop court (min 2 caractères)");
        }
        if (nom.length() > 50) {
            throw new UtilisateurInvalideException("Nom trop long (max 50 caractères)");
        }
        return true;
    }

    public boolean validerEmail(String email) throws UtilisateurInvalideException {
        if (email == null || email.trim().isEmpty()) {
            throw new UtilisateurInvalideException("Email requis");
        }
        if (!PATTERN_EMAIL.matcher(email).matches()) {
            throw new UtilisateurInvalideException("Format email invalide: " + email);
        }
        return true;
    }


    public Validateur<Livre> validateurLivre() {
        return this::validerLivre;
    }

    public Validateur<Utilisateur> validateurUtilisateur() {
        return this::validerUtilisateur;
    }
}
