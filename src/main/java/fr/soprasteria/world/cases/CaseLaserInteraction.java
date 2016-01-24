package fr.soprasteria.world.cases;

import java.util.List;

import fr.soprasteria.world.laser.Laser;

/**
 * Case pouvant intéragir avec un laser.
 */
public abstract class CaseLaserInteraction extends Case {
	/**
	 * Receptionne un laser.
	 * @param laser le laser à réceptionner.
	 * @return les nouveaux lasers produits par la case suite à la réception du laser 
	 */
	public abstract List<Laser> reception(Laser laser);
	
	/**
	 * Ce type de case peut interagir avec les lasers.
	 * @return toujours vrai.
	 */
	@Override
	public boolean canInteractWithLaser() {
		return true;
	}
}
