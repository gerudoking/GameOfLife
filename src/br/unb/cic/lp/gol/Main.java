package br.unb.cic.lp.gol;

public class Main {

	public static void main(String args[]) {
		GameController controller = new GameController();
		
		Statistics statistics = new Statistics();

		GameEngine engine = new Seed2(10, 10, statistics);	
		
		GameViewGraphical board = new GameViewGraphical(controller, engine);
		
		controller.setBoard(board);
		controller.setEngine(engine);
		controller.setStatistics(statistics);
		
		controller.start();
	}
}
