package fr.soprasteria.jeu.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fr.soprasteria.world.cases.Case;

public class CibleView extends CaseView{

	public CibleView(Case c) {
		super(c);
	}
	
	public void afficherSaVraiNature()
	{
		try {
			BufferedImage image = ImageIO.read(new File("src/main/resources/images/target.png"));
			this.setIcon(new ImageIcon(image));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
