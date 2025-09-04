package com.isitech.bibliotheque;

import javax.swing.*;
import java.awt.*;

public class FenetreEmprunts {
    private JFrame frame;

    public FenetreEmprunts() {
        frame = new JFrame("Gestion des Emprunts");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] colonnes = {"Livre", "Utilisateur", "Date Emprunt", "Retour prévu"};
        Object[][] donnees = {
                {"Clean Code", "Alice", "03/09/2025", "18/09/2025"},
                {"Design Patterns", "Dupont", "03/09/2025", "03/10/2025"}
        };

        JTable tableEmprunts = new JTable(donnees, colonnes);
        JScrollPane scrollPane = new JScrollPane(tableEmprunts);

        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
