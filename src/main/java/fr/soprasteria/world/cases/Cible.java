package fr.soprasteria.world.cases;

import fr.soprasteria.world.Declencheur;
import fr.soprasteria.world.laser.Laser;

/**
 * Case à atteindre par un laser pour réussir un niveau.
 */
public class Cible extends CaseLaserInteraction implements Declencheur {

	@Override
	public void declencher() {
		// TODO Success Level
	}

	@Override
	public void reception(Laser laser) {
		declencher();
	}

	@Override
	public String toString() {
		return "Cible";
	}
}
