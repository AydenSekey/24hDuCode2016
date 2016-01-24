package fr.soprasteria.jeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import fr.soprasteria.jeu.view.CaseView;
import fr.soprasteria.world.Personnage;
import fr.soprasteria.world.WorldGrille;

public class PanneauJeuGaming extends PanneauJeu{

	public PanneauJeuGaming() {
		super();
	}
	
	public PanneauJeuGaming(WorldGrille grille) {
		super(grille);
		this.initialiserComportement();
	}
	
	public void initialiserComportement()
	{
		
		this.setFocusable(true);
//		System.out.println("isFocusable=" + this.isFocusable());
//		this.requestFocus();
////		this.requestFocusInWindow();
//		System.out.println(this.isFocusOwner());
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					bougerPersonnageADroite(0);
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT)
				{
					bougerPersonnageAGauche(0);
				}
			}
		});
	}
	
	public void bougerPersonnageADroite(int persoNumero)
	{
		Personnage perso = this.grille.getPersonnages().get(persoNumero);
		CaseView caseView = (CaseView) this.getGridButton(perso.getX(), perso.getY());
		caseView.retirerPersonnage();
		CaseView caseViewVoisine = (CaseView) this.getGridButton(perso.getX()+1, perso.getY());
		caseViewVoisine.afficherPersonnage();
		perso.setX(perso.getX()+1);
	}
	
	public void bougerPersonnageAGauche(int persoNumero)
	{
		Personnage perso = this.grille.getPersonnages().get(persoNumero);
		CaseView caseView = (CaseView) this.getGridButton(perso.getX(), perso.getY());
		caseView.retirerPersonnage();
		CaseView caseViewVoisine = (CaseView) this.getGridButton(perso.getX()-1, perso.getY());
		caseViewVoisine.afficherPersonnage();
		perso.setX(perso.getX()-1);
	}

	public void dessinerLaser(JComponent element1, JComponent element2)
	{
		Graphics g = this.getGraphics();
		Graphics2D g2d = ( Graphics2D ) g;
        g2d.setRenderingHint ( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );

        g2d.setPaint ( Color.BLACK );
        //g2.drawLine(x1,  y1,  x2,  y2);
		
		Point pt = new Point(element1.getLocation()); 
		Point pt2 = new Point(element2.getLocation());
		
//		System.out.println(c.getLocationOnScreen().getX());
		System.out.println("actionStat");

		g2d.drawLine((int)element1.getLocationOnScreen().getX(), (int)element1.getLocationOnScreen().getY(), (int)element2.getLocationOnScreen().getX(), (int)element2.getLocationOnScreen().getY());
	}

	public JPanel lancerJeu() {
		// TODO Auto-generated method stub
		JComponent c = this.getGridButton(2,3);
		
		
		JButton boutonStat = new JButton("Stats");
		boutonStat.setAlignmentX(Component.CENTER_ALIGNMENT);
		boutonStat.setBackground(Color.white);
		boutonStat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				actionStat();
				JComponent c = getGridButton(2,3);
				JComponent d = getGridButton(7,7);
				dessinerLaser(c,d);
			}
		});
		this.add(boutonStat);
//		Point pt = new Point(c.getLocation()); 
//		SwingUtilities.convertPointToScreen(pt, c); 
//		System.out.println(c.getLocationOnScreen());
		
		return this;
	}


	
}
