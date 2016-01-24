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
	
	public Laser(Position origine, LaserDirection direction, Laser source, Color couleur) {
		this.couleur = couleur;
		this.origine = origine;
		this.direction = direction;
		this.arret = null;
	}
	
	public Laser(Position origine, LaserDirection direction, Laser source) {
		this(origine, direction, source, Color.red);
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
