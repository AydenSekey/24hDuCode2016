package fr.soprasteria.jeu;

import javax.swing.JFrame;

public class Jeu{
	
	private static Jeu _instance;
	private FenetreJeu _FENETRE;
	
	private Jeu(){
		init();
	}
	
	public static Jeu getInstance()
	{
		if(_instance == null)
		{
			_instance = new Jeu();
		}
		return _instance;
	}
	
	private void init()
	{
		_FENETRE = FenetreJeu.getInstance();
	}
	
	public void start()
	{
		_FENETRE.start();
	}

}
