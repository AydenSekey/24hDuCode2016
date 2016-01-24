package fr.soprasteria.jeu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class Jeu{
	
	private FenetreJeu _FENETRE;
	private static final String _NOM= "Marechal Laser";
	
	/**
	 * static Singleton instance
	 */
	private static Jeu instance;

	/**
	 * Private constructor for singleton
	 */
	private Jeu() {
		init();
	}

	/**
	 * Static getter method for retrieving the singleton instance
	 */
	public static Jeu getInstance() {
		if (instance == null) {
			instance = new Jeu();
		}
		return instance;
	}
	
	private void init()
	{
		_FENETRE = FenetreJeu.getInstance();
	}
	
	public void start()
	{
		_FENETRE.start();
		jouerSon("militaire.wav");
	}
	
	public String getNom()
	{
		return _NOM;
	}
	
	public ArrayList<String> listerNiveaux()
	{
		File rep = new File("doc/levels");
		File edit_rep = new File("doc/levels/editor_levels");
		if(!edit_rep.exists()) {
			edit_rep.mkdirs();
		}
		ArrayList<String> niveaux = new ArrayList<>();
		for(String niv: rep.list())
		{
			if(niv.contains(".lvl"))
				niveaux.add(niv.replace(".lvl", ""));
		}
		for(String niv: edit_rep.list())
		{
			if(niv.contains(".lvl"))
				niveaux.add(niv.replace(".lvl", ""));
		}
		
		return niveaux;
	}
	
	public void jouerSon(String soundName){   
		AudioInputStream audioInputStream = null;
		try {
			File path = new File("doc/sons/" + soundName).getAbsoluteFile();
			audioInputStream = AudioSystem.getAudioInputStream(path);
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Clip clip = null;
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			clip.open(audioInputStream);
		} catch (LineUnavailableException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		clip.setLoopPoints(0,-1);
//		clip.loop(4);
		clip.start();
	}

}
