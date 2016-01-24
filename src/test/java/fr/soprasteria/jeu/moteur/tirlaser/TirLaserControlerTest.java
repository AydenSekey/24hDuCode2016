package fr.soprasteria.jeu.moteur.tirlaser;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fr.soprasteria.world.Position;
import fr.soprasteria.world.WorldGrille;
import fr.soprasteria.world.fabriques.FabriqueSimpleWorlds;
import fr.soprasteria.world.laser.Laser;
import fr.soprasteria.world.laser.LaserDirection;

public class TirLaserControlerTest {

	@Test
	public void testCalculTirLaserUnique() {
		WorldGrille worldTest = FabriqueSimpleWorlds.emptyWorld(6, 7, 5, 0);
		TirLaserControler tirControler = new TirLaserControler(worldTest);

		Laser laser = new Laser(new Position(0, 5), LaserDirection.NORD_EST);
		List<Laser> laserResult = tirControler.calculTirLaser(laser);
		assertNotNull("Erreur de conception, null retourné au lieu d'une liste vide.", laserResult);
		assertTrue("Un laser a été généré à tord", laserResult.isEmpty());
		assertNotNull("Le laser n'a pas été arrêté.", laser.getArret());
		Position posArret = laser.getArret();
		assertEquals("Abscisse d'arrêt incorrect", 5, posArret.getX());
		assertEquals("Ordonnée d'arrêt incorrect", 0, posArret.getY());
	}

}
