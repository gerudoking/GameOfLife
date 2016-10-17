package br.unb.cic.lp.gol;

public class Seed2 extends GameEngine{
	public Seed2(int height, int width, Statistics statistics) {
		super(height, width, statistics);
	}

	/* verifica se uma celula deve ser mantida viva */
	protected boolean shouldKeepAlive(int i, int j) {
		return false;
	}

	/* verifica se uma celula deve (re)nascer */
	protected boolean shouldRevive(int i, int j) {
		return (!cells[i][j].isAlive())
				&& (numberOfNeighborhoodAliveCells(i, j) == 2);
	}
}
