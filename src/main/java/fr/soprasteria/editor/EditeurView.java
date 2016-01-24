package fr.soprasteria.editor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
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
import fr.soprasteria.jeu.PanneauEditeur;
import fr.soprasteria.jeu.PanneauJeuEditor;
import fr.soprasteria.jeu.PanneauJeuGaming;
import fr.soprasteria.view.ImagesCases;
import fr.soprasteria.world.WorldGrille;
import fr.soprasteria.world.fabriques.FabriqueSimpleWorlds;
import fr.soprasteria.world.persistence.WorldFileSerializer;

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
	private JButton JSave;
	private JButton JRetour;
	private JButton JPlay;
	private JPanel actionEditor;
	private JPanel left;
	private EditeurButtonCase ebc;
	private List<ImagesCases> listCases;
	
	/**
	 * Private constructor for singleton
	 */
	private EditeurView(){
				
		listCases = new ArrayList<ImagesCases>();
		
		listCases.add(ImagesCases.OBSTACLE_SOLIDE);
		//listCases.add(ImagesCases.OBSTACLE_DESTRUCTIBLE);
		//listCases.add(ImagesCases.REFLEXION);
		listCases.add(ImagesCases.PERSONNAGE);
		listCases.add(ImagesCases.CIBLE);
		listCases.add(ImagesCases.REDIRECTION);
		//listCases.add(ImagesCases.DIFFRACTION);
		//listCases.add(ImagesCases.DEVIATION);		
		
		grille = FabriqueSimpleWorlds.emptyWorld(20, 10);
		
		panelWorld = new PanneauJeuEditor(grille);
				
		toolBox=genererToolBox();		
		toolBox.setMinimumSize(new Dimension(150,FenetreJeu.getInstance().getHeight()));
		toolBox.setMaximumSize(new Dimension(150,FenetreJeu.getInstance().getHeight()));
		panelWorld.setMinimumSize(new Dimension(FenetreJeu.getInstance().getWidth(),FenetreJeu.getInstance().getHeight()));
		
		scrollpane1 = new JScrollPane(toolBox);
		
		left = new JPanel(new BorderLayout());
		
		actionEditor = new JPanel(new GridLayout(4,1));
		actionEditor.setMinimumSize(new Dimension(150,150));
		
		JSave = new JButton("Sauvegarder");
		JPlay = new JButton("Jouer");
		JRetour = new JButton("Retour");
		JSave.addActionListener(this);
		JPlay.addActionListener(this);
		JRetour.addActionListener(this);
		
		actionEditor.add(JSave);		
		actionEditor.add(JPlay);
		actionEditor.add(JRetour);
		
		left.add(scrollpane1,BorderLayout.NORTH);
		left.add(actionEditor,BorderLayout.SOUTH);
		
		scrollpane2 = new JScrollPane(panelWorld);
		
		scrollpane1.setMinimumSize(new Dimension(150,FenetreJeu.getInstance().getHeight()));
		scrollpane1.setMaximumSize(new Dimension(150,FenetreJeu.getInstance().getHeight()));
		scrollpane2.setMinimumSize(new Dimension(FenetreJeu.getInstance().getWidth(),FenetreJeu.getInstance().getHeight()));
		//scrollpane2.setMaximumSize(new Dimension(150,FenetreJeu.getInstance().getHeight()));

		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,left, panelWorld);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);
		splitPane.setMinimumSize(new Dimension(FenetreJeu.getInstance().getWidth(), FenetreJeu.getInstance().getHeight()));
		splitPane.setContinuousLayout(true);
		
		//setMinimumSize(new Dimension(FenetreJeu.getInstance().getWidth(), FenetreJeu.getInstance().getHeight()));		
		setLayout(new BorderLayout());
		
		add(splitPane,BorderLayout.CENTER);
		
		setVisible(true);
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
		int i = 0;
		for (ImagesCases imageCase:listCases){
			
			EditeurButtonCase JBCase = new EditeurButtonCase(imageCase);
			JBCase.setName(imageCase.getNom());
			try {
				BufferedImage image = ImageIO.read(new File(imageCase.getLienImage()));
				JBCase.setIcon(new ImageIcon(image));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JBCase.addActionListener(this);
			
			Dimension dim = new Dimension(100,100);
			JBCase.setPreferredSize(dim);
			JBCase.setMaximumSize(dim);
			JBCase.setMinimumSize(dim);
			
			JBCase.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			Dimension minSize = new Dimension(5, 10);
			Dimension prefSize = new Dimension(5, 10);
			Dimension maxSize = new Dimension(Short.MAX_VALUE, 10);
			outils.add(new Box.Filler(minSize, prefSize, maxSize));
			
			outils.add(JBCase);
			
			if (i == 0) {
				ebc = JBCase;
				this.ebc.setEnabled(false);
			}
			i = i + 1;
		}
		
		return outils;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == JSave){
			EditorSave es = new EditorSave(grille,panelWorld);
		}
		else{
			if (e.getSource() == JPlay){
				EditorSave es = new EditorSave(grille,panelWorld,"demo");
				EditorLoad el = new EditorLoad("demo.lvl",true);
					
				PanneauJeuGaming pan = new PanneauJeuGaming(el.getGrille());
				FenetreJeu.getInstance().changerPanneau(pan);	
			}
			else{
				this.ebc.setEnabled(true);
				this.ebc = (EditeurButtonCase) e.getSource();
				this.ebc.setEnabled(false);
			}
		}
	}
	
	public void setButtonCase(EditeurButtonCase ebc){
		this.ebc=ebc;
	}
	
	public EditeurButtonCase getButtonCase(){
		return ebc;
	}
}
