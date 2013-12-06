package org.emil.snake.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.emil.snake.WindowController;
import org.emil.snake.model.MoveDirection;

public class JPanelDraftsman implements Draftsman {

	private JPanel board = new JPanel();
	private Dimension BOARD_SIZE = new Dimension(600, 600);
	private int pointSize;
	private Color snakeColor = Color.red;
	private Color foodColor = Color.black;
	private Color defaultColor = Color.white;
	private WindowController keylistener;
	private JLabel lPoints= new JLabel("Points: 0");

	public JPanelDraftsman(WindowController keylistener, int pointSize) {
		this.pointSize = pointSize;
		this.keylistener = keylistener;
		
		JFrame frame = new JFrame("Snake");
		board.setPreferredSize(BOARD_SIZE);
		board.setBackground(defaultColor);
//		board.setBorder(BorderFactory.createLineBorder(Color.black));
		//frame.setPreferredSize(new Dimension(450, 500));
		frame.setLayout(new BorderLayout());
		frame.add(board,BorderLayout.CENTER);
		frame.add(lPoints,BorderLayout.SOUTH);
		frame.addKeyListener(keylistener);

			

		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void drawSnakePoint(Point point) {
//		System.out.println("Snake Point (" + point.x + "," + point.y + ")");
		Graphics g = board.getGraphics();
		g.setColor(snakeColor);
		g.fillRect(point.x, point.y, pointSize, pointSize);

		board.paintComponents(g);

	}

	@Override
	public void drawFoodPoint(Point point) {
//		System.out.println("Food Point (" + point.x + "," + point.y + ")");
		Graphics g = board.getGraphics();
		g.setColor(foodColor);
		g.fillRect(point.x, point.y, pointSize, pointSize);
		board.paintComponents(g);
	}

	@Override
	public Dimension getWindowSize() {
		
		return BOARD_SIZE;
	}

	@Override
	public void removePoint(Point point) {
		//System.out.println("Remove Point (" + point.x + "," + point.y + ")");
		Graphics g = board.getGraphics();
		g.setColor(defaultColor);
		g.fillRect(point.x, point.y, pointSize, pointSize);
		board.paintComponents(g);
		
	}

	@Override
	public MoveDirection checkDirection() {

		switch(keylistener.getLastPressed()){
		case KeyEvent.VK_DOWN:
			return MoveDirection.DOWN;
		case KeyEvent.VK_UP:
			return MoveDirection.UP;
		case KeyEvent.VK_LEFT:
			return MoveDirection.LEFT;
		case KeyEvent.VK_RIGHT:
			return MoveDirection.RIGHT;
		
		}
		return MoveDirection.RIGHT;
	}

	@Override
	public void setPoints(String points) {
		lPoints.setText("Points: "+points);
		
	}
	

}

