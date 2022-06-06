package util;

import java.util.ArrayList;
import java.util.List;
import game.Boom;

public class PoloPool {
    public static int x=1;
    public static final int POOL_MAX_SIZE=5;
    private static List<Boom> pool=new ArrayList<>();

    static {
        for(int i=0;i<POOL_MAX_SIZE;i++){
            pool.add(new Boom());
        }
    }

    public static Boom get(){

        Boom boom=null;
        if(pool.size()==0) {
             return null;
        }
        else if(pool.size()>5-x)
            boom=pool.remove(0);

        return boom;
    }


    public static void back(Boom boom){

        if(pool.size()==POOL_MAX_SIZE){
            return;
        }
        pool.add(boom);
    }

    public static void setDefaultPoolSize(int size){
        x=size;
    }
}
