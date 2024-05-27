package Representation.node;

public abstract class ANode {
	private String id;
	private String description;
	private String descriptionchoix;
	
	public ANode(String id, String desc, String descchoix) {
		this.id = id;
		this.description = desc;
		this.descriptionchoix = descchoix;
	}
	
	public abstract void startNode();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescriptionChoix() {
		return descriptionchoix;
	}
	
	public void setDescriptionChoix(String descriptionchoix) {
		this.descriptionchoix = descriptionchoix;
	}

}
