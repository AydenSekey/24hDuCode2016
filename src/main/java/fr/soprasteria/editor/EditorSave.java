package fr.soprasteria.editor;

import java.awt.TextField;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fr.soprasteria.world.WorldGrille;
import fr.soprasteria.world.persistence.WorldFileSerializer;

public class EditorSave {
	
	private WorldFileSerializer wfs;
	private File wordFile;
	
	public EditorSave(WorldGrille grille)
	{
		wfs = new WorldFileSerializer();		
		try {
			wfs.save(getWordFile(), grille);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public EditorSave(WorldGrille grille,String demo)
	{
		wfs = new WorldFileSerializer();		
		try {
			wfs.save(new File("doc/levels/editor_levels/"+demo), grille);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private File getWordFile(){
		
		String path = "doc/levels/editor_levels";
		
		//JFrame frame = new JFrame("Sauvagarde Niveau");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String text=JOptionPane.showInputDialog("Entrer le nom du fichier");
        
        
        
       /* //Add contents to the window.
        frame.add(text);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);*/
        
        path = path +"/"+ text;
		
		File wordFile = new File(path);
		return wordFile;		
		
	}
	
	
	
	
}
