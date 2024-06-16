package Univers.classe;

import java.io.Serializable;

import Univers.Enum.ECompetence;

public class AClasseMage implements IClasse, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public String getDescription() {
		return "un mage";
	}

	@Override
	public ECompetence[] getCompetences() {
		ECompetence[] competence = {ECompetence.STALACTITE, ECompetence.POTIONSOIN};
		return competence;
	}

	@Override
	public boolean canLevelUp() {
		return true;
	}

	@Override
	public IClasse levelUp() {
		return new TClasseArchimage();
	}

}
