import java.awt.*;

public class Enemy1 extends EnemyS {
    private static final Image[] enemy_run = SpriteLoader.getFrames("/enemy1/enemy_1_run.png", 32, 32, 2);
    private int index, direction, runP;
    private int Cx,Cy,Cw,Ch;


    public Enemy1(int x, int y, int w, int h, int speed, int hp, int damage, int direction,int scoreP) {
        super(x, y, w, h, speed, hp, damage,scoreP);
        this.direction = direction;


    }

    @Override
    public Rectangle Colision() {
        return new Rectangle(getX()+16, getY()+32, getW()/2, getH()/2);

    }

    @Override
    public boolean isCalision(Player player) {
        return super.isCalision(player);
    }

    @Override
    public Rectangle atackArea() {
        return new Rectangle(getX()+8,getY()+70,90,10);
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
            runP = 90;
            drawX = getX() + (img - getW());
        }else{runP = 0;}

        Image frame = enemy_run[index];
        g.drawImage(frame, drawX+runP, getY(), img * direction, img, null);

        // хитбокс
        g.setColor(Color.green);
        g.drawRect(getX()+8,getY()+70,90,10);

        super.drawEnemy(g);
    }
}