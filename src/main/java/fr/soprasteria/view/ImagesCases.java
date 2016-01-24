package fr.soprasteria.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fr.soprasteria.world.cases.Case;
import fr.soprasteria.world.cases.Cible;
import fr.soprasteria.world.cases.Obstacle;

public enum ImagesCases{

	OBSTACLE_SOLIDE("Obstacle solide", "src/main/resources/images/wall.png","Obstacle"),
//	OBSTACLE_DESTRUCTIBLE("Obstacle destructible", ""),
//	REFLEXION("Reflexion", ""),
	PERSONNAGE("Personnage","src/main/resources/images/character.png","Personnage"),
	CIBLE("Cible","src/main/resources/images/target.png","Cible");
	//REFRACTION("Refraction",""),
	//DIFFRACTION("Diffraction",""),
	//DEVIATION("Deviation","");

	private final String nom;
	private final String lienImage;
	private final String ca;

	private ImagesCases(String nom , String lienImage,String ca) {
		this.nom = nom;
		this.lienImage = lienImage;
		this.ca=ca;
	}

	public String getNom() {
		return nom;
	}

	public String getLienImage() {
		return lienImage;
	}
	
	public String getCase() {
		return ca;
	}
		
}
