package Univers.Enum;

import java.io.Serializable;

public enum ERace implements Serializable{
	//ATTRIBUT DANS L'ORDRE : Nom,pvMax, ca par défaut
	HUMAIN("Humain",20,10),
	NAIN("Nain",15,20),
	GOBELIN("Gobelin",30,5),
	OBSTACLE("Obstacle",20,30);
	
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

	public int getHitPointsMax() {
		return hitPoints;
	}

	public int getArmorClass() {
		return armorClass;
	}
}
