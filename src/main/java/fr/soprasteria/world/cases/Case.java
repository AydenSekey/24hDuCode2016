package fr.soprasteria.world.cases;

import java.io.Serializable;

/**
 * Case du monde. 
 */
public abstract class Case implements Serializable {
	
	private int colonne;
	private int ligne;
	
	public Case() {
		super();
		colonne=-1;
		ligne=-1;
	}
	
	/**
	 * Indique si la case peut intéragir avec le monde
	 * @return vrai si la case peut intéragir avec un laser, faux dans le cas contraire.
	 */
	public abstract boolean canInteractWithLaser();

	public void setColonne(int col) {
		// TODO Auto-generated method stub
		this.colonne=col;
	}
	
	public int getColonne() {
		// TODO Auto-generated method stub
		return colonne;
	}

	public void setLigne(int li) {
		// TODO Auto-generated method stub
		this.ligne=li;
	}
	
	public int getLigne() {
		// TODO Auto-generated method stub
		return ligne;
	}
}
