package fr.soprasteria.jeu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import fr.soprasteria.jeu.moteur.tirlaser.TirLaserControler;
import fr.soprasteria.jeu.view.CaseView;
import fr.soprasteria.world.Personnage;
import fr.soprasteria.world.Position;
import fr.soprasteria.world.WorldGrille;
import fr.soprasteria.world.laser.Laser;
import fr.soprasteria.world.laser.LaserDirection;

public class PanneauJeuGaming extends PanneauJeu{
	private TirLaserControler laserControler;
	
	public PanneauJeuGaming() {
		super();
	}
	
	public PanneauJeuGaming(WorldGrille grille) {
		super(grille);
		laserControler = new TirLaserControler(grille);
		this.initialiserComportement();
	}
	
	public void initialiserComportement()
	{
		
		this.setFocusable(true);
		
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
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(!grille.getPersonnages().isEmpty()) {
						Personnage perso = grille.getPersonnages().get(0);
						Laser laser = perso.tirer();
						laserControler.calculTirLaser(laser);
						dessinerLaser(laser);
					}
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

	public void dessinerLaser(Point pointSrc, Point pointCible, Color couleur)
	{
		Graphics g = this.getGraphics();
		Graphics2D g2d = ( Graphics2D ) g;
        g2d.setRenderingHint ( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        g2d.setPaint (couleur);
		g2d.drawLine((int)pointSrc.getX(), (int)pointSrc.getY(), (int)pointCible.getX(), (int)pointCible.getY());
	}

	public JPanel lancerJeu() {
		JComponent c = this.getGridButton(2,3);
		
		
		JButton boutonStat = new JButton("Stats");
		boutonStat.setAlignmentX(Component.CENTER_ALIGNMENT);
		boutonStat.setBackground(Color.white);
		boutonStat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}

		});
		this.add(boutonStat);
		
		return this;
	}


	private void dessinerLaser(Laser laser) {
		Position origine = laser.getOrigine();
		Position arret = laser.getArret();
		JComponent c = getGridButton(origine.getX(), origine.getY());
		Point pSrc = middleLocation(c);
		Point pCible;
		if(arret == null) {
			// Laser non interrompu -> doit atteindre le bord de l'écran
			pCible = determinerBordPan(pSrc, laser.getDirection());
		} else {
			// Laser interrompu par une case
			pCible = middleLocation(getGridButton(arret.getX(), arret.getY()));
		}
		dessinerLaser(pSrc, pCible, laser.getCouleur());
	}

	/**
	 * Détermine un point dans le prolongement de la direction permettant d'avoir un trait finissant au bord ou en dehors de l'écran.
	 * @param origine les coordonnées d'origine du laser
	 * @param direction la direction du laser
	 * @return le point de fin du segmet de laser.
	 */
	private Point determinerBordPan(Point origine, LaserDirection direction) {
		Point bordPoint = null;
		int xDistanceWithMin;
		int yDistanceWithMin;
		int minDistance;
		
		switch (direction) {
			case OUEST:
				bordPoint = new Point(this.getWidth(), (int) origine.getY());
				break;
			case NORD_OUEST:
				xDistanceWithMin = (int) origine.getX();
				yDistanceWithMin = (int) origine.getY();
				minDistance = Math.min(xDistanceWithMin, yDistanceWithMin);
				bordPoint = new Point((int) origine.getX() - minDistance,(int) origine.getY() - minDistance);
				break;
			case NORD:
				bordPoint = new Point((int) origine.getX(), 0);
				break;
			case NORD_EST:
				xDistanceWithMin = this.getWidth() - (int) origine.getX();
				yDistanceWithMin = (int) origine.getY();
				minDistance = Math.min(xDistanceWithMin, yDistanceWithMin);
				bordPoint = new Point((int) origine.getX() + minDistance, (int) origine.getY() - minDistance);
				break;
			case EST:
				bordPoint = new Point(this.getWidth(), (int) origine.getY());
				break;
			case SUD_EST:
				xDistanceWithMin = this.getWidth() - (int) origine.getX();
				yDistanceWithMin = this.getHeight() - (int) origine.getY();
				minDistance = Math.min(xDistanceWithMin, yDistanceWithMin);
				bordPoint = new Point((int) origine.getX() + minDistance, (int) origine.getY() + minDistance);
				break;
			case SUD:
				bordPoint = new Point((int) origine.getX(), this.getHeight());
				break;
			case SUD_OUEST:
				xDistanceWithMin = (int) origine.getX();
				yDistanceWithMin = this.getHeight() - (int) origine.getY();
				minDistance = Math.min(xDistanceWithMin, yDistanceWithMin);
				bordPoint = new Point((int) origine.getX() - minDistance, (int) origine.getY() + minDistance);
				break;
			default:
				break;
		}
		return bordPoint;
	}
	
	/**
	 * Donne la position du centre d'un composant par rappord au coin supérieur gauche de son parent.
	 * @param component le composant pour lequel on veut la position du centre
	 * @return la position du centre du composant.
	 */
	private Point middleLocation(JComponent component) {
		Point pos = component.getLocation();
		int witdh = component.getWidth();
		int height = component.getHeight();
		int midX = (int) pos.getX() + witdh / 2;
		int midY = (int) pos.getY() + height / 2;
				
		return new Point(midX, midY);
	}
}
