import java.awt.*;

public class Enemy3 extends EnemyS {
    private static final Image[] enemy_run = SpriteLoader.getFrames("/enemy3/enemy_3_run.png", 32, 32, 2);
    private int index, direction, runP;


    public Enemy3(int x, int y, int w, int h, int speed, int hp, int damage, int direction,int scoreP) {
        super(x, y, w, h, speed, hp, damage, scoreP);
        this.direction = direction;

    }

    @Override
    public Rectangle Colision() {
        return super.Colision();
    }

    public void animation() {
        index++;
        if (index == 2) {
            index = 0;
        }

    }

    @Override
    public void drawEnemy(Graphics g) {
        int img = 32*3;

        int drawX = getX();
        if (direction == -1) {
            runP = 200;
            drawX = getX() + (img - getW());
        }else{runP = 0;}

        Image frame = enemy_run[index];
        g.drawImage(frame, drawX+runP, getY(), img * direction, img, null);

        // хитбокс
        g.drawRect(getX(), getY(), img, img);

        super.drawEnemy(g);
    }
}