

import java.awt.Graphics;
import java.awt.Image;

public class Viewport {
    private final int x,y,w,h;
    private static final Image viewportPNG = SpriteLoader.load("game/viewport.png");


    public Viewport(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }


    public void drawUpground(Graphics g){

        g.drawImage(viewportPNG,x,y,w,h,null);
    }

}
