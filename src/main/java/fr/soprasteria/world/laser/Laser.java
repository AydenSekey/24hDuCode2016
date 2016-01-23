package fr.soprasteria.world.laser;

import java.awt.Color;

import fr.soprasteria.world.Position;

/**
 * Interace pour les lasers.
 */
public interface Laser {
	/**
	 * Donne la couleur finale du laser.
	 * @return la couleur finale du laser.
	 */
	public Color getCouleur();
	
	/**
	 * Donne la position de l'origine du laser.
	 * @return la position de l'origine.
	 */
	public Position getOrigine();
	
	/**
	 * Donne le laser source du laser courant si ce dernier est généré depuis un autre laser.
	 * @return le laser source ou <code>null</code> s'il n'y en a pas.
	 */
	public Laser getLaserSource();
}
