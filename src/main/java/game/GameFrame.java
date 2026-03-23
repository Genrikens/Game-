package game;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JPanel {
    Background background = new Background(0, 0, 480*3, 270*3);
    Upground upground = new Upground(0,0,480*3,270*3);
    Player player = new Player(300,478,16,32);

    public GameFrame() {

        new Timer(16, e -> {

            repaint();

        }).start();
    }



    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        background.drawBackground(g);
        player.drawPlayer(g);
        upground.drawUpground(g);


        g.setColor(new Color(111, 100, 255));
        g.drawRect(0, 0, 480*3, 270*3);


    }

}