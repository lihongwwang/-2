package game;
//import javafx.scene.input.KeyCode;

import map.GameMap;
import Thread.*;
import util.PoloPool;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static util.Constant.*;

public class GameFrame extends Frame implements Runnable{

    public static int gameState;

    private int menuIndex=0;
    private int overIndex=0;
    public static int npc1Index=0;
    public static int npc2Index=0;
    public static Player myPlayer;
    public static NPC npc1=new NPC();
    public static NPC npc2=new NPC();
    public static boolean WinOrNot=false;

    private BufferedImage bufImg= new BufferedImage(FRAME_WIDTH,FRAME_HEIGHT,BufferedImage.TYPE_4BYTE_ABGR);

    private GameMap gameMap= new GameMap();
    public GameFrame(){
        initGameState();
        initFrame();
        initEventListener();
        new Thread(this).start();

    }

    private void initFrame(){
        setTitle(GAME_TITLE);
        setVisible(true);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }


    private void initGameState(){
        gameState=STATE_MENU;
    }


    public void update(Graphics g1){
       // SoundThread soundThread=new SoundThread();
       // new Thread(soundThread).start();
       // if(gameState!=STATE_RUN)
         //   soundThread.stop();
        npc1.s=npc1Index;
        npc2.s=npc2Index;
        Graphics g=bufImg.getGraphics();
        switch (gameState){
            case STATE_MENU:
                drawMenu(g);
                break;
            case STATE_HELP:
                drawHelp(g);
                break;
            case STATE_ABOUT:
                drawAbout(g);
                break;
            case STATE_RUN:
                drawRun(g);
                break;
            case STATE_OVER:
                drawOver(g);
                break;
        }
        g1.drawImage(bufImg,0,0,null);
        if(npc1.state== npc1.STATE_DIE&&npc2.state==npc2.STATE_DIE) {
            gameState=STATE_OVER;
            WinOrNot=true;
        }
    }
    private void drawMenu(Graphics g){
        g.drawImage(bg,0,0,null);
        g.drawImage(button1,1200,400,null);

        g.drawImage(button3,1200,500,null);
        g.drawImage(button4,1200,600,null);
        g.drawImage(button5,1200,700,null);
        g.drawImage(arrowhead,1000,100*menuIndex+400,null);
    }

    private void drawAbout(Graphics g) {
        g.drawImage(gameAbout,0,0,null);
        g.drawImage(button6,1200,400,null);
        g.drawImage(arrowhead,1000,100*overIndex+400,null);

    }

    private void drawRun(Graphics g) {
        g.drawImage(bg,0,0,null);
        gameMap.draw(g);
        myPlayer.draw(g);
        npc1.draw(g);
        npc2.draw(g);

    }

    private void drawOver(Graphics g) {
        if(WinOrNot)
        g.drawImage(gameOverWin,0,0,null);
        else
            g.drawImage(gameOverLost,0,0,null);
        g.drawImage(button1,1200,400,null);
        g.drawImage(button3,1200,500,null);
        g.drawImage(button4,1200,600,null);
        g.drawImage(button5,1200,700,null);
        g.drawImage(arrowhead,1000,100*overIndex+400,null);

    }

    private void drawHelp(Graphics g) {
        g.drawImage(gameHelp,0,0,null);
        g.drawImage(button6,1200,400,null);
        g.drawImage(arrowhead,1000,100*overIndex+400,null);
    }


    private void initEventListener(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode=e.getKeyCode();
                switch (gameState){
                    case STATE_MENU:
                        keyPressedEventMenu(keyCode);
                        break;
                    case STATE_HELP:
                        keyPressedEventHelp(keyCode);
                        break;
                    case STATE_ABOUT:
                        keyPressedEventAbout(keyCode);
                        break;
                    case STATE_RUN:
                        keyPressedEventRun(keyCode);
                        break;
                    case STATE_OVER:
                        keyPressedEventOver(keyCode);
                        break;
                }
            }
            public void keyReleased(KeyEvent e){
                int keyCode=e.getKeyCode();
                if(gameState==STATE_RUN){
                    keyReleasedEventRun(keyCode);
                }
            }

            private void keyReleasedEventRun(int keyCode) {
                switch (keyCode){
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                    //case KeyEvent.VK_SPACE:


                        myPlayer.dealXY();
                        myPlayer.setState(Player.STATE_STAND);
                }
            }


            private void keyPressedEventOver(int keyCode) {
                switch (keyCode){
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                        overIndex--;
                        if(overIndex<0)
                            overIndex=3;

                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        overIndex++;
                        if(overIndex>3)
                            overIndex=0;
                        break;
                    case KeyEvent.VK_ENTER:
                        if(overIndex==0) {
                            gameState = STATE_RUN;
                            resetGame();
                            newGame();
                        }
                        else if(overIndex==1){
                            resetGame();
                            gameState=STATE_HELP;
                        }
                        else if(overIndex==2){
                            resetGame();
                            gameState=STATE_ABOUT;
                        }
                        else if(overIndex==3)
                            System.exit(0);

                        break;

            }}

