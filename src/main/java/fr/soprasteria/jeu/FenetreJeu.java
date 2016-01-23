package fr.soprasteria.jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FenetreJeu extends JFrame{
	
	/**
	 * static Singleton instance
	 */
	private static FenetreJeu instance;
	
	private static final String _FRAME_NAME= "Marechal Laser";
	
	private JMenuBar menuBar;

	/**
	 * Private constructor for singleton
	 */
	private FenetreJeu() {
		super(_FRAME_NAME);
		init();
	}

	/**
	 * Static getter method for retrieving the singleton instance
	 */
	public static FenetreJeu getInstance() {
		if (instance == null) {
			instance = new FenetreJeu();
		}
		return instance;
	}
	
	private void init()
	{
		this.setSize(1000,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(PanneauAccueil.getInstance());
	}
	
	public void start()
	{
		//this.pack();
		this.setVisible(true);
	}

	public void chargerEditeur()
	{
		this.setContentPane(PanneauEditeur.getInstance());
		this.validate();
	}
	
	public void changerPanneau(JPanel panneau)
	{
		this.setContentPane(panneau);
		this.validate();
	}
}
