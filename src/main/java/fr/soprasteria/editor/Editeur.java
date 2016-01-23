package fr.soprasteria.editor;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.soprasteria.view.ImagesCases;
import fr.soprasteria.world.WorldGrille;

public class Editeur extends JPanel{
	
	/**
	 * static Singleton instance
	 */
	private static Editeur instance;
	private WorldGrille newWorld;	
	private JSplitPane splitPane;
	private JPanel panelWorld;
	private JPanel toolBox;
	
	/**
	 * Private constructor for singleton
	 */
	public Editeur(){
				
		newWorld=new WorldGrille(8,10);
		panelWorld = new JPanel();
		toolBox=genererToolBox();
		//toolBox = new JPanel(box);
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,toolBox, panelWorld);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);
		
		add(splitPane);
		setVisible(true);
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
				
		JPanel outils = new JPanel();
		BoxLayout box = new BoxLayout(outils,BoxLayout.Y_AXIS);
		outils.setLayout(box);
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
