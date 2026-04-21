

import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;


public class GameFrame extends JPanel implements KeyListener {
    int Enemydirection;
    Background background = new Background(0, 0, 480*3, 270*3);
    Upground upground = new Upground(0,0,480*3,270*3);
    Player player = new Player(300,478,16,32);
    Viewport viewport = new Viewport(0,0,480*3,270*3);
    ArrayList<EnemyS> enemyList = new ArrayList<>();
    int scoreC;


    public GameFrame() {
        setFocusable(true);
        addKeyListener(this);
        requestFocusInWindow();

        

        new Timer(16, e -> {

            player.animation();
            for (EnemyS enemyS : enemyList){
                enemyS.muw(player);
                repaint();

            }
            player.setIndex(player.getIndex());
            addEnemy();
            repaint();
            enemyList.removeIf(i -> i.getHp() <= 0);
        }).start();
    }


    public void addEnemy(){
        if (enemyList.size() < 7) {
            Random random = new Random();
            int right = 1445;
            int left = -10;

            //                     (true = left, false = right)
            int x = random.nextBoolean() ? left : right;
            if (x == left) {
                Enemydirection = 1;
            }else {
                Enemydirection = -1;
            }

            //                         0 1 2
            int type = random.nextInt(3);

            switch(type) {
                case 0:
                    enemyList.add(new Enemy1(x, 478, 32, 32, 2, 1, 1,Enemydirection,10));
                    break;
                case 1:
                    enemyList.add(new Enemy2(x, 478, 32, 32, 1, 1, 1,Enemydirection,25));
                    break;
                case 2:
                    enemyList.add(new Enemy3(x, 478, 64, 32, 1, 1, 1,Enemydirection,15));
                    break;
            }
        }
    }



    @Override protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        background.drawBackground(g);


        for (EnemyS enemyS : enemyList){
            if (enemyS.getHp()!=0){
                enemyS.drawEnemy(g);
                enemyS.animation();
                if( player.isCalision(enemyS)){

                    if(player.atack){
                        enemyS.setHp(enemyS.getHp() - 1);
                        scoreC += enemyS.getScoreE();

                    }
                }
            }
        }


        player.drawPlayer(g);

        upground.drawUpground(g);
        viewport.drawUpground(g);
        g.setFont(new Font("Arial",Font.BOLD,64));
        g.drawString(""+scoreC,30,100);



    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W ){player.block = true;}

        if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S ){player.atack = true;}

        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A ) {
            player.setX(player.getX() - player.getSpeed());
            player.setDirection(-1);
            player.run = true;
        }

        if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D ){
            player.setX(player.getX() + player.getSpeed());
            player.setDirection(1);
            player.run = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W ){player.block = false;}

        if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S ){player.atack = false;}

        if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A ) {player.run = false;}

        if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D ){player.run = false;}
    }





}