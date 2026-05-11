import java.awt.*;

public class EnemyS {
    boolean run = false, atack = false, block = false;
    private int x,y,w,h,speed,hp,damage;
    private int index = 0;
    private int index_count = 2;
    private int scoreE;
    private int coldawn=15;
    private int coldawnbAtack = 200;
    private int Cx,Cy,Cw,Ch;

    public EnemyS(int x, int y, int w, int h, int speed, int hp, int damage,int score) {
        this.x = x;
        this.y = y;
        this.w = w*3;
        this.h = h*3;
        this.speed = speed;
        this.hp = hp;
        this.damage = damage;
        this.scoreE = score;



    }


    public void Atack(Player player){
        if (isCalision(player)){
            System.out.println(coldawnbAtack);
            coldawnbAtack--;
            if(coldawnbAtack == 0 && isCalision(player)) {
                player.setHp(player.getHp() - damage);
                coldawnbAtack = 200;
            }
        }
    }





    public Rectangle atackArea(){
        return new Rectangle();
    }

    public Rectangle Colision(){return new Rectangle(x,y,w,h);}

    public void muw(Player player){
        if (player.getX()+60 > x) x += speed;
        if (player.getX()-60 < x) x -= speed;
    }




    public void drawEnemy(Graphics g) {

    }

    public boolean isCalEnemy(EnemyS enemyS){
        return enemyS.Colision().intersects(Colision());
    }

    public boolean isCalision(Player player) {
        return player.Calision().intersects(atackArea());
    }

    public void animation() {

        coldawn--;
        if (coldawn<=0) {
            index++;

            if (index == 2) {
                index = 0;
            }
            coldawn = 15;
        }
    }


    public int getScoreE() {
        return scoreE;
    }

    public void setScoreE(int scoreE) {
        this.scoreE = scoreE;
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

    public void setHp(int hp) {this.hp = hp;}

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setIndex_count(int index_count) {
        this.index_count = index_count;
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

    public int getIndex() {return index;}

    public int getIndex_count() {
        return index_count;
    }

}
