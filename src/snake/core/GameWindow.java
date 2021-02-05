package snake.core;

import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;
import static java.lang.System.exit;
import static snake.util.Constants.GAME_MIN_TIME_BETWEEN_KEYBOARD_EVENTS;
import static snake.util.Constants.GAME_TILE;
import static snake.util.Constants.WINDOW_HEIGHT;
import static snake.util.Constants.WINDOW_WIDTH;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import snake.graphics.Renderer;
import snake.scene.Snake;

@SuppressWarnings("serial")
public class GameWindow extends JFrame implements KeyListener {

	private Renderer renderer;
	private Snake snake;
	private Image buffer;
	private Graphics gImage;
	private Rectangle drawingArea;
	private long lastKeyboardEventTime;

	public GameWindow(Snake snake) {
		this.renderer = new Renderer();
		this.snake = snake;

		setTitle(GAME_TILE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		addKeyListener(this);
		setVisible(true);

		buffer = createImage(WINDOW_WIDTH, WINDOW_HEIGHT);
		gImage = buffer.getGraphics();

		defineDrawingArea();
	}

	public Renderer getRenderer() {
		return renderer;
	}

	@Override
	public void paint(Graphics gScreen) {
		if (renderer != null && gImage != null && buffer != null) {
			renderer.render(gImage);
			gScreen.drawImage(buffer, 0, 0, null);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		long now = System.currentTimeMillis();

		if (now - lastKeyboardEventTime < GAME_MIN_TIME_BETWEEN_KEYBOARD_EVENTS) {
			return;
		}

		switch (e.getKeyCode()) {
		case VK_UP:
			snake.up();
			break;
		case VK_DOWN:
			snake.down();
			break;
		case VK_RIGHT:
			snake.rigth();
			break;
		case VK_LEFT:
			snake.left();
			break;
		case VK_ESCAPE:
			exit(NORMAL);
			;
			break;
		}

		lastKeyboardEventTime = now;
	}

	public Rectangle getDrawingArea() {
		return drawingArea;
	}

	private void defineDrawingArea() {
		int upperY = WINDOW_HEIGHT - (int) getContentPane().getSize().getHeight();
		drawingArea = new Rectangle(0, upperY, WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
