package Univers.race;

public enum ERace {
	//ATTRIBUT DANS L'ORDRE : Nom,pv, ca par défaut
	HUMAIN("Humain",100,10),
	NAIN("Nain",90,20),
	GOBELIN("Gobelin",40,5),
	OBSTACLE("Obstacle",70,30);
	
	private final String description;
	private final int hitPoints;
    private final int armorClass;
	
	ERace(String description, int hitPoints, int armorClass) {
        this.description = description;
        this.hitPoints = hitPoints;
        this.armorClass = armorClass;
	}
	
	public String getDescription() {
		return description;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public int getArmorClass() {
		return armorClass;
	}
}
