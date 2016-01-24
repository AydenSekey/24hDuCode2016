package fr.soprasteria.jeu.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import fr.soprasteria.world.Personnage;
import fr.soprasteria.world.cases.Case;
import fr.soprasteria.world.laser.LaserDirection;

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

	public void afficherPersonnage(Personnage p)
	{
		changerPersonnage(p.getDirectionArme());
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
	
	public void changerPersonnage(LaserDirection direction)
	{
		String url = "src/main/resources/images/character_8.png";
		if(direction == LaserDirection.EST){
			url = "src/main/resources/images/character_6.png";
		}
		if(direction == LaserDirection.NORD_EST){
			url = "src/main/resources/images/character_9.png";
		}
		if(direction == LaserDirection.NORD){
			url = "src/main/resources/images/character_8.png";
		}
		if(direction == LaserDirection.NORD_OUEST){
			url = "src/main/resources/images/character_7.png";
		}
		if(direction == LaserDirection.OUEST){
			url = "src/main/resources/images/character_4.png";
		}
		try {
			BufferedImage image = ImageIO.read(new File(url));
			this.setIcon(new ImageIcon(image));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
