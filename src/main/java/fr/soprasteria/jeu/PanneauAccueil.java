package fr.soprasteria.jeu;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.soprasteria.design.PanneauLogo;

public class PanneauAccueil extends JPanel{

	/**
	 * static Singleton instance
	 */
	private static PanneauAccueil instance;

	/**
	 * Private constructor for singleton
	 */
	private PanneauAccueil() {
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.setBorder(new EmptyBorder(50, 75, 50, 75));
		this.setBackground(Color.white);
		this.add(PanneauLogo.getInstance());
		this.add(PanneauMenu.getInstance());
	}

	/**
	 * Static getter method for retrieving the singleton instance
	 */
	public static PanneauAccueil getInstance() {
		if (instance == null) {
			instance = new PanneauAccueil();
		}
		return instance;
	}
}
