package fr.soprasteria.world.cases;

public class CaseVide extends Case {

	/**
	 * Une case vide ne peut interagir avec un laser.
	 * @return toujours faux.
	 */
	@Override
	public boolean canInteractWithLaser() {
		return false;
	}

	@Override
	public String toString() {
		return "CaseVide";
	}
}
