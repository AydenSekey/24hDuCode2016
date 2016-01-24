package fr.soprasteria.world.cases;

import java.util.ArrayList;
import java.util.List;

import fr.soprasteria.world.laser.Laser;

/**
 * Case empêchant le déplacement d'un laser.
 */
public class Obstacle extends CaseLaserInteraction {

	/**
	 * Lorsqu'un obstacle réceptionne un laser il l'absorbe et ne fait rien.
	 * @return 
	 */
	@Override
	public List<Laser> reception(Laser laser) {
		// Ne rien faire
		return new ArrayList<Laser>();
	}

	@Override
	public String toString() {
		return "Obstacle";
	}
}
