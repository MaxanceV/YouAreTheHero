package Univers;

import java.io.Serializable;

import Univers.Enum.ERace;
import Univers.classe.IClasse;

public class TPersonnage implements Serializable {
	private static final long serialVersionUID = 1L;
	private ERace race;
	private IClasse classe;
	private int pointVie;
	private int classeArmure;
	private String nom;
	
	
	public TPersonnage(String nom, IClasse classe, ERace race) {
		this.nom = nom;
		this.classe = classe;
		this.race = race;
		this.classeArmure = race.getArmorClass();
		this.pointVie = race.getHitPointsMax();
	}


	public ERace getRace() {
		return race;
	}


	public void setRace(ERace race) {
		this.race = race;
	}


	public IClasse getClasse() {
		return classe;
	}


	public void setClasse(IClasse classe) {
		this.classe = classe;
	}


	public int getPointVie() {
		return pointVie;
	}


	public void setPointVie(int pointVie) {
		this.pointVie = pointVie;
	}
	
	public void pertPointVie(int pointViePerdu) {
		if(getPointVie() - pointViePerdu < 0 ) {
			setPointVie(0);	
		} else {
			setPointVie(pointVie - pointViePerdu);
		}
	}
	
	public void gagnePointVie(int pointVieGagner) {
		if(getPointVie() + pointVieGagner > race.getHitPointsMax()) {
			setPointVie(race.getHitPointsMax());
		} else {
			setPointVie(pointVie + pointVieGagner);
		}
	}

	public int getClasseArmur() {
		return classeArmure;
	}


	public void setClasseArmur(int classeArmur) {
		this.classeArmure = classeArmur;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void levelUp() {
		IClasse classeTmp = getClasse().levelUp();
		if(null != classeTmp) {
			setClasse(classeTmp);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    TPersonnage other = (TPersonnage) obj;
	    if (nom == null) {
	        if (other.nom != null) {
	            return false;
	        }
	    } else if (!nom.equals(other.nom)) {
	        return false;
	    }
	    if (race != other.race) {
	        return false;
	    }
	    if (classeArmure != other.classeArmure) {
	        return false;
	    }
	    if (pointVie != other.pointVie) {
	        return false;
	    }
	    return classe != null ? classe.equals(other.classe) : other.classe == null;
	}
	
	@Override
	public String toString() {
	    return "TPersonnage{" +
	           "nom='" + nom + '\'' +
	           ", race=" + race +
	           ", classe=" + classe +
	           ", pointVie=" + pointVie +
	           ", classeArmure=" + classeArmure +
	           '}';
	}
	
}
