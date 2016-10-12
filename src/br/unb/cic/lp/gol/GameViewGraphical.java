package br.unb.cic.lp.gol;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameViewGraphical extends JFrame{
	private Container contentPane;
	
	private JPanel painelDaMatriz;
	private JPanel painelDeOpcoes;
	
	private CellButton[][] celulas;
	
	private JButton automatic;
	private JButton nextGeneration;
	private JButton halt;
	private JButton undo;
	
	private GameEngine engine;
	private GameController controller;
	
	public GameViewGraphical(GameController controller, GameEngine engine){
		super("Game of Life");
		
		this.controller = controller;
		this.engine = engine;
		
		contentPane = getContentPane();
		
		painelDaMatriz = new JPanel();
		painelDeOpcoes = new JPanel();
		
		contentPane.setLayout(new BorderLayout(5, 5));
		painelDaMatriz.setLayout(new GridLayout(10, 10));
		painelDeOpcoes.setLayout(new GridLayout(1, 4));
		
		contentPane.add(painelDaMatriz, BorderLayout.CENTER);
		contentPane.add(painelDeOpcoes, BorderLayout.SOUTH);
		
		automatic = new JButton("Automatic");
		nextGeneration = new JButton("Next Generation");
		halt = new JButton("Halt");
		undo = new JButton("Undo");
		
		celulas = new CellButton[10][10];
		
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				celulas[i][j] = new CellButton(i, j, controller);
				painelDaMatriz.add(celulas[i][j]);
			}
		}
		
		automatic.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				automatic();
			}
		});
		
		nextGeneration.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				nextGeneration();
			}
		});
		
		halt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				halt();
			}
		});
		
		undo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				undo();
			}
		});
		
		painelDeOpcoes.add(automatic);
		painelDeOpcoes.add(nextGeneration);
		painelDeOpcoes.add(halt);
		painelDeOpcoes.add(undo);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void update(){
		for(int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				if (engine.isCellAlive(i, j)){
					celulas[i][j].corRed();
				}
				else{
					celulas[i][j].corBlack();
				}
			}
		}
	}
	
	private void automatic(){
		//controller.automaticGeneration();
	}
	
	private void nextGeneration(){
		controller.nextGeneration();
	}
	
	private void halt(){
		controller.halt();
	}
	
	private void undo(){
		//controller.undo();
	}
}
