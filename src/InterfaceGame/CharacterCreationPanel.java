// CharacterCreationPanel.java

package InterfaceGame;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Univers.TPersonnage;
import Univers.classe.AClasseGuerrier;
import Univers.classe.AClasseMage;
import Univers.classe.IClasse;
import Univers.race.ERace;

public class CharacterCreationPanel extends JPanel {
	private static final long serialVersionUID = UniqueIdGenerator.generateUniqueIdLong();

	public CharacterCreationPanel(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(new GridLayout(5, 1, 10, 10));

        // Nom du personnage
        add(new JLabel("Entrez votre nom :"));
        JTextField nameField = new JTextField();
        add(nameField);

        // Sélection de la race
        add(new JLabel("Choisissez une race :"));
        JComboBox<String> raceBox = new JComboBox<>(new String[]{"Humain", "Nain"});
        add(raceBox);

        // Sélection de la classe
        add(new JLabel("Choisissez une classe :"));
        JComboBox<String> classBox = new JComboBox<>(new String[]{"Guerrier", "Mage"});
        add(classBox);

        // Bouton de confirmation
        JButton confirmButton = new JButton("Confirmer");
        confirmButton.addActionListener(e -> {
            ERace raceJoueur = raceBox.getSelectedItem().equals("Humain") ? ERace.HUMAIN : ERace.NAIN;
            IClasse classeJoueur = classBox.getSelectedItem().equals("Guerrier") ? new AClasseGuerrier() : new AClasseMage();
            TPersonnage joueur = new TPersonnage(nameField.getText(), classeJoueur, raceJoueur);
            System.out.println("Création de : " + joueur.getNom() + ", Race : " + joueur.getRace().getDescription() + ", Classe : " + joueur.getClasse().getDescription());
            cardLayout.show(cardPanel, "Game");
        });
        add(confirmButton);
    }
}
