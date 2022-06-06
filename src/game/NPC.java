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
import game.GameFrame;
public class NPC {
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
    public int s;
    private int dir;
    public  int imageIndex=0;
    public boolean isNPCCollide=false;
    public boolean isPlayerCollide=false;
    public int imgIndex;
    public static Image[] playerDown={playerDown1,playerDown2,playerDown3,playerDown4};
    public static Image[] playerUp={playerUp1,playerUp2,playerUp3,playerUp4};
    public static Image[] playerLeft={playerLeft1,playerLeft2,playerLeft3,playerLeft4};
    public static Image[] playerRight={playerRight1,playerRight2,playerRight3,playerRight4};

    public int state=STATE_STAND;
    Boom boom=new Boom() ;

    //TODO
    public NPC(int x,int y,int dir,int imgIndex){
        this.dir=dir;
        this.y=y;
        this.x=x;
        this.imgIndex=imgIndex;
    }
    public NPC(){}

    public void draw(Graphics g){
        ss();
        logic();
        if(state!=STATE_DIE)
        drawNPC(g);
        drawPolo(g);
    }


    public void ss ()
    {
        if(state!=STATE_DIE){
        //s=GameFrame.npcIndex;
            switch (s) {
                case 1:
                    state = STATE_STAND;
                    break;
                case 2:
                case 3:
                    state = STATE_MOVE;
                    dir = DIR_UP;
                    break;
                case 4:
                case 5:
                    state = STATE_MOVE;
                    dir = DIR_DOWN;
                    break;
                case 6:
                case 7:
                    state = STATE_MOVE;
                    dir = DIR_LEFT;
                    break;
                case 8:
                case 9:
                    state = STATE_MOVE;
                    dir = DIR_RIGHT;
                    break;
                case 10:
                case 11:
                    if(boom.atk==0)
                    setPolo();
                    break;
                default:
                    break;
            }}
    }



    private void drawNPC(Graphics g){
        if(imgIndex==1){

        switch (dir) {
            case DIR_DOWN:
                g.drawImage(npc1Down, x, y, null);
                break;
            case DIR_UP:
                g.drawImage(npc1Up, x, y, null);
                break;
            case DIR_LEFT:
                g.drawImage(npc1Left, x, y, null);
                break;
            case DIR_RIGHT:
                g.drawImage(npc1Right, x, y, null);
                break;

        }}
        if(imgIndex==2){
            switch (dir) {
                case DIR_DOWN:
                    g.drawImage(npc2Down, x, y, null);
                    break;
                case DIR_UP:
                    g.drawImage(npc2Up, x, y, null);
                    break;
                case DIR_LEFT:
                    g.drawImage(npc2Left, x, y, null);
                    break;
                case DIR_RIGHT:
                    g.drawImage(npc2Right, x, y, null);
                    break;

            }}
    }
    private void logic(){
        switch (state){
            case STATE_STAND:
                break;
            case STATE_MOVE:
                move();
                break;
            case STATE_DIE:
                break;
        }
    }
    private void move(){
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
            boom.setX(poloX);
            boom.setY(poloY);
            boom.setDir(dir);
            boom.setAtk(1);
            boom.setState(Boom.STATE_BEFORE_BOOM);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    boom.setState(Boom.STATE_BOOM);
                    for(Boom b:Player.polo){
                    isNPCCollide=GameFrame.isCollide(boom.atk,b.getX(),b.getY(),x,y);
                    if(isNPCCollide==true){
                        setState(STATE_DIE);
                    }}
                    isPlayerCollide=GameFrame.isCollide(atk,boom.getX(),boom.getY(),GameFrame.myPlayer.getX(),GameFrame.myPlayer.getY());
                    if(isPlayerCollide==true&&GameFrame.myPlayer.defense==true){
                        GameFrame.myPlayer.setDefense(false);
                    }
                    else if(isPlayerCollide==true&&GameFrame.myPlayer.defense==false){
                        GameFrame.myPlayer.setState(STATE_DIE);
                    }
                }
            }, 2000);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    boom.setState(Boom.STATE_AFTER_BOOM);
                    boom=new Boom();
                    isNPCCollide=false;

                }
            }, 3000);

        }}


    private void drawPolo(Graphics g){
        boom.draw(g);
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


