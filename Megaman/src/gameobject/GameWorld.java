package gameobject;

import java.awt.Graphics2D;

import userinterface.GameFrame;

public class GameWorld {
	public Megaman megaman;
	Camera camera;
	BulletManager bulletManager;
	PhysicalMap physicalMap;
	public GameWorld() {
		megaman = new Megaman(300, 300,this);
		physicalMap = new PhysicalMap(0, 0,this);
		bulletManager = new BulletManager(this);
		camera = new Camera(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, this);
	}
	public void update() {
		megaman.update();
		camera.update();
		bulletManager.UpdateObjects();
	}
	public void render(Graphics2D g2) {
		physicalMap.draw(g2);
		megaman.draw(g2);
		bulletManager.draw(g2);
	}
}
