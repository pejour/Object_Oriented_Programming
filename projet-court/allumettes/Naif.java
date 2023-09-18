package allumettes;

import java.util.Random;
// On utilise la classe java.util.Scanner (cf contrainte 12).

public class Naif implements Strategie {

	// Stratégie "naif"=> ordinateur choisit aléatoirement un nombre entre 1 et PRISE_MAX.

	/** Obtenir nombre d'allumettes que le joueur veut prendre avec la stratégie "naïf".
	 * @return nombre d'allumettes tirées
	 */
	public int getPrise(Jeu jeu) {
		Random random = new Random();
		if (jeu.getNombreAllumettes() == 1) {
			return 1;
		} else {
			return random.nextInt(jeu.PRISE_MAX - 1) + 1;
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
		return "Naif";
	}


}
