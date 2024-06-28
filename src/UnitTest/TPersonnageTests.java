package UnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Univers.TPersonnage;
import Univers.Enum.ERace;
import Univers.classe.AClasseGuerrier;

	public class TPersonnageTests {
	    private TPersonnage personnage;
	    private final int ARMOR_CLASS = 12;

	    @BeforeEach
	    public void setUp() {
	        // On initialise un personnage avant chaque test
	        personnage = new TPersonnage("Héros", new AClasseGuerrier(), ERace.HUMAIN);
	    }

	    @Test
	    public void testInitialLifePoints() {
	        // Vérifie que les points de vie initiaux sont correctement définis
	    	System.out.println(personnage.getRace().getHitPointsMax() + " " + personnage.getPointVie());
	        assertEquals("Les points de vie initiaux devraient être au maximum", personnage.getRace().getHitPointsMax(), personnage.getPointVie());
	    }

	    @Test
	    public void testTakeDamage() {
	        // Vérifie que les points de vie sont correctement déduits après des dégâts
	        int damage = 5;
	        personnage.pertPointVie(damage);
	        assertEquals("Les points de vie après dommage devraient être réduits", personnage.getRace().getHitPointsMax() - damage, personnage.getPointVie());
	    }

	    @Test
	    public void testHealing() {
	        // Réduit les points de vie et puis teste la guérison
	        personnage.pertPointVie(10); // Réduit de 10 points
	        personnage.gagnePointVie(5); // Guérit de 5 points
	        assertEquals("Les points de vie après guérison devraient augmenter", personnage.getRace().getHitPointsMax() - 5, personnage.getPointVie());
	    }

	    @Test
	    public void testOverHealing() {
	        // Vérifie que les points de vie ne dépassent pas le maximum
	        personnage.gagnePointVie(5); // Tente de guérir au-delà du max
	        assertEquals("Les points de vie ne devraient pas dépasser le maximum", personnage.getRace().getHitPointsMax(), personnage.getPointVie());
	    }

	    @Test
	    public void testArmorClass() {
	        // Vérifie que la classe d'armure est correctement définie
	        assertEquals("La classe d'armure devrait être définie à la création", ARMOR_CLASS, personnage.getClasseArmur());
	    }

}
