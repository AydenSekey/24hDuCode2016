package fr.soprasteria.world.cases;

import fr.soprasteria.world.laser.Laser;

/**
 * Case pouvant intéragir avec un laser.
 */
public abstract class CaseLaserInteraction extends Case {
	/**
	 * Receptionne un laser.
	 * @param laser le laser à réceptionner.
	 */
	public abstract void reception(Laser laser);
	
	/**
	 * Ce type de case peut interagir avec les lasers.
	 * @return toujours vrai.
	 */
	@Override
	public boolean canInteractWithLaser() {
		return true;
	}
}
