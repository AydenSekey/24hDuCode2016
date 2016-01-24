package fr.soprasteria.jeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
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
		this.setBorder(new EmptyBorder(10,0,0,0));
		this.setBackground(Color.white);
		this.setMaximumSize( new Dimension(500, 500));
		
		BoxLayout box = new BoxLayout(this,BoxLayout.Y_AXIS);
		this.setLayout(box);
		
		Dimension dim = new Dimension(150,40);
		
		JButton boutonNouvellePartie = new JButton("Nouvelle partie");
		boutonNouvellePartie.setAlignmentX(Component.CENTER_ALIGNMENT);
		boutonNouvellePartie.setBackground(Color.white);
		boutonNouvellePartie.setMinimumSize(dim);
		boutonNouvellePartie.setMaximumSize(dim);
		boutonNouvellePartie.setPreferredSize(dim);
		boutonNouvellePartie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionNouvellePartie();
				
			}
		});
		JButton boutonEditeur = new JButton("Editeur");
		boutonEditeur.setAlignmentX(Component.CENTER_ALIGNMENT);
		boutonEditeur.setBackground(Color.white);
		boutonEditeur.setMinimumSize(dim);
		boutonEditeur.setMaximumSize(dim);
		boutonEditeur.setPreferredSize(dim);
		boutonEditeur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionEditeur();
				
			}
		});
		JButton boutonStat = new JButton("Stats");
		boutonStat.setAlignmentX(Component.CENTER_ALIGNMENT);
		boutonStat.setBackground(Color.white);
		boutonStat.setMinimumSize(dim);
		boutonStat.setMaximumSize(dim);
		boutonStat.setPreferredSize(dim);
		boutonStat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionStat();
				
			}
		});		
		JButton boutonOption = new JButton("Options");
		boutonOption.setAlignmentX(Component.CENTER_ALIGNMENT);
		boutonOption.setBackground(Color.white);
		boutonOption.setMinimumSize(dim);
		boutonOption.setMaximumSize(dim);
		boutonOption.setPreferredSize(dim);
		boutonOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionOption();
				
			}
		});
		
		Dimension minSize = new Dimension(5, 12);
		Dimension prefSize = new Dimension(5, 12);
		Dimension maxSize = new Dimension(Short.MAX_VALUE, 12);
		
		this.add(boutonNouvellePartie);
		this.add(new Box.Filler(minSize, prefSize, maxSize));
		this.add(boutonEditeur);
		this.add(new Box.Filler(minSize, prefSize, maxSize));
		this.add(boutonStat);
		this.add(new Box.Filler(minSize, prefSize, maxSize));
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
		FenetreJeu.getInstance().changerPanneau(PanneauEditeur.getInstance());
	}
	
	public void actionStat()
	{
	}
	
	public void actionOption()
	{
		
	}
}
