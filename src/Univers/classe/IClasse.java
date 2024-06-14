package Univers.classe;

import Univers.Enum.ECompetence;

public interface IClasse {
	
	public abstract String getDescription();
	public abstract ECompetence[] Competences();
	public abstract boolean canLevelUp();
	public abstract IClasse levelUp();

}
