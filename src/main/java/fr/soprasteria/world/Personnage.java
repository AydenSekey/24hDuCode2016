package fr.soprasteria.world;

import java.awt.Color;

import fr.soprasteria.world.cases.Case;
import fr.soprasteria.world.laser.Laser;
import fr.soprasteria.world.laser.LaserDirection;
import fr.soprasteria.world.laser.LaserTireur;

/**
 * Personnage/joueur.
 */
public class Personnage implements LaserTireur {
	private Color couleurLaser;
	private LaserDirection directionArme;
	private Case caseOccupee;
	private int x;
	private int y;
	
	public Personnage() {
		this(0,0);
	}
	
	/**
	 * Crée un personnage.
	 * @param x abcisse de la position du personnage à l'écran
	 * @param y ordonnée  de la position du personnage à l'écran
	 */
	public Personnage(int x, int y) {
		this(x, y, Color.red);
	}
	
	/**
	 * Crée un personnage.
	 * @param x abcisse de la position du personnage à l'écran
	 * @param y ordonnée  de la position du personnage à l'écran
	 * @param couleurLaser la couleur du laser tiré par le joueur.
	 */
	public Personnage(int x, int y, Color couleurLaser) {
		this.couleurLaser = couleurLaser;
		this.x = x;
		this.y = y;
		this.directionArme = LaserDirection.NORD;
	}
	
	@Override
	public Laser tirer() {
		return new Laser(new Position(x, y), directionArme, couleurLaser);
	}

	/**
	 * @return the couleurLaser
	 */
	public Color getCouleurLaser() {
		return couleurLaser;
	}

	/**
	 * @param couleurLaser the couleurLaser to set
	 */
	public void setCouleurLaser(Color couleurLaser) {
		this.couleurLaser = couleurLaser;
	}

	/**
	 * @return the caseOccupee
	 */
	public Case getCaseOccupee() {
		return caseOccupee;
	}

	/**
	 * @param caseOccupee the caseOccupee to set
	 */
	public void setCaseOccupee(Case caseOccupee) {
		this.caseOccupee = caseOccupee;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the directionArme
	 */
	public LaserDirection getDirectionArme() {
		return directionArme;
	}

	/**
	 * @param directionArme the directionArme to set
	 */
	public void setDirectionArme(LaserDirection directionArme) {
		this.directionArme = directionArme;
	}
}

