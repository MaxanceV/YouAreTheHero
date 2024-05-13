import java.util.Scanner;

import javax.swing.SwingUtilities;

import InterfaceGame.InterfaceGame;
import Univers.TPersonnage;
import Univers.classe.AClasseGuerrier;
import Univers.classe.AClasseMage;
import Univers.classe.IClasse;
import Univers.race.ERace;

public class MainGame {
	
	public static void startGame(Scanner scanner) {
		System.out.println("Bienvenue dans cette aventure épique !");
    	System.out.println("Choisissez un nom :");
    	String name = scanner.nextLine();
    	System.out.println("Choisissez une race 1 : Humain, 2 : Nain");
    	int intRace = scanner.nextInt();
    	System.out.println("Choisissez une classe 1 : Guerrier, 2 : Mage");
    	int intClasse = scanner.nextInt();
    	ERace raceJoueur = intRace == 1 ? ERace.HUMAIN : ERace.NAIN;
    	IClasse classeJoueur = intClasse == 1 ? new AClasseGuerrier() : new AClasseMage();
    	TPersonnage joueur = new TPersonnage(name,classeJoueur, raceJoueur);
    	
    	System.out.println("Bienvenue " + joueur.getNom() + " Vous faite partie du peuple des " + joueur.getRace().getDescription() + " et vous êtes un " + joueur.getClasse().getDescription());
    	
	}
    public static void main(String[] args) {
//    	Scanner scanner = new Scanner(System.in);
//    	startGame(scanner);
   
    	
    	
    	
        SwingUtilities.invokeLater(() -> {
        	InterfaceGame frame = new InterfaceGame();
            frame.setVisible(true);
            
        });
    }
}
