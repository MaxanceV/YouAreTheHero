package InterfaceGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import MainLaunch.MainGame;
import Representation.node.ANodeInner;
import Representation.node.TNodeTerminal;
import Univers.TPlayer;

public class NodeTerminalDialog extends JDialog {
    private static final long serialVersionUID = 1L;

    public NodeTerminalDialog(JFrame parent, TPlayer joueur, TNodeTerminal tNodeTerminal) {
        super(parent, "You Are The Hero", true);  // true pour rendre le dialogue modal
        setSize(800, 600);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        // Déterminer l'apparence en fonction de la description
        String description = tNodeTerminal.getDescription();
        JLabel descriptionLabel = new JLabel(description, JLabel.CENTER);
        descriptionLabel.setFont(new Font("Serif", Font.BOLD, 48));

        if ("Game Over".equals(description)) {
            getContentPane().setBackground(Color.BLACK);
            descriptionLabel.setForeground(Color.RED);
        } else if ("Victoire".equals(description)) {
            getContentPane().setBackground(Color.WHITE);
            descriptionLabel.setForeground(Color.YELLOW);
        } else {
            // Définir des valeurs par défaut si nécessaire
            getContentPane().setBackground(Color.LIGHT_GRAY);
            descriptionLabel.setForeground(Color.BLACK);
        }

        // Ajouter la description au centre
        add(descriptionLabel, BorderLayout.CENTER);

        // Panel pour les boutons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);  // Rendre transparent pour montrer l'image de fond

        JButton mainMenuButton = new JButton("Retourner au Menu principal");
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	MainGame.OpenMainMenu();
                dispose();
            }
        });

        JButton quitButton = new JButton("Quitter");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGame.quit();
                dispose();
            }
        });

        buttonPanel.add(mainMenuButton);
        buttonPanel.add(quitButton);

        // Ajouter le panel des boutons en bas du dialog
        add(buttonPanel, BorderLayout.SOUTH);
    }
}

