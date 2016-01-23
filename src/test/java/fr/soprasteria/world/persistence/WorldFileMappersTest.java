package fr.soprasteria.world.persistence;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import fr.soprasteria.world.WorldGrille;
import fr.soprasteria.world.fabriques.FabriqueSimpleWorlds;

public class WorldFileMappersTest {
	
	@Test
	public void testWorldFileSerializerOK() throws IOException {
		File fileTest = new File("target/testWorldFileSerializerOK.jo");
		// Suppression du fichier s'il exist déjà pour avoir un context propre
		if(fileTest.exists())
			fileTest.delete();
		
		WorldGrille world = FabriqueSimpleWorlds.emptyWorld(4, 3, 1, 2);
		
		WorldFileSerializer serializer = new WorldFileSerializer();
		serializer.save(fileTest, world);
		assertTrue("Fichier sérialisé absent après sauvegarde.", fileTest.exists());
		WorldGrille loadWorld = serializer.load(fileTest);
		
		// Si tout est OK jusque là, on peut supprimer le fichier de test
		fileTest.delete();
		
		// Vérification du monde charger
		assertEquals("Nombre de colonnes différent entre le monde d'origine et celui chargé", world.getNbColonnes(), loadWorld.getNbColonnes());
		assertEquals("Nombre de lignes différent entre le monde d'origine et celui chargé", world.getNbLignes(), loadWorld.getNbLignes());
		for(int col = 0; col < world.getNbColonnes(); col++) {
			for(int li = 0; li < world.getNbLignes(); li++) {
				String expected = world.getCase(col, li).getClass().getName();
				String actual = loadWorld.getCase(col, li).getClass().getName();
				assertEquals("Case(li=" + li + ", col=" + col + ") de classe incorrecte.", expected, actual);
			}
		}
	}

}
