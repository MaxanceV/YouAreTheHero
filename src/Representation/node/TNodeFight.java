package Representation.node;

import javax.swing.JFrame;

import Univers.TPlayer;

public final class TNodeFight extends ANodeInner {

	public TNodeFight(String id, String desc, String descchoix) {
		super(id, desc, descchoix);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ANode chooseNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void launchNode(TPlayer joueur, JFrame frame) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ENodeType getNodeType() {
		return ENodeType.FIGHT;
	}
}
