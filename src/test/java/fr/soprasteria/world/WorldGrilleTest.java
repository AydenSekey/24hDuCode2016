package fr.soprasteria.world;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.soprasteria.world.cases.Case;
import fr.soprasteria.world.exceptions.ConstructionWorldGrilleException;


public class WorldGrilleTest {

	@Test
	public void testConstruction() {
		WorldGrille laby = null;
		boolean exception = false;
		try {
			laby = new WorldGrille(-1, 1);
		} catch(ConstructionWorldGrilleException e) {
			exception = true;
		}
		assertTrue("ConstructionWorldGrilleException attendue pour nombre de colonnes négatif.", exception);
		exception = false;
		try {
			laby = new WorldGrille(1, -1);
		} catch(ConstructionWorldGrilleException e) {
			exception = true;
		}
		assertTrue("ConstructionWorldGrilleException attendue pour nombre de lignes négatif.", exception);
		exception = false;
		try {
			laby = new WorldGrille(1, 0);
		} catch(ConstructionWorldGrilleException e) {
			exception = true;
		}
		assertTrue("ConstructionWorldGrilleException attendue pour nombre de colonnes nul.", exception);
		exception = false;
		try {
			laby = new WorldGrille(0, 1);
		} catch(ConstructionWorldGrilleException e) {
			exception = true;
		}
		assertTrue("ConstructionWorldGrilleException attendue pour nombre de lignes nul.", exception);
		exception = false;
		try {
			laby = new WorldGrille(0, 0);
		} catch(ConstructionWorldGrilleException e) {
			exception = true;
		}
		assertTrue("ConstructionWorldGrilleException attendue pour nombre de lignes et de colonnes nul.", exception);
		exception = false;
		try {
			laby = new WorldGrille(-1, -1);
		} catch(ConstructionWorldGrilleException e) {
			exception = true;
		}
		assertTrue("ConstructionWorldGrilleException attendue pour nombre de lignes et de colonnes négatif.", exception);
		exception = false;
		try {
			laby = new WorldGrille(3, 2);
		} catch(Exception e) {
			exception = true;
		}
		assertFalse("Echec de la création.", exception);
		assertEquals("Nombre de lignes incorrect", 2, laby.getNbLignes());
		assertEquals("Nombre de lignes incorrect", 3, laby.getNbColonnes());
	}

	@Test
	public void testSetGetCase() {
		WorldGrille laby = new WorldGrille(5, 6);
		Case case1 = new Case() {
			@Override
			public boolean canInteractWithLaser() {
				return false;
			}
		};
		
		laby.setCase(0, 0, case1);
		assertTrue("Erreur de setCase ou getCase.", case1 == laby.getCase(0, 0));
	}
}
