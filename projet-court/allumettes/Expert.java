package allumettes;
import java.util.Random;

public class Expert implements Strategie {

	// Stratégie "expert" => l'ordinateur joue du mieux qu'il peut.


	/** Obtenir nombre d'allumettes que le joueur veut prendre avec la stratégie "expert".
	 * @return nombre d'allumettes tirées
	 */
	public int getPrise(Jeu jeu) {
		Random random = new Random();
		if (jeu.getNombreAllumettes() == 1) {
			return 1;
        	} else if ((jeu.getNombreAllumettes() - 1) % (jeu.PRISE_MAX + 1) == 0) {
			return random.nextInt(Math.min(jeu.PRISE_MAX, jeu.getNombreAllumettes())) + 1;
		} else {
			return (jeu.getNombreAllumettes() - 1) % (jeu.PRISE_MAX + 1);
        	}
	}


	/** Afficher le nombre d'allumettes tirées par le joueur. */
	public void afficher(Jeu jeu, Joueur j1, int vprise) {
		System.out.println();
		if (vprise > 1) {
			System.out.println(j1.getNom() + " prend " + vprise + " allumettes.");
		} else {
			System.out.println(j1.getNom() + " prend " + vprise + " allumette.");
		}
	}


	/** Obtenir le nom de la stratégie utilisée en chaine de caractères.
	 * @return nom de la stratégie en String
	 */
	public String nomStrategie() {
		return "Expert";
	}


}
