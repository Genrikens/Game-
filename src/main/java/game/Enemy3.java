import java.awt.*;

public class Enemy3 extends EnemyS {
    private static final Image[] enemy_run = SpriteLoader.getFrames("/enemy3/enemy_3_run.png", 32, 32, 2);
    private static final Image[] enemy_atack = SpriteLoader.getFrames("enemy3/enemy3ATACK.png", 192/2, 32, 2);
    private int index, direction, runP,indexAtack;
    private int img = 32*3;

    public Enemy3(int x, int y, int w, int h, int speed, int hp, int damage, int direction,int scoreP,int coldawnbAtack) {
        super(x, y, w, h, speed, hp, damage, scoreP);
        this.direction = direction;
        this.coldawnbAtack = coldawnbAtack;

    }

    @Override
    public void Atack(Player player) {
        if (isCalision(player)) {
            
            coldawnbAtack--;
            atack = true;

            if (coldawnbAtack == 0 && isCalision(player)) {
                if (!player.isBlock()) {
                    player.setHp(player.getHp() - damage);

                }
                if(direction == -1){
                    setX(getX()-200);
                }else setX(getX()+200);

                coldawnbAtack = 10;
            }
        } else atack = false;
    }


    @Override
    public Rectangle atackArea() {
        return new Rectangle(getX()+8,getY()+70,90,10);
    }

    public Rectangle Colision() {
        return new Rectangle(getX(),getY(),img,img);
    }

    public void animation() {

        indexAtack++;
        if(indexAtack == 2){
            indexAtack = 0;
        }
        index++;
        if (index == 2) {
            index = 0;
        }

    }

    @Override
    public void drawEnemy(Graphics g) {


        int drawX = getX();
        if (direction == -1) {
            runP = 200;
            drawX = getX() + (img - getW());
        }else{runP = 0;}

        Image frame = enemy_run[index];
        if(!atack){
            g.drawImage(frame, drawX+runP, getY(), img * direction, img, null);
        }
        if (atack){
            frame = enemy_atack[indexAtack];
            g.drawImage(frame, drawX+runP, getY(), img*3 * direction, img, null);

        }


        // хитбокс
//        g.setColor(Color.green);
//        g.drawRect(getX(), getY(), img, img);

        super.drawEnemy(g);
    }
    @Override
    public void setDirection(int direction) {
        this.direction = direction;
    }
}