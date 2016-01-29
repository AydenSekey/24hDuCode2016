package fr.soprasteria.jeu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

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
	private boolean success;
	
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
		success = false;
		this.setFocusable(true);
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					bougerPersonnageADroite(0);
					repaint();
				} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					bougerPersonnageAGauche(0);
					repaint();
				} else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					finirNiveau();
				} else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(!grille.getPersonnages().isEmpty()) {
						Personnage perso = grille.getPersonnages().get(0);
						Laser laser = perso.tirer();
						List<Laser> lasers = laserControler.calculTirLaserRecursif(laser);
						dessinerLaser(laser);
						for(Laser las : lasers) {
							dessinerLaser(las);
						}
						jouerSon("shoot.wav");
						if(success) {
							finirNiveau();
						}
					}
				} else if(e.getKeyCode() == KeyEvent.VK_Q) {
					Personnage perso = grille.getPersonnages().get(0);
					perso.setDirectionArme(LaserDirection.OUEST);
					CaseView caseView = (CaseView) getGridButton(perso.getX(), perso.getY());
					caseView.changerPersonnage(LaserDirection.OUEST);
				} else if(e.getKeyCode() == KeyEvent.VK_A) {
					Personnage perso = grille.getPersonnages().get(0);
					perso.setDirectionArme(LaserDirection.NORD_OUEST);
					CaseView caseView = (CaseView) getGridButton(perso.getX(), perso.getY());
					caseView.changerPersonnage(LaserDirection.NORD_OUEST);	
				} else if(e.getKeyCode() == KeyEvent.VK_Z) {
					Personnage perso = grille.getPersonnages().get(0);
					perso.setDirectionArme(LaserDirection.NORD);
					CaseView caseView = (CaseView) getGridButton(perso.getX(), perso.getY());
					caseView.changerPersonnage(LaserDirection.NORD);
				} else if(e.getKeyCode() == KeyEvent.VK_E) {
					Personnage perso = grille.getPersonnages().get(0);
					perso.setDirectionArme(LaserDirection.NORD_EST);
					CaseView caseView = (CaseView) getGridButton(perso.getX(), perso.getY());
					caseView.changerPersonnage(LaserDirection.NORD_EST);
				} else if(e.getKeyCode() == KeyEvent.VK_D) {
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
		jouerSon("blop.wav");
		Personnage perso = this.grille.getPersonnages().get(persoNumero);
		CaseView caseView = (CaseView) this.getGridButton(perso.getX(), perso.getY());
		if(perso.getX() < this.grille.getNbColonnes() - 1) {
			caseView.retirerPersonnage();
			CaseView caseViewVoisine = (CaseView) this.getGridButton(perso.getX()+1, perso.getY());
			caseViewVoisine.afficherPersonnage(perso);
			perso.setX(perso.getX()+1);
		}
	}
	
	public void bougerPersonnageAGauche(int persoNumero)
	{
		jouerSon("blop2.wav");
		Personnage perso = this.grille.getPersonnages().get(persoNumero);
		CaseView caseView = (CaseView) this.getGridButton(perso.getX(), perso.getY());
		if(perso.getX() > 0) {
			caseView.retirerPersonnage();
			CaseView caseViewVoisine = (CaseView) this.getGridButton(perso.getX()-1, perso.getY());
			caseViewVoisine.afficherPersonnage(perso);
			perso.setX(perso.getX()-1);
			perso.setCaseOccupee(caseViewVoisine.getModele());
		}
	}
	
	public void finirNiveau()
	{
		JOptionPane.showMessageDialog(this, "Gagné !");
		FenetreJeu.getInstance().changerPanneau(PanneauSelectionNiveau.getInstance());
	}
	
	public void jouerSon(String soundName){   
		AudioInputStream audioInputStream = null;
		File fileAudio = new File("doc/sons/" + soundName);
		try {
			File path = fileAudio.getAbsoluteFile();
			audioInputStream = AudioSystem.getAudioInputStream(path);
		} catch (UnsupportedAudioFileException | IOException e1) {
			e1.printStackTrace();
		}
		Clip clip = null;
		try {
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} catch (LineUnavailableException | IOException e1) {
			System.err.println("Problème de lecture du fichier " + fileAudio.getAbsolutePath());
			e1.printStackTrace();
		}
		clip.start();
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
				bordPoint = new Point(0, (int) origine.getY());
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
		success = true;
	}
}
