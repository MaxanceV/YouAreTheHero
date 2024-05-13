package InterfaceGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InterfaceGame extends JFrame {
	private static final long serialVersionUID = UniqueIdGenerator.generateUniqueIdLong();
	private CardLayout cardLayout;
    private JPanel cardPanel; // Panel qui contient les différents "écrans" du jeu

    public InterfaceGame() {
        setTitle("Jeu d'Aventure");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        initMenu();
        initCharacterCreationUI();
        initGameUI(); // Méthode pour initialiser l'UI du jeu

        add(cardPanel);
    }

    private void initMenu() {
        JPanel menuPanel = new JPanel(new GridLayout(2, 1, 10, 10)); // Utilisez GridLayout pour organiser les boutons
        JButton btnNewGame = new JButton("Nouvelle Partie");
        JButton btnContinue = new JButton("Continuer");

        btnNewGame.addActionListener(this::handleNewGame);
        btnContinue.addActionListener(this::handleContinueGame);

        menuPanel.add(btnNewGame);
        menuPanel.add(btnContinue);

        cardPanel.add(menuPanel, "Menu");
    }

    private void initGameUI() {
        JPanel gamePanel = new JPanel();
        gamePanel.add(new JLabel("Interface de jeu ici"));

        // Ajoutez d'autres composants à gamePanel selon vos besoins

        cardPanel.add(gamePanel, "Game");
    }
    
    private void initCharacterCreationUI() {
        JPanel characterCreationPanel = new JPanel(new GridLayout(5, 1, 10, 10)); // 5 lignes pour le nom, la race, la classe, le bouton

        // Nom du personnage
        characterCreationPanel.add(new JLabel("Entrez votre nom :"));
        JTextField nameField = new JTextField();
        characterCreationPanel.add(nameField);

        // Sélection de la race
        characterCreationPanel.add(new JLabel("Choisissez une race :"));
        JComboBox<String> raceBox = new JComboBox<>(new String[]{"Humain", "Nain"});
        characterCreationPanel.add(raceBox);

        // Sélection de la classe
        characterCreationPanel.add(new JLabel("Choisissez une classe :"));
        JComboBox<String> classBox = new JComboBox<>(new String[]{"Guerrier", "Mage"});
        characterCreationPanel.add(classBox);

        // Bouton de confirmation
        JButton confirmButton = new JButton("Confirmer");
        confirmButton.addActionListener(e -> {
            String name = nameField.getText();
            String race = (String) raceBox.getSelectedItem();
            String classe = (String) classBox.getSelectedItem();
            // Logique pour créer le personnage
            System.out.println("Création de : " + name + ", Race : " + race + ", Classe : " + classe);
            // Peut-être revenir au jeu ou passer à l'écran suivant
            cardLayout.show(cardPanel, "Game");
        });
        characterCreationPanel.add(confirmButton);

        cardPanel.add(characterCreationPanel, "CharacterCreation");
    }


    private void handleNewGame(ActionEvent e) {
        cardLayout.show(cardPanel, "CharacterCreation");
        // Logique pour démarrer une nouvelle partie
    }

    private void handleContinueGame(ActionEvent e) {
        cardLayout.show(cardPanel, "Game");
        // Logique pour charger et continuer une partie existante
    }
}