package util;

import java.util.ArrayList;
import java.util.List;
import game.Boom;
import game.Buff;

public class BuffPool {
    public static  int DEFAULT_POOL_SIZE=20;

    private static List<Buff> pool=new ArrayList<>();

    static {
        for(int i=0;i<DEFAULT_POOL_SIZE;i++){
            pool.add(new Buff());
        }
    }

    public static Buff get(){

        Buff buff=null;
        if(pool.size()==0) {
            return null;
        }
        else
            buff=pool.remove(0);
        return buff;
    }
    public static void back(Buff buff){
        pool.add(buff);
    }
}
