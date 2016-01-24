package fr.soprasteria.jeu.moteur.tirlaser;

import fr.soprasteria.world.laser.Laser;

/**
 * Interface pour les objets tirant des lasers.
 */
public interface LaserTireur {
	/**
	 * Tir un laser.
	 * @return le laser tiré.
	 */
	Laser tirer();
}
