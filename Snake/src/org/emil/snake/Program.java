package org.emil.snake;

import org.emil.snake.exception.ColisionException;
import org.emil.snake.graphic.Draftsman;
import org.emil.snake.graphic.JPanelDraftsman;
import org.emil.snake.model.Snake;

public class Program {
	public static void main(String[] args) {
		Snake snake = new Snake();
		int SIZE = 10;
		int FOOD_INTERVAL = 2;

		Controller con = new Controller();
		Draftsman draftsman = new JPanelDraftsman(con, SIZE);

		Engine engine = new Engine(snake, SIZE, draftsman);
		Thread foodMaker = new Thread(new FoodGenerator(engine, draftsman, FOOD_INTERVAL));
		foodMaker.start();
		
		try {
			
			while (true) {
				engine.doStep();
				Thread.sleep(250);
			}
		} catch (ColisionException e) {
			foodMaker.stop();
			System.out.println("colision!");
			
		}
		catch (InterruptedException e) {
		}

	}
}
