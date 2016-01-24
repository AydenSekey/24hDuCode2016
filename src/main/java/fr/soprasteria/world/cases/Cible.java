package fr.soprasteria.world.cases;

import java.util.ArrayList;
import java.util.List;

import fr.soprasteria.world.Declencheur;
import fr.soprasteria.world.laser.Laser;

/**
 * Case à atteindre par un laser pour réussir un niveau.
 */
public class Cible extends CaseLaserInteraction implements Declencheur {
	private transient List<CibleListener> listeners;
	
	public Cible() {
		super();
		listeners = new ArrayList<>();
	}
	
	@Override
	public void declencher() {
		for(CibleListener listener : getListeners()) {
			listener.cibleTouchee();
		}
	}

	@Override
	public List<Laser> reception(Laser laser) {
		declencher();
		return new ArrayList<Laser>();
	}

	/**
	 * Ajoute un écouteur.
	 * @param listener le nouvel écouteur
	 */
	public void addListener(CibleListener listener) {
		getListeners().add(listener);
	}
	
	protected List<CibleListener> getListeners() {
		// nécessaire à cause de la déserialisation qui ne passe pas par le constructeur
		if(listeners == null) {
			listeners = new ArrayList<>();
		}
		return listeners;
	}
	
	@Override
	public String toString() {
		return "Cible";
	}
}
