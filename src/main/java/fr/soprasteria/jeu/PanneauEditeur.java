package fr.soprasteria.jeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.soprasteria.editor.EditeurView;
import fr.soprasteria.world.WorldGrille;

public class PanneauEditeur extends JPanel implements MouseListener,ActionListener{
	
	/**
	 * static Singleton instance
	 */
	private static PanneauEditeur instance;
	
	/*liste de niveaux cr�es*/
	private List<String> list_world;

	private JPanel panelNiveau;
	private JButton newNiveau;
	private JLabel newLabel;
	
	/**
	 * Private constructor for singleton
	 */
	private PanneauEditeur() {
		
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JLabel titre = new JLabel("Niveaux Personalisés");
		titre.setHorizontalAlignment(JLabel.CENTER);
		titre.setFont(new Font("Serif", Font.PLAIN, 30));
		this.add(titre,BorderLayout.NORTH);
		//this.add(this.getPanneauListeNiveauxEdition(),BorderLayout.CENTER);
		
		Dimension dimB = new Dimension(100,100);
		
		panelNiveau = new JPanel();
		list_world = listerNiveaux();		
		GridLayout g1 = new GridLayout(4,4);
		g1.setHgap(15); //
		g1.setVgap(15);
		panelNiveau.setLayout(g1);
		panelNiveau.setBackground(Color.WHITE);
		
		int i;
		for (i=0;i<15;i++){
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			JLabel bu = new JLabel("VIDE");
			bu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			bu.setPreferredSize(dimB);
			JLabel la = new JLabel("");
			la.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			bu.setHorizontalAlignment(JLabel.CENTER);
			la.setHorizontalAlignment(JLabel.CENTER);
			
			panel.setLayout(new BorderLayout());	
			if (i<list_world.size()){
				 bu.setText(list_world.get(i));
				 la.setText(list_world.get(i));
			}
			panel.add(bu,BorderLayout.CENTER);
			panel.add(la,BorderLayout.SOUTH);
			panel.addMouseListener(this);
			
			panelNiveau.add(panel);
		}
		
		JPanel panelNew = new JPanel();
		panelNew.setLayout(new BorderLayout());
		newNiveau = new JButton();
		try {
			BufferedImage image = ImageIO.read(new File("src/main/resources/images/icone_plus.png"));
			newNiveau.setIcon(new ImageIcon(image));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newNiveau.setPreferredSize(dimB);
		newNiveau.setHorizontalAlignment(JLabel.CENTER);
		newNiveau.setVerticalAlignment(JLabel.CENTER);
		newNiveau.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		newLabel = new JLabel("Nouveau niveau");
		newLabel.setHorizontalAlignment(JLabel.CENTER);
		newLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		newNiveau.addActionListener(this);
		panelNew.add(newNiveau,BorderLayout.CENTER);
		panelNew.add(newLabel,BorderLayout.SOUTH);
		panelNiveau.add(panelNew);
		
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
	
	public ArrayList<String> listerNiveaux()
	{
		File edit_rep = new File("doc/levels/editor_levels");
		if(!edit_rep.exists()) {
			edit_rep.mkdirs();
		}
		ArrayList<String> niveaux = new ArrayList<>();
		for(String niv: edit_rep.list())
		{
			if(niv.contains(".lvl"))
				niveaux.add(niv.replace(".lvl", ""));
		}
		
		return niveaux;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( e.getSource() == newNiveau ){
			FenetreJeu.getInstance().changerPanneau(EditeurView.getInstance());
		}
	}
}
