package Univers.classe;

public class AClasseMage implements IClasse {
	
	@Override
	public String getDescription() {
		return "Je suis un mage";
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
		return new TClasseArchimage();
	}

}
