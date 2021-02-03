package snake;

public class Snake extends Shape {

	public Snake() {
		super(Constants.SNAKE_COLOR);

		Rect rect = new Rect(120, 100, 6, 6);
		addRect(rect); // Cabeça da Snake

		for (int i = 1; i < Constants.SNAKE_PIECE_SIZE; i++) {
			rect = duplicate(rect);
			addRect(rect);
		}
	}
}
