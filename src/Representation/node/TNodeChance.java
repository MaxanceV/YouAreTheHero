package Representation.node;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import InterfaceGame.DialogNodeChance;
import Univers.TPlayer;

public final class TNodeChance extends ANodeInner {
	
	public TNodeChance(String id, String desc, String descchoix) {
		super(id, desc, descchoix);
	}

	@Override
	public void launchNode(TPlayer joueur, JFrame frame) {
		SwingUtilities.invokeLater(() -> {
            new DialogNodeChance(frame, joueur, this).setVisible(true);
        });
	}

	@Override
	public ENodeType getNodeType() {
		return ENodeType.CHANCE;
	}

}
