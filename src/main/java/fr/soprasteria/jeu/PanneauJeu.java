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

public class PanneauJeu extends JPanel{
	
	/**
	 * static Singleton instance
	 */
	private static PanneauJeu instance;
	private JComponent[][] structureCase;
	

	/**
	 * Private constructor for singleton
	 * @return 
	 */
	public PanneauJeu() {
		this.setLayout(new GridLayout(8, 8));
		structureCase = new JComponent[8][8];
		for (int i = 0; i < structureCase.length; i++) {
			for (int j = 0; j < structureCase[i].length; j++) {
				//this.add(new JButton("coucou"));
				JComponent b = new JLabel("coucou x:" + i + ", y:" + j);
				ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
				//b.setIcon(icon);
				structureCase[j][i] = b;
			}
		}
		
		for (int ii = 0; ii < structureCase.length; ii++) {
            for (int jj = 0; jj < structureCase.length; jj++) {
            	this.add(structureCase[jj][ii]);
            }
		}
		
	}

	protected JComponent getGridButton(int r, int c) {
//        int index = r * 8 + c;
        return this.structureCase[r][c];
    }
	
}
