package Univers.classe;

public interface IClasse {
	
	public abstract String getDescription();
	public abstract int attaque();
	public abstract int defense();
	public abstract boolean canLevelUp();
	public abstract IClasse levelUp();

}
