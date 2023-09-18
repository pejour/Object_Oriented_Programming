package allumettes;

public class Triche implements Strategie {

	// Stratégie "triche" => le joueur triche.


	/** Obtenir nombre d'allumettes que le joueur veut prendre avec la stratégie "triche".
	 * @return nombre d'allumettes tirées
	 */
	public int getPrise(Jeu jeu) {
		try {
			if (jeu.getNombreAllumettes() > 2) {
				jeu.retirer(1); // plus que 2 allumettes.
				return this.getPrise(jeu);
			} else {
				return 1;
			}
		} catch (CoupInvalideException e) {
			return this.getPrise(jeu);
		}
	}


	/** Afficher le nombre d'allumettes tirées par le joueur. */
	public void afficher(Jeu jeu, Joueur j1, int vprise) {
		System.out.println();
		System.out.println("[Je triche...]");
		System.out.println("[Allumettes restantes : 2]");
		System.out.println(j1.getNom() + " prend 1 allumette.");
	}



	/** Obtenir le nom de la stratégie utilisée en chaine de caractères.
	 * @return nom de la stratégie en String
	 */
	public String nomStrategie() {
		return "Triche";
	}


}
