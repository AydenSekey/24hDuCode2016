package fr.soprasteria.jeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanneauJeu extends JPanel{
	
	/**
	 * static Singleton instance
	 */
	private static PanneauJeu instance;
	private JButton[][] structureCase;

	/**
	 * Private constructor for singleton
	 * @return 
	 */
	private PanneauJeu() {
		this.setLayout(new GridLayout(8, 8));
		structureCase = new JButton[8][8];
		for (int i = 0; i < structureCase.length; i++) {
			for (int j = 0; j < structureCase[i].length; j++) {
				//this.add(new JButton("coucou"));
				JButton b = new JButton("coucou x:" + i + ", y:" + j);
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
		
		JButton c = this.getGridButton(2,3);
		c.setText("coucou");
	}

	private JButton getGridButton(int r, int c) {
//        int index = r * 8 + c;
        return this.structureCase[r][c];
    }
	/**
	 * Static getter method for retrieving the singleton instance
	 */
	public static PanneauJeu getInstance() {
		if (instance == null) {
			instance = new PanneauJeu();
		}
		return instance;
	}
	
	
}
