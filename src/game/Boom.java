package game;


import map.GameMap;
import map.MapTile;
import util.BuffPool;
import util.MyUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;


import static util.Constant.*;
public class Boom {
    public static final int STATE_BEFORE_BOOM=0;
    public static final int STATE_BOOM=1;
    public static final int STATE_AFTER_BOOM=2;


    private int x,y;
    public  int atk;
    private int dir;
    private int state=STATE_BEFORE_BOOM;
    Timer timer=new Timer();
    public static List<Buff> buffs=new ArrayList<>();
    public Boom(int x, int y, int dir,int atk)
    {
        this.x=x;
        this.y=y;
        this.dir=dir;
        this.atk=atk;

    }
    //给对象池使用
    public Boom(){
        this.atk=0;

    }

    public void setState(int state) {
        this.state = state;
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

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getDir()
    {
        return dir;
    }

    public int getState() {
        return state;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public void draw(Graphics g){

        switch (state) {
            case STATE_BEFORE_BOOM:
                g.drawImage(boom, x, y, null);
                break;
            case STATE_BOOM:
                poloBoom(g);
                boomWithMap();
                break;
            case STATE_AFTER_BOOM:

                break;
        }

    }

    public void boomWithMap() {
        boolean isCollide = false;
        int j = -atk;
        int i = -atk;
        for (i = -atk; i <= atk; i++) {
            for (j = -atk; j <= atk; j++) {
                isCollide = GameFrame.isCollide(atk, x, y, i * 50 + x, j * 50 + y);
                if ((isCollide && GameMap.gameMapGetIndex((i * 50 + x - 150) / 50, (j * 50 + y - 100) / 50) != 4
                        && GameMap.gameMapGetIndex((i * 50 + x - 150) / 50, (j * 50 + y - 100) / 50) != 6
                        && GameMap.gameMapGetIndex((i * 50 + x - 150) / 50, (j * 50 + y - 100) / 50) != 1)) {
                    if(GameMap.gameMapGetIndex((i * 50 + x - 150) / 50, (j * 50 + y - 100) / 50)==5){
                        Buff buff= BuffPool.get();
                        buff.setX(i*50+x);
                        buff.setY(j*50+y);
                        buff.setBuffIndex(MyUtil.getRandomNumber(1,5));
                        buffs.add(buff);
                    }
                    GameMap.gameMapSetTileIndex((i * 50 + x - 150) / 50, (j * 50 + y - 100) / 50, 0);
                }
            }
        }
    }






        private void poloBoom(Graphics g) {
            // Timer t=new Timer();
            // t.schedule(new )
            switch(atk) {
                case 1:
                    g.drawImage(boomCenter,x,y,null);

                    g.drawImage(boomDown2,x,(y+50),null);

                    g.drawImage(boomLeft2,(x-50),y,null);

                    g.drawImage(boomRight2,(x+50),y,null);

                    g.drawImage(boomUp2,x,(y-50),null);

                    break;

                case 2:
                    g.drawImage(boomCenter,x,y,null);

                    g.drawImage(boomUp1,x,(y-50),null);
                    g.drawImage(boomUp2,x,(y-100),null);

                    g.drawImage(boomDown1,x,(y+50),null);
                    g.drawImage(boomDown2,x,(y+100),null);

                    g.drawImage(boomLeft1,(x-50),y,null);
                    g.drawImage(boomLeft2,(x-100),y,null);

                    g.drawImage(boomRight1,(x+50),y,null);
                    g.drawImage(boomRight2,(x+100),y,null);

                    break;
                case 3:
                    g.drawImage(boomCenter, x, y, null);

                    g.drawImage(boomDown1, x, (y + 50), null);
                    g.drawImage(boomDown1, x, (y + 100), null);
                    g.drawImage(boomDown2, x, (y + 150), null);

                    g.drawImage(boomLeft1, (x - 50), y, null);
                    g.drawImage(boomLeft1, (x - 100), y, null);
                    g.drawImage(boomLeft2, (x - 150), y, null);

                    g.drawImage(boomRight1, (x + 50), y, null);
                    g.drawImage(boomRight1, (x + 100), y, null);
                    g.drawImage(boomRight2, (x + 150), y, null);

                    g.drawImage(boomUp1, x, (y - 50), null);
                    g.drawImage(boomUp1, x, (y - 100), null);
                    g.drawImage(boomUp2, x, (y - 150), null);

                    break;
            }

    }
}
