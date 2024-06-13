package Main;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import InterfaceGame.CharacterCreationDialog;
import InterfaceGame.MenuDialog;
import Representation.node.ANode;
import Representation.node.TNodeChance;
import Representation.node.TNodeDecision;
import Representation.node.TNodeFight;
import Representation.node.TNodeTerminal;
import Representation.node.container.ANodeContainer;
import Representation.node.container.TNodeContainerSauverTimelin;
import Univers.TPlayer;

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
		System.out.println("load");
	}
	
	public static void playerCreated(TPlayer player) {
		joueur = player;
		joueur.setCurrentNode(nodeOfTheStory.getDefaultStartNode());
		launchNode(joueur);
		}

	private static void launchNode(TPlayer joueur) {
		ANode node = joueur.getCurrentNode();
		if(null != node) {
			node.launchNode(joueur, frame);
		} else {
			//TODO
		}
		
	}
}
