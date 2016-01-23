package fr.soprasteria.jeu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.soprasteria.editor.EditeurView;
import fr.soprasteria.world.WorldGrille;

public class PanneauEditeur extends JPanel implements ActionListener{
	
	/**
	 * static Singleton instance
	 */
	private static PanneauEditeur instance;
	
	/*liste de niveaux cr�es*/
	private List<String> list_world;

	private JPanel panelTitre;
	private JPanel panelNiveau;
	private JButton newNiveau;
	
	/**
	 * Private constructor for singleton
	 */
	private PanneauEditeur() {
			
		panelTitre = new JPanel();						
		panelNiveau = new JPanel();		
		list_world = getListWorld();		
		panelNiveau.setLayout(new FlowLayout(list_world.size()));		
		
		for (String world:list_world){
			
			JButton Bu = new JButton(world);
			Bu.addActionListener(this);
			panelNiveau.add(Bu);
			//panelNiveau.add(new JLabel(world));
		}
		
		newNiveau = new JButton("Nouveau niveau");
		newNiveau.addActionListener(this);
		panelNiveau.add(newNiveau);
		//panelNiveau.add(new JLabel("Nouveau niveau"));
		
		add(panelTitre,BorderLayout.NORTH);
		add(panelNiveau,BorderLayout.CENTER);
			
		setVisible(true);
	}

	/**
	 * Static getter method for retrieving the singleton instance
	 */
	public static synchronized PanneauEditeur getInstance() {
		if (instance == null) {
			instance = new PanneauEditeur();
		}
		return instance;
	}
	
	/*recuperation de la liste de niveau*/
	private List<String> getListWorld(){
		list_world = new ArrayList<String>();
		
		list_world.add("TEST 1");
		list_world.add("TEST 2");
		
		return list_world;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( e.getSource() == newNiveau ){
			FenetreJeu.getInstance().changerPanneau(EditeurView.getInstance());
		}
	}
}
