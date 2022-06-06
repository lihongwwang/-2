package Thread;
import game.GameFrame;
import BGM.PlaySound;
import static util.Constant.*;
public class SoundThread implements Runnable{
    public SoundThread(){}
    public boolean flag=true;
    @Override
    public void run(){
        PlaySound playSound=new PlaySound();
        while(flag){
            playSound.playBGM();
        }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


    }
    public void stop(){
        this.flag=false;
    }
}
