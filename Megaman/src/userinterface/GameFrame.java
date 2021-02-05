package userinterface;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JFrame;
import effect.CacheDataLoader;
import userinterface.GameFrame;
import userinterface.GamePanel;

public class GameFrame extends JFrame{

    public static final int SCREEN_WIDTH = 1000;
    public static final int SCREEN_HEIGHT = 600;

    GamePanel gamePanel;

    public GameFrame(){

        Toolkit toolkit = this.getToolkit();
        Dimension solution = toolkit.getScreenSize();
        this.setBounds((solution.width - SCREEN_WIDTH)/2, (solution.height - SCREEN_HEIGHT)/2, SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            CacheDataLoader.getInstance().LoadData();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        gamePanel = new GamePanel();
        add(gamePanel);
        this.addKeyListener(gamePanel);

    }

    public void startGame(){

            gamePanel.startGame();
            this.setVisible(true);

    }

    public static void main(String arg[]){

            GameFrame gameFrame = new GameFrame();
            gameFrame.startGame();

    }
        
}
