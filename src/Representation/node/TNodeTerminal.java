package Representation.node;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import InterfaceGame.DialogNodeTerminal;
import Univers.TPlayer;

public final class TNodeTerminal extends ANode {

	public TNodeTerminal(String id, String desc, String descchoix) {
		super(id, desc, descchoix);
	}

	@Override
	public void launchNode(TPlayer joueur, JFrame frame) {
		SwingUtilities.invokeLater(() -> {
            new DialogNodeTerminal(frame, joueur, this).setVisible(true);
        });
	}

	@Override
	public ENodeType getNodeType() {
		return ENodeType.TERMINAL;
	}
}