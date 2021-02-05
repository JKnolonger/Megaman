package userinterface;


import java.awt.event.KeyEvent;

import gameobject.GameWorld;
import gameobject.Megaman;


public class InputManager {
private GamePanel gamePanel;
private GameWorld gameWorld;
	public InputManager(GameWorld  gameWorld) {
		this.gameWorld = gameWorld;
	}
	public void processKeyPressed(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_A:
			gameWorld.megaman.setDirection(Megaman.DIR_LEFT);
			gameWorld.megaman.setSpeedX(-5);
			break;
		case KeyEvent.VK_S:
			break;
		case KeyEvent.VK_D:
			gameWorld.megaman.setDirection(Megaman.DIR_LEFT);
			gameWorld.megaman.setSpeedX(5);
			break;
		case KeyEvent.VK_W:
			System.out.println("pressed W");
			break;
		case KeyEvent.VK_SPACE:
			gameWorld.megaman.setSpeedY(-3);
			gameWorld.megaman.setPosY(gameWorld.megaman.getPosY()+(-3));
			break;
		default:
			break;
		}
	}
	public void processKeyReleased(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_A:
			gameWorld.megaman.setSpeedX(0);
			break;
		case KeyEvent.VK_S:
			System.out.println("released S");
			break;
		case KeyEvent.VK_D:
			gameWorld.megaman.setSpeedX(0);
			break;
		case KeyEvent.VK_W:
			System.out.println("released W");
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("space");
			break;
		default:
			break;
		}
	}
    
}
