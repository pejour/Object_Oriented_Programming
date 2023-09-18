package allumettes;

public class Rapide implements Strategie {

	// Stratégie "rapide" => l'ordinateur prend le maximum d'allumettes possibles.

	/** Obtenir nombre d'allumettes que le joueur veut prendre avec la stratégie "rapide".
	 * @return nombre d'allumettes tirées
	 */
	public int getPrise(Jeu jeu) {
		if (jeu.getNombreAllumettes() < jeu.PRISE_MAX) {
			return jeu.getNombreAllumettes();
		} else {
			return jeu.PRISE_MAX;
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
		return "Rapide";
	}


}
