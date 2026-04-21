import java.awt.*;

public class Enemy2 extends EnemyS {
    private static final Image[] enemy_run = SpriteLoader.getFrames("/enemy2/enemy_2_run.png", 64, 32, 2);
    private int index, direction;


    public Enemy2(int x, int y, int w, int h, int speed, int hp, int damage, int direction,int scoreP) {
        super(x, y, w, h, speed, hp, damage,scoreP);
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
        int img = 64*3;

        int drawX = getX();
        if (direction == -1) {
            drawX = getX() + (img - getW());
        }

        Image frame = enemy_run[index];
        g.drawImage(frame, drawX, getY(), 64*3 * direction, 32*3, null);

        // хитбокс
        g.drawRect(getX(), getY(), 32*3, 32*3);

        super.drawEnemy(g);
    }
}