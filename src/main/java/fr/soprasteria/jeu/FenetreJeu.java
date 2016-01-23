package fr.soprasteria.jeu;

import javax.swing.*;

public class FenetreJeu extends JFrame{
	
	/**
	 * static Singleton instance
	 */
	private static FenetreJeu instance;
	
	private static final String _FRAME_NAME= "Trouvez un putain de nom au jeu";
	
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
		
		//menu
		this.menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Menu");
		this.menuBar.add(menu1);
		menu1.add((new JMenuItem("Editeur")));
		this.setJMenuBar(this.menuBar);
	}
	
	public void start()
	{
		this.setVisible(true);
	}

}
