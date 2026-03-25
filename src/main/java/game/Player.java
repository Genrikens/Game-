


import java.awt.*;


public class Player {
    boolean run = false, atack = false, block = false;
    private int x,y,w,h,speed,hp;
    private static final Image player = SpriteLoader.load("/player.png");
    private static final Image[] player_idle = SpriteLoader.getFrames("/playerIdle.png",16,32,2);
    private static final Image[] player_run = SpriteLoader.getFrames("/player_run.png",32,32,2);
    private static final Image[] player_atack = SpriteLoader.getFrames("/player_atack.png",32,32,2);
    private static final Image[] player_block = SpriteLoader.getFrames("/player_block.png",32,32,2);
    private int index = 0;
    private int index_count = 2;
    private int animation_speed = 0;
    private int direction = 1;

    public Player(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w*3;
        this.h = h*3;
        this.speed = 10;
        this.hp = 3;
    }



    public void drawPlayer(Graphics g){
        int drawW, drawH;

        if (block) {
            drawW = 32 * 3;
            drawH = 32 * 3;
        } else if (atack) {
            drawW = 32 * 3;
            drawH = 32 * 3;
        } else if (run) {
            drawW = 48 * 2;
            drawH = 32 * 3;
        } else {
            drawW = 16 * 3;
            drawH = 32 * 3;
        }


        if (direction == -1) {
            drawW = -drawW;
        }

        if (block) {
            g.drawImage(player_block[index], x, y, drawW, drawH, null);
        } else if (atack) {
            g.drawImage(player_atack[index], x, y, drawW, drawH, null);
        } else if (run) {
            g.drawImage(player_run[index], x, y, drawW, drawH, null);
        } else {
            g.drawImage(player_idle[index], x, y, drawW, drawH, null);
        }
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

