package InterfaceGame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MainLaunch.MainGame;

public class DialogOptions extends JDialog {
    private static final long serialVersionUID = 1L;

    public DialogOptions(JFrame parent, JDialog jDialog) {
        super(parent, "Options", true);  // true pour rendre le dialogue modal
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setIconImage(CreatorToolDialog.getIconOfDialog());

        // Label pour informer de la sauvegarde automatique
        JLabel autoSaveLabel = new JLabel("Votre partie est sauvegardée automatiquement.");
        autoSaveLabel.setHorizontalAlignment(JLabel.CENTER);  // Centre le texte
        
        // Panel pour les boutons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton mainMenuButton = new JButton("Retourner au Menu principal");
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();
                MainGame.OpenMainMenu(getDialog());
            }
        });

        JButton quitButton = new JButton("Quitter le jeu");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jDialog.dispose();
                MainGame.quit(getDialog());
            }
        });

        JButton returnButton = new JButton("Retour");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonPanel.add(mainMenuButton);
        buttonPanel.add(quitButton);
        buttonPanel.add(returnButton);

        // Ajouter les éléments au dialog
        add(autoSaveLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        
        pack();
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());
    }

    public JDialog getDialog() {
        return this;
    }
}
