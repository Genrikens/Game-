import java.awt.*;

public class EnemyS {
    boolean run = false, atack = false, block = false;
    private int x,y,w,h,speed,hp,damage;
    //private static final Image player = SpriteLoader.load("/player/player.png");
    //private static final Image[] player_idle = SpriteLoader.getFrames("/player/playerIdle.png",16,32,2);
    //private static final Image[] player_run = SpriteLoader.getFrames("/player/player_run.png",32,32,2);
    //private static final Image[] player_atack = SpriteLoader.getFrames("/player/player_atack.png",32,32,2);
    //private static final Image[] player_block = SpriteLoader.getFrames();
    private int index = 0;
    private int index_count = 2;
    private int animation_speed = 0;
    private int direction = 1;

    public EnemyS(int x, int y, int w, int h, int speed, int hp, int damage) {
        this.x = x;
        this.y = y;
        this.w = w*3;
        this.h = h*3;
        this.speed = speed;
        this.hp = hp;
        this.damage = damage;
    }

    public Rectangle Colision(){return new Rectangle(x,y,w,h);}

    public void muw(Player player){
        if (player.getX()+60 > x) x += speed;
        if (player.getX()-60 < x) x -= speed;
    }


    public void drawEnemy(Graphics g) {
        g.drawRect(getX(), getY(), getW(), getH());

    }

    public void atack(){

    }

    public void animation() {
        //animation_speed++;
        //if (animation_speed >= 3) {
        index++;
        if (index >= index_count) {
            index = 0;
        }
        animation_speed = 0;
        //}
    }



    public void setRun(boolean run) {
        this.run = run;
    }

    public void setAtack(boolean atack) {
        this.atack = atack;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setIndex_count(int index_count) {
        this.index_count = index_count;
    }

    public void setAnimation_speed(int animation_speed) {
        this.animation_speed = animation_speed;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isRun() {
        return run;
    }

    public boolean isAtack() {
        return atack;
    }

    public boolean isBlock() {
        return block;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }

    public int getIndex() {
        return index;
    }

    public int getIndex_count() {
        return index_count;
    }

    public int getAnimation_speed() {
        return animation_speed;
    }

    public int getDirection() {
        return direction;
    }
}
