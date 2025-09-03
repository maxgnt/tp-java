package com.isitech.bibliotheque.services;

import com.isitech.bibliotheque.models.Utilisateur;
import com.isitech.bibliotheque.models.Livre;
import com.isitech.bibliotheque.models.Emprunt;


import java.util.ArrayList;
import java.util.List;

public class GestionnaireEmprunts {
    private List<Emprunt> emprunts;

    public GestionnaireEmprunts() {
        this.emprunts = new ArrayList<>();
    }


    public boolean emprunterLivre(Utilisateur utilisateur, Livre livre) {
        if (!utilisateur.peutEmprunter()) {
            System.out.println(" L'utilisateur a atteint son quota d'emprunts.");
            return false;
        }
        if (!livre.isDisponible()) {
            System.out.println(" Le livre n'est pas disponible.");
            return false;
        }
        if (!utilisateur.peutEmprunterType(livre)) {
            System.out.println(" Cet utilisateur ne peut pas emprunter ce type de livre.");
            return false;
        }

        livre.emprunter();
        utilisateur.incrementerEmprunts();
        Emprunt emprunt = new Emprunt(utilisateur, livre, utilisateur.getDureeEmpruntMax());
        emprunts.add(emprunt);

        System.out.println(" Emprunt réussi : " + emprunt);
        return true;
    }


    public boolean retournerLivre(Utilisateur utilisateur, Livre livre) {
        for (Emprunt e : emprunts) {
            if (e.getLivre().equals(livre) && e.getUtilisateur().equals(utilisateur) && e.getDateRetourReelle() == null) {
                e.retourner();
                System.out.println(" Livre retourné : " + livre.getTitre());
                return true;
            }
        }
        System.out.println(" Aucun emprunt trouvé pour ce livre/utilisateur.");
        return false;
    }


    public void afficherEmprunts() {
        System.out.println("\n=== Emprunts en cours ===");
        for (Emprunt e : emprunts) {
            if (e.getDateRetourReelle() == null) {
                System.out.println(e);
            }
        }
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }
}
