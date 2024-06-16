package Representation.node;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import InterfaceGame.DialogNodeDecision;
import Univers.TPlayer;

public final class TNodeDecision extends ANodeInner {
	
	public TNodeDecision(String id, String desc, String descchoix) {
		super(id, desc, descchoix);
	}


	@Override
	public void launchNode(TPlayer joueur, JFrame frame) {
		SwingUtilities.invokeLater(() -> {
            new DialogNodeDecision(frame, joueur, this).setVisible(true);
        });
	}
	
	@Override
	public ENodeType getNodeType() {
		return ENodeType.DECISION;
	}
}
