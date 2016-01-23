package fr.soprasteria.world.persistence;

import java.io.File;
import java.io.IOException;

import fr.soprasteria.world.WorldGrille;

/**
 * Interface pour les classes permettant la sauvegarde et le chargement d'un monde dans un fichier.
 */
public interface WorldFileMapper {
	
	/**
	 * Charge un monde depuis un fichier.
	 * @param worldFile le fichier contenant le monde.
	 * @return le monde chargé.
	 * @throws IOException en cas de problème avec le fichier
	 */
	public WorldGrille load(File worldFile) throws IOException;
	
	/**
	 * Sauvegarde un monde dans un fichier.
	 * @param worldFile le fichier dans lequel sauvegardé le monde. Le fichier est écrasé s'il existe déjà.
	 * @param world le monde à sauvegarder.
	 * @throws IOException en cas de problème avec le fichier.
	 */
	public void save(File worldFile, WorldGrille world) throws IOException;
}
