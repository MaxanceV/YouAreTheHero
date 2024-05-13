package Univers.classe;

public final class TClasseArchimage extends AClasseMage {
	
	@Override
	public String getDescription() {
		return "Je suis un archimage";
	}

	@Override
	public int attaque() {
		return 0;
	}

	@Override
	public int defense() {
		return 0;
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
