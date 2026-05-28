import java.awt.*;

public class Energitik {
    private static final Image energitik_anim = SpriteLoader.load("energitik.png");

    private int x,y,w,h;

    public Energitik(int x,int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w*3;
        this.h = h*3;

    }





    public Rectangle Calision(){
        return new Rectangle(x,y,w,h);
    }


    public void drawEnergitik(Graphics g) {
        g.drawImage(energitik_anim,x,y,w,h,null );
    }


}
