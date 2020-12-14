package readFile;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class PlayWav {
    public static void playWav(String str) {
        AudioInputStream as;
        try {
            as = AudioSystem.getAudioInputStream(new File("F:\\mp3\\"+str));
            AudioFormat format = as.getFormat();
            SourceDataLine sdl = null;
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            sdl = (SourceDataLine) AudioSystem.getLine(info);
            sdl.open(format);
            sdl.start();
            int nBytesRead = 0;
            byte[] abData = new byte[1024];
            while (nBytesRead != -1) {
                nBytesRead = as.read(abData, 0, abData.length);
                if (nBytesRead >= 0)
                    sdl.write(abData, 0, nBytesRead);
            }
            //关闭SourceDataLine
            sdl.drain();
            sdl.close();
        }catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(str);
    }

}
