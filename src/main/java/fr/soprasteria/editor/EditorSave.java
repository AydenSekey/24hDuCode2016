package fr.soprasteria.editor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.soprasteria.world.WorldGrille;
import fr.soprasteria.world.persistence.WorldFileSerializer;

public class EditorSave {
	
	private WorldFileSerializer wfs;
	private File wordFile;
	
	public EditorSave(WorldGrille grille,JPanel panel)
	{
		wfs = new WorldFileSerializer();
		try {
			wfs.save(getWordFile(panel), grille);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public EditorSave(WorldGrille grille,JPanel panel,String demo)
	{
		wfs = new WorldFileSerializer();
		try {
			wfs.save(new File("doc/levels/editor_levels/"+demo+".lvl"), grille);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private File getWordFile(JPanel panel){
		
		String path = "doc/levels/editor_levels";
        
        String text=JOptionPane.showInputDialog("Entrer le nom du fichier");
        
        
        path = path +"/"+ text;
        
        takeSnapShot(panel,path);
		
		File wordFile = new File(path + ".lvl");
		return wordFile;		
		
	}
	
	
	void takeSnapShot(JPanel panel,String path)
	{
	  // Create a new image with the JComponent size
	  BufferedImage bufImage = new BufferedImage(panel.getSize().width, panel.getSize().height,BufferedImage.TYPE_INT_ARGB);
	  // The panel draw itself into the graphics of the image
	  panel.paint(bufImage.createGraphics());
	  // Instantiate a file for saving the screenshot
	  File imageFile = new File(path + ".png");
	  try
	  {
	    imageFile.createNewFile();
	    ImageIO.write(bufImage, "png", imageFile);
	  }
	  catch(Exception ex)
	  {
	    ex.printStackTrace();
	  }
	}
	
	
}
