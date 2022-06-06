package game;

import map.GameMap;
import util.BuffPool;
import util.PoloPool;


import static util.Constant.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Player {
    public static final int DIR_UP=0;
    public static final int DIR_DOWN=1;
    public static final int DIR_LEFT=2;
    public static final int DIR_RIGHT=3;
    public static final int STATE_STAND=0;
    public static final int STATE_MOVE=1;
    public static final int STATE_DIE=2;


    public boolean defense=false;
    public int atk=1;
    private int x;
    private int y;
    private int hp=1;
    private int speed=5;
    Timer timer=new Timer();
    private int dir;
    public  int imageIndex=0;
    public boolean isCollide=false;
    public static Image[] playerDown={playerDown1,playerDown2,playerDown3,playerDown4};
    public static Image[] playerUp={playerUp1,playerUp2,playerUp3,playerUp4};
    public static Image[] playerLeft={playerLeft1,playerLeft2,playerLeft3,playerLeft4};
    public static Image[] playerRight={playerRight1,playerRight2,playerRight3,playerRight4};



    public  void setImageIndex() {
        imageIndex++;
        if(imageIndex>3)
            imageIndex=0;
    }


    private int state=STATE_STAND;

    //TODO
    public static List<Boom> polo=new ArrayList();
    public static List<Buff> buffs= Boom.buffs;
    public Player(int x,int y,int dir){
        this.dir=dir;
        this.y=y;
        this.x=x;

    }

    public void draw(Graphics g){
        try{
        moveWithBuff();
        logic();
        drawBuff(g);
        drawPlayer(g);
        drawPolo(g);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //timerIndex.schedule(setImageIndex(),100,100);
    }

    private void drawPlayer(Graphics g){
        switch (dir){
            case DIR_DOWN:
                g.drawImage(playerDown[imageIndex],x,y,null);
                break;
            case DIR_UP:
                g.drawImage(playerUp[imageIndex],x,y,null);
                break;
            case DIR_LEFT:
                g.drawImage(playerLeft[imageIndex],x,y,null);
                break;
            case DIR_RIGHT:
                g.drawImage(playerRight[imageIndex],x,y,null);
                break;
        }
    }
    private void logic(){
        switch (state){
            case STATE_STAND:
                break;
            case STATE_MOVE:
                move();
                break;
            case STATE_DIE:
                GameFrame.gameState=STATE_OVER;
                break;
        }
    }
    private void move(){
       //

        switch (dir){
            case DIR_UP:
                if(y%50==0&&GameMap.gameMapGetIndex((x-150)/50,(y-150)/50)!=0||y%50==0&&x%50!=0){
                    break;
                }
                y-=speed;
                if(y<150){
                    y=150;
                }
                break;
            case DIR_RIGHT:
                if(x%50==0&&GameMap.gameMapGetIndex((x-100)/50,(y-100)/50)!=0||x%50==0&&y%50!=0){
                    break;
                }
                x+=speed;
                if(x>1450)
                    x=1450;
                break;
            case DIR_DOWN:
                if(y%50==0&&GameMap.gameMapGetIndex((x-150)/50,(y-50)/50)!=0||y%50==0&&x%50!=0){
                    break;
                }
                y+=speed;
                if(y>900)
                    y=900;
                break;
            case DIR_LEFT:
                if(x%50==0&&GameMap.gameMapGetIndex((x-200)/50,(y-100)/50)!=0||x%50==0&&y%50!=0){
                    break;
                }
                x-=speed;
                if(x<200)
                    x=200;
                break;
        }
    //}
       // else
           // return;
    }

    //进行平滑处理
    public void dealXY(){
        int dealX=x/50;
        int dealY=y/50;
        switch (dir){
            case DIR_UP:
            case DIR_DOWN:
                if(y%50<=10)
                    y=dealY*50;
                if(y%50>40)
                    y=dealY*50+50;
                break;
            case DIR_RIGHT:
            case DIR_LEFT:
                if(x%50<=10)
                    x=dealX*50;
                if(x%50>40)
                    x=dealX*50+50;
                break;
        }
    }

    public void drawBuff(Graphics g){
        for(Buff buff:buffs){
            buff.draw(g);
        }
    }

    public void moveWithBuff(){
        for (int i=0;i<buffs.size();i++){
            Buff buff=buffs.get(i);
            if(x==buff.getX()&&y==buff.getY()){
                getBuff();
                buffs.remove(i);
                BuffPool.back(buff);
            }

        }
    }

    public void setDefense(boolean defense) {
        this.defense = defense;
    }

    private void getBuff() {
        switch (Buff.buffIndex){
            case 1:
                speed=speed+5;
                if(speed>10)
                    speed=10;
                break;
            case 2:
                atk=atk+1;
                if(atk>2)
                    atk=2;
                break;
            case 3:
                setDefense(true);
                break;
            case 4:
                boolean m=true;
                while (m==true){
                    if(PoloPool.x==2)
                        PoloPool.setDefaultPoolSize(3);
                    if(PoloPool.x==1)
                        PoloPool.setDefaultPoolSize(2);
                    m=false;
                }
                break;

        }
    }


    public boolean PoloAccessible() {
        boolean accessible=true;
        if(x%50!=0&&dir==DIR_UP)
            accessible=false;
        if(x%50!=0&&dir==DIR_DOWN)
            accessible=false;
        if(y%50!=0&&dir==DIR_LEFT)
            accessible=false;
        if(y%50!=0&&dir==DIR_RIGHT)
            accessible=false;
        return accessible;
    }


    public void setPolo(){
        if(PoloAccessible()){
        int poloX=x;
        int poloY=y;
        int mx,my;
        int nx,ny;
        int sx=x,sy=y;
        mx=x/50;
        my=y/50;
        nx=x%50;
        ny=y%50;
        if(nx>=25)
            sx=mx*50+50;
        if(nx<25)
            sx=mx*50;
        if(ny>=25)
            sy=my*50+50;
        if(ny<25)
            sy=my*50;
        switch (dir){
            case DIR_UP:
                poloY=sy-50;
                if(GameMap.gameMapGetIndex((x-150)/50,(poloY-100)/50)!=0)
                    poloY=sy;
                break;
            case DIR_DOWN:
                poloY=sy+50;
                if(GameMap.gameMapGetIndex((x-150)/50,(poloY-100)/50)!=0)
                    poloY=sy;
                break;
            case DIR_LEFT:
                poloX=sx-50;
                if(GameMap.gameMapGetIndex((poloX-150)/50,(y-100)/50)!=0)
                    poloX=sx;
                break;
            case DIR_RIGHT:
                poloX=sx+50;
                if(GameMap.gameMapGetIndex((poloX-150)/50,(y-100)/50)!=0)
                    poloX=sx;
                break;
        }
        Boom boom= PoloPool.get();
        boom.setX(poloX);
        boom.setY(poloY);
        boom.setDir(dir);
        boom.setAtk(atk);
        boom.setState(Boom.STATE_BEFORE_BOOM);
        polo.add(boom);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                boom.setState(Boom.STATE_BOOM);
                isCollide=GameFrame.isCollide(atk,boom.getX(),boom.getY(),x,y);

                if(isCollide==true&&defense==true){
                    setDefense(false);
                }
                else if(isCollide==true&&defense==false){
                    setState(STATE_DIE);
                }
            }
        }, 2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                boom.setState(Boom.STATE_AFTER_BOOM);
                isCollide=false;

            }
        }, 3000);

    }}
    private void drawPolo(Graphics g){
        for (Boom boom:polo){
            boom.draw(g);
        }
        for(int i=0;i<polo.size();i++){
            Boom boom=polo.get(i);
            if(boom.getState()==Boom.STATE_AFTER_BOOM) {
                polo.remove(i);
                PoloPool.back(boom);
            }
        }
    }
    public  void poloReturn(){
        for (Boom boom:polo){
            PoloPool.back(boom);
        }
        polo.clear();
    }
    public  void buffReturn(){
        for (Buff buff:buffs){
            BuffPool.back(buff);
        }
        buffs.clear();
    }


    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getState() {
        return state;
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
}

