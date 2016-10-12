package br.unb.cic.lp.gol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class CellButton extends JButton{
	
	private GameController controller;
	
	public CellButton(final int i, final int j, GameController controller){
		super(" ");
		this.setBackground(Color.BLACK);
		
		this.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				makeCellAlive(i, j);
			}
		});
		
		this.controller = controller;
	}
	
	public void makeCellAlive(int i, int j){
		this.setBackground(Color.RED);
		controller.makeCellAlive(i, j);
	}
	
	public void corRed(){
		this.setBackground(Color.RED);
	}
	
	public void corBlack(){
		this.setBackground(Color.BLACK);
	}
}
