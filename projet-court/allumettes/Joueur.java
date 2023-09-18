package allumettes;

public class Joueur {


	// Attributs.

	/** Nom du joueur. */
	private String nom;

	/** Stratégie du joueur. */
	private Strategie strategie;



	// Constructeurs.

	/** Créer un joueur à partir de son nom et de sa stratégie.
	 * @param vnom nom du joueur
	 * @param vstrategie stratégie du joueur
	 */
	public Joueur(String vnom, Strategie vstrategie) {
        	this.nom = vnom;
        	this.strategie = vstrategie;
	}


	// On définit les méthodes.

	/** Obtenir le nom du joueur.
	 * @return nom du joueur
	 */
	public String getNom() {
        	return this.nom;
	}


	/** Obtenir la stratégie du joueur.
	 * @return stratégie du joueur
	 */
	public Strategie getStrategie() {
        	return this.strategie;
	}


	/** Obtenir le nombre d'allumettes que le joueur veut prendre.
	 * @return nombre d'allumettes tirées
	 */
	public int getPrise(Jeu jeu) {
		return getStrategie().getPrise(jeu);
	}


}
