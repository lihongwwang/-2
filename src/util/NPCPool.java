package util;

import game.NPC;
import java.util.ArrayList;
import java.util.List;



public class NPCPool {
    public static  int DEFAULT_POOL_SIZE=3;
    private static List<NPC> pool=new ArrayList<>();

    static{
        for(int i=0;i<DEFAULT_POOL_SIZE;i++)
        {
            pool.add(new NPC());
        }
    }

    public static NPC get(){
        NPC npc=null;
        if(pool.size()==0)
        {
            return null;
        }
        else{
            npc=pool.remove(0);
        }
        return npc;
    }

    public static void back(NPC npc)
    {
        pool.add(npc);
    }
}

