package userinterface;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import gameobject.Megaman;

public class GamePanel extends JPanel implements Runnable, KeyListener{

private	Thread thread;
private InputManager inputManager;
private BufferedImage bufferImage;
private Graphics2D bufG2D;
Megaman megaman = new Megaman(300, 300, 100, 200, 0.1f);
    public boolean isRunning = true;

    public GamePanel(){
      
        inputManager = new InputManager(this);
        bufferImage  = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
    }

    public void startGame(){
        if(thread == null) {
        	isRunning = true;
        	thread = new Thread(this);
        	thread.start();
        }
    }
    @Override
    public void run() {
    	long FPS = 80;
    	long period = 1000*1000000/FPS;
        long beginTime;
        long sleepTime;
        beginTime = System.nanoTime();


        while(isRunning){
        	updateGame();
        	renderGame();
        	repaint();
        	long deltaTime = System.nanoTime() - beginTime;
        	sleepTime = period - deltaTime;
           
            try{
            	if(sleepTime > 0)
            		Thread.sleep(sleepTime/1000000);
                else Thread.sleep(period/2000000);

            }catch(Exception e){}

            beginTime = System.nanoTime();
        }

    }
    public void updateGame() {
    	megaman.update();
    }
    public void renderGame() {
    	if(bufferImage == null) {
    		bufferImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
    	}
    	if(bufferImage != null) {
    		bufG2D = (Graphics2D) bufferImage.getGraphics();
    	}
    	if(bufG2D != null) {
    		bufG2D.setColor(Color.WHITE);
    		bufG2D.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
    		//draw game object here
    		megaman.draw(bufG2D);;
    	}
    }
    public void paint(Graphics g){

       g.drawImage(bufferImage, 0, 0, this);
        
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        inputManager.processKeyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        inputManager.processKeyReleased(e.getKeyCode());
    }

}
