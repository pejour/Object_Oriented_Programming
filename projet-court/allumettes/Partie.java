package allumettes;
// La classe Partie implémente l'interface Jeu.

public class Partie implements Jeu {

	// Attribut de classe.

	/** Nombre d'allumettes dans le jeu. */
	private static final int NBALLUMETTESINITIAL = 13;
	// Il ne vaut pas forcémént 13 (cf contrainte 9).


	// Attributs.

	/** Confiance de l'arbitre. */
	private int nbAllumettes;


	/** Confiance de l'arbitre. */
	private boolean confiance;


	// Constructeurs.

	/** Créer une partie à partir de la confiance.
	 * @param vconfiance l'arbitre est-il confiant ?
	 */
	public Partie(boolean vconfiance) {
        	this.nbAllumettes = Partie.NBALLUMETTESINITIAL;
        	this.confiance = vconfiance;
	}



	// Méthodes.

	/** Obtenir le nombre d'allumettes encore en jeu.
	 * @return nombre d'allumettes encore en jeu
	 */
	public int getNombreAllumettes() {
		return this.nbAllumettes;
	}


	/** Obtenir la confiance de l'arbitre dans la partie.
	 * @return confiance de l'arbitre
	 */
	public boolean getConfiance() {
		return this.confiance;
	}




	/** Retirer des allumettes.  Le nombre d'allumettes doit Ãªtre compris
	 * entre 1 et PRISE_MAX, dans la limite du nombre d'allumettes encore
	 * en jeu.
	 * @param nbPrises nombre d'allumettes prises.
	 * @throws CoupInvalideException tentative de prendre un nombre invalide d'alumettes
	 */
	public void retirer(int nbPrises) throws CoupInvalideException {

		if (nbPrises <= nbAllumettes && nbPrises > 0 && nbPrises <= Jeu.PRISE_MAX) {
			this.nbAllumettes = this.nbAllumettes - nbPrises;
		} else {
			if (nbPrises > nbAllumettes) {
				throw new CoupInvalideException(nbPrises, "> " + nbAllumettes);
            		} else if (nbPrises > Jeu.PRISE_MAX) {
                		throw new CoupInvalideException(nbPrises, "> " + Jeu.PRISE_MAX);
			} else {
				throw new CoupInvalideException(nbPrises, "< 1");
			}
		}
	}




}
