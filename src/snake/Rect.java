package snake;

import java.awt.Color;
import java.awt.Graphics;

public class Rect {

	private int width;
	private int height;
	private Point point;
	private Color color;

	public Rect(int x, int y, int width, int height, Color color) {
		point = new Point(x, y);
		this.height = height;
		this.width = width;
		this.color = color;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(point.getX(), point.getY(), this.width, this.height);
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getX() {
		return point.getX();
	}
	
	public int getY() {
		return point.getY();
	}
}
