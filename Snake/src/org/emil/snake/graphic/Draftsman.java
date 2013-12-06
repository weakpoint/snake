package org.emil.snake.graphic;

import java.awt.Dimension;
import java.awt.Point;

import org.emil.snake.model.MoveDirection;

public interface Draftsman {
	public void drawFoodPoint(Point point);
	public void drawSnakePoint(Point point);
	public void removePoint(Point point);
	public MoveDirection checkDirection();
	public void setPoints(String points);
	public Dimension getWindowSize();
}
