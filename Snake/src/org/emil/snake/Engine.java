package org.emil.snake;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.emil.snake.exception.ColisionException;
import org.emil.snake.graphic.Draftsman;
import org.emil.snake.model.MoveDirection;
import org.emil.snake.model.Snake;

public class Engine {
	private List<Point> food;
	private Draftsman window;
	private int windowMaxX;
	private int windowMaxY;
	private Snake snake;
	private int pointSize;
	private Point actualPoint;
	private int pkt = 0;

	public Engine(Snake snake, int pointSize, Draftsman window) {
		this.snake = snake;
		this.pointSize = pointSize;
		this.window = window;

		food = new ArrayList<Point>();

		windowMaxX = window.getWindowSize().width;
		windowMaxY = window.getWindowSize().height;

		actualPoint = new Point(0, 0);

		snakeSetUp();
	}
	

	public void doStep() throws ColisionException {
		Point nextPoint = null;
		MoveDirection direction = window.checkDirection();

		switch (direction) {
		case UP:
			nextPoint = new Point(actualPoint.x, actualPoint.y - pointSize);
			break;
		case DOWN:
			nextPoint = new Point(actualPoint.x, actualPoint.y + pointSize);
			break;
		case LEFT:
			nextPoint = new Point(actualPoint.x - pointSize, actualPoint.y);
			break;
		case RIGHT:
			nextPoint = new Point(actualPoint.x + pointSize, actualPoint.y);
			break;

		}

//		if (nextPoint.x < 0 || nextPoint.x >= windowMaxX) {
//			nextPoint.x = windowMaxX - nextPoint.x;
//		}
//
//		if (nextPoint.y < 0 || nextPoint.y >= windowMaxY) {
//			nextPoint.y = windowMaxY - nextPoint.y;
//		}

		if (nextPoint.x < 0) {
			nextPoint.x = windowMaxX + nextPoint.x;
		}
		if(nextPoint.x > windowMaxX){
			nextPoint.x = windowMaxX - nextPoint.x;
		}

		if (nextPoint.y < 0) {
			nextPoint.y = windowMaxY + nextPoint.y;
		}
		if( nextPoint.y > windowMaxY){
			nextPoint.y = windowMaxY - nextPoint.y;
		}
		
		if (checkColision(nextPoint)) {
			window.setPoints(""+pkt+"  Colision! GAME OVER");
			throw new ColisionException();
		}

		window.drawSnakePoint(nextPoint);
		

		if (food.contains(nextPoint)) {
			snake.move(nextPoint, true);
			food.remove(nextPoint);
			window.setPoints(""+(++pkt));
		} else {
			snake.move(nextPoint, false);
			window.removePoint(snake.getLast());
		}
		
		actualPoint = nextPoint;

	}

	public boolean addFood(Point point) {
		if (food.contains(point) || snake.checkIfContains(point)) {
			return false;
		} else {
			window.drawFoodPoint(point);
			food.add(point);
			return true;
		}
	}

	private boolean checkColision(Point point) {
		return snake.checkIfContains(point);

	}

	private void snakeSetUp() {
		window.drawSnakePoint(actualPoint);
		snake.move(actualPoint, true);
		

		actualPoint.x += pointSize;

		snake.move(actualPoint, true);
		window.drawSnakePoint(actualPoint);
		
/*
		try {
			snake.move(actualPoint, true);
			window.drawSnakePoint(actualPoint);
			doStep(MoveDirection.RIGHT);
			
			snake.move(actualPoint, true);
			window.drawSnakePoint(actualPoint);
			doStep(MoveDirection.RIGHT);
			
		} catch (ColisionException e) {
			System.out.println("Colision!");
		}
*/		
	}
}
