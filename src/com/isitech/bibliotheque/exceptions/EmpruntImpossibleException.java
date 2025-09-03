package com.isitech.bibliotheque.exceptions;

public class EmpruntImpossibleException extends BibliothequeException {
    public EmpruntImpossibleException(String message) {
        super("Impossible d'effectuer l'emprunt : " + message);
    }
}
