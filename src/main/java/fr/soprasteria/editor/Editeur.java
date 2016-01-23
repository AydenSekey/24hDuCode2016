package fr.soprasteria.editor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import fr.soprasteria.jeu.FenetreJeu;
import fr.soprasteria.view.ImagesCases;
import fr.soprasteria.world.WorldGrille;
import fr.soprasteria.world.fabriques.FabriqueSimpleWorlds;

public class Editeur extends JPanel implements ActionListener{
	
	/**
	 * static Singleton instance
	 */
	private static Editeur instance;
	private WorldGrille newWorld;	
	private JSplitPane splitPane;
	private JPanel panelWorld;
	private JPanel toolBox;
	private JScrollPane scrollpane;
	private JButton selectButton;
	
	/**
	 * Private constructor for singleton
	 */
	public Editeur(){
				
		panelWorld = new JPanel();
		toolBox=genererToolBox();
		
		toolBox.setMinimumSize(new Dimension(150,FenetreJeu.getInstance().getHeight()));
		
		scrollpane = new JScrollPane(toolBox);
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollpane, panelWorld);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);
		splitPane.setMinimumSize(new Dimension(FenetreJeu.getInstance().getWidth(), FenetreJeu.getInstance().getHeight()));
		splitPane.setContinuousLayout(true);
		
		setMinimumSize(new Dimension(FenetreJeu.getInstance().getWidth(), FenetreJeu.getInstance().getHeight()));		
		setLayout(new BorderLayout());
		
		add(splitPane,BorderLayout.CENTER);
		
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
		
		selectButton = new JButton();
		
		List <ImagesCases> listCases = new ArrayList<ImagesCases>();
			
		listCases.add(ImagesCases.OBSTACLE_SOLIDE);
		listCases.add(ImagesCases.OBSTACLE_DESTRUCTIBLE);
		listCases.add(ImagesCases.REFLEXION);
		listCases.add(ImagesCases.CIBLE);
		listCases.add(ImagesCases.REFRACTION);
		listCases.add(ImagesCases.DIFFRACTION);
		listCases.add(ImagesCases.DEVIATION);
		
		for (ImagesCases imageCase:listCases){
			
			JButton image = new JButton(imageCase.getNom());
			
			image.addActionListener(this);
			
			Dimension dim = new Dimension(100,100);
			image.setPreferredSize(dim);
			image.setMaximumSize(dim);
			image.setMinimumSize(dim);
			
			image.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			Dimension minSize = new Dimension(5, 10);
			Dimension prefSize = new Dimension(5, 10);
			Dimension maxSize = new Dimension(Short.MAX_VALUE, 10);
			outils.add(new Box.Filler(minSize, prefSize, maxSize));
			
			outils.add(image);
			
		}
		
		return outils;
	}
	
	private void setSelectionBouton(JButton bouton){
		this.selectButton=bouton;
	}
	
	private JButton getSelectionBouton(){
		return selectButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		selectButton.setEnabled(true);
		this.setSelectionBouton((JButton)e.getSource());
		selectButton.setEnabled(false);
		
		
	}
}
