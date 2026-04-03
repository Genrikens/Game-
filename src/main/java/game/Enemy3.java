import java.awt.*;

public class Enemy3 extends EnemyS{
    private static final Image ememy3 = SpriteLoader.load("/enemy3/Enemy3.png");

    public Enemy3(int x, int y, int w, int h, int speed, int hp, int damage) {
        super(x, y, w, h, speed, hp, damage);

    }

    @Override
    public Rectangle Colision() {
        return super.Colision();
    }

    @Override
    public void drawEnemy(Graphics g) {
        g.drawImage(ememy3,getX(),getY(),16*3,32*3,null);
        super.drawEnemy(g);
    }
}
