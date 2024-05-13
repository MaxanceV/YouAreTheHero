package InterfaceGame;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfaceGame extends JFrame {
	private static final long serialVersionUID = UniqueIdGenerator.generateUniqueIdLong();
	private CardLayout cardLayout;
    private JPanel cardPanel; // Panel qui contient les différents "écrans" du jeu

    public InterfaceGame() {
        setTitle("You are the Hero");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        initMenu();
        initGameUI(); // Méthode pour initialiser l'UI du jeu
        
        CharacterCreationPanel characterCreationPanel = new CharacterCreationPanel(cardLayout, cardPanel);
        cardPanel.add(characterCreationPanel, "CharacterCreation");

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
    
    private void handleNewGame(ActionEvent e) {
        cardLayout.show(cardPanel, "CharacterCreation");
        // Logique pour démarrer une nouvelle partie
    }

    private void handleContinueGame(ActionEvent e) {
        cardLayout.show(cardPanel, "Game");
        // Logique pour charger et continuer une partie existante
    }
}