


import java.awt.*;



public class Player {
    boolean run = false, atack = false, block = false;
    private int x,y,w,h,speed,hp;
    private static final Image[] player_idle = SpriteLoader.getFrames("/player/player_idle.png",32,32,2);
    private static final Image[] player_run = SpriteLoader.getFrames("/player/player_run.png",32,32,2);
    private static final Image[] player_atack = SpriteLoader.getFrames("/player/player_atack.png",32,32,2);
    private static final Image[] player_block = SpriteLoader.getFrames("/player/player_block.png",32,32,2);
    private int index = 0;
    private int index_count = 2;
    private int animation_speed = 0;
    private int direction = 1;
    int AtackP;


    public Player(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w*3;
        this.h = h*3;
        this.speed = 10;
        this.hp = 3;
    }




    public void drawPlayer(Graphics g){

        int imgW = 32 * 3;
        int drawX = x;
        if (direction == -1) {
            AtackP = 50;
            drawX = x + (imgW - w);
        }else {AtackP = 0;}

        Image frame;
        if (block) frame = player_block[index];
        else if (atack) frame = player_atack[index];
        else if (run) frame = player_run[index];
        else frame = player_idle[index];

        g.drawImage(frame, drawX, y, imgW * direction, 32*3, null);
        g.drawRect(x,y,w,h);
        g.drawRect(x-AtackP,y,100,100);


    }

    public boolean isCalision(EnemyS enemyS) {
        return enemyS.Colision().intersects(atackArea());
    }
    public Rectangle Calision(){
        return new Rectangle(x,y,w,h);
    }
    public Rectangle atackArea(){return new Rectangle(getX()-AtackP,getY(),100,100);}




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


    //_____GETRY_____

    public int getX() {return x;}

    public int getY() {return y;}

    public int getW() {return w;}

    public int getH() {return h;}

    public int getSpeed() {return speed;}

    public int getHp() {return hp;}

    public int getIndex() {return index;}

    public int getIndex_count() {return index_count;}

    public int getAnimation_speed() {return animation_speed;}

    //_____SETRY_____


    public void setDirection(int direction) {this.direction = direction;}

    public void setIndex(int index) {this.index = index;}

    public void setIndex_count(int index_count) {this.index_count = index_count;}

    public void setAnimation_speed(int animation_speed) {this.animation_speed = animation_speed;}

    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}

    public void setW(int w) {this.w = w;}

    public void setH(int h) {this.h = h;}

    public void setSpeed(int speed) {this.speed = speed;}

    public void setHp(int hp) {this.hp = hp;}


}

