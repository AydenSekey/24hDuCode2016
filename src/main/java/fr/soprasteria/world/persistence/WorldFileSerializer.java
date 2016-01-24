package fr.soprasteria.world.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import fr.soprasteria.world.WorldGrille;

/**
 * Sauvegarde ou charge un monde dans ou depuis un fichier en utilisant la sérialisation Java.
 */
public class WorldFileSerializer implements WorldFileMapper {

	@Override
	public WorldGrille load(File worldFile) throws IOException {
		// Vérification des paramètres
		if(worldFile == null)
			throw new IllegalArgumentException("null passer en paramètre pour worldFile.");
		// Vérification des infos de fichier
		if(!worldFile.exists())
			throw new IOException("Le fichier " + worldFile.getAbsolutePath() + " n'existe pas.");
		if(!worldFile.isFile())
					throw new IOException(worldFile.getAbsolutePath() + " n'est pas un fichier.");
		
		// deserialization du fichier
		WorldGrille world;
		try(FileInputStream fin = new FileInputStream(worldFile)) { // try-resource gère le close avec finally
			try(ObjectInputStream oin = new ObjectInputStream(fin)) { // try-resource gère le close avec finally
				world = (WorldGrille) oin.readObject();
			} catch (ClassNotFoundException | ClassCastException e) {
				throw new IOException("Erreur au chargement du fichier " + worldFile.getAbsolutePath() + " : ne contient pas la classe WorldGrille.", e);
			}
		}
		
		return world;
	}

	@Override
	public void save(File worldFile, WorldGrille world) throws IOException {
		// Vérification des paramètres
		if(worldFile == null)
			throw new IllegalArgumentException("null passer en paramètre pour worldFile.");
		if(world == null)
			throw new IllegalArgumentException("null passer en paramètre pour world.");
		
		// serialization du fichier
		try(FileOutputStream fout = new FileOutputStream(worldFile)) { // try-resource gère le close avec finally
			try(ObjectOutputStream oout = new ObjectOutputStream(fout)) { // try-resource gère le close avec finally
				oout.writeObject(world);
			}
		}
	}

}
