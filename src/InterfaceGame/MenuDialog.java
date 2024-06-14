package InterfaceGame;

import javax.swing.*;

import MainLaunch.MainGame;

public class MenuDialog extends JDialog {

	private static final long serialVersionUID = 1L;

    public MenuDialog(JFrame parent) {
        super(parent, "Menu Principal", true);  // true pour rendre le dialogue modal
        setupMenu();
    }

    private void setupMenu() {
        JButton btnNewGame = new JButton("Nouvelle Partie");
        JButton btnLoadGame = new JButton("Charger Partie");
        btnNewGame.addActionListener(e -> onMenuSelected(0));
        btnLoadGame.addActionListener(e -> onMenuSelected(1));

        JPanel panel = new JPanel();
        panel.add(btnNewGame);
        panel.add(btnLoadGame);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void onMenuSelected(int choice) {
    	switch (choice) {
        case 0: // Nouvelle Partie
            MainGame.createCharacter();
            break;
        case 1: // Charger Partie
            MainGame.loadCharacter();
            break;
    }
    this.dispose();  // Fermer le dialogue après la sélection
    }
}
