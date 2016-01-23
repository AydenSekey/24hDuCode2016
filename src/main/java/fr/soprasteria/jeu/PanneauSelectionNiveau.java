package fr.soprasteria.jeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauSelectionNiveau extends JPanel{

	/**
	 * static Singleton instance
	 */
	private static PanneauSelectionNiveau instance;

	/**
	 * Private constructor for singleton
	 */
	private PanneauSelectionNiveau(){
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JLabel titre = new JLabel("Levels");
		this.add(titre,BorderLayout.NORTH);
		this.add(this.getPanneauListeNiveaux(),BorderLayout.SOUTH);
		
	}

	/**
	 * Static getter method for retrieving the singleton instance
	 */
	public static PanneauSelectionNiveau getInstance() {
		if (instance == null) {
			instance = new PanneauSelectionNiveau();
		}
		return instance;
	}
	
	public JPanel getPanneauListeNiveaux()
	{
		JPanel panneau = new JPanel();
		
		panneau.setLayout(new FlowLayout());
		for(int i = 0; i < 5; i++)
		{
			JLabel l = new JLabel(""+i);
			l.setSize(50, 50);
			l.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			panneau.add(l);
		}
		
		return panneau;
	}
}
