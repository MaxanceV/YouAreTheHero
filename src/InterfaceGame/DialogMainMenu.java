package InterfaceGame;

import java.awt.BorderLayout;

import javax.swing.*;

import MainLaunch.MainGame;

public class DialogMainMenu extends JDialog implements IDialog{

	private static final long serialVersionUID = 1L;

    public DialogMainMenu(JFrame parent) {
        super(parent, "Menu Principal", true);  // true pour rendre le dialogue modal
        setupMenu(parent);
    }

    private void setupMenu(JFrame parent) {
        JButton btnNewGame = new JButton("Nouvelle partie");
        JButton btnLoadGame = new JButton("Charger une partie");
        JButton btnQuit = new JButton("Quitter le jeu");
        btnNewGame.addActionListener(e -> onMenuSelected(0));
        btnLoadGame.addActionListener(e -> onMenuSelected(1));
        btnQuit.addActionListener(e -> onMenuSelected(2));
        
        JPanel panel = new JPanel();
        panel.add(btnNewGame);
        panel.add(btnLoadGame);
        panel.add(btnQuit);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        pack();
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
    }

    private void onMenuSelected(int choice) {
    	switch (choice) {
        case 0: // Nouvelle Partie
            MainGame.createCharacter(this);
            break;
        case 1: // Charger Partie
            MainGame.loadCharacter(this);
            break;
        case 2:
        	MainGame.quit(this);
        	break;
    	}
    }

	@Override
	public JDialog getDialog() {
		return this;
	}
}
