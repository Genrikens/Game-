import java.awt.*;

public class Enemy2 extends EnemyS{
    private static final Image ememy2 = SpriteLoader.load("/enemy2/Enemy2.png");

    public Enemy2(int x, int y, int w, int h, int speed, int hp, int damage) {
        super(x, y, w, h, speed, hp, damage);

    }

    @Override
    public Rectangle Colision() {
        return super.Colision();
    }

    @Override
    public void drawEnemy(Graphics g) {
        g.drawImage(ememy2,getX(),getY(),16*3,32*3,null);
        super.drawEnemy(g);
    }
}
