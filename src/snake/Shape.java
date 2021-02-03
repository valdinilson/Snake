package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Shape extends Drawable {

	private List<Rect> rects;

	public Shape(Color color) {
		super(color);
		rects = new ArrayList<>();
	}

	public void addRect(Rect rect) {
		rects.add(rect);
	}

	@Override
	public void draw(Graphics g) {
		for (Rect rect : rects) {
			rect.draw(g);
		}
	}

	public Rect duplicate(Rect baseRect) {
		int baseX = (int) baseRect.getLocation().getX();
		int baseY = (int) baseRect.getLocation().getY();

		Rect newRect = new Rect(new Point(baseX - (int) baseRect.getDimension().getWidth(), baseY),
				baseRect.getDimension());
		return newRect;
	}
}
