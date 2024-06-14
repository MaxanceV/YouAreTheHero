package Univers.Enum;

public enum ECompetence {
	COUPEPEE("Coup d'épee","Attaque l'ennemi avec son épée", 2, 8,0),
	BOULEDEFEU("Boule de feu", "Jette une boule de feu sur l'ennemi",2,8,0),
	STALACTITE("Stalactite","Lance un pique de glace", 2,8,0),
	COUPDEPEEADEUXMAIN("Coup d'épee à deux main","Attaque l'ennemi à deux main avec son épée", -2,12,0),
	POTIONSOIN("Se soigner","Utilise une potion de soin sur lui même",0,0,8),
	OBSTACLE("Ne rien faire","Ne fait rien",0,0,0);
	
	
	private String nom;
	private String desc;
	private int modif = 0;
	private int maxDeDegat = 0;
	private int maxDeHeal = 0;
	
	ECompetence(String name, String description, int modif, int maxDeDegat, int maxDeHeal) {
		this.nom = name;
		this.desc = description;
		this.modif = modif;
		this.maxDeDegat = maxDeDegat;
		this.maxDeHeal = maxDeHeal;
	}
	
	public String getNom() {
		return nom;
	}

	public String getDesc() {
		return desc;
	}

	public int getModif() {
		return modif;
	}

	public int getMaxDeDegat() {
		return maxDeDegat;
	}

	public int getMaxDeHeal() {
		return maxDeHeal;
	}


}
