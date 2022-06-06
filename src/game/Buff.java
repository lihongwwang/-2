package game;

import java.awt.*;

import static util.Constant.*;

public class Buff {
    public  static int buffIndex;
    public static int x;
    public static int y;
    public Buff(){}
    public Buff(int x,int y,int buffIndex){
        this.x=x;
        this.y=y;
        this.buffIndex=buffIndex;
    }
    public void draw(Graphics g){
        switch (buffIndex){
            case 1:
                g.drawImage(speedBuff,x,y,null);
                break;
            case 2:
                g.drawImage(powerBuff,x,y,null);
                break;
            case 3:
                g.drawImage(defenseBuff,x,y,null);
                break;
            case 4:
                g.drawImage(poloNumber,x,y,null);
                break;
            default:
                break;
        }
    }

    public int getBuffIndex() {
        return buffIndex;
    }

    public void setBuffIndex(int buffIndex) {
        this.buffIndex = buffIndex;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
