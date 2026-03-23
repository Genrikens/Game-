package game;

import java.awt.Graphics;
import java.awt.Image;

public class Upground {
    private final int x,y,w,h;
    private static final Image upgroundPNG = SpriteLoader.load("/upground.png");


    public Upground(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }


    public void drawUpground(Graphics g){

        g.drawImage(upgroundPNG,x,y,w,h,null);
    }

}
