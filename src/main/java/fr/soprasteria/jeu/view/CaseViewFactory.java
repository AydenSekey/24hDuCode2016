package fr.soprasteria.jeu.view;

import fr.soprasteria.world.cases.Case;
import fr.soprasteria.world.cases.CaseRedirection;
import fr.soprasteria.world.cases.Cible;
import fr.soprasteria.world.cases.Obstacle;

public class CaseViewFactory {

	public static CaseView getCasePourModele(Case c)
	{
		if(c instanceof Cible)
			return (new CibleView(c));
		if(c instanceof Obstacle)
			return (new ObstacleView(c));
		if(c instanceof CaseRedirection) {
			return new CaseRedirectionView(c);
		}
		
		return (new CaseView(c));
	}
}
