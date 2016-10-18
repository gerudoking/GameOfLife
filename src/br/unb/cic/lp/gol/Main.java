package br.unb.cic.lp.gol;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		GameEngine engine = null;
		
		GameController controller = new GameController();
		
		Statistics statistics = new Statistics();
		
		//RuleSelector rule = new RuleSelector(10, 10, statistics);

		//GameEngine engine = rule.getEngine();
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Decida qual regra utilizar:");
		System.out.println("[1] - Conway");
		System.out.println("[2] - Anneal");
		System.out.println("[3] - Day And Night");
		System.out.println("[4] - Gnarl");
		System.out.println("[5] - Highlife");
		System.out.println("[6] - Seed2");
		
		int n = reader.nextInt();
		
		switch(n){
		case 1:
			engine = new Conway(10, 10, statistics);
			break;
		case 2:
			engine = new Anneal(10, 10, statistics);
			break;
		case 3:
			engine = new Dayandnight(10, 10, statistics);
			break;
		case 4:
			engine = new Gnarl(10, 10, statistics);
			break;
		case 5:
			engine = new Highlife(10, 10, statistics);
			break;
		case 6:
			engine = new Seed2(10, 10, statistics);
			break;
		default:
			engine = new Conway(10, 10, statistics);
			break;
		}
		
		
		GameViewGraphical board = new GameViewGraphical(controller, engine);
		
		controller.setBoard(board);
		controller.setEngine(engine);
		controller.setStatistics(statistics);
		
		controller.start();
	}
}
