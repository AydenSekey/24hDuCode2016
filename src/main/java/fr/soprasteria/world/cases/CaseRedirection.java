package fr.soprasteria.world.cases;

import java.util.ArrayList;
import java.util.List;

import fr.soprasteria.world.laser.Laser;
import fr.soprasteria.world.laser.LaserDirection;

public class CaseRedirection extends CaseLaserInteraction {
	private LaserDirection direction;
	
	public CaseRedirection() {
		this(LaserDirection.OUEST);
	}
	
	public CaseRedirection(LaserDirection direction) {
		this.direction = direction;
	}
	
	@Override
	public List<Laser> reception(Laser laser) {
		if(laser.getArret() == null) {
			throw new IllegalArgumentException("Laser reçu n'a pas d'arrêt défini.");
		}
		List<Laser> lasers = new ArrayList<Laser>();
		lasers.add(new Laser(laser.getArret(), direction, laser));
		return lasers;
	}
	
	/**
	 * @return the direction
	 */
	public LaserDirection getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(LaserDirection direction) {
		if(direction == null) {
			throw new IllegalArgumentException("null interdit pour l'attribut direction.");
		}
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "CaseRedirection(direction=" + direction + ")";
	}
}
