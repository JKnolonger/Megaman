package userinterface;


import java.awt.event.KeyEvent;

import gameobject.Megaman;


public class InputManager {
private GamePanel gamePanel;
	public InputManager(GamePanel  gamePanel) {
		this.gamePanel = gamePanel;
	}
	public void processKeyPressed(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_A:
			gamePanel.megaman.setDirection(Megaman.DIR_LEFT);
			gamePanel.megaman.setSpeedX(-5);
			break;
		case KeyEvent.VK_S:
			break;
		case KeyEvent.VK_D:
			gamePanel.megaman.setDirection(Megaman.DIR_LEFT);
			gamePanel.megaman.setSpeedX(5);
			break;
		case KeyEvent.VK_W:
			System.out.println("pressed W");
			break;
		case KeyEvent.VK_SPACE:
			gamePanel.megaman.setSpeedY(-3);
			gamePanel.megaman.setPosY(gamePanel.megaman.getPosY()+(-3));
			break;
		default:
			break;
		}
	}
	public void processKeyReleased(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_A:
			gamePanel.megaman.setSpeedX(0);
			break;
		case KeyEvent.VK_S:
			System.out.println("released S");
			break;
		case KeyEvent.VK_D:
			gamePanel.megaman.setSpeedX(0);
			break;
		case KeyEvent.VK_W:
			System.out.println("released W");
			break;
		case KeyEvent.VK_SPACE:
			
			break;
		default:
			break;
		}
	}
    
}
