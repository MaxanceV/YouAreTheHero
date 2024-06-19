package InterfaceGame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;

import MainLaunch.MainGame;

public class DialogMainMenu extends JDialog {

    private static final long serialVersionUID = 1L;

    public DialogMainMenu(JFrame parent) {
        super(parent, "Menu Principal", true);  // true pour rendre le dialogue modal
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setupMenu(parent);
    }

    private void setupMenu(JFrame parent) {
        // Chargement de l'image
        JLabel imageLabel = CreatorToolDialog.createBackgroundLabel("images/"+"YouAreTheHero2.png");
        setIconImage(CreatorToolDialog.getIconOfDialog());

        // Boutons du menu
        JButton btnNewGame = new JButton("Nouvelle partie");
        JButton btnLoadGame = new JButton("Charger une partie");
        JButton btnQuit = new JButton("Quitter le jeu");

        // Listeners pour les boutons
        btnNewGame.addActionListener(e -> onMenuSelected(0));
        btnLoadGame.addActionListener(e -> onMenuSelected(1));
        btnQuit.addActionListener(e -> onMenuSelected(2));

        // Panneau pour les boutons, utilisant FlowLayout pour l'alignement horizontal
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnNewGame);
        buttonPanel.add(btnLoadGame);
        buttonPanel.add(btnQuit);

        // Ajout des composants au dialogue
        setLayout(new BorderLayout());
        add(imageLabel, BorderLayout.NORTH); // Ajoute l'image au nord
        add(buttonPanel, BorderLayout.CENTER); // Ajoute les boutons au centre

        pack();
        setLocationRelativeTo(parent);
    }

    private void onMenuSelected(int choice) {
        switch (choice) {
            case 0: // Nouvelle Partie
                MainGame.createCharacter(this);
                break;
            case 1: // Charger Partie
                MainGame.loadCharacter(this);
                break;
            case 2:
                MainGame.quit(this);
                break;
        }
    }

    public JDialog getDialog() {
        return this;
    }
}
