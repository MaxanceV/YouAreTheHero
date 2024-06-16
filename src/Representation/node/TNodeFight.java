package Representation.node;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import InterfaceGame.DialogNodeFight;
import Univers.TPersonnage;
import Univers.TPlayer;

public final class TNodeFight extends ANodeInner {
	private TPersonnage ennemi;

	public TNodeFight(String id, String desc, String descchoix, String image, String son, TPersonnage ennemi) {
		super(id, desc, descchoix, image, son);
		this.ennemi = ennemi;
	}

	@Override
	public void setChoix(ANode[] choix) {
		if(choix.length == 2) {
			super.setChoix(choix);
		} else {
			System.out.println("Deux choix pour les nodes de combat (Victoire et defaite");
		}
	}

	@Override
	public void launchNode(TPlayer joueur, JFrame frame) {
		SwingUtilities.invokeLater(() -> {
            new DialogNodeFight(frame, joueur, this).setVisible(true);
        });
	}

	@Override
	public ENodeType getNodeType() {
		return ENodeType.FIGHT;
	}

	public TPersonnage getEnnemi() {
		return ennemi;
	}
}
