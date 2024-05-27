package Representation.node;

public final class TNodeChance extends ANodeInner {
	
	public TNodeChance(String id, String desc, String descchoix) {
		super(id, desc,descchoix);
	}

	@Override
	public ANode chooseNext() {
		System.out.println("Que va-t-il se passer ? Tous les événements ont une égale probabilité de se produire");
		for(int i=0;i< this.getChoix().length;i++) {
			System.out.println(this.getChoix()[i].getDescriptionChoix());
		}
		// TODO
		//this.getChoix()[decisionprise].startNode();
		return null;
	}

	@Override
	public void startNode() {
		// Afficher la description puis passer au tirage aléatoire : 
		System.out.println(this.getDescription());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.chooseNext();
	}

}
