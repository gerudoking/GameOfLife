package br.unb.cic.lp.gol;

public class Gnarl extends GameEngine {
	public Gnarl(int height, int width, Statistics statistics) {
		super(height, width, statistics);
	}

	/* verifica se uma celula deve ser mantida viva */
	protected boolean shouldKeepAlive(int i, int j) {
		return (cells[i][j].isAlive())
				&& (numberOfNeighborhoodAliveCells(i, j) == 1);
	}

	/* verifica se uma celula deve (re)nascer */
	protected boolean shouldRevive(int i, int j) {
		return (!cells[i][j].isAlive())
				&& (numberOfNeighborhoodAliveCells(i, j) == 1);
	}
}
