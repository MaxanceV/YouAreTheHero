package Representation.node.container;

import java.util.HashMap;

import Representation.node.ANode;
import Representation.node.ANodeInner;
import Representation.node.TNodeChance;
import Representation.node.TNodeDecision;
import Representation.node.TNodeFight;
import Representation.node.TNodeTerminal;
import Univers.TPersonnage;

public abstract class ANodeContainer {
	
	private HashMap<String, ANode> nodesOfTheGame;
	
	public abstract ANodeInner getDefaultStartNode();
	
	public ANodeContainer() {
		this.nodesOfTheGame = new HashMap<String, ANode>(5);
	}
	
	public HashMap<String, ANode> getNodesOfTheGame() {
		return nodesOfTheGame;
	}
	
	public ANode getNodeFromId(String id) {
		return getNodesOfTheGame().get(id);
	}
	
	protected TNodeChance addNodeChance(String id, String desc, String descchoix, String image, String son) {
		TNodeChance node = new TNodeChance(id, desc, descchoix, image, son);
		nodesOfTheGame.put(id, node);
		return node;
	}
	
	protected TNodeDecision addNodeDecision(String id, String desc, String descchoix, String image, String son) {
		TNodeDecision node = new TNodeDecision(id, desc, descchoix, image, son);
		nodesOfTheGame.put(id, node);
		return node;
	}
	
	protected TNodeFight addNodeFight(String id, String desc, String descchoix, String image, String son, TPersonnage ennemi) {
		TNodeFight node = new TNodeFight(id, desc, descchoix, image, son, ennemi);
		nodesOfTheGame.put(id, node);
		return node;
	}
	
	protected TNodeTerminal addNodeTerminal(String id, String desc, String descchoix, String image, String son) {
		TNodeTerminal node = new TNodeTerminal(id, desc, descchoix, image, son);
		nodesOfTheGame.put(id, node);
		return node;
	}

}
