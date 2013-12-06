package org.emil.snake;

import java.awt.Point;
import java.util.Random;

import org.emil.snake.graphic.Draftsman;

public class FoodGenerator implements Runnable {

	private Engine engine;
	private int x, y, foodInterval;

	public FoodGenerator(Engine engine, Draftsman draftsman, int foodInterval) {
		this.engine = engine;
		x = draftsman.getWindowSize().width;
		y = draftsman.getWindowSize().height;
		this.foodInterval = foodInterval;
	}

	@Override
	public void run() {

		Point point = null;
		Random rand = new Random();

		while (true) {
			try {
				do {
					Thread.sleep(foodInterval * 1000);
					point = new Point(rand.nextInt((int)(x-10)/10)*10, rand.nextInt((int)(y-10)/10)*10);
				} while (!engine.addFood(point));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
