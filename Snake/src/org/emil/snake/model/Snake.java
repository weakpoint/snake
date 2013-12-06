package org.emil.snake.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Snake {
	private List<Point> snake = new ArrayList<Point>();

	public Point getFirst() {
		return snake.get(snake.size()-1);
	}

	public Point getLast() {
		return snake.get(0);
	}

	public int getSnakeLength() {
		return snake.size();
	}
	
	public boolean checkIfContains(Point point){
		return snake.contains(point);
	}

	public void move(Point point, boolean ateFood) {
		if(snake.size()> 0 && !ateFood){
			snake.remove(0);
		}
		snake.add(point);
	}
	

}
