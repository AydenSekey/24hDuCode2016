package fr.soprasteria.editor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import fr.soprasteria.jeu.FenetreJeu;
import fr.soprasteria.jeu.PanneauJeuEditor;
import fr.soprasteria.view.ImagesCases;
import fr.soprasteria.world.WorldGrille;
import fr.soprasteria.world.cases.Case;
import fr.soprasteria.world.fabriques.FabriqueSimpleWorlds;

public class EditeurView extends JPanel implements ActionListener{
	
	/**
	 * static Singleton instance
	 */
	private static EditeurView instance;
	private WorldGrille grille;
	private JSplitPane splitPane;
	private JPanel panelWorld;
	private JPanel toolBox;
	private JScrollPane scrollpane1;
	private JScrollPane scrollpane2;
	private EditeurController editeurController;
	private List<ImagesCases> listCases;
	
	/**
	 * Private constructor for singleton
	 */
	private EditeurView(){
		
		listCases = new ArrayList<ImagesCases>();
		
		listCases.add(ImagesCases.OBSTACLE_SOLIDE);
		//listCases.add(ImagesCases.OBSTACLE_DESTRUCTIBLE);
		//listCases.add(ImagesCases.REFLEXION);
		listCases.add(ImagesCases.CIBLE);
		//listCases.add(ImagesCases.REFRACTION);
		//listCases.add(ImagesCases.DIFFRACTION);
		//listCases.add(ImagesCases.DEVIATION);
		
		grille = FabriqueSimpleWorlds.emptyWorld(20, 10);
		
		panelWorld = new PanneauJeuEditor(grille);
				
		toolBox=genererToolBox();		
		toolBox.setMinimumSize(new Dimension(150,FenetreJeu.getInstance().getHeight()));
		toolBox.setMaximumSize(new Dimension(150,FenetreJeu.getInstance().getHeight()));
		panelWorld.setMinimumSize(new Dimension(FenetreJeu.getInstance().getWidth(),FenetreJeu.getInstance().getHeight()));
		
		scrollpane1 = new JScrollPane(toolBox);
		scrollpane2 = new JScrollPane(panelWorld);
		
		scrollpane1.setMinimumSize(new Dimension(150,FenetreJeu.getInstance().getHeight()));
		scrollpane1.setMaximumSize(new Dimension(150,FenetreJeu.getInstance().getHeight()));
		scrollpane2.setMinimumSize(new Dimension(FenetreJeu.getInstance().getWidth(),FenetreJeu.getInstance().getHeight()));
		//scrollpane2.setMaximumSize(new Dimension(150,FenetreJeu.getInstance().getHeight()));

		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scrollpane1, panelWorld);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);
		splitPane.setMinimumSize(new Dimension(FenetreJeu.getInstance().getWidth(), FenetreJeu.getInstance().getHeight()));
		splitPane.setContinuousLayout(true);
		
		//setMinimumSize(new Dimension(FenetreJeu.getInstance().getWidth(), FenetreJeu.getInstance().getHeight()));		
		setLayout(new BorderLayout());
		
		add(splitPane,BorderLayout.CENTER);
		
		setVisible(true);
		
		editeurController = new EditeurController();
	}
	
	/**
	 * Static getter method for retrieving the singleton instance
	 */
	public static synchronized EditeurView getInstance() {
		if (instance == null) {
			instance = new EditeurView();
		}
		return instance;
	}
	
	private JPanel genererToolBox(){
				
		JPanel outils = new JPanel();
		BoxLayout box = new BoxLayout(outils,BoxLayout.Y_AXIS);
		outils.setLayout(box);
		
		int i = 1;
		for (ImagesCases imageCase:listCases){
			
			JButton JBImage = new JButton();
			JBImage.setName(""+i);
			try {
				BufferedImage image = ImageIO.read(new File(imageCase.getLienImage()));
				JBImage.setIcon(new ImageIcon(image));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JBImage.addActionListener(this);
			
			Dimension dim = new Dimension(100,100);
			JBImage.setPreferredSize(dim);
			JBImage.setMaximumSize(dim);
			JBImage.setMinimumSize(dim);
			
			JBImage.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			Dimension minSize = new Dimension(5, 10);
			Dimension prefSize = new Dimension(5, 10);
			Dimension maxSize = new Dimension(Short.MAX_VALUE, 10);
			outils.add(new Box.Filler(minSize, prefSize, maxSize));
			
			outils.add(JBImage);
			i = i +1;
		}
		
		return outils;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}
