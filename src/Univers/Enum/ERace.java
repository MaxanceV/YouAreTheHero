package Univers.Enum;

import java.io.Serializable;

public enum ERace implements Serializable{
	//ATTRIBUT DANS L'ORDRE : Nom,pvMax, ca par défaut
	HUMAIN("Humain",15,12),
	NAIN("Nain",12,15),
	ORC("Orc",20,12),
	GOBELIN("Gobelin",10,12),
	OBSTACLE("Obstacle",20,0);
	
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
