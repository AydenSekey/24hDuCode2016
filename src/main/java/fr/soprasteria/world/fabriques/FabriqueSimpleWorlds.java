package fr.soprasteria.world.fabriques;

import fr.soprasteria.world.WorldGrille;
import fr.soprasteria.world.cases.CaseVide;
import fr.soprasteria.world.cases.Cible;

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
		return world;
	}
}
