

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameFrame extends JPanel implements ActionListener, KeyListener {
    Background background = new Background(0, 0, 480*3, 270*3);
    Upground upground = new Upground(0,0,480*3,270*3);
    Player player = new Player(300,478,16,32);



    public GameFrame() {
        setFocusable(true);
        addKeyListener(this);
        requestFocusInWindow();

        new Timer(16, e -> {
            player.animation();
            player.setIndex(player.getIndex());

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

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP){
            player.block = true;
        }

        if (code == KeyEvent.VK_DOWN){
            player.atack = true;
        }

        if (code == KeyEvent.VK_LEFT) {
            player.setX(player.getX() - player.getSpeed());
            player.setDirection(-1);
        }

        if (code == KeyEvent.VK_RIGHT){
            player.setX(player.getX() + player.getSpeed());
            player.setDirection(1);
        }
        player.run = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.run=false;
        player.atack=false;
        player.block=false;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }


}