package fr.soprasteria.world.laser;

/**
 * Directions possibles d'un laser
 */
public enum LaserDirection {
	/** Direction 180 degrés -> vers bord gauche de l'écran. */
	OUEST,
	/** Direction 135 degrés -> vers le coin en haut à gauche de l'écran. */
	NORD_OUEST,
	/** Direction 90 degrés -> vers le bord haut de l'écran. */
	NORD,
	/** Direction 45 degrés -> vers le coin en haut à droite de l'écran. */
	NORD_EST,
	/** Direction 0 degrés -> vers le bord droit de l'écran. */
	EST,
	/** Direction -45 degrés -> vers le coin en bas à droite de l'écran. */
	SUD_EST,
	/** Direction -90 degrés -> vers le bord bas de l'écran. */
	SUD,
	/** Direction -135 degrés -> vers le coin en bas à gauche de l'écran. */
	SUD_OUEST;
}
