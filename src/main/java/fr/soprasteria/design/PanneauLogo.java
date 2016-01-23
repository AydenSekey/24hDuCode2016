package fr.soprasteria.design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
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
private PanneauLogo(String name) {
	this.setBackground(Color.WHITE);
	this.setLayout(new BorderLayout());
	this.label = new JLabel(name);
	this.label.setHorizontalAlignment(JLabel.CENTER);
	this.label.setVerticalAlignment(JLabel.CENTER);
	this.label.setFont(new Font("Serif", Font.PLAIN, 30));
	this.label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	this.add(label, BorderLayout.CENTER);
}

/**
 * Static getter method for retrieving the singleton instance
 */
public static PanneauLogo getInstance() {
	if (instance == null) {
		instance = new PanneauLogo("Marechal Laser");
	}
	return instance;
}
}
