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
import Representation.node.ANode;
import Representation.node.TNodeDecision;
import Univers.TPlayer;

public class DialogNodeDecision extends JDialog implements IDialog {
    private static final long serialVersionUID = 1L;

    public DialogNodeDecision(JFrame parent, TPlayer joueur, TNodeDecision node) {
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

        // Panel pour les choix du joueur
        JPanel choicesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        choicesPanel.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(), "Choix"));
        ANode[] choices = node.getChoix();
        for (ANode choice : choices) {
            JButton choiceButton = new JButton(choice.getDescriptionChoix());
            choiceButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MainGame.nextNode(getDialog(), choice.getId());
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

        pack();
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
    }

	@Override
	public JDialog getDialog() {
		return this;
	}
}
