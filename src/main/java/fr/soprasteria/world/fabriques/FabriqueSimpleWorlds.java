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
		CaseVide caseVide = new CaseVide();
		for(int col = 0; col < nbCols; col++) {
			for(int li = 0; li < nbLis; li++) {
				if(li == liCible && col == colCible) {
					world.setCase(col, li, new Cible());
				} else {
					world.setCase(col, li, caseVide);
				}
			}
		}
		
		world.setCase(3, 0, new Obstacle());
		world.setCase(3, 1, new Obstacle());
		world.setCase(3, 2, new Obstacle());
		world.setCase(4, 2, new Obstacle());
		world.setCase(5, 2, new Obstacle());
		world.setCase(6, 2, new Obstacle());
		
		
		return world;
	}
}
