package BGM;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class PlaySound {
    public PlaySound(){}
    public  void playBGM(){

        try {
            AudioInputStream  ais=AudioSystem.getAudioInputStream(this.getClass().getResourceAsStream("/music/bgm0.wav"));
            AudioFormat format=ais.getFormat();
            SourceDataLine sdl;
            DataLine.Info info=new DataLine.Info(SourceDataLine.class,format);
            sdl=(SourceDataLine) AudioSystem.getLine(info);
            sdl.open(format);
            sdl.start();

            int nBytesRead;
            byte[] Data=new byte[1024];
            while ((nBytesRead=ais.read(Data,0,Data.length))!=-1){
                sdl.write(Data,0,nBytesRead);
            }
            sdl.stop();
    } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

