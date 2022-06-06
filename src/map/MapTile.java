package map;

import java.awt.*;

import static util.Constant.*;

public class MapTile {
    public int x;
    public int y;
    public int index=0;
    public boolean sturdiness=true;

    private static final Image tileImg0=tile0;
    private static final Image tileImg1=tile1;
    private static final Image tileImg2=tile2;
    private static final Image tileImg3=tile3;
    private static final Image tileImg4=tile4;
    private static final Image tileImg5=tile5;
    private static final Image tileImg6=tile6;
    public int[][] ArrMap=arr;

    public  void changeArr(int i, int j, int index){
        ArrMap[i][j]=index;

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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean getSturdiness(){
        return sturdiness;
    }


    public void setSturdiness(boolean sturdiness) {
        this.sturdiness = sturdiness;
    }

    public MapTile(){}

    public MapTile(int x, int y,int index,boolean sturdiness){
        this.x=x;
        this.y=y;
        this.index=index;
        this.sturdiness=sturdiness;
    }



    public void draw(Graphics g){
         switch (index) {
             case 0:
                 g.drawImage(tileImg0, x, y, null);
                 break;
             case 1:
                 g.drawImage(tileImg1, x, y, null);
                 break;
             case 2:
                 g.drawImage(tileImg2, x, y, null);
                 break;
             case 3:
                 g.drawImage(tileImg3, x, y, null);
                 break;
             case 4:
                 g.drawImage(tileImg4, x, y, null);
                 break;
             case 5:
                 g.drawImage(tileImg5, x, y, null);
                 break;
             case 6:
                 g.drawImage(tileImg6, x, y, null);
                 break;
         }
    }
}
