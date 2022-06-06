package util;
import java.awt.*;

public class Constant {
    /*****************游戏窗口相关************************/
    public static final String GAME_TITLE="泡泡堂";

    public static final int FRAME_WIDTH=1600;
    public static final int FRAME_HEIGHT=1200;


    /*****************游戏菜单相关************************/
    public static final int STATE_MENU=0;
    public static final int STATE_HELP=1;
    public static final int STATE_ABOUT=2;
    public static final int STATE_RUN=3;
    public static final int STATE_OVER=4;
    public static final Image bg=Toolkit.getDefaultToolkit().getImage("img/bg.jpg");
    public static final Image button1=Toolkit.getDefaultToolkit().getImage("img/start.png");
    public static final Image button2=Toolkit.getDefaultToolkit().getImage("img/continue.png");
    public static final Image button3=Toolkit.getDefaultToolkit().getImage("img/help.png");
    public static final Image button4=Toolkit.getDefaultToolkit().getImage("img/about.png");
    public static final Image button5=Toolkit.getDefaultToolkit().getImage("img/over.png");
    public static final Image button6=Toolkit.getDefaultToolkit().getImage("img/back.png");

    public static final Image arrowhead=Toolkit.getDefaultToolkit().getImage("img/arrow.png");

    public static final int REPAINT_INTERVAL =25;

    /*****************游戏界面相关************************/
    public static final Image playerDown1=Toolkit.getDefaultToolkit().getImage("img/player1down1.png");
    public static final Image playerRight1=Toolkit.getDefaultToolkit().getImage("img/player1right1.png");
    public static final Image playerUp1=Toolkit.getDefaultToolkit().getImage("img/player1up1.png");
    public static final Image playerLeft1=Toolkit.getDefaultToolkit().getImage("img/player1left1.png");

    public static final Image playerDown2=Toolkit.getDefaultToolkit().getImage("img/player1down2.png");
    public static final Image playerRight2=Toolkit.getDefaultToolkit().getImage("img/player1Right2.png");
    public static final Image playerUp2=Toolkit.getDefaultToolkit().getImage("img/player1Up2.png");
    public static final Image playerLeft2=Toolkit.getDefaultToolkit().getImage("img/player1left2.png");

    public static final Image playerDown3=Toolkit.getDefaultToolkit().getImage("img/player1down3.png");
    public static final Image playerRight3=Toolkit.getDefaultToolkit().getImage("img/player1Right3.png");
    public static final Image playerUp3=Toolkit.getDefaultToolkit().getImage("img/player1Up3.png");
    public static final Image playerLeft3=Toolkit.getDefaultToolkit().getImage("img/player1left3.png");

    public static final Image playerDown4=Toolkit.getDefaultToolkit().getImage("img/player1down4.png");
    public static final Image playerRight4=Toolkit.getDefaultToolkit().getImage("img/player1Right4.png");
    public static final Image playerUp4=Toolkit.getDefaultToolkit().getImage("img/player1Up4.png");
    public static final Image playerLeft4=Toolkit.getDefaultToolkit().getImage("img/player1left4.png");


    public static final Image boom=Toolkit.getDefaultToolkit().getImage("img/boom.png");
    public static final Image boomCenter=Toolkit.getDefaultToolkit().getImage("img/center.png");
    public static final Image boomDown1=Toolkit.getDefaultToolkit().getImage("img/polodown1.png");
    public static final Image boomDown2=Toolkit.getDefaultToolkit().getImage("img/polodown2.png");
    public static final Image boomUp1=Toolkit.getDefaultToolkit().getImage("img/poloup1.png");
    public static final Image boomUp2=Toolkit.getDefaultToolkit().getImage("img/poloup2.png");
    public static final Image boomLeft1=Toolkit.getDefaultToolkit().getImage("img/pololeft1.png");
    public static final Image boomLeft2=Toolkit.getDefaultToolkit().getImage("img/pololeft2.png");
    public static final Image boomRight1=Toolkit.getDefaultToolkit().getImage("img/poloright1.png");
    public static final Image boomRight2=Toolkit.getDefaultToolkit().getImage("img/poloright2.png");



    /*****************游戏界面物块相关************************/

    public static final Image tile0=Toolkit.getDefaultToolkit().getImage("img/floor.png");
    public static final Image tile1=Toolkit.getDefaultToolkit().getImage("img/1.png");
    public static final Image tile2=Toolkit.getDefaultToolkit().getImage("img/2.png");
    public static final Image tile3=Toolkit.getDefaultToolkit().getImage("img/3.png");
    public static final Image tile4=Toolkit.getDefaultToolkit().getImage("img/4.png");
    public static final Image tile5=Toolkit.getDefaultToolkit().getImage("img/5.png");
    public static final Image tile6=Toolkit.getDefaultToolkit().getImage("img/6.png");

