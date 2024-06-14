package InterfaceGame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import MainLaunch.MainGame;
import Representation.node.ANode;
import Representation.node.ANodeInner;
import Univers.TPlayer;

public class NodeDecisionDialog extends JDialog {
    private static final long serialVersionUID = 1L;

    public NodeDecisionDialog(JFrame parent, TPlayer joueur, ANodeInner node) {
        super(parent, "You Are The Hero", true);  // true pour rendre le dialogue modal
        setSize(800, 600);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        // Chargement des images
        ImageIcon settingsIcon = new ImageIcon(getClass().getClassLoader().getResource(InterfaceCreatorTool.SETTING_ICON));
        ImageIcon backgroundIcon = new ImageIcon(getClass().getClassLoader().getResource("images/decore.png"));

//        // Vérifier si les images sont correctement chargées
//        if (settingsIcon.getImageLoadStatus() != java.awt.MediaTracker.COMPLETE) {
//            throw new RuntimeException("Failed to load image: images/setting.png");
//        }
//        if (backgroundIcon.getImageLoadStatus() != java.awt.MediaTracker.COMPLETE) {
//            throw new RuntimeException("Failed to load image: images/decore.png");
//        }

        // Panel principal avec l'image de fond
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new BorderLayout());

        // Panel pour l'icône des paramètres
        JPanel settingsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        settingsPanel.setOpaque(false);
        JButton settingsButton = new JButton(settingsIcon);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBorderPainted(false);
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGame.startOptionsDialog(NodeDecisionDialog.this);
            }
        });
        settingsPanel.add(settingsButton);

        // Ajouter le settingsPanel au haut du backgroundLabel
        backgroundLabel.add(settingsPanel, BorderLayout.NORTH);

        // Panel pour la description du nœud
        JPanel descriptionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        descriptionPanel.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(), "Description"));
        JLabel descriptionLabel = new JLabel("<html>" + InterfaceCreatorTool.stringDescriptionNodeFormat(node.getDescription()) + "</html>");
        descriptionPanel.add(descriptionLabel);

        // Panel pour les choix du joueur
        JPanel choicesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        choicesPanel.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(), "Choix"));
        ANode[] choices = node.getChoix();
        for (ANode choice : choices) {
            JButton choiceButton = new JButton(choice.getDescriptionChoix());
            choiceButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MainGame.nextNode(choice.getId());
                    dispose();
                }
            });
            choicesPanel.add(choiceButton);
        }

        // Créer un panel principal pour contenir l'image de fond, la description et les choix
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);
        mainPanel.add(backgroundLabel, BorderLayout.CENTER);

        // Panel pour contenir la description et les choix
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);
        bottomPanel.add(descriptionPanel, BorderLayout.NORTH);
        bottomPanel.add(choicesPanel, BorderLayout.CENTER);

        // Ajouter le bottomPanel au sud du mainPanel
        add(mainPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}