import java.awt.*;

public class Enemy1 extends EnemyS{
    private static final Image ememy1 = SpriteLoader.load("/enemy1/Enemy1.png");

    public Enemy1(int x, int y, int w, int h, int speed, int hp, int damage) {
        super(x, y, w, h, speed, hp, damage);

    }

    @Override
    public Rectangle Colision() {
        return super.Colision();
    }

    @Override
    public void drawEnemy(Graphics g) {
        g.drawImage(ememy1,getX(),getY(),16*3,32*3,null);
        super.drawEnemy(g);
    }
}