    public static final int [][] arr={
            {6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
            {6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,6},
            {6,0,4,0,4,0,4,0,4,0,4,0,4,0,4,0,5,6},
            {6,5,4,3,4,5,4,3,4,5,4,3,4,5,4,4,4,6},
            {6,0,0,2,0,0,0,0,0,0,0,0,0,0,0,2,5,6},
            {6,4,0,4,4,4,4,1,5,4,0,4,4,4,0,4,4,6},
            {6,0,0,0,0,5,4,0,4,4,0,4,0,0,0,0,0,6},
            {6,2,4,4,4,0,4,0,0,0,0,0,0,1,1,1,0,6},
            {6,5,0,0,4,0,4,0,4,4,0,4,0,0,0,0,0,6},
            {6,0,1,2,2,0,0,0,4,4,0,4,4,4,0,4,4,6},
            {6,0,1,1,0,0,4,0,0,1,1,1,1,1,0,1,1,6},
            {6,0,0,0,0,0,4,1,0,1,1,4,1,1,0,1,1,6},
            {6,0,1,1,4,0,0,0,0,0,1,1,1,0,0,0,0,6},
            {6,0,5,0,4,0,1,4,1,2,0,1,0,0,1,1,0,6},
            {6,1,1,0,4,0,4,1,4,1,0,0,0,1,1,0,0,6},
            {6,0,0,0,0,0,1,4,1,4,0,1,1,1,0,0,1,6},
            {6,5,1,0,1,0,1,2,0,5,0,2,0,0,0,1,1,6},
            {6,1,1,4,1,0,2,0,1,0,1,0,2,1,0,0,5,6},
            {6,0,0,0,1,2,0,1,1,0,1,1,0,2,1,1,0,6},
            {6,5,1,0,2,0,1,5,0,0,0,5,1,0,2,0,0,6},
            {6,1,1,2,0,1,1,0,1,0,1,0,1,1,0,2,1,6},
            {6,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6},
            {6,0,1,2,0,1,1,0,1,0,1,0,1,1,0,2,0,6},
            {6,0,1,1,2,0,1,5,0,0,0,5,1,0,2,1,0,6},
            {6,0,0,0,1,2,0,1,1,0,1,1,0,2,1,0,0,6},
            {6,0,1,0,1,1,2,0,1,0,1,0,2,1,0,1,0,6},
            {6,0,0,0,0,0,0,2,0,0,0,2,0,0,0,0,0,6},
            {6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6}
    };

    /*****************游戏界面道具相关************************/

    public static final Image powerBuff=Toolkit.getDefaultToolkit().getImage("img/powerBuff.png");
    public static final Image speedBuff=Toolkit.getDefaultToolkit().getImage("img/speedBuff.png");
    public static final Image defenseBuff=Toolkit.getDefaultToolkit().getImage("img/defenseBuff.png");
    public static final Image poloNumber=Toolkit.getDefaultToolkit().getImage("img/poloNumber.png");


    /*****************游戏界面相关************************/
    public static final Image gameOver=Toolkit.getDefaultToolkit().getImage("img/gameOver.png");
    public static final Image gameOverWin=Toolkit.getDefaultToolkit().getImage("img/gameOverWin.png");
    public static final Image gameOverLost=Toolkit.getDefaultToolkit().getImage("img/gameOverLost.png");
    public static final Image gameHelp=Toolkit.getDefaultToolkit().getImage("img/helpBackground.png");
    public static final Image gameAbout=Toolkit.getDefaultToolkit().getImage("img/aboutBackground.png");


    /*****************游戏NPC************************/
    public static final Image npc1Down=Toolkit.getDefaultToolkit().getImage("img/npc1down.png");
    public static final Image npc1Left=Toolkit.getDefaultToolkit().getImage("img/npc1left.png");
    public static final Image npc1Up=Toolkit.getDefaultToolkit().getImage("img/npc1up.png");
    public static final Image npc1Right=Toolkit.getDefaultToolkit().getImage("img/npc1right.png");
    public static final Image npc2Down=Toolkit.getDefaultToolkit().getImage("img/npc2down.png");
    public static final Image npc2Left=Toolkit.getDefaultToolkit().getImage("img/npc2left.png");
    public static final Image npc2Up=Toolkit.getDefaultToolkit().getImage("img/npc2up.png");
    public static final Image npc2Right=Toolkit.getDefaultToolkit().getImage("img/npc2right.png");

}
