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
	private int numberOfGen = 1;
	
	private Container contentPane;
	
	private JPanel painelDaMatriz;
	private JPanel painelDeOpcoes;
	private JPanel painelAutomatic;
	
	private CellButton[][] celulas;
	
	private JButton automatic;
	private JButton automaticPlus;
	private JButton automaticSub;
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
		painelAutomatic = new JPanel();
		
		contentPane.setLayout(new BorderLayout(5, 5));
		painelDaMatriz.setLayout(new GridLayout(engine.getHeight(), engine.getWidth()));
		painelDeOpcoes.setLayout(new GridLayout(1, 4));
		painelAutomatic.setLayout(new GridLayout(1, 3));
		
		contentPane.add(painelDaMatriz, BorderLayout.CENTER);
		contentPane.add(painelDeOpcoes, BorderLayout.SOUTH);
		
		automatic = new JButton("GA: " + numberOfGen + ".");
		automaticPlus = new JButton("+");
		automaticSub = new JButton("-");
		nextGeneration = new JButton("Next Generation");
		halt = new JButton("Halt");
		undo = new JButton("Undo");
		
		celulas = new CellButton[engine.getHeight()][engine.getWidth()];
		
		for(int i = 0; i < engine.getHeight(); i++){
			for(int j = 0; j < engine.getWidth(); j++){
				celulas[i][j] = new CellButton(i, j, controller, engine);
				painelDaMatriz.add(celulas[i][j]);
			}
		}
		
		automatic.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				automatic();
			}
		});
		
		automaticPlus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				automaticPlus();
			}
		});
		
		automaticSub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				automaticSub();
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
		
		painelDeOpcoes.add(painelAutomatic);
		painelDeOpcoes.add(nextGeneration);
		painelDeOpcoes.add(halt);
		painelDeOpcoes.add(undo);
		
		painelAutomatic.add(automaticPlus);
		painelAutomatic.add(automatic);
		painelAutomatic.add(automaticSub);
		
		this.setSize(1000, 600);
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
		for(int i = 0; i< numberOfGen; i++ ){
			controller.nextGeneration();
		}
	}
	
	private void automaticPlus(){
		numberOfGen++;
		automatic.setText("GA: " + numberOfGen + ".");
	}
	
	private void automaticSub(){
		if (numberOfGen > 1) numberOfGen--;
		automatic.setText("GA: " + numberOfGen + ".");
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
