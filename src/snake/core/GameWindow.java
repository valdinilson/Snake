package snake.core;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import snake.graphics.Renderer;
import snake.scene.Snake;
import snake.util.Constants;

@SuppressWarnings("serial")
public class GameWindow extends JFrame implements KeyListener {

	private Renderer renderer;
	private Snake snake;
	private Image buffer;
	private Graphics gImage;

	public GameWindow(Snake snake) {
		this.renderer = new Renderer();
		this.snake = snake;
		
		setTitle(Constants.GAME_TILE);
		setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addKeyListener(this);
		setVisible(true);
		
		buffer = createImage(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
		gImage = buffer.getGraphics();
	}
	
	public Renderer getRenderer() {
		return renderer;
	}

	@Override
	public void paint(Graphics gScreen) {
		renderer.render(gImage);
		gScreen.drawImage(buffer, 0, 0, null);
	}

	@Override
	public void keyPressed(KeyEvent e) {
	    switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			snake.up();
			break;
		case KeyEvent.VK_DOWN:
			snake.down();
			break;
		case KeyEvent.VK_RIGHT:
			snake.rigth();
			break;
		case KeyEvent.VK_LEFT:
			snake.left();
			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(NORMAL);;
			break;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {		
	}

}
