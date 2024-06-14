package Representation.node.container;

import java.util.HashMap;

import Representation.node.ANode;
import Representation.node.ANodeInner;
import Representation.node.TNodeChance;
import Representation.node.TNodeDecision;
import Representation.node.TNodeTerminal;

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
	
	protected TNodeChance addNodeChance(String id, String desc, String descchoix) {
		TNodeChance node = new TNodeChance(id, desc, descchoix);
		nodesOfTheGame.put(id, node);
		return node;
	}
	
	protected TNodeDecision addNodeDecision(String id, String desc, String descchoix) {
		TNodeDecision node = new TNodeDecision(id, desc, descchoix);
		nodesOfTheGame.put(id, node);
		return node;
	}
	
	protected TNodeDecision addNodeFight(String id, String desc, String descchoix) {
		TNodeDecision node = new TNodeDecision(id, desc, descchoix);
		nodesOfTheGame.put(id, node);
		return node;
	}
	
	protected TNodeTerminal addNodeTerminal(String id, String desc, String descchoix) {
		TNodeTerminal node = new TNodeTerminal(id, desc, descchoix);
		nodesOfTheGame.put(id, node);
		return node;
	}

}
