package br.unb.cic.lp.gol;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameViewGraphical extends JFrame{
	private Container contentPane;
	
	private JPanel painelDaMatriz;
	private JPanel painelDeOpcoes;
	
	private CellButton[][] celulas;
	
	private JButton makeCellAlive;
	private JButton nextGeneration;
	private JButton halt;
	
	private GameEngine engine;
	private GameController controller;
	
	public GameViewGraphical(GameController controller, GameEngine engine){
		super("Game of Life");
		
		contentPane = getContentPane();
		
		contentPane.setLayout(new BorderLayout(5, 5));
		painelDaMatriz.setLayout(new GridLayout(10, 10));
		painelDeOpcoes.setLayout(new GridLayout(1, 3));
		
		contentPane.add(painelDaMatriz, BorderLayout.NORTH);
		contentPane.add(painelDeOpcoes, BorderLayout.SOUTH);
		
		painelDeOpcoes.add(makeCellAlive);
		painelDeOpcoes.add(nextGeneration);
		painelDeOpcoes.add(halt);
		
		this.controller = controller;
		this.engine = engine;
	}
}
