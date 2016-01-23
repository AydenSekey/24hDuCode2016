package fr.soprasteria.jeu;

import javax.swing.JPanel;

public class PanneauEditeur extends JPanel{
	
	/**
	 * static Singleton instance
	 */
	private static PanneauEditeur instance;

	/**
	 * Private constructor for singleton
	 */
	private PanneauEditeur() {
	}

	/**
	 * Static getter method for retrieving the singleton instance
	 */
	public static PanneauEditeur getInstance() {
		if (instance == null) {
			instance = new PanneauEditeur();
		}
		return instance;
	}
}
