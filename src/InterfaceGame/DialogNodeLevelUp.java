package InterfaceGame;

import java.awt.BorderLayout;
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
import Representation.node.TNodeLevelUp;
import Univers.TPlayer;

public class DialogNodeLevelUp extends JDialog implements IDialog {
    private static final long serialVersionUID = 1L;
    private JButton actionButton;

    public DialogNodeLevelUp(JFrame parent, TPlayer joueur, TNodeLevelUp node) {
        super(parent, "You Are The Hero", true);  // true pour rendre le dialogue modal
        
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

        // Panel pour le bouton d'action
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        actionPanel.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(), "Action"));
        actionButton = new JButton("Monter de rang");
        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                joueur.levelUp();
                descriptionLabel.setText("Félicitations ! Vous êtes devenu " + joueur.getClasse().getDescription() + " ! ");
                actionButton.setText("Continuer");
                actionButton.removeActionListener(this);
                actionButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        MainGame.nextNode(getDialog(), node.getChoix()[0].getId());
                    }
                });
            }
        });
        actionPanel.add(actionButton);

        // Créer un panel principal pour contenir l'image de fond, la description et l'action
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);
        mainPanel.add(backgroundLabel, BorderLayout.CENTER);

        // Panel pour contenir la description et l'action
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);
        bottomPanel.add(descriptionPanel, BorderLayout.NORTH);
        bottomPanel.add(actionPanel, BorderLayout.CENTER);

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
