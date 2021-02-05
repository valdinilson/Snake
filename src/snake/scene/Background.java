package snake.scene;

import static snake.util.Constants.BACKGROUND_COLOR;
import static snake.util.Constants.WINDOW_HEIGHT;
import static snake.util.Constants.WINDOW_WIDTH;

import snake.graphics.Rect;

public class Background extends Rect {

	public Background() {
		super(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		setColor(BACKGROUND_COLOR);
	}
}
