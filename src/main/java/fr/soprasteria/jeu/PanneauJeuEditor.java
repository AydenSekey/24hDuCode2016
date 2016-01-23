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

public class PanneauJeuEditor extends PanneauJeu{

	/**
	 * Private constructor for singleton
	 * @return 
	 */
	public PanneauJeuEditor() {
		super();
	}

	public JPanel lancerEditor() {
		// TODO Auto-generated method stub
		JComponent c = this.getGridButton(2,3);
		
		
		JButton boutonStat = new JButton("Stats");
		boutonStat.setAlignmentX(Component.CENTER_ALIGNMENT);
		boutonStat.setBackground(Color.white);
		boutonStat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComponent c = getGridButton(2,3);
				JComponent d = getGridButton(7,7);
			}
		});
		this.add(boutonStat);
		
		return this;
	}
	
}
