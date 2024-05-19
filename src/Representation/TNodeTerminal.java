package Representation;

public final class TNodeTerminal extends ANode {

	public TNodeTerminal(int id, String desc, String descchoix) {
		super(id, desc, descchoix);
	}

	@Override
	public void startNode() {
		System.out.println(this.getDescription());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin du jeu. Recommencer ?");
	}

}
