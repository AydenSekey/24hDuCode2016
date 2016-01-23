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
		
		//menu
		this.menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Menu");
		this.menuBar.add(menu1);
		JMenuItem itemEditeur = new JMenuItem("Editeur");
		itemEditeur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FenetreJeu.getInstance().chargerEditeur();
				
			}
		});
		menu1.add(itemEditeur);
		this.setJMenuBar(this.menuBar);
	}
	
	public void start()
	{
		this.setVisible(true);
	}

	public void chargerEditeur()
	{
		this.setContentPane(PanneauEditeur.getInstance());
		this.validate();
	}
}
