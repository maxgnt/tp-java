package com.isitech.bibliotheque;

import javax.swing.*;
import java.awt.*;

public class InterfaceBiblio {

    private JFrame frame;
    private JButton btnLivres;
    private JButton btnUtilisateurs;
    private JButton btnEmprunts;
    private JLabel statusLabel;

    public InterfaceBiblio() {

        frame = new JFrame("Bibliothèque ISITECH");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());


        JLabel titreLabel = new JLabel("Gestion de Bibliothèque", SwingConstants.CENTER);
        titreLabel.setFont(new Font("Arial", Font.BOLD, 22));
        frame.add(titreLabel, BorderLayout.NORTH);


        JPanel panelBoutons = new JPanel();
        panelBoutons.setLayout(new GridLayout(3, 1, 10, 10));

        btnLivres = new JButton("Gestion des Livres");
        btnUtilisateurs = new JButton("Gestion des Utilisateurs");
        btnEmprunts = new JButton("Gestion des Emprunts");

        panelBoutons.add(btnLivres);
        panelBoutons.add(btnUtilisateurs);
        panelBoutons.add(btnEmprunts);

        frame.add(panelBoutons, BorderLayout.CENTER);


        statusLabel = new JLabel("Bienvenue dans la bibliothèque");
        frame.add(statusLabel, BorderLayout.SOUTH);


        btnLivres.addActionListener(e -> new FenetreLivres());
        btnUtilisateurs.addActionListener(e -> new FenetreUtilisateurs());
        btnEmprunts.addActionListener(e -> new FenetreEmprunts());



        frame.setVisible(true);
    }

    private void setStatus(String message) {
        statusLabel.setText(message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InterfaceBiblio::new);
    }
}
