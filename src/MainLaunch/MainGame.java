package MainLaunch;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import InterfaceGame.CharacterCreationDialog;
import InterfaceGame.LoadSaveDialog;
import InterfaceGame.MenuDialog;
import InterfaceGame.NodeDecisionDialog;
import InterfaceGame.OptionsDialog;
import Representation.node.ANode;
import Representation.node.TNodeChance;
import Representation.node.TNodeDecision;
import Representation.node.TNodeFight;
import Representation.node.TNodeTerminal;
import Representation.node.container.ANodeContainer;
import Representation.node.container.TNodeContainerSauverTimelin;
import Univers.TPlayer;
import Univers.Enum.ERace;
import Univers.classe.AClasseGuerrier;

// MainGame.java
public class MainGame {
	private static JFrame frame;
	private static TPlayer joueur;
	private static ANodeContainer nodeOfTheStory;

    public static void main(String[] args) {
    	
    	createDefaultFrame();
    	loadStory();
    	OpenMainMenu(); 	
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

	public static void OpenMainMenu() {
        SwingUtilities.invokeLater(() -> {
            new MenuDialog(frame).setVisible(true);
        });
	}

	public static void createCharacter() {
		SwingUtilities.invokeLater(() -> {
	        new CharacterCreationDialog(frame).setVisible(true);
	   });
	}

	public static void loadCharacter() {
    	SwingUtilities.invokeLater(() -> {
	        new LoadSaveDialog(frame).setVisible(true);
	   });
	}
	
	public static void playerCreated(TPlayer player) {
		joueur = player;
		joueur.setCurrentNode(nodeOfTheStory.getDefaultStartNode().getId());
		launchNode();
		}
	
	public static void playerLoader(String player) {
		joueur = SaveManager.loadPlayer(player);
		if (joueur != null) {
    	    System.out.println("Joueur chargé: " + joueur.getNom());
    	    launchNode();
    	} else {
    	    System.out.println("Erreur lors du chargement du joueur");
    	    OpenMainMenu();
    	}
	}

	private static void launchNode() {
		System.out.println(joueur.getCurrentNode());
		ANode node = nodeOfTheStory.getNodeFromId(joueur.getCurrentNode());
		System.out.println(nodeOfTheStory);
		System.out.println(node);
		if(null != node) {
			node.launchNode(joueur, frame);
		} else {
			//TODO
		}
		
	}

	public static void nextNode(String id) {
		joueur.setCurrentNode(id);
		SaveManager.savePlayer(joueur);
		launchNode();
	}
	
	public static void endOfGameAndQuit() {
		deleteSaveOfPlayer();
		quit();
	}
	
	public static void startOptionsDialog(JDialog jDialog) {
		SwingUtilities.invokeLater(() -> {
	        new OptionsDialog(frame, jDialog).setVisible(true);
	   });
	}

	private static void deleteSaveOfPlayer() {
		// TODO Auto-generated method stub
		
	}

	public static void quit() {
		frame.dispose();
		System.exit(0);
	}
}
