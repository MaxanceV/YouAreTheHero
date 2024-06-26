package Univers.classe;

import java.io.Serializable;

import Univers.Enum.ECompetence;

public final class TClasseObstacle implements IClasse, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public String getDescription() {
		return "un obstacle";
	}

	@Override
	public ECompetence[] getCompetences() {
		ECompetence[] competence = {ECompetence.OBSTACLE};
		return competence;
	}

	@Override
	public boolean canLevelUp() {
		return false;
	}

	@Override
	public IClasse levelUp() {
		return null;
	}

}
