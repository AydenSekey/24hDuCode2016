package fr.soprasteria.world.fabriques;

import fr.soprasteria.world.WorldGrille;
import fr.soprasteria.world.cases.CaseVide;
import fr.soprasteria.world.cases.Cible;
import fr.soprasteria.world.cases.Obstacle;

public final class FabriqueSimpleWorlds {
	private FabriqueSimpleWorlds() {
		throw new UnsupportedOperationException("Il est interdit de construire une instance de FabriqueSimpleWorlds.");
	}
	
	/**
	 * Crée un monde contenant uniquement une cible.
	 * @param nbCols le nombre de colonnes de la grille du monde
	 * @param nbLis le nombre de lignes de la grille du monde
	 * @param colCible la colonne de la cible
	 * @param liCible la ligne de la cible
	 * @return le monde correspondant.
	 */
	public static WorldGrille emptyWorld(int nbCols, int nbLis, int colCible, int liCible) {
		WorldGrille world = new WorldGrille(nbCols, nbLis);
		for(int col = 0; col < nbCols; col++) {
			for(int li = 0; li < nbLis; li++) {
				if(li == liCible && col == colCible) {
					world.setCase(col, li, new Cible());
				} else {
					world.setCase(col, li, new CaseVide());
				}
			}
		}
		
		return world;
	}
	
	/**
	 * Crée un monde entièrement vide.
	 * @param nbCols le nombre de colonnes de la grille du monde
	 * @param nbLis le nombre de lignes de la grille du monde
	 * @return le monde correspondant.
	 */
	public static WorldGrille emptyWorld(int nbCols, int nbLis) {
		WorldGrille world = new WorldGrille(nbCols, nbLis);
		for(int col = 0; col < nbCols; col++) {
			for(int li = 0; li < nbLis; li++) {
					world.setCase(col, li, new CaseVide());
			}
		}
		return world;
	}
	
	/**
	 * Crée un monde contenant une cible avec 4 obstacles.
	 * @return le monde correspondant.
	 */
	public static WorldGrille withObstacleWorldExemple1() {
		int nbCols = 10;
		int nbLis = 5;
		int colCible = 1;
		int liCible = 2;
		WorldGrille world = emptyWorld(nbCols, nbLis, colCible, liCible);
		
		world.setCase(2, 0, new Obstacle());
		world.setCase(2, 1, new Obstacle());
		world.setCase(2, 2, new Obstacle());
		world.setCase(3, 2, new Obstacle());	
		
		return world;
	}
}
