package fr.soprasteria.design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.soprasteria.jeu.Jeu;

public class PanneauLogo extends JPanel{
/**
 * static Singleton instance
 */
private static PanneauLogo instance;

private JLabel label;

/**
 * Private constructor for singleton
 */
private PanneauLogo() {
	this.setBackground(Color.WHITE);
	this.setLayout(new BorderLayout());
	this.label = new JLabel(new ImageIcon("index.png"));
//	this.label.setSize(new Dimension(200,100));
//	this.label.setHorizontalAlignment(JLabel.CENTER);
//	this.label.setVerticalAlignment(JLabel.CENTER);
//	this.label.setFont(new Font("Serif", Font.PLAIN, 30));
	this.label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	this.add(label, BorderLayout.CENTER);
}

/**
 * Static getter method for retrieving the singleton instance
 */
public static PanneauLogo getInstance() {
	if (instance == null) {
		instance = new PanneauLogo();
	}
	return instance;
}
}
