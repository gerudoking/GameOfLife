package br.unb.cic.lp.gol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class CellButton extends JButton{
	
	private GameController controller;
	private GameEngine engine;
	
	public CellButton(final int i, final int j, GameController controller, final GameEngine engine){
		super(" ");
		this.setBackground(Color.BLACK);
		
		this.controller = controller;
		this.engine = engine;
		
		this.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!(engine.isCellAlive(i, j))) makeCellAlive(i, j);
				else makeCellDead(i, j);
			}
		});
	}
	
	public void makeCellAlive(int i, int j){
		this.setBackground(Color.RED);
		controller.makeCellAlive(i, j);
	}
	
	public void makeCellDead(int i, int j){
		this.setBackground(Color.BLACK);
		controller.makeCellDead(i, j);
	}
	
	public void corRed(){
		this.setBackground(Color.RED);
	}
	
	public void corBlack(){
		this.setBackground(Color.BLACK);
	}
}
