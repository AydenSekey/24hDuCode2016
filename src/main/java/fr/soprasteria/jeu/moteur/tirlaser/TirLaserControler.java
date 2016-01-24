package fr.soprasteria.jeu.moteur.tirlaser;

import java.util.ArrayList;
import java.util.List;

import fr.soprasteria.world.Position;
import fr.soprasteria.world.WorldGrille;
import fr.soprasteria.world.cases.Case;
import fr.soprasteria.world.cases.CaseLaserInteraction;
import fr.soprasteria.world.exceptions.InvalideCoordonneeGrilleException;
import fr.soprasteria.world.laser.Laser;
import fr.soprasteria.world.laser.LaserDirection;

public class TirLaserControler {
	private static final int NB_CALCUL_RECURSIFS_MAX = 16;
	private WorldGrille world;
	
	/**
	 * Crée un contrôleur de laser pour un monde.
	 * @param controlThisWorld le monde sur lequel contrôler le laser.
	 */
	public TirLaserControler(WorldGrille controlLaserOnThisWorld) {
		world = controlLaserOnThisWorld;
	}
	
	/**
	 * Calcul le chemin de parcouru jusqu'à un obstacle par un laser venant d'être tirer dans le monde.
	 * @param laser le laser pour lequel faire le calcul, s'il est interrompu sa position d'arrêt sera renseignée.
	 * @return les nouveaux lasers potentiellement générés par l'objet (case) ayant interrompu le laser.
	 */
	public List<Laser> calculTirLaser(Laser laser) {
		final LaserDirection direction = laser.getDirection();
	
		List<Laser> newLasers = new ArrayList<>();
		Position nextPos = laser.getOrigine();
		boolean outWorldOrCaseIntercept = false;
		do {
			nextPos = nextPositionDirection(nextPos, direction);
			try {
				Case caseNext = world.getCase(nextPos.getX(), nextPos.getY());
				if(caseNext.canInteractWithLaser()) {
					// Case interagissant avec le laser.
					// Stoppé le laser courant
					laser.setArret(nextPos);
					// indiquer à la case de recevoir le laser
					CaseLaserInteraction caseInteract = (CaseLaserInteraction) caseNext;
					newLasers = caseInteract.reception(laser);
					outWorldOrCaseIntercept = true;
				}
			} catch(InvalideCoordonneeGrilleException e) {
				outWorldOrCaseIntercept = true;
			}
		} while(!outWorldOrCaseIntercept);
		return newLasers;
	}
	
	/**
	 * Calcul le chemin de parcouru jusqu'à un obstacle par des lasers venant d'être tirer dans le monde.
	 * @param lasers les lasers pour lesquels faire le calcul, si un laser est interrompu sa position d'arrêt sera renseignée.
	 * @return les nouveaux lasers potentiellement générés par les objets (case) ayant interrompu le laser.
	 */
	public List<Laser> calculTirLaser(List<Laser> lasers) {
		List<Laser> newLasers = new ArrayList<>();
		for(Laser laser : lasers) {
			List<Laser> lasersOut = calculTirLaser(laser);
			newLasers.addAll(lasersOut);
		}
		return newLasers;
	}
	
	public void calculTirLaserRecursif(Laser laser) {
		List<Laser> lasers = calculTirLaser(laser);
		int nbCalcul = 0;
		while(!lasers.isEmpty() && nbCalcul < NB_CALCUL_RECURSIFS_MAX) {
			lasers = calculTirLaser(lasers);
			nbCalcul++;
		}
	}

	private Position nextPositionDirection(Position origin, LaserDirection direction) {
		Position next = null;
		switch (direction) {
			case OUEST:
				next = new Position(origin.getX() - 1, origin.getY());
				break;
			case NORD_OUEST:
				next = new Position(origin.getX() - 1, origin.getY() - 1);
				break;
			case NORD:
				next = new Position(origin.getX(), origin.getY() - 1);
				break;
			case NORD_EST:
				next = new Position(origin.getX() + 1, origin.getY() - 1);
				break;
			case EST:
				next = new Position(origin.getX() + 1, origin.getY());
				break;
			case SUD_EST:
				next = new Position(origin.getX() + 1, origin.getY() + 1);
				break;
			case SUD:
				next = new Position(origin.getX(), origin.getY() + 1);
				break;
			case SUD_OUEST:
				next = new Position(origin.getX() - 1, origin.getY() + 1);
				break;
			default:
				break;
		}
		return next;
	}
}
