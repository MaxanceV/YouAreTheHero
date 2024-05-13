import java.util.Scanner;

import javax.swing.SwingUtilities;

import InterfaceGame.InterfaceGame;
import Univers.TPersonnage;
import Univers.classe.AClasseGuerrier;
import Univers.classe.AClasseMage;
import Univers.classe.IClasse;

public class MainGame {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Bienvenue dans cette aventure épique !");
    	System.out.println("Choisissez un nom :");
    	String name = scanner.nextLine();
    	System.out.println("Choisissez une race 1 : Humain, 2 : Nain");
    	int race = scanner.nextInt();
    	System.out.println("Choissiez une classe 1 : Guerrier, 2 : Mage");
    	int classe = scanner.nextInt();
    	IClasse classeJoueur;
    	//TPersonnage joueur = new TPersonnage(name,classe, race);
    	
    	
    	
//        SwingUtilities.invokeLater(() -> {
//        	InterfaceGame frame = new InterfaceGame();
//            frame.setVisible(true);
//            
//        });
    }
}
