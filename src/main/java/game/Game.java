import javax.swing.*;


public class Game extends JFrame {



    public Game(){
        setTitle("Samuraj Game");
        setSize(480 * 3 + 1, 270 * 3 + 38);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(false);
        setResizable(false);
        requestFocusInWindow(true);



        GameFrame gameFrame = new GameFrame();
        add(gameFrame);
    }
}
