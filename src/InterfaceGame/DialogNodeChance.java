package InterfaceGame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import MainLaunch.MainGame;
import Representation.node.ANode;
import Representation.node.TNodeChance;
import Univers.TPlayer;

public class DialogNodeChance extends JDialog implements IDialog {
    private static final long serialVersionUID = 1L;
    private JButton[] choiceButtons;
    private Random random;

    public DialogNodeChance(JFrame parent, TPlayer joueur, TNodeChance node) {
        super(parent, "You Are The Hero", true);  // true pour rendre le dialogue modal
        random = new Random();
        
        // Panel principal avec l'image de fond
        JLabel backgroundLabel = CreatorToolDialog.createBackgroundLabel(node);
        backgroundLabel.setLayout(new BorderLayout());

        // Ajouter le settingsPanel au haut du backgroundLabel
        backgroundLabel.add(CreatorToolDialog.getSettingButton(this), BorderLayout.NORTH);

        // Panel pour la description du nœud
        JPanel descriptionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        descriptionPanel.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(), "Description"));
        JLabel descriptionLabel = new JLabel("<html>" + CreatorToolDialog.stringDescriptionNodeFormat(node.getDescription()) + "</html>");
        descriptionPanel.add(descriptionLabel);

        // Panel pour les choix du joueur
        JPanel choicesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        choicesPanel.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(), "Choix"));
        ANode[] choices = node.getChoix();
        choiceButtons = new JButton[choices.length];

        // Désactiver initialement les boutons de choix
        for (int i = 0; i < choices.length; i++) {
            choiceButtons[i] = new JButton(choices[i].getDescriptionChoix());
            choiceButtons[i].setEnabled(false);  // Désactiver les boutons de choix
            final int index = i;
            choiceButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MainGame.nextNode(getDialog(), choices[index].getId());
                }
            });
            choicesPanel.add(choiceButtons[i]);
        }

        // Bouton pour tenter sa chance
        JButton chanceButton = new JButton("Tenter votre chance");
        chanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int chosenIndex = random.nextInt(choices.length);
                for (int i = 0; i < choiceButtons.length; i++) {
                    choiceButtons[i].setEnabled(i == chosenIndex);  // Activer un bouton aléatoire
                }
                chanceButton.setEnabled(false);
            }
        });

        // Panel pour contenir le bouton "Tenter sa chance" et les choix
        JPanel chancePanel = new JPanel(new BorderLayout());
        chancePanel.add(chanceButton, BorderLayout.CENTER);
        chancePanel.add(choicesPanel, BorderLayout.SOUTH);

        // Créer un panel principal pour contenir l'image de fond, la description et les choix
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);
        mainPanel.add(backgroundLabel, BorderLayout.CENTER);

        // Panel pour contenir la description et les choix
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);
        bottomPanel.add(descriptionPanel, BorderLayout.NORTH);
        bottomPanel.add(chancePanel, BorderLayout.CENTER);

        // Ajouter le bottomPanel au sud du mainPanel
        add(mainPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
    }
    
	@Override
	public JDialog getDialog() {
		return this;
	}
}
