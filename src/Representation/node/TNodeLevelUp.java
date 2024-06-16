package Representation.node;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import InterfaceGame.DialogNodeLevelUp;
import Univers.TPlayer;

public class TNodeLevelUp extends ANodeInner{

	public TNodeLevelUp(String id, String desc, String descchoix) {
		super(id, desc, descchoix);
	}
	
	@Override
	public void setChoix(ANode[] choix) {
		if(choix.length == 1) {
			super.setChoix(choix);
		} else {
			System.out.println("1 seul noeud suivant pour les noeuds level up");
		}
	}
	
	@Override
	public void launchNode(TPlayer joueur, JFrame frame) {
		SwingUtilities.invokeLater(() -> {
            new DialogNodeLevelUp(frame, joueur, this).setVisible(true);
        });
	}

	@Override
	public ENodeType getNodeType() {
		// TODO Auto-generated method stub
		return null;
	}

}
