package map;

import game.Boom;
import game.Buff;
import util.MapTilePool;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


import static util.Constant.*;

public class GameMap {
    public static List<MapTile> tiles=new ArrayList<>();


    public GameMap(){
        initMap();
    }

    private void initMap(){
        //TODO
        int i=0;
        int j=0;
        for(i=0;i<28;i++){
            for(j=0;j<18;j++){
                MapTile tile=MapTilePool.get();
                tile.setIndex(arr[i][j]);
                tile.setX(50*i+150);
                tile.setY(50*j+100);
                if(tile.getIndex()==6||tile.getIndex()==4){
                    tile.setSturdiness(true);
                }
                else tile.setSturdiness(false);
                tiles.add(tile);
            }
        }
    }
    public void draw(Graphics g){
        for(MapTile tile:tiles){
            tile.draw(g);
        }

    }
    public static void gameMapSetTileIndex(int i,int j,int index){
        tiles.get(i*18+j).setIndex(index);
    }
    public static int gameMapGetIndex(int i,int j){
        return tiles.get(i*18+j).getIndex();
    }

}
