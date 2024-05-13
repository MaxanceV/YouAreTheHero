package Univers.classe;

public final class TClasseChampion extends AClasseGuerrier {
	
	@Override
	public String getDescription() {
		return "Je suis un champion";
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
