package allumettes;
import org.junit.*;
import static org.junit.Assert.*;

/** Programme de test de la classe Strategie Rapide.*/

public class RapideTest {

	// On définit les attributs de notre classe de test.

	private Joueur j1;

	private Partie p1;

	private Partie p2;

	private Proxy p3;

	@Before
	public void setUp() {
        	j1 = new Joueur("j1", new Rapide());
		p1 = new Partie(true);
		p2 = new Partie(false);
	}

	@Test
	public void testNomStrategie() {
        	assertEquals(j1.getStrategie().nomStrategie(), "Rapide");
	}

	@Test
	public void testgetPriseTrue() {
		try {
			for (int i=0; i<11; i++) {
				assertEquals(j1.getStrategie().getPrise(p1), 3);
				p1.retirer(1);
			}
			assertEquals(j1.getStrategie().getPrise(p1), 2);
			// j1 prend bien 2 allumettes quand il n'en reste que 2.
			p1.retirer(1);
			assertEquals(j1.getStrategie().getPrise(p1), 1);
			// j1 prend bien 1 allumette quand il n'en reste que 1.
		} catch (CoupInvalideException e) {
		// Nécessaire pour que le programme compile.
		}
	}

	@Test
	public void testgetPriseFalse() {
        	try {
			for (int i=0; i<11; i++) {
				assertEquals(j1.getStrategie().getPrise(p2), 3);
				p2.retirer(1);
			}
			assertEquals(j1.getStrategie().getPrise(p2), 2);
			// j1 prend bien 2 allumettes quand il n'en reste que 2.
			p2.retirer(1);
			assertEquals(j1.getStrategie().getPrise(p2), 1);
			// j1 prend bien 1 allumette quand il n'en reste que 1.
		} catch (CoupInvalideException e) {
		// Nécessaire pour que le programme compile.
		}
	}


	@Test
	public void testgetPriseProxy() {
        	try {
			for (int i=0; i<11; i++) {
				p3 = new Proxy(p2);
				assertEquals(j1.getStrategie().getPrise(p3), 3);
				p2.retirer(1);
			}
			p3 = new Proxy(p2);
			assertEquals(j1.getStrategie().getPrise(p3), 2);
			// j1 prend bien 2 allumettes quand il n'en reste que 2.
			p2.retirer(1);
			p3 = new Proxy(p2);
			assertEquals(j1.getStrategie().getPrise(p3), 1);
			// j1 prend bien 1 allumette quand il n'en reste que 1.
		} catch (CoupInvalideException e) {
		// Nécessaire pour que le programme compile.
		}
	}

}
