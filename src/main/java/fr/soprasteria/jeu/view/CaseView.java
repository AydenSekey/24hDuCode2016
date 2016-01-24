package fr.soprasteria.jeu.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import fr.soprasteria.world.cases.Case;

public class CaseView extends JLabel{

	private Case modele;
	
	public CaseView(Case c)
	{
		this.modele = c;
		afficherSaVraiNature();
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
			}
		});
	}
	
	public Case getCase(){
		return modele;
	}	

	public void afficherPersonnage()
	{
		try {
			BufferedImage image = ImageIO.read(new File("src/main/resources/images/character.png"));
			this.setIcon(new ImageIcon(image));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void retirerPersonnage()
	{
		afficherSaVraiNature();
	}
	
	public void afficherSaVraiNature() 
	{
		this.setIcon(null);
	}
	
	public Case getModele()
	{
		return this.modele;
	}
}
