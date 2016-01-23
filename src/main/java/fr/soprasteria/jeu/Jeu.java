package fr.soprasteria.jeu;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

public class Jeu{
	
	private FenetreJeu _FENETRE;
	private static final String _NOM= "Marechal Laser";
	
	/**
	 * static Singleton instance
	 */
	private static Jeu instance;

	/**
	 * Private constructor for singleton
	 */
	private Jeu() {
		init();
	}

	/**
	 * Static getter method for retrieving the singleton instance
	 */
	public static Jeu getInstance() {
		if (instance == null) {
			instance = new Jeu();
		}
		return instance;
	}
	
	private void init()
	{
		_FENETRE = FenetreJeu.getInstance();
	}
	
	public void start()
	{
		_FENETRE.start();
	}
	
	public String getNom()
	{
		return _NOM;
	}
	
	public ArrayList<String> listerNiveaux()
	{
		File rep = new File("doc/levels");
		ArrayList<String> niveaux = new ArrayList<>();
		for(String niv: rep.list())
		{
			niveaux.add(niv.replace(".lvl", ""));
		}
		
		return niveaux;
	}

}
