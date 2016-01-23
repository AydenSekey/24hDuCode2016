package fr.soprasteria.world.cases;

/**
 * Case du monde. 
 */
public abstract class Case {
	
	public Case() {
		super();
	}
	
	/**
	 * Indique si la case peut intéragir avec le monde
	 * @return vrai si la case peut intéragir avec un laser, faux dans le cas contraire.
	 */
	public abstract boolean canInteractWithLaser();
}
