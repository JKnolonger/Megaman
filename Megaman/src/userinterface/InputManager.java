package userinterface;


import java.awt.event.KeyEvent;


public class InputManager {
private GamePanel gamePanel;
	public InputManager(GamePanel  gamePanel) {
		this.gamePanel = gamePanel;
	}
	public void processKeyPressed(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_A:
			gamePanel.megaman.setSpeedX(-5);
			break;
		case KeyEvent.VK_S:
			System.out.println("pressed S");
			break;
		case KeyEvent.VK_D:
			gamePanel.megaman.setSpeedX(5);
			break;
		case KeyEvent.VK_W:
			System.out.println("pressed W");
			break;

		default:
			break;
		}
	}
	public void processKeyReleased(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_A:
			System.out.println("released A");
			break;
		case KeyEvent.VK_S:
			System.out.println("released S");
			break;
		case KeyEvent.VK_D:
			System.out.println("released D");
			break;
		case KeyEvent.VK_W:
			System.out.println("released W");
			break;

		default:
			break;
		}
	}
    
}
