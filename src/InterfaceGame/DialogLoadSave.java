package InterfaceGame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import MainLaunch.MainGame;
import MainLaunch.SaveManager;

public class DialogLoadSave extends JDialog {
    private static final long serialVersionUID = 1L;
    private JComboBox<String> saveBox;
    private JButton validateButton;
    private JButton deleteButton;
    private String selectedSave;

    public DialogLoadSave(JFrame parent) {
        super(parent, "Charger une Sauvegarde", true);  // true pour rendre le dialogue modal
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);


        // Panel pour sélectionner une sauvegarde
        JPanel selectPanel = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Choisir une sauvegarde:");
        saveBox = new JComboBox<>(getSaveFiles());
        saveBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean hasSelection = saveBox.getSelectedIndex() != -1;
                validateButton.setEnabled(hasSelection);
                deleteButton.setEnabled(hasSelection);
            }
        });

        selectPanel.add(label);
        selectPanel.add(saveBox);

        // Panel pour les boutons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton mainMenuButton = new JButton("Retourner au Menu principal");
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGame.OpenMainMenu(getDialog());
            }
        });

        validateButton = new JButton("Valider");
        validateButton.setEnabled(false);  // Désactivé jusqu'à ce qu'une sauvegarde soit sélectionnée
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedSave = (String) saveBox.getSelectedItem();
                if (selectedSave != null) {
                    MainGame.playerLoaded(selectedSave);
                    dispose();
                }
            }
        });

        deleteButton = new JButton("Supprimer la sauvegarde");
        deleteButton.setEnabled(false);  // Désactivé jusqu'à ce qu'une sauvegarde soit sélectionnée
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedSave = (String) saveBox.getSelectedItem();
                if (selectedSave != null) {
                    int confirmation = JOptionPane.showConfirmDialog(
                        DialogLoadSave.this,
                        "Êtes-vous sûr de vouloir supprimer la sauvegarde " + selectedSave + " ?",
                        "Confirmation de suppression",
                        JOptionPane.YES_NO_OPTION
                    );
                    if (confirmation == JOptionPane.YES_OPTION) {
                        SaveManager.deleteSaveOfPlayer(selectedSave);
                        // Mettre à jour la liste des sauvegardes
                        saveBox.setModel(new javax.swing.DefaultComboBoxModel<>(getSaveFiles()));
                        validateButton.setEnabled(false);
                        deleteButton.setEnabled(false);
                    }
                }
            }
        });

        buttonPanel.add(mainMenuButton);
        buttonPanel.add(validateButton);
        buttonPanel.add(deleteButton);

        // Ajouter les panels au dialog
        add(selectPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
    }

    private String[] getSaveFiles() {
        File saveDir = new File("saves");
        if (!saveDir.exists() || !saveDir.isDirectory()) {
            return new String[0];  // Retourne un tableau vide si le dossier n'existe pas ou n'est pas un dossier
        }

        File[] saveFiles = saveDir.listFiles((dir, name) -> name.endsWith("_save.ser"));
        if (saveFiles == null || saveFiles.length == 0) {
            return new String[0];  // Retourne un tableau vide s'il n'y a pas de fichiers de sauvegarde
        }

        String[] saveNames = new String[saveFiles.length];
        for (int i = 0; i < saveFiles.length; i++) {
            String fileName = saveFiles[i].getName();
            saveNames[i] = fileName.substring(0, fileName.indexOf("_save.ser"));
        }
        return saveNames;
    }

    public String getSelectedSave() {
        return selectedSave;
    }

	public JDialog getDialog() {
		return this;
	}
}