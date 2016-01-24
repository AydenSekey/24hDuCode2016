package fr.soprasteria.jeu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

import fr.soprasteria.jeu.moteur.tirlaser.TirLaserControler;
import fr.soprasteria.jeu.view.CaseView;
import fr.soprasteria.world.Personnage;
import fr.soprasteria.world.Position;
import fr.soprasteria.world.WorldGrille;
import fr.soprasteria.world.cases.Case;
import fr.soprasteria.world.cases.Cible;
import fr.soprasteria.world.cases.CibleListener;
import fr.soprasteria.world.laser.Laser;
import fr.soprasteria.world.laser.LaserDirection;

public class PanneauJeuGaming extends PanneauJeu implements CibleListener {
	private TirLaserControler laserControler;
	
	public PanneauJeuGaming() {
		super();
	}
	
	public PanneauJeuGaming(WorldGrille grille) {
		super(grille);
		laserControler = new TirLaserControler(grille);
		miseCibleEnEcoute();
		this.initialiserComportement();
	}
	
	private void miseCibleEnEcoute() {
		for(int col = 0; col < grille.getNbColonnes(); col++) {
			for(int li = 0; li < grille.getNbLignes(); li++) {
				Case c = grille.getCase(col, li);
				if(c instanceof Cible) {
					((Cible) c).addListener(this);
				}
			}
		}
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
					repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT)
				{
					bougerPersonnageAGauche(0);
					repaint();
				}
				if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				{
					finirNiveau();
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(!grille.getPersonnages().isEmpty()) {
						Personnage perso = grille.getPersonnages().get(0);
						Laser laser = perso.tirer();
						laserControler.calculTirLaserRecursif(laser);
						dessinerLaser(laser);
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
					Personnage perso = grille.getPersonnages().get(0);
					perso.setDirectionArme(LaserDirection.OUEST);
					CaseView caseView = (CaseView) getGridButton(perso.getX(), perso.getY());
					caseView.changerPersonnage(LaserDirection.OUEST);
				}
				if(e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
					Personnage perso = grille.getPersonnages().get(0);
					perso.setDirectionArme(LaserDirection.NORD_OUEST);
					CaseView caseView = (CaseView) getGridButton(perso.getX(), perso.getY());
					caseView.changerPersonnage(LaserDirection.NORD_OUEST);	
				}
				if(e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
					Personnage perso = grille.getPersonnages().get(0);
					perso.setDirectionArme(LaserDirection.NORD);
					CaseView caseView = (CaseView) getGridButton(perso.getX(), perso.getY());
					caseView.changerPersonnage(LaserDirection.NORD);
				}
				if(e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
					Personnage perso = grille.getPersonnages().get(0);
					perso.setDirectionArme(LaserDirection.NORD_EST);
					CaseView caseView = (CaseView) getGridButton(perso.getX(), perso.getY());
					caseView.changerPersonnage(LaserDirection.NORD_EST);
				}
				if(e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
					System.out.println("s");
					Personnage perso = grille.getPersonnages().get(0);
					perso.setDirectionArme(LaserDirection.EST);
					CaseView caseView = (CaseView) getGridButton(perso.getX(), perso.getY());
					caseView.changerPersonnage(LaserDirection.EST);
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
		caseViewVoisine.afficherPersonnage(perso);
		perso.setX(perso.getX()+1);
	}
	
	public void bougerPersonnageAGauche(int persoNumero)
	{
		Personnage perso = this.grille.getPersonnages().get(persoNumero);
		CaseView caseView = (CaseView) this.getGridButton(perso.getX(), perso.getY());
		caseView.retirerPersonnage();
		CaseView caseViewVoisine = (CaseView) this.getGridButton(perso.getX()-1, perso.getY());
		caseViewVoisine.afficherPersonnage(perso);
		perso.setX(perso.getX()-1);
		perso.setCaseOccupee(caseViewVoisine.getModele());
	}
	
	public void finirNiveau()
	{
		FenetreJeu.getInstance().changerPanneau(PanneauSelectionNiveau.getInstance());
	}

	public void dessinerLaser(Point pointSrc, Point pointCible, Color couleur)
	{
		Graphics g = this.getGraphics();
		if(g != null) {
			Graphics2D g2d = ( Graphics2D ) g;
	        g2d.setRenderingHint ( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
	        g2d.setPaint (couleur);
			g2d.drawLine((int)pointSrc.getX(), (int)pointSrc.getY(), (int)pointCible.getX(), (int)pointCible.getY());
		} else {
			System.err.println("WARNING : support de dessin indisponible.");
		}
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

	@Override
	public void cibleTouchee() {
		System.out.println("SUCCESS !");
		finirNiveau();
	}
}
