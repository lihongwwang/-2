package Thread;
import game.GameFrame;
import static util.Constant.*;


public class NPCThread extends Thread{
    public  NPCThread(){}
    @Override
    public  void run(){
        while(GameFrame.gameState==STATE_RUN){
            GameFrame.npc1Index=util.MyUtil.getRandomNumber(1,12);
            GameFrame.npc2Index=util.MyUtil.getRandomNumber(1,12);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
