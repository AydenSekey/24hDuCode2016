package fr.soprasteria.world.laser;

import java.awt.Color;

import fr.soprasteria.world.Position;

/**
 * Représente un laser non dévié (trait droit)
 */
public class LaserSimple implements Laser {
	private final Position origine;
	private Color couleur;
	private Laser laserSource;
	
	public LaserSimple(Position origine, Laser source, Color couleur) {
		this.couleur = couleur;
		this.origine = origine;
	}
	
	public LaserSimple(Position origine, Laser source) {
		this.couleur = Color.red;
		this.origine = origine;
	}
	
	@Override
	public Color getCouleur() {
		return couleur;
	}

	@Override
	public Position getOrigine() {
		return origine;
	}

	@Override
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
}
