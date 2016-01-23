package fr.soprasteria.editor;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.soprasteria.view.ImagesCases;
import fr.soprasteria.world.WorldGrille;

public class Editeur extends JPanel{
	
	/**
	 * static Singleton instance
	 */
	private static Editeur instance;
	private WorldGrille newWorld;	
	private JPanel outils;
	
	/**
	 * Private constructor for singleton
	 */
	public Editeur(){
		
		//splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,listScrollPane, pictureScrollPane);
		
		newWorld=new WorldGrille(8,10);

		this.outils=genererToolBox();
		
		add(outils);
	}
	
	/**
	 * Static getter method for retrieving the singleton instance
	 */
	public static synchronized Editeur getInstance() {
		if (instance == null) {
			instance = new Editeur();
		}
		return instance;
	}
	
	private JPanel genererToolBox(){
				
		outils = new JPanel();
		outils.setLayout(new FlowLayout());
		
		List <ImagesCases> listCases = new ArrayList<ImagesCases>();
			
		listCases.add(ImagesCases.OBSTACLE_SOLIDE);
		listCases.add(ImagesCases.OBSTACLE_DESTRUCTIBLE);
		listCases.add(ImagesCases.REFLEXION);
		listCases.add(ImagesCases.CIBLE);
		listCases.add(ImagesCases.REFRACTION);
		listCases.add(ImagesCases.DIFFRACTION);
		listCases.add(ImagesCases.DEVIATION);
		
		for (ImagesCases imageCase:listCases){	
			outils.add(new JButton(imageCase.getNom()));
		}
		
		return outils;
	}
	
}
