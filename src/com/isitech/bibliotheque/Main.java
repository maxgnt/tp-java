package com.isitech.bibliotheque;

import com.isitech.bibliotheque.models.*;
import com.isitech.bibliotheque.services.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        BibliothequeService biblio = new BibliothequeService();
        GestionnaireEmprunts gestionEmprunts = new GestionnaireEmprunts();


        Livre l1 = new Livre("978-0132350884", "Clean Code", "Robert C. Martin", 464, "Prentice Hall", LocalDate.of(2008, 8, 1));
        Livre l2 = new Livre("978-0201633612", "Design Patterns", "Gang of Four", 395, "Addison-Wesley", LocalDate.of(1994, 10, 21));

        biblio.ajouterLivre(l1);
        biblio.ajouterLivre(l2);


        Etudiant e1 = new Etudiant("Alice", "alice@mail.com", "E123", "L3", "Informatique");
        Professeur p1 = new Professeur("Dupont", "dupont@mail.com", "Informatique", true);


        biblio.afficherCatalogue();


        gestionEmprunts.emprunterLivre(e1, l1);

        gestionEmprunts.emprunterLivre(p1, l1);

        gestionEmprunts.retournerLivre(e1, l1);

        gestionEmprunts.emprunterLivre(p1, l1);

        gestionEmprunts.afficherEmprunts();
    }
}
