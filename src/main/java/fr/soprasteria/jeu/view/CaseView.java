package fr.soprasteria.jeu.view;

import javax.swing.JLabel;

import fr.soprasteria.world.cases.Case;

public class CaseView extends JLabel{

	private Case modele;
	
	public CaseView(Case c)
	{
		this.modele = c;
	}
	
	public Case getCase(){
		return modele;
	}	
}
