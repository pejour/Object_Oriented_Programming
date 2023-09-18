package allumettes;

/** Exception levée si l'utilisateur ne rentre pas un entier. */
public class SaisirEntierException extends RuntimeException {

	// exception levée par la méthode getPrise() de Humain !!!!!

	public SaisirEntierException() {
		super("Vous devez donner un entier.");
	}

}
