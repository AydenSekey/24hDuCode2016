package fr.soprasteria.world;

import java.io.Serializable;

import fr.soprasteria.world.cases.Case;
import fr.soprasteria.world.exceptions.ConstructionWorldGrilleException;
import fr.soprasteria.world.exceptions.InvalideCoordonneeGrilleException;

/**
 * Labyrinthe à deux dimensions représenté par une grille.
 * La coordonnée (0;0) au coin sud-ouest.
 */
public class WorldGrille implements Serializable {
	private final int nbLignes;
	private final int nbColonnes;
	private final Case[] grille;
	private String nom;

	/**
	 * Crée un labyrinthe.
	 * @param col le nombre de colonnes de la grille représentant le labyrinthe.
	 * @param li le nombre de lignes de la grille représentant le labyrinthe.
	 * @throws ConstructionWorldGrilleException si les paramètres de construction sont incorrects.
	 */
	public WorldGrille(int col, int li) {
		if(col <= 0 || li <= 0)
			throw new ConstructionWorldGrilleException(col, li);
		nbColonnes = col;
		nbLignes = li;
		grille = new Case[nbColonnes * nbLignes];
	}

	/**
	 * Accède à une case.
	 * @param col la colonne de la case.
	 * @param li la ligne de la case.
	 * @return la case ou <code>null</code> s'il n'y en a pas à cette position.
	 */
	public Case getCase(int col, int li) {
		if(valideCoordonnee(col, li)) {
			int pos = calculPosition(col, li);
			return grille[pos];
		} else {
			throw new InvalideCoordonneeGrilleException(col, li);
		}
	}
	
	public void setCase(int col, int li, Case laCase) {
		if(valideCoordonnee(col, li)) {
			int pos = calculPosition(col, li);
			laCase.setColonne(col);
			laCase.setLigne(li);
			grille[pos] = laCase;
		} else {
			throw new InvalideCoordonneeGrilleException(col, li);
		}
	}
	
	/**
	 * Calcul la position de la case dans le tableau représentant la grille.
	 * @param col la colonne.
	 * @param li la ligne.
	 * @return la position.
	 */
	private int calculPosition(int col, int li) {
		return nbColonnes * li + col;
	}
	
	private boolean valideCoordonnee(int col, int li) {
		return col >= 0 && li >= 0 && col < nbColonnes && li < nbLignes;
	}
	
	/**
	 * Donne le nombre de lignes de la grille du labyrinthe.
	 * 
	 * @return le nombre de lignes.
	 */
	public int getNbLignes() {
		return nbLignes;
	}

	/**
	 * Donne le nombre de colonnes de la grille du labyrinthe.
	 * 
	 * @return le nombre de colonnes.
	 */
	public int getNbColonnes() {
		return nbColonnes;
	}

	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}
	
	public void setNom(String nom){
		this.nom=nom;
	}
	
	/**
	 * 
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder(256);
		builder.append("WorldGrille(nbColonnes=").append(nbColonnes).append(", nbLignes=").append(nbLignes).append(")\n[");
		for(int li = 0; li < nbLignes; li++) {
			for(int col = 0; col < nbColonnes; col++) {
				builder.append(getCase(col, li)).append(", ");
			}
			builder.append("\n");
		}
		builder.append("]");
		return builder.toString();
	}
}
