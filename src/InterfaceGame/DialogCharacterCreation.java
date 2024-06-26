package InterfaceGame;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import MainLaunch.MainGame;
import Univers.TPlayer;
import Univers.Enum.ERace;
import Univers.classe.AClasseGuerrier;
import Univers.classe.AClasseMage;
import Univers.classe.IClasse;

public class DialogCharacterCreation extends JDialog {
    private static final long serialVersionUID = 1l;
    private TPlayer joueur;

    public DialogCharacterCreation(JFrame parent) {
        super(parent, "Création de Personnage", true);
        setSize(300, 200);
        setLayout(new GridLayout(5, 1));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setIconImage(CreatorToolDialog.getIconOfDialog());

        // Nom du personnage
        add(new JLabel("Entrez votre nom :"));
        JTextField nameField = new JTextField();
        add(nameField);

        // Sélection de la race
        add(new JLabel("Choisissez une race :"));
        JComboBox<String> raceBox = new JComboBox<>(new String[]{"Humain", "Nain","Orc"});
        add(raceBox);

        // Sélection de la classe
        add(new JLabel("Choisissez une classe :"));
        JComboBox<String> classBox = new JComboBox<>(new String[]{"Guerrier", "Mage"});
        add(classBox);
        
        //Bouton de retour
        JButton backToMenuButton = new JButton("Retour");
        add(backToMenuButton);
        backToMenuButton.addActionListener(e -> {
        	MainGame.OpenMainMenu(this);
        });
        
        // Bouton de confirmation
        JButton confirmButton = new JButton("Confirmer");
        confirmButton.setEnabled(false);  // Le bouton est désactivé par défaut
        add(confirmButton);

        // Ajout de document listeners pour le champ de texte du nom
        nameField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                update();
            }
            public void removeUpdate(DocumentEvent e) {
                update();
            }
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            // Méthode pour mettre à jour l'état du bouton
            private void update() {
                confirmButton.setEnabled(
                    !nameField.getText().isEmpty() &&
                    raceBox.getSelectedIndex() != -1 &&
                    classBox.getSelectedIndex() != -1
                );
            }
        });

        // Ajout de action listeners pour les comboboxes
        ActionListener comboBoxListener = e -> {
            confirmButton.setEnabled(
                !nameField.getText().isEmpty() &&
                raceBox.getSelectedIndex() != -1 &&
                classBox.getSelectedIndex() != -1
            );
        };
        raceBox.addActionListener(comboBoxListener);
        classBox.addActionListener(comboBoxListener);

        // Listener du bouton de confirmation
        confirmButton.addActionListener(e -> {
        	
            ERace raceJoueur = ERace.getRaceFromString(raceBox.getSelectedItem().toString());
            IClasse classeJoueur = classBox.getSelectedItem().equals("Guerrier") ? new AClasseGuerrier() : new AClasseMage();
            joueur = new TPlayer(nameField.getText(), classeJoueur, raceJoueur);
            MainGame.playerCreated(joueur);
            dispose();
        });

        setLocationRelativeTo(null);  // Centre le dialogue au milieu de l'écran
    }

	public JDialog getDialog() {
		return this;
	}
}
