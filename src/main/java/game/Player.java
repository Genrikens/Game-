package game;

import java.awt.*;

public class Player {
    private int x,y,w,h,speed,hp;
    private static final Image SHIP = SpriteLoader.load("/player.png");
//[eq
    public Player(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w*3;
        this.h = h*3;
        this.speed = 30;
        this.hp = 3;
    }

    public void drawPlayer(Graphics g){
        g.drawImage(SHIP,x,y,w,h,null);

    }

    //_____GETRY_____

    public int getX() {return x;}

    public int getY() {return y;}

    public int getW() {return w;}

    public int getH() {return h;}

    public int getSpeed() {return speed;}

    public int getHp() {return hp;}

    //_____SETRY_____
    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}

    public void setW(int w) {this.w = w;}

    public void setH(int h) {this.h = h;}

    public void setSpeed(int speed) {this.speed = speed;}

    public void setHp(int hp) {this.hp = hp;}
}

