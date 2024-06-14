package Representation.node;

import javax.swing.JFrame;

import Univers.TPlayer;

public final class TNodeTerminal extends ANode {

	public TNodeTerminal(String id, String desc, String descchoix, String image, String son) {
		super(id, desc, descchoix, image, son);
	}

	@Override
	public void launchNode(TPlayer joueur, JFrame frame) {
		System.out.println(this.getDescription());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin du jeu. Recommencer ?");
	}

	@Override
	public ENodeType getNodeType() {
		return ENodeType.TERMINAL;
	}
}
