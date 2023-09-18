package allumettes;

/** Exception qui indique qu'une opération interdite est effectuée. */
public class OperationInterditeException extends RuntimeException {

	// exception levée par la méthode retirer de Proxy !!!!!

	public OperationInterditeException() {
		super("");
	}

}
