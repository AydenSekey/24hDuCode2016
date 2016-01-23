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
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fr.soprasteria.jeu.view.CaseViewFactory;
import fr.soprasteria.world.WorldGrille;

public class PanneauJeu extends JPanel{
	
	private JComponent[][] structureCase;
	
	//modele
	private WorldGrille grille;

	public PanneauJeu(WorldGrille grille) {
		this.grille = grille;
		constuire();
	}

	public PanneauJeu() {
		
	}

	private void constuire()
	{
		int x = this.grille.getNbColonnes();
		int y = this.grille.getNbLignes();
		
		this.setLayout(new GridLayout(x,y));
		structureCase = new JComponent[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				JComponent b = CaseViewFactory.getCasePourModele(grille.getCase(i,j));
				
				structureCase[i][j] = b;
			}
		}
		
		for (int ii = 0; ii < x; ii++) {
            for (int jj = 0; jj < y; jj++) {
            	this.add(structureCase[ii][jj]);
            }
		}
	}
	
	protected JComponent getGridButton(int r, int c) {
//        int index = r * 8 + c;
        return this.structureCase[r][c];
    }
	
}
