package br.unb.cic.lp.gol;

public class Highlife extends GameEngine{
	public Highlife(int height, int width, Statistics statistics) {
		super(height, width, statistics);
	}

	/* verifica se uma celula deve ser mantida viva */
	protected boolean shouldKeepAlive(int i, int j) {
		return (cells[i][j].isAlive())
				&& (numberOfNeighborhoodAliveCells(i, j) == 2 || numberOfNeighborhoodAliveCells(i, j) == 3);
	}

	/* verifica se uma celula deve (re)nascer */
	protected boolean shouldRevive(int i, int j) {
		return (!cells[i][j].isAlive())
				&& ((numberOfNeighborhoodAliveCells(i, j) == 3) || (numberOfNeighborhoodAliveCells(i, j) == 6));
	}
}
