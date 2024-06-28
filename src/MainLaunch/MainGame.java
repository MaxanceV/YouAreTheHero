package MainLaunch;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import InterfaceGame.CreatorToolDialog;
import InterfaceGame.DialogCharacterCreation;
import InterfaceGame.DialogLoadSave;
import InterfaceGame.DialogMainMenu;
import InterfaceGame.DialogNodeDecision;
import InterfaceGame.DialogOptions;
import InterfaceGame.DialogStatistics;
import Representation.node.ANode;
import Representation.node.TNodeChance;
import Representation.node.TNodeDecision;
import Representation.node.TNodeFight;
import Representation.node.TNodeTerminal;
import Representation.node.container.ANodeContainer;
import Representation.node.container.TNodeContainerSauverTimelin;
import Univers.TPersonnage;
import Univers.TPlayer;
import Univers.Enum.ERace;
import Univers.classe.AClasseGuerrier;

/**
 * Main class of the game "You Are The Hero".
 * 
 * This game was developed as a part of an educational project by Maxance and Ferdinand.
 * The purpose of this project was to apply and expand our knowledge in software development,
 * focusing on creating engaging user experiences with Java Swing for graphical user interfaces,
 * managing audio playback, and implementing a save/load system.
 * 
 * Creators:
 * - Maxance Villame
 * - Ferdinand Martin-Lavigne
 * 
 * We hope you enjoy playing it as much as we enjoyed making it!
 */

// MainGame.java
public class MainGame {
	private static JFrame frame;
	private static TPlayer joueur;
	private static ANodeContainer nodeOfTheStory;

    public static void main(String[] args) {
    	createDefaultFrame();
    	OpenMainMenu(null); 	
    }

	private static void loadStory() {
		nodeOfTheStory = new TNodeContainerSauverTimelin();
	}

	private static void createDefaultFrame() {
        frame = new JFrame("Game Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(false);
	}

	public static void OpenMainMenu(JDialog jDialog) {
		if(null != jDialog) {
			jDialog.dispose();
		}
		SoundManager.stopSound();
        SwingUtilities.invokeLater(() -> {
            new DialogMainMenu(frame).setVisible(true);
        });
	}

	public static void createCharacter(JDialog jDialog) {
		if(null != jDialog) {
			jDialog.dispose();
		}
		SwingUtilities.invokeLater(() -> {
	        new DialogCharacterCreation(frame).setVisible(true);
	   });
	}

	public static void loadCharacter(JDialog jDialog) {
		if(null != jDialog) {
			jDialog.dispose();
		}
    	SwingUtilities.invokeLater(() -> {
	        new DialogLoadSave(frame).setVisible(true);
	   });
	}
	
	public static void playerCreated(TPlayer player) {
		loadStory();
		joueur = player;
		joueur.setCurrentNode(nodeOfTheStory.getDefaultStartNode().getId());
		launchNode();
		}
	
	public static void playerLoaded(String player) {
		joueur = SaveManager.loadPlayer(player);
		if (joueur != null) {
			loadStory();
    	    System.out.println("Joueur chargé: " + joueur.getNom());
    	    launchNode();
    	} else {
    	    System.out.println("Erreur lors du chargement du joueur");
    	    OpenMainMenu(null);
    	}
	}

	private static void launchNode() {
		ANode node = nodeOfTheStory.getNodeFromId(joueur.getCurrentNode());
		if(null != node) {
			SoundManager.playSound("sons/" + node.getId() + ".wav");
			node.launchNode(joueur, frame);
		} else {
			//TODO
		}
		
	}

	public static void nextNode(JDialog jDialog, String id) {
		if(null != jDialog) {
			jDialog.dispose();
		}
		joueur.setCurrentNode(id);
		SaveManager.savePlayer(joueur);
		SoundManager.stopSound();
		launchNode();
	}
	
	public static void endOfGameAndQuit() {
		SoundManager.stopSound();
		deleteSaveOfPlayer(null);
		quit(null);
	}
	
	public static void startOptionsDialog(JDialog jDialog) {
		SwingUtilities.invokeLater(() -> {
	        new DialogOptions(frame, jDialog).setVisible(true);
	   });
	}

	private static void deleteSaveOfPlayer(TPlayer player) {
		if (null != player) {
			SaveManager.deleteSaveOfPlayer(player.getNom());
		} else {
			SaveManager.deleteSaveOfPlayer(joueur.getNom());
		}
		
	}

	public static void quit(JDialog jDialog) {
		if(null != jDialog) {
			jDialog.dispose();
		}
		frame.dispose();
		System.exit(0);
	}

	public static void startStatisticsDialog(JDialog dialog, TPersonnage player) {
		SwingUtilities.invokeLater(() -> {
			new DialogStatistics(frame, player).setVisible(true);
		});
	}
}
