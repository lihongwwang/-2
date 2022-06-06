package Thread;

import game.GameFrame;
import static util.Constant.*;
public class ImageThread extends Thread{
    public  ImageThread(){}
    @Override
    public  void run(){
        while(GameFrame.gameState==STATE_RUN){
        GameFrame.myPlayer.setImageIndex();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
