package fr.soprasteria.editor;

import java.awt.TextField;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fr.soprasteria.world.WorldGrille;
import fr.soprasteria.world.persistence.WorldFileSerializer;

public class EditorLoad {
	
	private WorldFileSerializer wfs;
	private File wordFile;
	
	public EditorLoad(String file)
	{
		wfs = new WorldFileSerializer();		
		try {
			wfs.load(new File (file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public EditorLoad(String demo,boolean bc)
	{
		wfs = new WorldFileSerializer();		
		try {
			wfs.load(new File("doc/levels/editor_levels/"+demo));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
}
