package fr.soprasteria.world.laser;

import java.awt.Color;

import fr.soprasteria.world.Position;

/**
 * Interace pour les lasers.
 */
public class Laser {
	
	private final Position origine;
	private final LaserDirection direction;
	private Position arret;
	private Color couleur;
	private Laser laserSource;
	
	/**
	 * Crée un laser
	 * @param origine la position (coordonnée de case) d'origine du laser
	 * @param direction la direction du laser
	 * @param source le laser source du laser. Mettre <code>null</code> pour le laser de départ (celui d'un tir)
	 * @param couleur la couleur du laser
	 */
	public Laser(Position origine, LaserDirection direction, Laser source, Color couleur) {
		this.couleur = couleur;
		this.origine = origine;
		this.direction = direction;
		this.arret = null;
	}
	
	/**
	 * Crée un laser de départ (sans source)
	 * @param origine la position (coordonnée de case) d'origine du laser
	 * @param direction la direction du laser
	 * @param couleur la couleur du laser
	 */
	public Laser(Position origine, LaserDirection direction, Color couleur) {
		this.couleur = couleur;
		this.origine = origine;
		this.direction = direction;
		this.arret = null;
	}
	
	/**
	 * Crée un laser rouge.
	 * @param origine la position (coordonnée de case) d'origine du laser
	 * @param direction la direction du laser
	 * @param source le laser source du laser. Mettre <code>null</code> pour le laser de départ (celui d'un tir)
	 */
	public Laser(Position origine, LaserDirection direction, Laser source) {
		this(origine, direction, source, Color.red);
	}
	
	/**
	 * Crée un laser rouge de départ (sans source)
	 * @param origine la position (coordonnée de case) d'origine du laser
	 * @param direction la direction du laser
	 */
	public Laser(Position origine, LaserDirection direction) {
		this(origine, direction, null, Color.red);
	}
	
	/**
	 * Donne la couleur finale du laser.
	 * @return la couleur finale du laser.
	 */
	public Color getCouleur() {
		return couleur;
	}

	/**
	 * Donne la position de l'origine du laser.
	 * @return la position de l'origine.
	 */
	public Position getOrigine() {
		return origine;
	}

	/**
	 * Donne le laser source du laser courant si ce dernier est généré depuis un autre laser.
	 * @return le laser source ou <code>null</code> s'il n'y en a pas.
	 */
	public Laser getLaserSource() {
		return laserSource;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	/**
	 * @param laserSource the laserSource to set
	 */
	public void setLaserSource(Laser laserSource) {
		if(laserSource == this) {
			throw new IllegalArgumentException("Un laser ne doit pas être source de lui-même.");
		}
		this.laserSource = laserSource;
	}

	/**
	 * Donne la direction du laser.
	 * @return la direction du laser.
	 */
	public LaserDirection getDirection() {
		return direction;
	}

	/**
	 * Donne la position d'arrêt du laser.
	 * @return la position d'arrêt du laser.
	 */
	public Position getArret() {
		return arret;
	}
	
	/**
	 * Modifie la position d'arret du laser.
	 * @param newPosition la nouvelle position d'arrêt du laser, <code>null</code> pour indiquer que le laser n'est pas arrêté.
	 */
	public void setArret(Position newPosition) {
		arret = newPosition;
	}
}
