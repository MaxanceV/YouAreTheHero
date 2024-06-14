package Univers.classe;

import Univers.Enum.ECompetence;

public final class TClasseArchimage extends AClasseMage {
	private static final long serialVersionUID = 1L;

	@Override
	public String getDescription() {
		return "Je suis un archimage";
	}

	@Override
	public ECompetence[] Competences() {
		ECompetence[] competence = {ECompetence.BOULEDEFEU, ECompetence.STALACTITE, ECompetence.POTIONSOIN};
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
