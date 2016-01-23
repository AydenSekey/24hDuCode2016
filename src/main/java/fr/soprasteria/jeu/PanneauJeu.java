package fr.soprasteria.jeu;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanneauJeu extends JPanel{
	
	private JPanel gui;
	private JButton[][] chessBoardSquares;
	private JPanel chessBoard;
	/**
	 * static Singleton instance
	 */
	private static PanneauJeu instance;

	/**
	 * Private constructor for singleton
	 * @return 
	 */
	private JPanel PanneauJeu() {
		gui	= new JPanel(new BorderLayout(3, 3));
		chessBoardSquares = new JButton[8][8];
		chessBoard = new JPanel(new GridLayout(0, 9));
		gui.add(chessBoard);
		return gui;
	}

	/**
	 * Static getter method for retrieving the singleton instance
	 */
	public static PanneauJeu getInstance() {
		if (instance == null) {
			instance = new PanneauJeu();
		}
		return instance;
	}
}
