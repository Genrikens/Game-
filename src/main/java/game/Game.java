package game;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Game extends JFrame {


    public Game() {

        setTitle("Samuraj Game");
        setSize(480*3+1, 270*3+38);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        


        GameFrame gameFrame = new GameFrame();
        add(gameFrame);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Game().setVisible(true);
        });
    }
}