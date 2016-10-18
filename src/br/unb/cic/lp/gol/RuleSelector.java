package br.unb.cic.lp.gol;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RuleSelector extends JFrame{
	private Container contentPane;
	
	private JPanel opcoes;
	
	private JButton conway;
	private JButton anneal;
	private JButton dayandnight;
	private JButton gnarl;
	private JButton highlife;
	private JButton seed2;
	
	private GameEngine engine;
	
	private int heigth;
	private int width;
	private Statistics statistics;
	
	public RuleSelector(int heigth, int width, Statistics statistics) {
		super("Selecione a regra desejada");
		
		engine = null;
		
		contentPane = getContentPane();
		
		opcoes = new JPanel();
		
		contentPane.add(opcoes);
		
		conway = new JButton("Regra Conway");
		
		opcoes.add(conway);
		
		conway.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				conway();
			}
		});
		
		this.setSize(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void conway(){
		this.engine = new Conway(heigth, width, statistics);
	}

	public GameEngine getEngine() {
		return engine;
	}
}
