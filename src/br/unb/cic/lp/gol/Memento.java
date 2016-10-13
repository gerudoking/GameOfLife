package br.unb.cic.lp.gol;

public class Memento {
	protected Cell[][] cells;
	
	public Memento(Cell[][] entrada){
		cells=entrada.clone();
	}
	public Memento(Memento entrada){
		this.cells=entrada.cells.clone();
	}
	public Cell[][] getMemento(){
		return cells;
	}
}
