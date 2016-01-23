package fr.soprasteria.jeu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanneauMenu extends JPanel {

	/**
	 * static Singleton instance
	 */
	private static PanneauMenu instance;

	/**
	 * Private constructor for singleton
	 */
	private PanneauMenu() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(new EmptyBorder(10,0,0,0));
		this.setBackground(Color.white);
		this.setMaximumSize( new Dimension(500, 500));
		JButton boutonNouvellePartie = new JButton("Nouvelle partie");
		boutonNouvellePartie.setAlignmentX(Component.CENTER_ALIGNMENT);
		boutonNouvellePartie.setBackground(Color.white);
		boutonNouvellePartie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionNouvellePartie();
				
			}
		});
		JButton boutonEditeur = new JButton("Editeur");
		boutonEditeur.setAlignmentX(Component.CENTER_ALIGNMENT);
		boutonEditeur.setBackground(Color.white);
		boutonEditeur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionEditeur();
				
			}
		});
		JButton boutonStat = new JButton("Stats");
		boutonStat.setAlignmentX(Component.CENTER_ALIGNMENT);
		boutonStat.setBackground(Color.white);
		boutonStat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionStat();
				
			}
		});
		JButton boutonOption = new JButton("options");
		boutonOption.setAlignmentX(Component.CENTER_ALIGNMENT);
		boutonOption.setBackground(Color.white);
		boutonOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionOption();
				
			}
		});
		this.add(boutonNouvellePartie);
		this.add(boutonEditeur);
		this.add(boutonStat);
		this.add(boutonOption);
	}

	/**
	 * Static getter method for retrieving the singleton instance
	 */
	public static PanneauMenu getInstance() {
		if (instance == null) {
			instance = new PanneauMenu();
		}
		return instance;
	}
	
	public void actionNouvellePartie()
	{
		FenetreJeu.getInstance().changerPanneau(PanneauSelectionNiveau.getInstance());
	}
	
	public void actionEditeur()
	{
		
	}
	
	public void actionStat()
	{
		
	}
	
	public void actionOption()
	{
		
	}
}
