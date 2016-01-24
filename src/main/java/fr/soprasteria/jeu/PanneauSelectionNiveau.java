package fr.soprasteria.jeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.soprasteria.world.fabriques.FabriqueSimpleWorlds;

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
		titre.setHorizontalAlignment(JLabel.CENTER);
		titre.setFont(new Font("Serif", Font.PLAIN, 30));
		this.add(titre,BorderLayout.NORTH);
		this.add(this.getPanneauListeNiveaux(),BorderLayout.CENTER);
		
		
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
		panneau.setOpaque(true);
		panneau.setBackground(Color.white);
		panneau.setLayout(new FlowLayout());
		for(String niv: (Jeu.getInstance().listerNiveaux()))
		{
			JLabel l = new JLabel(niv);
			Dimension d = new Dimension(75,75);
			l.setPreferredSize(d);
			l.setMinimumSize(d);
			l.setSize(d);
//			l.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			l.setHorizontalAlignment(JLabel.CENTER);
			l.setBackground(Color.black);
			l.setForeground(Color.white);
			l.setOpaque(true);
			l.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					File file = new File("doc/levels/"+((JLabel)e.getComponent()).getText()+".lvl");
					
					PanneauJeuGaming pan = new PanneauJeuGaming(FabriqueSimpleWorlds.withObstacleWorldExemple1());
					FenetreJeu.getInstance().changerPanneau(pan);
					
					
				}
			});
			panneau.add(l);
		}
		
		return panneau;
	}
}
