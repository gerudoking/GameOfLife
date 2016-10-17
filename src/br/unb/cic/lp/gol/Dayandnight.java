package br.unb.cic.lp.gol;

public class Dayandnight extends GameEngine {
	public Dayandnight(int height, int width, Statistics statistics) {
		super(height, width, statistics);
	}

	/* verifica se uma celula deve ser mantida viva */
	protected boolean shouldKeepAlive(int i, int j) {
		return (cells[i][j].isAlive())
				&& ((numberOfNeighborhoodAliveCells(i, j) > 2 || numberOfNeighborhoodAliveCells(i, j) < 9)
						&& (numberOfNeighborhoodAliveCells(i, j) != 5));
	}

	/* verifica se uma celula deve (re)nascer */
	protected boolean shouldRevive(int i, int j) {
		return (!cells[i][j].isAlive())
				&& ((numberOfNeighborhoodAliveCells(i, j) == 3) || (numberOfNeighborhoodAliveCells(i, j) == 6)
						|| (numberOfNeighborhoodAliveCells(i, j) == 7) || (numberOfNeighborhoodAliveCells(i, j) == 8));
	}
}
