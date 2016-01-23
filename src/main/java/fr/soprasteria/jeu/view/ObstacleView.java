package fr.soprasteria.jeu.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import fr.soprasteria.world.cases.Case;

public class ObstacleView extends CaseView {

	public ObstacleView(Case c) {
		super(c);
		//this.setText("X");
		
		try {
			BufferedImage image = ImageIO.read(new File("src/main/resources/images/wall.png"));
			this.setIcon(new ImageIcon(image));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
