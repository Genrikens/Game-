

import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;


public class GameFrame extends JPanel implements KeyListener {
    private int spawnTickCounter = 0; // считает тики таймера (каждый тик ~16ms)
    private int spawnIntervalTicks = 75; // через сколько тиков спавнить (75*16ms ≈ 1200ms)

    private static final Image DEAD= SpriteLoader.load("game/DEAD.png");
    private static final Image Bexit = SpriteLoader.load("game/exit.png");
    private static final Image Bplay = SpriteLoader.load("game/replay.png");
    int coldawn;
    int dir;
    Background background = new Background(0, 0, 480*3, 270*3);
    Upground upground = new Upground(0,0,480*3,270*3);
    Player player = new Player(300,478,16,32);
    Viewport viewport = new Viewport(0,0,480*3,270*3);
    ArrayList<EnemyS> enemyList = new ArrayList<>();
    private int nextEnergitikTime = 250;

    JLabel DEADL = new JLabel();
    JButton play = new JButton();
    JButton exit = new JButton();
    JPanel buttons = new JPanel();

    int scoreC;
    Energitik energitik;


    public GameFrame() {
        setLayout(null);
        addKeyListener(this);
        setFocusable(true);

        int rr = 49;



        DEADL.setIcon(new ImageIcon(DEAD.getScaledInstance(480*2,270*2,Image.SCALE_SMOOTH)));
        DEADL.setBounds(250, -700, 480*8, 270*8);
        DEADL.setVisible(false);
        add(DEADL);


        play.setIcon(new ImageIcon(Bplay.getScaledInstance(rr,rr,Image.SCALE_SMOOTH)));// позиция и размер панели в buttons
        play.setPreferredSize(new Dimension(rr,rr));
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);
        play.addActionListener(e -> {
            restart();
        });


        exit.setIcon(new ImageIcon(Bexit.getScaledInstance(rr,rr,Image.SCALE_SMOOTH)));// позиция и размер панели в buttons
        exit.setPreferredSize(new Dimension(rr,rr));
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.addActionListener(e -> System.exit(0));



        buttons.setOpaque(false);
        buttons.setBounds(234, 19, 300, 200); // позиция и размер панели в GameFrame



        buttons.add(exit);
        buttons.add(play);

        add(buttons);
        buttons.setVisible(false);












        new Timer(16, e -> {

            if (player.isDead()) {
             buttons.setVisible(true);
             DEADL.setVisible(true);
            }


                if (!player.isDead()) {

                repaint();

                player.animation();
                    for (EnemyS enemyS : enemyList) {
                        dir = (enemyS.getX() < player.getX()) ? 1 : -1;
                        enemyS.setDirection(dir);

                        enemyS.muw(player);
                        enemyS.Atack(player);
                    }


                    if (energitik != null && player.isCalisionEnergitik(energitik)) {
                    if (player.getHp() != 3) {
                        player.setHp(player.getHp() + 1);
                        energitik = null;
                    }
                }
                addEnergitik();
                player.setIndex(player.getIndex());

                    spawnTickCounter++;
                    if (spawnTickCounter >= spawnIntervalTicks) {
                        if (enemyList.size() < 7) {
                            spawnOneEnemy();
                        }
                        spawnTickCounter = 0;
                    }



                repaint();
                enemyList.removeIf(i -> i.getHp() <= 0);
            }
        }).start();
    }



    public void restart() {
        DEADL.setVisible(false);
        scoreC = 0;
        nextEnergitikTime = 250;
        enemyList.clear();
        energitik = null;
        coldawn = 15;
        player.setX(300);
        player.setY(478);
        player.setHp(3);
        player.setDead(false);
        player.run = false;
        player.atack = false;
        player.block = false;
        player.setDirection(1);
        player.setIndex(0);


        buttons.setVisible(false);

        repaint();
    }




    public void addEnergitik(){
        if (energitik == null && scoreC >= nextEnergitikTime){
            energitik = new Energitik(500,500,16,16);
            nextEnergitikTime += 550;
        }
    }




    public void spawnOneEnemy() {


            Random random = new Random();
            int right = 1445;
            int left = -10;

            int x = random.nextBoolean() ? left : right;
            int direction = (x < player.getX()) ? 1 : -1;

            int type = random.nextInt(3);

            switch (type) {
                case 0: {
                    EnemyS Enemy1 = new Enemy1(x, 478, 32, 32, 2, 1, 1, direction, 10, 100);
//                    for (EnemyS enemyS : enemyList) {
//                        if (enemyS.isCalEnemy(enemyS)) {
//                            return;
//                        }
//                    }
                    enemyList.add(Enemy1);
                    break;
                }
                case 1: {
                    EnemyS Enemy2 = new Enemy2(x, 478, 32, 32, 1, 1, 2, direction, 25, 50);
//                    for (EnemyS enemyS : enemyList) {
//                        if (enemyS.isCalEnemy(enemyS)) return;
//                    }
                    enemyList.add(Enemy2);
                    break;
                }
                case 2: {
                    EnemyS Enemy3 = new Enemy3(x, 478, 64, 32, 1, 1, 1, direction, 15, 10);
//                    for (EnemyS enemyS : enemyList) {
//                        if (enemyS.isCalEnemy(enemyS)) return;
//                    }
                    enemyList.add(Enemy3);
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
                coldawn--;
                if (coldawn<=0) {
                    enemyS.animation();
                    coldawn = 15;
                }
                if( player.isCalision(enemyS)){

                    if(player.atack){
                        enemyS.setHp(enemyS.getHp() - 1);
                        scoreC += enemyS.getScoreE();

                    }
                }
            }
        }


        player.drawPlayer(g);
        if (energitik != null){
            energitik.drawEnergitik(g);
        }

        upground.drawUpground(g);
        viewport.drawUpground(g);
        g.setColor(new Color(0x83, 0x95, 0x9F));
        g.setFont(new Font("Arial",Font.BOLD,64));
        g.drawString("" + scoreC,30,100);
        player.drawHP(g);


    }


    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
            player.block = true;
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
            player.atack = true;
                break;

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
            player.setX(player.getX() - player.getSpeed());

            if (player.getX() >= -10) {
                player.setDirection(-1);
                player.run = true;
                break;
            }else {
                player.setX(-19);
                player.setDirection(-1);
            }

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
            player.setX(player.getX() + player.getSpeed());
                if (player.getX() <= 1385) {
                    player.setDirection(1);
                    player.run = true;
                    break;
                }else{
                    player.setDirection(-1);
                    player.setX(1384);
                }
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