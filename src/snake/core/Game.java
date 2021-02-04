package snake.core;

import snake.graphics.Renderer;
import snake.scene.Background;
import snake.scene.Snake;
import snake.util.GameUtils;

public class Game implements Runnable {

	private GameWindow gameWindow;
	private Snake snake;
	private Renderer renderer;

	public void start() {
		snake = new Snake();
		gameWindow = new GameWindow(snake);

		renderer = gameWindow.getRenderer();
		
		addElementToScreen();
		
		new Thread(this).start();
	}
	
	private void addElementToScreen() {
		renderer.add(new Background());
		renderer.add(snake);
	}

	@Override
	public void run() {
		while (!isGameOver()) {
			snake.move();
			gameWindow.repaint();
			GameUtils.sleep(30);
		}
		
		gameWindow.dispose();
	}

	private boolean isGameOver() {
		return snake.collideWithItself();
	}
}
