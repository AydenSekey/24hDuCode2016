package fr.soprasteria.world;

/**
 * Position en deux dimensions immutable.
 */
public final class Position {
	private final int x;
	private final int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return l'abcisse.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @return l'ordonnée
	 */
	public int getY() {
		return y;
	}
}
