package snake.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Rect extends Drawable {

	private Rectangle rectangle;
	
	public Rect(int x, int y, int width, int height) {
		this(new Point(x, y), new Dimension(width, height));
	}

	public Rect(Point location, Dimension dimension) {
		rectangle = new Rectangle(location, dimension);
	}

	@Override
	public void draw(Graphics g) {
		g.fillRect((int) getLocation().getX(), (int) getLocation().getY(), (int) getDimension().getWidth(),
				(int) getDimension().getHeight());
	}

	public Point getLocation() {
		return rectangle.getLocation();
	}
	
	public void setlocation(Point location) {
		rectangle.setLocation(location);
	} 

	public Dimension getDimension() {
		return rectangle.getSize();
	}
	
	public void setDimension(Dimension dimension) {
		rectangle.setSize(dimension);
	}
	
	public boolean intersects(Rect other) {
		return rectangle.intersects(other.rectangle);
	}
}
