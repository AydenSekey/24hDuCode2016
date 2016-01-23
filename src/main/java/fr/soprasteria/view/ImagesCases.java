package fr.soprasteria.view;

public enum ImagesCases {

	OBSTACLE_SOLIDE("Obstacle solide", ""), 
	OBSTACLE_DESTRUCTIBLE("Obstacle destructible", ""),
	REFLEXION("Reflexion", ""),
	CIBLE("Cible",""),
	REFRACTION("Refraction",""),
	DIFFRACTION("Diffraction",""),
	DEVIATION("Deviation","");

	private final String nom;
	private final String lienImage;

	private ImagesCases(String nom , String lienImage) {
		this.nom = nom;
		this.lienImage = lienImage;
	}

	public String getNom() {
		return nom;
	}

	public String getLienImage() {
		return lienImage;
	}
		
}
