package allumettes;
// La classe Proxy hérite de la classe Partie.
// La classe Proxy traite les cas de tricherie quand l'arbitre n'a pas confiance.

public class Proxy extends Partie {

	// Attributs.

	/** Jeu associé au Proxy. */
	private Jeu jeu;


	// Constructeurs.

	/** Créer le proxy à partir du jeu.
	 * @param jeu le jeu à partir duquel on crée le proxy
	 */
	public Proxy(Jeu jeu) {
		super(false);
		this.jeu = jeu;
	}


	// Méthodes.

	/** Obtenir le nombre d'allumettes encore en jeu.
	 * @return nombre d'allumettes encore en jeu
	 */
	@Override
	public int getNombreAllumettes() {
		return jeu.getNombreAllumettes();
	}


	/** Retirer des allumettes.
	 * @param nbPrises nombre d'allumettes prises.
	 * @throws OperationInterditeException triche sans confiance de l'arbitre.
	 */
	@Override
	public void retirer(int nbPrises) {
		throw new OperationInterditeException();
	}

}
