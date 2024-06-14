package InterfaceGame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.MainGame;
import Representation.node.ANode;
import Representation.node.ANodeInner;
import Univers.TPlayer;

public class NodeDecisionDialog extends JDialog {
    private static final long serialVersionUID = 1L;

    public NodeDecisionDialog(JFrame parent, TPlayer joueur, ANodeInner node) {
        super(parent, "Node Interaction", true);  // true pour rendre le dialogue modal
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Panel pour la description
        JPanel descriptionPanel = new JPanel(new BorderLayout());
        JLabel descriptionLabel = new JLabel("<html>" + node.getDescription() + "</html>");
        descriptionPanel.add(descriptionLabel, BorderLayout.CENTER);
        add(descriptionPanel, BorderLayout.NORTH);

        // Panel pour les choix
        JPanel choicesPanel = new JPanel(new GridLayout(0, 1));
        ANode[] choices = node.getChoix();
        for (ANode choice : choices) {
            JButton choiceButton = new JButton(choice.getDescriptionChoix());
            choiceButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    node.chooseNext(choice.getId());;
                    dispose();
                }
            });
            choicesPanel.add(choiceButton);
        }
        add(choicesPanel, BorderLayout.CENTER);

        // Panel pour les points de vie du joueur
        JPanel playerPanel = new JPanel(new BorderLayout());
        JLabel playerHealthLabel = new JLabel("Points de Vie: " + joueur.getPointVie());
        playerPanel.add(playerHealthLabel, BorderLayout.CENTER);
        add(playerPanel, BorderLayout.SOUTH);
    }
}
