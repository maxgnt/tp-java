package com.isitech.bibliotheque.interfaces;

public interface Empruntable {
    boolean isDisponible();
    void emprunter();
    void retourner();
}
