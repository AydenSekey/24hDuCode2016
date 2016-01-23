package fr.soprasteria.world.cases;

import fr.soprasteria.world.laser.Laser;

/**
 * Case empêchant le déplacement d'un laser.
 */
public class Obstacle extends CaseLaserInteraction {

	/**
	 * Lorsqu'un obstacle réceptionne un laser il l'absorbe et ne fait rien.
	 */
	@Override
	public void reception(Laser laser) {
		// Ne rien faire
	}

}