            private void keyPressedEventRun(int keyCode) {
                myPlayer.setState(Player.STATE_MOVE);
                switch (keyCode){
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:

                        myPlayer.setDir(Player.DIR_UP);
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:

                        myPlayer.setDir(Player.DIR_LEFT);
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:

                        myPlayer.setDir(Player.DIR_DOWN);
                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:

                        myPlayer.setDir(Player.DIR_RIGHT);
                        break;
                    case KeyEvent.VK_SPACE:
                        myPlayer.setPolo();
                        break;

                }

            }

            private void keyPressedEventAbout(int keyCode) {

                switch (keyCode) {
                    case KeyEvent.VK_ENTER:
                        gameState = STATE_MENU;
                        break;
                }
            }

            private void keyPressedEventHelp(int keyCode) {
                switch (keyCode) {
                    case KeyEvent.VK_ENTER:
                            gameState = STATE_MENU;
                            break;
                }
                }

            private void keyPressedEventMenu(int keyCode) {
                switch (keyCode){
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                        menuIndex--;
                        if(menuIndex<0)
                            menuIndex=3;

                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        menuIndex++;
                        if(menuIndex>3)
                            menuIndex=0;
                        break;
                    case KeyEvent.VK_ENTER:
                        if(menuIndex==0){
                            newGame();
                        }
                        else if(menuIndex==1){
                            gameState=STATE_HELP;
                        }
                        else if(menuIndex==2){
                            gameState=STATE_ABOUT;
                        }
                        else if(menuIndex==3)
                            System.exit(0);
                        break;
                }
            }

            private void newGame() {
                gameState=STATE_RUN;
                myPlayer=new Player(200,150, Player.DIR_DOWN);
                ImageThread imageThread=new ImageThread();
                imageThread.start();

                NPCThread npcThread=new NPCThread();
                npcThread.start();
                npc1=new NPC(1200,150,NPC.DIR_UP,1);
                npc2=new NPC(1200,900,NPC.DIR_UP,2);

            }
        });
    }
    @Override
    public void run() {
        while(true){
            repaint();
            try {
                Thread.sleep(REPAINT_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //角色和物块与炸弹爆炸范围的检测
    public static  boolean isCollide(int atk,int poloX,int poloY,int playerX,int playerY)
    {
        boolean collide=true;
        switch(atk){
            case 1:
                if(playerX>(poloX-100)&&playerX<(poloX+100)&&playerY>(poloY-100)&&playerY<(poloY+100)) {
                    if (playerX >= (poloX + 50) && playerY >= (poloY + 50)) {
                        collide= false;
                    } else if (playerX >= (poloX + 50) && playerY <= (poloY - 50)) {
                        collide= false;
                    } else if (playerX <= (poloX - 50) && playerY >= (poloY + 50)) {
                        collide= false;
                    } else if (playerX <= (poloX - 50) && playerY <= (poloY - 50)) {
                        collide= false;
                    } else {
                        collide= true;
                    }
                }
                else {
                    collide= false;
                }
                break;

            case 2:
                if(playerX>(poloX-150)&&playerX<(poloX+150)&&playerY>(poloY-100)&&playerY<(poloY+100)) {
                    if (playerX >= (poloX + 50) && playerY >= (poloY + 50)) {
                        collide= false;
                    } else if (playerX >= (poloX + 50) && playerY <= (poloY - 50)) {
                        collide= false;
                    } else if (playerX <= (poloX - 50) && playerY >= (poloY + 50)) {
                        collide= false;
                    } else if (playerX <= (poloX - 50) && playerY <= (poloY - 50)) {
                        collide= false;
                    } else {
                        collide= true;
                    }

                }
                else {
                    collide= false;
                }
                break;

            case 3:
                if(playerX>(poloX-150)&&playerX<(poloX+150)&&playerY>(poloY-150)&&playerY<(poloY+150)) {
                    if (playerX >= (poloX + 50) && playerY >= (poloY + 50)) {
                        collide= false;
                    } else if (playerX >= (poloX + 50) && playerY <= (poloY - 50)) {
                        collide= false;
                    } else if (playerX <= (poloX - 50) && playerY >= (poloY + 50)) {
                        collide= false;
                    } else if (playerX <= (poloX - 50) && playerY <= (poloY - 50)) {
                        collide= false;
                    } else {
                        collide= true;
                    }
                }
                else {
                    collide= false;
                }
                break;

            default:
                collide= false;
                break;

        }
        return collide;
    }

    private void resetGame(){
        menuIndex=0;
        overIndex=0;
        PoloPool.x=1;
        GameMap.tiles=new ArrayList<>();
        gameMap= new GameMap();
        myPlayer.poloReturn();
        myPlayer.buffReturn();
        Player.buffs.clear();
        //myPlayer=null;
        WinOrNot=false;
    }
}

