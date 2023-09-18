package allumettes;

/** Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 * @author	Xavier Crégut
 * @version	$Revision: 1.5 $
 */
public class Jouer {

	/** Lancer une partie. En argument sont donnés les deux joueurs sous
	 * la forme nom@stratégie.
	 * @param args la description des deux joueurs
	 */
	public static void main(String[] args) {
		try {
			verifierNombreArguments(args);
			int i;
			boolean conf;
			if (args.length == 2) {
				i = 0;
				conf = false;
			} else if (args[0].equals("-confiant")) {
				i = 1;
				conf = true;
			} else {
				throw new ConfigurationException("Ligne de commande mal écrite.");
			}
			Joueur j1 = creationJoueur(args[i]);
			Joueur j2 = creationJoueur(args[i + 1]);
			Arbitre arbitre = new Arbitre(j1, j2);
			Partie partie = new Partie(conf);
			arbitre.arbitrer(partie);
		} catch (ConfigurationException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
			System.exit(1);
		}
		// on traite exceptions dans classes Arbitre, Humain et Partie (contrainte 11).
	}


	private static void verifierNombreArguments(String[] args) {
		final int nbJoueurs = 2;
		if (args.length < nbJoueurs) {
			throw new ConfigurationException("Trop peu d'arguments : "
					+ args.length);
		}
		if (args.length > nbJoueurs + 1) {
			throw new ConfigurationException("Trop d'arguments : "
					+ args.length);
		}
	}

	/** Afficher des indications sur la manière d'exécuter cette classe. */
	public static void afficherUsage() {
		System.out.println("\n" + "Usage :"
				+ "\n\t" + "java allumettes.Jouer joueur1 joueur2"
				+ "\n\t\t" + "joueur est de la forme nom@stratégie"
				+ "\n\t\t" + "strategie = naif | rapide | expert | humain | tricheur"
				+ "\n"
				+ "\n\t" + "Exemple :"
				+ "\n\t" + "	java allumettes.Jouer Xavier@humain "
					   + "Ordinateur@naif"
				+ "\n"
				);
	}


	/** Créer un joueur à partir des données de la ligne de commande.
	 * @param args arguments de la ligne de commande.
	 */
	public static Joueur creationJoueur(String args) {

	// on récupère les arguments avec la méthode split de String (cf contrainte 10).
		String[] part = args.split("@");
		Strategie s;
		if (part.length != 2) {
			throw new ConfigurationException("Ligne de commande mal écrite.");
		}
		String nom = part[0];
		String strat = part[1];

		switch (strat) {
			case "humain":
				s = new Humain();
				break;
			case "naif":
				s = new Naif();
				break;
			case "rapide":
				s = new Rapide();
				break;
			case "expert":
				s = new Expert();
				break;
			case "tricheur":
				s = new Triche();
				break;
			default :
				throw new ConfigurationException("Stratégie inconnue.");
		}

		return new Joueur(nom, s);
	}


}
