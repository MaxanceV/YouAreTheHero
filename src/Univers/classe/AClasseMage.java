package Univers.classe;

import java.io.Serializable;

import Univers.Enum.ECompetence;

public class AClasseMage implements IClasse, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public String getDescription() {
		return "Je suis un mage";
	}

	@Override
	public ECompetence[] Competences() {
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
