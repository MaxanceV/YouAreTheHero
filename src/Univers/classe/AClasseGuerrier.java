package Univers.classe;

public abstract class AClasseGuerrier implements IClasse {
	
	@Override
	public String getDescription() {
		return "Je suis un guerrier";
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
		return true;
	}

	@Override
	public IClasse levelUp() {
		return new TClasseChampion();
	}

}
