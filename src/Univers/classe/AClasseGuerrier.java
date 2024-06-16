package Univers.classe;

import java.io.Serializable;

import Univers.Enum.ECompetence;

public class AClasseGuerrier implements IClasse, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public String getDescription() {
		return "un guerrier";
	}

	@Override
	public boolean canLevelUp() {
		return true;
	}

	@Override
	public IClasse levelUp() {
		return new TClasseChampion();
	}

	@Override
	public ECompetence[] getCompetences() {
		ECompetence[] competence = {ECompetence.COUPEPEE, ECompetence.COUPDEPEEADEUXMAIN};
		return competence;
	}

}
