package fr.soprasteria.world.exceptions;

/**
 * Exception de coordonnée (ligne, colonne) invalide.
 */
public class InvalideCoordonneeGrilleException extends RuntimeException {
	
	/**
	 * Crée une exception de direction incorrecte.
	 * 
	 * @param message le message de l'exception.
	 */
	public InvalideCoordonneeGrilleException(String message) {
		super(message);
	}

	/**
	 * Crée une exception de direction incorrecte, avec un message par défaut en fonction des coordonnées.
	 * 
	 * @param col le numéro de colonne de la coordonnée invaide
	 * @param li le numéro de ligne de la coordonnée invalide
	 */
	public InvalideCoordonneeGrilleException(int col, int li) {
		super("Coordonnées invalides : ligne=" + li + "; colonne=" + col);
	}
}
