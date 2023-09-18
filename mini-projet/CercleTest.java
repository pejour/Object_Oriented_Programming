import java.awt.Color;
import org.junit.*;
import static org.junit.Assert.*;

/**
  * Classe de test de la classe Cercle.
  */
public class CercleTest {

	// précision pour les comparaisons réelle
	public final static double EPS = 0.001;

	// Les points utilisés pour les tests
	private Point A1, A2;

	// Les coordonnées du centre et le rayon
	private double x, y, rayon;

	// Les cercles utilisés pour les tests
	private Cercle C1, C2, C3;

	@Before public void setUp() {
		// Construire les points
		A1 = new Point(1, 2);
		A2 = new Point(-2, 3);

		x = (A1.getX() + A2.getX()) / 2;
		y = (A1.getY() + A2.getY()) / 2;
		rayon = A1.distance(A2) / 2;


		// Construire les cercles
		C1 = new Cercle(A1, A2);
		C2 = new Cercle(A1, A2, Color.green);
		C3 = Cercle.creerCercle(A1,A2);
	}


// on effectue les tests nécessaires sur les 3 constructeurs des exigences E12, E13, E14 (cf contrainte C6)



	/* on effectue les tests sur l'exigence E12 */
	@Test public void testerE12() {
		assertEquals("test E12 sur l'abscisse du centre de C1", x, C1.getCentre().getX(), EPS);
		assertEquals("test E12 sur l'ordonnée du centre de C1", y, C1.getCentre().getY(), EPS);
		assertEquals("test E12 sur le rayon de C1", rayon, C1.getRayon(), EPS);
		assertTrue("test E12 sur la couleur de C1", C1.getCouleur() == Color.blue);           // le bleu étant la couleur par défaut
	}



	/* on effectue les tests sur l'exigence E13 */
	@Test public void testerE13() {
		assertEquals("test E13 sur l'abscisse du centre de C2", x, C2.getCentre().getX(), EPS);
		assertEquals("test E13 sur l'ordonnée du centre de C2", y, C2.getCentre().getY(), EPS);
		assertEquals("test E13 sur le rayon de C2", rayon, C2.getRayon(), EPS);
		assertTrue("test E13 sur la couleur de C2", C2.getCouleur() == Color.green);
	}



	/* on effectue les tests sur l'exigence E14 */
	@Test public void testerE14() {
		assertEquals("test E14 sur l'abscisse du centre de C3", A1.getX(), C3.getCentre().getX(), EPS);
		assertEquals("test E14 sur l'ordonnée du centre de C3", A1.getY(), C3.getCentre().getY(), EPS);
		assertEquals("test E14 sur le rayon de C3", rayon * 2, C3.getRayon(), EPS);
		assertTrue("test E14 sur la couleur de C3", C3.getCouleur() == Color.blue);
	}
	

}
