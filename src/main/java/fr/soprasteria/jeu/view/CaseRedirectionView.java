package fr.soprasteria.jeu.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fr.soprasteria.world.cases.Case;

public class CaseRedirectionView extends CaseView {

	public CaseRedirectionView(Case c) {
		super(c);
	}

	public void afficherSaVraiNature()
	{
		try {
			// TODO Modifier l'image
			BufferedImage image = ImageIO.read(new File("src/main/resources/images/wall.png"));
			this.setIcon(new ImageIcon(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
