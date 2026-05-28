import java.awt.*;

public class Enemy2 extends EnemyS {
    private static final Image[] enemy_run = SpriteLoader.getFrames("/enemy2/enemy_2_run.png", 64, 32, 2);
    private static final  Image[] enemy_atack = SpriteLoader.getFrames("enemy2/enemy2ATACK.png",64,32,6);
    private int index, direction,indexAtack;



    public Enemy2(int x, int y, int w, int h, int speed, int hp, int damage, int direction,int scoreP, int coldawnbAtack) {
        super(x, y, w, h, speed, hp, damage,scoreP);
        this.direction = direction;
        this.coldawnbAtack = coldawnbAtack;

    }

    @Override
    public void Atack(Player player) {
        if (isCalision(player)){

            coldawnbAtack--;
            atack = true;

            if(coldawnbAtack == 0 && isCalision(player)) {
                if (!player.isBlock()) {
                    player.setHp(player.getHp() - damage);
                }
                coldawnbAtack = 50;
            }
        }else atack = false;

    }
    @Override
    public Rectangle atackArea() {
        return new Rectangle(getX()+8,getY()+70,90,10);
    }


    @Override
    public Rectangle Colision() {
        return super.Colision();
    }

    public void animation() {

        indexAtack++;
        if(indexAtack == 6){
            indexAtack = 0;
        }


        index++;
        if (index == 2) {
            index = 0;
        }

    }

    @Override
    public void drawEnemy(Graphics g) {

        int img = 64*3;

        int drawX = getX();
        if (direction == -1) {
            drawX = getX() + (img - getW());
        }

        Image frame = enemy_run[index];
        if (atack){
            frame = enemy_atack[indexAtack];
        }
        g.drawImage(frame, drawX, getY(), 64*3 * direction, 32*3, null);

        // хитбокс
        //g.drawRect(getX(), getY(), 32*3, 32*3);

        super.drawEnemy(g);
    }
    @Override
    public void setDirection(int direction) {
        this.direction = direction;
    }
}