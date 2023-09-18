package allumettes;

public class Arbitre {

	// Attributs.

	/** Joueurs arbitrés. */
	private Joueur j1;
	private Joueur j2;


	// Constructeurs.

	/** Créer une partie.
	 * @param vj1 joueur 1
	 * @param vj2 joueur 2
	 */
	public Arbitre(Joueur vj1, Joueur vj2) {
		j1 = new Joueur(vj1.getNom(), vj1.getStrategie());
		j2 = new Joueur(vj2.getNom(), vj2.getStrategie());
	}



	// Méthodes.

	/** Arbitrer une partie (un jeu). */
	public void arbitrer(Jeu jeu) {
		int c = 0;
		int res = -123456789;
		Joueur j;
		boolean repetitionTriche;
		// variable repetitionTriche pour redemander la prise si triche avec confiance.
		boolean saisieInvalide;
		// variable saisieInvalide => redemander au joueur si SaisirEntierException levée.
		boolean fin = false;
		// variable fin pour arrêter la partie si OperationInterditeException levée.

		while (jeu.getNombreAllumettes() > 0 && !fin) {
			if (c % 2 == 0) {
				j = j1;
			} else {
				j = j2;
			}
			if (((Partie) jeu).getConfiance()) {
				System.out.print("Nombre d'allumettes restantes : "
				+ jeu.getNombreAllumettes());
				do {
					saisieInvalide = false;
					repetitionTriche = false;
					try {
						if (j.getStrategie().nomStrategie().equals("Humain")) {
							System.out.println();
							System.out.print(j.getNom() + ", combien d'allumettes ? ");
						}
						int p = j.getPrise(jeu);
						if (p == res) {
							repetitionTriche = true;
						} else {
							j.getStrategie().afficher(jeu, j, p);
							jeu.retirer(p);
							c = c + 1;
						}
					} catch (CoupInvalideException e) {
						System.out.println("Impossible ! " + e.getMessage());
					} catch (SaisirEntierException e) {
						System.out.println(e.getMessage());
						saisieInvalide = true;
					}
				} while (saisieInvalide || repetitionTriche);
			} else {
				System.out.print("Nombre d'allumettes restantes : "
				+ jeu.getNombreAllumettes());
				do {
					saisieInvalide = false;
					Proxy proxy = new Proxy(jeu);
					try {
						if (j.getStrategie().nomStrategie().equals("Humain")) {
							System.out.println();
							System.out.print(j.getNom() + ", combien d'allumettes ? ");
						}
			    			int p = j.getPrise(proxy);
						j.getStrategie().afficher(jeu, j, p);
						jeu.retirer(p);
						c = c + 1;
					} catch (OperationInterditeException e) {
						if (j.getStrategie().nomStrategie().equals("Triche")) {
							System.out.println();
						}
						System.out.println("[Je triche...]");
						System.out.println("Abandon de la partie car "
						+ j.getNom() + " triche !");
						fin = true;
					} catch (CoupInvalideException e) {
						System.out.println("Impossible ! " + e.getMessage());
					} catch (SaisirEntierException e) {
						System.out.println(e.getMessage());
						saisieInvalide = true;
					}
				} while (saisieInvalide);
			}
			System.out.println();
			// retour à la ligne
		}

		if (!fin) {
			if (c % 2 == 0) {
				System.out.println(j2.getNom() + " perd !");
				System.out.println(j1.getNom() + " gagne !");
			} else {
				System.out.println(j1.getNom() + " perd !");
				System.out.println(j2.getNom() + " gagne !");
			}
		}
	}

}
