package com.isitech.bibliotheque;

import javax.swing.*;
import java.awt.*;

public class FenetreLivres {
    private JFrame frame;

    public FenetreLivres() {
        frame = new JFrame("Gestion des Livres");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        String[] colonnes = {"ISBN", "Titre", "Auteur", "Disponible"};
        Object[][] donnees = {
                {"978-0132350884", "Clean Code", "Robert C. Martin", "Oui"},
                {"978-0201633612", "Design Patterns", "Gang of Four", "Non"}
        };

        JTable tableLivres = new JTable(donnees, colonnes);
        JScrollPane scrollPane = new JScrollPane(tableLivres);

        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
