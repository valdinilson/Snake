package snake.core;

import static snake.util.Constants.SLEEP_TIME;
import static snake.util.Constants.SNAKE_PIECE_SIZE;

import java.awt.Rectangle;

import snake.graphics.Rect;
import snake.graphics.Renderer;
import snake.scene.Background;
import snake.scene.Food;
import snake.scene.GameOverText;
import snake.scene.Snake;
import snake.util.GameUtils;

public class Game implements Runnable {

	private GameWindow gameWindow;
	private Snake snake;
	private Renderer renderer;
	private Food food;

	public void start() {
		snake = new Snake();
		gameWindow = new GameWindow(snake);
		food = new Food(snake, gameWindow.getDrawingArea());

		renderer = gameWindow.getRenderer();
		
		addElementToScreen();
		
		new Thread(this).start();
	}
	
	private void addElementToScreen() {
		renderer.add(new Background());
		renderer.add(snake);
		renderer.add(food);
	}

	@Override
	public void run() {
		do {
			gameWindow.repaint();
			snake.move();
			food.checkIfEaten(snake, gameWindow.getDrawingArea());
			GameUtils.sleep(SLEEP_TIME);
		
		} while (!isGameOver());
		
		processGameOver();
	}
	
	private void processGameOver() {
		renderer.remove(snake);
		renderer.remove(food);
		renderer.add(new GameOverText(food.getEatenTimes()));
		gameWindow.repaint();
	}
	
	private boolean isGameOver() {
		return isSnakeHitBounds() || snake.collidedWithItself();
	}
	
	private boolean isSnakeHitBounds() {
		Rect head = snake.getFirstRect();
		Rectangle drawingArea = gameWindow.getDrawingArea();
		
		int headX = (int) head.getLocation().getX();
		int headY = (int) head.getLocation().getY();
		
		int areaX1 = (int) drawingArea.getMinX();
		int areaY1 = (int) drawingArea.getMinY() - SNAKE_PIECE_SIZE * 2;
		
		int areaX2 = (int) drawingArea.getMaxX();
		int areaY2 = (int) drawingArea.getMaxY();
		
		if (headX <= areaX1 || headX + SNAKE_PIECE_SIZE >= areaX2) {
			return true;
		}
		
		if (headY <= areaY1 || headY + SNAKE_PIECE_SIZE >= areaY2) {
			return true;
		}

		return false;
	}
}
