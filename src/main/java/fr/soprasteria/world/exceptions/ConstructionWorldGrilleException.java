package fr.soprasteria.world.exceptions;

/**
 * Exception provenant d'une erreur de construction d'une grille 2D sous forme de grille.
 */
public class ConstructionWorldGrilleException extends RuntimeException {
	
	/**
	 * Crée une exception de construction de LabGrille2D.
	 * 
	 * @param message le message d'erreur.
	 */
	public ConstructionWorldGrilleException(String message) {
		super(message);
	}
	
	/**
	 * Crée une exception de construction de LabGrille2D avec le message par défaut en fonction des paramètres de construction.
	 * 
	 * @param nbColParam le nombre de colonnes demandées à la construction.
	 * @param nbLiParam le nombre de lignes demandées à la construction.
	 */
	public ConstructionWorldGrilleException(final int nbColParam, final int nbLiParam) {
		this("Paramètre de construction incorrects : col=" + nbColParam + ", li=" + nbLiParam);
	}
}
