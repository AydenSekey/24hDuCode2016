package fr.soprasteria.jeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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

import fr.soprasteria.jeu.view.CaseView;
import fr.soprasteria.jeu.view.CaseViewFactory;
import fr.soprasteria.world.Personnage;
import fr.soprasteria.world.WorldGrille;
import fr.soprasteria.world.fabriques.FabriqueSimpleWorlds;

public class PanneauJeu extends JPanel{
	
	private JComponent[][] structureCase;
	
	//modele
	private WorldGrille grille;

	public PanneauJeu(WorldGrille grille) {
		this.grille = grille;
		constuire();
	}

	public PanneauJeu() {
		this.grille = FabriqueSimpleWorlds.emptyWorld(10, 5);
	}

	private void constuire()
	{
		
		System.out.println(this.grille);
		
		int x = this.grille.getNbColonnes();
		int y = this.grille.getNbLignes();
		this.setBackground(Color.white);
		this.setLayout(new GridLayout(y, x));
		structureCase = new JComponent[x][y];
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				JComponent b = CaseViewFactory.getCasePourModele(grille.getCase(j,i));
				b.setPreferredSize(new Dimension(10, 10));
				structureCase[j][i] = b;
				this.add(structureCase[j][i]);
			}
		}
		
		for(Personnage p: this.grille.getPersonnages())
		{
			((CaseView)structureCase[p.getX()][p.getY()]).afficherPersonnage();
		}
	}
	
	protected JComponent getGridButton(int r, int c) {
//        int index = r * 8 + c;
        return this.structureCase[r][c];
    }
	
}
