package com.isitech.bibliotheque;

import javax.swing.*;
import java.awt.*;

public class FenetreUtilisateurs {
    private JFrame frame;

    public FenetreUtilisateurs() {
        frame = new JFrame("Gestion des Utilisateurs");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] colonnes = {"ID", "Nom", "Email", "Type"};
        Object[][] donnees = {
                {"U1", "Alice", "alice@mail.com", "Étudiant"},
                {"U2", "Dupont", "dupont@mail.com", "Professeur"}
        };

        JTable tableUsers = new JTable(donnees, colonnes);
        JScrollPane scrollPane = new JScrollPane(tableUsers);

        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
