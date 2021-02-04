package snake.graphics;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Renderer {

	private List<Drawable> drawables;

	public Renderer() {
		drawables = new ArrayList<>();
	}

	public void add(Drawable drawable) {
		drawables.add(drawable);
	}

	public void remove(Drawable drawable) {
		drawables.remove(drawable);
	}

	public void render(Graphics g) {
		for (Drawable drawable : drawables) {
			g.setColor(drawable.getColor());
			drawable.draw(g);
		}
	}
}
