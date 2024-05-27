package Representation.node;

import java.util.Scanner;

public final class TNodeDecision extends ANodeInner {
	
	public TNodeDecision(String id, String desc, String descchoix) {
		super(id, desc, descchoix);
	}

	@Override
	public ANode chooseNext() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Que faire ?");
		for(int i=0;i< this.getChoix().length;i++) {
			System.out.println(this.getChoix()[i].getDescriptionChoix()+" Entrez : "+i);
		}
		int decisionprise = scanner.nextInt();
		this.getChoix()[decisionprise].startNode();
		return null;
	}

	@Override
	public void startNode() {
		// Afficher la description puis passer au choix : 
		System.out.println(this.getDescription());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.chooseNext();
	}
	
	@Override
	public ENodeType getNodeType() {
		return ENodeType.DECISION;
	}
}
