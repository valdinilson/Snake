package snake.scene;

import snake.core.Direction;
import snake.graphics.Rect;
import snake.graphics.Shape;
import snake.util.Constants;
import snake.util.GameUtils;

public class Snake extends Shape {

	private Direction direction;

	public Snake() {
		super(Constants.SNAKE_COLOR);

		direction = Direction.NONE;
		Rect rect = new Rect(Constants.SNAKE_INITIAL_X, Constants.SNAKE_INITIAL_Y, Constants.SNAKE_PIECE_SIZE,
				Constants.SNAKE_PIECE_SIZE);
		addRect(rect); // Cabeça da Snake

		for (int i = 1; i < Constants.SNAKE_SIZE; i++) {
			rect = duplicate(rect, Direction.LEFT);
			addRect(rect);
		}
	}

	public void move() {
		if (direction != Direction.NONE) {
			GameUtils.moveRect(getRects());
			getRects().set(0, duplicate(getFirstRect(), direction));
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

	public boolean collideWithItself() {
		for (int i = 1; i < getRects().size(); i++) {
			if (getFirstRect().intersects(getRects().get(i))) {
				return true;
			}
		}

		return false;
	}

	private void changeTo(Direction direction) {
		if (direction.canChangeTo(direction)) {
			this.direction = direction;
		}
	}
}
