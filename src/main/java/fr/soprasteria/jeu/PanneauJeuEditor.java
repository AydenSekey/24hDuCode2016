package fr.soprasteria.jeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import fr.soprasteria.editor.EditeurView;
import fr.soprasteria.jeu.view.CaseView;
import fr.soprasteria.jeu.view.CaseViewFactory;
import fr.soprasteria.jeu.view.CibleView;
import fr.soprasteria.world.WorldGrille;
import fr.soprasteria.world.cases.Case;
import fr.soprasteria.world.cases.Cible;

public class PanneauJeuEditor extends PanneauJeu implements MouseListener{

	/**
	 * Private constructor for singleton
	 * @return 
	 */
	public PanneauJeuEditor(WorldGrille grille) {
		super(grille);
		setBackground(Color.WHITE);
		Object blackline = BorderFactory.createLineBorder(Color.black);
		for(int i=0;i<grille.getNbColonnes();i++){
			for(int j=0;j<grille.getNbLignes();j++){
				JComponent component = getGridButton(i, j);
				component.setOpaque(true);
				component.setBackground(Color.WHITE);
				component.setBorder((Border) blackline);
				component.addMouseListener(this);
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		CaseView c = (CaseView) e.getSource();
		System.out.println("Col : " + c.getCase().getColonne() + " | Lig : " + c.getCase().getLigne() + " CLICKED");
		
		Case newCase = new Cible();
				
		this.getGrille().setCase(c.getCase().getColonne(), c.getCase().getLigne(), newCase);
		this.setGridButton(c.getCase().getColonne(), c.getCase().getLigne(), CaseViewFactory.getCasePourModele(newCase));
		
		this.repaint();
		this.validate();
		
		/*for(int i=0;i<this.getGrille().getNbColonnes();i++){
			for(int j=0;j<this.getGrille().getNbLignes();j++){
				System.out.println(i + " " + j + " " +this.getGrille().getCase(i, j).getClass().getName());
			}
		}*/
				
		//EditeurView.getInstance().updatePanelWorld(new PanneauJeuEditor(this.getGrille));
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}
