package com.isitech.bibliotheque;

import java.util.Scanner;

public class Main {
    private static Bibliotheque bibliotheque = new Bibliotheque("Bibliothèque ISITECH");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(" Bienvenue dans le système de gestion de bibliothèque");


        initialiserDonneesTest();


        boolean continuer = true;
        while (continuer) {
            afficherMenu();
            int choix = lireChoix();
            continuer = traiterChoix(choix);
        }

        System.out.println("Au revoir !");
        scanner.close();
    }


    private static void initialiserDonneesTest() {
        bibliotheque.ajouterLivre(new Livre("Clean Code", "Robert Martin", "978-0132350884"));
        bibliotheque.ajouterLivre(new Livre("Design Patterns", "Gang of Four", "978-0201633612"));
        bibliotheque.ajouterLivre(new Livre("Refactoring", "Martin Fowler", "978-0201485677"));
        bibliotheque.ajouterLivre(new Livre("Effective Java", "Joshua Bloch", "978-0134685991"));
        bibliotheque.ajouterLivre(new Livre("Domain-Driven Design", "Eric Evans", "978-0321125217"));
    }


    private static void afficherMenu() {
        System.out.println("\n === MENU PRINCIPAL ===");
        System.out.println("1. Afficher le catalogue");
        System.out.println("2. Ajouter un livre");
        System.out.println("3. Rechercher un livre");
        System.out.println("4. Supprimer un livre");
        System.out.println("5. Afficher les statistiques");
        System.out.println("0. Quitter");
        System.out.print("Votre choix: ");
    }


    private static int lireChoix() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }


    private static boolean traiterChoix(int choix) {
        scanner.nextLine();

        switch (choix) {
            case 1:
                bibliotheque.afficherCatalogue();
                break;
            case 2:
                ajouterNouveauLivre();
                break;
            case 3:
                rechercherLivre();
                break;
            case 4:
                supprimerLivre();
                break;
            case 5:
                bibliotheque.afficherStatistiques();
                break;
            case 0:
                return false;
            default:
                System.out.println(" Choix invalide!");
        }
        return true;
    }

    /
    private static void ajouterNouveauLivre() {
        System.out.println("\n === AJOUT D'UN LIVRE ===");

        System.out.print("Titre: ");
        String titre = scanner.nextLine();

        System.out.print("Auteur: ");
        String auteur = scanner.nextLine();

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Livre livre = new Livre(titre, auteur, isbn);
        bibliotheque.ajouterLivre(livre);

        System.out.println(" Livre ajouté avec succès!");
    }


    private static void rechercherLivre() {
        System.out.println("\n🔍 === RECHERCHE DE LIVRE ===");
        System.out.println("1. Par titre");
        System.out.println("2. Par auteur");
        System.out.println("3. Par ISBN");
        System.out.print("Type de recherche: ");

        int type = lireChoix();
        scanner.nextLine();

        Livre livre = null;
        switch (type) {
            case 1:
                System.out.print("Titre à rechercher: ");
                String titre = scanner.nextLine();
                livre = bibliotheque.rechercherParTitre(titre);
                break;
            case 2:
                System.out.print("Auteur à rechercher: ");
                String auteur = scanner.nextLine();
                livre = bibliotheque.rechercherParAuteur(auteur);
                break;
            case 3:
                System.out.print("ISBN à rechercher: ");
                String isbn = scanner.nextLine();
                livre = bibliotheque.rechercherParISBN(isbn);
                break;
            default:
                System.out.println(" Type de recherche invalide!");
                return;
        }

        if (livre != null) {
            System.out.println("📖 Livre trouvé: " + livre);
        } else {
            System.out.println(" Aucun livre trouvé.");
        }
    }

    // Suppression d’un livre
    private static void supprimerLivre() {
        System.out.println("\n === SUPPRESSION D'UN LIVRE ===");
        System.out.print("ISBN du livre à supprimer: ");
        String isbn = scanner.nextLine();

        if (bibliotheque.supprimerLivre(isbn)) {
            System.out.println(" Livre supprimé avec succès!");
        } else {
            System.out.println(" Livre non trouvé.");
        }
    }
}
