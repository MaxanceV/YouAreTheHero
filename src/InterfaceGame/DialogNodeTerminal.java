package InterfaceGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import MainLaunch.MainGame;
import Representation.node.TNodeTerminal;
import Univers.TPlayer;

public class DialogNodeTerminal extends JDialog  {
    private static final long serialVersionUID = 1L;

    public DialogNodeTerminal(JFrame parent, TPlayer joueur, TNodeTerminal tNodeTerminal) {
        super(parent, "You Are The Hero", true);  // true pour rendre le dialogue modal
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        // Déterminer l'apparence en fonction de la description
        String id = tNodeTerminal.getId();
        String description = tNodeTerminal.getDescription();

        JLabel mainLabel = new JLabel("", JLabel.CENTER);
        mainLabel.setFont(new Font("Serif", Font.BOLD, 48));

        if (id.contains("defaite")) {
            mainLabel.setText("DEFAITE");
            mainLabel.setForeground(Color.RED);
        } else if (id.contains("victoire")) {
            mainLabel.setText("VICTOIRE");
            mainLabel.setForeground(Color.YELLOW);
        } else {
            mainLabel.setText("FIN");
            mainLabel.setForeground(Color.BLACK);
        }

        // Panel principal avec l'image de fond
        JLabel backgroundLabel = CreatorToolDialog.createBackgroundLabel(tNodeTerminal);
        backgroundLabel.setLayout(new BorderLayout());

    	// Ajouter le settingsPanel au haut du backgroundLabel
        backgroundLabel.add(CreatorToolDialog.getSettingsAndStatsButtons(this, joueur), BorderLayout.EAST);

        // Panel pour le label principal
        JPanel mainLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainLabelPanel.add(mainLabel);
        mainLabelPanel.setOpaque(false);
        backgroundLabel.add(mainLabelPanel, BorderLayout.CENTER);

        // Panel pour la description du nœud
        JPanel descriptionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        descriptionPanel.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(), "Description"));
        JLabel descriptionLabel = new JLabel("<html>" + CreatorToolDialog.stringDescriptionNodeFormat(description) + "</html>");
        descriptionPanel.add(descriptionLabel);
        backgroundLabel.add(descriptionPanel, BorderLayout.SOUTH);

        // Panel pour les boutons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);  // Rendre transparent pour montrer l'image de fond

        JButton mainMenuButton = new JButton("Retourner au Menu principal");
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGame.OpenMainMenu(getDialog());
            }
        });

        JButton quitButton = new JButton("Quitter");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGame.quit(getDialog());
                dispose();
            }
        });

        buttonPanel.add(mainMenuButton);
        buttonPanel.add(quitButton);

        // Créer un panel principal pour contenir l'image de fond, la description et les choix
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);
        mainPanel.add(backgroundLabel, BorderLayout.CENTER);

        // Panel pour contenir la description et les choix
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);
        bottomPanel.add(descriptionPanel, BorderLayout.NORTH);
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        // Ajouter les panels au dialog
        add(mainPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(parent);
    }
    
    public JDialog getDialog() {
        return this;
    }
}
