package Univers.classe;

import Univers.Enum.ECompetence;

public final class TClasseGoblinGuerrier extends AClasseGuerrier{
	private static final long serialVersionUID = 1L;

	@Override
	public String getDescription() {
		return "un gobelin guerrier";
	}

	@Override
	public ECompetence[] getCompetences() {
		ECompetence[] competence = {ECompetence.COUPEPEE, ECompetence.COUPDEPEEADEUXMAIN};
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
