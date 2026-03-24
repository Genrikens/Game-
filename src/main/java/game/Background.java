

import java.awt.Graphics;
import java.awt.Image;

public class Background {
    private final int x,y,w,h;
    private static final Image backgroundPNG = SpriteLoader.load("/background.png");


    public Background(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }


    public void drawBackground(Graphics g){

        g.drawImage(backgroundPNG,x,y,w,h,null);
    }

}
