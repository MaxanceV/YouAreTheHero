package Univers;

import Univers.classe.IClasse;
import Univers.race.ERace;

public class TPersonnage {

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
		this.pointVie = race.getHitPoints();
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
	
}
