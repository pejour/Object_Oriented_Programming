package allumettes;

public interface Strategie {

	// On construit une interface Strategie afin de respecter la Contrainte 13.
	// Il suffit pour cela de rajouter une classe implémentant l'interface Strategie.
	// Il suffira simplement de la prendre en compte dans la classe Jouer.



	/** Obtenir le nombre d'allumettes que le joueur tire avec la stratégie choisie.
	 * @return nombre d'allumettes tirées
	 */
	int getPrise(Jeu jeu);


	/** Afficher des indications sur le nombre d'allumettes tiré par le joueur j1. */
	void afficher(Jeu jeu, Joueur j1, int vprise);


	/** Obtenir le nom de la stratégie utilisée en chaine de caractères.
	 * @return nom de la stratégie en String
	 */
	String nomStrategie();


}
