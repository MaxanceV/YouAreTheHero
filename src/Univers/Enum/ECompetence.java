package Univers.Enum;

public enum ECompetence {
	COUPEPEE("coupEpee","Coup d'épée","Attaque l'ennemi avec son épée", 2, 8,0),
	BOULEDEFEU("bouleDeFeu","Boule de feu", "Jette une boule de feu sur l'ennemi",2,12,0),
	STALACTITE("stalactite","Stalactite","Lance un pique de glace", 2,8,0),
	COUPDEPEEADEUXMAIN("coupEpeeDeuxMain","Coup d'épée à deux mains","Attaque l'ennemi à deux mains avec son épée", -2,12,0),
	POTIONSOIN("potionSoin","Se soigner","Utilise une potion de soin sur lui-même",0,0,8),
	OBSTACLE("neRienFaire","Ne rien faire","Ne fait rien",0,0,0),
	LAMEDEFEU("lameDeFeu","Lame miraculeuse","Porte un coup avec son épée possédée par une force divine",2,12,0);
	
	private String id;
	private String nom;
	private String desc;
	private int modif = 0;
	private int maxDeDegat = 0;
	private int maxDeHeal = 0;
	
	ECompetence(String id, String name, String description, int modif, int maxDeDegat, int maxDeHeal) {
		this.id = id;
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

	public String getId() {
		return id;
	}
	
    @Override
    public String toString() {
        return nom + ": " + desc + " (Modif: " + modif + ", Dégâts: " + maxDeDegat + ", Soin: " + maxDeHeal + ")";
    }


}
