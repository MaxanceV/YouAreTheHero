package Representation.node;

import javax.swing.JFrame;

import Univers.TPlayer;

public class TNodeLevelUp extends ANodeInner{

	public TNodeLevelUp(String id, String desc, String descchoix, String image, String son) {
		super(id, desc, descchoix, image, son);
	}

	@Override
	public void launchNode(TPlayer joueur, JFrame frame) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ENodeType getNodeType() {
		// TODO Auto-generated method stub
		return null;
	}

}
