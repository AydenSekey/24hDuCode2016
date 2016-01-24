package fr.soprasteria.world.cases;

import java.util.ArrayList;
import java.util.List;

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
	public List<Laser> reception(Laser laser) {
		declencher();
		return new ArrayList<Laser>();
	}

	@Override
	public String toString() {
		return "Cible";
	}
}
