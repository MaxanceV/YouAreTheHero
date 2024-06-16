package InterfaceGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
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

public class DialogNodeTerminal extends JDialog {
    private static final long serialVersionUID = 1L;

    public DialogNodeTerminal(JFrame parent, TPlayer joueur, TNodeTerminal tNodeTerminal) {
        super(parent, "You Are The Hero", true);  // true pour rendre le dialogue modal

        // Déterminer l'apparence en fonction de la description
        String id = tNodeTerminal.getId();
        String description = tNodeTerminal.getDescription();

        JLabel mainLabel = new JLabel("", JLabel.CENTER);
        mainLabel.setFont(new Font("Serif", Font.BOLD, 48));

        if (id.contains("defaite")) {
            mainLabel.setText("DEFAITE");
            mainLabel.setForeground(Color.RED);
            getContentPane().setBackground(Color.BLACK);
        } else if (id.contains("victoire")) {
            mainLabel.setText("VICTOIRE");
            mainLabel.setForeground(Color.YELLOW);
            getContentPane().setBackground(Color.WHITE);
        } else {
            mainLabel.setText("FIN");
            mainLabel.setForeground(Color.BLACK);
            getContentPane().setBackground(Color.LIGHT_GRAY);
        }

        // Ajouter le mainLabel en haut
        JPanel mainLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainLabelPanel.add(mainLabel);
        mainLabelPanel.setOpaque(false);

        // Panel pour la description du nœud
        JPanel descriptionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        descriptionPanel.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(), "Description"));
        JLabel descriptionLabel = new JLabel("<html>" + InterfaceCreatorTool.stringDescriptionNodeFormat(description) + "</html>");
        descriptionPanel.add(descriptionLabel);

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
                MainGame.quit(getDialog());
                dispose();
            }
        });

        buttonPanel.add(mainMenuButton);
        buttonPanel.add(quitButton);

        // Ajouter les panels au dialog
        setLayout(new BorderLayout());
        add(mainLabelPanel, BorderLayout.NORTH);
        add(descriptionPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(parent);
    }

    protected JDialog getDialog() {
        return this;
    }
}

