package allumettes;

import java.util.Scanner;
// On utilise la classe java.util.Scanner (cf contrainte 8).

public class Humain implements Strategie {

	// Stratégie "humain"=> ordinateur demande utilisateur nb allumettes qu'il veut tirer.

	// Attribut de classe.

	public static final Scanner SCANNER = new Scanner(System.in);



	/** Obtenir nombre d'allumettes que le joueur veut prendre avec la stratégie "humain".
	 * @return nombre d'allumettes tirées
	 */
	public int getPrise(Jeu jeu) {
		int res = -123456789;
		String ligne = Humain.SCANNER.nextLine();
		// on utilise scanner.nextLine()
		try {
            		return Integer.parseInt(ligne);      // lui demander
		} catch (NumberFormatException e) {
			if (ligne.equals("triche")) {
				if (jeu.getNombreAllumettes() > 1) {
					System.out.println("[Une allumette en moins, plus que "
					+ (jeu.getNombreAllumettes() - 1) + ". Chut !]");
					try {
						jeu.retirer(1);
					} catch (CoupInvalideException c) {
					// situation qui n'arrivera jamais.
					}
				} else {
					System.out.println("Triche alors qu'il ne reste qu'1 allumette.");
				}
				return res;
			} else {
				throw new SaisirEntierException();
			}
		}
	}


	/** Afficher le nombre d'allumettes tirées par le joueur. */
	public void afficher(Jeu jeu, Joueur j1, int vprise) {
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
		return "Humain";
	}

}
