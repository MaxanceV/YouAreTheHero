package InterfaceGame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import MainLaunch.MainGame;
import Representation.node.TNodeFight;
import Univers.TPersonnage;
import Univers.TPlayer;
import Univers.Enum.ECompetence;

public class DialogNodeFight extends JDialog implements IDialog {
    private static final long serialVersionUID = 1L;
    private Random random = new Random();
    private JLabel playerHealthLabel;
    private JLabel enemyHealthLabel;
    private JLabel descriptionLabel;
    private JPanel buttonPanel;
    private TPlayer joueur;
    private TPersonnage ennemi;
    private TNodeFight node;
    private ECompetence selectedCompetence;

    public DialogNodeFight(JFrame parent, TPlayer joueur, TNodeFight node) {
        super(parent, "You Are The Hero", true);  // true pour rendre le dialogue modal
        this.joueur = joueur;
        this.ennemi = node.getEnnemi();
        this.node = node;

        // Panel principal avec l'image de fond
        JLabel backgroundLabel = CreatorToolDialog.createBackgroundLabel(node);
        backgroundLabel.setLayout(new BorderLayout());

        // Panel pour afficher les points de vie
        JPanel healthPanel = new JPanel(new GridLayout(2, 1));
        healthPanel.setOpaque(false);
        playerHealthLabel = new JLabel("Votre vie : \n" + joueur.getPointVie());
        enemyHealthLabel = new JLabel("PV de " + ennemi.getNom() + " : \n" + ennemi.getPointVie());
        healthPanel.add(playerHealthLabel);
        healthPanel.add(enemyHealthLabel);

        // Ajouter le settingsPanel et le healthPanel à un panel à droite
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setOpaque(false);
        rightPanel.add(CreatorToolDialog.getSettingButton(this), BorderLayout.NORTH);
        rightPanel.add(healthPanel, BorderLayout.CENTER);

        // Panel pour la description du nœud
        JPanel descriptionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        descriptionPanel.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(), "Description"));
        descriptionLabel = new JLabel("<html>" + CreatorToolDialog.stringDescriptionNodeFormat(node.getDescription()) + "</html>");
        descriptionPanel.add(descriptionLabel);

        // Panel pour les boutons de compétences
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setOpaque(false);
        updateButtonPanelWithCompetences();

        // Panel principal pour contenir l'image de fond
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);
        mainPanel.add(backgroundLabel, BorderLayout.CENTER);

        // Panel pour contenir la description et les boutons
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);
        bottomPanel.add(descriptionPanel, BorderLayout.NORTH);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Ajouter le mainPanel et le bottomPanel au JDialog
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        add(rightPanel, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(parent);
    }

    private void updateButtonPanelWithCompetences() {
        buttonPanel.removeAll();

        // Panel pour les compétences
        JPanel competencePanel = new JPanel(new GridLayout(0, 1));
        competencePanel.setOpaque(false);
        ECompetence[] competences = joueur.getClasse().getCompetences();
        for (ECompetence competence : competences) {
            JButton competenceButton = new JButton(competence.getNom());
            competenceButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedCompetence = competence;
                    descriptionLabel.setText("<html>Vous avez choisi " + selectedCompetence.getNom() + "</html>");
                    if(selectedCompetence.getMaxDeDegat()>0) {
                        showAttackButton();
                    } else if (selectedCompetence.getMaxDeHeal() > 0) {
                    	showHealButton();
                    }
 
                }
            });
            competencePanel.add(competenceButton);
        }

        buttonPanel.add(competencePanel);
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    private void showAttackButton() {
        buttonPanel.removeAll();

        JButton attackButton = new JButton("Tenter de toucher l'ennemi");
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAttack();
            }
        });

        buttonPanel.add(attackButton);
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }
    
    private void showHealButton() {
        buttonPanel.removeAll();

        JButton attackButton = new JButton("Tenter de vous soigner avec" + selectedCompetence.getNom());
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleHeal();
            }
        });

        buttonPanel.add(attackButton);
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }
    
    private void handleHeal() {
    	int soin = random.nextInt(selectedCompetence.getMaxDeHeal()) + 1;
    	joueur.gagnePointVie(soin);
        descriptionLabel.setText("<html>Vous avez gagné " + soin + " points de vie.</html>");
        updateHealthLabels();
        if(ennemi.getPointVie()>0) {
        	enemyTurn();
        } else {
        	checkEndOfCombat();
        }
    }

    private void handleAttack() {
        int resultatDe = random.nextInt(20) + 1 + selectedCompetence.getModif();
        if (resultatDe > ennemi.getClasseArmur()) {
           descriptionLabel.setText("<html>Vous avez touché " + ennemi.getNom() + " avec " + selectedCompetence.getNom() + ".</html>");
           showDamageButton();
        } else {
            descriptionLabel.setText("<html>Vous n'avez pas réussi à toucher " + ennemi.getNom() + "</html>");
            enemyTurn();
        }
    }

    private void showDamageButton() {
        buttonPanel.removeAll();

        JButton damageButton = new JButton("Combien de dégâts allez vous infliger ?");
        damageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int degat = random.nextInt(selectedCompetence.getMaxDeDegat()) + 1;
                ennemi.pertPointVie(degat);
                descriptionLabel.setText("<html>Vous avez infligé " + degat + " points de dégâts à " + ennemi.getNom() + " avec " + selectedCompetence.getNom() + ".</html>");
                updateHealthLabels();
                if(ennemi.getPointVie()>0) {
                	enemyTurn();
                } else {
                	checkEndOfCombat();
                }
            }
        });

        buttonPanel.add(damageButton);
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    protected void enemyTurn() {
    	showContinueButton("Tour de l'ennemi", this::handleEnemyTurn);
	}

	private void handleEnemyTurn() {
        descriptionLabel.setText("<html>C'est au tour de l'ennemi !</html>");
        buttonPanel.removeAll();
        buttonPanel.revalidate();
        buttonPanel.repaint();

        ECompetence[] competences = ennemi.getClasse().getCompetences();
        ECompetence competence = competences[random.nextInt(competences.length)];
        if (competence.getMaxDeDegat() == 0 && competence.getMaxDeHeal() == 0) {
        	descriptionLabel.setText("<html>" + ennemi.getNom() + " ne fait rien. </html>");
        } else if (competence.getMaxDeDegat() > 0) {  // Compétence de dégat
        	int resultatDe = random.nextInt(20) + 1 + competence.getModif();
            if (resultatDe > joueur.getClasseArmur()) {
                int degat = random.nextInt(competence.getMaxDeDegat()) + 1;
                joueur.pertPointVie(degat);
                descriptionLabel.setText("<html>" + ennemi.getNom() + " vous a touché avec " + competence.getNom() + " et vous subissez " + degat + " points de dégâts.</html>");
            } else {
                descriptionLabel.setText("<html>" + ennemi.getNom() + " n'a pas réussi à vous toucher.</html>");
            }
        } else {  // Compétence de soin
            int soin = random.nextInt(competence.getMaxDeHeal()) + 1;
            ennemi.gagnePointVie(soin);
            descriptionLabel.setText("<html>" + ennemi.getNom() + "s'est soigné de " + soin + " points de vie.</html>");
        }

        updateHealthLabels();
        checkEndOfCombat();
        if (joueur.getPointVie() > 0 && ennemi.getPointVie() > 0) {
            showContinueButton("Votre tour", this::updateButtonPanelWithCompetences);
        }
    }

    private void showContinueButton(String buttonText, Runnable action) {
        buttonPanel.removeAll();

        JButton continueButton = new JButton(buttonText);
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.run();
            }
        });

        buttonPanel.add(continueButton);
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    private void updateHealthLabels() {
        playerHealthLabel.setText("Votre vie : " + joueur.getPointVie());
        enemyHealthLabel.setText("PV de " + ennemi.getNom() + " : " + ennemi.getPointVie());
    }

    private void checkEndOfCombat() {
        if (joueur.getPointVie() <= 0) {
            descriptionLabel.setText("<html>Vous avez été vaincu par l'ennemi.</html>");
            showEndCombatOptions(false);
        } else if (ennemi.getPointVie() <= 0) {
            descriptionLabel.setText("<html>Vous avez vaincu l'ennemi !</html>");
            showEndCombatOptions(true);
        } else {
            // Si le combat n'est pas terminé, continuer avec le prochain tour
            if (joueur.getPointVie() > 0 && ennemi.getPointVie() > 0) {
                showContinueButton("Votre tour", this::updateButtonPanelWithCompetences);
            }
        }
    }

    private void showEndCombatOptions(boolean playerWon) {
        buttonPanel.removeAll();

        JButton continueButton = new JButton("Continuer");
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGame.nextNode(getDialog(), playerWon ? node.getChoix()[0].getId() : node.getChoix()[1].getId());
                dispose();
            }
        });

        buttonPanel.add(continueButton);
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    @Override
    public JDialog getDialog() {
        return this;
    }

}
