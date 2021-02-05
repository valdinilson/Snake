package snake.scene;

import static snake.util.Constants.GAME_OVER_COLOR;
import static snake.util.Constants.GAME_OVER_TEXT;
import static snake.util.Constants.GAME_OVER_location;

import snake.graphics.Text;

public class GameOverText extends Text {

	public GameOverText(int score) {
		super(String.format(GAME_OVER_TEXT, score), GAME_OVER_location, GAME_OVER_COLOR);
	}
}
