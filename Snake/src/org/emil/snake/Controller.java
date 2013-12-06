package org.emil.snake;

import java.awt.event.KeyEvent;

public class Controller implements WindowController {

	private int lastPressed = 0;

	public int getLastPressed() {
		return lastPressed;
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			if (lastPressed != KeyEvent.VK_UP && lastPressed != KeyEvent.VK_DOWN) {
				lastPressed = KeyEvent.VK_DOWN;
			}
			// System.out.println("down");
			break;
		case KeyEvent.VK_UP:
			if (lastPressed != KeyEvent.VK_UP && lastPressed != KeyEvent.VK_DOWN) {
				lastPressed = KeyEvent.VK_UP;
			}
			// System.out.println("up");
			break;
		case KeyEvent.VK_LEFT:
			if (lastPressed != KeyEvent.VK_LEFT && lastPressed != KeyEvent.VK_RIGHT) {
				lastPressed = KeyEvent.VK_LEFT;
			}
			// System.out.println("left");
			break;
		case KeyEvent.VK_RIGHT:
			if (lastPressed != KeyEvent.VK_LEFT && lastPressed != KeyEvent.VK_RIGHT) {
				lastPressed = KeyEvent.VK_RIGHT;
			}
			// System.out.println("right");
			break;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
