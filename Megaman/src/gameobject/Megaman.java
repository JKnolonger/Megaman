package gameobject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Megaman {
	//posX duoc cho la tam cua nhan vat, k phai diem ben tren ben trai
	private float posX;
	//posY duoc cho la tam cua nhan vat, k phai diem ben tren ben trai
	private float posY;
	
	private float width;
	private float height;
	private float mass;
	
	private float speedX;
	private float speedY;
	
	public static int DIR_LEFT;
	public static int DIR_RIGHT;
	private int direction;
	GameWorld gameWorld;
	public Megaman(float posX, float posY, float width, float height, float mass,GameWorld gameWorld) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.mass = mass;
		this.gameWorld = gameWorld;
	}
	public void draw(Graphics2D g2) {
		g2.setColor(Color.BLUE);
		g2.fillRect((int)(posX-getWidth()/2),(int)(posY - getHeight()/2), (int)width,(int)height);
		g2.setColor(Color.BLACK);
		g2.fillRect((int)posX,(int)posY ,2,2);
	}
	public void update() {
		setPosX(posX + speedX);
		Rectangle futureRect = getBoundForCollisionWithMap();
		futureRect.y += speedY;
		Rectangle rectLand = gameWorld.physicalMap.haveCollisionWithLand(futureRect);
		if(rectLand != null) setPosY(rectLand.y -getHeight()/2);
			
		else {
			setPosY(getPosY() + speedY);
			setSpeedY(getSpeedY()+mass);
			
		}
	}
	public Rectangle getBoundForCollisionWithMap(){
		Rectangle bound = new Rectangle();
		bound.x = (int) (getPosX() - (getWidth()/2));
		bound.y = (int) (getPosY() - (getHeight()/2));
		bound.width = (int) getWidth();
		bound.height = (int) getHeight();
	return bound;
			
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
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getMass() {
		return mass;
	}
	public void setMass(float mass) {
		this.mass = mass;
	}
	public float getSpeedX() {
		return speedX;
	}
	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}
	public float getSpeedY() {
		return speedY;
	}
	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	
}
