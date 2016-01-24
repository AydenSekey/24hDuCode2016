package fr.soprasteria.editor;

import javax.swing.JButton;

import fr.soprasteria.view.ImagesCases;

public class EditeurButtonCase extends JButton {

	private ImagesCases ic;
	
	public EditeurButtonCase(ImagesCases ic){
		this.setIc(ic);
	}

	public ImagesCases getIc() {
		return ic;
	}

	public void setIc(ImagesCases ic) {
		this.ic = ic;
	}
	
	
	
	
	
}
