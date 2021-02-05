package snake.scene;

import static snake.util.Constants.SNAKE_COLOR;
import static snake.util.Constants.SNAKE_ELONGATE_PIECES;
import static snake.util.Constants.SNAKE_START_X;
import static snake.util.Constants.SNAKE_START_Y;
import static snake.util.Constants.SNAKE_INITIAL_SIZE;
import static snake.util.Constants.SNAKE_PIECE_SIZE;

import snake.core.Direction;
import snake.graphics.Rect;
import snake.graphics.Shape;
import snake.util.GameUtils;

public class Snake extends Shape {

	private Direction direction;
	private int piecesToElongate;

	public Snake() {
		super(SNAKE_COLOR);

		direction = Direction.NONE;
		Rect rect = new Rect(SNAKE_START_X, SNAKE_START_Y, SNAKE_PIECE_SIZE,
				SNAKE_PIECE_SIZE);
		addRect(rect); // Cabeça da Snake

		for (int i = 1; i < SNAKE_INITIAL_SIZE; i++) {
			rect = duplicate(rect, Direction.LEFT);
			addRect(rect);
		}
	}

	public void move() {
		if (direction != Direction.NONE) {
			GameUtils.moveRect(getRects());
			getRects().set(0, duplicate(getFirstRect(), direction));
			
			if (piecesToElongate > 0) {
				getRects().add(getLastRect());
				piecesToElongate--;
			}
		}
	}

	public void up() {
		changeTo(Direction.UP);
	}

	public void down() {
		changeTo(Direction.DOWN);
	}

	public void left() {
		changeTo(Direction.LEFT);
	}

	public void rigth() {
		changeTo(Direction.RIGTH);
	}

	public boolean collidedWithItself() {
		for (int i = 1; i < getRects().size(); i++) {
			if (getFirstRect().intersects(getRects().get(i))) {
				return true;
			}
		}

		return false;
	}
	
	public void elongate() {
		piecesToElongate = SNAKE_ELONGATE_PIECES;
	}

	private synchronized void changeTo(Direction direction) {
		if (direction.canChangeTo(direction)) {
			this.direction = direction;
		}
	}
}
