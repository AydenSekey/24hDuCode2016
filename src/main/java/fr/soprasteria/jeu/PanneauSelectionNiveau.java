package fr.soprasteria.jeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.soprasteria.world.WorldGrille;
import fr.soprasteria.world.fabriques.FabriqueSimpleWorlds;
import fr.soprasteria.world.persistence.WorldFileSerializer;

public class PanneauSelectionNiveau extends JPanel{

	/**
	 * static Singleton instance
	 */
	private static PanneauSelectionNiveau instance;

	/**
	 * Private constructor for singleton
	 */
	private PanneauSelectionNiveau(){
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JLabel titre = new JLabel("Levels");
		titre.setHorizontalAlignment(JLabel.CENTER);
		titre.setFont(new Font("Serif", Font.PLAIN, 30));
		this.add(titre,BorderLayout.NORTH);
		this.add(this.getPanneauListeNiveaux(),BorderLayout.CENTER);
		
		
	}

	/**
	 * Static getter method for retrieving the singleton instance
	 */
	public static PanneauSelectionNiveau getInstance() {
		if (instance == null) {
			instance = new PanneauSelectionNiveau();
		}
		return instance;
	}
	
	public JPanel getPanneauListeNiveaux()
	{
		JPanel panneau = new JPanel();
		panneau.setOpaque(true);
		panneau.setBackground(Color.white);
		
		GridLayout g1 = new GridLayout(4,4);
		g1.setHgap(15); //
		g1.setVgap(15);		
		panneau.setLayout(g1);
		panneau.setBackground(Color.WHITE);
		
		Dimension d = new Dimension(100,100);
		
		for(String niv: (Jeu.getInstance().listerNiveaux()))
		{
			
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			JLabel bu = new JLabel();
			bu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			bu.setPreferredSize(d);
			JLabel la = new JLabel(niv);
			panel.setName(niv);
			la.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			bu.setHorizontalAlignment(JLabel.CENTER);
			la.setHorizontalAlignment(JLabel.CENTER);
			
			try {					 
			 	BufferedImage image = ImageIO.read(new File("doc/levels/editor_levels/"+niv+".png"));
			 	image = resize(image, 350, 150);
			 	bu.setIcon(new ImageIcon(image));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			panel.add(bu,BorderLayout.CENTER);
			panel.add(la,BorderLayout.SOUTH);
			
			/*JLabel l = new JLabel(niv);
			l.setPreferredSize(d);
			l.setMinimumSize(d);
			l.setSize(d);
//			l.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			l.setHorizontalAlignment(JLabel.CENTER);
			l.setBackground(Color.black);
			l.setForeground(Color.white);
			l.setOpaque(true);*/
			panel.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println(((JPanel)e.getSource()).getName());
					File file = new File("doc/editor_levels/"+((JPanel)e.getSource()).getName()+".lvl");
					
					try {
						WorldGrille g = (new WorldFileSerializer()).load(file);
						
						if(g != null){
							PanneauJeuGaming pan = new PanneauJeuGaming(g);
							FenetreJeu.getInstance().changerPanneau(pan);
						}
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			});
			panneau.add(panel,BorderLayout.CENTER);
		}
		
		return panneau;
	}
	
	public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}  
}
