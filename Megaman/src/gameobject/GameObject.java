package gameobject;
//doi tuong trong game chia lam 2 loai: nhan vat, quai.... va physicalmap,backgroundmap...
public abstract class GameObject {
private float posX;
private float posY;
private GameWorld gameWorld;
public GameObject(float posX, float posY, GameWorld gameWorld) {
	super();
	this.posX = posX;
	this.posY = posY;
	this.gameWorld = gameWorld;
}
public float getPosX() {
	return posX;
}
public void setPosX(float posX) {
	this.posX = posX;
}
public float getPosY() {
	return posY;
}
public void setPosY(float posY) {
	this.posY = posY;
}
public GameWorld getGameWorld() {
	return gameWorld;
}
public void setGameWorld(GameWorld gameWorld) {
	this.gameWorld = gameWorld;
}
public abstract void update();

	
}

