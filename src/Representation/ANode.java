package Representation;

public abstract class ANode {
	int id;
	String description;
	
	public ANode(int id, String desc) {
		this.id = id;
		this.description = desc;
	}
	
	public abstract void startNode(); //Déroulé du node courant
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
