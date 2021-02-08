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
			gameWorld.megaman.setDirection(gameWorld.megaman.LEFT_DIR);
			gameWorld.megaman.run();
			break;
		case KeyEvent.VK_S:
			break;
		case KeyEvent.VK_D:
			gameWorld.megaman.setDirection(gameWorld.megaman.RIGHT_DIR);
			gameWorld.megaman.run();
			break;
		case KeyEvent.VK_W:
			System.out.println("pressed W");
			break;
		case KeyEvent.VK_SPACE:
			gameWorld.megaman.jump();
			break;
		case KeyEvent.VK_SHIFT:
			gameWorld.megaman.attack();
		default:
			break;
		}
	}
	public void processKeyReleased(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_A:
			if(gameWorld.megaman.getSpeedX()<0)
				gameWorld.megaman.stopRun();
			break;
		case KeyEvent.VK_S:
			System.out.println("released S");
			break;
		case KeyEvent.VK_D:
			if(gameWorld.megaman.getSpeedX()>0)
				gameWorld.megaman.stopRun();
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
