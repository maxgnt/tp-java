package com.isitech.bibliotheque.exceptions;

public class LivreIntrouvableException extends BibliothequeException {
    public LivreIntrouvableException(String isbn) {
        super("Livre introuvable avec l'ISBN : " + isbn);
    }
}
