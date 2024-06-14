package Representation.node;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import InterfaceGame.MenuDialog;
import InterfaceGame.NodeDecisionDialog;
import Univers.TPlayer;

public final class TNodeDecision extends ANodeInner {
	
	public TNodeDecision(String id, String desc, String descchoix, String image, String son) {
		super(id, desc, descchoix, image, son);
	}

//	@Override
//	public ANode chooseNext() {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Que faire ?");
//		for(int i=0;i< this.getChoix().length;i++) {
//			System.out.println(this.getChoix()[i].getDescriptionChoix()+" Entrez : "+i);
//		}
//		int decisionprise = scanner.nextInt();
////		this.getChoix()[decisionprise].launchNode();
//		return null;
//	}

	@Override
	public void launchNode(TPlayer joueur, JFrame frame) {
		SwingUtilities.invokeLater(() -> {
            new NodeDecisionDialog(frame, joueur, this).setVisible(true);
        });
	}
	
	@Override
	public ENodeType getNodeType() {
		return ENodeType.DECISION;
	}
}
