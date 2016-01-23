package fr.soprasteria.jeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanneauJeu extends JPanel{
	
	/**
	 * static Singleton instance
	 */
	private static PanneauJeu instance;

	/**
	 * Private constructor for singleton
	 * @return 
	 */
	private PanneauJeu() {
		this.setLayout(new GridLayout(0, 9));
		
		for (int i = 0; i < 9*9; i++) {
			this.add(new JButton("coucou"));
		}
	}

	/**
	 * Static getter method for retrieving the singleton instance
	 */
	public static PanneauJeu getInstance() {
		if (instance == null) {
			instance = new PanneauJeu();
		}
		return instance;
	}
}
