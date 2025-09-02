# TP Java - Gestion de Bibliothèque

##  Présentation
Ce projet a été réalisé dans le cadre de mon TP en Java (POO).  
L’objectif est de créer une application console qui gère une bibliothèque : livres, utilisateurs et emprunts.

##  Structure du projet
- `models` : contient les classes principales (`Utilisateur`, `Etudiant`, `Professeur`, `Personnel`, `Livre`, `Emprunt`).
- `services` : logique métier (gestion des emprunts, gestion de la bibliothèque).
- `exceptions` : exceptions personnalisées.
- `interfaces` : interfaces utiles (Empruntable, Validateur...).
- `utils` : classes utilitaires.
- `Main.java` : point d’entrée de l’application (menu console).

##  Fonctionnalités
- Ajouter, rechercher et supprimer des livres.
- Ajouter des utilisateurs (étudiants, professeurs, personnel).
- Gérer les emprunts et les retours de livres.
- Vérifier les droits et limitations des utilisateurs.
- Afficher des statistiques de la bibliothèque.

##  Lancement
Depuis IntelliJ :  
- Clic droit sur `Main.java` → **Run 'Main.main()'**

Ou en ligne de commande :  
```bash
javac src/com/isitech/bibliotheque/**/*.java
java com.isitech.bibliotheque.Main
